package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLRoutineProtocal;
import com.fudanmed.platform.core.deliver.DLTaskSource;
import com.fudanmed.platform.core.deliver.impl.DLTaskProtocalSourceImpl;
import com.fudanmed.platform.core.deliver.proxy.DLTaskProtocalSourceProxy;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = DLTaskProtocalSourceImpl.class)
public interface DLTaskProtocalSource extends DLTaskSource {
  public abstract DLRoutineProtocal getProtocal();
  
  public abstract DLTaskProtocalSource setProtocal(final DLRoutineProtocal protocal);
  
  public abstract String getEntityName();
  
  public abstract DLTaskProtocalSourceProxy toProxy();
}
