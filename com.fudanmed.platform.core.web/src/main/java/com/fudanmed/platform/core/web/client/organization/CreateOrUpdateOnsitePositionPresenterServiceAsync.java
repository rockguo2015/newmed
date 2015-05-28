package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateOnsitePositionPresenterServiceAsync {
  public abstract void loadValue(final RCOnsitePositionProxy pvalue, final AsyncCallback<UIOnsitePosition> callback);
  
  public abstract void updateValue(final UIOnsitePosition uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UIOnsitePosition uivalue, final AsyncCallback<RCOnsitePositionProxy> callback);
}
