package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTask;
import com.fudanmed.platform.core.domain.RCEmployee;
import edu.fudan.mylang.pf.event.IEntityEventsListner;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public interface DLCenterlizedDeliverTaskEventsListener extends IEntityEventsListner<DLCenterlizedDeliverTask> {
  public abstract void performUpdate(final DLCenterlizedDeliverTask entity, final Procedure1<? super DLCenterlizedDeliverTask> updater);
  
  public abstract void dispatch(final DLCenterlizedDeliverTask entity, final Collection<RCEmployee> performers);
  
  public abstract void cancel(final DLCenterlizedDeliverTask entity, final String comment);
  
  public abstract void cancelDispatch(final DLCenterlizedDeliverTask entity, final String comment);
  
  public abstract void finish(final DLCenterlizedDeliverTask entity, final String comment);
}
