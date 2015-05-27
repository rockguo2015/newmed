package com.fudanmed.platform.core.domain.events;

import com.fudanmed.platform.core.domain.RCWorkItemTask;
import edu.fudan.mylang.pf.event.IEntityEventsListner;

public interface RCWorkItemTaskEventsListener extends IEntityEventsListner<RCWorkItemTask> {
  public abstract void pend(final RCWorkItemTask entity);
  
  public abstract void cancelPend(final RCWorkItemTask entity);
  
  public abstract void outsource(final RCWorkItemTask entity);
  
  public abstract void followup(final RCWorkItemTask entity);
  
  public abstract void finishOutsource(final RCWorkItemTask entity);
  
  public abstract void misDispatching(final RCWorkItemTask entity);
  
  public abstract void finish(final RCWorkItemTask entity);
  
  public abstract void cancel(final RCWorkItemTask entity);
}
