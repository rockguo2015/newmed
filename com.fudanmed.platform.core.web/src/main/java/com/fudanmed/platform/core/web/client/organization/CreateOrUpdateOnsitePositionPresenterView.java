package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.client.organization.CreateOrUpdateOnsitePositionView;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = CreateOrUpdateOnsitePositionView.class)
public interface CreateOrUpdateOnsitePositionPresenterView extends ViewerWithValidation {
  public abstract UIOnsitePosition getValue();
  
  public abstract void setValue(final UIOnsitePosition value);
  
  public abstract void setParent(final RCOnsitePositionProxy parent);
}
