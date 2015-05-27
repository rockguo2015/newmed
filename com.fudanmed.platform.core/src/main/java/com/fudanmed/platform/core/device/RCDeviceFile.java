package com.fudanmed.platform.core.device;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.impl.RCDeviceFileImpl;
import com.fudanmed.platform.core.device.proxy.RCDeviceFileProxy;
import edu.fudan.langlab.domain.document.DocumentStorage;
import edu.fudan.langlab.domain.document.IDocumentContainer;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCDeviceFileImpl.class)
public interface RCDeviceFile extends DocumentStorage {
  public abstract RCDevice getDevice();
  
  public abstract RCDeviceFile setDevice(final RCDevice device);
  
  public abstract IDocumentContainer getContainer();
  
  public abstract RCDeviceFileProxy toProxy();
}
