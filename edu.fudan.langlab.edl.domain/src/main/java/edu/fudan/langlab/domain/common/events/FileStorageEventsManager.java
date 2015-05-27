package edu.fudan.langlab.domain.common.events;

import edu.fudan.langlab.domain.common.FileStorage;
import edu.fudan.langlab.domain.common.events.FileStorageEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("edu.fudan.langlab.domain.common.events.FileStorageEventsManager")
public class FileStorageEventsManager extends EntityEventsManager<FileStorage> {
  @Autowired(required = false)
  private Collection<FileStorageEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<FileStorageEventsListener> getListeners() {
    return listeners;
  }
}
