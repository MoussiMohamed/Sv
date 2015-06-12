package com.savonline.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.savonline.client.presenter.*;
import com.savonline.client.presenter.AffichFichePresenter.Display;
import com.savonline.client.view.*;

public class EditFicheEvent extends GwtEvent<EditFicheEventHandler> {
  public static Type<EditFicheEventHandler> TYPE = new Type<EditFicheEventHandler>();
  private final String id;
  private final String TypeElement;
  
  public EditFicheEvent(String id,String TypeElement) {
    this.id = id;
    this.TypeElement=TypeElement;
  }
  
  public String getId() { return id; }
  public String getTypeElement() { return TypeElement; }
  
  @Override
  public Type<EditFicheEventHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(EditFicheEventHandler handler) {
    handler.onEditFiche(this);
  }
}