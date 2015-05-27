package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLTaskSourceType;
import com.fudanmed.platform.core.deliver.impl.DLTaskSourceImpl;
import com.fudanmed.platform.core.deliver.proxy.DLTaskSourceProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;

@EntityImplementation(implementBy = DLTaskSourceImpl.class)
public interface DLTaskSource extends IModelObject {
  public abstract DLTaskSourceType getType();
  
  public abstract DLTaskSource setType(final DLTaskSourceType type);
  
  public abstract DLTaskSourceProxy toProxy();
}
