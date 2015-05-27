package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLInHospitalPatient;
import com.fudanmed.platform.core.deliver.impl.DLInHospitalPatientCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;

@QueryImplementation(implementBy = DLInHospitalPatientCriteriaImpl.class)
public interface DLInHospitalPatientCriteria extends IPagedCriteria<DLInHospitalPatient> {
  public abstract String getInfo();
  
  public abstract DLInHospitalPatientCriteria setInfo(final String info);
}
