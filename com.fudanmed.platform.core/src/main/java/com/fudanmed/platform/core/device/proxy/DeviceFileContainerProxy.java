package com.fudanmed.platform.core.device.proxy;

import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.uniquesoft.gwt.shared.adaptor.EntityAdaptorProxy;
import edu.fudan.langlab.domain.document.proxy.IDocumentContainerProxy;

public class DeviceFileContainerProxy extends EntityAdaptorProxy<RCDeviceProxy> implements IDocumentContainerProxy {
  public DeviceFileContainerProxy() {
    super();
  }
  
  public DeviceFileContainerProxy(final RCDeviceProxy adaptee) {
    super(adaptee,"com.fudanmed.platform.core.device.DeviceFileContainer");
  }
}
