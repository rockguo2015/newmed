package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverMaterialCategory;
import com.fudanmed.platform.core.deliver.DLDeliverMaterialType;
import com.fudanmed.platform.core.deliver.impl.DLDeliverMaterialTypeCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;

@QueryImplementation(implementBy = DLDeliverMaterialTypeCriteriaImpl.class)
public interface DLDeliverMaterialTypeCriteria extends IPagedCriteria<DLDeliverMaterialType> {
  public abstract String getInfo();
  
  public abstract DLDeliverMaterialTypeCriteria setInfo(final String info);
  
  public abstract DLDeliverMaterialCategory getCategory();
  
  public abstract DLDeliverMaterialTypeCriteria setCategory(final DLDeliverMaterialCategory category);
  
  public abstract String getIdPath();
  
  public abstract DLDeliverMaterialTypeCriteria setIdPath(final String idPath);
  
  public abstract void postInitialize();
}
