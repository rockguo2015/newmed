package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.fudanmed.platform.core.web.shared.device.DateValueData;
import com.fudanmed.platform.core.web.shared.device.UIAttributeSlot;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Date;

public interface DateValueEditorPresenterServiceAsync {
  public abstract void updateValue(final RCAttributeSlotProxy slot, final DateValueData theValue, final AsyncCallback<UIAttributeSlot> callback);
  
  public abstract void loadValue(final RCAttributeSlotProxy slot, final AsyncCallback<Date> callback);
}
