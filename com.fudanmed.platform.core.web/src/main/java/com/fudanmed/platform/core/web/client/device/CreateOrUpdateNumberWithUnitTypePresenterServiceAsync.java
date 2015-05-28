package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCNumberWithUnitTypeProxy;
import com.fudanmed.platform.core.web.shared.device.UINumberWithUnitType;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateNumberWithUnitTypePresenterServiceAsync {
  public abstract void loadValue(final RCNumberWithUnitTypeProxy pvalue, final AsyncCallback<UINumberWithUnitType> callback);
  
  public abstract void updateValue(final UINumberWithUnitType uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UINumberWithUnitType uivalue, final AsyncCallback<Void> callback);
}
