package edu.fudan.langlab.domain.security.events;

import edu.fudan.langlab.domain.security.User;
import edu.fudan.langlab.domain.security.events.UserEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("edu.fudan.langlab.domain.security.events.UserEventsManager")
public class UserEventsManager extends EntityEventsManager<User> {
  @Autowired(required = false)
  private Collection<UserEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<UserEventsListener> getListeners() {
    return listeners;
  }
}
