package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCGasMeasureValueProxy;
import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy;
import com.fudanmed.platform.core.web.shared.measure.UIGasMeasureValue;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateGasMeasureValuePresenterServiceAsync {
  public abstract void loadValue(final RCGasMeasureValueProxy pvalue, final AsyncCallback<UIGasMeasureValue> callback);
  
  public abstract void updateValue(final UIGasMeasureValue uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UIGasMeasureValue uivalue, final RCMeasureDeviceProxy parent, final AsyncCallback<Void> callback);
}
