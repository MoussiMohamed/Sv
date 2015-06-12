package com.savonline.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.savonline.client.presenter.*;
import com.savonline.client.presenter.AffichFichePresenter.Display;
import com.savonline.client.view.*;

public class DevisEvent extends GwtEvent<DevisEventHandler> {
  public static Type<DevisEventHandler> TYPE = new Type<DevisEventHandler>();
  private final String id;

  public DevisEvent(String id) {
    this.id = id;
 
  }
  
  public String getId() { return id; }

  @Override
  public Type<DevisEventHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(DevisEventHandler handler) {
    handler.onCreateDevis(this);
  }
}