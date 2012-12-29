package ca.effacious.professional.gaeqb.qbsync;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.apache.commons.io.IOUtils;

@SuppressWarnings("serial")
public class QBSyncServlet extends HttpServlet {
	static Logger log = Logger.getLogger(QBSyncServlet.class.getName());
	static MessageFactory messageFactory;
	static QBSyncSOAPHandler soapHandler;

	static {
		System.setProperty("javax.xml.transform.TransformerFactory",  "com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl");
		try {
			messageFactory = MessageFactory.newInstance();
			soapHandler = new QBSyncSOAPHandler();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		try {
			boolean logResponse = false;
			
			// Get all the headers from the HTTP request
			MimeHeaders headers = getHeaders(req);

			// Construct a SOAPMessage from the XML in the request body
			InputStream is = req.getInputStream();
			
			if(1==1) {
				StringWriter writer = new StringWriter();
				IOUtils.copy(is, writer);
				String requestString = writer.toString();
				
				if(
					(requestString.contains("sendRequestXML") == false)
					&& (requestString.contains("receiveResponseXML") == false)
					)
					log.info("Request : " + requestString);
				
				if(requestString.contains("<authenticate"))
					logResponse = true;
				
				is = new ByteArrayInputStream(requestString.getBytes());
			}
			
			SOAPMessage soapRequest = messageFactory.createMessage(headers, is);

			// Handle soapReqest
			SOAPMessage soapResponse = soapHandler
					.handleSOAPRequest(soapRequest);

			// Write to HttpServeltResponse
			resp.setStatus(HttpServletResponse.SC_OK);
			resp.setContentType("text/xml;charset=\"utf-8\"");
			OutputStream os = resp.getOutputStream();
			soapResponse.writeTo(os);
			os.flush();
			
			
			if(logResponse) {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				soapResponse.writeTo(baos);
				String soapResponseStr = new String(baos.toByteArray(),"UTF-8");
				log.info("Response : " + soapResponseStr);
			}
			
		} catch (SOAPException e) {
			throw new IOException("Exception while creating SOAP message.", e);
		}
	}

	@SuppressWarnings("unchecked")
	static MimeHeaders getHeaders(HttpServletRequest req) {
		Enumeration headerNames = req.getHeaderNames();
		MimeHeaders headers = new MimeHeaders();
		while (headerNames.hasMoreElements()) {
			String headerName = (String) headerNames.nextElement();
			String headerValue = req.getHeader(headerName);
			StringTokenizer values = new StringTokenizer(headerValue, ",");
			while (values.hasMoreTokens()) {
				headers.addHeader(headerName, values.nextToken().trim());
			}
		}
		return headers;
	}
}