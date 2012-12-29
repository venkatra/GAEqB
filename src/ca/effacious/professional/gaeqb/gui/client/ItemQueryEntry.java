package ca.effacious.professional.gaeqb.gui.client;

import ca.effacious.professional.gaeqb.gui.shared.Item;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ItemQueryEntry implements EntryPoint {

	private VerticalPanel mainPanel = new VerticalPanel();
	private FlexTable tblItem = new FlexTable();
	private HorizontalPanel addPanel = new HorizontalPanel();
	private TextBox txtBoxItemName = new TextBox();
	private Button btnSearchByName = new Button("Search");
	private Label lastUpdatedLabel = new Label();

	private final ItemQueryServiceAsync service = GWT
			.create(ItemQueryService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		doLayout();
		doSetEventHandlers();
	}
	
	private void doSetEventHandlers() {
		// Listen for mouse events on the Add button.
		btnSearchByName.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				searchForItemByName();
			}
		});

		// Listen for keyboard events in the input box.
		txtBoxItemName.addKeyPressHandler(new KeyPressHandler() {
			public void onKeyPress(KeyPressEvent event) {
				if (event.getCharCode() == KeyCodes.KEY_ENTER) {
					searchForItemByName();
				}
			}
		});

	}

	private void searchForItemByName() {
		final String symbol = txtBoxItemName.getText().trim();
		txtBoxItemName.setFocus(true);

		// Stock code must be between 1 and 10 chars that are numbers, letters,
		// or dots.
		if (!symbol.matches("^[0-9A-Z\\.]{1,10}$")) {
			Window.alert("'" + symbol + "' is not a valid symbol.");
			txtBoxItemName.selectAll();
			return;
		}

		// newSymbolTextBox.setText("");

		service.getItemByName(txtBoxItemName.getText(),
				new AsyncCallback<Item>() {
					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user
						tblItem.setText(0, 1, "Server error");
						tblItem.setText(1, 1, "");
						tblItem.setText(2, 1, "");
						tblItem.setText(3, 1, "");

					}

					public void onSuccess(Item result) {
						tblItem.setText(0, 1, result.getName());
						tblItem.setText(1, 1, result.getFullName());
						tblItem.setText(2, 1,
								"" + result.getQuantityOnHand());
						tblItem.setText(3, 1, result.getListId());
						
					}
				});
	}

	void doLayout() {
		// Create table for stock data.
		tblItem.setText(0, 0, "Name");
		tblItem.setText(1, 0, "Full Name");
		tblItem.setText(2, 0, "QuantityOnHand");
		tblItem.setText(3, 0, "List ID");
		
		tblItem.setText(0, 1, "");
		tblItem.setText(1, 1, "");
		tblItem.setText(2, 1, "");
		tblItem.setText(3, 1, "");

		tblItem.getColumnFormatter().addStyleName(0, "watchListHeader");
		tblItem.addStyleName("watchList");
		 
		// Assemble Add Stock panel.
		addPanel.add(txtBoxItemName);
		addPanel.add(btnSearchByName);
		addPanel.addStyleName("addPanel");
		
		// Assemble Main panel.
		mainPanel.add(addPanel);
		mainPanel.add(lastUpdatedLabel);
		mainPanel.add(tblItem);

		// Associate the Main panel with the HTML host page.
		RootPanel.get("itemQueryDivSection").add(mainPanel);

		// Move cursor focus to the input box.
		txtBoxItemName.setFocus(true);
	}

}
