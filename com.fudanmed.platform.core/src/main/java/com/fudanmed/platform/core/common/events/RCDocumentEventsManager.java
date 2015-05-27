package com.fudanmed.platform.core.common.events;

import com.fudanmed.platform.core.common.RCDocument;
import com.fudanmed.platform.core.common.events.RCDocumentEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.common.events.RCDocumentEventsManager")
public class RCDocumentEventsManager extends EntityEventsManager<RCDocument> {
  @Autowired(required = false)
  private Collection<RCDocumentEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCDocumentEventsListener> getListeners() {
    return listeners;
  }
}
