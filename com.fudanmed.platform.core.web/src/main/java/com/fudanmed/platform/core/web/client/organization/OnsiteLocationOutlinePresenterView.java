package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.client.organization.OnsiteLocationOutlineView;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import java.util.Collection;

@ImplementedBy(value = OnsiteLocationOutlineView.class)
public interface OnsiteLocationOutlinePresenterView extends Viewer {
  public abstract void showResults(final Collection<UIOnsitePosition> results);
  
  public abstract void updateOnsitePosition(final UIOnsitePosition org);
  
  public abstract void deleteOnsitePosition(final RCOnsitePositionProxy org);
  
  public abstract void addOnsitePosition(final UIOnsitePosition org);
  
  public abstract ActionContext<UIOnsitePosition> getActionContext();
  
  public abstract void setAsSimpleTree(final Boolean isSimple);
}
