package com.savonline.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class DeconnectEvent extends GwtEvent<DeconnectEventHandler> {
  public static Type<DeconnectEventHandler> TYPE = new Type<DeconnectEventHandler>();
  
  @Override
  public Type<DeconnectEventHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(DeconnectEventHandler handler) {
	    handler.onDeconnect(this);
	  }
}
