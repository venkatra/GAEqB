package ca.effacious.professional.gaeqb.gui.server;

import ca.effacious.professional.gaeqb.gui.client.ItemQueryService;
import ca.effacious.professional.gaeqb.gui.shared.Item;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service. Queries the datastore
 * for the requested item.
 */
@SuppressWarnings("serial")
public class ItemQueryServiceImpl extends RemoteServiceServlet
		implements ItemQueryService {

	@Override
	public Item getItemByName(String name)
			throws IllegalArgumentException {
		Item itm = null;

		itm = new Item();

		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();

		Filter itemNameFilter = new FilterPredicate("Name",
				FilterOperator.EQUAL, name);

		// Use class Query to assemble a query
		Query q = new Query("ITEM").setFilter(itemNameFilter);

		// Use PreparedQuery interface to retrieve results
		PreparedQuery pq = datastore.prepare(q);

		for (Entity result : pq.asIterable()) {

			itm.setName((String) result.getProperty("Name"));
			itm.setFullName((String) result.getProperty("FullName"));
			itm.setListId((String) result.getProperty("ListID"));
			itm.setQuantityOnHand((Long) result
					.getProperty("QuantityOnHand"));

		}

		return itm;
	}

}
