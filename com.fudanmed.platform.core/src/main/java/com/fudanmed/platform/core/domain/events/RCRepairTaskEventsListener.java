package com.fudanmed.platform.core.domain.events;

import com.fudanmed.platform.core.domain.RCGroupTask;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCRepairTask;
import edu.fudan.mylang.pf.event.IEntityEventsListner;

public interface RCRepairTaskEventsListener extends IEntityEventsListner<RCRepairTask> {
  public abstract void cancel(final RCRepairTask entity);
  
  public abstract void close(final RCRepairTask entity);
  
  public abstract void updated(final RCRepairTask entity);
  
  public abstract void groupTaskFinished(final RCRepairTask entity, final RCGroupTask groupTask);
  
  public abstract void createGroupTask(final RCRepairTask entity, final RCMaintenanceTeam team);
  
  public abstract void misdispatch(final RCRepairTask entity, final RCGroupTask groupTask);
  
  public abstract void firstWorkItemCreated(final RCRepairTask entity);
}
