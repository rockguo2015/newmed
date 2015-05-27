package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverMaterialCategory;
import com.fudanmed.platform.core.deliver.impl.DLDeliverMaterialTypeImpl;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialTypeProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IHasSimplePy;
import edu.fudan.mylang.pf.IModelObject;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@EntityImplementation(implementBy = DLDeliverMaterialTypeImpl.class)
public interface DLDeliverMaterialType extends IModelObject, IHasSimplePy {
  public abstract DLDeliverMaterialCategory getCategory();
  
  public abstract DLDeliverMaterialType setCategory(final DLDeliverMaterialCategory category);
  
  public abstract String getCode();
  
  public abstract DLDeliverMaterialType setCode(final String code);
  
  public abstract String getName();
  
  public abstract DLDeliverMaterialType setName(final String name);
  
  public abstract String getComment();
  
  public abstract DLDeliverMaterialType setComment(final String comment);
  
  public abstract String getUnit();
  
  public abstract DLDeliverMaterialType setUnit(final String unit);
  
  public abstract String getEntityName();
  
  public abstract String getSimplePy();
  
  public abstract DLDeliverMaterialType setSimplePy(final String simplePy);
  
  public abstract String getNameField();
  
  public abstract void update(final Procedure1<? super DLDeliverMaterialType> updater);
  
  public abstract void checkValid();
  
  public abstract DLDeliverMaterialTypeProxy toProxy();
}
