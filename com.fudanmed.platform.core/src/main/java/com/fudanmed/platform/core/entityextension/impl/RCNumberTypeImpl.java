package com.fudanmed.platform.core.entityextension.impl;

import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCNumberType;
import com.fudanmed.platform.core.entityextension.RCNumberValue;
import com.fudanmed.platform.core.entityextension.impl.RCNumberValueImpl;
import com.fudanmed.platform.core.entityextension.impl.RCPrimaryTypeImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCNumberTypeProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Entity
@DiscriminatorValue("RCNUMBERTYPE_TYPE")
public class RCNumberTypeImpl extends RCPrimaryTypeImpl implements RCNumberType {
  public RCNumberTypeImpl() {
    super();
  }
  
  public String getTypeName() {
    return "\u6570\u503C";
  }
  
  public RCNumberValue createInstance(final RCExtensiableEntity rootOwner) {RCNumberValue rCNumberValue=RCNumberValueImpl.create(getObjectFactory());
    final Procedure1<RCNumberValue> _function = new Procedure1<RCNumberValue>() {
        public void apply(final RCNumberValue it) {
          it.setRootOwner(rootOwner);
        }
      };
    RCNumberValue _doubleArrow = ObjectExtensions.<RCNumberValue>operator_doubleArrow(rCNumberValue, _function);
    return _doubleArrow;
  }
  
  public static RCNumberType create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.entityextension.RCNumberType rCNumberType = new com.fudanmed.platform.core.entityextension.impl.RCNumberTypeImpl(
    );
    objectFactory.create(rCNumberType);
    return rCNumberType;			
    
  }
  
  public RCNumberTypeProxy toProxy() {
    com.fudanmed.platform.core.entityextension.proxy.RCNumberTypeProxy proxy = new com.fudanmed.platform.core.entityextension.proxy.RCNumberTypeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
