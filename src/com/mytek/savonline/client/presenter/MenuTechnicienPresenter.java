package com.mytek.savonline.client.presenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.Widget;

public class MenuTechnicienPresenter implements Presenter {
public static interface Display{
	Widget asWidget();
	TreeItem getItemSelected();
	Widget onInitialize();
	void setEventBus(HandlerManager eventBus);
}

private final HandlerManager eventBus;
private final RequestBuilder requestBuilder;
private final Display display;
public MenuTechnicienPresenter(HandlerManager eventBus,RequestBuilder requestBuilder,Display display){
	this.eventBus=eventBus;
	this.requestBuilder = requestBuilder;
	this.display=display;
	this.display.setEventBus(eventBus);
}

public void bind() {
	
    
}



@Override
public void go(final HasWidgets left, final HasWidgets container) {
   
	left.clear();
	left.add(display.asWidget());
  }
}
