package com.fudanmed.platform.core.web.client.warehouse;

import com.google.gwt.event.shared.EventHandler;

public interface StockTakingListsChangedHandler extends EventHandler {
  public abstract void StockTakingListsChanged();
}
