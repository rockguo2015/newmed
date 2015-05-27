package com.fudanmed.platform.core.entityextension.impl;

import com.fudanmed.platform.core.entityextension.RCAttributeSlot;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCType;
import com.fudanmed.platform.core.entityextension.RCValue;
import com.fudanmed.platform.core.entityextension.impl.RCAttributeSlotImpl;
import com.fudanmed.platform.core.entityextension.impl.RCExtensiableEntityImpl;
import com.fudanmed.platform.core.entityextension.impl.RCTypeImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCValueProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCVALUE_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcvalue")
public abstract class RCValueImpl extends BaseModelObject implements RCValue {
  public RCValueImpl() {
    super();
  }
  
  private String instanceName;
  
  public String getInstanceName() {
    return this.instanceName;
  }
  
  public RCValue setInstanceName(final String instanceName) {
    this.instanceName = instanceName;
    return this;			
    
  }
  
  @JoinColumn(name = "type_id")
  @ManyToOne(targetEntity = RCTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCType type;
  
  public RCType getType() {
    return this.type;
  }
  
  public RCValue setType(final RCType type) {
    this.type = type;
    return this;			
    
  }
  
  @JoinColumn(name = "rootOwner_id")
  @ManyToOne(targetEntity = RCExtensiableEntityImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCExtensiableEntity rootOwner;
  
  public RCExtensiableEntity getRootOwner() {
    return this.rootOwner;
  }
  
  public RCValue setRootOwner(final RCExtensiableEntity rootOwner) {
    this.rootOwner = rootOwner;
    return this;			
    
  }
  
  @JoinColumn(name = "slotOwner_id")
  @ManyToOne(targetEntity = RCAttributeSlotImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCAttributeSlot slotOwner;
  
  public RCAttributeSlot getSlotOwner() {
    return this.slotOwner;
  }
  
  public RCValue setSlotOwner(final RCAttributeSlot slotOwner) {
    this.slotOwner = slotOwner;
    return this;			
    
  }
  
  public RCValueProxy toProxy() {
    com.fudanmed.platform.core.entityextension.proxy.RCValueProxy proxy = new com.fudanmed.platform.core.entityextension.proxy.RCValueProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
