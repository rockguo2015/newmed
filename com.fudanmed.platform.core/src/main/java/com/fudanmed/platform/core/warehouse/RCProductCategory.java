package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductType;
import com.fudanmed.platform.core.warehouse.impl.RCProductCategoryImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IHasSimplePy;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Collection;

@EntityImplementation(implementBy = RCProductCategoryImpl.class)
public interface RCProductCategory extends IModelObject, IHasSimplePy {
  public abstract String getCode();
  
  public abstract RCProductCategory setCode(final String code);
  
  public abstract String getName();
  
  public abstract RCProductCategory setName(final String name);
  
  public abstract String getSimplePy();
  
  public abstract RCProductCategory setSimplePy(final String simplePy);
  
  public abstract RCProductCategory getParent();
  
  public abstract RCProductCategory setParent(final RCProductCategory parent);
  
  public abstract Collection<RCProductCategory> getSubCategories();
  
  public abstract RCProductCategory createAndAddtoSubCategories();
  
  public abstract RCProductCategory removeFromSubCategories(final RCProductCategory rCProductCategory);
  
  public abstract RCProductCategory removeAllSubCategories();
  
  public abstract Collection<RCProductType> getProductTypes();
  
  public abstract RCProductType createAndAddtoProductTypes();
  
  public abstract RCProductCategory removeFromProductTypes(final RCProductType rCProductType);
  
  public abstract RCProductCategory removeAllProductTypes();
  
  public abstract String getEntityName();
  
  public abstract String getNameField();
  
  public abstract RCProductCategoryProxy toProxy();
}
