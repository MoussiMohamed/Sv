package com.savonline.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.savonline.client.view.*;
import com.savonline.client.presenter.*;
import com.savonline.client.presenter.AffichFichePresenter.Display;

public class SuiviFicheEvent extends GwtEvent<SuiviFicheEventHandler> {
  public static Type<SuiviFicheEventHandler> TYPE = new Type<SuiviFicheEventHandler>();
  
  
  
  
  @Override
  public Type<SuiviFicheEventHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(SuiviFicheEventHandler handler) {
    handler.onSuiviFiche(this);
  }
}