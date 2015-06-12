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
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.logging.client.DefaultLevel.Info;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.savonline.client.event.AddEmployeEvent;


public class AddEmployePresenter implements Presenter {

	 public static interface Display{
		 Widget asWidget();
		 HasValue<Integer> getIntNTelPort();
		 HasValue<Integer> getIntNTelFix();
		 HasValue<String> getTxtNom();
		 HasValue<String> getTxtPrenom();
		 HasValue<String> getTxtAdresse();
		 HasValue<String> getTxtEmail();
		 HasValue<String> getTxtPwd();
		 HasClickHandlers getbtnAdd();
		 HasClickHandlers getbtnCancel();
		 Label getlblErrNom();
		 Label getlblErrPrenom();
		 Label getlblErrAdresse();
		 Label getlblErrNTelPort();
		 Label getlblErrNTelFix();
		 Label getlblErrEmail();
		 Label getlblErrPwd();
	}
	 
	 private final HandlerManager eventBus;
	 private final RequestBuilder requestBuilder;
	 private final Display display;
	 String ct,ct2;
	 
	  JSONObject jsonObj;
	 public AddEmployePresenter(HandlerManager eventBus,RequestBuilder requestBuidler,Display display){
			this.eventBus=eventBus;
			this.requestBuilder = requestBuidler;
			this.display=display;
			
			ct = new String("Content-Type");
			ct2 = new String("application/x-www-form-urlencoded");
			jsonObj =  new JSONObject();
	 }
	 
	 public void VerifChamp(){
		 if (display.getTxtNom().getValue().equalsIgnoreCase("")){
				display.getlblErrNom().setText(" *");
			}
			else if(display.getTxtPrenom().getValue().equalsIgnoreCase("")){
				display.getlblErrPrenom().setText(" *");
			}
			else if(display.getTxtAdresse().getValue().equalsIgnoreCase("")){
				display.getlblErrAdresse().setText(" *");
			}
			else if(display.getIntNTelPort().getValue().equals(null)){
				display.getlblErrNTelPort().setText(" *");
			}
			else if(display.getIntNTelFix().getValue().equals(null)){
				display.getlblErrNTelFix().setText(" *");
			}
			else if(display.getTxtEmail().getValue().equalsIgnoreCase("")){
				display.getlblErrEmail().setText(" *");
			}
			else if(display.getTxtPwd().getValue().equalsIgnoreCase("")){
				display.getlblErrPwd().setText(" *");
			}
			
	 }
	 
	 public void bind(){
		 display.getbtnCancel().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			display.getTxtNom().setValue("");
			display.getTxtPrenom().setValue("");
			display.getTxtAdresse().setValue("");
			display.getIntNTelPort().setValue(null);
			display.getIntNTelFix().setValue(null);
			display.getTxtEmail().setValue("");
			display.getTxtPwd().setValue("");
				
			}
		});
		 display.getbtnAdd().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				VerifChamp();
				try{
					jsonObj.put("Action", new JSONString("AddEmploye"));
					jsonObj.put("Nom", new JSONString(display.getTxtNom().getValue()));
					jsonObj.put("Prenom", new JSONString(display.getTxtPrenom().getValue()));
					jsonObj.put("Adresse", new JSONString(display.getTxtAdresse().getValue()));
					jsonObj.put("NumTelPort", new JSONNumber(display.getIntNTelPort().getValue()));
					jsonObj.put("NumTelFix", new JSONNumber(display.getIntNTelFix().getValue()));
					jsonObj.put("Email", new JSONString(display.getTxtEmail().getValue()));
					jsonObj.put("Pwd", new JSONString(display.getTxtPwd().getValue()));
					
					requestBuilder.setHeader(ct, ct2);
					requestBuilder.sendRequest("jsonObj="+jsonObj.toString(), new RequestCallback() {
						
						@Override
						public void onResponseReceived(Request request, Response response) {
							
						}
						
						@Override
						public void onError(Request request, Throwable exception) {
							// TODO Auto-generated method stub
							Window.alert("Error with HTTP code :"+ exception.toString());
						}
					});
				}
				catch(RequestException e){
					e.printStackTrace();
				}
				eventBus.fireEvent(new AddEmployeEvent());
			}
		});
	 }

		public void go(HasWidgets left, HasWidgets container) {
			bind();
			//left.add(display.asWidget());
			container.clear();
			container.add(display.asWidget());
			
		}

}
