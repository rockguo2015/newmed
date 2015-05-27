package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.common.RCMaterialBrand;
import com.fudanmed.platform.core.domain.RCSupplier;
import com.fudanmed.platform.core.warehouse.RCProduceSpecificationUnit;
import com.fudanmed.platform.core.warehouse.RCProductType;
import com.fudanmed.platform.core.warehouse.impl.RCProductSpecificationImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IHasSimplePy;
import edu.fudan.mylang.pf.IModelObject;

@EntityImplementation(implementBy = RCProductSpecificationImpl.class)
public interface RCProductSpecification extends IModelObject, IHasSimplePy {
  public abstract String getSid();
  
  public abstract RCProductSpecification setSid(final String sid);
  
  public abstract String getMaterialId();
  
  public abstract RCProductSpecification setMaterialId(final String materialId);
  
  public abstract RCMaterialBrand getBrandType();
  
  public abstract RCProductSpecification setBrandType(final RCMaterialBrand brandType);
  
  public abstract Double getReferencePrice();
  
  public abstract RCProductSpecification setReferencePrice(final Double referencePrice);
  
  public abstract Integer getShelfLife();
  
  public abstract RCProductSpecification setShelfLife(final Integer shelfLife);
  
  public abstract Integer getLowerStorage();
  
  public abstract RCProductSpecification setLowerStorage(final Integer lowerStorage);
  
  public abstract Integer getUpperStorage();
  
  public abstract RCProductSpecification setUpperStorage(final Integer upperStorage);
  
  public abstract String getName();
  
  public abstract RCProductSpecification setName(final String name);
  
  public abstract String getTypeDesc();
  
  public abstract RCProductSpecification setTypeDesc(final String typeDesc);
  
  public abstract RCProductType getProductType();
  
  public abstract RCProductSpecification setProductType(final RCProductType productType);
  
  public abstract RCProduceSpecificationUnit getUnit();
  
  public abstract RCProductSpecification setUnit(final RCProduceSpecificationUnit unit);
  
  public abstract RCSupplier getDefaultSupplier();
  
  public abstract RCProductSpecification setDefaultSupplier(final RCSupplier defaultSupplier);
  
  public abstract String getSimplePy();
  
  public abstract RCProductSpecification setSimplePy(final String simplePy);
  
  public abstract String getEntityName();
  
  public abstract String getNameField();
  
  public abstract RCProductSpecificationProxy toProxy();
}
