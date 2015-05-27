package com.fudanmed.platform.core.domain.events;

import com.fudanmed.platform.core.domain.RCEmployee;
import edu.fudan.mylang.pf.event.IEntityEventsListner;

public interface RCEmployeeEventsListener extends IEntityEventsListner<RCEmployee> {
  public abstract void leaveJob(final RCEmployee entity);
  
  public abstract void returnJob(final RCEmployee entity);
}
