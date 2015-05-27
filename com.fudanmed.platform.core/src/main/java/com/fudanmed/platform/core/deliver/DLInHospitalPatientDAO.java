package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLInHospitalPatient;
import edu.fudan.mylang.pf.IDAOService;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public interface DLInHospitalPatientDAO extends IDAOService<DLInHospitalPatient> {
  public abstract DLInHospitalPatient create(final Procedure1<? super DLInHospitalPatient> init);
  
  public abstract void delete(final DLInHospitalPatient value);
  
  public abstract DLInHospitalPatient findByCode(final String sid);
}
