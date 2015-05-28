package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCExtensiableEntityProxy;
import com.fudanmed.platform.core.web.shared.device.UIAttributeSlot;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface AttributeSlotTreeListPresenterServiceAsync {
  public abstract void getParentSlot(final RCAttributeSlotProxy slot, final AsyncCallback<UIAttributeSlot> callback);
  
  public abstract void loadAttributeSlotList(final RCExtensiableEntityProxy context, final AsyncCallback<Collection<UIAttributeSlot>> callback);
  
  public abstract void loadAttributeSlotListFromSlot(final UIAttributeSlot slot, final Collection<UIAttributeSlot> result, final AsyncCallback<Void> callback);
}
