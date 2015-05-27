package edu.fudan.langlab.domain.workflow;

import edu.fudan.langlab.domain.workflow.ActivityNodeDef;
import edu.fudan.langlab.domain.workflow.BusinessProcess;
import edu.fudan.langlab.domain.workflow.ForkStatus;
import edu.fudan.langlab.domain.workflow.ProcessTask;
import edu.fudan.langlab.domain.workflow.impl.TokenImpl;
import edu.fudan.langlab.domain.workflow.proxy.TokenProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Collection;

@EntityImplementation(implementBy = TokenImpl.class)
public interface Token extends IModelObject {
  public abstract BusinessProcess getBp();
  
  public abstract Token setBp(final BusinessProcess bp);
  
  public abstract ActivityNodeDef getTargetActivity();
  
  public abstract Token setTargetActivity(final ActivityNodeDef targetActivity);
  
  public abstract Collection<ForkStatus> getForkJoinPoints();
  
  public abstract Token addtoForkJoinPoints(final ForkStatus forkStatus);
  
  public abstract Token setForkJoinPoints(final Iterable<ForkStatus> forkJoinPoints);
  
  public abstract Token removeFromForkJoinPoints(final ForkStatus forkStatus);
  
  public abstract Token removeAllForkJoinPoints();
  
  public abstract Collection<String> getDecisionMergePoints();
  
  public abstract Token setDecisionMergePoints(final Iterable<String> decisionMergePoints);
  
  public abstract Token addtoDecisionMergePoints(final String string);
  
  public abstract Token removeAllDecisionMergePoints();
  
  public abstract Token removeFromDecisionMergePoints(final String string);
  
  public abstract ProcessTask getProcessTask();
  
  public abstract void pushMergePoint(final String activityId);
  
  public abstract String popMergePoint();
  
  public abstract ForkStatus peekForkPoint();
  
  public abstract ForkStatus popForkPoint();
  
  public abstract ForkStatus pushForkPoint(final String joinPoint);
  
  public abstract Token cloneWith(final String newActivityId);
  
  public abstract TokenProxy toProxy();
}
