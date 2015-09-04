package com.savonline.client.presenter;

//import com.google.gwt.event.dom.client.ClickEvent;
//import com.google.gwt.event.dom.client.ClickHandler;
//import com.google.gwt.event.dom.client.HasClickHandlers;

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


public class DisplayEmployePresenter implements Presenter {
	public static interface Display{
		Widget asWidget();
		void setDataEmpoye(JSONArray data);

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
	public DisplayEmployePresenter(HandlerManager eventBus,RequestBuilder requestBuilder,Display display){
		this.eventBus=eventBus;
		this.requestBuilder = requestBuilder;
		this.display=display;
		ct = new String("Content-Type");
		ct2 = new String("application/x-www-form-urlencoded");
		jsonObj =  new JSONObject();
		

	}

	public void bind(){
		try {	

			
			jsonObj.put("Action", new JSONString("DisplayEmploye"));
						
			requestBuilder.setHeader(ct, ct2);
			requestBuilder.sendRequest("jsonObj="+jsonObj.toString(), new RequestCallback() {

				@Override
				public void onResponseReceived(Request request, Response response) {
					if(response.getText().equalsIgnoreCase("")){
						Window.alert("no content to display");
					}else{
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


					display.setDataEmpoye(jsonArray);

				}
				}

				@Override
				public void onError(Request request, Throwable exception) {
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
	

	
//public void EditFiche(){
//	
//		display.getList().addClickHandler(new ClickHandler() {
//			public void onClick(ClickEvent event) {
//				
//				eventBus.fireEvent(new EditFicheEvent(display.getClickedRow(event),display.getTypeElement(event)));
//				
//	}
//	
//		});
//
//}


public void go(HasWidgets top, HasWidgets left, HasWidgets container) {
	
	bind();
//	EditFiche();
	container.clear();
	container.add(display.asWidget());

}

}
