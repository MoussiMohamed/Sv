package com.mytek.savonline.client.view;

import com.google.gwt.core.client.GWT;
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
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.mytek.savonline.client.presenter.AddFichePresenter;

public class AddFicheView extends Composite implements AddFichePresenter.Display{
	

	private  Button btnAjouter,btnAnnuler;
	 private  FlexTable flexTableContainerAll;
	 private  TextBox txtNom,txtPrenom,txtAdresse,txtNumTelPort,txtNumTelFix,txtEmail,txtMotPasse;
	 private Label lnom,lprenom,ladresse,lnumTelPort,lnumTelFix,lemail,Lpassword,lmodele,lmarque,lnumSerie,lstatut,lcommentaire,ldescriptionPanne,laccessoire,lremarque,letat,lObservation;
	

	private  TextBox txtModele,txtMarque,txtNumeroSerie;
	private  TextArea txtAriaDescriptionPanne,txtAriaCommEtatFiche,txtAriaAccessoires,txtAriaRemarque,txtAriaObservation/*,txtAriaInformationComplementaire*/;
	private  ListBox lstGarantie,lstEtatFiche;
	


//	private  TextBox txtDateCreation;
	// private final TextBox txtNomFournisseur,txtAdresseFournisseur,txtNumTelFournisseur,txtFaxFournisseur,txtEmailFournisseur;
	 
	 

