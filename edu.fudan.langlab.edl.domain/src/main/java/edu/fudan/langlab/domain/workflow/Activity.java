package edu.fudan.langlab.domain.workflow;

import edu.fudan.langlab.domain.security.User;
import edu.fudan.langlab.domain.workflow.BusinessProcess;
import edu.fudan.langlab.domain.workflow.ProcessManager;
import edu.fudan.langlab.domain.workflow.impl.ActivityImpl;
import edu.fudan.langlab.domain.workflow.proxy.ActivityProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.INamedModelObject;
import java.util.Date;

@EntityImplementation(implementBy = ActivityImpl.class)
public interface Activity extends IModelObject, INamedModelObject {
  public abstract User getExecuter();
  
  public abstract Activity setExecuter(final User executer);
  
  public abstract Date getExecuteDate();
  
  public abstract Activity setExecuteDate(final Date executeDate);
  
  public abstract String getActivityName();
  
  public abstract Activity setActivityName(final String activityName);
  
  public abstract String getComment();
  
  public abstract Activity setComment(final String comment);
  
  public abstract BusinessProcess getBp();
  
  public abstract Activity setBp(final BusinessProcess bp);
  
  public abstract ProcessManager getProcessManager();
  
  public abstract String getEntityName();
  
  public abstract String toString();
  
  public abstract ActivityProxy toProxy();
}
