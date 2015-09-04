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
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.savonline.client.event.AddFicheEvent;

public class SuiviFichePresenter implements Presenter {
	public static interface Display{
		Widget asWidget();
		HasClickHandlers getFlexDevis();
		String getClickedRowDevis(ClickEvent event);
		void setBoitDevis(JSONArray jsonDataDevis);
		Button getBtnValiderDevisDisable();
		//dialogBox
		Button getBtnAnnulerF();
		Button getBtnModif();
		Button getBtnAjouterFiche();
		DialogBox getBoitDialog();
		void setLblRapport(String Rapportlbl);
		void setLblDevis(String lDevis);
		void setLblCommentDevis(String commentaire);
		void setLblIdFiche(String idFiche);
		HasValue<String> getTxtAriaCommentaire();
		HasValue<String> getTxtAriaDevis();
		HasValue<String> getTxtAriaRapport();
		HasClickHandlers getBtnValiderDevis();
		HasClickHandlers getbtnModifierDevis();
		HasClickHandlers getBtnFermer();
		//Edit
		Button getBAssigner();
		ListBox getLstTechnicien();
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
		HasClickHandlers getBtnEditFiche();
		HasValue<String> getTxtDateCreation();
		HasValue<String> getTxtAriaDescriptionPanne();
		HasValue<String> getTxtAriaCommEtatFiche();	
		HasValue<String> getTxtAriaAccessoires();
		HasValue<String> getTxtAriaRemarque();
		HasValue<String> getTxtAriaObservation();
		HasValue<String> getRaye();
		HasValue<String> getSubitUnChoc();
		HasValue<String> getVisOuvert();
		String getLstGarantie();
		String getLstEtatFiche();
		HasClickHandlers getBtnAssigner();
		void setSuiviData(JSONArray data);
		void setLstTechnicien(JSONArray DataTechnicien);
		void setLblResultInsert(String resultInsert);
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
		String getId_Employe();
		HasClickHandlers getBtnCreateDevis();
		void setDataDevis(JSONArray jsonDataDevis);
	}

	private final HandlerManager eventBus;
	private final RequestBuilder requestBuilder;
	private final Display display;
	String ct,ct2;

	JSONObject jsonObj;

	String idFiche;
	String idClient;
	String typeElement;
	JSONValue jsonValue;
	JSONArray jsonArray;
	JSONObject jsonObject,jsonObjVariable;
	JSONString jsonString;



	public SuiviFichePresenter(HandlerManager eventBus,RequestBuilder requesBuilder, Display display){
		this.eventBus=eventBus;
		this.requestBuilder = requesBuilder;
		this.display=display;
		

		ct = new String("Content-Type");
		ct2 = new String("application/x-www-form-urlencoded");
		jsonObj =  new JSONObject();		

		try{


			requesBuilder.setHeader(ct, ct2);
			jsonObj.put("Action", new JSONString("SuiviFiche"));
			jsonObj.put("idClient", new JSONString(Cookies.getCookie("ID_employe")));
			requesBuilder.sendRequest("jsonObj="+jsonObj.toString(), new RequestCallback() {

				@Override
				public void onResponseReceived(Request request, Response response) {

					//Window.alert(response.getText());
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
					
					
//					if (Cookies.getCookie("RoleName").equalsIgnoreCase("Technicien")){
						
//					SuiviFichePresenter.this.display.getBAssigner().setEnabled(false);
//					SuiviFichePresenter.this.display.getLstTechnicien().setEnabled(false);
//					SuiviFichePresenter.this.display.getBtnAjouterFiche().setEnabled(true);
//					SuiviFichePresenter.this.display.getBtnAnnulerF().setEnabled(false);
//					}
//					SuiviFichePresenter.this.display.setSuiviData(jsonArray);
//					SuiviFichePresenter.this.display.getBtnAnnulerF().setVisible(false);
				Window.alert("ok");
				}

				@Override
				public void onError(Request request, Throwable exception) {
					SuiviFichePresenter.this.display.setLblResultInsert("Error with HTTP code :"+ exception.toString());

				}
			});
		}

		catch (RequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}	
		//			eventBus.fireEvent(new EditFicheEvent());
	}

