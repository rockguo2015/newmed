package com.fudanmed.platform.core.device.impl;

import com.fudanmed.platform.core.device.DeviceTypeFileContainer;
import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.RCDeviceTypeFile;
import com.fudanmed.platform.core.device.impl.RCDeviceTypeImpl;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeFileProxy;
import edu.fudan.langlab.domain.document.IDocumentContainer;
import edu.fudan.langlab.domain.document.impl.DocumentStorageImpl;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("RCDEVICETYPEFILE_TYPE")
public class RCDeviceTypeFileImpl extends DocumentStorageImpl implements RCDeviceTypeFile {
  public RCDeviceTypeFileImpl() {
    super();
  }
  
  public RCDeviceTypeFileImpl(final RCDeviceType deviceType) {
    super();
    this.deviceType = deviceType;
  }
  
  @JoinColumn(name = "deviceType_id")
  @ManyToOne(targetEntity = RCDeviceTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCDeviceType deviceType;
  
  public RCDeviceType getDeviceType() {
    return this.deviceType;
  }
  
  public RCDeviceTypeFile setDeviceType(final RCDeviceType deviceType) {
    this.deviceType = deviceType;
    return this;			
    
  }
  
  public IDocumentContainer getContainer() {
    DeviceTypeFileContainer _deviceTypeFileContainer = new DeviceTypeFileContainer(this.deviceType);
    return _deviceTypeFileContainer;
  }
  
  public static RCDeviceTypeFile create(final RCDeviceType deviceType, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.device.RCDeviceTypeFile rCDeviceTypeFile = new com.fudanmed.platform.core.device.impl.RCDeviceTypeFileImpl(
    	deviceType
    );
    objectFactory.create(rCDeviceTypeFile);
    return rCDeviceTypeFile;			
    
  }
  
  public RCDeviceTypeFileProxy toProxy() {
    com.fudanmed.platform.core.device.proxy.RCDeviceTypeFileProxy proxy = new com.fudanmed.platform.core.device.proxy.RCDeviceTypeFileProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
