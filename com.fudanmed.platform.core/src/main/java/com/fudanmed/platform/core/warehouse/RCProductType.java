package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductCategory;
import com.fudanmed.platform.core.warehouse.impl.RCProductTypeImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCProductTypeProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IHasSimplePy;
import edu.fudan.mylang.pf.IModelObject;

@EntityImplementation(implementBy = RCProductTypeImpl.class)
public interface RCProductType extends IModelObject, IHasSimplePy {
  public abstract RCProductCategory getCategory();
  
  public abstract RCProductType setCategory(final RCProductCategory category);
  
  public abstract String getCode();
  
  public abstract RCProductType setCode(final String code);
  
  public abstract String getName();
  
  public abstract RCProductType setName(final String name);
  
  public abstract String getSimplePy();
  
  public abstract RCProductType setSimplePy(final String simplePy);
  
  public abstract String getCategoryPath();
  
  public abstract RCProductType setCategoryPath(final String categoryPath);
  
  public abstract void updateCategoryPath();
  
  public abstract String getEntityName();
  
  public abstract String getNameField();
  
  public abstract RCProductTypeProxy toProxy();
}
