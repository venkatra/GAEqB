package ca.effacious.professional.gaeqb.gui.shared;

import java.io.Serializable;

/**
 * This is a DTO/Pojo representing ITEM.
 * 
 */
public class Item implements Serializable {

	private static final long serialVersionUID = -2342831113967415890L;
	private String listId;
	private String name;
	private String fullName;
	private boolean isActive;
	private long quantityOnHand;
	private String lastRefreshed;
	
	public String getListId() {
		return listId;
	}
	public void setListId(String listId) {
		this.listId = listId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public long getQuantityOnHand() {
		return quantityOnHand;
	}
	public void setQuantityOnHand(long quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}
	public String getLastRefreshed() {
		return lastRefreshed;
	}
	public void setLastRefreshed(String lastRefreshed) {
		this.lastRefreshed = lastRefreshed;
	}
	
	
	
	
}
