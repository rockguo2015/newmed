package edu.fudan.langlab.domain.workflow;

import edu.fudan.langlab.domain.organization.Party;
import edu.fudan.langlab.domain.workflow.Activity;
import edu.fudan.langlab.domain.workflow.BusinessProcess;
import edu.fudan.langlab.domain.workflow.ProcessTask;
import edu.fudan.langlab.domain.workflow.Token;
import edu.fudan.mylang.pf.IBaseService;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public interface ProcessManager extends IBaseService {
  public abstract Token start(final BusinessProcess bp, final String targetActivity);
  
  public abstract Token assertToken(final BusinessProcess bp, final String activityId);
  
  public abstract boolean tokenPresent(final BusinessProcess bp, final String activityId);
  
  public abstract Token forwardTo(final Token token, final String activityId);
  
  public abstract Token enterDecision(final Token token, final String decisionId, final String mergePoint);
  
  public abstract Token merge(final Token token);
  
  public abstract Token prepareFork(final Token token, final String joinPoint);
  
  public abstract Token fork(final Token token, final String activityId);
  
  public abstract void join(final Token token, final Procedure1<? super Token> joinedAction);
  
  public abstract void join(final Token token);
  
  public abstract void tokenForked(final Token token);
  
  public abstract void deleteToken(final Token token);
  
  public abstract Activity createActivity(final BusinessProcess p, final String activityName, final String comment);
  
  public abstract void removeTask(final ProcessTask task);
  
  public abstract ProcessTask registTask(final BusinessProcess bp, final Token token, final Party taskOwner, final String description);
}
