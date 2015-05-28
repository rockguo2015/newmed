package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureValueProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DeleteElectricMeasureValueCommandServiceAsync {
  public abstract void delete(final RCElectricMeasureValueProxy value, final AsyncCallback<Void> callback);
}
