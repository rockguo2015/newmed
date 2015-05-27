package com.fudanmed.platform.core.device;

import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.impl.RCDeviceTypePictureImpl;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypePictureProxy;
import edu.fudan.langlab.domain.document.DocumentStorage;
import edu.fudan.langlab.domain.document.IDocumentContainer;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCDeviceTypePictureImpl.class)
public interface RCDeviceTypePicture extends DocumentStorage {
  public abstract RCDeviceType getDeviceType();
  
  public abstract RCDeviceTypePicture setDeviceType(final RCDeviceType deviceType);
  
  public abstract IDocumentContainer getContainer();
  
  public abstract RCDeviceTypePictureProxy toProxy();
}
