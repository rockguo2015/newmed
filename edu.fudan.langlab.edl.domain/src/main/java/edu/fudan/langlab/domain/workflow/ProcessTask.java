package edu.fudan.langlab.domain.workflow;

import edu.fudan.langlab.domain.task.Task;
import edu.fudan.langlab.domain.workflow.Token;
import edu.fudan.langlab.domain.workflow.impl.ProcessTaskImpl;
import edu.fudan.langlab.domain.workflow.proxy.ProcessTaskProxy;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = ProcessTaskImpl.class)
public interface ProcessTask extends Task {
  public abstract Token getToken();
  
  public abstract ProcessTask setToken(final Token token);
  
  public abstract String getTaskTypeName();
  
  public abstract String getTaskCategory();
  
  public abstract ProcessTaskProxy toProxy();
}
