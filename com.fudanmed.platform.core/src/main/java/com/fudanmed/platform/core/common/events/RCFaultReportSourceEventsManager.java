package com.fudanmed.platform.core.common.events;

import com.fudanmed.platform.core.common.RCFaultReportSource;
import com.fudanmed.platform.core.common.events.RCFaultReportSourceEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.common.events.RCFaultReportSourceEventsManager")
public class RCFaultReportSourceEventsManager extends EntityEventsManager<RCFaultReportSource> {
  @Autowired(required = false)
  private Collection<RCFaultReportSourceEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCFaultReportSourceEventsListener> getListeners() {
    return listeners;
  }
}
