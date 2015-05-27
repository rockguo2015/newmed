package com.fudanmed.platform.core.entityextension.impl;

import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCNumberWithUnitType;
import com.fudanmed.platform.core.entityextension.RCNumberWithUnitValue;
import com.fudanmed.platform.core.entityextension.impl.RCCustomizableTypeImpl;
import com.fudanmed.platform.core.entityextension.impl.RCNumberWithUnitValueImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCNumberWithUnitTypeProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Entity
@DiscriminatorValue("RCNUMBERWITHUNITTYPE_TYPE")
public class RCNumberWithUnitTypeImpl extends RCCustomizableTypeImpl implements RCNumberWithUnitType {
  public RCNumberWithUnitTypeImpl() {
    super();
  }
  
  private String alias;
  
  public String getAlias() {
    return this.alias;
  }
  
  public RCNumberWithUnitType setAlias(final String alias) {
    this.alias = alias;
    return this;			
    
  }
  
  private String unit;
  
  public String getUnit() {
    return this.unit;
  }
  
  public RCNumberWithUnitType setUnit(final String unit) {
    this.unit = unit;
    return this;			
    
  }
  
  public String getTypeName() {
    return this.unit;
  }
  
  public RCNumberWithUnitValue createInstance(final RCExtensiableEntity rootOwner) {RCNumberWithUnitValue rCNumberWithUnitValue=RCNumberWithUnitValueImpl.create(getObjectFactory());
    final Procedure1<RCNumberWithUnitValue> _function = new Procedure1<RCNumberWithUnitValue>() {
        public void apply(final RCNumberWithUnitValue it) {
          it.setRootOwner(rootOwner);
        }
      };
    RCNumberWithUnitValue _doubleArrow = ObjectExtensions.<RCNumberWithUnitValue>operator_doubleArrow(rCNumberWithUnitValue, _function);
    return _doubleArrow;
  }
  
  public static RCNumberWithUnitType create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.entityextension.RCNumberWithUnitType rCNumberWithUnitType = new com.fudanmed.platform.core.entityextension.impl.RCNumberWithUnitTypeImpl(
    );
    objectFactory.create(rCNumberWithUnitType);
    return rCNumberWithUnitType;			
    
  }
  
  public RCNumberWithUnitTypeProxy toProxy() {
    com.fudanmed.platform.core.entityextension.proxy.RCNumberWithUnitTypeProxy proxy = new com.fudanmed.platform.core.entityextension.proxy.RCNumberWithUnitTypeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
