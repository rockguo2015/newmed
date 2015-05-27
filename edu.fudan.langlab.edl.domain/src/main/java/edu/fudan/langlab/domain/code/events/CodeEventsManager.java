package edu.fudan.langlab.domain.code.events;

import edu.fudan.langlab.domain.code.Code;
import edu.fudan.langlab.domain.code.events.CodeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("edu.fudan.langlab.domain.code.events.CodeEventsManager")
public class CodeEventsManager extends EntityEventsManager<Code> {
  @Autowired(required = false)
  private Collection<CodeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<CodeEventsListener> getListeners() {
    return listeners;
  }
}
