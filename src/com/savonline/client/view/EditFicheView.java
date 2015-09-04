package com.savonline.client.view;

import javax.swing.text.html.ListView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.resources.css.ast.CssProperty.StringValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.savonline.client.presenter.EditFichePresenter;

public class EditFicheView extends Composite implements EditFichePresenter.Display{
	private final Button btnValiderDevis,btnModifier,btnFermer;
	private final DialogBox boitDialog;
	private Label lblRapport,lblDevis,lblIdFiche,lblCommentDevis;
	private final TextArea txtAriaRapport,txtAriaDevis,txtAriaCommentaire;
private FlexTable flexDevis;
	private  Button btnValider,btnAnnuler,btnAssigner,btnCreateDevis;
	 private  FlexTable flexTableContainerAll;
	 private  TextBox txtNom,txtPrenom,txtAdresse,txtNumTelPort,txtNumTelFix,txtEmail,txtMotPasse;
	 private Label lnom,lprenom,ladresse,lnumTelPort,lnumTelFix,lemail,Lpassword,lmodele,lmarque,lnumSerie,lstatut,lcommentaire,ldescriptionPanne;
	private  TextBox txtModele,txtMarque,txtNumeroSerie,txtRaye,txtSubitUnChoc,txtVisOuvert;
	private  TextArea txtAriaDescriptionPanne,txtAriaCommEtatFiche,txtAriaAccessoires,txtAriaRemarque,txtAriaObservation/*,txtAriaInformationComplementaire*/;
	private  ListBox lstGarantie,lstEtatFiche,lstTechnicien;
	private Label lbltitreDevis,lblTitreRapport,lblTitreComment,lblTitreIdDevis;
	private TextArea txtRapport,txtDevis,txtCommentaireDevis;
	private TextBox txtIdDevis;
	private Image imgBtnEdit;
	private Label lblIdDevis;

