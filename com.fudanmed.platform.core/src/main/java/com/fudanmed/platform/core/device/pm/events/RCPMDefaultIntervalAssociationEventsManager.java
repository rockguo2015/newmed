package com.fudanmed.platform.core.device.pm.events;

import com.fudanmed.platform.core.device.pm.RCPMDefaultIntervalAssociation;
import com.fudanmed.platform.core.device.pm.events.RCPMDefaultIntervalAssociationEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.device.pm.events.RCPMDefaultIntervalAssociationEventsManager")
public class RCPMDefaultIntervalAssociationEventsManager extends EntityEventsManager<RCPMDefaultIntervalAssociation> {
  @Autowired(required = false)
  private Collection<RCPMDefaultIntervalAssociationEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCPMDefaultIntervalAssociationEventsListener> getListeners() {
    return listeners;
  }
}
