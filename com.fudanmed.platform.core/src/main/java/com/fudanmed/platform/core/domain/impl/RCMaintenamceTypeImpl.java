package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCFaultType;
import com.fudanmed.platform.core.domain.RCMaintenamceType;
import com.fudanmed.platform.core.domain.impl.RCFaultTypeImpl;
import com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IGenericQuery;
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
@DiscriminatorValue("RCMAINTENAMCETYPE_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcmaintenamcetype")
public class RCMaintenamceTypeImpl extends BaseModelObject implements RCMaintenamceType {
  public RCMaintenamceTypeImpl() {
    super();
  }
  
  public RCMaintenamceTypeImpl(final RCMaintenamceType parent) {
    super();
    this.parent = parent;
  }
  
  private String code;
  
  public String getCode() {
    return this.code;
  }
  
  public RCMaintenamceType setCode(final String code) {
    this.code = code;
    return this;			
    
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public RCMaintenamceType setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  private String simplePy;
  
  public String getSimplePy() {
    return this.simplePy;
  }
  
  public RCMaintenamceType setSimplePy(final String simplePy) {
    this.simplePy = simplePy;
    return this;			
    
  }
  
  @JoinColumn(name = "parent_id")
  @ManyToOne(targetEntity = RCMaintenamceTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCMaintenamceType parent;
  
  public RCMaintenamceType getParent() {
    return this.parent;
  }
  
  public RCMaintenamceType setParent(final RCMaintenamceType parent) {
    this.parent = parent;
    return this;			
    
  }
  
  @OneToMany(targetEntity = RCMaintenamceTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "parent")
  private Collection<RCMaintenamceType> subTypes = new java.util.ArrayList<com.fudanmed.platform.core.domain.RCMaintenamceType>();;
  
  public Collection<RCMaintenamceType> getSubTypes() {
    return this.subTypes;
  }
  
  public RCMaintenamceType createAndAddtoSubTypes() {
    getSubTypes().size();
    com.fudanmed.platform.core.domain.RCMaintenamceType rCMaintenamceType = new com.fudanmed.platform.core.domain.impl.RCMaintenamceTypeImpl(this);
    getObjectFactory().create(rCMaintenamceType);
    getSubTypes().add(rCMaintenamceType);
    return rCMaintenamceType;
    
  }
  
  public RCMaintenamceType removeAllSubTypes() {
    for(RCMaintenamceType obj : this.subTypes){
    	getObjectFactory().delete(obj);
    }
    this.subTypes.clear();
    return this;	
    
  }
  
  public RCMaintenamceType removeFromSubTypes(final RCMaintenamceType rCMaintenamceType) {
    this.subTypes.remove(rCMaintenamceType);
    getObjectFactory().delete(rCMaintenamceType);
    return this;
    
  }
  
  @OneToMany(targetEntity = RCFaultTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "mtype")
  private Collection<RCFaultType> faultTypes = new java.util.ArrayList<com.fudanmed.platform.core.domain.RCFaultType>();;
  
  public Collection<RCFaultType> getFaultTypes() {
    return this.faultTypes;
  }
  
  public RCFaultType createAndAddtoFaultTypes() {
    getFaultTypes().size();
    com.fudanmed.platform.core.domain.RCFaultType rCFaultType = new com.fudanmed.platform.core.domain.impl.RCFaultTypeImpl(this);
    getObjectFactory().create(rCFaultType);
    getFaultTypes().add(rCFaultType);
    return rCFaultType;
    
  }
  
  public RCMaintenamceType removeAllFaultTypes() {
    for(RCFaultType obj : this.faultTypes){
    	getObjectFactory().delete(obj);
    }
    this.faultTypes.clear();
    return this;	
    
  }
  
  public RCMaintenamceType removeFromFaultTypes(final RCFaultType rCFaultType) {
    this.faultTypes.remove(rCFaultType);
    getObjectFactory().delete(rCFaultType);
    return this;
    
  }
  
  public String getEntityName() {
    return this.name;
  }
  
  public String getNameField() {
    return "name";
  }
  
  public Collection<RCFaultType> getAllSubFaultTypes() {
    Collection<RCFaultType> _xblockexpression = null;
    {
      Long _id = this.getId();
      String _plus = ("%[" + _id);
      final String idTag = (_plus + "]%");
      IGenericQuery<RCFaultType> query=getObjectFactory().createGenericQuery(RCFaultType.class,"select ft from com.fudanmed.platform.core.domain.impl.RCFaultTypeImpl as ft   where (ft.mtypePath  LIKE :idTag) and  ft.active = 1      ").setParameter("idTag",idTag);
      Collection<RCFaultType> _list = query.list();
      _xblockexpression = (_list);
    }
    return _xblockexpression;
  }
  
  public static RCMaintenamceType create(final RCMaintenamceType parent, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.domain.RCMaintenamceType rCMaintenamceType = new com.fudanmed.platform.core.domain.impl.RCMaintenamceTypeImpl(
    	parent
    );
    objectFactory.create(rCMaintenamceType);
    return rCMaintenamceType;			
    
  }
  
  public RCMaintenamceTypeProxy toProxy() {
    com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy proxy = new com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
