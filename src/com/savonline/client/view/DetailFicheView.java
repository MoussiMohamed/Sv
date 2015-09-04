package com.savonline.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.savonline.client.presenter.DetailFichePresenter;

public class DetailFicheView extends Composite implements DetailFichePresenter.Display{
	

	 private  Button btnAssigner;
	 private  FlexTable flexTableContainerAll;
	 private  TextBox txtNom,txtPrenom,txtAdresse,txtNumTelPort,txtNumTelFix,txtEmail,txtMotPasse;
	 
	private  TextBox txtModele,txtMarque,txtNumeroSerie;
	private  TextArea txtAriaDescriptionPanne,txtAriaCommEtatFiche;
	private  TextBox txtGarantie,txtEtatFiche;

	private  TextBox txtDateCreation;
	// private final TextBox txtNomFournisseur,txtAdresseFournisseur,txtNumTelFournisseur,txtFaxFournisseur,txtEmailFournisseur;
	 
	private  FlexTable flexTableAll;	
	 private  Label lblResAffich;
	public DetailFicheView() {
		//creation de textAriaDescriptionPanne
		txtAriaDescriptionPanne=new TextArea();
		txtAriaDescriptionPanne.setEnabled(false);
		txtAriaCommEtatFiche=new TextArea();
		txtAriaCommEtatFiche.setEnabled(false);
		
		//txtAriaInformationComplementaire=new TextArea();
		
		//creation de TextBox de date de creation de fiche
		txtDateCreation=new TextBox();
		txtDateCreation.setEnabled(false);
		//creattion de label de resultat d insertion
		lblResAffich=new Label("Resultat affichage");
		
		//creation de TextBoxClient
		txtNom=new TextBox();
		txtNom.setEnabled(false);
		txtPrenom=new TextBox();
		txtPrenom.setEnabled(false);
		txtAdresse=new TextBox();
		txtAdresse.setEnabled(false);
		txtNumTelPort=new TextBox();
		txtNumTelPort.setEnabled(false);
		txtNumTelFix=new TextBox();
		txtNumTelFix.setEnabled(false);
		txtEmail=new TextBox();
		txtEmail.setEnabled(false);
		txtMotPasse=new TextBox();
		txtMotPasse.setEnabled(false);
		
		//creation de TextBoxMateriel
		txtModele=new TextBox();
		txtModele.setEnabled(false);
		txtMarque=new TextBox();
		txtMarque.setEnabled(false);
		txtNumeroSerie=new TextBox();
		txtNumeroSerie.setEnabled(false);
		
//		//creation de TextBoxFournisseur
//		txtNomFournisseur=new TextBox();
//		txtAdresseFournisseur=new TextBox();
//		txtNumTelFournisseur=new TextBox();
//		txtFaxFournisseur=new TextBox();
//		txtEmailFournisseur=new TextBox();
		
		//creation de ListBox de garantie & Statut de materiel
		txtGarantie=new TextBox();
		txtGarantie.setEnabled(false);
		txtEtatFiche=new TextBox();
		txtEtatFiche.setEnabled(false);
		
		
		
		//creation de FlexTable
		flexTableContainerAll=new FlexTable();
		flexTableContainerAll.setCellPadding(15);
		flexTableContainerAll.setCellPadding(10);
		btnAssigner=new Button("Assigner");
		
		flexTableAll=new FlexTable();
		flexTableAll.setCellSpacing(6);
	    FlexCellFormatter cellFormatter = flexTableAll.getFlexCellFormatter();
	    
	    
	    // Add a title to the form
	    flexTableAll.setHTML(0, 0, "<b>Information de fiche de reception de materiel<b>");
	    cellFormatter.setColSpan(0, 0, 2);
	    cellFormatter.setHorizontalAlignment(
	        0, 0, HasHorizontalAlignment.ALIGN_CENTER);
	    
	    
	    cellFormatter.setHorizontalAlignment(
		        3, 0, HasHorizontalAlignment.ALIGN_RIGHT);
	    cellFormatter.setHorizontalAlignment(
		        3, 1, HasHorizontalAlignment.ALIGN_LEFT);
	    
	    
flexTableAll.setWidget(1, 0, createClient());
flexTableAll.setWidget(2, 0, createMateriel());
flexTableAll.setWidget(1, 1, createFiche());
//flexTableAll.setWidget(2, 1, createFournisseur());
flexTableAll.setWidget(3, 0, btnAssigner);
FlexCellFormatter cellFormatterContainerAll = flexTableContainerAll.getFlexCellFormatter();
flexTableContainerAll.setCellSpacing(10);
cellFormatterContainerAll.setHorizontalAlignment(0, 0, HasAlignment.ALIGN_CENTER);
flexTableContainerAll.setWidget(0, 0, flexTableAll);
DecoratorPanel decPanelContainerAll =new DecoratorPanel();
decPanelContainerAll.add(flexTableContainerAll);

			initWidget(decPanelContainerAll);
			
}


