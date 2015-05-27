package com.fudanmed.platform.core.common.events;

import com.fudanmed.platform.core.common.RCMaterialBrand;
import com.fudanmed.platform.core.common.events.RCMaterialBrandEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.common.events.RCMaterialBrandEventsManager")
public class RCMaterialBrandEventsManager extends EntityEventsManager<RCMaterialBrand> {
  @Autowired(required = false)
  private Collection<RCMaterialBrandEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCMaterialBrandEventsListener> getListeners() {
    return listeners;
  }
}
