package com.intuit.developer;

import java.util.UUID;
import java.util.logging.Logger;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import ca.effacious.professional.gaeqb.service.ItemSyncStore;

/**
 * Implements the service contracts as defined by quick book's web connector
 * (QBWC) WSDL :
 * 
 * http://developer.intuit.com/uploadedFiles/Support/QBWebConnectorSvc.wsdl
 * 
 * This code forwards a request of getting all the items detail information from
 * Quick book.
 * 
 * NOTE: This is a POC code, hence does not follow strict conventions. Code has
 * been developed just so it can work and prove the solution.
 * 
 */
@WebService
public class QBSyncService {
	static Logger log = Logger.getLogger(QBSyncService.class.getName());

	@WebMethod
	@WebResult(name = "authenticateResult", targetNamespace = "http://developer.intuit.com/")
	public com.intuit.developer.ArrayOfString authenticate(
			@WebParam(name = "strUserName", targetNamespace = "http://developer.intuit.com/") java.lang.String strUserName,
			@WebParam(name = "strPassword", targetNamespace = "http://developer.intuit.com/") java.lang.String strPassword) {
		boolean invalidUser = false;

		/*
		 * This method should ideally look at a datastore and do robust
		 * user/password validations. But for this poc, it just does a string
		 * compare and authenticates the user as valid.
		 * 
		 * For details about this method please refer to quicbook SDK.
		 */

		log.info("Authenticating user : " + strUserName + " ...");

		if (("test".equalsIgnoreCase(strUserName) && "test"
				.equalsIgnoreCase(strPassword)) == false) {
			log.warning("Invalid user : " + strUserName);
			invalidUser = true;
		} else {
			log.fine("User [" + strUserName + "] is valid.");
		}

		String[] asRtn = new String[2];
		asRtn[0] = "{" + UUID.randomUUID().toString() + "}";
		asRtn[1] = "";

		/*
		 * Ideally at this point, the implement should look at some task queues
		 * are find if there are any request to be done, it will ideally set the
		 * asRtn[1] parameter to NONE (for no work is needed).
		 */
		if (invalidUser) {
			asRtn[1] = "nvu";
		}

		ArrayOfString asRtn2 = new ArrayOfString(asRtn);
		return asRtn2;
	}

	@WebMethod
	@WebResult(name = "sendRequestXMLResult", targetNamespace = "http://developer.intuit.com/")
	public java.lang.String sendRequestXML(
			@WebParam(name = "ticket", targetNamespace = "http://developer.intuit.com/") java.lang.String ticket,
			@WebParam(name = "strHCPResponse", targetNamespace = "http://developer.intuit.com/") java.lang.String strHCPResponse,
			@WebParam(name = "strCompanyFileName", targetNamespace = "http://developer.intuit.com/") java.lang.String strCompanyFileName,
			@WebParam(name = "qbXMLCountry", targetNamespace = "http://developer.intuit.com/") java.lang.String qbXMLCountry,
			@WebParam(name = "qbXMLMajorVers", targetNamespace = "http://developer.intuit.com/") int qbXMLMajorVers,
			@WebParam(name = "qbXMLMinorVers", targetNamespace = "http://developer.intuit.com/") int qbXMLMinorVers) {

		/*
		 * Ideally at this point, the implement should look at some task queues
		 * generate requests based of them. For this POC; this just forwards a
		 * request to get all the item details.
		 * 
		 * The code also does not iterate further if there are more than 50
		 * items.
		 */

		String requestXML = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
				+ "<?qbxml version=\"7.0\"?>"
				+ "<QBXML>"
				+ "	<QBXMLMsgsRq onError=\"stopOnError\">"
				+ "	 <ItemInventoryQueryRq requestID=\"1234\" metaData=\"NoMetaData\" iterator=\"Start\">"
				+ "	  <MaxReturned>50</MaxReturned>"
				+ "	 </ItemInventoryQueryRq>" + "	</QBXMLMsgsRq>" + "</QBXML>";

		return requestXML;
	}

	@WebMethod
	@WebResult(name = "receiveResponseXMLResult", targetNamespace = "http://developer.intuit.com/")
	public int receiveResponseXML(
			@WebParam(name = "ticket", targetNamespace = "http://developer.intuit.com/") java.lang.String ticket,
			@WebParam(name = "response", targetNamespace = "http://developer.intuit.com/") java.lang.String response,
			@WebParam(name = "hresult", targetNamespace = "http://developer.intuit.com/") java.lang.String hresult,
			@WebParam(name = "message", targetNamespace = "http://developer.intuit.com/") java.lang.String message) {

		/*
		 * If the response has further iterations, the implementation should be
		 * enhanced for this.
		 */

		log.info("hresult : " + hresult);
		log.info("message : " + message);
		log.fine("Query response : " + response);

		response = "" + response;
		if (response.trim().length() <= 0)
			return 100;

		ItemSyncStore store = new ItemSyncStore();
		store.parseItemListQueryResponse(ticket, response, hresult, message);
		store.storeItems();

		return 100;
	}

	@WebMethod
	@WebResult(name = "connectionErrorResult", targetNamespace = "http://developer.intuit.com/")
	public java.lang.String connectionError(
			@WebParam(name = "ticket", targetNamespace = "http://developer.intuit.com/") java.lang.String ticket,
			@WebParam(name = "hresult", targetNamespace = "http://developer.intuit.com/") java.lang.String hresult,
			@WebParam(name = "message", targetNamespace = "http://developer.intuit.com/") java.lang.String message) {

		log.info("connectionError : " + ticket + " \n" + message);
		return null;
	}

	@WebMethod
	@WebResult(name = "getLastErrorResult", targetNamespace = "http://developer.intuit.com/")
	public java.lang.String getLastError(@WebParam(name = "ticket", targetNamespace = "http://developer.intuit.com/") java.lang.String ticket) {
		return null;
	}

	@WebMethod
	@WebResult(name = "closeConnectionResult", targetNamespace = "http://developer.intuit.com/")
	public java.lang.String closeConnection(@WebParam(name = "ticket", targetNamespace = "http://developer.intuit.com/") java.lang.String ticket) {
		log.info("Closing connection for session : " + ticket);
		return ("close with this message");
	}

	@WebMethod
	@WebResult(name = "clientVersionResult", targetNamespace = "http://developer.intuit.com/")
	public String clientVersion(@WebParam(name = "strVersion", targetNamespace = "http://developer.intuit.com/") java.lang.String strVersion) {
		log.info("Client version : " + strVersion);
		return "";
	}

	@WebMethod
	@WebResult(name = "serverVersionResult", targetNamespace = "http://developer.intuit.com/")
	public java.lang.String serverVersion(@WebParam(name = "strVersion", targetNamespace = "http://developer.intuit.com/") java.lang.String strVersion) {
		log.info("Server version : " + strVersion);
		return "";
	}

}
