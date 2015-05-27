package com.fudanmed.platform.core.domain.events;

import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.events.RCMaintenanceTeamEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.events.RCMaintenanceTeamEventsManager")
public class RCMaintenanceTeamEventsManager extends EntityEventsManager<RCMaintenanceTeam> {
  @Autowired(required = false)
  private Collection<RCMaintenanceTeamEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCMaintenanceTeamEventsListener> getListeners() {
    return listeners;
  }
}
