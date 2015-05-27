package edu.fudan.langlab.domain.workflow.events;

import edu.fudan.langlab.domain.workflow.BusinessProcess;
import edu.fudan.langlab.domain.workflow.events.BusinessProcessEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("edu.fudan.langlab.domain.workflow.events.BusinessProcessEventsManager")
public class BusinessProcessEventsManager extends EntityEventsManager<BusinessProcess> {
  @Autowired(required = false)
  private Collection<BusinessProcessEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<BusinessProcessEventsListener> getListeners() {
    return listeners;
  }
}
