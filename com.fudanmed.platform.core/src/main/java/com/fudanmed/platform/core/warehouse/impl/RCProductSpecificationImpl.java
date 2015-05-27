package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.common.RCMaterialBrand;
import com.fudanmed.platform.core.common.impl.RCMaterialBrandImpl;
import com.fudanmed.platform.core.domain.RCSupplier;
import com.fudanmed.platform.core.domain.impl.RCSupplierImpl;
import com.fudanmed.platform.core.warehouse.RCProduceSpecificationUnit;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductType;
import com.fudanmed.platform.core.warehouse.impl.RCProduceSpecificationUnitImpl;
import com.fudanmed.platform.core.warehouse.impl.RCProductTypeImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
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
@DiscriminatorValue("RCPRODUCTSPECIFICATION_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcproductspecification")
public class RCProductSpecificationImpl extends BaseModelObject implements RCProductSpecification {
  public RCProductSpecificationImpl() {
    super();
  }
  
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public RCProductSpecification setSid(final String sid) {
    this.sid = sid;
    return this;			
    
  }
  
  private String materialId;
  
  public String getMaterialId() {
    return this.materialId;
  }
  
  public RCProductSpecification setMaterialId(final String materialId) {
    this.materialId = materialId;
    return this;			
    
  }
  
  @JoinColumn(name = "brandType_id")
  @ManyToOne(targetEntity = RCMaterialBrandImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCMaterialBrand brandType;
  
  public RCMaterialBrand getBrandType() {
    return this.brandType;
  }
  
  public RCProductSpecification setBrandType(final RCMaterialBrand brandType) {
    this.brandType = brandType;
    return this;			
    
  }
  
  private Double referencePrice;
  
  public Double getReferencePrice() {
    return this.referencePrice;
  }
  
  public RCProductSpecification setReferencePrice(final Double referencePrice) {
    this.referencePrice = referencePrice;
    return this;			
    
  }
  
  private Integer shelfLife;
  
  public Integer getShelfLife() {
    return this.shelfLife;
  }
  
  public RCProductSpecification setShelfLife(final Integer shelfLife) {
    this.shelfLife = shelfLife;
    return this;			
    
  }
  
  private Integer lowerStorage;
  
  public Integer getLowerStorage() {
    return this.lowerStorage;
  }
  
  public RCProductSpecification setLowerStorage(final Integer lowerStorage) {
    this.lowerStorage = lowerStorage;
    return this;			
    
  }
  
  private Integer upperStorage;
  
  public Integer getUpperStorage() {
    return this.upperStorage;
  }
  
  public RCProductSpecification setUpperStorage(final Integer upperStorage) {
    this.upperStorage = upperStorage;
    return this;			
    
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public RCProductSpecification setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  private String typeDesc;
  
  public String getTypeDesc() {
    return this.typeDesc;
  }
  
  public RCProductSpecification setTypeDesc(final String typeDesc) {
    this.typeDesc = typeDesc;
    return this;			
    
  }
  
  @JoinColumn(name = "productType_id")
  @ManyToOne(targetEntity = RCProductTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCProductType productType;
  
  public RCProductType getProductType() {
    return this.productType;
  }
  
  public RCProductSpecification setProductType(final RCProductType productType) {
    this.productType = productType;
    return this;			
    
  }
  
  @JoinColumn(name = "unit_id")
  @ManyToOne(targetEntity = RCProduceSpecificationUnitImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCProduceSpecificationUnit unit;
  
  public RCProduceSpecificationUnit getUnit() {
    return this.unit;
  }
  
  public RCProductSpecification setUnit(final RCProduceSpecificationUnit unit) {
    this.unit = unit;
    return this;			
    
  }
  
  @JoinColumn(name = "defaultSupplier_id")
  @ManyToOne(targetEntity = RCSupplierImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCSupplier defaultSupplier;
  
  public RCSupplier getDefaultSupplier() {
    return this.defaultSupplier;
  }
  
  public RCProductSpecification setDefaultSupplier(final RCSupplier defaultSupplier) {
    this.defaultSupplier = defaultSupplier;
    return this;			
    
  }
  
  private String simplePy;
  
  public String getSimplePy() {
    return this.simplePy;
  }
  
  public RCProductSpecification setSimplePy(final String simplePy) {
    this.simplePy = simplePy;
    return this;			
    
  }
  
  public String getEntityName() {
    return this.name;
  }
  
  public String getNameField() {
    return "name";
  }
  
  public static RCProductSpecification create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.warehouse.RCProductSpecification rCProductSpecification = new com.fudanmed.platform.core.warehouse.impl.RCProductSpecificationImpl(
    );
    objectFactory.create(rCProductSpecification);
    return rCProductSpecification;			
    
  }
  
  public RCProductSpecificationProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
