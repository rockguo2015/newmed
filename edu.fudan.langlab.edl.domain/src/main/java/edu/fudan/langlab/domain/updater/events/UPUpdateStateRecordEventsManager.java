package edu.fudan.langlab.domain.updater.events;

import edu.fudan.langlab.domain.updater.UPUpdateStateRecord;
import edu.fudan.langlab.domain.updater.events.UPUpdateStateRecordEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("edu.fudan.langlab.domain.updater.events.UPUpdateStateRecordEventsManager")
public class UPUpdateStateRecordEventsManager extends EntityEventsManager<UPUpdateStateRecord> {
  @Autowired(required = false)
  private Collection<UPUpdateStateRecordEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<UPUpdateStateRecordEventsListener> getListeners() {
    return listeners;
  }
}
