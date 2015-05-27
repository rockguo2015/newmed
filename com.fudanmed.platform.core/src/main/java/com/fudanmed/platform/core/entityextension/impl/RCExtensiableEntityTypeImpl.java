package com.fudanmed.platform.core.entityextension.impl;

import com.fudanmed.platform.core.entityextension.RCCompositeType;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntityType;
import com.fudanmed.platform.core.entityextension.impl.RCCompositeTypeImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCExtensiableEntityTypeProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCEXTENSIABLEENTITYTYPE_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcextensiableentitytype")
public class RCExtensiableEntityTypeImpl extends BaseModelObject implements RCExtensiableEntityType {
  public RCExtensiableEntityTypeImpl() {
    super();
  }
  
  @JoinColumn(name = "rootType_id")
  @ManyToOne(targetEntity = RCCompositeTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCCompositeType rootType;
  
  public RCCompositeType getRootType() {
    return this.rootType;
  }
  
  public RCExtensiableEntityType setRootType(final RCCompositeType rootType) {
    this.rootType = rootType;
    return this;			
    
  }
  
  @OneToMany(targetEntity = RCCompositeTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "extensiableEntity")
  private Collection<RCCompositeType> compositeTypes = new java.util.ArrayList<com.fudanmed.platform.core.entityextension.RCCompositeType>();;
  
  public Collection<RCCompositeType> getCompositeTypes() {
    return this.compositeTypes;
  }
  
  public RCCompositeType createAndAddtoCompositeTypes() {
    getCompositeTypes().size();
    com.fudanmed.platform.core.entityextension.RCCompositeType rCCompositeType = new com.fudanmed.platform.core.entityextension.impl.RCCompositeTypeImpl(this);
    getObjectFactory().create(rCCompositeType);
    getCompositeTypes().add(rCCompositeType);
    return rCCompositeType;
    
  }
  
  public RCExtensiableEntityType removeAllCompositeTypes() {
    for(RCCompositeType obj : this.compositeTypes){
    	getObjectFactory().delete(obj);
    }
    this.compositeTypes.clear();
    return this;	
    
  }
  
  public RCExtensiableEntityType removeFromCompositeTypes(final RCCompositeType rCCompositeType) {
    this.compositeTypes.remove(rCCompositeType);
    getObjectFactory().delete(rCCompositeType);
    return this;
    
  }
  
  public static RCExtensiableEntityType create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.entityextension.RCExtensiableEntityType rCExtensiableEntityType = new com.fudanmed.platform.core.entityextension.impl.RCExtensiableEntityTypeImpl(
    );
    objectFactory.create(rCExtensiableEntityType);
    return rCExtensiableEntityType;			
    
  }
  
  public RCExtensiableEntityTypeProxy toProxy() {
    com.fudanmed.platform.core.entityextension.proxy.RCExtensiableEntityTypeProxy proxy = new com.fudanmed.platform.core.entityextension.proxy.RCExtensiableEntityTypeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
