package com.savonline.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class AuthentifEvent extends GwtEvent<AuthentifEventHandler> {
  public static Type<AuthentifEventHandler> TYPE = new Type<AuthentifEventHandler>();
//  private final String role;
//  private final String id_employe;
  public AuthentifEvent(/*String role, String id_employe*/){
//	  this.role=role;
//	  this.id_employe=id_employe;
  }
  
//  public String getRole(){ return role; }
//  public String get_idEmploye(){ return id_employe; }
  public Type<AuthentifEventHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(AuthentifEventHandler handler) {
    handler.onAuthentif(this);
  }
}
