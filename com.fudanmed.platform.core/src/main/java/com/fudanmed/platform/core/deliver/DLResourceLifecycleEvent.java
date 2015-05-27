package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLResourceEvent;
import com.fudanmed.platform.core.deliver.DLResourceEventType;
import com.fudanmed.platform.core.deliver.impl.DLResourceLifecycleEventImpl;
import com.fudanmed.platform.core.deliver.proxy.DLResourceLifecycleEventProxy;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = DLResourceLifecycleEventImpl.class)
public interface DLResourceLifecycleEvent extends DLResourceEvent {
  public abstract DLResourceEventType getType();
  
  public abstract DLResourceLifecycleEvent setType(final DLResourceEventType type);
  
  public abstract DLResourceLifecycleEventProxy toProxy();
}
