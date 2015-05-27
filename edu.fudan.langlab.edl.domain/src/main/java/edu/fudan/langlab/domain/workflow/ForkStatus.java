package edu.fudan.langlab.domain.workflow;

import edu.fudan.langlab.domain.workflow.impl.ForkStatusImpl;
import edu.fudan.langlab.domain.workflow.proxy.ForkStatusProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;

@EntityImplementation(implementBy = ForkStatusImpl.class)
public interface ForkStatus extends IModelObject {
  public abstract Integer getActiveActivities();
  
  public abstract ForkStatus setActiveActivities(final Integer activeActivities);
  
  public abstract String getJoinPoint();
  
  public abstract ForkStatus setJoinPoint(final String joinPoint);
  
  public abstract ForkStatusProxy toProxy();
}
