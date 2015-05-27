package com.fudanmed.platform.core.entityextension.impl;

import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCStringType;
import com.fudanmed.platform.core.entityextension.RCStringValue;
import com.fudanmed.platform.core.entityextension.impl.RCPrimaryTypeImpl;
import com.fudanmed.platform.core.entityextension.impl.RCStringValueImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCStringTypeProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Entity
@DiscriminatorValue("RCSTRINGTYPE_TYPE")
public class RCStringTypeImpl extends RCPrimaryTypeImpl implements RCStringType {
  public RCStringTypeImpl() {
    super();
  }
  
  public String getTypeName() {
    return "\u6587\u5B57";
  }
  
  public RCStringValue createInstance(final RCExtensiableEntity rootOwner) {RCStringValue rCStringValue=RCStringValueImpl.create(getObjectFactory());
    final Procedure1<RCStringValue> _function = new Procedure1<RCStringValue>() {
        public void apply(final RCStringValue it) {
          it.setRootOwner(rootOwner);
        }
      };
    RCStringValue _doubleArrow = ObjectExtensions.<RCStringValue>operator_doubleArrow(rCStringValue, _function);
    return _doubleArrow;
  }
  
  public static RCStringType create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.entityextension.RCStringType rCStringType = new com.fudanmed.platform.core.entityextension.impl.RCStringTypeImpl(
    );
    objectFactory.create(rCStringType);
    return rCStringType;			
    
  }
  
  public RCStringTypeProxy toProxy() {
    com.fudanmed.platform.core.entityextension.proxy.RCStringTypeProxy proxy = new com.fudanmed.platform.core.entityextension.proxy.RCStringTypeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
