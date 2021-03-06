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
import com.google.gwt.user.client.ui.Widget;
import com.savonline.client.event.AddFicheEvent;
import com.savonline.client.event.VerifGarantieFicheEvent;

public class AddFichePresenter implements Presenter {
	JSONValue jsonValue;
	JSONArray jsonArray;
	JSONObject jsonObject;
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

		HasClickHandlers getBtnAnnuler();
		HasClickHandlers getBtnAddFicheRec();
		HasClickHandlers getBtnCheckGarantee();
//		HasValue<String> getTxtDateCreation();
		HasValue<String> getTxtAriaDescriptionPanne();
		HasValue<String> getTxtAriaCommEtatFiche();
		HasValue<String> getTxtAriaObservation();
		HasValue<String> getTxtAriaRemarque();
		HasValue<String> getTxtAriaAccessoires();
		HasValue<String> getRaye();
		HasValue<String> getSubitUnChoc();
		HasValue<String> getVisOuvert();
		
		String getLstGarantie();
		String getLstEtatFiche();
		void setLnom(String lnom);
		void setLprenom(String lprenom);
		void setLadresse(String ladresse);
		void setLnumTelPort(String lnumTelPort);
		void setLnumTelFix(String lnumTelFix);
		void setLemail(String lemail);
		void setLpassword(String lpassword);
		void setLmodele(String lmodele);
		void setLmarque(String lmarque);
		void setLnumSerie(String lnumSerie);
		void setLstatut(String lstatut);
		void setLdescriptionPanne(String ldescriptionPanne);
		void setLcommentaire(String lcommentaire);
		void setLblResultInsert(String resultInsert);
		
	}
	
	private final HandlerManager eventBus;
	private final Display display;
	private final RequestBuilder requestBuidler;
	 String ct,ct2;
	 
	  JSONObject jsonObj;
	  
	  
	public AddFichePresenter(HandlerManager eventBus,RequestBuilder requestBuidler,Display display){
		this.eventBus=eventBus;
		this.requestBuidler = requestBuidler;
		this.display=display;
		
		ct = new String("Content-Type");
		ct2 = new String("application/x-www-form-urlencoded");
		jsonObj =  new JSONObject();
		
	
	}
	public static boolean isNumber(String str) {
	     try {
	             Integer.parseInt(str);
	             return true;
	     }
	     catch(NumberFormatException e) {
	             return false;
	     }
	}

	public boolean isValidEmail(Object value) {
        if(value == null) return true;
        
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(?:[a-zA-Z]{2,6})$";
        
        boolean valid = false;
        
        if(value.getClass().toString().equals(String.class.toString())) {
                valid = ((String)value).matches(emailPattern);
        } else {
                valid = ((Object)value).toString().matches(emailPattern);
        }

        return valid;
}
	public void bind(){
		display.getBtnAddFicheRec().addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				display.setLnom("");
				display.setLprenom("");
				display.setLadresse("");
				display.setLnumTelPort("");
				display.setLemail("");
				display.setLmodele("");
				display.setLmarque("");
				display.setLnumSerie("");
				display.setLdescriptionPanne("");
				display.setLnumTelFix("");
				if (display.getTxtNom().getValue().equalsIgnoreCase("")){
					display.setLnom(" *");

				}
//				else if(display.getTxtPrenom().getValue().isEmpty()){
//					display.setLprenom(" ");
//				}
				else if(display.getTxtPrenom().getValue().equalsIgnoreCase("")){
						display.setLprenom(" *");
					}
				else if(display.getTxtAdresse().getValue().equalsIgnoreCase("")){
						display.setLadresse(" *");
					}
				else if(display.getTxtNumTelPort().getValue().equalsIgnoreCase("")
						||!(isNumber(display.getTxtNumTelPort().getValue()))){
						display.setLnumTelPort(" required numeric");
					}
				
				else if(!(display.getTxtNumTelFix().getValue().equalsIgnoreCase(""))
						&& !(isNumber(display.getTxtNumTelFix().getValue()))){
					
							display.setLnumTelFix("required numeric");
					
					}
				else if(display.getTxtEmail().getValue().equalsIgnoreCase("")
						||!(isValidEmail(display.getTxtEmail().getValue()))){
						display.setLemail(" required email format");
					}
				
				else if(display.getTxtModele().getValue().equalsIgnoreCase("")){
						display.setLmodele(" *");
					}
				else if(display.getTxtMarque().getValue().equalsIgnoreCase("")){
						display.setLmarque(" *");
					}
				else if(display.getTxtNumeroSerie().getValue().equalsIgnoreCase("")){
						display.setLnumSerie(" *");
					}
				else if (display.getTxtAriaDescriptionPanne().getValue().equalsIgnoreCase("")){
						display.setLdescriptionPanne(" *");
					}
//				else if(display.getTxtAriaCommEtatFiche().getValue().equalsIgnoreCase("")){
//						display.setLcommentaire(" *");
//					}
					
				else{
					
					try {
					
					
		    		jsonObj.put("Action", new JSONString("InsertFiche"));
	    			jsonObj.put("NomClient", new JSONString(display.getTxtNom().getValue()));
	    			jsonObj.put("PrenomClient", new JSONString(display.getTxtPrenom().getValue()));
	    			jsonObj.put("AdresseClient", new JSONString(display.getTxtAdresse().getValue()));
	    			jsonObj.put("NumTelPortClient", new JSONString(display.getTxtNumTelPort().getValue()));
	    			jsonObj.put("NumTelFixClient", new JSONString(display.getTxtNumTelFix().getValue()));
	    			jsonObj.put("Email", new JSONString(display.getTxtEmail().getValue()));
	    			
	    			jsonObj.put("Modele", new JSONString(display.getTxtModele().getValue()));
	    			jsonObj.put("Marque", new JSONString(display.getTxtMarque().getValue()));
	    			jsonObj.put("NumSerie", new JSONString(display.getTxtNumeroSerie().getValue()));
	    			jsonObj.put("statutMateriel", new JSONString(display.getLstGarantie()));
	    			jsonObj.put("commentaire_etat_Fiche", new JSONString(display.getTxtAriaCommEtatFiche().getValue()));
	    			jsonObj.put("accessoire", new JSONString(display.getTxtAriaAccessoires().getValue()));
	    			jsonObj.put("remarque", new JSONString(display.getTxtAriaRemarque().getValue()));
	    			jsonObj.put("observation", new JSONString(display.getTxtAriaObservation().getValue()));
	    			jsonObj.put("Raye", new JSONString(display.getRaye().getValue()));
	    			jsonObj.put("SubitUnChoc", new JSONString(display.getSubitUnChoc().getValue()));
	    			jsonObj.put("VisOuvert", new JSONString(display.getVisOuvert().getValue()));
//	    			jsonObj.put("NomFournisseur", new JSONString(display.getTxtNomFournisseur().getValue()));
//	    			jsonObj.put("AdresseFournisseur", new JSONString(display.getTxtAdresseFournisseur().getValue()));
//	    			jsonObj.put("NumTelFournisseur", new JSONString(display.getTxtNumTelFournisseur().getValue()));
//	    			jsonObj.put("NumFaxFournisseur", new JSONString(display.getTxtFaxFournisseur().getValue()));
//	    			jsonObj.put("EmailFournisseur", new JSONString(display.getTxtEmailFournisseur().getValue()));
//	    			jsonObj.put("dateCreationFiche", new JSONString(display.getTxtDateCreation().getValue()));
	    			jsonObj.put("EtatFiche", new JSONString(display.getLstEtatFiche()));
	    			jsonObj.put("DescPanne", new JSONString(display.getTxtAriaDescriptionPanne().getValue()));
	    			//jsonObj.put("InformationComplementaire", new JSONString(display.getTxtAriaInformationComplementaire().getValue()));
	    			
	    			requestBuidler.setHeader(ct, ct2);
	    			requestBuidler.sendRequest("jsonObj="+jsonObj.toString(), new RequestCallback() {
	    			
	    				@Override
	    				public void onResponseReceived(Request request, Response response) {
	    					
	    					eventBus.fireEvent(new AddFicheEvent());
	    						}
	    				
	    				@Override
	    				public void onError(Request request, Throwable exception) {
	    					display.setLblResultInsert("Error with HTTP code :"+ exception.toString());
	    					
	    				}
	    			
	    			});
	    		
	    			}
					
				
				
	    	  catch (RequestException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
					
				
					}
			}
		});
		display.getBtnCheckGarantee().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if (display.getTxtNumeroSerie().getValue().equalsIgnoreCase("")){
					display.setLnumSerie(" *");
				}else{
					try {
						jsonObj.put("Action", new JSONString("checkGarantee"));
		    			jsonObj.put("numSerie", new JSONString(display.getTxtNumeroSerie().getValue()));
		    			Cookies.setCookie("numSerie",display.getTxtNumeroSerie().getValue());
		    			requestBuidler.setHeader(ct, ct2);
		    			requestBuidler.sendRequest("jsonObj="+jsonObj.toString(), new RequestCallback() {
		    			
		    				@Override
		    				public void onResponseReceived(Request request, Response response) {
		    					
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
		    					
		    					Window.alert(jsonArray.toString());
		    						
		    				}
		    				
		    				@Override
		    				public void onError(Request request, Throwable exception) {
		    					Window.alert("Error with HTTP code :"+ exception.toString());
		    					
		    				}
		    			
		    			});
					} catch (Exception e) {
						e.printStackTrace();
					}
					eventBus.fireEvent(new VerifGarantieFicheEvent());
				}
				
			}
		});
	
		display.getBtnAnnuler().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				 //TODO Auto-generated method stub
			display.getTxtNom().setValue("");
			display.getTxtAriaCommEtatFiche().setValue("");
			display.getTxtPrenom().setValue("");
			display.getTxtAdresse().setValue("");
			display.getTxtNumTelPort().setValue("");
			display.getTxtNumTelFix().setValue("");
			display.getTxtEmail().setValue("");
			display.getTxtMotPasse().setValue("");
//			display.getTxtNomFournisseur().setValue("");
//			display.getTxtAdresseFournisseur().setValue("");
//			display.getTxtNumTelFournisseur().setValue("");
//			display.getTxtFaxFournisseur().setValue("");
//			display.getTxtEmailFournisseur().setValue("");
			display.getTxtModele().setValue("");
			display.getTxtMarque().setValue("");
			display.getTxtNumeroSerie().setValue("");
//			display.getTxtDateCreation().setValue("");
			display.getTxtAriaDescriptionPanne().setValue("");
			display.getTxtAriaAccessoires().setValue("");
			display.getTxtAriaRemarque().setValue("");
			display.getTxtAriaObservation().setValue("");
			display.getRaye().setValue("");
			display.getSubitUnChoc().setValue("");
			display.getVisOuvert().setValue("");
			//display.getTxtAriaInformationComplementaire().setValue("");
			}
		});
	}
	
	public void go(HasWidgets top, HasWidgets left, HasWidgets container) {
		bind();
		//left.add(display.asWidget());
		container.clear();
		container.add(display.asWidget());
		
	}

}
