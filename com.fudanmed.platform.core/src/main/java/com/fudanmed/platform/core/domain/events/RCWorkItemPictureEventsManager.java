package com.fudanmed.platform.core.domain.events;

import com.fudanmed.platform.core.domain.RCWorkItemPicture;
import com.fudanmed.platform.core.domain.events.RCWorkItemPictureEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.events.RCWorkItemPictureEventsManager")
public class RCWorkItemPictureEventsManager extends EntityEventsManager<RCWorkItemPicture> {
  @Autowired(required = false)
  private Collection<RCWorkItemPictureEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCWorkItemPictureEventsListener> getListeners() {
    return listeners;
  }
}
