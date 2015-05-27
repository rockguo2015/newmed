package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLRoutineProtocal;
import com.fudanmed.platform.core.deliver.impl.DLRoutineTaskTemplateImpl;
import com.fudanmed.platform.core.deliver.proxy.DLRoutineTaskTemplateProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Date;

@EntityImplementation(implementBy = DLRoutineTaskTemplateImpl.class)
public interface DLRoutineTaskTemplate extends IModelObject {
  public abstract DLRoutineProtocal getProtocal();
  
  public abstract DLRoutineTaskTemplate setProtocal(final DLRoutineProtocal protocal);
  
  public abstract void generateTasks(final Date fromDate, final Date toDate);
  
  public abstract DLRoutineTaskTemplateProxy toProxy();
}
