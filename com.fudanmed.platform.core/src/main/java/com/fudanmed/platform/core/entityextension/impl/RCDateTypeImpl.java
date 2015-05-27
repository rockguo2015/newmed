package com.fudanmed.platform.core.entityextension.impl;

import com.fudanmed.platform.core.entityextension.RCDateType;
import com.fudanmed.platform.core.entityextension.RCDateValue;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.impl.RCDateValueImpl;
import com.fudanmed.platform.core.entityextension.impl.RCPrimaryTypeImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCDateTypeProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Entity
@DiscriminatorValue("RCDATETYPE_TYPE")
public class RCDateTypeImpl extends RCPrimaryTypeImpl implements RCDateType {
  public RCDateTypeImpl() {
    super();
  }
  
  public String getTypeName() {
    return "\u65E5\u671F";
  }
  
  public RCDateValue createInstance(final RCExtensiableEntity rootOwner) {RCDateValue rCDateValue=RCDateValueImpl.create(getObjectFactory());
    final Procedure1<RCDateValue> _function = new Procedure1<RCDateValue>() {
        public void apply(final RCDateValue it) {
          it.setRootOwner(rootOwner);
        }
      };
    RCDateValue _doubleArrow = ObjectExtensions.<RCDateValue>operator_doubleArrow(rCDateValue, _function);
    return _doubleArrow;
  }
  
  public static RCDateType create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.entityextension.RCDateType rCDateType = new com.fudanmed.platform.core.entityextension.impl.RCDateTypeImpl(
    );
    objectFactory.create(rCDateType);
    return rCDateType;			
    
  }
  
  public RCDateTypeProxy toProxy() {
    com.fudanmed.platform.core.entityextension.proxy.RCDateTypeProxy proxy = new com.fudanmed.platform.core.entityextension.proxy.RCDateTypeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
