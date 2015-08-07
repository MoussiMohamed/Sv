package com.savonline.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class VerifGarantieFicheEvent extends GwtEvent<VerifGarantieFicheEventHandler> {
  public static Type<VerifGarantieFicheEventHandler> TYPE = new Type<VerifGarantieFicheEventHandler>();
  
  @Override
  public Type<VerifGarantieFicheEventHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(VerifGarantieFicheEventHandler handler) {
	    handler.onVerifGarantieMateriel(this);
	  }
}
