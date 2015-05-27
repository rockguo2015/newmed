package com.fudanmed.platform.core.device.proxy;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.uniquesoft.gwt.shared.adaptor.EntityAdaptorProxy;
import edu.fudan.langlab.domain.document.proxy.IDocumentContainerProxy;

public class DeviceTypePictureContainerProxy extends EntityAdaptorProxy<RCDeviceTypeProxy> implements IDocumentContainerProxy {
  public DeviceTypePictureContainerProxy() {
    super();
  }
  
  public DeviceTypePictureContainerProxy(final RCDeviceTypeProxy adaptee) {
    super(adaptee,"com.fudanmed.platform.core.device.DeviceTypePictureContainer");
  }
}
