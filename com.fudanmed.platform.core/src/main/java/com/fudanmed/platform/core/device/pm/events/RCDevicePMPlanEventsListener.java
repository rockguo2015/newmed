package com.fudanmed.platform.core.device.pm.events;

import com.fudanmed.platform.core.device.pm.RCDevicePMPlan;
import edu.fudan.mylang.pf.event.IEntityEventsListner;

public interface RCDevicePMPlanEventsListener extends IEntityEventsListner<RCDevicePMPlan> {
  public abstract void assign(final RCDevicePMPlan entity);
  
  public abstract void reportInfo(final RCDevicePMPlan entity, final String comment);
  
  public abstract void finish(final RCDevicePMPlan entity, final String comment);
  
  public abstract void cancelAssign(final RCDevicePMPlan entity);
  
  public abstract void assignWorker(final RCDevicePMPlan entity);
}
