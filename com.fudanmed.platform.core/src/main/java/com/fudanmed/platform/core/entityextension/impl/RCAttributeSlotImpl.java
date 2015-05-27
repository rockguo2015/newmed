package com.fudanmed.platform.core.entityextension.impl;

import com.fudanmed.platform.core.entityextension.RCAttribute;
import com.fudanmed.platform.core.entityextension.RCAttributeSlot;
import com.fudanmed.platform.core.entityextension.RCCompositeValue;
import com.fudanmed.platform.core.entityextension.RCType;
import com.fudanmed.platform.core.entityextension.RCValue;
import com.fudanmed.platform.core.entityextension.impl.RCAttributeImpl;
import com.fudanmed.platform.core.entityextension.impl.RCCompositeValueImpl;
import com.fudanmed.platform.core.entityextension.impl.RCValueImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCATTRIBUTESLOT_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcattributeslot")
public class RCAttributeSlotImpl extends BaseModelObject implements RCAttributeSlot {
  public RCAttributeSlotImpl() {
    super();
  }
  
  public RCAttributeSlotImpl(final RCCompositeValue attrValue) {
    super();
    this.attrValue = attrValue;
  }
  
  @JoinColumn(name = "attrValue_id")
  @ManyToOne(targetEntity = RCCompositeValueImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCCompositeValue attrValue;
  
  public RCCompositeValue getAttrValue() {
    return this.attrValue;
  }
  
  public RCAttributeSlot setAttrValue(final RCCompositeValue attrValue) {
    this.attrValue = attrValue;
    return this;			
    
  }
  
  @JoinColumn(name = "attr_id")
  @ManyToOne(targetEntity = RCAttributeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCAttribute attr;
  
  public RCAttribute getAttr() {
    return this.attr;
  }
  
  public RCAttributeSlot setAttr(final RCAttribute attr) {
    this.attr = attr;
    return this;			
    
  }
  
  @JoinColumn(name = "value_id")
  @OneToOne(targetEntity = RCValueImpl.class, cascade = CascadeType.ALL)
  private RCValue value;
  
  public RCValue getValue() {
    return this.value;
  }
  
  public RCAttributeSlot setValue(final RCValue value) {
    this.value = value;
    return this;			
    
  }
  
  public RCType getValueType() {
    RCType _typeRef = this.attr.getTypeRef();
    return _typeRef;
  }
  
  public static RCAttributeSlot create(final RCCompositeValue attrValue, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.entityextension.RCAttributeSlot rCAttributeSlot = new com.fudanmed.platform.core.entityextension.impl.RCAttributeSlotImpl(
    	attrValue
    );
    objectFactory.create(rCAttributeSlot);
    return rCAttributeSlot;			
    
  }
  
  public RCAttributeSlotProxy toProxy() {
    com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy proxy = new com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
