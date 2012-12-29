package ca.effacious.professional.gaeqb.service;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import ca.effacious.professional.gaeqb.gui.shared.Item;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Transaction;

public class ItemSyncStore {
	private static Logger log = Logger.getLogger(ItemSyncStore.class.getName());
	private DatastoreService datastore;
	private XPathExpression xpathExpression_ItemInventoryRet = null;
	private XPath xpath;
	private List<Item> listOfItems = new ArrayList<Item>();
	private Entity itemEntityParent;

	public ItemSyncStore() {
		xpath = XPathFactory.newInstance().newXPath();
		try {
			xpathExpression_ItemInventoryRet = xpath
					.compile("//ItemInventoryRet");
		} catch (XPathExpressionException e) {
			log.severe("Error while compiling xpath expression : "
					+ e.getMessage());
		}

		datastore = DatastoreServiceFactory.getDatastoreService();

		Key parentKey = KeyFactory.createKey("ParentEntity", "ITEMParent");
		try {
			itemEntityParent = datastore.get(parentKey);
		} catch (EntityNotFoundException e) {

			Transaction txn = datastore.beginTransaction();
			try {
				itemEntityParent = new Entity(parentKey);
				datastore.put(itemEntityParent);
				txn.commit();
			} catch (Exception ex) {
				log.severe("FATAL :- unable to create item entity parent : "
						+ e.getMessage());
				itemEntityParent = null;
			}

		}

	}

	public int parseItemListQueryResponse(java.lang.String ticket,
			java.lang.String response, java.lang.String hresult,
			java.lang.String message) {

		if (xpathExpression_ItemInventoryRet == null) {
			log.severe("Xpath expression was not initialized, hence not parsing the response");
		}

		InputSource s = new InputSource(new StringReader(response));
		NodeList nl = null;
		try {
			nl = (NodeList) xpathExpression_ItemInventoryRet.evaluate(s,
					XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			log.severe("Unable to evaluate xpath on the response xml doc. hence returning "
					+ e.getMessage());
			log.info("Query response : " + response);
			e.printStackTrace();
			return 100;
		}

		log.info("Total items in list : " + nl.getLength());
		Element n = null;
		String refreshedTime = (new Date()).toString();
		for (int i = 0; i < nl.getLength(); i++) {
			n = (Element) nl.item(i);
			try {
				Item itm = new Item();
				itm.setListId(xpath.evaluate("./ListID", n));
				itm.setName(xpath.evaluate("./Name", n));
				itm.setFullName(xpath.evaluate("./FullName", n));
				itm.setActive(Boolean.parseBoolean(xpath.evaluate("./IsActive",
						n)));
				itm.setQuantityOnHand(Integer.parseInt(xpath.evaluate(
						"./QuantityOnHand", n)));
				itm.setLastRefreshed(refreshedTime);

				listOfItems.add(itm);

			} catch (XPathExpressionException e) {
				log.info("Error : " + e.getMessage());
			}

		}

		return 100;
	}

	public void storeItems() {
		List<Entity> listOfEntities = new ArrayList<Entity>();

		if (itemEntityParent == null) {
			log.severe("Unable to store items, as parent is null.");
			return;
		}

		for (Item item : this.listOfItems) {
			Entity itmEntity = new Entity("ITEM", item.getListId(),
					itemEntityParent.getKey());
			itmEntity.setProperty("ListID", item.getListId());
			itmEntity.setProperty("Name", item.getName());
			itmEntity.setProperty("FullName", item.getFullName());
			itmEntity.setUnindexedProperty("IsActive", item.isActive());
			itmEntity.setUnindexedProperty("QuantityOnHand",
					item.getQuantityOnHand());
			itmEntity.setUnindexedProperty("LastRefreshed",
					item.getLastRefreshed());

			listOfEntities.add(itmEntity);
		}

		Transaction txn = datastore.beginTransaction();
		try {
			datastore.put(txn, listOfEntities);
			txn.commit();
		} catch (Exception ex) {
			log.severe("FATAL :- unable to store items : " + ex.getMessage());
		}
		log.info("No of items refereshed : " + listOfEntities.size());

		listOfItems = new ArrayList<Item>();
	}
}
