package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AttributeSlotEditPresenterServiceAsync {
  public abstract void deleteSlotAttribute(final RCAttributeSlotProxy slot, final AsyncCallback<Void> callback);
}
