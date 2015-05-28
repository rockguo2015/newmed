package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.fudanmed.platform.core.web.shared.device.StringValueData;
import com.fudanmed.platform.core.web.shared.device.UIAttributeSlot;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface StringValueEditorPresenterServiceAsync {
  public abstract void updateValue(final RCAttributeSlotProxy slot, final StringValueData theValue, final AsyncCallback<UIAttributeSlot> callback);
  
  public abstract void loadValue(final RCAttributeSlotProxy slot, final AsyncCallback<String> callback);
}
