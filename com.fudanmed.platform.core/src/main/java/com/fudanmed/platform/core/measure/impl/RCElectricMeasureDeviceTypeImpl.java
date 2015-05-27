package com.fudanmed.platform.core.measure.impl;

import com.fudanmed.platform.core.measure.RCElectricMeasureDevice;
import com.fudanmed.platform.core.measure.RCElectricMeasureDeviceType;
import com.fudanmed.platform.core.measure.impl.RCElectricMeasureDeviceImpl;
import com.fudanmed.platform.core.measure.impl.RCMeasureDeviceTypeImpl;
import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceTypeProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Entity
@DiscriminatorValue("RCELECTRICMEASUREDEVICETYPE_TYPE")
public class RCElectricMeasureDeviceTypeImpl extends RCMeasureDeviceTypeImpl implements RCElectricMeasureDeviceType {
  public RCElectricMeasureDeviceTypeImpl() {
    super();
  }
  
  public RCElectricMeasureDevice createDevice(final Procedure1<? super RCElectricMeasureDevice> init) {RCElectricMeasureDevice rCElectricMeasureDevice=RCElectricMeasureDeviceImpl.create(getObjectFactory());
    final Procedure1<RCElectricMeasureDevice> _function = new Procedure1<RCElectricMeasureDevice>() {
        public void apply(final RCElectricMeasureDevice it) {
          it.setDeviceType(RCElectricMeasureDeviceTypeImpl.this);
          init.apply(it);
        }
      };
    RCElectricMeasureDevice _doubleArrow = ObjectExtensions.<RCElectricMeasureDevice>operator_doubleArrow(rCElectricMeasureDevice, _function);
    final Procedure1<RCElectricMeasureDevice> _function_1 = new Procedure1<RCElectricMeasureDevice>() {
        public void apply(final RCElectricMeasureDevice it) {
          it.checkValid();
        }
      };
    RCElectricMeasureDevice _doubleArrow_1 = ObjectExtensions.<RCElectricMeasureDevice>operator_doubleArrow(_doubleArrow, _function_1);
    return _doubleArrow_1;
  }
  
  public static RCElectricMeasureDeviceType create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.measure.RCElectricMeasureDeviceType rCElectricMeasureDeviceType = new com.fudanmed.platform.core.measure.impl.RCElectricMeasureDeviceTypeImpl(
    );
    objectFactory.create(rCElectricMeasureDeviceType);
    return rCElectricMeasureDeviceType;			
    
  }
  
  public RCElectricMeasureDeviceTypeProxy toProxy() {
    com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceTypeProxy proxy = new com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceTypeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
