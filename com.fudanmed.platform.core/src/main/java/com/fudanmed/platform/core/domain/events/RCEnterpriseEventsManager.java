package com.fudanmed.platform.core.domain.events;

import com.fudanmed.platform.core.domain.RCEnterprise;
import com.fudanmed.platform.core.domain.events.RCEnterpriseEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.events.RCEnterpriseEventsManager")
public class RCEnterpriseEventsManager extends EntityEventsManager<RCEnterprise> {
  @Autowired(required = false)
  private Collection<RCEnterpriseEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCEnterpriseEventsListener> getListeners() {
    return listeners;
  }
}
