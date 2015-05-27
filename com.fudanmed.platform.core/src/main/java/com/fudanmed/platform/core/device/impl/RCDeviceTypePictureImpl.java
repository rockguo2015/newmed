package com.fudanmed.platform.core.device.impl;

import com.fudanmed.platform.core.device.DeviceTypePictureContainer;
import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.RCDeviceTypePicture;
import com.fudanmed.platform.core.device.impl.RCDeviceTypeImpl;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypePictureProxy;
import edu.fudan.langlab.domain.document.IDocumentContainer;
import edu.fudan.langlab.domain.document.impl.DocumentStorageImpl;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("RCDEVICETYPEPICTURE_TYPE")
public class RCDeviceTypePictureImpl extends DocumentStorageImpl implements RCDeviceTypePicture {
  public RCDeviceTypePictureImpl() {
    super();
  }
  
  public RCDeviceTypePictureImpl(final RCDeviceType deviceType) {
    super();
    this.deviceType = deviceType;
  }
  
  @JoinColumn(name = "deviceType_id")
  @ManyToOne(targetEntity = RCDeviceTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCDeviceType deviceType;
  
  public RCDeviceType getDeviceType() {
    return this.deviceType;
  }
  
  public RCDeviceTypePicture setDeviceType(final RCDeviceType deviceType) {
    this.deviceType = deviceType;
    return this;			
    
  }
  
  public IDocumentContainer getContainer() {
    DeviceTypePictureContainer _deviceTypePictureContainer = new DeviceTypePictureContainer(this.deviceType);
    return _deviceTypePictureContainer;
  }
  
  public static RCDeviceTypePicture create(final RCDeviceType deviceType, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.device.RCDeviceTypePicture rCDeviceTypePicture = new com.fudanmed.platform.core.device.impl.RCDeviceTypePictureImpl(
    	deviceType
    );
    objectFactory.create(rCDeviceTypePicture);
    return rCDeviceTypePicture;			
    
  }
  
  public RCDeviceTypePictureProxy toProxy() {
    com.fudanmed.platform.core.device.proxy.RCDeviceTypePictureProxy proxy = new com.fudanmed.platform.core.device.proxy.RCDeviceTypePictureProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