	public Widget createClient(){
		
		 // Create a table to layout the form options
	    FlexTable layout = new FlexTable();
	    layout.setCellSpacing(6);
	    FlexCellFormatter cellFormatter = layout.getFlexCellFormatter();

	    // Add a title to the form
	    layout.setHTML(0, 0, "Client");
	    cellFormatter.setColSpan(0, 0, 2);
	    cellFormatter.setHorizontalAlignment(
	        0, 0, HasHorizontalAlignment.ALIGN_CENTER);

	    // Partie Client
	    layout.setHTML(1, 0, "Nom");
	    layout.setWidget(1, 1, txtNom);
	    layout.setHTML(2, 0, "Prenom");
	    layout.setWidget(2, 1, txtPrenom);
	    layout.setHTML(3,0,"Adresse");
	    layout.setWidget(3, 1, txtAdresse);
	    layout.setHTML(4,0,"Numero de telephone portable");
	    layout.setWidget(4, 1,txtNumTelPort);
	    layout.setHTML(5,0,"Numero de telephone fix");
	    layout.setWidget(5, 1, txtNumTelFix);
	    layout.setHTML(6,0,"Email");
	    layout.setWidget(6, 1, txtEmail);
	    layout.setHTML(7,0,"Mot de passe");
	    layout.setWidget(7, 1,txtMotPasse);
	    

	    // Wrap the content in a DecoratorPanel
	    DecoratorPanel decPanel = new DecoratorPanel();
	    decPanel.setWidget(layout);
	    
	    return decPanel;
		
		
	}
	public Widget createMateriel(){
		
		 // Create a table to layout the form options
	    FlexTable layout2 = new FlexTable();
	    layout2.setCellSpacing(6);
	    FlexCellFormatter cellFormatter = layout2.getFlexCellFormatter();

	    // Add a title to the form
	    layout2.setHTML(0, 0, "Materiel");
	    cellFormatter.setColSpan(0, 0, 2);
	    cellFormatter.setHorizontalAlignment(
	        0, 0, HasHorizontalAlignment.ALIGN_CENTER);

	    // Add some standard form options
	    layout2.setHTML(1, 0, "Modele");
	    layout2.setWidget(1, 1, txtModele);
	    layout2.setHTML(2, 0, "Marque");
	    layout2.setWidget(2, 1, txtMarque);
	    layout2.setHTML(3,0,"Numero de serie");
	    layout2.setWidget(3, 1, txtNumeroSerie);
	    layout2.setHTML(4,0,"Garantie");
	    layout2.setWidget(4, 1, txtGarantie);
	    layout2.setHTML(5,0,"Description de panne");
	    layout2.setWidget(5, 1, txtAriaDescriptionPanne);

	    
	    // Wrap the content in a DecoratorPanel
	    DecoratorPanel decPanel2 = new DecoratorPanel();
	    decPanel2.setWidget(layout2);
	    
	    return decPanel2;
		
		
	}
//	public Widget createFournisseur(){
//		
//		 // Create a table to layout the form options
//	    FlexTable layout3 = new FlexTable();
//	    layout3.setCellSpacing(6);
//	    FlexCellFormatter cellFormatter = layout3.getFlexCellFormatter();
//
//	    // Add a title to the form
//	    layout3.setHTML(0, 0, "Fournisseur");
//	    cellFormatter.setColSpan(0, 0, 2);
//	    cellFormatter.setHorizontalAlignment(
//	        0, 0, HasHorizontalAlignment.ALIGN_CENTER);
//
//	    // Add some standard form options
//	    layout3.setHTML(1, 0, "Nom");
//	    layout3.setWidget(1, 1, txtNomFournisseur);
//	    layout3.setHTML(2, 0, "Adresse");
//	    layout3.setWidget(2, 1, txtAdresseFournisseur);
//	    layout3.setHTML(3,0,"Numero de telephone");
//	    layout3.setWidget(3, 1, txtNumTelFournisseur);
//	    layout3.setHTML(4,0,"Numero de fax");
//	    layout3.setWidget(4, 1, txtFaxFournisseur);
//	    layout3.setHTML(5,0,"Email");
//	    layout3.setWidget(5, 1, txtEmailFournisseur);
//	
//
//	    
//
//	    // Wrap the content in a DecoratorPanel
//	    DecoratorPanel decPanel3 = new DecoratorPanel();
//	    decPanel3.setWidget(layout3);
//	    
//	    return decPanel3;
//		
//		
//	}

	
	public Widget createFiche(){
		
		 // Create a table to layout the form options
	    FlexTable layout5 = new FlexTable();
	    layout5.setCellSpacing(6);
	    FlexCellFormatter cellFormatter = layout5.getFlexCellFormatter();

	    // Add a title to the form
	    layout5.setHTML(0, 0, "Fiche");
	    cellFormatter.setColSpan(0, 0, 2);
	    cellFormatter.setHorizontalAlignment(
	        0, 0, HasHorizontalAlignment.ALIGN_CENTER);

	    // Add some standard form options
	    layout5.setHTML(1, 0, "Date de creation");
	    layout5.setWidget(1, 1, txtDateCreation);
	    layout5.setHTML(2, 0, "Etat de fiche");
	    layout5.setWidget(2, 1, txtEtatFiche);
	    layout5.setHTML(3, 0, "Commentaire");
	    layout5.setWidget(3, 1, txtAriaCommEtatFiche);
	    



	    // Wrap the content in a DecoratorPanel
	    DecoratorPanel decPanel5 = new DecoratorPanel();
	    decPanel5.setWidget(layout5);
	    
	    return decPanel5;
	    
	}
	
	
public Widget asWidget() {
    return this;
  }

//Getter TextBox
public HasValue<String> getTxtNom() {
	return txtNom;
}



public HasValue<String> getTxtPrenom() {
	return txtPrenom;
}



public HasValue<String> getTxtAdresse() {
	return txtAdresse;
}



public HasValue<String> getTxtNumTelPort() {
	return txtNumTelPort;
}


public HasValue<String> getTxtNumTelFix() {
	return txtNumTelFix;
}


public HasValue<String> getTxtEmail() {
	return txtEmail;
}


public HasValue<String> getTxtMotPasse() {
	return txtMotPasse;
}


public HasValue<String> getTxtModele() {
	return txtModele;
}


public HasValue<String> getTxtMarque() {
	return txtMarque;
}


public HasValue<String> getTxtNumeroSerie() {
	return txtNumeroSerie;
}


//public HasValue<String> getTxtNomFournisseur() {
//	return txtNomFournisseur;
//}
//
//public HasValue<String> getTxtAdresseFournisseur() {
//	return txtAdresseFournisseur;
//}
//
//
//public HasValue<String> getTxtNumTelFournisseur() {
//	return txtNumTelFournisseur;
//}
//
//public TextBox getTxtFaxFournisseur() {
//	return txtFaxFournisseur;
//}
//
//public HasValue<String> getTxtEmailFournisseur() {
//	return txtEmailFournisseur;
//}


public HasClickHandlers getBtnAssigner(){
	return btnAssigner;
}

public void setLblResAffiche(String ResAffich){
	lblResAffich.setText(ResAffich);
}

public HasValue<String> getTxtAriaDescriptionPanne() {
	return txtAriaDescriptionPanne;
}

public HasValue<String> getTxtAriaCommEtatFiche() {
	return txtAriaCommEtatFiche;
}

public HasValue<String> getTxtGarantie(){
	return txtGarantie;
}

public HasValue<String> getTxtEtatFiche(){
	return txtEtatFiche;
}


public HasValue<String> getTxtDateCreation() {
	return txtDateCreation;
}

public void setDataAffiche(JSONArray data){
	JSONObject jsonObject = new JSONObject();
	for (int i = 0 ; i < data.size() ; i++){

		jsonObject =  data.get(i).isObject();


		if(jsonObject != null){
			getTxtNom().setValue(jsonObject.get("nom_Client").isString().stringValue());
			getTxtPrenom().setValue(jsonObject.get("prenom_client").isString().stringValue());
			getTxtAdresse().setValue(jsonObject.get("adresse").isString().stringValue());
			getTxtNumTelPort().setValue(jsonObject.get("num_tel_port").isString().stringValue());
			getTxtNumTelFix().setValue(jsonObject.get("num_tel_fix").isString().stringValue());
			getTxtEmail().setValue(jsonObject.get("email").isString().stringValue());
			getTxtMotPasse().setValue(jsonObject.get("mot_passe").isString().stringValue());
			getTxtModele().setValue(jsonObject.get("modele").isString().stringValue());
			getTxtMarque().setValue(jsonObject.get("marque").isString().stringValue());
			getTxtNumeroSerie().setValue(jsonObject.get("numero_serie").isString().stringValue());
			getTxtGarantie().setValue(jsonObject.get("statut_materiel").isString().stringValue());
			getTxtEtatFiche().setValue(jsonObject.get("nom_etat").isString().stringValue());
			getTxtAriaDescriptionPanne().setValue(jsonObject.get("description_panne").isString().stringValue());
			getTxtDateCreation().setValue(jsonObject.get("date_creation_fiche").isString().stringValue());
			txtDateCreation.setEnabled(false);
			getTxtAriaCommEtatFiche().setValue(jsonObject.get("commentaire_etat").isString().stringValue());
			
		}
	}
}



}