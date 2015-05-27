package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLRoutineProtocal;
import com.fudanmed.platform.core.deliver.DLWeekDay;
import com.fudanmed.platform.core.deliver.impl.DLWeeklyRoutineProtocalImpl;
import com.fudanmed.platform.core.deliver.proxy.DLWeeklyRoutineProtocalProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import java.util.Collection;
import java.util.Date;

@EntityImplementation(implementBy = DLWeeklyRoutineProtocalImpl.class)
public interface DLWeeklyRoutineProtocal extends DLRoutineProtocal {
  public abstract Collection<DLWeekDay> getWeekdays();
  
  public abstract DLWeeklyRoutineProtocal setWeekdays(final Iterable<DLWeekDay> weekdays);
  
  public abstract DLWeeklyRoutineProtocal addtoWeekdays(final DLWeekDay dLWeekDay);
  
  public abstract DLWeeklyRoutineProtocal removeAllWeekdays();
  
  public abstract DLWeeklyRoutineProtocal removeFromWeekdays(final DLWeekDay dLWeekDay);
  
  public abstract void generateTasks(final Date fromDate, final Date toDate);
  
  public abstract DLWeeklyRoutineProtocalProxy toProxy();
}
