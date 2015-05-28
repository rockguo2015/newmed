package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureValueProxy;
import com.fudanmed.platform.core.web.shared.measure.UIWaterMeasureValue;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateWaterMeasureValuePresenterServiceAsync {
  public abstract void loadValue(final RCWaterMeasureValueProxy pvalue, final AsyncCallback<UIWaterMeasureValue> callback);
  
  public abstract void updateValue(final UIWaterMeasureValue uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UIWaterMeasureValue uivalue, final RCMeasureDeviceProxy parent, final AsyncCallback<Void> callback);
}
