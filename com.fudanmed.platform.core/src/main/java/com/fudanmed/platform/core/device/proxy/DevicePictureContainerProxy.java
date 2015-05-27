package com.fudanmed.platform.core.device.proxy;

import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.uniquesoft.gwt.shared.adaptor.EntityAdaptorProxy;
import edu.fudan.langlab.domain.document.proxy.IDocumentContainerProxy;

public class DevicePictureContainerProxy extends EntityAdaptorProxy<RCDeviceProxy> implements IDocumentContainerProxy {
  public DevicePictureContainerProxy() {
    super();
  }
  
  public DevicePictureContainerProxy(final RCDeviceProxy adaptee) {
    super(adaptee,"com.fudanmed.platform.core.device.DevicePictureContainer");
  }
}
