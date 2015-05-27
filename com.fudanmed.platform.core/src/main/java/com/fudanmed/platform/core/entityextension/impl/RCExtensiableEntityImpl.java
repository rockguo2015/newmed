package com.fudanmed.platform.core.entityextension.impl;

import com.fudanmed.platform.core.entityextension.RCCompositeType;
import com.fudanmed.platform.core.entityextension.RCCompositeValue;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntityType;
import com.fudanmed.platform.core.entityextension.RCType;
import com.fudanmed.platform.core.entityextension.impl.RCCompositeValueImpl;
import com.fudanmed.platform.core.entityextension.impl.RCExtensiableEntityTypeImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCExtensiableEntityProxy;
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
@DiscriminatorValue("RCEXTENSIABLEENTITY_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcextensiableentity")
public class RCExtensiableEntityImpl extends BaseModelObject implements RCExtensiableEntity {
  public RCExtensiableEntityImpl() {
    super();
  }
  
  @JoinColumn(name = "type_id")
  @ManyToOne(targetEntity = RCExtensiableEntityTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCExtensiableEntityType type;
  
  public RCExtensiableEntityType getType() {
    return this.type;
  }
  
  public RCExtensiableEntity setType(final RCExtensiableEntityType type) {
    this.type = type;
    return this;			
    
  }
  
  @JoinColumn(name = "value_id")
  @OneToOne(targetEntity = RCCompositeValueImpl.class, cascade = CascadeType.ALL)
  private RCCompositeValue value;
  
  public RCCompositeValue getValue() {
    return this.value;
  }
  
  public RCExtensiableEntity setValue(final RCCompositeValue value) {
    this.value = value;
    return this;			
    
  }
  
  public RCType getValueType() {
    RCCompositeType _rootType = this.type.getRootType();
    return _rootType;
  }
  
  public static RCExtensiableEntity create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.entityextension.RCExtensiableEntity rCExtensiableEntity = new com.fudanmed.platform.core.entityextension.impl.RCExtensiableEntityImpl(
    );
    objectFactory.create(rCExtensiableEntity);
    return rCExtensiableEntity;			
    
  }
  
  public RCExtensiableEntityProxy toProxy() {
    com.fudanmed.platform.core.entityextension.proxy.RCExtensiableEntityProxy proxy = new com.fudanmed.platform.core.entityextension.proxy.RCExtensiableEntityProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
