package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLInHospitalLocation;
import com.fudanmed.platform.core.deliver.impl.DLInHospitalLocationCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;

@QueryImplementation(implementBy = DLInHospitalLocationCriteriaImpl.class)
public interface DLInHospitalLocationCriteria extends IPagedCriteria<DLInHospitalLocation> {
  public abstract String getInfo();
  
  public abstract DLInHospitalLocationCriteria setInfo(final String info);
}
