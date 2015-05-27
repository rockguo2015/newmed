package com.fudanmed.platform.core.measure.impl;

import com.fudanmed.platform.core.measure.RCGasMeasureDevice;
import com.fudanmed.platform.core.measure.RCGasMeasureValue;
import com.fudanmed.platform.core.measure.RCMeasureValue;
import com.fudanmed.platform.core.measure.impl.RCGasMeasureValueImpl;
import com.fudanmed.platform.core.measure.impl.RCMeasureDeviceImpl;
import com.fudanmed.platform.core.measure.proxy.RCGasMeasureDeviceProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Entity
@DiscriminatorValue("RCGASMEASUREDEVICE_TYPE")
public class RCGasMeasureDeviceImpl extends RCMeasureDeviceImpl implements RCGasMeasureDevice {
  public RCGasMeasureDeviceImpl() {
    super();
  }
  
  public RCMeasureValue doCreateValue() {RCGasMeasureValue rCGasMeasureValue=RCGasMeasureValueImpl.create(getObjectFactory());
    return rCGasMeasureValue;
  }
  
  public void update(final Procedure1<? super RCGasMeasureDevice> updater) {
    updater.apply(this);
    this.checkValid();
  }
  
  public static RCGasMeasureDevice create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.measure.RCGasMeasureDevice rCGasMeasureDevice = new com.fudanmed.platform.core.measure.impl.RCGasMeasureDeviceImpl(
    );
    objectFactory.create(rCGasMeasureDevice);
    return rCGasMeasureDevice;			
    
  }
  
  public RCGasMeasureDeviceProxy toProxy() {
    com.fudanmed.platform.core.measure.proxy.RCGasMeasureDeviceProxy proxy = new com.fudanmed.platform.core.measure.proxy.RCGasMeasureDeviceProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
