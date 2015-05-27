package edu.fudan.langlab.domain.organization.events;

import edu.fudan.langlab.domain.organization.Party;
import edu.fudan.langlab.domain.organization.events.PartyEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("edu.fudan.langlab.domain.organization.events.PartyEventsManager")
public class PartyEventsManager extends EntityEventsManager<Party> {
  @Autowired(required = false)
  private Collection<PartyEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<PartyEventsListener> getListeners() {
    return listeners;
  }
}
