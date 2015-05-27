package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.warehouse.RCProductStorage;
import com.fudanmed.platform.core.warehouse.impl.RCWorkItemStorageImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStorageProxy;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCWorkItemStorageImpl.class)
public interface RCWorkItemStorage extends RCProductStorage {
  public abstract RCWorkItemTask getWorkItem();
  
  public abstract RCWorkItemStorage setWorkItem(final RCWorkItemTask workItem);
  
  public abstract RCWorkItemStorageProxy toProxy();
}
