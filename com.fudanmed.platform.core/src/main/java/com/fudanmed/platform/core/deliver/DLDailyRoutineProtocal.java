package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLRoutineProtocal;
import com.fudanmed.platform.core.deliver.impl.DLDailyRoutineProtocalImpl;
import com.fudanmed.platform.core.deliver.proxy.DLDailyRoutineProtocalProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import java.util.Date;

@EntityImplementation(implementBy = DLDailyRoutineProtocalImpl.class)
public interface DLDailyRoutineProtocal extends DLRoutineProtocal {
  public abstract Date getFromDate();
  
  public abstract DLDailyRoutineProtocal setFromDate(final Date fromDate);
  
  public abstract Date getToDate();
  
  public abstract DLDailyRoutineProtocal setToDate(final Date toDate);
  
  public abstract Boolean getIsForever();
  
  public abstract DLDailyRoutineProtocal setIsForever(final Boolean isForever);
  
  public abstract DLDailyRoutineProtocalProxy toProxy();
}
