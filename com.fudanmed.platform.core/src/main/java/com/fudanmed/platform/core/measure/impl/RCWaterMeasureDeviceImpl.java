package com.fudanmed.platform.core.measure.impl;

import com.fudanmed.platform.core.measure.RCWaterMeasureDevice;
import com.fudanmed.platform.core.measure.RCWaterMeasureValue;
import com.fudanmed.platform.core.measure.events.RCWaterMeasureDeviceEventsManager;
import com.fudanmed.platform.core.measure.impl.RCMeasureDeviceImpl;
import com.fudanmed.platform.core.measure.impl.RCWaterMeasureValueImpl;
import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureDeviceProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.BeanFactory;

@Entity
@DiscriminatorValue("RCWATERMEASUREDEVICE_TYPE")
public class RCWaterMeasureDeviceImpl extends RCMeasureDeviceImpl implements RCWaterMeasureDevice {
  public RCWaterMeasureDeviceImpl() {
    super();
  }
  
  public RCWaterMeasureValue doCreateValue() {RCWaterMeasureValue rCWaterMeasureValue=RCWaterMeasureValueImpl.create(getObjectFactory());
    return rCWaterMeasureValue;
  }
  
  public void update(final Procedure1<? super RCWaterMeasureDevice> updater) {
    updater.apply(this);
    this.checkValid();
    BeanFactory _beanFactory = this.getBeanFactory();
    RCWaterMeasureDeviceEventsManager _bean = _beanFactory.<RCWaterMeasureDeviceEventsManager>getBean(RCWaterMeasureDeviceEventsManager.class);
    _bean.fireUpdateded(this);
  }
  
  public static RCWaterMeasureDevice create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.measure.RCWaterMeasureDevice rCWaterMeasureDevice = new com.fudanmed.platform.core.measure.impl.RCWaterMeasureDeviceImpl(
    );
    objectFactory.create(rCWaterMeasureDevice);
    return rCWaterMeasureDevice;			
    
  }
  
  public RCWaterMeasureDeviceProxy toProxy() {
    com.fudanmed.platform.core.measure.proxy.RCWaterMeasureDeviceProxy proxy = new com.fudanmed.platform.core.measure.proxy.RCWaterMeasureDeviceProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
