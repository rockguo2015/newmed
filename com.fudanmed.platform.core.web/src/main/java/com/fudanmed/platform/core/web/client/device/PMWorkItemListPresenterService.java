package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItem;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.PMWorkItemListPresenterService")
public interface PMWorkItemListPresenterService extends RemoteService {
  public abstract Collection<UIPMWorkItem> loadPMWorkItemList(final RCDeviceProxy device) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
