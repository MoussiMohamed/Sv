package com.mytek.savonline.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mytek.savonline.client.presenter.AddEmployePresenter;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.DateLabel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.ValuePicker;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;

public class AddEmployeView extends Composite implements AddEmployePresenter.Display{
	public AbsolutePanel absolutePanel;
	public final IntegerBox intNTelPort,intNTelFix;
	public final DecoratorPanel decP;
	public final TextBox txtNom,txtPrenom,txtAdresse,txtEmail,txtPwd;
	public final Button btnCancel,btnAdd;
	public Label lblErrNom,lblErrPrenom,lblErrAdresse,lblErrNTelPort,lblErrNTelFix,lblErrEmail,lblErrPwd;
	public AddEmployeView() {
		decP=new DecoratorPanel();

		absolutePanel = new AbsolutePanel();
		absolutePanel.setSize("397px", "354px");
		Label lblAddEmploye = new Label("Fiche de technicien");
		lblAddEmploye.setStyleName("gwt-LabelAddEmloye");
		absolutePanel.add(lblAddEmploye, 113, 10);
		lblAddEmploye.setSize("163px", "22px");
		
		btnAdd = new Button("Add");
		btnAdd.setText("Ajouter");
		absolutePanel.add(btnAdd, 110, 320);
		btnAdd.setSize("54px", "24px");
		
		btnCancel = new Button("Cancel");
		btnCancel.setText("Annuler");
		absolutePanel.add(btnCancel, 170, 320);
		
		FlexTable flexTable = new FlexTable();
		
		flexTable.setSize("316px", "255px");
		
		Label lblNom = new Label("Nom *");
		flexTable.setWidget(0, 0, lblNom);
		lblNom.setWidth("125px");
		flexTable.getCellFormatter().setVerticalAlignment(0, 0, HasVerticalAlignment.ALIGN_MIDDLE);
		
		txtNom = new TextBox();
		flexTable.setWidget(0, 1, txtNom);
		
		lblErrNom = new Label("");
		flexTable.setWidget(0, 8, lblErrNom);
		
		Label lblPrenom = new Label("Prenom *");
		flexTable.setWidget(1, 0, lblPrenom);
		
		txtPrenom = new TextBox();
		flexTable.setWidget(1, 1, txtPrenom);
		
		lblErrPrenom = new Label("");
		flexTable.setWidget(1, 7, lblErrPrenom);
		
		Label lblAdresse = new Label("Adresse *");
		flexTable.setWidget(2, 0, lblAdresse);
		
		txtAdresse = new TextBox();
		flexTable.setWidget(2, 1, txtAdresse);
		
		lblErrAdresse = new Label("");
		flexTable.setWidget(2, 6, lblErrAdresse);
		
		Label lblNTelportable = new Label("N\u00B0 Tel-portable *");
		flexTable.setWidget(3, 0, lblNTelportable);
		
		intNTelPort = new IntegerBox();
		flexTable.setWidget(3, 1, intNTelPort);
		
		lblErrNTelPort = new Label("");
		flexTable.setWidget(3, 5, lblErrNTelPort);
		
		Label lblNTelfix = new Label("N\u00B0 Tel-fix *");
		flexTable.setWidget(4, 0, lblNTelfix);
		
		intNTelFix = new IntegerBox();
		flexTable.setWidget(4, 1, intNTelFix);
		
		lblErrNTelFix = new Label("");
		flexTable.setWidget(4, 4, lblErrNTelFix);
		
		Label lblEmail = new Label("Email *");
		flexTable.setWidget(5, 0, lblEmail);
		
		txtEmail = new TextBox();
		flexTable.setWidget(5, 1, txtEmail);
		
		lblErrEmail = new Label("");
		flexTable.setWidget(5, 3, lblErrEmail);
		
		Label lblPassword = new Label("Password *");
		flexTable.setWidget(6, 0, lblPassword);
		
		txtPwd = new TextBox();
		flexTable.setWidget(6, 1, txtPwd);
		flexTable.getCellFormatter().setVerticalAlignment(1, 7, HasVerticalAlignment.ALIGN_BOTTOM);
		flexTable.getCellFormatter().setHorizontalAlignment(1, 7, HasHorizontalAlignment.ALIGN_LEFT);
		
		lblErrPwd = new Label("");
		flexTable.setWidget(6, 2, lblErrPwd);
		absolutePanel.add(flexTable, 22, 38);
		initWidget(absolutePanel);
	}
	
	public Widget asWidget() {
	    return this;
	  }

	public HasValue<Integer> getIntNTelPort() {
		return intNTelPort;
	}

	public HasValue<Integer> getIntNTelFix() {
		return intNTelFix;
	}

	public HasValue<String> getTxtNom() {
		return txtNom;
	}

	public HasValue<String> getTxtPrenom() {
		return txtPrenom;
	}

	public HasValue<String> getTxtAdresse() {
		return txtAdresse;
	}

	public HasValue<String> getTxtEmail() {
		return txtEmail;
	}

	public HasValue<String> getTxtPwd() {
		return txtPwd;
	}
	public HasClickHandlers getbtnAdd() {
		return btnAdd;
	}
	public HasClickHandlers getbtnCancel() {
		return btnCancel;
	}
	public Label getlblErrNom(){
		return lblErrNom;
	}
	public Label getlblErrPrenom(){
		return lblErrPrenom;
	}
	public Label getlblErrAdresse(){
		return lblErrAdresse;
	}
	public Label getlblErrNTelPort(){
		return lblErrNTelPort;
	}
	public Label getlblErrNTelFix(){
		return lblErrNTelFix;
	}
	public Label getlblErrEmail(){
		return lblErrEmail;
	}
	public Label getlblErrPwd(){
		return lblErrPwd;
	}
}
