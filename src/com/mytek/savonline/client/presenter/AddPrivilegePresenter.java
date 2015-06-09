package com.mytek.savonline.client.presenter;

import org.apache.tools.ant.taskdefs.condition.Not;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.mytek.savonline.client.event.AddPrivilegeEvent;

public class AddPrivilegePresenter implements Presenter{
	
	public static interface Display {
		Widget asWidget();
		HasClickHandlers getBtnAjoutPriv();
		HasValue<String> getTxtPrivilege();
		void setLblResultPriv(String result);
	}

	private final HandlerManager eventBus;
	private final Display display;
	private final RequestBuilder requestBuidler;
	 String ct,ct2;
	 
	  JSONObject jsonObj;
	public AddPrivilegePresenter(HandlerManager eventBus,RequestBuilder requestBuidler,Display display){
		this.eventBus=eventBus;
		this.requestBuidler = requestBuidler;
		this.display=display;
		
		ct = new String("Content-Type");
		ct2 = new String("application/x-www-form-urlencoded");
		jsonObj =  new JSONObject();
	}
	
	public void bind(){
		
		display.getBtnAjoutPriv().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			try {
				if(display.getTxtPrivilege().getValue().equalsIgnoreCase("")){
				display.setLblResultPriv("Champ Obligatoire");
				}
				else {
					display.setLblResultPriv("");
				jsonObj.put("Action", new JSONString("AddPrivilege"));
				jsonObj.put("Privilege", new JSONString(display.getTxtPrivilege().getValue()));

    			requestBuidler.setHeader(ct, ct2);
    			requestBuidler.sendRequest("jsonObj="+jsonObj.toString(), new RequestCallback() {
    			
    				@Override
    				public void onResponseReceived(Request request, Response response) {
    					

    				}
    				@Override
    				public void onError(Request request, Throwable exception) {
    					display.setLblResultPriv("Error with HTTP code :"+ exception.toString());
    					
    				}
    			
    			});
    			eventBus.fireEvent(new AddPrivilegeEvent());
    			}
				
			}
			
			catch (RequestException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
			
			}
		});
		
	}
	
	@Override
	public void go(HasWidgets left, HasWidgets container) {
		bind();
		container.clear();
		container.add(display.asWidget());
		
	}

}
