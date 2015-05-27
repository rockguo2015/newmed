package edu.fudan.langlab.domain.workflow.events;

import edu.fudan.langlab.domain.workflow.ForkStatus;
import edu.fudan.langlab.domain.workflow.events.ForkStatusEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("edu.fudan.langlab.domain.workflow.events.ForkStatusEventsManager")
public class ForkStatusEventsManager extends EntityEventsManager<ForkStatus> {
  @Autowired(required = false)
  private Collection<ForkStatusEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<ForkStatusEventsListener> getListeners() {
    return listeners;
  }
}
