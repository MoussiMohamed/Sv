package com.savonline.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Cookies;
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
import com.savonline.client.presenter.TopMenuPresenter;

public class TopMenuView extends Composite implements TopMenuPresenter.Display{
	
	 private Button btnDisconnect;
	
private FlexTable flexTStats;
public TopMenuView() {
		

Label lblStatus = new Label();

btnDisconnect=new Button("Deconnexion");
flexTStats=new FlexTable();
flexTStats.setWidget(0, 0, lblStatus);
flexTStats.setWidget(0, 1, btnDisconnect);
flexTStats.setStyleName("deconnectBtn");

lblStatus.setText("Connecte en tant que: "+Cookies.getCookie("Email"));
			initWidget(flexTStats);
			
}
	
	
public Widget asWidget() {
    return this;
  }

public HasClickHandlers getBtnDisconnect() {
	return btnDisconnect;
}

}