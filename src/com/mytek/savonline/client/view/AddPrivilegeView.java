package com.mytek.savonline.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.mytek.savonline.client.presenter.AddPrivilegePresenter;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
public class AddPrivilegeView extends Composite implements AddPrivilegePresenter.Display{
public final Button btnAjouter;
public final TextBox txtPrivilege;
public Label lblResult;
	public AddPrivilegeView() {
		
		DecoratorPanel decPanel = new DecoratorPanel();		
		FlexTable flexTable = new FlexTable();
		decPanel.setWidget(flexTable);
		
		Label lblPrivilege = new Label("Privilege");
		flexTable.setWidget(0, 0, lblPrivilege);
		
		txtPrivilege = new TextBox();
		flexTable.setWidget(0, 1, txtPrivilege);
		txtPrivilege.setWidth("181px");
		
		btnAjouter = new Button("Ajouter");
		flexTable.setWidget(0, 2, btnAjouter);
		
		lblResult = new Label("");
		lblResult.setStyleName("LblResult");
		flexTable.setWidget(1, 0, lblResult);
		
		initWidget(decPanel);
		
	}
	
	
	public Widget asWidget() {
		return this;
	}
	public HasValue<String> getTxtPrivilege(){
		return txtPrivilege;
	}
	public HasClickHandlers getBtnAjoutPriv(){
		return btnAjouter;
	}
	public void setLblResultPriv(String result){
		lblResult.setText(result);
	}
}
