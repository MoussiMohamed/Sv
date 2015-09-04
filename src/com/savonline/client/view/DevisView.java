package com.savonline.client.view;

import javax.swing.text.html.ListView;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.resources.css.ast.CssProperty.StringValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DialogBox;
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
import com.savonline.client.presenter.DevisPresenter;

public class DevisView extends Composite implements DevisPresenter.Display{
	
	private final Button btnValiderDevis,btnAnnulerDevis;
	DialogBox boitDialog;
	private Label lblRapport,lblDevis,lblIdFiche,lblCommentDevis;
	private final TextArea txtAriaRapport,txtAriaDevis,txtAriaCommentaire;
	
	
	public DevisView() {

		lblRapport=new Label();
		lblDevis=new Label();
		lblCommentDevis=new Label();
		lblIdFiche=new Label();
		
		txtAriaCommentaire=new TextArea();
		txtAriaCommentaire.setPixelSize(600, 150);
		txtAriaDevis=new TextArea();
		txtAriaDevis.setPixelSize(600, 150);
		txtAriaRapport=new TextArea();
		txtAriaRapport.setPixelSize(600, 150);
		
		btnValiderDevis=new Button("Valider");
		btnAnnulerDevis=new Button("Annuler");
		
		boitDialog=new DialogBox();
		boitDialog.setGlassEnabled(true);
		boitDialog.setAnimationEnabled(true);
		boitDialog.center();
		boitDialog.show();
		boitDialog.setText("Devis d intervention");
		boitDialog.add(createRapport());
	
			initWidget(boitDialog);

}



	public Widget createRapport(){
		
		 // Create a table to layout the form options
	    FlexTable layoutDevis = new FlexTable();
	    layoutDevis.setCellSpacing(6);
	    FlexCellFormatter cellFormatter = layoutDevis.getFlexCellFormatter();

	    // Add a title to the form
	    layoutDevis.setHTML(0, 0, "Devis d intervention");
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
	    
	    layoutDevis.setWidget(5, 1, btnAnnulerDevis);
	    
	    
	    // Wrap the content in a DecoratorPanel
	    DecoratorPanel decPanel = new DecoratorPanel();
	    decPanel.setWidget(layoutDevis);
	    
	    return decPanel;
		
		
	}
	
	

public Widget asWidget() {
    return this;
  }



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



public HasClickHandlers getBtnAnnulerDevis() {
	return btnAnnulerDevis;
}

public DialogBox getBoitDialog(){
	return boitDialog;
}
}