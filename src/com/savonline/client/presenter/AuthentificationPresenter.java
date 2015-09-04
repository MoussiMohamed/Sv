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
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.savonline.client.event.AuthentifEvent;
import com.savonline.client.event.SuiviFicheEvent;

public class AuthentificationPresenter implements Presenter{
	public interface Display{
		Widget asWidget();
		void setLblErrPwd(String lblErrorPwd);
		void setLblErrLogin(String lblErrorLogin);
		String getChBoxOption();
		HasClickHandlers getBtnAuthentifier();
		HasValue<String> getTxtpwd();
		HasValue<String> getTxtLogin();
		TextBox getTxtBoxLogin();
	}
	private final HandlerManager eventBus;
	private final Display display;
	private final RequestBuilder requestBuilder;
	 String ct,ct2;
		JSONValue jsonValue;
		JSONArray jsonArray;
		JSONObject jsonObject,jsonObjVariable;
		JSONString jsonString;
		JSONObject jsonObj;
	  public AuthentificationPresenter(HandlerManager eventBus,RequestBuilder requestBuidler,Display display){
		  this.eventBus=eventBus;
			this.requestBuilder = requestBuidler;
			this.display=display;
			
			ct = new String("Content-Type");
			ct2 = new String("application/x-www-form-urlencoded");
			jsonObj =  new JSONObject();
	  }
	  
	  
	  public void bind(){
		  display.getTxtBoxLogin().setFocus(true);
		  display.getBtnAuthentifier().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				try {
					
if(display.getTxtLogin().getValue().equals("")){
//	Window.alert("champs vide");
	display.setLblErrLogin("champs vide");
}	
	else if(display.getTxtpwd().getValue().equals("")){
	display.setLblErrPwd(" champs vide");
//	Window.alert("champs vide");
}

					jsonObj.put("Action", new JSONString("authentification"));
					jsonObj.put("login", new JSONString(display.getTxtLogin().getValue()));
					jsonObj.put("pwd", new JSONString(display.getTxtpwd().getValue()));
					requestBuilder.setHeader(ct, ct2);
					//Cookies.get
					requestBuilder.sendRequest("jsonObj="+jsonObj.toString(), new RequestCallback() {

						@Override
						public void onResponseReceived(Request request, Response response) {
						if(response.getText().equalsIgnoreCase("")){
							Window.alert("login ou mot de passe incorrect");
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

							jsonObject=jsonArray.get(0).isObject();
							if(jsonObject.get("email")!= null){
								Cookies.setCookie("ID_employe",jsonObject.get("id_client").isString().stringValue());
								Cookies.setCookie("Email",display.getTxtLogin().getValue());
								eventBus.fireEvent(new SuiviFicheEvent());
							}
							if (jsonObject.get("emailEmp")!= null){
								Cookies.setCookie("RoleName",jsonObject.get("role").isString().stringValue());
								Cookies.setCookie("ID_employe",jsonObject.get("id_employe").isString().stringValue());
								Cookies.setCookie("Email",display.getTxtLogin().getValue());
								eventBus.fireEvent(new AuthentifEvent());
							}
							
//							if(jsonObject.get("role").isString().stringValue().equalsIgnoreCase("")){
//	
//}

//								Cookies.setCookie("RoleName",jsonObject.get("role").isString().stringValue());
//								Cookies.setCookie("ID_employe",jsonObject.get("id_client").isString().stringValue());
//								Cookies.setCookie("Email",display.getTxtLogin().getValue());
//								eventBus.fireEvent(new AuthentifEvent());	
						}
						
						}
					
						@Override
						public void onError(Request request, Throwable exception) {
						
						}
					});

				}

				catch (RequestException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			
				
			}
		});
	  }
	  
	@Override
	public void go(HasWidgets top,HasWidgets left, HasWidgets container) {
		bind();
		top.clear();
		left.clear();
		container.clear();
		container.add(display.asWidget());
		
	}

}
