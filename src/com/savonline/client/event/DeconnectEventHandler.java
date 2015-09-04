package com.savonline.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface DeconnectEventHandler extends EventHandler {
  void onDeconnect(DeconnectEvent event);
}
