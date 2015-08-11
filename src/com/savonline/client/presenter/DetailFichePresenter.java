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
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.savonline.client.event.AddFicheEvent;
import com.savonline.client.event.EditFicheEvent;
import com.savonline.client.event.EditFicheEventHandler;
import com.savonline.client.presenter.AffichFichePresenter;

public class DetailFichePresenter implements Presenter {
	public static interface Display{
		Widget asWidget();
		HasValue<String> getTxtNom();
		HasValue<String> getTxtPrenom();
		HasValue<String> getTxtAdresse();
		HasValue<String> getTxtNumTelPort();
		HasValue<String> getTxtNumTelFix();
		HasValue<String> getTxtEmail();
		HasValue<String> getTxtMotPasse();
		HasValue<String> getTxtModele();
		HasValue<String> getTxtMarque();
		HasValue<String> getTxtNumeroSerie();
		void setDataAffiche(JSONArray data);
//		HasValue<String> getTxtNomFournisseur();
//		HasValue<String> getTxtAdresseFournisseur();
//		HasValue<String> getTxtNumTelFournisseur();
//		TextBox getTxtFaxFournisseur();
//		HasValue<String> getTxtEmailFournisseur();
		HasValue<String> getTxtEtatFiche();
		HasValue<String> getTxtGarantie();
		HasClickHandlers getBtnAssigner();
		HasValue<String> getTxtDateCreation();
		HasValue<String> getTxtAriaDescriptionPanne();
		HasValue<String> getTxtAriaCommEtatFiche();
		
		//HasValue<String> getTxtAriaInformationComplementaire();
		
		void setLblResAffiche(String ResAffich);
		
	}
	
	private final HandlerManager eventBus;
	private final Display display;
	 String ct,ct2;
	 
	  JSONObject jsonObj;
	  RequestBuilder builder;
	  String idFiche;
	  JSONValue jsonValue;
		JSONArray jsonArray;
		JSONObject jsonObject,jsonObjVariable;
		JSONString jsonString;
	
//	public EditFichePresenter(HandlerManager eventBus,Display display){
//		this.eventBus=eventBus;
//		this.display=display;
//		
//		ct = new String("Content-Type");
//		ct2 = new String("application/x-www-form-urlencoded");
//		jsonObj =  new JSONObject();
//		
//	
//	}
	
	
	public DetailFichePresenter(HandlerManager eventBus, Display display, String id){
		this.eventBus=eventBus;
		this.display=display;
		idFiche=id;
		String url="http://127.0.0.1:8888/savOnline-copy/src/com/mytek/savonline/server/EditFichePHP.php";
		ct = new String("Content-Type");
		ct2 = new String("application/x-www-form-urlencoded");
		jsonObj =  new JSONObject();
		
		
	
				
				try{
	
				
				
//				Window.alert(jsonObj.toString());
				
				builder = new RequestBuilder(RequestBuilder.POST,URL.encode(url));
				builder.setHeader(ct, ct2);
				jsonObj.put("action", new JSONString("EditFiche"));
				jsonObj.put("id_fiche_for_edit", new JSONString(id));
				builder.sendRequest("jsonObj="+jsonObj.toString(), new RequestCallback() {
					
					@Override
					public void onResponseReceived(Request request, Response response) {
						
						Window.alert(response.getText());
						jsonValue = JSONParser.parseStrict(response.getText());
//						Window.alert(jsonValue.toString());
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

						DetailFichePresenter.this.display.setDataAffiche(jsonArray);
						
					}

					@Override
					public void onError(Request request, Throwable exception) {
						DetailFichePresenter.this.display.setLblResAffiche("Error with HTTP code :"+ exception.toString());
 
					}
				});
				}

		catch (RequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}	
//			eventBus.fireEvent(new EditFicheEvent());
	}

	public void bindAssigner(){
		display.getBtnAssigner().addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				
				try {	
					String id=idFiche;
					
					String url="http://127.0.0.1:8888/savOnline-copy/src/com/mytek/savonline/server/TestPHP.php";
					builder = new RequestBuilder(RequestBuilder.POST,URL.encode(url));
		    		jsonObj.put("Action", new JSONString("EditFicheNow"));
		    		jsonObj.put("IdFicheAffiche", new JSONString(id));

	    			builder.setHeader(ct, ct2);
	    			builder.sendRequest("jsonObj="+jsonObj.toString(), new RequestCallback() {
	    			
	    				@Override
	    				public void onResponseReceived(Request request, Response response) {
	    					
	    					Window.alert(response.getText());
	    				
	    						}
	    				
	    				@Override
	    				public void onError(Request request, Throwable exception) {
	    					display.setLblResAffiche("Error with HTTP code :"+ exception.toString());
	    					
	    				}
	    			});
	    		
	    			}
				
	    	  
	    	  catch (RequestException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
				eventBus.fireEvent(new AddFicheEvent());
			}
		});
		
	}
	
	public void go(HasWidgets top, HasWidgets left, HasWidgets container) {
		
		bindAssigner();
//		DisplayEditFiche();
		container.clear();
		container.add(display.asWidget());
		
	}

}
