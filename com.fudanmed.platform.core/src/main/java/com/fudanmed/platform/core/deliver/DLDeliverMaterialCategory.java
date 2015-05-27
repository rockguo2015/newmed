package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverMaterialType;
import com.fudanmed.platform.core.deliver.impl.DLDeliverMaterialCategoryImpl;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IHasHierarchy;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.INamedModelObject;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@EntityImplementation(implementBy = DLDeliverMaterialCategoryImpl.class)
public interface DLDeliverMaterialCategory extends IModelObject, INamedModelObject, IHasHierarchy {
  public abstract String getCode();
  
  public abstract DLDeliverMaterialCategory setCode(final String code);
  
  public abstract String getName();
  
  public abstract DLDeliverMaterialCategory setName(final String name);
  
  public abstract DLDeliverMaterialCategory getParentCategory();
  
  public abstract DLDeliverMaterialCategory setParentCategory(final DLDeliverMaterialCategory parentCategory);
  
  public abstract Collection<DLDeliverMaterialCategory> getSubCategories();
  
  public abstract DLDeliverMaterialCategory createAndAddtoSubCategories();
  
  public abstract DLDeliverMaterialCategory removeFromSubCategories(final DLDeliverMaterialCategory dLDeliverMaterialCategory);
  
  public abstract DLDeliverMaterialCategory removeAllSubCategories();
  
  public abstract Collection<DLDeliverMaterialType> getMaterialTypes();
  
  public abstract DLDeliverMaterialType createAndAddtoMaterialTypes();
  
  public abstract DLDeliverMaterialCategory removeFromMaterialTypes(final DLDeliverMaterialType dLDeliverMaterialType);
  
  public abstract DLDeliverMaterialCategory removeAllMaterialTypes();
  
  public abstract String getEntityName();
  
  public abstract void update(final Procedure1<? super DLDeliverMaterialCategory> updater);
  
  public abstract void createMaterialType(final Procedure1<? super DLDeliverMaterialType> updater);
  
  public abstract void deleteMaterialType(final DLDeliverMaterialType materialType);
  
  public abstract void checkValid();
  
  public abstract String getFullIdPath();
  
  public abstract DLDeliverMaterialCategory setFullIdPath(final String fullIdPath);
  
  public abstract String getFullPath();
  
  public abstract void moveTo(final DLDeliverMaterialCategory newParent);
  
  public abstract Iterable<IHasHierarchy> getHierarchyChildren();
  
  public abstract IHasHierarchy getHierarchyParent();
  
  public abstract void setHierarchyParent(final IHasHierarchy parent);
  
  public abstract DLDeliverMaterialCategoryProxy toProxy();
}
