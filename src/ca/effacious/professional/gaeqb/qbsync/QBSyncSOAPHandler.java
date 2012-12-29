package ca.effacious.professional.gaeqb.qbsync;

import java.util.Iterator;

import javax.xml.bind.JAXB;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SAAJResult;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.dom.DOMSource;

import com.intuit.developer.jaxws.Authenticate;
import com.intuit.developer.jaxws.ClientVersion;
import com.intuit.developer.jaxws.CloseConnection;
import com.intuit.developer.jaxws.ConnectionError;
import com.intuit.developer.jaxws.GetLastError;
import com.intuit.developer.jaxws.ReceiveResponseXML;
import com.intuit.developer.jaxws.SendRequestXML;
import com.intuit.developer.jaxws.ServerVersion;

public class QBSyncSOAPHandler {

	private static final String NAMESPACE_URI = "http://developer.intuit.com/";
	private static final QName QNAME_clientVersion = new QName(NAMESPACE_URI,
	"clientVersion");
	private static final QName QNAME_serverVersion = new QName(NAMESPACE_URI,
	"serverVersion");
	private static final QName QNAME_authenticate2 = new QName(NAMESPACE_URI,
			"authenticate2");
	private static final QName QNAME_authenticate = new QName(NAMESPACE_URI,
			"authenticate");
	private static final QName QNAME_sendRequestXML = new QName(NAMESPACE_URI,
			"sendRequestXML");
	private static final QName QNAME_receiveResponseXML = new QName(
			NAMESPACE_URI, "receiveResponseXML");
	private static final QName QNAME_connectionError = new QName(NAMESPACE_URI,
			"connectionError");
	private static final QName QNAME_getLastError = new QName(NAMESPACE_URI,
			"getLastError");
	private static final QName QNAME_closeConnection = new QName(NAMESPACE_URI,
			"closeConnection");

	private MessageFactory messageFactory;
	private QBSyncSOAPAdapter qBSyncSOAPAdapter;

	public QBSyncSOAPHandler() throws SOAPException {
		messageFactory = MessageFactory.newInstance();
		qBSyncSOAPAdapter = new QBSyncSOAPAdapter();
	}

	public SOAPMessage handleSOAPRequest(SOAPMessage request)
			throws SOAPException {
		SOAPBody soapBody = request.getSOAPBody();
		Iterator iterator = soapBody.getChildElements();
		Object responsePojo = null;
		while (iterator.hasNext()) {
			Object next = iterator.next();
			if (next instanceof SOAPElement) {
				SOAPElement soapElement = (SOAPElement) next;
				QName qname = soapElement.getElementQName();
				if (QNAME_authenticate.equals(qname)) {
					responsePojo = handle_authenticate(soapElement);
					break;
				} else if (QNAME_sendRequestXML.equals(qname)) {
					responsePojo = handle_sendRequestXML(soapElement);
					break;
				} else if (QNAME_receiveResponseXML.equals(qname)) {
					responsePojo = handle_receiveResponseXML(soapElement);
					break;
				} else if (QNAME_connectionError.equals(qname)) {
					responsePojo = handle_connectionError(soapElement);
					break;
				} else if (QNAME_getLastError.equals(qname)) {
					responsePojo = handle_getLastError(soapElement);
					break;
				} else if (QNAME_closeConnection.equals(qname)) {
					responsePojo = handle_closeConnection(soapElement);
					break;
				} else if (QNAME_clientVersion.equals(qname)) {
					responsePojo = handle_clientVersion(soapElement);
					break;
				} else if (QNAME_serverVersion.equals(qname)) {
					responsePojo = handle_serverVersion(soapElement);
					break;
				}
			}
		}

		SOAPMessage soapResponse = messageFactory.createMessage();
		soapBody = soapResponse.getSOAPBody();
		if (responsePojo != null) {
			JAXB.marshal(responsePojo, new SAAJResult(soapBody));
		} else {
			SOAPFault fault = soapBody.addFault();
			fault.setFaultString("Unrecognized SOAP request.");
		}
		return soapResponse;
	}

	
	
	
	private Object handle_clientVersion(SOAPElement soapElement) {
		ClientVersion request = JAXB.unmarshal(new DOMSource(soapElement),
				ClientVersion.class);
		return qBSyncSOAPAdapter.clientVersion(request);
	}

	private Object handle_serverVersion(SOAPElement soapElement) {
		ServerVersion request = JAXB.unmarshal(new DOMSource(soapElement),
				ServerVersion.class);
		return qBSyncSOAPAdapter.serverVersion(request);
	}
	
	
	private Object handle_authenticate(SOAPElement soapElement) {
		Authenticate request = JAXB.unmarshal(new DOMSource(soapElement),
				Authenticate.class);
		return qBSyncSOAPAdapter.authenticate(request);
	}

	private Object handle_sendRequestXML(SOAPElement soapElement) {
		SendRequestXML request = JAXB.unmarshal(new DOMSource(soapElement),
				SendRequestXML.class);
		return qBSyncSOAPAdapter.sendRequestXML(request);
	}

	private Object handle_receiveResponseXML(SOAPElement soapElement) {
		ReceiveResponseXML request = JAXB.unmarshal(new DOMSource(soapElement),
				ReceiveResponseXML.class);
		return qBSyncSOAPAdapter.receiveResponseXML(request);
	}

	private Object handle_connectionError(SOAPElement soapElement) {
		ConnectionError request = JAXB.unmarshal(new DOMSource(soapElement),
				ConnectionError.class);
		return qBSyncSOAPAdapter.connectionError(request);
	}

	private Object handle_getLastError(SOAPElement soapElement) {
		GetLastError request = JAXB.unmarshal(new DOMSource(soapElement),
				GetLastError.class);
		return qBSyncSOAPAdapter.getLastError(request);
	}

	private Object handle_closeConnection(SOAPElement soapElement) {
		CloseConnection request = JAXB.unmarshal(new DOMSource(soapElement),
				CloseConnection.class);
		return qBSyncSOAPAdapter.closeConnection(request);
	}

}