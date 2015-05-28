package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateWorkItemTaskView;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@ImplementedBy(value = CreateOrUpdateWorkItemTaskView.class)
public interface CreateOrUpdateWorkItemTaskPresenterView extends ViewerWithValidation {
  public abstract UIWorkItemTask getValue();
  
  public abstract void setValue(final UIWorkItemTask value);
  
  public abstract void setDefaultValues(final RCEmployeeProxy operator, final RCFaultTypeProxy faultType, final String faultDescription, final RCOrganizationProxy team, final Procedure1<? super Void> p);
}
