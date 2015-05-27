package edu.fudan.langlab.domain.security.events;

import edu.fudan.langlab.domain.security.RoleFunctionAssignment;
import edu.fudan.langlab.domain.security.events.RoleFunctionAssignmentEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("edu.fudan.langlab.domain.security.events.RoleFunctionAssignmentEventsManager")
public class RoleFunctionAssignmentEventsManager extends EntityEventsManager<RoleFunctionAssignment> {
  @Autowired(required = false)
  private Collection<RoleFunctionAssignmentEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RoleFunctionAssignmentEventsListener> getListeners() {
    return listeners;
  }
}
