package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategory;
import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckType;
import com.fudanmed.platform.core.deliver.impl.DLDeliverPatientCheckTypeCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;

@QueryImplementation(implementBy = DLDeliverPatientCheckTypeCriteriaImpl.class)
public interface DLDeliverPatientCheckTypeCriteria extends IPagedCriteria<DLDeliverPatientCheckType> {
  public abstract String getInfo();
  
  public abstract DLDeliverPatientCheckTypeCriteria setInfo(final String info);
  
  public abstract DLDeliverPatientCheckCategory getCategory();
  
  public abstract DLDeliverPatientCheckTypeCriteria setCategory(final DLDeliverPatientCheckCategory category);
  
  public abstract String getIdPath();
  
  public abstract DLDeliverPatientCheckTypeCriteria setIdPath(final String idPath);
  
  public abstract void postInitialize();
}
