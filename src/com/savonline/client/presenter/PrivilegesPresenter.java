package com.savonline.client.presenter;

import java.util.ArrayList;
import java.util.List;

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
import com.google.gwt.json.client.JSONString;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.savonline.client.event.AddContactEvent;
import com.savonline.client.event.EditePrivilegeEvent;
import com.savonline.client.view.PrivilegesView;

public class PrivilegesPresenter implements Presenter {  
  public interface Display {
    HasClickHandlers getAddButton();
    HasClickHandlers getCancelButton();
    void setLblResult(String resultat);
    HasValue<String> getTextPriv();
    void setTextPriv();
    HasClickHandlers geteditButton();
    Widget asWidget();
  }
  
  private final HandlerManager eventBus;
  private final Display display;
 
  String ct,ct2;
  JSONObject jsonObj;
  RequestBuilder builder;
  public PrivilegesPresenter(HandlerManager eventBus, Display view) {
    this.eventBus = eventBus;
    this.display = view;
    
    String url = "http://127.0.0.1:8888/savOnline-copy/src/com/mytek/savonline/server/PrivilegeService.php";
	ct = new String("Content-Type");
	ct2 = new String("application/x-www-form-urlencoded");
	jsonObj =  new JSONObject();
	builder = new RequestBuilder(RequestBuilder.POST,URL.encode(url));
  }
  public void bind() {
    display.getAddButton().addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
    	  
    	  try {	
    		  
    			jsonObj.put("privilege", new JSONString(display.getTextPriv().getValue()));
    			builder.setHeader(ct, ct2);
    			builder.sendRequest("jsonObj="+jsonObj.toString(), new RequestCallback() {
    			
    				@Override
    				public void onResponseReceived(Request request, Response response) {
    					
    					display.setLblResult(response.getText().toString());
    					display.setTextPriv();
    				
    						}
    				
    				@Override
    				public void onError(Request request, Throwable exception) {
    					display.setLblResult("Error with HTTP code :"+ exception.toString());
    					
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
    display.getCancelButton().addClickHandler(new ClickHandler() {   
        public void onClick(ClickEvent event) {
        display.getTextPriv().setValue("");
        }
        
    });
    display.geteditButton().addClickHandler(new ClickHandler() {   
        public void onClick(ClickEvent event) {
        //display.getTextPriv().setValue("");
        	eventBus.fireEvent(new EditePrivilegeEvent());
        }
        
    });
    
  }

  public void go(final HasWidgets container) {
    bind();
    container.clear();
    container.add(display.asWidget());
  }
  /*private void fetchData() {
	    rpcService.getContactDetails(new AsyncCallback<ArrayList<ContactDetails>>() {
	      public void onSuccess(ArrayList<ContactDetails> result) {
	          contactDetails = result;
	          sortContactDetails();
	          List<String> data = new ArrayList<String>();

	          for (int i = 0; i < result.size(); ++i) {
	            data.add(contactDetails.get(i).getDisplayName());
	          }
	          
	          display.setData(data);
	      }
	      
	      public void onFailure(Throwable caught) {
	        Window.alert("Error fetching contact details");
	      }
	    });
	  }*/
@Override
public void go(HasWidgets top, HasWidgets left, HasWidgets container) {
	// TODO Auto-generated method stub
	
}
}
