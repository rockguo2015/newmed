package com.fudanmed.platform.core.domain.events;

import com.fudanmed.platform.core.domain.RCDirtyRecord;
import com.fudanmed.platform.core.domain.events.RCDirtyRecordEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.events.RCDirtyRecordEventsManager")
public class RCDirtyRecordEventsManager extends EntityEventsManager<RCDirtyRecord> {
  @Autowired(required = false)
  private Collection<RCDirtyRecordEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCDirtyRecordEventsListener> getListeners() {
    return listeners;
  }
}
