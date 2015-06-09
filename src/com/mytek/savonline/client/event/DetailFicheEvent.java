package com.mytek.savonline.client.event;

import com.google.gwt.event.shared.GwtEvent;



public class DetailFicheEvent extends GwtEvent<DetailFicheEventHandler> {
  public static Type<DetailFicheEventHandler> TYPE = new Type<DetailFicheEventHandler>();
  private final String id;
  
  public DetailFicheEvent(String id) {
    this.id = id;
  }
  
  public String getId() { return id; }
  
  
  @Override
  public Type<DetailFicheEventHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(DetailFicheEventHandler handler) {
    handler.onDetailFiche(this);
  }
}
