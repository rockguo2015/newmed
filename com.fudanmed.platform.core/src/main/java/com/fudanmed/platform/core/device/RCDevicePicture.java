package com.fudanmed.platform.core.device;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.impl.RCDevicePictureImpl;
import com.fudanmed.platform.core.device.proxy.RCDevicePictureProxy;
import edu.fudan.langlab.domain.document.DocumentStorage;
import edu.fudan.langlab.domain.document.IDocumentContainer;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCDevicePictureImpl.class)
public interface RCDevicePicture extends DocumentStorage {
  public abstract RCDevice getDevice();
  
  public abstract RCDevicePicture setDevice(final RCDevice device);
  
  public abstract IDocumentContainer getContainer();
  
  public abstract RCDevicePictureProxy toProxy();
}
