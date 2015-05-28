package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.OrganizationOutlineView;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import java.util.Collection;

@ImplementedBy(value = OrganizationOutlineView.class)
public interface OrganizationOutlinePresenterView extends Viewer {
  public abstract void showResults(final Collection<UIOrganization> values);
  
  public abstract void updateOrganization(final UIOrganization org);
  
  public abstract void deleteOrganization(final RCOrganizationProxy org);
  
  public abstract void addOrganization(final UIOrganization org);
  
  public abstract ActionContext<UIOrganization> getActionContext();
  
  public abstract void asSimpleTree(final Boolean isSimple);
  
  public abstract void select(final UIOrganization org);
}
