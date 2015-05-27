package com.fudanmed.platform.core.measure.impl;

import com.fudanmed.platform.core.measure.RCElectricMeasureDevice;
import com.fudanmed.platform.core.measure.RCElectricMeasureValue;
import com.fudanmed.platform.core.measure.RCMeasureValue;
import com.fudanmed.platform.core.measure.impl.RCElectricMeasureValueImpl;
import com.fudanmed.platform.core.measure.impl.RCMeasureDeviceImpl;
import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Entity
@DiscriminatorValue("RCELECTRICMEASUREDEVICE_TYPE")
public class RCElectricMeasureDeviceImpl extends RCMeasureDeviceImpl implements RCElectricMeasureDevice {
  public RCElectricMeasureDeviceImpl() {
    super();
  }
  
  public RCMeasureValue doCreateValue() {RCElectricMeasureValue rCElectricMeasureValue=RCElectricMeasureValueImpl.create(getObjectFactory());
    return rCElectricMeasureValue;
  }
  
  public void update(final Procedure1<? super RCElectricMeasureDevice> updater) {
    updater.apply(this);
    this.checkValid();
  }
  
  public void delete() {getObjectFactory().delete(this);
    
  }
  
  public static RCElectricMeasureDevice create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.measure.RCElectricMeasureDevice rCElectricMeasureDevice = new com.fudanmed.platform.core.measure.impl.RCElectricMeasureDeviceImpl(
    );
    objectFactory.create(rCElectricMeasureDevice);
    return rCElectricMeasureDevice;			
    
  }
  
  public RCElectricMeasureDeviceProxy toProxy() {
    com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceProxy proxy = new com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
