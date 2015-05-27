package com.fudanmed.platform.core.device.impl;

import com.fudanmed.platform.core.device.DeviceFileContainer;
import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.RCDeviceFile;
import com.fudanmed.platform.core.device.impl.RCDeviceImpl;
import com.fudanmed.platform.core.device.proxy.RCDeviceFileProxy;
import edu.fudan.langlab.domain.document.IDocumentContainer;
import edu.fudan.langlab.domain.document.impl.DocumentStorageImpl;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("RCDEVICEFILE_TYPE")
public class RCDeviceFileImpl extends DocumentStorageImpl implements RCDeviceFile {
  public RCDeviceFileImpl() {
    super();
  }
  
  public RCDeviceFileImpl(final RCDevice device) {
    super();
    this.device = device;
  }
  
  @JoinColumn(name = "device_id")
  @ManyToOne(targetEntity = RCDeviceImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCDevice device;
  
  public RCDevice getDevice() {
    return this.device;
  }
  
  public RCDeviceFile setDevice(final RCDevice device) {
    this.device = device;
    return this;			
    
  }
  
  public IDocumentContainer getContainer() {
    DeviceFileContainer _deviceFileContainer = new DeviceFileContainer(this.device);
    return _deviceFileContainer;
  }
  
  public static RCDeviceFile create(final RCDevice device, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.device.RCDeviceFile rCDeviceFile = new com.fudanmed.platform.core.device.impl.RCDeviceFileImpl(
    	device
    );
    objectFactory.create(rCDeviceFile);
    return rCDeviceFile;			
    
  }
  
  public RCDeviceFileProxy toProxy() {
    com.fudanmed.platform.core.device.proxy.RCDeviceFileProxy proxy = new com.fudanmed.platform.core.device.proxy.RCDeviceFileProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
