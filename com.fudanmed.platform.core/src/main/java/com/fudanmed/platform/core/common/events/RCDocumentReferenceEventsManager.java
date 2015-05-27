package com.fudanmed.platform.core.common.events;

import com.fudanmed.platform.core.common.RCDocumentReference;
import com.fudanmed.platform.core.common.events.RCDocumentReferenceEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.common.events.RCDocumentReferenceEventsManager")
public class RCDocumentReferenceEventsManager extends EntityEventsManager<RCDocumentReference> {
  @Autowired(required = false)
  private Collection<RCDocumentReferenceEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCDocumentReferenceEventsListener> getListeners() {
    return listeners;
  }
}
