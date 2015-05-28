package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMDefaultIntervalAssociationProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCPMDeviceTypeEntryProxy;
import com.fudanmed.platform.core.web.shared.device.UIPMDefaultIntervalAssociation;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdatePMDefaultIntervalAssociationPresenterServiceAsync {
  public abstract void loadValue(final RCPMDefaultIntervalAssociationProxy pvalue, final AsyncCallback<UIPMDefaultIntervalAssociation> callback);
  
  public abstract void updateValue(final UIPMDefaultIntervalAssociation uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UIPMDefaultIntervalAssociation uivalue, final RCPMDeviceTypeEntryProxy parent, final AsyncCallback<Void> callback);
}
