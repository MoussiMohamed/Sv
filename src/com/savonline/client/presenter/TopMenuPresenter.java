package com.savonline.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.savonline.client.event.DeconnectEvent;

public class TopMenuPresenter implements Presenter {
	JSONValue jsonValue;
	JSONArray jsonArray;
	JSONObject jsonObject;
	public static interface Display{
		Widget asWidget();
		
		HasClickHandlers getBtnDisconnect();
		
	}
	
	private final HandlerManager eventBus;
	private final Display display;
	private final RequestBuilder requestBuidler;
	 String ct,ct2;
	 
	  JSONObject jsonObj;
	  
	  
	public TopMenuPresenter(HandlerManager eventBus,RequestBuilder requestBuidler,Display display){
		this.eventBus=eventBus;
		this.requestBuidler = requestBuidler;
		this.display=display;
		
		ct = new String("Content-Type");
		ct2 = new String("application/x-www-form-urlencoded");
		jsonObj =  new JSONObject();
		
	
	}

	public void bind(){
		
		
		display.getBtnDisconnect().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Cookies.removeCookie("RoleName");
				Cookies.removeCookie("ID_employe");
				Cookies.removeCookie("Email");
				eventBus.fireEvent(new DeconnectEvent());
			}
		});
	
		
	}
	
	public void go(HasWidgets top, HasWidgets left, HasWidgets container) {
		bind();
		top.clear();
		top.add(display.asWidget());

		
	}

}
