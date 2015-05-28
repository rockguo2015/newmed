package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemWorkerAssignmentProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignment;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignment;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface CreateOrUpdatePMWorkItemWorkerAssignmentPresenterServiceAsync {
  public abstract void loadValue(final RCPMWorkItemWorkerAssignmentProxy pvalue, final AsyncCallback<UIPMWorkItemWorkerAssignment> callback);
  
  public abstract void updateValue(final UIPMWorkItemWorkerAssignment uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final Collection<UIWorkItemPlanAssignment> planAssignments, final RCPMWorkItemProxy parent, final UIPMWorkItemWorkerAssignment uivalue, final AsyncCallback<RCPMWorkItemWorkerAssignmentProxy> callback);
  
  public abstract void loadTeamOrg4WorkItem(final RCPMWorkItemProxy value, final AsyncCallback<RCOrganizationProxy> callback);
  
  public abstract void loadTeamOrg4Assignment(final RCPMWorkItemWorkerAssignmentProxy value, final AsyncCallback<RCOrganizationProxy> callback);
}
