package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.impl.RCDirtyRecordImpl;
import com.fudanmed.platform.core.domain.proxy.RCDirtyRecordProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;

@EntityImplementation(implementBy = RCDirtyRecordImpl.class)
public interface RCDirtyRecord extends IModelObject {
  public abstract RCMaintenanceTeam getTeam();
  
  public abstract RCDirtyRecord setTeam(final RCMaintenanceTeam team);
  
  public abstract Boolean getIsDirty4Team();
  
  public abstract RCDirtyRecord setIsDirty4Team(final Boolean isDirty4Team);
  
  public abstract Boolean getIsDirty4Scheduler();
  
  public abstract RCDirtyRecord setIsDirty4Scheduler(final Boolean isDirty4Scheduler);
  
  public abstract void refreshed4Team();
  
  public abstract void notify4Team();
  
  public abstract void refreshed4Scheduler();
  
  public abstract void notify4Scheduler();
  
  public abstract RCDirtyRecordProxy toProxy();
}
