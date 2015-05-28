package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemWorkerAssignmentView;
import com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentListPresenter;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignment;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@ImplementedBy(value = CreateOrUpdatePMWorkItemWorkerAssignmentView.class)
public interface CreateOrUpdatePMWorkItemWorkerAssignmentPresenterView extends ViewerWithValidation {
  public abstract UIPMWorkItemWorkerAssignment getValue();
  
  public abstract void setValue(final UIPMWorkItemWorkerAssignment value);
  
  public abstract void setTeam(final RCOrganizationProxy team, final Procedure1<? super Void> postInit);
  
  public abstract void setWorkItemPlanAssignmentListPresenter(final WorkItemPlanAssignmentListPresenter workItemPlanAssignmentListPresenter);
}
