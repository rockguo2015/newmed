package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMDefaultIntervalAssociationProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCPMDeviceTypeEntryProxy;
import com.fudanmed.platform.core.web.shared.device.UIPMDefaultIntervalAssociation;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMDefaultIntervalAssociationPresenterService")
public interface CreateOrUpdatePMDefaultIntervalAssociationPresenterService extends RemoteService {
  public abstract UIPMDefaultIntervalAssociation loadValue(final RCPMDefaultIntervalAssociationProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UIPMDefaultIntervalAssociation uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void createValue(final UIPMDefaultIntervalAssociation uivalue, final RCPMDeviceTypeEntryProxy parent) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
