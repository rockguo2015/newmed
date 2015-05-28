package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.web.shared.device.UIPMDefaultIntervalAssociation;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.PMDefaultIntervalAssociationListPresenterService")
public interface PMDefaultIntervalAssociationListPresenterService extends RemoteService {
  public abstract Collection<UIPMDefaultIntervalAssociation> loadPMDefaultIntervalAssociationList(final RCDeviceTypeProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
