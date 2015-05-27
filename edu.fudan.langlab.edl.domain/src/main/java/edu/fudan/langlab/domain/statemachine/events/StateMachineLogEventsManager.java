package edu.fudan.langlab.domain.statemachine.events;

import edu.fudan.langlab.domain.statemachine.StateMachineLog;
import edu.fudan.langlab.domain.statemachine.events.StateMachineLogEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("edu.fudan.langlab.domain.statemachine.events.StateMachineLogEventsManager")
public class StateMachineLogEventsManager extends EntityEventsManager<StateMachineLog> {
  @Autowired(required = false)
  private Collection<StateMachineLogEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<StateMachineLogEventsListener> getListeners() {
    return listeners;
  }
}
