package com.mytek.savonline.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.mytek.savonline.client.presenter.AuthentificationPresenter;

public class AuthentificationView extends Composite implements AuthentificationPresenter.Display{

	
	final private FlexTable flexAuthent;
	final private TextBox txtLogin;
	final private PasswordTextBox txtpwd;
	final private Button btnAuthentifier;
	private Label lblErrLogin,lblErrPwd;
	final private CheckBox chBoxOption;
	
	public AuthentificationView(){
		lblErrLogin=new Label();
		lblErrLogin.setStyleName("lblErrorConnexion");
		lblErrPwd=new Label();
		lblErrPwd.setStyleName("lblErrorConnexion");
		chBoxOption=new CheckBox();
		chBoxOption.setHTML("Rester connecte");
		flexAuthent=new FlexTable();
//		flexAuthent.setStyleName("positionAuthentification");
		txtLogin=new TextBox();
		txtLogin.setFocus(true);
		txtpwd=new PasswordTextBox();
		btnAuthentifier=new Button("Connexion");

//		btnAuthentifier.setStyleName("btnConnexion");
		initWidget(authentification());
	}
	
	public Widget authentification(){
		FlexCellFormatter cellFormater = flexAuthent.getFlexCellFormatter();
		cellFormater.setColSpan(0, 0, 3);
		cellFormater.setColSpan(3, 0, 3);
		cellFormater.setColSpan(4, 0, 3);
		cellFormater.setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);
		cellFormater.setHorizontalAlignment(3, 0, HasHorizontalAlignment.ALIGN_CENTER);
		cellFormater.setHorizontalAlignment(4, 0, HasHorizontalAlignment.ALIGN_CENTER);
		flexAuthent.setHTML(0, 0, "Merci de vous identifier pour acceder a l'application");
		flexAuthent.setCellPadding(10);
//		flexAuthent.setCellSpacing(10);
		flexAuthent.setHTML(1, 0, "Login : ");
		flexAuthent.setWidget(1, 1, txtLogin);
		flexAuthent.setWidget(1, 2, lblErrLogin);
		flexAuthent.setHTML(2, 0, "Password");
		flexAuthent.setWidget(2, 1, txtpwd);
		flexAuthent.setWidget(2, 2, lblErrPwd);
		flexAuthent.setWidget(3, 0, chBoxOption);
		flexAuthent.setWidget(4, 0, btnAuthentifier);
		
		DecoratorPanel decPanel=new DecoratorPanel();
		decPanel.add(flexAuthent);
		decPanel.setStyleName("positionAuthentification");
		return decPanel;
	}

	public HasValue<String> getTxtLogin() {
		return txtLogin;
	}

	public HasValue<String> getTxtpwd() {
		return txtpwd;
	}

	public HasClickHandlers getBtnAuthentifier() {
		return btnAuthentifier;
	}

	public String getChBoxOption() {
		return chBoxOption.getText();
	}
	
	public TextBox getTxtBoxLogin(){
		return txtLogin;
	}

	public void setLblErrLogin(String lblErrorLogin) {
		this.lblErrLogin.setText(lblErrorLogin);
	}

	public void setLblErrPwd(String lblErrorPwd) {
		this.lblErrPwd.setText(lblErrorPwd);
	}
	public Widget asWidget() {
		return this;
	}
}
