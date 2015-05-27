package com.fudanmed.platform.core.entityextension.impl;

import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCNumberWithUnitValue;
import com.fudanmed.platform.core.entityextension.RCType;
import com.fudanmed.platform.core.entityextension.impl.RCPrimaryValueImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCNumberWithUnitValueProxy;
import com.google.common.base.Objects;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Entity
@DiscriminatorValue("RCNUMBERWITHUNITVALUE_TYPE")
public class RCNumberWithUnitValueImpl extends RCPrimaryValueImpl implements RCNumberWithUnitValue {
  public RCNumberWithUnitValueImpl() {
    super();
  }
  
  private Double value;
  
  public Double getValue() {
    return this.value;
  }
  
  public RCNumberWithUnitValue setValue(final Double value) {
    this.value = value;
    return this;			
    
  }
  
  public String getEntityName() {
    String _xifexpression = null;
    boolean _notEquals = (!Objects.equal(this.value, null));
    if (_notEquals) {
      String _string = this.value.toString();
      _xifexpression = _string;
    } else {
      _xifexpression = "";
    }
    return _xifexpression;
  }
  
  public RCNumberWithUnitValue cloneIn(final RCExtensiableEntity rootOwner) {RCNumberWithUnitValue rCNumberWithUnitValue=RCNumberWithUnitValueImpl.create(getObjectFactory());
    final Procedure1<RCNumberWithUnitValue> _function = new Procedure1<RCNumberWithUnitValue>() {
        public void apply(final RCNumberWithUnitValue it) {
          it.setRootOwner(rootOwner);
          RCType _type = RCNumberWithUnitValueImpl.this.getType();
          it.setType(_type);
          it.setValue(RCNumberWithUnitValueImpl.this.value);
        }
      };
    RCNumberWithUnitValue _doubleArrow = ObjectExtensions.<RCNumberWithUnitValue>operator_doubleArrow(rCNumberWithUnitValue, _function);
    return _doubleArrow;
  }
  
  public static RCNumberWithUnitValue create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.entityextension.RCNumberWithUnitValue rCNumberWithUnitValue = new com.fudanmed.platform.core.entityextension.impl.RCNumberWithUnitValueImpl(
    );
    objectFactory.create(rCNumberWithUnitValue);
    return rCNumberWithUnitValue;			
    
  }
  
  public RCNumberWithUnitValueProxy toProxy() {
    com.fudanmed.platform.core.entityextension.proxy.RCNumberWithUnitValueProxy proxy = new com.fudanmed.platform.core.entityextension.proxy.RCNumberWithUnitValueProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
