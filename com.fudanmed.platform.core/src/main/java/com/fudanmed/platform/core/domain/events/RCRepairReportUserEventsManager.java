package com.fudanmed.platform.core.domain.events;

import com.fudanmed.platform.core.domain.RCRepairReportUser;
import com.fudanmed.platform.core.domain.events.RCRepairReportUserEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.events.RCRepairReportUserEventsManager")
public class RCRepairReportUserEventsManager extends EntityEventsManager<RCRepairReportUser> {
  @Autowired(required = false)
  private Collection<RCRepairReportUserEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCRepairReportUserEventsListener> getListeners() {
    return listeners;
  }
}
