package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCGasMeasureValueProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DeleteGasMeasureValueCommandServiceAsync {
  public abstract void delete(final RCGasMeasureValueProxy value, final AsyncCallback<Void> callback);
}
