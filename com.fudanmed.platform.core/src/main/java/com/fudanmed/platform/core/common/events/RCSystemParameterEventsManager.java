package com.fudanmed.platform.core.common.events;

import com.fudanmed.platform.core.common.RCSystemParameter;
import com.fudanmed.platform.core.common.events.RCSystemParameterEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.common.events.RCSystemParameterEventsManager")
public class RCSystemParameterEventsManager extends EntityEventsManager<RCSystemParameter> {
  @Autowired(required = false)
  private Collection<RCSystemParameterEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCSystemParameterEventsListener> getListeners() {
    return listeners;
  }
}
