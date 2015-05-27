package com.fudanmed.platform.core.device;

import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.impl.RCDeviceTypeFileImpl;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeFileProxy;
import edu.fudan.langlab.domain.document.DocumentStorage;
import edu.fudan.langlab.domain.document.IDocumentContainer;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCDeviceTypeFileImpl.class)
public interface RCDeviceTypeFile extends DocumentStorage {
  public abstract RCDeviceType getDeviceType();
  
  public abstract RCDeviceTypeFile setDeviceType(final RCDeviceType deviceType);
  
  public abstract IDocumentContainer getContainer();
  
  public abstract RCDeviceTypeFileProxy toProxy();
}
