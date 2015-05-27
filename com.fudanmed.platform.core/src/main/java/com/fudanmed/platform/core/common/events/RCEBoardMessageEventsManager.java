package com.fudanmed.platform.core.common.events;

import com.fudanmed.platform.core.common.RCEBoardMessage;
import com.fudanmed.platform.core.common.events.RCEBoardMessageEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.common.events.RCEBoardMessageEventsManager")
public class RCEBoardMessageEventsManager extends EntityEventsManager<RCEBoardMessage> {
  @Autowired(required = false)
  private Collection<RCEBoardMessageEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCEBoardMessageEventsListener> getListeners() {
    return listeners;
  }
}
