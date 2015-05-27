package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLRoutineTaskTemplate;
import com.fudanmed.platform.core.deliver.events.DLRoutineTaskTemplateEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLRoutineTaskTemplateEventsManager")
public class DLRoutineTaskTemplateEventsManager extends EntityEventsManager<DLRoutineTaskTemplate> {
  @Autowired(required = false)
  private Collection<DLRoutineTaskTemplateEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLRoutineTaskTemplateEventsListener> getListeners() {
    return listeners;
  }
}
