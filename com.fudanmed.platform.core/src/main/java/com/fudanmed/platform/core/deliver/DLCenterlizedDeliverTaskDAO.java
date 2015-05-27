package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTask;
import com.fudanmed.platform.core.deliver.DLPatientCheckDeliver;
import edu.fudan.mylang.pf.IDAOService;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public interface DLCenterlizedDeliverTaskDAO extends IDAOService<DLCenterlizedDeliverTask> {
  public abstract DLCenterlizedDeliverTask createPatientCheckDeliverTask(final DLPatientCheckDeliver deliver, final Procedure1<? super DLCenterlizedDeliverTask> init);
  
  public abstract void delete(final DLCenterlizedDeliverTask value);
  
  public abstract void update(final DLCenterlizedDeliverTask value, final Procedure1<? super DLCenterlizedDeliverTask> updater);
}
