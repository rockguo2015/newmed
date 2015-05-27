package com.fudanmed.platform.core.device.proxy;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.uniquesoft.gwt.shared.adaptor.EntityAdaptorProxy;
import edu.fudan.langlab.domain.document.proxy.IDocumentContainerProxy;

public class DeviceTypeFileContainerProxy extends EntityAdaptorProxy<RCDeviceTypeProxy> implements IDocumentContainerProxy {
  public DeviceTypeFileContainerProxy() {
    super();
  }
  
  public DeviceTypeFileContainerProxy(final RCDeviceTypeProxy adaptee) {
    super(adaptee,"com.fudanmed.platform.core.device.DeviceTypeFileContainer");
  }
}
