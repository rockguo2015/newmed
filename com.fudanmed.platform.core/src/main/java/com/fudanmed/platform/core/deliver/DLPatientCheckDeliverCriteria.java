package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLCheckOrganization;
import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckType;
import com.fudanmed.platform.core.deliver.DLInHospitalLocation;
import com.fudanmed.platform.core.deliver.DLInHospitalPatient;
import com.fudanmed.platform.core.deliver.DLPatientCheckDeliver;
import com.fudanmed.platform.core.deliver.DLPatientDeliverMethod;
import com.fudanmed.platform.core.deliver.impl.DLPatientCheckDeliverCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;

@QueryImplementation(implementBy = DLPatientCheckDeliverCriteriaImpl.class)
public interface DLPatientCheckDeliverCriteria extends IPagedCriteria<DLPatientCheckDeliver> {
  public abstract DLInHospitalPatient getPatient();
  
  public abstract DLPatientCheckDeliverCriteria setPatient(final DLInHospitalPatient patient);
  
  public abstract DLInHospitalLocation getLocation();
  
  public abstract DLPatientCheckDeliverCriteria setLocation(final DLInHospitalLocation location);
  
  public abstract String getBedNumber();
  
  public abstract DLPatientCheckDeliverCriteria setBedNumber(final String bedNumber);
  
  public abstract DLCheckOrganization getCheckOrganization();
  
  public abstract DLPatientCheckDeliverCriteria setCheckOrganization(final DLCheckOrganization checkOrganization);
  
  public abstract DLDeliverPatientCheckType getCheckType();
  
  public abstract DLPatientCheckDeliverCriteria setCheckType(final DLDeliverPatientCheckType checkType);
  
  public abstract DLPatientDeliverMethod getDeliverMethod();
  
  public abstract DLPatientCheckDeliverCriteria setDeliverMethod(final DLPatientDeliverMethod deliverMethod);
}
