package com.mytek.savonline.client.event;

import com.google.gwt.event.shared.*;
import com.mytek.savonline.client.view.*;
import com.mytek.savonline.client.presenter.*;
import com.mytek.savonline.client.presenter.AffichFichePresenter.Display;

public class AfficheFicheEvent extends GwtEvent<AfficheFicheEventHandler> {
  public static Type<AfficheFicheEventHandler> TYPE = new Type<AfficheFicheEventHandler>();
  private final String id;
  
  public AfficheFicheEvent(String id) {
    this.id = id;
  }
  
  public String getId() { return id; }
  
  
  @Override
  public Type<AfficheFicheEventHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(AfficheFicheEventHandler handler) {
    handler.onEditFiche(this);
  }
}