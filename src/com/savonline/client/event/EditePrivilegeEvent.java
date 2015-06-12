package com.savonline.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class EditePrivilegeEvent extends GwtEvent<EditePrivilegeEventHandler> {
  public static Type<EditePrivilegeEventHandler> TYPE = new Type<EditePrivilegeEventHandler>();
  
  @Override
  public Type<EditePrivilegeEventHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(EditePrivilegeEventHandler handler) {
    handler.oneditPriv(this);
  }
}
