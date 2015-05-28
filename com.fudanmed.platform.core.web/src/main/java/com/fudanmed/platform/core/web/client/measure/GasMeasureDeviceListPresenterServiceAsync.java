package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCGasMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.shared.measure.UIGasMeasureDevice;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface GasMeasureDeviceListPresenterServiceAsync {
  public abstract void loadGasMeasureDeviceList(final RCGasMeasureDeviceTypeProxy context, final AsyncCallback<Collection<UIGasMeasureDevice>> callback);
}
