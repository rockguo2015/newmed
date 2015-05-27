package com.fudanmed.platform.core.entityextension.events;

import com.fudanmed.platform.core.entityextension.RCCustomizableType;
import com.fudanmed.platform.core.entityextension.events.RCCustomizableTypeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.entityextension.events.RCCustomizableTypeEventsManager")
public class RCCustomizableTypeEventsManager extends EntityEventsManager<RCCustomizableType> {
  @Autowired(required = false)
  private Collection<RCCustomizableTypeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCCustomizableTypeEventsListener> getListeners() {
    return listeners;
  }
}
