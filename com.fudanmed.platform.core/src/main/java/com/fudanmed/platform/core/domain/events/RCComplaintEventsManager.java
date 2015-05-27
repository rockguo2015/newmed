package com.fudanmed.platform.core.domain.events;

import com.fudanmed.platform.core.domain.RCComplaint;
import com.fudanmed.platform.core.domain.events.RCComplaintEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.events.RCComplaintEventsManager")
public class RCComplaintEventsManager extends EntityEventsManager<RCComplaint> {
  @Autowired(required = false)
  private Collection<RCComplaintEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCComplaintEventsListener> getListeners() {
    return listeners;
  }
}
