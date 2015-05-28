package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.CreateOrUpdateOrganizationView;
import com.fudanmed.platform.core.web.client.organization.OnsiteLocationOutlinePresenter;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;
import java.util.Collection;

@ImplementedBy(value = CreateOrUpdateOrganizationView.class)
public interface CreateOrUpdateOrganizationPresenterView extends ViewerWithValidation {
  public abstract UIOrganization getValue();
  
  public abstract void setValue(final UIOrganization value);
  
  public abstract void setParent(final RCOrganizationProxy value);
  
  public abstract void setPositions(final Collection<UIOnsitePosition> positions);
  
  public abstract Collection<UIOnsitePosition> getPositions();
  
  public abstract void setOnsiteLocationOutlinePresenter(final OnsiteLocationOutlinePresenter onsiteLocationOutlinePresenter);
}
