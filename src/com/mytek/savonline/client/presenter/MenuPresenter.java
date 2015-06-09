package com.mytek.savonline.client.presenter;

import com.google.gwt.event.logical.shared.HasSelectionHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.autobean.gwt.client.impl.ClientPropertyContext.Setter;

public class MenuPresenter implements Presenter {
public static interface Display{
	Widget asWidget();
//	HasSelectionHandlers<TreeItem>  getTreeItemMail();
//	HasSelectionHandlers<TreeItem> getTreeItemTechnicien();
	TreeItem getItemSelected();
	Label getLblAjoutFiche();
	Label getLblAssignerFiche();
	TreeItem getItemSelectedTechnicien();
	Widget onInitialize();
	Widget getStatistiqueHeader();
	Widget getTechnicienHeader();
	void setEventBus(HandlerManager eventBus);
	//HasSelectionHandlers<TreeItem> getSelectionEvent();
}
private final HandlerManager eventBus;
private final RequestBuilder requestBuilder;
private final Display display;
public MenuPresenter(HandlerManager eventBus,RequestBuilder requestBuilder,Display display){
	this.eventBus=eventBus;
	this.requestBuilder = requestBuilder;
	this.display=display;
	this.display.setEventBus(eventBus);
}

public void bind() {
	
	if (Cookies.getCookie("RoleName").equalsIgnoreCase("Technicien")){
		display.getStatistiqueHeader().setVisible(false);
		display.getTechnicienHeader().setVisible(false);
		display.getLblAjoutFiche().setText("");
		display.getLblAssignerFiche().setText("");
	}
    
}



@Override
public void go(final HasWidgets left, final HasWidgets container) {
//	bind();
	left.clear();
	left.add(display.asWidget());
  }
}
