package edu.fudan.langlab.domain.workflow;

import edu.fudan.langlab.domain.workflow.Activity;
import edu.fudan.langlab.domain.workflow.ActivityNodeDef;
import edu.fudan.langlab.domain.workflow.ProcessManager;
import edu.fudan.langlab.domain.workflow.Token;
import edu.fudan.langlab.domain.workflow.impl.BusinessProcessImpl;
import edu.fudan.langlab.domain.workflow.proxy.BusinessProcessProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.INamedModelObject;
import java.util.Collection;
import java.util.Date;

@EntityImplementation(implementBy = BusinessProcessImpl.class)
public interface BusinessProcess extends IModelObject, INamedModelObject {
  public abstract Collection<Activity> getActivities();
  
  public abstract Activity createAndAddtoActivities();
  
  public abstract BusinessProcess removeFromActivities(final Activity activity);
  
  public abstract BusinessProcess removeAllActivities();
  
  public abstract Collection<Token> getTokens();
  
  public abstract Token createAndAddtoTokens(final ActivityNodeDef targetActivity);
  
  public abstract BusinessProcess removeFromTokens(final Token token);
  
  public abstract BusinessProcess removeAllTokens();
  
  public abstract Boolean getIsFinished();
  
  public abstract BusinessProcess setIsFinished(final Boolean isFinished);
  
  public abstract Date getStartDate();
  
  public abstract BusinessProcess setStartDate(final Date startDate);
  
  public abstract ProcessManager getProcessManager();
  
  public abstract String getProcessId();
  
  public abstract void finish();
  
  public abstract ActivityNodeDef getActivityDef(final String activityId);
  
  public abstract String getProcessName();
  
  public abstract String getProcessType();
  
  public abstract void systemExecute();
  
  public abstract boolean _systemExecute();
  
  public abstract String getEntityName();
  
  public abstract String getStatusSummary();
  
  public abstract BusinessProcessProxy toProxy();
}
