package com.mytek.savonline.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class AddFicheEvent extends GwtEvent<AddFicheEventHandler> {
  public static Type<AddFicheEventHandler> TYPE = new Type<AddFicheEventHandler>();
  
  @Override
  public Type<AddFicheEventHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(AddFicheEventHandler handler) {
	    handler.onAddNewRecepMateriel(this);
	  }
}