	private  TextBox txtDateCreation; 
	private  FlexTable flexTableAll;	
	private  Label lblResultInsert;
	
	
	public EditFicheView() {
		lblIdDevis=new Label();
		txtIdDevis=new TextBox();
		txtIdDevis.setEnabled(false);
		lblTitreIdDevis=new Label();
		
		flexDevis=new FlexTable();
		//DevisView
		lblRapport=new Label();
		lblDevis=new Label();
		lblCommentDevis=new Label();
		lblIdFiche=new Label();
		boitDialog=new DialogBox();
		boitDialog.setPopupPosition(120, 60);
		boitDialog.setHTML("Devis de diagnostique");
		boitDialog.setAnimationEnabled(true);
		boitDialog.setGlassEnabled(true);
		boitDialog.center();
		//boitDialog.setStyleName("dialogBoxCenter");
		btnFermer=new Button("Fermer");
		txtAriaCommentaire=new TextArea();
		txtAriaCommentaire.setPixelSize(300, 100);
		txtAriaAccessoires= new TextArea();
		txtAriaAccessoires.setHeight("30px");
		txtAriaRemarque = new TextArea();	
		txtAriaRemarque.setHeight("30px");
		txtAriaObservation = new TextArea();
		txtAriaObservation.setHeight("30px");
		txtAriaDevis=new TextArea();
		txtAriaDevis.setPixelSize(300, 100);
		txtAriaRapport=new TextArea();
		txtAriaRapport.setPixelSize(300, 100);
		btnValiderDevis=new Button("Valider");
		btnModifier=new Button("Modifier");
		boitDialog.add(createRapport());
		boitDialog.hide();
	    
		
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
		
				//affichage de Devis
				txtRapport=new TextArea();
				txtRapport.setHeight("30px");
//				txtRapport.setPixelSize(270, 70);
				txtRapport.setEnabled(false);
				txtDevis=new TextArea();
				txtDevis.setHeight("30px");
//				txtDevis.setPixelSize(270, 70);
				txtDevis.setEnabled(false);
				txtCommentaireDevis=new TextArea();
				txtCommentaireDevis.setHeight("30px");
//				txtCommentaireDevis.setPixelSize(270, 70);
				txtCommentaireDevis.setEnabled(false);
				lblTitreRapport=new Label();
				lbltitreDevis=new Label();
				lblTitreComment=new Label();
				
		//creation de textAriaDescriptionPanne
		txtAriaDescriptionPanne=new TextArea();
		txtAriaDescriptionPanne.setHeight("30px");
		txtAriaCommEtatFiche=new TextArea();
		txtAriaCommEtatFiche.setHeight("30px");
		//txtAriaInformationComplementaire=new TextArea();
		
		//creation de TextBox de date de creation de fiche
		txtDateCreation=new TextBox();
		txtDateCreation.setEnabled(false);
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
		
		//creation de button devis:
		btnCreateDevis=new Button("Creer devis");
		
		//creation de TextBoxMateriel
		txtModele=new TextBox();
		txtMarque=new TextBox();
		txtNumeroSerie=new TextBox();
		txtRaye=new TextBox();
		txtSubitUnChoc=new TextBox();
		txtVisOuvert=new TextBox();
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
		lstEtatFiche.addItem("en attente de traitement");
		lstEtatFiche.addItem("Ouvert");
		lstEtatFiche.addItem("En cours de verification");
		lstEtatFiche.addItem("En attante de confirmation de devis");
		lstEtatFiche.addItem("En cours de reparaion");
		lstEtatFiche.addItem("reparation termine");
		lstEtatFiche.addItem("Ferme");
		
		lstTechnicien=new ListBox();
		
		//creation de FlexTable
		flexTableContainerAll=new FlexTable();
		flexTableContainerAll.setCellPadding(15);
		flexTableContainerAll.setCellPadding(10);
		btnValider=new Button("Valider");
		btnAnnuler=new Button("Annuler");
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
flexTableAll.setWidget(1, 1, createMateriel());
flexTableAll.setWidget(1, 2, createAssignation());
flexTableAll.setWidget(2, 0, createFiche());
flexTableAll.setWidget(2, 1, createAffichageDevis());
flexTableAll.setWidget(2, 2, createInfoSuppl());
flexTableAll.setWidget(3, 0, btnValider);
flexTableAll.setWidget(3, 1, btnAnnuler);

FlexCellFormatter cellFormatterContainerAll = flexTableContainerAll.getFlexCellFormatter();
flexTableContainerAll.setCellSpacing(10);
cellFormatterContainerAll.setHorizontalAlignment(0, 0, HasAlignment.ALIGN_CENTER);
flexTableContainerAll.setWidget(0, 0, flexTableAll);
DecoratorPanel decPanelContainerAll =new DecoratorPanel();
decPanelContainerAll.setPixelSize(1023, 600);
decPanelContainerAll.add(flexTableContainerAll);

			initWidget(decPanelContainerAll);
			
		   
//String s=lstGarantie.getItemText(0);
}


	public Widget createRapport(){
		
		 // Create a table to layout the form options
	    FlexTable layoutDevis = new FlexTable();
	    layoutDevis.setCellSpacing(6);
	    FlexCellFormatter cellFormatter = layoutDevis.getFlexCellFormatter();

	    // Add a title to the form
	    layoutDevis.setHTML(0, 0, "");
	    cellFormatter.setColSpan(0, 0, 2);
	
	    cellFormatter.setHorizontalAlignment(
	        0, 0, HasHorizontalAlignment.ALIGN_CENTER);

	    // Partie Client
	    layoutDevis.setWidget(1, 0, lblIdFiche);
	    layoutDevis.setWidget(1, 1, lblCommentDevis);
	    layoutDevis.setHTML(2, 0, "Rapport de diagnostique");
	    layoutDevis.setWidget(2, 1, txtAriaRapport);
	    layoutDevis.setHTML(3, 0, "Devis de reparation");
	    layoutDevis.setWidget(3, 1, txtAriaDevis);
	    layoutDevis.setHTML(4, 0, "Commentaire");
	    layoutDevis.setWidget(4, 1, txtAriaCommentaire);
	    layoutDevis.setWidget(5, 0, btnValiderDevis);
	    layoutDevis.setWidget(5, 1, btnModifier);
	    layoutDevis.setWidget(5, 2, btnFermer);
	    cellFormatter.setHorizontalAlignment(5, 0, HasHorizontalAlignment.ALIGN_RIGHT);
	    cellFormatter.setHorizontalAlignment(5, 1, HasHorizontalAlignment.ALIGN_LEFT);
	    cellFormatter.setHorizontalAlignment(5, 2, HasHorizontalAlignment.ALIGN_LEFT);
	    
	    // Wrap the content in a DecoratorPanel
	   
	    return layoutDevis;
		
		
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
	    

	    // Wrap the content in a DecoratorPanel
	    DecoratorPanel decPanel2 = new DecoratorPanel();
	    decPanel2.setWidget(layout2);
	    
	    return decPanel2;
		
		
	}
	
