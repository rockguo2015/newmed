package com.fudanmed.platform.core.measure.impl;

import com.fudanmed.platform.core.measure.RCMeasureValue;
import com.fudanmed.platform.core.measure.RCPhasedElectricMeasureDevice;
import com.fudanmed.platform.core.measure.RCPhasedElectricMeasureValue;
import com.fudanmed.platform.core.measure.impl.RCMeasureDeviceImpl;
import com.fudanmed.platform.core.measure.impl.RCPhasedElectricMeasureValueImpl;
import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Entity
@DiscriminatorValue("RCPHASEDELECTRICMEASUREDEVICE_TYPE")
public class RCPhasedElectricMeasureDeviceImpl extends RCMeasureDeviceImpl implements RCPhasedElectricMeasureDevice {
  public RCPhasedElectricMeasureDeviceImpl() {
    super();
  }
  
  private Double factor;
  
  public Double getFactor() {
    return this.factor;
  }
  
  public RCPhasedElectricMeasureDevice setFactor(final Double factor) {
    this.factor = factor;
    return this;			
    
  }
  
  public RCMeasureValue doCreateValue() {RCPhasedElectricMeasureValue rCPhasedElectricMeasureValue=RCPhasedElectricMeasureValueImpl.create(getObjectFactory());
    return rCPhasedElectricMeasureValue;
  }
  
  public void update(final Procedure1<? super RCPhasedElectricMeasureDevice> updater) {
    updater.apply(this);
    this.checkValid();
  }
  
  public static RCPhasedElectricMeasureDevice create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.measure.RCPhasedElectricMeasureDevice rCPhasedElectricMeasureDevice = new com.fudanmed.platform.core.measure.impl.RCPhasedElectricMeasureDeviceImpl(
    );
    objectFactory.create(rCPhasedElectricMeasureDevice);
    return rCPhasedElectricMeasureDevice;			
    
  }
  
  public RCPhasedElectricMeasureDeviceProxy toProxy() {
    com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceProxy proxy = new com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