	private  FlexTable flexTableAll;	
	 private  Label lblResultInsert;
	public AddFicheView() {
		
		//creattion de Label
		lnom=new Label();
		lprenom=new Label();
		ladresse=new Label();
		lnumTelPort=new Label();
		lnumTelFix=new Label();
		lemail=new Label();
		Lpassword=new Label();
		lmodele=new Label();
		lmarque=new Label();
		lnumSerie=new Label();
		lstatut=new Label();
		lcommentaire=new Label();
		ldescriptionPanne=new Label();
		laccessoire=new Label("");
		
		
		//creation de textAriaDescriptionPanne
		txtAriaDescriptionPanne=new TextArea();
		txtAriaCommEtatFiche=new TextArea();
		txtAriaAccessoires=new TextArea();
		txtAriaRemarque=new TextArea();
		txtAriaObservation=new TextArea();
		//txtAriaInformationComplementaire=new TextArea();
		
		//creation de TextBox de date de creation de fiche
//		txtDateCreation=new TextBox();
		
		//creattion de label de resultat d insertion
		lblResultInsert=new Label();
		
		//creation de TextBoxClient
		txtNom=new TextBox();
		txtPrenom=new TextBox();
		txtAdresse=new TextBox();
		txtNumTelPort=new TextBox();
		txtNumTelFix=new TextBox();
		txtEmail=new TextBox();
		txtMotPasse=new TextBox();
		
		//creation de TextBoxMateriel
		txtModele=new TextBox();
		txtMarque=new TextBox();
		txtNumeroSerie=new TextBox();
		
//		//creation de TextBoxFournisseur
//		txtNomFournisseur=new TextBox();
//		txtAdresseFournisseur=new TextBox();
//		txtNumTelFournisseur=new TextBox();
//		txtFaxFournisseur=new TextBox();
//		txtEmailFournisseur=new TextBox();
		
		//creation de ListBox de garantie & Statut de materiel
		lstGarantie=new ListBox();
		lstGarantie.addItem("---");
		lstGarantie.addItem("Oui");
		lstGarantie.addItem("Non");
		lstEtatFiche=new ListBox();
		lstEtatFiche.addItem("Reception");
		lstEtatFiche.addItem("En cours de diagnostique");
		lstEtatFiche.addItem("Materiel chez le fournisseur");
		lstEtatFiche.addItem("Sous devis");
		lstEtatFiche.addItem("Reparation");
		lstEtatFiche.addItem("Sortie");
		lstEtatFiche.addItem("Preleve");
		
		
		//creation de FlexTable
		flexTableContainerAll=new FlexTable();
		flexTableContainerAll.setCellPadding(15);
		flexTableContainerAll.setCellPadding(10);
		btnAjouter=new Button("Ajouter");
		btnAnnuler=new Button("Annuler");
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
flexTableAll.setWidget(2, 0, createFiche());
flexTableAll.setWidget(1, 1, createMateriel());

//flexTableAll.setWidget(2, 1, createFournisseur());
flexTableAll.setWidget(3, 0, btnAjouter);
flexTableAll.setWidget(3, 1, btnAnnuler);
flexTableAll.setWidget(3, 2, lblResultInsert);
FlexCellFormatter cellFormatterContainerAll = flexTableContainerAll.getFlexCellFormatter();
flexTableContainerAll.setCellSpacing(10);
cellFormatterContainerAll.setHorizontalAlignment(0, 0, HasAlignment.ALIGN_CENTER);
flexTableContainerAll.setWidget(0, 0, flexTableAll);
DecoratorPanel decPanelContainerAll =new DecoratorPanel();
decPanelContainerAll.setPixelSize(1023, 590);
decPanelContainerAll.add(flexTableContainerAll);

			initWidget(decPanelContainerAll);
			
		   
//String s=lstGarantie.getItemText(0);
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
	    layout.setWidget(1, 2, lnom);
	    layout.setHTML(2, 0, "Prenom");
	    layout.setWidget(2, 1, txtPrenom);
	    layout.setWidget(2, 2, lprenom);
	    layout.setHTML(3,0,"Adresse");
	    layout.setWidget(3, 1, txtAdresse);
	    layout.setWidget(3, 2, ladresse);
	    layout.setHTML(4,0,"Numero de telephone portable");
	    layout.setWidget(4, 1,txtNumTelPort);
	    layout.setWidget(4, 2,lnumTelPort);
	    layout.setHTML(5,0,"Numero de telephone fix");
	    layout.setWidget(5, 1, txtNumTelFix);
	    layout.setWidget(5, 2, lnumTelFix);
	    layout.setHTML(6,0,"Email");
	    layout.setWidget(6, 1, txtEmail);
	    layout.setWidget(6, 2, lemail);
	    layout.setHTML(7,0,"Mot de passe");
	    layout.setWidget(7, 1,txtMotPasse);
	    layout.setWidget(7, 2,Lpassword);
	    

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
	    layout2.setWidget(1, 2, lmodele);
	    layout2.setHTML(2, 0, "Marque");
	    layout2.setWidget(2, 1, txtMarque);
	    layout2.setWidget(2, 2, lmarque);
	    layout2.setHTML(3,0,"Numero de serie");
	    layout2.setWidget(3, 1, txtNumeroSerie);
	    layout2.setWidget(3, 2, lnumSerie);
	    layout2.setHTML(4,0,"Garantie");
	    layout2.setWidget(4, 1, lstGarantie);
	    layout2.setWidget(4, 2, lstatut);
	    layout2.setHTML(5,0,"Description de panne");
	    layout2.setWidget(5, 1, txtAriaDescriptionPanne);
	    layout2.setWidget(5, 2, ldescriptionPanne);
	    layout2.setHTML(6,0,"Accessoires");
	    layout2.setWidget(6, 1, txtAriaAccessoires);
	    layout2.setHTML(7,0,"Remarques");
	    layout2.setWidget(7, 1, txtAriaRemarque);

//	    layout2.setHTML(6,0,"Information complementaire");
//	    layout2.setWidget(6, 1, txtAriaInformationComplementaire);
	    
	    
	

	    

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
//	    layout5.setHTML(1, 0, "Date de creation");
//	    layout5.setWidget(1, 1, txtDateCreation);
	    layout5.setHTML(1, 0, "Etat de fiche");
	    layout5.setWidget(1, 1, lstEtatFiche);
	    layout5.setHTML(2, 0, "Commentaire");
	    layout5.setWidget(2, 1, txtAriaCommEtatFiche);
	    layout5.setWidget(2, 2, ldescriptionPanne);
	    layout5.setHTML(3, 0, "Observation");
	    layout5.setWidget(3, 1, txtAriaObservation);



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


public HasClickHandlers getBtnAddFicheRec(){
	return btnAjouter;
}
public HasClickHandlers getBtnAnnuler(){
	return btnAnnuler;
}
public void setLblResultInsert(String resultInsert){
	lblResultInsert.setText(resultInsert);
}
public HasValue<String> getTxtAriaDescriptionPanne() {
	return txtAriaDescriptionPanne;
}


//public HasValue<String> getTxtAriaInformationComplementaire() {
//	return txtAriaInformationComplementaire;
//}



public HasValue<String> getTxtAriaCommEtatFiche() {
	return txtAriaCommEtatFiche;
}



public String getLstGarantie() {
    
    return lstGarantie.getValue(lstGarantie.getSelectedIndex());
    
    
  }
public String getLstEtatFiche() {
	return lstEtatFiche.getValue(lstEtatFiche.getSelectedIndex());
}

//public HasValue<String> getTxtDateCreation() {
//	return txtDateCreation;
//}

public void setDataEdit(JSONArray data){
	JSONObject jsonObject = new JSONObject();
	for (int i = 0 ; i < data.size() ; i++){

		jsonObject =  data.get(i).isObject();
		Resources resources = GWT.create(Resources.class);
		Image imgBtnEdit = new Image(resources.editBtn());
		Image imgBtnDelete = new Image(resources.delBtn());

		if(jsonObject != null){
//			getTxtNom().setValue(jsonObject.get("nom_Client").isString().stringValue());
//			txtPrenom.setText(jsonObject.get("prenom_client").isString().stringValue());
//			txtAdresse.setText(jsonObject.get("adresse").isString().stringValue());
//			txtNumTelPort.setText(jsonObject.get("num_tel_port").isString().stringValue());
//			txtNumTelFix.setText(jsonObject.get("num_tel_fix").isString().stringValue());
//			txtEmail.setText(jsonObject.get("email").isString().stringValue());
//			txtMotPasse.setText(jsonObject.get("mot_passe").isString().stringValue());
//			txtModele.setText(jsonObject.get("modele").isString().stringValue());
//			txtMarque.setText(jsonObject.get("marque").isString().stringValue());
//			txtNumeroSerie.setText(jsonObject.get("numero_serie").isString().stringValue());
//			lstGarantie.setItemText(0,jsonObject.get("statut_materiel").isString().stringValue());
//			txtAriaDescriptionPanne.setText(jsonObject.get("description_panne").isString().stringValue());
//			txtDateCreation.setText(jsonObject.get("date_creation_fiche").isString().stringValue());
//			lstEtatFiche.setItemText(0,jsonObject.get("nom_etat").isString().stringValue());
//			txtAriaCommEtatFiche.setText(jsonObject.get("commentaire_etat").isString().stringValue());
		}
	}
}



public void setLnom(String lnom) {
	this.lnom.setText(lnom);
}



public void setLprenom(String lprenom) {
	this.lprenom.setText(lprenom);
}



public void setLadresse(String ladresse) {
	this.ladresse.setText(ladresse);
}



public void setLnumTelPort(String lnumTelPort) {
	this.lnumTelPort.setText(lnumTelPort);
}



public void setLnumTelFix(String lnumTelFix) {
	this.lnumTelFix.setText(lnumTelFix);
}



public void setLemail(String lemail) {
	this.lemail.setText(lemail);
}



public void setLpassword(String lpassword) {
	Lpassword.setText(lpassword);
}



public void setLmodele(String lmodele) {
	this.lmodele.setText(lmodele);
}



public void setLmarque(String lmarque) {
	this.lmarque.setText(lmarque);
}



public void setLnumSerie(String lnumSerie) {
	this.lnumSerie.setText(lnumSerie);
}

public void setLdescriptionPanne(String ldescriptionPanne){
	this.ldescriptionPanne.setText(ldescriptionPanne);
}


public void setLstatut(String lstatut) {
	this.lstatut.setText(lstatut);
}



public void setLcommentaire(String lcommentaire) {
	this.lcommentaire.setText(lcommentaire);
}



public HasValue<String> getTxtAriaAccessoires() {
	return txtAriaAccessoires;
}



public HasValue<String> getTxtAriaRemarque() {
	return txtAriaRemarque;
}




public HasValue<String> getTxtAriaObservation() {
	return txtAriaObservation;
}






}