package com.mytek.savonline.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.ui.RootPanel;


public class SavOnline implements EntryPoint {

	public void onModuleLoad() {

		String url="http://127.0.0.1:8880/savOnlineMyTek/src/com/mytek/savonline/server/dispatcher.php";
		

		HandlerManager eventBus = new HandlerManager(null);
		RequestBuilder requesBuilder = new RequestBuilder(RequestBuilder.POST,URL.encode(url));

		AppController appViewer = new AppController(eventBus,requesBuilder);
		appViewer.go(RootPanel.get("leftPanel"),RootPanel.get("centralPanel"));
	}
}
