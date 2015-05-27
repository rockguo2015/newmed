package com.fudanmed.platform.core.measure.impl;

import com.fudanmed.platform.core.measure.RCGasMeasureDevice;
import com.fudanmed.platform.core.measure.RCGasMeasureDeviceType;
import com.fudanmed.platform.core.measure.impl.RCGasMeasureDeviceImpl;
import com.fudanmed.platform.core.measure.impl.RCMeasureDeviceTypeImpl;
import com.fudanmed.platform.core.measure.proxy.RCGasMeasureDeviceTypeProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Entity
@DiscriminatorValue("RCGASMEASUREDEVICETYPE_TYPE")
public class RCGasMeasureDeviceTypeImpl extends RCMeasureDeviceTypeImpl implements RCGasMeasureDeviceType {
  public RCGasMeasureDeviceTypeImpl() {
    super();
  }
  
  public RCGasMeasureDevice createDevice(final Procedure1<? super RCGasMeasureDevice> init) {RCGasMeasureDevice rCGasMeasureDevice=RCGasMeasureDeviceImpl.create(getObjectFactory());
    final Procedure1<RCGasMeasureDevice> _function = new Procedure1<RCGasMeasureDevice>() {
        public void apply(final RCGasMeasureDevice it) {
          it.setDeviceType(RCGasMeasureDeviceTypeImpl.this);
          init.apply(it);
        }
      };
    RCGasMeasureDevice _doubleArrow = ObjectExtensions.<RCGasMeasureDevice>operator_doubleArrow(rCGasMeasureDevice, _function);
    final Procedure1<RCGasMeasureDevice> _function_1 = new Procedure1<RCGasMeasureDevice>() {
        public void apply(final RCGasMeasureDevice it) {
          it.checkValid();
        }
      };
    RCGasMeasureDevice _doubleArrow_1 = ObjectExtensions.<RCGasMeasureDevice>operator_doubleArrow(_doubleArrow, _function_1);
    return _doubleArrow_1;
  }
  
  public static RCGasMeasureDeviceType create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.measure.RCGasMeasureDeviceType rCGasMeasureDeviceType = new com.fudanmed.platform.core.measure.impl.RCGasMeasureDeviceTypeImpl(
    );
    objectFactory.create(rCGasMeasureDeviceType);
    return rCGasMeasureDeviceType;			
    
  }
  
  public RCGasMeasureDeviceTypeProxy toProxy() {
    com.fudanmed.platform.core.measure.proxy.RCGasMeasureDeviceTypeProxy proxy = new com.fudanmed.platform.core.measure.proxy.RCGasMeasureDeviceTypeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
