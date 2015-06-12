package com.savonline.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.ui.TreeItem;
import com.savonline.client.presenter.*;
import com.savonline.client.presenter.AffichFichePresenter.Display;
import com.savonline.client.view.*;

public class TreeItemMenuEvent extends GwtEvent<TreeItemMenuEventHandler> {
  public static Type<TreeItemMenuEventHandler> TYPE = new Type<TreeItemMenuEventHandler>();
  private final TreeItem Item;
  
  public TreeItemMenuEvent(TreeItem ItemText) {
    this.Item = ItemText;
  }
  
  public TreeItem getId() { return Item; }
  
  
  @Override
  public Type<TreeItemMenuEventHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(TreeItemMenuEventHandler handler) {
    handler.onClickItem(this);
  }
}