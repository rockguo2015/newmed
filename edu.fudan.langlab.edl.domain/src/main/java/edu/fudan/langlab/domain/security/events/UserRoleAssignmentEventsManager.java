package edu.fudan.langlab.domain.security.events;

import edu.fudan.langlab.domain.security.UserRoleAssignment;
import edu.fudan.langlab.domain.security.events.UserRoleAssignmentEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("edu.fudan.langlab.domain.security.events.UserRoleAssignmentEventsManager")
public class UserRoleAssignmentEventsManager extends EntityEventsManager<UserRoleAssignment> {
  @Autowired(required = false)
  private Collection<UserRoleAssignmentEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<UserRoleAssignmentEventsListener> getListeners() {
    return listeners;
  }
}
