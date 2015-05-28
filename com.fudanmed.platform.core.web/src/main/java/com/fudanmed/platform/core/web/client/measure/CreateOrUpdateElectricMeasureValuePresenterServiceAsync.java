package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureValueProxy;
import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy;
import com.fudanmed.platform.core.web.shared.measure.UIElectricMeasureValue;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateElectricMeasureValuePresenterServiceAsync {
  public abstract void loadValue(final RCElectricMeasureValueProxy pvalue, final AsyncCallback<UIElectricMeasureValue> callback);
  
  public abstract void updateValue(final UIElectricMeasureValue uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UIElectricMeasureValue uivalue, final RCMeasureDeviceProxy parent, final AsyncCallback<Void> callback);
}
