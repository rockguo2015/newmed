package edu.fudan.langlab.domain.updater.events;

import edu.fudan.langlab.domain.updater.UPSystemUpdateStatus;
import edu.fudan.langlab.domain.updater.events.UPSystemUpdateStatusEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("edu.fudan.langlab.domain.updater.events.UPSystemUpdateStatusEventsManager")
public class UPSystemUpdateStatusEventsManager extends EntityEventsManager<UPSystemUpdateStatus> {
  @Autowired(required = false)
  private Collection<UPSystemUpdateStatusEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<UPSystemUpdateStatusEventsListener> getListeners() {
    return listeners;
  }
}
