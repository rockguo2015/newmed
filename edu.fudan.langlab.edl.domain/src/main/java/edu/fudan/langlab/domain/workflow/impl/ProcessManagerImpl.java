package edu.fudan.langlab.domain.workflow.impl;

import com.google.common.base.Objects;
import edu.fudan.langlab.domain.organization.Party;
import edu.fudan.langlab.domain.security.ISystemUserService;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.langlab.domain.task.TaskService;
import edu.fudan.langlab.domain.workflow.Activity;
import edu.fudan.langlab.domain.workflow.ActivityNodeDef;
import edu.fudan.langlab.domain.workflow.BusinessProcess;
import edu.fudan.langlab.domain.workflow.ForkStatus;
import edu.fudan.langlab.domain.workflow.ProcessManager;
import edu.fudan.langlab.domain.workflow.ProcessTask;
import edu.fudan.langlab.domain.workflow.Token;
import edu.fudan.langlab.domain.workflow.impl.ProcessTaskImpl;
import edu.fudan.langlab.domain.workflow.impl.TokenImpl;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IGenericQuery;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("edu.fudan.langlab.domain.workflow.ProcessManager")
public class ProcessManagerImpl extends BaseService implements ProcessManager {
  @Autowired
  private ISystemUserService systemUserService;
  
  @Autowired
  private TaskService taskService;
  
  public Token start(final BusinessProcess bp, final String targetActivity) {
    Token _xblockexpression = null;
    {
      Date _date = new Date();
      bp.setStartDate(_date);
      ActivityNodeDef _activityDef = bp.getActivityDef(targetActivity);Token token=TokenImpl.create(_activityDef,bp,getObjectFactory());
      _xblockexpression = (token);
    }
    return _xblockexpression;
  }
  
  public Token assertToken(final BusinessProcess bp, final String activityId) {
    IGenericQuery<Token> query=getObjectFactory().createGenericQuery(Token.class,"select tk from edu.fudan.langlab.domain.workflow.impl.TokenImpl as tk   where ((tk.bp = :bp) and (tk.targetActivity.activityId = :activityId)) and  tk.active = 1      ").setParameter("bp",bp).setParameter("activityId",activityId);
    Token result = query.uniqueResult();
    boolean _equals = Objects.equal(result, null);
    if (_equals) {
      RuntimeException _runtimeException = new RuntimeException("invalid state");
      throw _runtimeException;
    }
    return result;
  }
  
  public boolean tokenPresent(final BusinessProcess bp, final String activityId) {
    boolean _xblockexpression = false;
    {
      IGenericQuery<Token> query=getObjectFactory().createGenericQuery(Token.class,"select tk from edu.fudan.langlab.domain.workflow.impl.TokenImpl as tk   where ((tk.bp = :bp) and (tk.targetActivity.activityId = :activityId)) and  tk.active = 1      ").setParameter("bp",bp).setParameter("activityId",activityId);
      Token result = query.uniqueResult();
      boolean _notEquals = (!Objects.equal(result, null));
      _xblockexpression = (_notEquals);
    }
    return _xblockexpression;
  }
  
  public Token forwardTo(final Token token, final String activityId) {
    Token _xblockexpression = null;
    {
      Token newToken = token.cloneWith(activityId);
      this.deleteToken(token);
      _xblockexpression = (newToken);
    }
    return _xblockexpression;
  }
  
  public Token enterDecision(final Token token, final String decisionId, final String mergePoint) {
    Token _xblockexpression = null;
    {
      token.pushMergePoint(mergePoint);
      _xblockexpression = (token);
    }
    return _xblockexpression;
  }
  
  public Token merge(final Token token) {
    String _popMergePoint = token.popMergePoint();
    Token _forwardTo = this.forwardTo(token, _popMergePoint);
    return _forwardTo;
  }
  
  public Token prepareFork(final Token token, final String joinPoint) {
    Token _xblockexpression = null;
    {
      token.pushForkPoint(joinPoint);
      _xblockexpression = (token);
    }
    return _xblockexpression;
  }
  