	public Widget createInfoSuppl(){
		
		 // Create a table to layout the form options
	    FlexTable layout6 = new FlexTable();
	    layout6.setCellSpacing(6);
	    FlexCellFormatter cellFormatter = layout6.getFlexCellFormatter();

	    // Add a title to the form
	    layout6.setHTML(0, 0, "Informations supplementaires");
	    cellFormatter.setColSpan(0, 0, 2);
	    cellFormatter.setHorizontalAlignment(
	        0, 0, HasHorizontalAlignment.ALIGN_CENTER);

	   
	    layout6.setHTML(1,0,"Raye");
	    layout6.setWidget(1, 1, txtRaye);
	    layout6.setHTML(2,0,"A Subit un Choc Apparent");
	    layout6.setWidget(2, 1, txtSubitUnChoc);
	    layout6.setHTML(3,0,"Vis Ouvert");
	    layout6.setWidget(3, 1, txtVisOuvert);
	    


	    // Wrap the content in a DecoratorPanel
	    DecoratorPanel decPanel6 = new DecoratorPanel();
	    decPanel6.setWidget(layout6);
	    
	    return decPanel6;
	    
	}
	

	
	//assignation fiche
	public Widget createAssignation(){
		
		 // Create a table to layout the form options
	    FlexTable layoutAssignation = new FlexTable();
	    layoutAssignation.setCellSpacing(6);
	    FlexCellFormatter cellFormatter = layoutAssignation.getFlexCellFormatter();

	    // Add a title to the form
	    layoutAssignation.setHTML(0, 0, "Assignation de fiche");
	    cellFormatter.setColSpan(0, 0, 2);
	    cellFormatter.setHorizontalAlignment(
	        0, 0, HasHorizontalAlignment.ALIGN_CENTER);
	    cellFormatter.setHorizontalAlignment(
		        2, 0, HasHorizontalAlignment.ALIGN_CENTER);
	    cellFormatter.setColSpan(2, 0, 2);
	    // Add some standard form options
	    layoutAssignation.setHTML(1, 0, "Technicien");
	    layoutAssignation.setWidget(1, 1, lstTechnicien);
	    layoutAssignation.setWidget(2, 0, btnAssigner);

	    // Wrap the content in a DecoratorPanel
	    DecoratorPanel decPanelAssignation = new DecoratorPanel();
	    decPanelAssignation.setWidget(layoutAssignation);
	    
	    return decPanelAssignation;
		
		
	}


	
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
	    layout5.setWidget(2, 1, lstEtatFiche);
	    layout5.setHTML(3, 0, "Commentaire");
	    layout5.setWidget(3, 1, txtAriaCommEtatFiche);
	    layout5.setWidget(3, 2, ldescriptionPanne);
	    layout5.setHTML(4, 0, "Observation");
	    layout5.setWidget(4, 1, txtAriaObservation);
	    cellFormatter.setColSpan(5, 0, 3);
	    



	    // Wrap the content in a DecoratorPanel
	    DecoratorPanel decPanel5 = new DecoratorPanel();
	    decPanel5.setWidget(layout5);
	    
