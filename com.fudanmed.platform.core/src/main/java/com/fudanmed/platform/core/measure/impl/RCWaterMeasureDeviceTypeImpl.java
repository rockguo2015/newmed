package com.fudanmed.platform.core.measure.impl;

import com.fudanmed.platform.core.measure.RCWaterMeasureDevice;
import com.fudanmed.platform.core.measure.RCWaterMeasureDeviceType;
import com.fudanmed.platform.core.measure.events.RCWaterMeasureDeviceEventsManager;
import com.fudanmed.platform.core.measure.impl.RCMeasureDeviceTypeImpl;
import com.fudanmed.platform.core.measure.impl.RCWaterMeasureDeviceImpl;
import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureDeviceTypeProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.BeanFactory;

@Entity
@DiscriminatorValue("RCWATERMEASUREDEVICETYPE_TYPE")
public class RCWaterMeasureDeviceTypeImpl extends RCMeasureDeviceTypeImpl implements RCWaterMeasureDeviceType {
  public RCWaterMeasureDeviceTypeImpl() {
    super();
  }
  
  public RCWaterMeasureDevice createDevice(final Procedure1<? super RCWaterMeasureDevice> init) {RCWaterMeasureDevice rCWaterMeasureDevice=RCWaterMeasureDeviceImpl.create(getObjectFactory());
    final Procedure1<RCWaterMeasureDevice> _function = new Procedure1<RCWaterMeasureDevice>() {
        public void apply(final RCWaterMeasureDevice it) {
          it.setDeviceType(RCWaterMeasureDeviceTypeImpl.this);
          init.apply(it);
        }
      };
    RCWaterMeasureDevice _doubleArrow = ObjectExtensions.<RCWaterMeasureDevice>operator_doubleArrow(rCWaterMeasureDevice, _function);
    final Procedure1<RCWaterMeasureDevice> _function_1 = new Procedure1<RCWaterMeasureDevice>() {
        public void apply(final RCWaterMeasureDevice it) {
          it.checkValid();
          BeanFactory _beanFactory = RCWaterMeasureDeviceTypeImpl.this.getBeanFactory();
          RCWaterMeasureDeviceEventsManager _bean = _beanFactory.<RCWaterMeasureDeviceEventsManager>getBean(RCWaterMeasureDeviceEventsManager.class);
          _bean.fireCreated(it);
        }
      };
    RCWaterMeasureDevice _doubleArrow_1 = ObjectExtensions.<RCWaterMeasureDevice>operator_doubleArrow(_doubleArrow, _function_1);
    return _doubleArrow_1;
  }
  
  public static RCWaterMeasureDeviceType create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.measure.RCWaterMeasureDeviceType rCWaterMeasureDeviceType = new com.fudanmed.platform.core.measure.impl.RCWaterMeasureDeviceTypeImpl(
    );
    objectFactory.create(rCWaterMeasureDeviceType);
    return rCWaterMeasureDeviceType;			
    
  }
  
  public RCWaterMeasureDeviceTypeProxy toProxy() {
    com.fudanmed.platform.core.measure.proxy.RCWaterMeasureDeviceTypeProxy proxy = new com.fudanmed.platform.core.measure.proxy.RCWaterMeasureDeviceTypeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
