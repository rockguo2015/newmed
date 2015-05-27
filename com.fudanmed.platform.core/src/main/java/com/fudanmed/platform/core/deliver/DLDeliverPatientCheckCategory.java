package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckType;
import com.fudanmed.platform.core.deliver.impl.DLDeliverPatientCheckCategoryImpl;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IHasHierarchy;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.INamedModelObject;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@EntityImplementation(implementBy = DLDeliverPatientCheckCategoryImpl.class)
public interface DLDeliverPatientCheckCategory extends IModelObject, INamedModelObject, IHasHierarchy {
  public abstract String getCode();
  
  public abstract DLDeliverPatientCheckCategory setCode(final String code);
  
  public abstract String getName();
  
  public abstract DLDeliverPatientCheckCategory setName(final String name);
  
  public abstract DLDeliverPatientCheckCategory getParentCategory();
  
  public abstract DLDeliverPatientCheckCategory setParentCategory(final DLDeliverPatientCheckCategory parentCategory);
  
  public abstract Collection<DLDeliverPatientCheckCategory> getSubCategories();
  
  public abstract DLDeliverPatientCheckCategory createAndAddtoSubCategories();
  
  public abstract DLDeliverPatientCheckCategory removeFromSubCategories(final DLDeliverPatientCheckCategory dLDeliverPatientCheckCategory);
  
  public abstract DLDeliverPatientCheckCategory removeAllSubCategories();
  
  public abstract Collection<DLDeliverPatientCheckType> getTypes();
  
  public abstract DLDeliverPatientCheckType createAndAddtoTypes();
  
  public abstract DLDeliverPatientCheckCategory removeFromTypes(final DLDeliverPatientCheckType dLDeliverPatientCheckType);
  
  public abstract DLDeliverPatientCheckCategory removeAllTypes();
  
  public abstract void update(final Procedure1<? super DLDeliverPatientCheckCategory> updater);
  
  public abstract String getEntityName();
  
  public abstract void checkValid();
  
  public abstract DLDeliverPatientCheckType createCheckType(final Procedure1<? super DLDeliverPatientCheckType> init);
  
  public abstract void deleteCheckType(final DLDeliverPatientCheckType checkType);
  
  public abstract String getFullIdPath();
  
  public abstract DLDeliverPatientCheckCategory setFullIdPath(final String fullIdPath);
  
  public abstract String getFullPath();
  
  public abstract void moveTo(final DLDeliverPatientCheckCategory newParent);
  
  public abstract Iterable<IHasHierarchy> getHierarchyChildren();
  
  public abstract IHasHierarchy getHierarchyParent();
  
  public abstract void setHierarchyParent(final IHasHierarchy parent);
  
  public abstract DLDeliverPatientCheckCategoryProxy toProxy();
}
