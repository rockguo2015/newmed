package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverSubject;
import com.google.gwt.user.client.rpc.IsSerializable;

public interface DLTaskConsumer extends IsSerializable {
  public abstract void forwardTo(final DLTaskConsumer consumer, final DLDeliverSubject subject);
  
  public abstract Object toProxy();
}
