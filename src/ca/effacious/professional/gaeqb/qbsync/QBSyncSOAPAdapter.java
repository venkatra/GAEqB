package ca.effacious.professional.gaeqb.qbsync;

import com.intuit.developer.ArrayOfString;
import com.intuit.developer.QBSyncService;
import com.intuit.developer.jaxws.Authenticate;
import com.intuit.developer.jaxws.AuthenticateResponse;
import com.intuit.developer.jaxws.ClientVersion;
import com.intuit.developer.jaxws.ClientVersionResponse;
import com.intuit.developer.jaxws.CloseConnection;
import com.intuit.developer.jaxws.CloseConnectionResponse;
import com.intuit.developer.jaxws.ConnectionError;
import com.intuit.developer.jaxws.ConnectionErrorResponse;
import com.intuit.developer.jaxws.GetLastError;
import com.intuit.developer.jaxws.GetLastErrorResponse;
import com.intuit.developer.jaxws.ReceiveResponseXML;
import com.intuit.developer.jaxws.ReceiveResponseXMLResponse;
import com.intuit.developer.jaxws.SendRequestXML;
import com.intuit.developer.jaxws.SendRequestXMLResponse;
import com.intuit.developer.jaxws.ServerVersion;
import com.intuit.developer.jaxws.ServerVersionResponse;

public class QBSyncSOAPAdapter {

	private QBSyncService qbService = new QBSyncService();

	public ClientVersionResponse clientVersion(ClientVersion request) {
		String response = qbService.clientVersion(request.getStrVersion());

		ClientVersionResponse adapterResponse = new ClientVersionResponse();
		adapterResponse.setClientVersionResult(response);

		return adapterResponse;
	}

	public ServerVersionResponse serverVersion(ServerVersion request) {
		String response = qbService.serverVersion(request.getStrVersion());

		ServerVersionResponse adapterResponse = new ServerVersionResponse();
		adapterResponse.setServerVersionResult(response);

		return adapterResponse;
	}

	public AuthenticateResponse authenticate(Authenticate request) {
		ArrayOfString response = qbService.authenticate(request.getStrUserName(),
				request.getStrPassword());

		AuthenticateResponse adapterResponse = new AuthenticateResponse();
		adapterResponse.setAuthenticateResult(response);

		return adapterResponse;
	}

	public SendRequestXMLResponse sendRequestXML(SendRequestXML request) {
		String response = qbService.sendRequestXML(request.getTicket(),
				request.getStrHCPResponse(), request.getStrCompanyFileName(), request.getQbXMLCountry(),
				request.getQbXMLMajorVers(), request.getQbXMLMinorVers());

		SendRequestXMLResponse adapterResponse = new SendRequestXMLResponse();
		adapterResponse.setSendRequestXMLResult(response);

		return adapterResponse;
	}

	public ReceiveResponseXMLResponse receiveResponseXML(
			ReceiveResponseXML request) {

		int response = qbService.receiveResponseXML(request.getTicket(),
				request.getResponse(), request.getHresult(), request.getMessage());

		ReceiveResponseXMLResponse adapterResponse = new ReceiveResponseXMLResponse();
		adapterResponse.setReceiveResponseXMLResult(response);

		return adapterResponse;
	}

	public ConnectionErrorResponse connectionError(ConnectionError request) {
		String response = qbService.connectionError(request.getTicket(),
				request.getHresult(), request.getMessage());

		ConnectionErrorResponse adapterResponse = new ConnectionErrorResponse();
		adapterResponse.setConnectionErrorResult(response);

		return adapterResponse;
	}

	public GetLastErrorResponse getLastError(GetLastError request) {
		String response = qbService.getLastError(request.getTicket());

		GetLastErrorResponse adapterResponse = new GetLastErrorResponse();
		adapterResponse.setGetLastErrorResult(response);

		return adapterResponse;
	}

	public CloseConnectionResponse closeConnection(CloseConnection request) {
		String response = qbService.closeConnection(request.getTicket());

		CloseConnectionResponse adapterResponse = new CloseConnectionResponse();
		adapterResponse.setCloseConnectionResult(response);

		return adapterResponse;
	}

}