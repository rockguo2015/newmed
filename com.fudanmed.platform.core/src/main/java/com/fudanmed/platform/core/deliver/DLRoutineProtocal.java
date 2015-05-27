package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLRoutineTaskTemplate;
import com.fudanmed.platform.core.deliver.impl.DLRoutineProtocalImpl;
import com.fudanmed.platform.core.deliver.proxy.DLRoutineProtocalProxy;
import edu.fudan.langlab.domain.common.DateRange;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;

@EntityImplementation(implementBy = DLRoutineProtocalImpl.class)
public interface DLRoutineProtocal extends IModelObject {
  public abstract DLRoutineTaskTemplate getTemplate();
  
  public abstract DLRoutineProtocal setTemplate(final DLRoutineTaskTemplate template);
  
  public abstract String getTitle();
  
  public abstract DLRoutineProtocal setTitle(final String title);
  
  public abstract DateRange getApplyDateRange();
  
  public abstract DLRoutineProtocal setApplyDateRange(final DateRange applyDateRange);
  
  public abstract DLRoutineProtocalProxy toProxy();
}
