package edu.fudan.langlab.domain.security.events;

import edu.fudan.langlab.domain.security.Role;
import edu.fudan.langlab.domain.security.events.RoleEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("edu.fudan.langlab.domain.security.events.RoleEventsManager")
public class RoleEventsManager extends EntityEventsManager<Role> {
  @Autowired(required = false)
  private Collection<RoleEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RoleEventsListener> getListeners() {
    return listeners;
  }
}
