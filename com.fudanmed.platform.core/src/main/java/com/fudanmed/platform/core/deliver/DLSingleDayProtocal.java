package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLRoutineProtocal;
import com.fudanmed.platform.core.deliver.impl.DLSingleDayProtocalImpl;
import com.fudanmed.platform.core.deliver.proxy.DLSingleDayProtocalProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import java.util.Date;

@EntityImplementation(implementBy = DLSingleDayProtocalImpl.class)
public interface DLSingleDayProtocal extends DLRoutineProtocal {
  public abstract Date getDate();
  
  public abstract DLSingleDayProtocal setDate(final Date date);
  
  public abstract DLSingleDayProtocalProxy toProxy();
}
