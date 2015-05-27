package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCDirtyRecord;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCReporterDirtyRecord;
import edu.fudan.mylang.pf.IBaseService;

public interface RCTaskDirtyManager extends IBaseService {
  public abstract RCDirtyRecord getDirtyRecord(final RCMaintenanceTeam team);
  
  public abstract RCReporterDirtyRecord getReporterDirtyRecord();
  
  public abstract Boolean checkDirty(final RCMaintenanceTeam team);
  
  public abstract void refreshed(final RCMaintenanceTeam team);
  
  public abstract void notifyTeam(final RCMaintenanceTeam team);
  
  public abstract void notifyScheduler(final RCMaintenanceTeam team);
  
  public abstract void notifyReported();
  
  public abstract Boolean checkDirty();
  
  public abstract void refreshed();
}
