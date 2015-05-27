package com.fudanmed.platform.core.common.events;

import com.fudanmed.platform.core.common.RCSequenceConfig;
import com.fudanmed.platform.core.common.events.RCSequenceConfigEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.common.events.RCSequenceConfigEventsManager")
public class RCSequenceConfigEventsManager extends EntityEventsManager<RCSequenceConfig> {
  @Autowired(required = false)
  private Collection<RCSequenceConfigEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCSequenceConfigEventsListener> getListeners() {
    return listeners;
  }
}
