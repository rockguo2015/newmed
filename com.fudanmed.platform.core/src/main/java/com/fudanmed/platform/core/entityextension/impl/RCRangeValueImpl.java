package com.fudanmed.platform.core.entityextension.impl;

import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCRangeValue;
import com.fudanmed.platform.core.entityextension.RCType;
import com.fudanmed.platform.core.entityextension.impl.RCPrimaryValueImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCRangeValueProxy;
import com.google.common.base.Objects;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Entity
@DiscriminatorValue("RCRANGEVALUE_TYPE")
public class RCRangeValueImpl extends RCPrimaryValueImpl implements RCRangeValue {
  public RCRangeValueImpl() {
    super();
  }
  
  private Double lowerBound;
  
  public Double getLowerBound() {
    return this.lowerBound;
  }
  
  public RCRangeValue setLowerBound(final Double lowerBound) {
    this.lowerBound = lowerBound;
    return this;			
    
  }
  
  private Double upperBound;
  
  public Double getUpperBound() {
    return this.upperBound;
  }
  
  public RCRangeValue setUpperBound(final Double upperBound) {
    this.upperBound = upperBound;
    return this;			
    
  }
  
  public String getEntityName() {
    Object _xifexpression = null;
    boolean _notEquals = (!Objects.equal(this.lowerBound, null));
    if (_notEquals) {
      _xifexpression = this.lowerBound;
    } else {
      _xifexpression = "_";
    }
    String _plus = ("[" + ((Comparable<Object>)_xifexpression));
    String _plus_1 = (_plus + 
      ",");
    Object _xifexpression_1 = null;
    boolean _notEquals_1 = (!Objects.equal(this.upperBound, null));
    if (_notEquals_1) {
      _xifexpression_1 = this.upperBound;
    } else {
      _xifexpression_1 = "_";
    }
    String _plus_2 = (_plus_1 + ((Comparable<Object>)_xifexpression_1));
    String _plus_3 = (_plus_2 + 
      "]");
    return _plus_3;
  }
  
  public void setValue(final Double lowerBound, final Double upperBound) {
    this.lowerBound = lowerBound;
    this.upperBound = upperBound;
  }
  
  public RCRangeValue cloneIn(final RCExtensiableEntity rootOwner) {RCRangeValue rCRangeValue=RCRangeValueImpl.create(getObjectFactory());
    final Procedure1<RCRangeValue> _function = new Procedure1<RCRangeValue>() {
        public void apply(final RCRangeValue it) {
          it.setRootOwner(rootOwner);
          RCType _type = RCRangeValueImpl.this.getType();
          it.setType(_type);
          it.setLowerBound(RCRangeValueImpl.this.lowerBound);
          it.setUpperBound(RCRangeValueImpl.this.upperBound);
        }
      };
    RCRangeValue _doubleArrow = ObjectExtensions.<RCRangeValue>operator_doubleArrow(rCRangeValue, _function);
    return _doubleArrow;
  }
  
  public static RCRangeValue create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.entityextension.RCRangeValue rCRangeValue = new com.fudanmed.platform.core.entityextension.impl.RCRangeValueImpl(
    );
    objectFactory.create(rCRangeValue);
    return rCRangeValue;			
    
  }
  
  public RCRangeValueProxy toProxy() {
    com.fudanmed.platform.core.entityextension.proxy.RCRangeValueProxy proxy = new com.fudanmed.platform.core.entityextension.proxy.RCRangeValueProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
