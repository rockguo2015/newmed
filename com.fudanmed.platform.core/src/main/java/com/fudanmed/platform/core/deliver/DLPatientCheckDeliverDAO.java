package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLPatientCheckDeliver;
import edu.fudan.mylang.pf.IDAOService;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public interface DLPatientCheckDeliverDAO extends IDAOService<DLPatientCheckDeliver> {
  public abstract DLPatientCheckDeliver create(final Procedure1<? super DLPatientCheckDeliver> init);
  
  public abstract void delete(final DLPatientCheckDeliver value);
}
