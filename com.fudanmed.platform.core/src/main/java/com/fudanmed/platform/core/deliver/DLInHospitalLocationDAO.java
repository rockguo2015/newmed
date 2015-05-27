package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLInHospitalLocation;
import edu.fudan.mylang.pf.IDAOService;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public interface DLInHospitalLocationDAO extends IDAOService<DLInHospitalLocation> {
  public abstract DLInHospitalLocation create(final Procedure1<? super DLInHospitalLocation> init);
  
  public abstract void delete(final DLInHospitalLocation value);
}
