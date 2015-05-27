package com.fudanmed.platform.core.entityextension.impl;

import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCStringValue;
import com.fudanmed.platform.core.entityextension.RCType;
import com.fudanmed.platform.core.entityextension.impl.RCPrimaryValueImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCStringValueProxy;
import com.google.common.base.Objects;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Entity
@DiscriminatorValue("RCSTRINGVALUE_TYPE")
public class RCStringValueImpl extends RCPrimaryValueImpl implements RCStringValue {
  public RCStringValueImpl() {
    super();
  }
  
  private String stringValue;
  
  public String getStringValue() {
    return this.stringValue;
  }
  
  public RCStringValue setStringValue(final String stringValue) {
    this.stringValue = stringValue;
    return this;			
    
  }
  
  public String getEntityName() {
    String _xifexpression = null;
    String _value = this.getValue();
    boolean _notEquals = (!Objects.equal(_value, null));
    if (_notEquals) {
      String _value_1 = this.getValue();
      String _string = _value_1.toString();
      _xifexpression = _string;
    } else {
      _xifexpression = "";
    }
    return _xifexpression;
  }
  
  public String getValue() {
    return this.stringValue;
  }
  
  public void setValue(final String v) {
    this.stringValue = v;
  }
  
  public RCStringValue cloneIn(final RCExtensiableEntity rootOwner) {RCStringValue rCStringValue=RCStringValueImpl.create(getObjectFactory());
    final Procedure1<RCStringValue> _function = new Procedure1<RCStringValue>() {
        public void apply(final RCStringValue it) {
          it.setRootOwner(rootOwner);
          RCType _type = RCStringValueImpl.this.getType();
          it.setType(_type);
          it.setStringValue(RCStringValueImpl.this.stringValue);
        }
      };
    RCStringValue _doubleArrow = ObjectExtensions.<RCStringValue>operator_doubleArrow(rCStringValue, _function);
    return _doubleArrow;
  }
  
  public static RCStringValue create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.entityextension.RCStringValue rCStringValue = new com.fudanmed.platform.core.entityextension.impl.RCStringValueImpl(
    );
    objectFactory.create(rCStringValue);
    return rCStringValue;			
    
  }
  
  public RCStringValueProxy toProxy() {
    com.fudanmed.platform.core.entityextension.proxy.RCStringValueProxy proxy = new com.fudanmed.platform.core.entityextension.proxy.RCStringValueProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