  public Token fork(final Token token, final String activityId) {
    Token _cloneWith = token.cloneWith(activityId);
    final Procedure1<Token> _function = new Procedure1<Token>() {
        public void apply(final Token it) {
          ForkStatus f = it.peekForkPoint();
          Integer _activeActivities = f.getActiveActivities();
          int _plus = ((_activeActivities).intValue() + 1);
          f.setActiveActivities(Integer.valueOf(_plus));
        }
      };
    Token _doubleArrow = ObjectExtensions.<Token>operator_doubleArrow(_cloneWith, _function);
    return _doubleArrow;
  }
  
  public void join(final Token token, final Procedure1<? super Token> joinedAction) {
    ForkStatus f = token.peekForkPoint();
    Integer _activeActivities = f.getActiveActivities();
    int _minus = ((_activeActivities).intValue() - 1);
    f.setActiveActivities(Integer.valueOf(_minus));
    Integer _activeActivities_1 = f.getActiveActivities();
    boolean _equals = ((_activeActivities_1).intValue() == 0);
    if (_equals) {
      ForkStatus _popForkPoint = token.popForkPoint();getObjectFactory().delete(_popForkPoint);
      
      String _joinPoint = f.getJoinPoint();
      Token newToken = this.forwardTo(token, _joinPoint);
      boolean _notEquals = (!Objects.equal(joinedAction, null));
      if (_notEquals) {
        joinedAction.apply(newToken);
      }
    } else {
      this.deleteToken(token);
    }
  }
  
  public void join(final Token token) {
    this.join(token, null);
  }
  
  public void tokenForked(final Token token) {
    this.deleteToken(token);
  }
  
  public void deleteToken(final Token token) {
    IGenericQuery<ProcessTask> query=getObjectFactory().createGenericQuery(ProcessTask.class,"select pt from edu.fudan.langlab.domain.workflow.impl.ProcessTaskImpl as pt   where (pt.token = :token) and  pt.active = 1      ").setParameter("token",token);
    Collection<ProcessTask> _list = query.list();
    final Procedure1<ProcessTask> _function = new Procedure1<ProcessTask>() {
        public void apply(final ProcessTask it) {
          ProcessManagerImpl.this.removeTask(it);
        }
      };
    IterableExtensions.<ProcessTask>forEach(_list, _function);getObjectFactory().delete(token);
    
  }
  
  public Activity createActivity(final BusinessProcess p, final String activityName, final String comment) {
    Activity _createAndAddtoActivities = p.createAndAddtoActivities();
    final Procedure1<Activity> _function = new Procedure1<Activity>() {
        public void apply(final Activity it) {
          User _currentUser = ProcessManagerImpl.this.systemUserService.getCurrentUser();
          it.setExecuter(_currentUser);
          Date _date = new Date();
          it.setExecuteDate(_date);
          it.setActivityName(activityName);
          it.setComment(comment);
        }
      };
    Activity _doubleArrow = ObjectExtensions.<Activity>operator_doubleArrow(_createAndAddtoActivities, _function);
    return _doubleArrow;
  }
  
  public void removeTask(final ProcessTask task) {
    this.taskService.notifyTaskTeBeDeleted(task);getObjectFactory().delete(task);
    
  }
  
  public ProcessTask registTask(final BusinessProcess bp, final Token token, final Party taskOwner, final String description) {ProcessTask processTask=ProcessTaskImpl.create(getObjectFactory());
    final Procedure1<ProcessTask> _function = new Procedure1<ProcessTask>() {
        public void apply(final ProcessTask it) {
          it.setDescription(description);
          String _processType = bp.getProcessType();
          String _plus = (_processType + ".");
          ActivityNodeDef _targetActivity = token.getTargetActivity();
          String _activityId = _targetActivity.getActivityId();
          String _plus_1 = (_plus + _activityId);
          it.setTaskType(_plus_1);
          it.setOwner(taskOwner);
          Date _date = new Date();
          it.setGenDate(_date);
          it.setToken(token);
          ProcessManagerImpl.this.taskService.notifyTaskCreated(it);
        }
      };
    ProcessTask _doubleArrow = ObjectExtensions.<ProcessTask>operator_doubleArrow(processTask, _function);
    return _doubleArrow;
  }
}
