package com.fudanmed.platform.core.measure.impl;

import com.fudanmed.platform.core.measure.RCPhasedElectricMeasureDevice;
import com.fudanmed.platform.core.measure.RCPhasedElectricMeasureDeviceType;
import com.fudanmed.platform.core.measure.impl.RCMeasureDeviceTypeImpl;
import com.fudanmed.platform.core.measure.impl.RCPhasedElectricMeasureDeviceImpl;
import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceTypeProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Entity
@DiscriminatorValue("RCPHASEDELECTRICMEASUREDEVICETYPE_TYPE")
public class RCPhasedElectricMeasureDeviceTypeImpl extends RCMeasureDeviceTypeImpl implements RCPhasedElectricMeasureDeviceType {
  public RCPhasedElectricMeasureDeviceTypeImpl() {
    super();
  }
  
  public RCPhasedElectricMeasureDevice createDevice(final Procedure1<? super RCPhasedElectricMeasureDevice> init) {RCPhasedElectricMeasureDevice rCPhasedElectricMeasureDevice=RCPhasedElectricMeasureDeviceImpl.create(getObjectFactory());
    final Procedure1<RCPhasedElectricMeasureDevice> _function = new Procedure1<RCPhasedElectricMeasureDevice>() {
        public void apply(final RCPhasedElectricMeasureDevice it) {
          it.setDeviceType(RCPhasedElectricMeasureDeviceTypeImpl.this);
          init.apply(it);
        }
      };
    RCPhasedElectricMeasureDevice _doubleArrow = ObjectExtensions.<RCPhasedElectricMeasureDevice>operator_doubleArrow(rCPhasedElectricMeasureDevice, _function);
    final Procedure1<RCPhasedElectricMeasureDevice> _function_1 = new Procedure1<RCPhasedElectricMeasureDevice>() {
        public void apply(final RCPhasedElectricMeasureDevice it) {
          it.checkValid();
        }
      };
    RCPhasedElectricMeasureDevice _doubleArrow_1 = ObjectExtensions.<RCPhasedElectricMeasureDevice>operator_doubleArrow(_doubleArrow, _function_1);
    return _doubleArrow_1;
  }
  
  public static RCPhasedElectricMeasureDeviceType create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.measure.RCPhasedElectricMeasureDeviceType rCPhasedElectricMeasureDeviceType = new com.fudanmed.platform.core.measure.impl.RCPhasedElectricMeasureDeviceTypeImpl(
    );
    objectFactory.create(rCPhasedElectricMeasureDeviceType);
    return rCPhasedElectricMeasureDeviceType;			
    
  }
  
  public RCPhasedElectricMeasureDeviceTypeProxy toProxy() {
    com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceTypeProxy proxy = new com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceTypeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
