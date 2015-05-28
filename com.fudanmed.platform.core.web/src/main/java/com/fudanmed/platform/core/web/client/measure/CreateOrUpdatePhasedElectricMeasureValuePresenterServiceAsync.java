package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureValueProxy;
import com.fudanmed.platform.core.web.shared.measure.UIPhasedElectricMeasureValue;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdatePhasedElectricMeasureValuePresenterServiceAsync {
  public abstract void loadValue(final RCPhasedElectricMeasureValueProxy pvalue, final AsyncCallback<UIPhasedElectricMeasureValue> callback);
  
  public abstract void updateValue(final UIPhasedElectricMeasureValue uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UIPhasedElectricMeasureValue uivalue, final RCMeasureDeviceProxy parent, final AsyncCallback<Void> callback);
}
