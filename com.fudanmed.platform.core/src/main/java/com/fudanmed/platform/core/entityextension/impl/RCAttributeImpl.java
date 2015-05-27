package com.fudanmed.platform.core.entityextension.impl;

import com.fudanmed.platform.core.entityextension.RCAttribute;
import com.fudanmed.platform.core.entityextension.RCCompositeType;
import com.fudanmed.platform.core.entityextension.RCType;
import com.fudanmed.platform.core.entityextension.impl.RCCompositeTypeImpl;
import com.fudanmed.platform.core.entityextension.impl.RCTypeImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCAttributeProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCATTRIBUTE_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcattribute")
public class RCAttributeImpl extends BaseModelObject implements RCAttribute {
  public RCAttributeImpl() {
    super();
  }
  
  public RCAttributeImpl(final RCCompositeType type) {
    super();
    this.type = type;
  }
  
  @JoinColumn(name = "type_id")
  @ManyToOne(targetEntity = RCCompositeTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCCompositeType type;
  
  public RCCompositeType getType() {
    return this.type;
  }
  
  public RCAttribute setType(final RCCompositeType type) {
    this.type = type;
    return this;			
    
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public RCAttribute setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  @JoinColumn(name = "typeRef_id")
  @ManyToOne(targetEntity = RCTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCType typeRef;
  
  public RCType getTypeRef() {
    return this.typeRef;
  }
  
  public RCAttribute setTypeRef(final RCType typeRef) {
    this.typeRef = typeRef;
    return this;			
    
  }
  
  public static RCAttribute create(final RCCompositeType type, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.entityextension.RCAttribute rCAttribute = new com.fudanmed.platform.core.entityextension.impl.RCAttributeImpl(
    	type
    );
    objectFactory.create(rCAttribute);
    return rCAttribute;			
    
  }
  
  public RCAttributeProxy toProxy() {
    com.fudanmed.platform.core.entityextension.proxy.RCAttributeProxy proxy = new com.fudanmed.platform.core.entityextension.proxy.RCAttributeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
