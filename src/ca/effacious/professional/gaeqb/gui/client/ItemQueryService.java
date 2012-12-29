package ca.effacious.professional.gaeqb.gui.client;

import ca.effacious.professional.gaeqb.gui.shared.Item;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("itemQuery")
public interface ItemQueryService extends RemoteService {
	
	/*
	 * Queries for an item based upon its name.
	 */
	Item getItemByName(String name) throws IllegalArgumentException;
}
