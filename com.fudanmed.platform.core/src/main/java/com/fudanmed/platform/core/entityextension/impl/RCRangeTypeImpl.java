package com.fudanmed.platform.core.entityextension.impl;

import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCNumberWithUnitType;
import com.fudanmed.platform.core.entityextension.RCRangeType;
import com.fudanmed.platform.core.entityextension.RCRangeValue;
import com.fudanmed.platform.core.entityextension.impl.RCCustomizableTypeImpl;
import com.fudanmed.platform.core.entityextension.impl.RCNumberWithUnitTypeImpl;
import com.fudanmed.platform.core.entityextension.impl.RCRangeValueImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCRangeTypeProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Entity
@DiscriminatorValue("RCRANGETYPE_TYPE")
public class RCRangeTypeImpl extends RCCustomizableTypeImpl implements RCRangeType {
  public RCRangeTypeImpl() {
    super();
  }
  
  @JoinColumn(name = "numberType_id")
  @ManyToOne(targetEntity = RCNumberWithUnitTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCNumberWithUnitType numberType;
  
  public RCNumberWithUnitType getNumberType() {
    return this.numberType;
  }
  
  public RCRangeType setNumberType(final RCNumberWithUnitType numberType) {
    this.numberType = numberType;
    return this;			
    
  }
  
  public String getTypeName() {
    String _unit = this.numberType.getUnit();
    String _plus = (_unit + "[\u8303\u56F4]");
    return _plus;
  }
  
  public String getAlias() {
    String _alias = this.numberType.getAlias();
    String _plus = (_alias + "[\u8303\u56F4]");
    return _plus;
  }
  
  public RCRangeValue createInstance(final RCExtensiableEntity rootOwner) {RCRangeValue rCRangeValue=RCRangeValueImpl.create(getObjectFactory());
    final Procedure1<RCRangeValue> _function = new Procedure1<RCRangeValue>() {
        public void apply(final RCRangeValue it) {
          it.setRootOwner(rootOwner);
        }
      };
    RCRangeValue _doubleArrow = ObjectExtensions.<RCRangeValue>operator_doubleArrow(rCRangeValue, _function);
    return _doubleArrow;
  }
  
  public static RCRangeType create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.entityextension.RCRangeType rCRangeType = new com.fudanmed.platform.core.entityextension.impl.RCRangeTypeImpl(
    );
    objectFactory.create(rCRangeType);
    return rCRangeType;			
    
  }
  
  public RCRangeTypeProxy toProxy() {
    com.fudanmed.platform.core.entityextension.proxy.RCRangeTypeProxy proxy = new com.fudanmed.platform.core.entityextension.proxy.RCRangeTypeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
