package com.savonline.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.savonline.client.event.AddPrivilegeEvent;
import com.savonline.client.presenter.AffichFichePresenter.Display;


public class AffichPrivilegePresenter implements Presenter {
	
public static interface Display{
	Widget asWidget();
	void setDataPrivilege(JSONArray data);
	String getClickedRow(ClickEvent event);
	HasClickHandlers getList();
	String getTypeElement(ClickEvent event);
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
public AffichPrivilegePresenter(HandlerManager eventBus,RequestBuilder requestBuilder, Display display){
	this.eventBus=eventBus;
	this.requestBuilder=requestBuilder;
	this.display=display;
	
	ct = new String("Content-Type");
	ct2 = new String("application/x-www-form-urlencoded");
	jsonObj =  new JSONObject();
	
}

public void bind(){
	try{
		jsonObj.put("Action", new JSONString("AffichePrivilege"));
		requestBuilder.setHeader(ct, ct2);
		requestBuilder.sendRequest("jsonObj="+jsonObj.toString(), new RequestCallback() {
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


				display.setDataPrivilege(jsonArray);

			}


			@Override
			public void onError(Request request, Throwable exception) {
				Window.alert("Error with HTTP code :"+ exception.toString());

			}
			
			
		});

	}
	catch (RequestException e){
		e.printStackTrace();
	}

}
 public void DeletePriv(){
display.getList().addClickHandler(new ClickHandler() {
	
	@Override
	public void onClick(ClickEvent event) {
	if (display.getTypeElement(event).equalsIgnoreCase("Delete")){
		
		try{
//			Window.alert(display.getClickedRow(event));
			jsonObj.put("Action", new JSONString("DeletePrivilege"));
			jsonObj.put("Id_Privilege", new JSONString(display.getClickedRow(event)));
			requestBuilder.setHeader(ct, ct2);
			requestBuilder.sendRequest("jsonObj="+jsonObj.toString(), new RequestCallback() {
				public void onResponseReceived(Request request, Response response) {


				}

				@Override
				public void onError(Request request, Throwable exception) {
					Window.alert("Error with HTTP code :"+ exception.toString());

				}

			});
			bind();
//			eventBus.fireEvent(new AddPrivilegeEvent());
		}
		catch (RequestException e){
			e.printStackTrace();
		}
		
	}
	
	}
});
 }
public void go(HasWidgets left, HasWidgets container) {
	bind();
	DeletePriv();
	container.clear();
	container.add(display.asWidget());
	
}
}
