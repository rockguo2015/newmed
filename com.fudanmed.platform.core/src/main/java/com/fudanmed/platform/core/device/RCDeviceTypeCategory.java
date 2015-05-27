package com.fudanmed.platform.core.device;

import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.impl.RCDeviceTypeCategoryImpl;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IHasSimplePy;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Collection;

@EntityImplementation(implementBy = RCDeviceTypeCategoryImpl.class)
public interface RCDeviceTypeCategory extends IModelObject, IHasSimplePy {
  public abstract String getCode();
  
  public abstract RCDeviceTypeCategory setCode(final String code);
  
  public abstract String getName();
  
  public abstract RCDeviceTypeCategory setName(final String name);
  
  public abstract String getSimplePy();
  
  public abstract RCDeviceTypeCategory setSimplePy(final String simplePy);
  
  public abstract RCDeviceTypeCategory getParent();
  
  public abstract RCDeviceTypeCategory setParent(final RCDeviceTypeCategory parent);
  
  public abstract Collection<RCDeviceTypeCategory> getSubCategories();
  
  public abstract RCDeviceTypeCategory createAndAddtoSubCategories();
  
  public abstract RCDeviceTypeCategory removeFromSubCategories(final RCDeviceTypeCategory rCDeviceTypeCategory);
  
  public abstract RCDeviceTypeCategory removeAllSubCategories();
  
  public abstract Collection<RCDeviceType> getDeviceTypes();
  
  public abstract RCDeviceType createAndAddtoDeviceTypes();
  
  public abstract RCDeviceTypeCategory removeFromDeviceTypes(final RCDeviceType rCDeviceType);
  
  public abstract RCDeviceTypeCategory removeAllDeviceTypes();
  
  public abstract String getEntityName();
  
  public abstract String getNameField();
  
  public abstract RCDeviceType createDeviceType();
  
  public abstract RCDeviceType cloneDeviceType(final RCDeviceType sourceType);
  
  public abstract void deleteDeviceType(final RCDeviceType deviceType);
  
  public abstract RCDeviceTypeCategoryProxy toProxy();
}
