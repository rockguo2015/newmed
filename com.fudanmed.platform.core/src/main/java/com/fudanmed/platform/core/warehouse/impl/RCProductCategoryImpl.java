package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCProductCategory;
import com.fudanmed.platform.core.warehouse.RCProductType;
import com.fudanmed.platform.core.warehouse.impl.RCProductTypeImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy;
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
@DiscriminatorValue("RCPRODUCTCATEGORY_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcproductcategory")
public class RCProductCategoryImpl extends BaseModelObject implements RCProductCategory {
  public RCProductCategoryImpl() {
    super();
  }
  
  public RCProductCategoryImpl(final RCProductCategory parent) {
    super();
    this.parent = parent;
  }
  
  private String code;
  
  public String getCode() {
    return this.code;
  }
  
  public RCProductCategory setCode(final String code) {
    this.code = code;
    return this;			
    
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public RCProductCategory setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  private String simplePy;
  
  public String getSimplePy() {
    return this.simplePy;
  }
  
  public RCProductCategory setSimplePy(final String simplePy) {
    this.simplePy = simplePy;
    return this;			
    
  }
  
  @JoinColumn(name = "parent_id")
  @ManyToOne(targetEntity = RCProductCategoryImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCProductCategory parent;
  
  public RCProductCategory getParent() {
    return this.parent;
  }
  
  public RCProductCategory setParent(final RCProductCategory parent) {
    this.parent = parent;
    return this;			
    
  }
  
  @OneToMany(targetEntity = RCProductCategoryImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "parent")
  private Collection<RCProductCategory> subCategories = new java.util.ArrayList<com.fudanmed.platform.core.warehouse.RCProductCategory>();;
  
  public Collection<RCProductCategory> getSubCategories() {
    return this.subCategories;
  }
  
  public RCProductCategory createAndAddtoSubCategories() {
    getSubCategories().size();
    com.fudanmed.platform.core.warehouse.RCProductCategory rCProductCategory = new com.fudanmed.platform.core.warehouse.impl.RCProductCategoryImpl(this);
    getObjectFactory().create(rCProductCategory);
    getSubCategories().add(rCProductCategory);
    return rCProductCategory;
    
  }
  
  public RCProductCategory removeAllSubCategories() {
    for(RCProductCategory obj : this.subCategories){
    	getObjectFactory().delete(obj);
    }
    this.subCategories.clear();
    return this;	
    
  }
  
  public RCProductCategory removeFromSubCategories(final RCProductCategory rCProductCategory) {
    this.subCategories.remove(rCProductCategory);
    getObjectFactory().delete(rCProductCategory);
    return this;
    
  }
  
  @OneToMany(targetEntity = RCProductTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "category")
  private Collection<RCProductType> productTypes = new java.util.ArrayList<com.fudanmed.platform.core.warehouse.RCProductType>();;
  
  public Collection<RCProductType> getProductTypes() {
    return this.productTypes;
  }
  
  public RCProductType createAndAddtoProductTypes() {
    getProductTypes().size();
    com.fudanmed.platform.core.warehouse.RCProductType rCProductType = new com.fudanmed.platform.core.warehouse.impl.RCProductTypeImpl(this);
    getObjectFactory().create(rCProductType);
    getProductTypes().add(rCProductType);
    return rCProductType;
    
  }
  
  public RCProductCategory removeAllProductTypes() {
    for(RCProductType obj : this.productTypes){
    	getObjectFactory().delete(obj);
    }
    this.productTypes.clear();
    return this;	
    
  }
  
  public RCProductCategory removeFromProductTypes(final RCProductType rCProductType) {
    this.productTypes.remove(rCProductType);
    getObjectFactory().delete(rCProductType);
    return this;
    
  }
  
  public String getEntityName() {
    return this.name;
  }
  
  public String getNameField() {
    return "name";
  }
  
  public static RCProductCategory create(final RCProductCategory parent, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.warehouse.RCProductCategory rCProductCategory = new com.fudanmed.platform.core.warehouse.impl.RCProductCategoryImpl(
    	parent
    );
    objectFactory.create(rCProductCategory);
    return rCProductCategory;			
    
  }
  
  public RCProductCategoryProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
