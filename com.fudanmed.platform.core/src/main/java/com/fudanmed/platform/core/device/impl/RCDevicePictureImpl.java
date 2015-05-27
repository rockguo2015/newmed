package com.fudanmed.platform.core.device.impl;

import com.fudanmed.platform.core.device.DevicePictureContainer;
import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.RCDevicePicture;
import com.fudanmed.platform.core.device.impl.RCDeviceImpl;
import com.fudanmed.platform.core.device.proxy.RCDevicePictureProxy;
import edu.fudan.langlab.domain.document.IDocumentContainer;
import edu.fudan.langlab.domain.document.impl.DocumentStorageImpl;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("RCDEVICEPICTURE_TYPE")
public class RCDevicePictureImpl extends DocumentStorageImpl implements RCDevicePicture {
  public RCDevicePictureImpl() {
    super();
  }
  
  public RCDevicePictureImpl(final RCDevice device) {
    super();
    this.device = device;
  }
  
  @JoinColumn(name = "device_id")
  @ManyToOne(targetEntity = RCDeviceImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCDevice device;
  
  public RCDevice getDevice() {
    return this.device;
  }
  
  public RCDevicePicture setDevice(final RCDevice device) {
    this.device = device;
    return this;			
    
  }
  
  public IDocumentContainer getContainer() {
    DevicePictureContainer _devicePictureContainer = new DevicePictureContainer(this.device);
    return _devicePictureContainer;
  }
  
  public static RCDevicePicture create(final RCDevice device, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.device.RCDevicePicture rCDevicePicture = new com.fudanmed.platform.core.device.impl.RCDevicePictureImpl(
    	device
    );
    objectFactory.create(rCDevicePicture);
    return rCDevicePicture;			
    
  }
  
  public RCDevicePictureProxy toProxy() {
    com.fudanmed.platform.core.device.proxy.RCDevicePictureProxy proxy = new com.fudanmed.platform.core.device.proxy.RCDevicePictureProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
