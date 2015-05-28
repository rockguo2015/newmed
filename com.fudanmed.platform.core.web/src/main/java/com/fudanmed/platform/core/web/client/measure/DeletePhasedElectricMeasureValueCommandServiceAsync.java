package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureValueProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DeletePhasedElectricMeasureValueCommandServiceAsync {
  public abstract void delete(final RCPhasedElectricMeasureValueProxy value, final AsyncCallback<Void> callback);
}
