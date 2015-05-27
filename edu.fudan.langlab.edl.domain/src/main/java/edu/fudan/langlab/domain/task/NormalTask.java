package edu.fudan.langlab.domain.task;

import edu.fudan.langlab.domain.task.Task;
import edu.fudan.langlab.domain.task.impl.NormalTaskImpl;
import edu.fudan.langlab.domain.task.proxy.NormalTaskProxy;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = NormalTaskImpl.class)
public interface NormalTask extends Task {
  public abstract String getTaskTypeName();
  
  public abstract NormalTask setTaskTypeName(final String taskTypeName);
  
  public abstract String getTaskCategory();
  
  public abstract NormalTaskProxy toProxy();
}