	    return decPanel5;
	    
	}
	
	public Widget createAffichageDevis(){
		
		
		flexDevis.setCellSpacing(5);
		
		
	    FlexCellFormatter cellFormatterDevis = flexDevis.getFlexCellFormatter();
	    cellFormatterDevis.setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);
	    cellFormatterDevis.setHorizontalAlignment(0, 1, HasHorizontalAlignment.ALIGN_CENTER);
	    cellFormatterDevis.setHorizontalAlignment(0, 2, HasHorizontalAlignment.ALIGN_CENTER);
	    cellFormatterDevis.setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_CENTER);
	    cellFormatterDevis.setHorizontalAlignment(1, 1, HasHorizontalAlignment.ALIGN_CENTER);
	    cellFormatterDevis.setHorizontalAlignment(1, 2, HasHorizontalAlignment.ALIGN_CENTER);
	    cellFormatterDevis.setHorizontalAlignment(4, 1, HasHorizontalAlignment.ALIGN_RIGHT);
	    flexDevis.setWidget(0, 0, lblTitreIdDevis);
	    flexDevis.setWidget(0, 1, lblIdDevis );
	    flexDevis.setWidget(1, 0, lblTitreRapport);
	    flexDevis.setWidget(1, 1, txtRapport);
	    flexDevis.setWidget(2, 0, lbltitreDevis);
	    flexDevis.setWidget(2, 1, txtDevis);
	    flexDevis.setWidget(3, 0, lblTitreComment);
	    flexDevis.setWidget(3, 1, txtCommentaireDevis);
	    flexDevis.setWidget(4, 0, btnCreateDevis);
	    Resources resources = GWT.create(Resources.class);
	    Image imgBtnEdit = new Image(resources.EditIcon());
		imgBtnEdit.setTitle("Editer");
	    flexDevis.setWidget(4, 1, imgBtnEdit);
	    
	    
	    
		return flexDevis;
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



public void setDataDevis(JSONArray jsonDataDevis){
	JSONObject jsonObjDevis=new JSONObject();
	
	for (int i = 0 ; i < jsonDataDevis.size() ; i++){
		jsonObjDevis=jsonDataDevis.get(i).isObject();
		if (jsonObjDevis.get("id_devis_reparation")!=null ){
			lblTitreIdDevis.setText("Id Devis");
			lblTitreRapport.setText("Rapport");
			lbltitreDevis.setText("Devis");
			lblTitreComment.setText("Commentaire");
			lblIdDevis.setText(jsonObjDevis.get("id_devis_reparation").isString().stringValue());
			txtRapport.setText(jsonObjDevis.get("rapport_diagnostique").isString().stringValue());
			txtDevis.setText(jsonObjDevis.get("devis").isString().stringValue());
			txtCommentaireDevis.setText(jsonObjDevis.get("Commentaire_Devis").isString().stringValue());
			btnCreateDevis.setVisible(false);
		
		}
	}
}



public void setBoitDevis(JSONArray jsonDataDevis){
	JSONObject jsonObjDevis=new JSONObject();
	
	for (int i = 0 ; i < jsonDataDevis.size() ; i++){
		jsonObjDevis=jsonDataDevis.get(i).isObject();
		if (jsonObjDevis.get("id_devis_reparation")!=null ){
			
			txtAriaRapport.setText(jsonObjDevis.get("rapport_diagnostique").isString().stringValue());
			txtAriaDevis.setText(jsonObjDevis.get("devis").isString().stringValue());
			txtAriaCommentaire.setText(jsonObjDevis.get("Commentaire_Devis").isString().stringValue());
			btnCreateDevis.setVisible(false);
		
		}
	}
}

String selectedItem;
public String getClickedRowDevis(ClickEvent event) {
	int selectedRow = -1;
//	Element selectedElement = null;
	HTMLTable.Cell cell = flexDevis.getCellForEvent(event);

	if (cell != null) {
		// Suppress clicks if the user is actually selecting the 
		//  check box
		//
		if (cell.getCellIndex() > 0) {
			selectedRow = cell.getRowIndex();
			
			selectedItem=flexDevis.getWidget(0, 1).getElement().getFirstChild().getNodeValue();
		}
	}

	return selectedItem;
}


public HasClickHandlers getFlexDevis() {
	return flexDevis;
}
public HasClickHandlers getBtnEditFiche(){
	return btnValider;
}
public HasClickHandlers getBtnAnnuler(){
	return btnAnnuler;
}

public HasClickHandlers getBtnAssigner(){
	return btnAssigner;
}

public void setLblResultInsert(String resultInsert){
	lblResultInsert.setText(resultInsert);
}
public HasValue<String> getTxtAriaDescriptionPanne() {
	return txtAriaDescriptionPanne;
}


