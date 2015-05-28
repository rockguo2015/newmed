package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureValueProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DeleteWaterMeasureValueCommandServiceAsync {
  public abstract void delete(final RCWaterMeasureValueProxy value, final AsyncCallback<Void> callback);
}
