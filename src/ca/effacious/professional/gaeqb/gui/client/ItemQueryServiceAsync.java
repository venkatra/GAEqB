package ca.effacious.professional.gaeqb.gui.client;

import ca.effacious.professional.gaeqb.gui.shared.Item;

import com.google.gwt.user.client.rpc.AsyncCallback;


public interface ItemQueryServiceAsync {
	void getItemByName(String name, AsyncCallback<Item> callback)
			throws IllegalArgumentException;
}
