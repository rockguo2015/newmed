package com.fudanmed.platform.core.entityextension.impl;

import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCNumberValue;
import com.fudanmed.platform.core.entityextension.RCType;
import com.fudanmed.platform.core.entityextension.impl.RCPrimaryValueImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCNumberValueProxy;
import com.google.common.base.Objects;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Entity
@DiscriminatorValue("RCNUMBERVALUE_TYPE")
public class RCNumberValueImpl extends RCPrimaryValueImpl implements RCNumberValue {
  public RCNumberValueImpl() {
    super();
  }
  
  private Double value;
  
  public Double getValue() {
    return this.value;
  }
  
  public RCNumberValue setValue(final Double value) {
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
  
  public RCNumberValue cloneIn(final RCExtensiableEntity rootOwner) {RCNumberValue rCNumberValue=RCNumberValueImpl.create(getObjectFactory());
    final Procedure1<RCNumberValue> _function = new Procedure1<RCNumberValue>() {
        public void apply(final RCNumberValue it) {
          it.setRootOwner(rootOwner);
          RCType _type = RCNumberValueImpl.this.getType();
          it.setType(_type);
          it.setValue(RCNumberValueImpl.this.value);
        }
      };
    RCNumberValue _doubleArrow = ObjectExtensions.<RCNumberValue>operator_doubleArrow(rCNumberValue, _function);
    return _doubleArrow;
  }
  
  public static RCNumberValue create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.entityextension.RCNumberValue rCNumberValue = new com.fudanmed.platform.core.entityextension.impl.RCNumberValueImpl(
    );
    objectFactory.create(rCNumberValue);
    return rCNumberValue;			
    
  }
  
  public RCNumberValueProxy toProxy() {
    com.fudanmed.platform.core.entityextension.proxy.RCNumberValueProxy proxy = new com.fudanmed.platform.core.entityextension.proxy.RCNumberValueProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
