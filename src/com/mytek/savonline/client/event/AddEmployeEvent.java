package com.mytek.savonline.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class AddEmployeEvent extends GwtEvent<AddEmployeEventHandler> {
 public static Type<AddEmployeEventHandler> TYPE = new Type<AddEmployeEventHandler>();
 

 public Type<AddEmployeEventHandler> getAssociatedType(){
	 return TYPE;
 }
 @Override
 protected void dispatch(AddEmployeEventHandler handler) {
	 handler.onAddEmploye(this);
 }
 
}
