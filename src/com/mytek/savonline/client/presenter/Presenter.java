package com.mytek.savonline.client.presenter;

import com.google.gwt.user.client.ui.HasWidgets;

public abstract interface Presenter {
  public abstract void go(final HasWidgets left,final HasWidgets container);
}
