package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItem;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface PMWorkItemListPresenterServiceAsync {
  public abstract void loadPMWorkItemList(final RCDeviceProxy device, final AsyncCallback<Collection<UIPMWorkItem>> callback);
}
