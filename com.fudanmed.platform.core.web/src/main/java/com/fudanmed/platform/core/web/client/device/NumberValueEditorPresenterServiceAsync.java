package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.fudanmed.platform.core.web.shared.device.NumberValueData;
import com.fudanmed.platform.core.web.shared.device.UIAttributeSlot;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface NumberValueEditorPresenterServiceAsync {
  public abstract void updateValue(final RCAttributeSlotProxy slot, final NumberValueData theValue, final AsyncCallback<UIAttributeSlot> callback);
  
  public abstract void loadValue(final RCAttributeSlotProxy slot, final AsyncCallback<Double> callback);
  
  public abstract void updateNumberWithUnitValue(final RCAttributeSlotProxy slot, final NumberValueData theValue, final AsyncCallback<UIAttributeSlot> callback);
  
  public abstract void loadNumberWithUnitValue(final RCAttributeSlotProxy slot, final AsyncCallback<Double> callback);
}
