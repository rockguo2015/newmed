package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLRoutineProtocal;
import com.fudanmed.platform.core.deliver.impl.DLMonthlyRoutineProtocalImpl;
import com.fudanmed.platform.core.deliver.proxy.DLMonthlyRoutineProtocalProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import java.util.Collection;

@EntityImplementation(implementBy = DLMonthlyRoutineProtocalImpl.class)
public interface DLMonthlyRoutineProtocal extends DLRoutineProtocal {
  public abstract Collection<Integer> getDays();
  
  public abstract DLMonthlyRoutineProtocal setDays(final Iterable<Integer> days);
  
  public abstract DLMonthlyRoutineProtocal addtoDays(final Integer integer);
  
  public abstract DLMonthlyRoutineProtocal removeAllDays();
  
  public abstract DLMonthlyRoutineProtocal removeFromDays(final Integer integer);
  
  public abstract Integer getInterval();
  
  public abstract DLMonthlyRoutineProtocal setInterval(final Integer interval);
  
  public abstract DLMonthlyRoutineProtocalProxy toProxy();
}
