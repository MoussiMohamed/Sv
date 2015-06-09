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
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.mytek.savonline.client.event.AddFicheEvent;

public class AddFichePresenter implements Presenter {
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
//		HasValue<String> getTxtDateCreation();
		HasValue<String> getTxtAriaDescriptionPanne();
		HasValue<String> getTxtAriaCommEtatFiche();
		HasValue<String> getTxtAriaObservation();
		HasValue<String> getTxtAriaRemarque();
		HasValue<String> getTxtAriaAccessoires();
		
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

	public void bind(){
		display.getBtnAddFicheRec().addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				
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
				else if(display.getTxtNumTelPort().getValue().equalsIgnoreCase("")){
						display.setLnumTelPort(" *");
					}
				
//				else if(display.getTxtNumTelFix().getValue().equalsIgnoreCase("")){
//						display.setLnumTelFix(" *");
//					}
				else if(display.getTxtEmail().getValue().equalsIgnoreCase("")){
						display.setLemail(" *");
					}
				else if(display.getTxtMotPasse().getValue().equalsIgnoreCase("")){
						display.setLpassword(" *");
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
	    			jsonObj.put("MotPasse", new JSONString(display.getTxtMotPasse().getValue()));
	    			jsonObj.put("Modele", new JSONString(display.getTxtModele().getValue()));
	    			jsonObj.put("Marque", new JSONString(display.getTxtMarque().getValue()));
	    			jsonObj.put("NumSerie", new JSONString(display.getTxtNumeroSerie().getValue()));
	    			jsonObj.put("statutMateriel", new JSONString(display.getLstGarantie()));
	    			jsonObj.put("commentaire_etat_Fiche", new JSONString(display.getTxtAriaCommEtatFiche().getValue()));
	    			jsonObj.put("accessoire", new JSONString(display.getTxtAriaAccessoires().getValue()));
	    			jsonObj.put("remarque", new JSONString(display.getTxtAriaRemarque().getValue()));
	    			jsonObj.put("observation", new JSONString(display.getTxtAriaObservation().getValue()));
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
	    					
//	    					display.setLblResultInsert(response.getText());
//	    				Window.alert(response.getText());
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
					
				eventBus.fireEvent(new AddFicheEvent());
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
			//display.getTxtAriaInformationComplementaire().setValue("");
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
