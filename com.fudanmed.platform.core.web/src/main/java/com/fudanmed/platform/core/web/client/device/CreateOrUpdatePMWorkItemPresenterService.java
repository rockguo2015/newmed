package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMPlanProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlan;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItem;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemPresenterService")
public interface CreateOrUpdatePMWorkItemPresenterService extends RemoteService {
  public abstract UIPMWorkItem loadValue(final RCPMWorkItemProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UIPMWorkItem uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Collection<UIDevicePMPlan> resolveDevicePMPlans(final Collection<RCDevicePMPlanProxy> selectedPlans) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Collection<UIDevicePMPlan> loadAssignedDevicePlans(final RCPMWorkItemProxy workItem) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void createValue(final Collection<RCDevicePMPlanProxy> selectedPlans, final UIPMWorkItem uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
