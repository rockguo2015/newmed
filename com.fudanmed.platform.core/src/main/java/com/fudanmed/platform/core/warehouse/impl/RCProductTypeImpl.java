package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCProductCategory;
import com.fudanmed.platform.core.warehouse.RCProductType;
import com.fudanmed.platform.core.warehouse.impl.RCProductCategoryImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCProductTypeProxy;
import com.google.common.base.Objects;
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
@DiscriminatorValue("RCPRODUCTTYPE_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcproducttype")
public class RCProductTypeImpl extends BaseModelObject implements RCProductType {
  public RCProductTypeImpl() {
    super();
  }
  
  public RCProductTypeImpl(final RCProductCategory category) {
    super();
    this.category = category;
  }
  
  @JoinColumn(name = "category_id")
  @ManyToOne(targetEntity = RCProductCategoryImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCProductCategory category;
  
  public RCProductCategory getCategory() {
    return this.category;
  }
  
  public RCProductType setCategory(final RCProductCategory category) {
    this.category = category;
    return this;			
    
  }
  
  private String code;
  
  public String getCode() {
    return this.code;
  }
  
  public RCProductType setCode(final String code) {
    this.code = code;
    return this;			
    
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public RCProductType setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  private String simplePy;
  
  public String getSimplePy() {
    return this.simplePy;
  }
  
  public RCProductType setSimplePy(final String simplePy) {
    this.simplePy = simplePy;
    return this;			
    
  }
  
  private String categoryPath;
  
  public String getCategoryPath() {
    return this.categoryPath;
  }
  
  public RCProductType setCategoryPath(final String categoryPath) {
    this.categoryPath = categoryPath;
    return this;			
    
  }
  
  public void updateCategoryPath() {
    String categoryp = "";
    RCProductCategory curCategory = this.category;
    boolean _notEquals = (!Objects.equal(curCategory, null));
    boolean _while = _notEquals;
    while (_while) {
      {
        String _plus = (categoryp + "[");
        Long _id = curCategory.getId();
        String _string = _id.toString();
        String _plus_1 = (_plus + _string);
        String _plus_2 = (_plus_1 + "]");
        categoryp = _plus_2;
        RCProductCategory _parent = curCategory.getParent();
        curCategory = _parent;
      }
      boolean _notEquals_1 = (!Objects.equal(curCategory, null));
      _while = _notEquals_1;
    }
    this.categoryPath = categoryp;
  }
  
  public String getEntityName() {
    return this.name;
  }
  
  public String getNameField() {
    return "name";
  }
  
  public static RCProductType create(final RCProductCategory category, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.warehouse.RCProductType rCProductType = new com.fudanmed.platform.core.warehouse.impl.RCProductTypeImpl(
    	category
    );
    objectFactory.create(rCProductType);
    return rCProductType;			
    
  }
  
  public RCProductTypeProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCProductTypeProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCProductTypeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
