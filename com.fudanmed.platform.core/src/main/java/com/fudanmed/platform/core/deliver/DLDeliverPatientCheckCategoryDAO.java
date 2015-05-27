package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategory;
import edu.fudan.mylang.pf.IDAOService;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public interface DLDeliverPatientCheckCategoryDAO extends IDAOService<DLDeliverPatientCheckCategory> {
  public abstract DLDeliverPatientCheckCategory create(final DLDeliverPatientCheckCategory parent, final Procedure1<? super DLDeliverPatientCheckCategory> init);
  
  public abstract void delete(final DLDeliverPatientCheckCategory value);
  
  public abstract Collection<DLDeliverPatientCheckCategory> findAll();
}
