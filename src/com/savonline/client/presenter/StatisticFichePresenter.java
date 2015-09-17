package com.savonline.client.presenter;



import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;


public class StatisticFichePresenter implements Presenter {
	public static interface Display{
		void setData(JSONArray jsonArray);
		Widget asWidget();


	}
	private final HandlerManager eventBus;
	private final RequestBuilder requestBuilder;
	private final Display display;
	private JSONValue jsonValue;
	private JSONObject jsonObject;
	private JSONArray jsonArray;
	String ct,ct2;

	JSONObject jsonObj;
	RequestBuilder builder;

	public StatisticFichePresenter(HandlerManager eventBus,RequestBuilder requestBuilder, final Display display){
		this.eventBus=eventBus;
		this.display=display;
		this.requestBuilder = requestBuilder;

		ct = new String("Content-Type");
		ct2 = new String("application/x-www-form-urlencoded");
		jsonObj =  new JSONObject();
		jsonObj.put("Action", new JSONString("getFicheStatus"));
		requestBuilder.setHeader(ct, ct2);
		try {
			requestBuilder.sendRequest("jsonObj="+jsonObj.toString(), new RequestCallback() {

				@Override
				public void onResponseReceived(Request request, Response response) {

					jsonValue = JSONParser.parseStrict(response.getText());

					if ((jsonObject = jsonValue.isObject()) == null) {
						Window.alert("Error parsing the JSON: is not an object");
						// Possibilites: error during download,
						// someone trying to break the application, etc.
					}

					jsonValue = jsonObject.get("d"); // Actually, this needs
					// a null check too
					if ((jsonArray = jsonValue.isArray()) == null) {
						Window.alert("Error parsing the JSON: is not an array");
					}




					display.setData(jsonArray);

				}

				@Override
				public void onError(Request request, Throwable exception) {


				}

			});
		} catch (RequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	
	

	@Override
	public void go(HasWidgets top, HasWidgets left, HasWidgets container) {
		

		container.clear();
		container.add(display.asWidget());
		
	}

}
