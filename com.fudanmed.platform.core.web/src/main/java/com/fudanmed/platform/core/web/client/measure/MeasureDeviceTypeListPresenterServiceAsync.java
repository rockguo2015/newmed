package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.shared.measure.UIMeasureDeviceType;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface MeasureDeviceTypeListPresenterServiceAsync {
  public abstract void loadMeasureDeviceTypeList(final AsyncCallback<Collection<UIMeasureDeviceType>> callback);
}
