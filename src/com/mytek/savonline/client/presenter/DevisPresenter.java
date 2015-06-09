package com.mytek.savonline.client.presenter;

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
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.mytek.savonline.client.event.AddFicheEvent;

public class DevisPresenter implements Presenter {
	public static interface Display{
		Widget asWidget();	
		DialogBox getBoitDialog();
		void setLblRapport(String Rapportlbl);
		void setLblDevis(String lDevis);
		void setLblCommentDevis(String commentaire);
		void setLblIdFiche(String idFiche);
		HasValue<String> getTxtAriaCommentaire();
		HasValue<String> getTxtAriaDevis();
		HasValue<String> getTxtAriaRapport();
		HasClickHandlers getBtnValiderDevis();
		HasClickHandlers getBtnAnnulerDevis();
	}

	private final HandlerManager eventBus;
	private final RequestBuilder requestBuilder;
	private final Display display;
	String ct,ct2;

	JSONObject jsonObj;

	String idFiche;
	JSONValue jsonValue;
	JSONArray jsonArray;
	JSONObject jsonObject,jsonObjVariable;
	JSONString jsonString;



	public DevisPresenter(HandlerManager eventBus,RequestBuilder requesBuilder, Display display, String id){
		this.eventBus=eventBus;
		this.requestBuilder = requesBuilder;
		this.display=display;
		this.idFiche=id;
		display.setLblIdFiche(id);

		ct = new String("Content-Type");
		ct2 = new String("application/x-www-form-urlencoded");
		jsonObj =  new JSONObject();		

	
	}

	public void bind(){
		display.getBtnValiderDevis().addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				if (display.getTxtAriaRapport().getValue().equalsIgnoreCase("")){
					display.setLblRapport(" *");
				}
				else if(display.getTxtAriaDevis().getValue().equalsIgnoreCase("")){
					display.setLblDevis(" *");
				}
				else if(display.getTxtAriaCommentaire().getValue().equalsIgnoreCase("")){
					display.setLblCommentDevis(" *");
				}
				
								else{
					try {	
						String id=idFiche;
						

						jsonObj.put("Action", new JSONString("addDevis"));
						jsonObj.put("Rapport", new JSONString(display.getTxtAriaRapport().getValue()));
						jsonObj.put("Devis", new JSONString(display.getTxtAriaDevis().getValue()));
						jsonObj.put("CommentaireDevis", new JSONString(display.getTxtAriaCommentaire().getValue()));

						requestBuilder.setHeader(ct, ct2);
						requestBuilder.sendRequest("jsonObj="+jsonObj.toString(), new RequestCallback() {

							@Override
							public void onResponseReceived(Request request, Response response) {

								
								
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
					display.getBoitDialog().hide();
//					eventBus.fireEvent(new AddFicheEvent());
				}
			}
		});


		display.getBtnAnnulerDevis().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				//TODO Auto-generated method stub
				display.getTxtAriaCommentaire().setValue("");
				display.getTxtAriaDevis().setValue("");
				display.getTxtAriaRapport().setValue("");
							}
		});

	}


	public void go(HasWidgets left, HasWidgets container) {

		bind();
		container.clear();
		container.add(display.asWidget());

	}

}
