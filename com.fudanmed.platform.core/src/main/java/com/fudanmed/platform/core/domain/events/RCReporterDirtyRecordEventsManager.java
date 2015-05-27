package com.fudanmed.platform.core.domain.events;

import com.fudanmed.platform.core.domain.RCReporterDirtyRecord;
import com.fudanmed.platform.core.domain.events.RCReporterDirtyRecordEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.events.RCReporterDirtyRecordEventsManager")
public class RCReporterDirtyRecordEventsManager extends EntityEventsManager<RCReporterDirtyRecord> {
  @Autowired(required = false)
  private Collection<RCReporterDirtyRecordEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCReporterDirtyRecordEventsListener> getListeners() {
    return listeners;
  }
}
