package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCProductSummarySnapshot;
import com.fudanmed.platform.core.warehouse.events.RCProductSummarySnapshotEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCProductSummarySnapshotEventsManager")
public class RCProductSummarySnapshotEventsManager extends EntityEventsManager<RCProductSummarySnapshot> {
  @Autowired(required = false)
  private Collection<RCProductSummarySnapshotEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCProductSummarySnapshotEventsListener> getListeners() {
    return listeners;
  }
}
