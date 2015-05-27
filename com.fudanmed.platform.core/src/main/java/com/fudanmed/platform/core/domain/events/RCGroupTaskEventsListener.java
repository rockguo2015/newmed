package com.fudanmed.platform.core.domain.events;

import com.fudanmed.platform.core.domain.RCGroupTask;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import edu.fudan.mylang.pf.event.IEntityEventsListner;

public interface RCGroupTaskEventsListener extends IEntityEventsListner<RCGroupTask> {
  public abstract void reportFinish(final RCGroupTask entity);
  
  public abstract void taskFinished(final RCGroupTask entity, final RCWorkItemTask task);
  
  public abstract void taskCreated(final RCGroupTask entity, final RCWorkItemTask task);
  
  public abstract void reportMisdispatch(final RCGroupTask entity);
  
  public abstract void cancel(final RCGroupTask entity);
}