public HasValue<String> getTxtAriaCommEtatFiche() {
	return txtAriaCommEtatFiche;
}
public void setLstGarantie(String garantie){
	lstGarantie.setItemText(0, garantie);
}

public void setLstEtat(String LstEtat){
	lstEtatFiche.setItemText(0, LstEtat);
	
}

public String getLstGarantie() {
    
    return lstGarantie.getValue(lstGarantie.getSelectedIndex());
    
    
  }

public Button getBtnValiderDevisDisable(){
	return btnValiderDevis;
}


public String getLstEtatFiche() {
	return lstEtatFiche.getValue(lstEtatFiche.getSelectedIndex());
}

public HasValue<String> getTxtDateCreation() {
	return txtDateCreation;
}




public void setLstTechnicien(JSONArray DataTechnicien) {
	JSONObject jsonObjTechnicien=new JSONObject();
	for (int i = 0 ; i < DataTechnicien.size() ; i++){
		jsonObjTechnicien=DataTechnicien.get(i).isObject();
		if(jsonObjTechnicien != null){
			lstTechnicien.addItem(jsonObjTechnicien.get("nom_Emp").isString().stringValue());
			
		}
	}
}

public String getId_Employe(){
	int id=lstTechnicien.getSelectedIndex();
	String idString;
	idString=String.valueOf(id+1);
	return idString;
}




