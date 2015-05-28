package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.UploadDeviceView;
import com.fudanmed.platform.core.web.shared.device.DeviceUploadData;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.FormViewer;
import com.uniquesoft.gwt.client.common.RequestHandler;
import java.util.Collection;

@ImplementedBy(value = UploadDeviceView.class)
public interface UploadDevicePresenterView extends FormViewer<DeviceUploadData> {
  public abstract void fileUploaded(final RequestHandler requestHandler);
  
  public abstract void setPreviewValues(final Collection<UIDevice> values);
  
  public abstract Collection<UIDevice> getPreviewValues();
}
