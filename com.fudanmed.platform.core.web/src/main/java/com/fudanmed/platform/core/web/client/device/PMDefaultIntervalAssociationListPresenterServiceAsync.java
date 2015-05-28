package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.web.shared.device.UIPMDefaultIntervalAssociation;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface PMDefaultIntervalAssociationListPresenterServiceAsync {
  public abstract void loadPMDefaultIntervalAssociationList(final RCDeviceTypeProxy context, final AsyncCallback<Collection<UIPMDefaultIntervalAssociation>> callback);
}
