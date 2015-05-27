package edu.fudan.langlab.domain.document.events;

import edu.fudan.langlab.domain.document.DocumentStorage;
import edu.fudan.langlab.domain.document.events.DocumentStorageEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("edu.fudan.langlab.domain.document.events.DocumentStorageEventsManager")
public class DocumentStorageEventsManager extends EntityEventsManager<DocumentStorage> {
  @Autowired(required = false)
  private Collection<DocumentStorageEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DocumentStorageEventsListener> getListeners() {
    return listeners;
  }
}
