package com.savonline.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class AddPrivilegeEvent extends GwtEvent<AddPrivilegeEventHandler> {
  public static Type<AddPrivilegeEventHandler> TYPE = new Type<AddPrivilegeEventHandler>();
  
  @Override
  public Type<AddPrivilegeEventHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(AddPrivilegeEventHandler handler) {
	    handler.onAddPrivilege(this);
	  }
}
