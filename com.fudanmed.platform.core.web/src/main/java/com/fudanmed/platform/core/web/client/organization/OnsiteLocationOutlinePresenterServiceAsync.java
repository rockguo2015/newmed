package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface OnsiteLocationOutlinePresenterServiceAsync {
  public abstract void loadAllOnsitePosition(final AsyncCallback<Collection<UIOnsitePosition>> callback);
  
  public abstract void getValue(final RCOnsitePositionProxy org, final AsyncCallback<UIOnsitePosition> callback);
}
