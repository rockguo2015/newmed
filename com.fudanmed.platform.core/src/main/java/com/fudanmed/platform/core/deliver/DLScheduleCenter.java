package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverSubject;
import com.fudanmed.platform.core.deliver.DLTaskConsumer;
import com.fudanmed.platform.core.deliver.impl.DLScheduleCenterImpl;
import com.fudanmed.platform.core.deliver.proxy.DLScheduleCenterProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;

@EntityImplementation(implementBy = DLScheduleCenterImpl.class)
public interface DLScheduleCenter extends IModelObject, DLTaskConsumer {
  public abstract void forwardTo(final DLTaskConsumer consumer, final DLDeliverSubject subject);
  
  public abstract DLScheduleCenterProxy toProxy();
}
