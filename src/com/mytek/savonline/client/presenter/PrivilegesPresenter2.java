package com.mytek.savonline.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.mytek.savonline.client.event.AddContactEvent;

public class PrivilegesPresenter2 implements Presenter {  
  public interface Display {
	  void setFTable(String[] data);
	  HasClickHandlers geteditButton();
	  HasClickHandlers getdeleteButton();
    Widget asWidget();
  }
  
  private final HandlerManager eventBus;
  private final Display display;
 
  String ct,ct2;
  JSONObject jsonObj;
  RequestBuilder builder;
  public PrivilegesPresenter2(HandlerManager eventBus, Display view) {
    this.eventBus = eventBus;
    this.display = view;
    
    String url = "http://127.0.0.1:8888/savOnline-copy/src/com/mytek/savonline/server/PrivilegeService.php";
	ct = new String("Content-Type");
	ct2 = new String("application/x-www-form-urlencoded");
	//jsonObj =  new JSONObject();
	builder = new RequestBuilder(RequestBuilder.POST,URL.encode(url));
  }
  public void bind() {
    display.getdeleteButton().addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
    	  
    	  try {	
    		  
    			//jsonObj.put("privilege", new JSONString(display.getTextPriv().getValue()));
    			builder.setHeader(ct, ct2);
    			builder.sendRequest(null, new RequestCallback() {
    			
    				@Override
    				public void onResponseReceived(Request request, Response response) {
    					
    					
    				
    						}
    				
    				@Override
    				public void onError(Request request, Throwable exception) {
    					//display.setLblResult("Error with HTTP code :"+ exception.toString());
    					
    				}
    			});
    		
    			}
    	  
    	  catch (RequestException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    	 
    	eventBus.fireEvent(new AddContactEvent());
      
      }
    });
   /* display.getCancelButton().addClickHandler(new ClickHandler() {   
        public void onClick(ClickEvent event) {
        display.getTextPriv().setValue("");
        }
        
    });*/
    
  }

  public void go(final HasWidgets container) {
    bind();
    //container.clear();
    container.add(display.asWidget());
  }
@Override
public void go(HasWidgets left, HasWidgets container) {
	// TODO Auto-generated method stub
	
}
}
