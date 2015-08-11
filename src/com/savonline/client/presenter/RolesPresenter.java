package com.savonline.client.presenter;

import java.util.List;

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
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.savonline.client.event.AddContactEvent;
import com.savonline.client.event.AddRoleEvent;
import com.savonline.client.presenter.PrivilegesPresenter.Display;

public class RolesPresenter implements Presenter{
public static interface Display{
	HasValue<String> getTextRole();
	HasClickHandlers getAddButton();
	HasClickHandlers getCancelButton();
	void setLblResult(String resultat);
	void setText(String data);
	void setFlexData(String[] data);
    List<Integer> getSelectedRows();
    Widget asWidget();
}
private final HandlerManager eventbus;
private final Display display;
private final RequestBuilder requestBuilder;
String ct,ct2;

JSONObject jsonObj;


public RolesPresenter( HandlerManager eventBus,RequestBuilder requestBuilder,Display view){
	this.eventbus=eventBus;
	this.requestBuilder = requestBuilder;
	this.display=view;
	String ct = new String("Content-Type");
	String ct2 = new String("application/x-www-form-urlencoded");
	
	//String url = "/RoleService.php";
	JSONObject jsonObjl;
	
	
	requestBuilder.setHeader(ct, ct2);
	
}






@Override
public void go(HasWidgets top, HasWidgets left, HasWidgets container) {
	// TODO Auto-generated method stub
	
}
}
