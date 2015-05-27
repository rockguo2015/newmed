package com.fudanmed.platform.core.common.events;

import com.fudanmed.platform.core.common.RCCredentialType;
import com.fudanmed.platform.core.common.events.RCCredentialTypeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.common.events.RCCredentialTypeEventsManager")
public class RCCredentialTypeEventsManager extends EntityEventsManager<RCCredentialType> {
  @Autowired(required = false)
  private Collection<RCCredentialTypeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCCredentialTypeEventsListener> getListeners() {
    return listeners;
  }
}
