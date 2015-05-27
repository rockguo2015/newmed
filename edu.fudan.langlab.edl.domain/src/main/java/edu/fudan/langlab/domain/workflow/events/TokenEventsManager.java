package edu.fudan.langlab.domain.workflow.events;

import edu.fudan.langlab.domain.workflow.Token;
import edu.fudan.langlab.domain.workflow.events.TokenEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("edu.fudan.langlab.domain.workflow.events.TokenEventsManager")
public class TokenEventsManager extends EntityEventsManager<Token> {
  @Autowired(required = false)
  private Collection<TokenEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<TokenEventsListener> getListeners() {
    return listeners;
  }
}