public void setDataEdit(JSONArray data,String TypeElement){
	if (TypeElement.equalsIgnoreCase("Editer")){

	JSONObject jsonObject = new JSONObject();
	for (int i = 0 ; i < data.size() ; i++){
		jsonObject =  data.get(i).isObject();
		if(jsonObject !=null){
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
			setLstGarantie(jsonObject.get("statut_materiel").isString().stringValue());
			setLstEtat(jsonObject.get("nom_etat").isString().stringValue());
			getTxtAriaDescriptionPanne().setValue(jsonObject.get("description_panne").isString().stringValue());
			getTxtDateCreation().setValue(jsonObject.get("date_creation_fiche").isString().stringValue());
			
			getTxtAriaCommEtatFiche().setValue(jsonObject.get("commentaire_etat").isString().stringValue());
			getTxtAriaAccessoires().setValue(jsonObject.get("accessoire").isString().stringValue());
			getTxtAriaRemarque().setValue(jsonObject.get("remarque").isString().stringValue());
			getTxtAriaObservation().setValue(jsonObject.get("observation").isString().stringValue());
			getRaye().setValue(jsonObject.get("raye").isString().stringValue());
			getSubitUnChoc().setValue(jsonObject.get("subit_choc").isString().stringValue());
			getVisOuvert().setValue(jsonObject.get("vis_ouvert").isString().stringValue());
			if (!jsonObject.get("rapport_diagnostique").isString().stringValue().equalsIgnoreCase("") ){
		    		btnCreateDevis.setVisible(true);
			lblTitreIdDevis.setText("Id Devis");
			lblTitreRapport.setText("Rapport");
			lbltitreDevis.setText("Devis");
			lblTitreComment.setText("Commentaire");
			lblIdDevis.setText(jsonObject.get("id_devis_reparation").isString().stringValue());
			txtRapport.setText(jsonObject.get("rapport_diagnostique").isString().stringValue());
			txtDevis.setText(jsonObject.get("devis").isString().stringValue());
			txtCommentaireDevis.setText(jsonObject.get("Commentaire_Devis").isString().stringValue());
			btnCreateDevis.setVisible(false);
			}
		}
			
		
	}
}
	
	else{
		
		JSONObject jsonObject = new JSONObject();
		txtNom.setEnabled(false);
		txtPrenom.setEnabled(false);
		txtAdresse.setEnabled(false);
		txtNumTelPort.setEnabled(false);
		txtNumTelFix.setEnabled(false);
		txtEmail.setEnabled(false);
		txtMotPasse.setEnabled(false);
		txtModele.setEnabled(false);
		txtMarque.setEnabled(false);
		txtNumeroSerie.setEnabled(false);
		lstGarantie.setEnabled(false);
		txtAriaDescriptionPanne.setEnabled(false);
		txtAriaAccessoires.setEnabled(false);
		txtAriaRemarque.setEnabled(false);
		txtAriaObservation.setEnabled(false);
		txtRaye.setEnabled(false);
		txtSubitUnChoc.setEnabled(false);
		txtVisOuvert.setEnabled(false);
		txtDateCreation.setEnabled(false);
		lstEtatFiche.setEnabled(false);
		txtAriaCommEtatFiche.setEnabled(false);
		btnValider.setVisible(false);
		btnAnnuler.setVisible(false);
		btnCreateDevis.setVisible(false);
		
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
				setLstGarantie(jsonObject.get("statut_materiel").isString().stringValue());
				setLstEtat(jsonObject.get("nom_etat").isString().stringValue());
				getTxtAriaDescriptionPanne().setValue(jsonObject.get("description_panne").isString().stringValue());
				getTxtDateCreation().setValue(jsonObject.get("date_creation_fiche").isString().stringValue());
				
				getTxtAriaCommEtatFiche().setValue(jsonObject.get("commentaire_etat").isString().stringValue());
				getTxtAriaAccessoires().setValue(jsonObject.get("accessoire").isString().stringValue());
				getTxtAriaRemarque().setValue(jsonObject.get("remarque").isString().stringValue());
				getTxtAriaObservation().setValue(jsonObject.get("observation").isString().stringValue());
				getRaye().setValue(jsonObject.get("raye").isString().stringValue());
				getSubitUnChoc().setValue(jsonObject.get("subit_choc").isString().stringValue());
				getVisOuvert().setValue(jsonObject.get("vis_ouvert").isString().stringValue());
				
				    if (!jsonObject.get("rapport_diagnostique").isString().stringValue().equalsIgnoreCase("") ){
				    	btnCreateDevis.setVisible(true);
				lblTitreIdDevis.setText("Id Devis");
				lblTitreRapport.setText("Rapport");
				lbltitreDevis.setText("Devis");
				lblTitreComment.setText("Commentaire");
				lblIdDevis.setText(jsonObject.get("id_devis_reparation").isString().stringValue());
				txtRapport.setText(jsonObject.get("rapport_diagnostique").isString().stringValue());
				txtDevis.setText(jsonObject.get("devis").isString().stringValue());
				txtCommentaireDevis.setText(jsonObject.get("Commentaire_Devis").isString().stringValue());
				    }else{
				    	btnCreateDevis.setVisible(false);
				    }
				 
		}
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

public HasClickHandlers getBtnCreateDevis(){
	return btnCreateDevis;
}

//Getter/Setter DialogBoxDevis
public void setLblRapport(String Rapportlbl){
	lblRapport.setText(Rapportlbl);
}



public void setLblDevis(String lDevis) {
	 lblDevis.setText(lDevis);
}



public void setLblIdFiche(String idFiche){
	lblIdFiche.setText("Id Fiche :"+idFiche);
}



public void setLblCommentDevis(String commentaire) {
	lblCommentDevis.setText(commentaire);
}



public HasValue<String> getTxtAriaRapport() {
	return txtAriaRapport;
}



public HasValue<String> getTxtAriaDevis() {
	return txtAriaDevis;
}



public HasValue<String> getTxtAriaCommentaire() {
	return txtAriaCommentaire;
}


public HasClickHandlers getBtnValiderDevis() {
	return btnValiderDevis;
}



public HasClickHandlers getbtnModifierDevis() {
	return btnModifier;
}

public DialogBox getBoitDialog(){
	return boitDialog;
}
public HasClickHandlers getBtnFermer(){
	return btnFermer;
}
public Button getBAssigner(){
	return btnAssigner;
}
public ListBox getLstTechnicien(){
	return lstTechnicien;
}
public Button getBtnAjouterFiche(){
	return btnValider;
}

public Button getBtnModif(){
	return btnModifier;
}

public Button getBtnAnnulerF(){
	return btnAnnuler;
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

public HasValue<String> getRaye() {
	return txtRaye;
}

public HasValue<String> getSubitUnChoc() {
	return txtSubitUnChoc;
}

public HasValue<String> getVisOuvert() {
	return txtVisOuvert;
}

}