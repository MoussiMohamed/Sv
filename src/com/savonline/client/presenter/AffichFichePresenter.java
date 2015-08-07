package com.savonline.client.presenter;

//import com.google.gwt.event.dom.client.ClickEvent;
//import com.google.gwt.event.dom.client.ClickHandler;
//import com.google.gwt.event.dom.client.HasClickHandlers;

import java.util.Date;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.savonline.client.event.EditFicheEvent;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.CellClickHandler;


public class AffichFichePresenter implements Presenter {
	public static interface Display{
		Widget asWidget();
		
		ListGrid getMainListGrid();
//		HasClickHandlers getList();
//		HasClickHandlers getListView();
//		JSONArray getSelectedRows();
//		String getClickedRow(/*ClickEvent event*/);
//		String getTypeElement(ClickEvent event);
//		void setLblResultInsert(String resultat);
//		HasClickHandlers getBtnAffiche();

		void setDataFiche(JSONArray data);


	}
	private final HandlerManager eventBus;
	private final RequestBuilder requestBuilder;
	private final Display display;
	String ct,ct2;

	JSONObject jsonObj;
	
	JSONValue jsonValue;
	JSONArray jsonArray;
	JSONObject jsonObject,jsonObjVariable;
	JSONString jsonString;
//String role,id_employe;
	public AffichFichePresenter(HandlerManager eventBus,RequestBuilder requestBuilder,Display display/*, String role, String id_employe*/){
		this.eventBus=eventBus;
		this.requestBuilder = requestBuilder;
		this.display=display;
//		this.role=role;
//		this.id_employe=id_employe;
		ct = new String("Content-Type");
		ct2 = new String("application/x-www-form-urlencoded");
		jsonObj =  new JSONObject();
		

	}
	
	public void bind(){
		try {	

			
			jsonObj.put("Action", new JSONString("afficheFiches"));
			String role = Cookies.getCookie("RoleName");
			String ID_employe=Cookies.getCookie("ID_employe");
			if(role.equalsIgnoreCase("Technicien")){
			
//			jsonObj.put("role", new JSONString(role));
			jsonObj.put("id_employe", new JSONString(ID_employe));
			}
			requestBuilder.setHeader(ct, ct2);
			requestBuilder.sendRequest("jsonObj="+jsonObj.toString(), new RequestCallback() {

				@Override
				public void onResponseReceived(Request request, Response response) {

					// parse the response text into JSON
					//JSONValue jsonValue = JSONParser.parseLenient(response.getText());

					jsonValue = JSONParser.parseStrict(response.getText());

					if ((jsonObject = jsonValue.isObject()) == null) {
						Window.alert("Error parsing the JSON");
						// Possibilites: error during download,
						// someone trying to break the application, etc.
					}

					jsonValue = jsonObject.get("d"); // Actually, this needs
					// a null check too
					if ((jsonArray = jsonValue.isArray()) == null) {
						Window.alert("Error parsing the JSON");
					}

					if ((jsonArray = jsonValue.isArray()) == null) {
						Window.alert("Error parsing the JSON");
					}

					display.setDataFiche(jsonArray);
				}


				@Override
				public void onError(Request request, Throwable exception) {
//					display.setLblResultInsert("Error with HTTP code :"+ exception.toString());
Window.alert("Error with HTTP code :"+ exception.toString());
				}
				
				
			});

		}

		catch (RequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//				eventBus.fireEvent(new AddFicheMaterielEvent());
	}
	
String selectedItem;
public void t(){
	display.getMainListGrid().addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
		
		@Override
		public void onClick(com.smartgwt.client.widgets.events.ClickEvent event) {
			
			selectedItem=display.getMainListGrid().getSelectedRecord().getAttribute("idFiche");
			eventBus.fireEvent(new EditFicheEvent(selectedItem,""));
		}
	});
}
//public void EditFiche(){
//		int selectedRow = -1;
//		Element selectedElement = null;
//		HTMLTable.Cell cell = fiches.getCellForEvent(event);
//
//		if (cell != null) {
//			// Suppress clicks if the user is actually selecting the 
//			//  check box
//			//
//			if (cell.getCellIndex() > 0) {
//				selectedRow = cell.getRowIndex();
//				
//				selectedItem=fiches.getWidget(selectedRow, 0).getElement().getFirstChild().getNodeValue();
//			}
//		}

		
	
	
//		display.getList().addClickHandler(new ClickHandler() {
//			public void onClick(ClickEvent event) {
//				
//				eventBus.fireEvent(new EditFicheEvent(display.getClickedRow(),display.getTypeElement(event)));
//		eventBus.fireEvent(new EditFicheEvent(selectedItem,null));
//	}
//		});
//}

public void go(HasWidgets left, HasWidgets container) {
	
	bind();
//	display.getClickedRow();
//	EditFiche();
	t();
	//left.add(display.asWidget());
	container.clear();
	container.add(display.asWidget());

}

}