	public void bind(){
//		display.getBtnEditFiche().addClickHandler(new ClickHandler() {
//
//			public void onClick(ClickEvent event) {
//				if (display.getTxtNom().getValue().equalsIgnoreCase("")){
//					display.setLnom(" *");
//				}
//				else if(display.getTxtPrenom().getValue().equalsIgnoreCase("")){
//					display.setLprenom(" *");
//				}
//				else if(display.getTxtAdresse().getValue().equalsIgnoreCase("")){
//					display.setLadresse(" *");
//				}
//				else if(display.getTxtNumTelPort().getValue().equalsIgnoreCase("")){
//					display.setLnumTelPort(" *");
//				}
////				else if(display.getTxtNumTelFix().getValue().equalsIgnoreCase("")){
////					display.setLnumTelFix(" *");
////				}
//				else if(display.getTxtEmail().getValue().equalsIgnoreCase("")){
//					display.setLemail(" *");
//				}
//				else if(display.getTxtMotPasse().getValue().equalsIgnoreCase("")){
//					display.setLpassword(" *");
//				}
//				else if(display.getTxtModele().getValue().equalsIgnoreCase("")){
//					display.setLmodele(" *");
//				}
//				else if(display.getTxtMarque().getValue().equalsIgnoreCase("")){
//					display.setLmarque(" *");
//				}
//				else if(display.getTxtNumeroSerie().getValue().equalsIgnoreCase("")){
//					display.setLnumSerie(" *");
//				}
//				else if (display.getTxtAriaDescriptionPanne().getValue().equalsIgnoreCase("")){
//					display.setLdescriptionPanne(" *");
//				}
////				else if(display.getTxtAriaCommEtatFiche().getValue().equalsIgnoreCase("")){
////					display.setLcommentaire(" *");
////				}
//				else{
//					try {	
//						String id=idFiche;
//
//
//
//						jsonObj.put("Action", new JSONString("updateFiche"));
//						jsonObj.put("IdFiche", new JSONString(id));
//						jsonObj.put("NomClient", new JSONString(display.getTxtNom().getValue()));
//						jsonObj.put("PrenomClient", new JSONString(display.getTxtPrenom().getValue()));
//						jsonObj.put("AdresseClient", new JSONString(display.getTxtAdresse().getValue()));
//						jsonObj.put("NumTelPortClient", new JSONString(display.getTxtNumTelPort().getValue()));
//						jsonObj.put("NumTelFixClient", new JSONString(display.getTxtNumTelFix().getValue()));
//						jsonObj.put("Email", new JSONString(display.getTxtEmail().getValue()));
//						jsonObj.put("MotPasse", new JSONString(display.getTxtMotPasse().getValue()));
//						jsonObj.put("Modele", new JSONString(display.getTxtModele().getValue()));
//						jsonObj.put("Marque", new JSONString(display.getTxtMarque().getValue()));
//						jsonObj.put("NumSerie", new JSONString(display.getTxtNumeroSerie().getValue()));
//						jsonObj.put("statutMateriel", new JSONString(display.getLstGarantie()));
//						jsonObj.put("commentaire_etat_Fiche", new JSONString(display.getTxtAriaCommEtatFiche().getValue()));						
//						jsonObj.put("dateCreationFiche", new JSONString(display.getTxtDateCreation().getValue()));
//						jsonObj.put("EtatFiche", new JSONString(display.getLstEtatFiche()));
//						jsonObj.put("DescPanne", new JSONString(display.getTxtAriaDescriptionPanne().getValue()));
//						jsonObj.put("Accessoire", new JSONString(display.getTxtAriaAccessoires().getValue()));
//						jsonObj.put("Remarque", new JSONString(display.getTxtAriaRemarque().getValue()));
//						jsonObj.put("Observation", new JSONString(display.getTxtAriaObservation().getValue()));
//						jsonObj.put("Raye", new JSONString(display.getRaye().getValue()));
//		    			jsonObj.put("SubitUnChoc", new JSONString(display.getSubitUnChoc().getValue()));
//		    			jsonObj.put("VisOuvert", new JSONString(display.getVisOuvert().getValue()));
//
//						requestBuilder.setHeader(ct, ct2);
//						requestBuilder.sendRequest("jsonObj="+jsonObj.toString(), new RequestCallback() {
//
//							@Override
//							public void onResponseReceived(Request request, Response response) {
//
//								//Window.alert(response.getText());
//
//							}
//
//							@Override
//							public void onError(Request request, Throwable exception) {
//								display.setLblResultInsert("Error with HTTP code :"+ exception.toString());
//
//							}
//						});
//
//					}
//
//
//					catch (RequestException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					eventBus.fireEvent(new AddFicheEvent());
//				}
//			}
//		});

		
		
	}

	public void go(HasWidgets top, HasWidgets left, HasWidgets container) {

		bind();
		left.clear();
		//		DisplayEditFiche();
		container.clear();
		container.add(display.asWidget());

	}

}
