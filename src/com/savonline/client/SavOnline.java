package com.savonline.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;


public class SavOnline implements EntryPoint {
	String url;
	
	public void onModuleLoad() {
	
//		if(!(Cookies.getCookie("numSerie") == null)){
//			//url="http://eventek-tn.com/test/E-adv/file-uploading/view.php";	
//			Cookies.removeCookie("numSerie");
//		}else{
//			url="http://127.0.0.1:8881/savOnlineToutBureau/src/com/savonline/server/dispatcher.php";
//		}
//		Window.alert(url);
		url="http://127.0.0.1:8881/savOnlineToutBureau/src/com/savonline/server/dispatcher.php";
		HandlerManager eventBus = new HandlerManager(null);
		RequestBuilder requesBuilder = new RequestBuilder(RequestBuilder.POST,URL.encode(url));
		
		AppController appViewer = new AppController(eventBus,requesBuilder);
		appViewer.go(RootPanel.get("topPanel"),RootPanel.get("leftPanel"),RootPanel.get("centralPanel"));
	}
	}

