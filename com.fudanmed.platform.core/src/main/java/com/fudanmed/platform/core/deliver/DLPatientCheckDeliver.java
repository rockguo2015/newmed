package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLCheckOrganization;
import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckType;
import com.fudanmed.platform.core.deliver.DLDeliverSubject;
import com.fudanmed.platform.core.deliver.DLInHospitalPatient;
import com.fudanmed.platform.core.deliver.DLPatientDeliverMethod;
import com.fudanmed.platform.core.deliver.impl.DLPatientCheckDeliverImpl;
import com.fudanmed.platform.core.deliver.proxy.DLPatientCheckDeliverProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@EntityImplementation(implementBy = DLPatientCheckDeliverImpl.class)
public interface DLPatientCheckDeliver extends DLDeliverSubject {
  public abstract DLInHospitalPatient getPatient();
  
  public abstract DLPatientCheckDeliver setPatient(final DLInHospitalPatient patient);
  
  public abstract DLDeliverPatientCheckType getCheckType();
  
  public abstract DLPatientCheckDeliver setCheckType(final DLDeliverPatientCheckType checkType);
  
  public abstract DLCheckOrganization getCheckOrganization();
  
  public abstract DLPatientCheckDeliver setCheckOrganization(final DLCheckOrganization checkOrganization);
  
  public abstract DLPatientDeliverMethod getDeliverMethod();
  
  public abstract DLPatientCheckDeliver setDeliverMethod(final DLPatientDeliverMethod deliverMethod);
  
  public abstract String getEntityName();
  
  public abstract void update(final Procedure1<? super DLPatientCheckDeliver> updater);
  
  public abstract void checkValid();
  
  public abstract DLPatientCheckDeliverProxy toProxy();
}
