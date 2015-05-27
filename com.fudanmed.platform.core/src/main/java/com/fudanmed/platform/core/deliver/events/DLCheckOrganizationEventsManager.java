package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLCheckOrganization;
import com.fudanmed.platform.core.deliver.events.DLCheckOrganizationEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLCheckOrganizationEventsManager")
public class DLCheckOrganizationEventsManager extends EntityEventsManager<DLCheckOrganization> {
  @Autowired(required = false)
  private Collection<DLCheckOrganizationEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLCheckOrganizationEventsListener> getListeners() {
    return listeners;
  }
}
