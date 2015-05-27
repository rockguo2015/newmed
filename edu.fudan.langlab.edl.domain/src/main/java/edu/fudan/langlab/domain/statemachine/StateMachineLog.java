package edu.fudan.langlab.domain.statemachine;

import edu.fudan.langlab.domain.statemachine.impl.StateMachineLogImpl;
import edu.fudan.langlab.domain.statemachine.proxy.StateMachineLogProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Date;

@EntityImplementation(implementBy = StateMachineLogImpl.class)
public interface StateMachineLog extends IModelObject {
  public abstract String getType();
  
  public abstract StateMachineLog setType(final String type);
  
  public abstract Long getTargetid();
  
  public abstract StateMachineLog setTargetid(final Long targetid);
  
  public abstract String getSmid();
  
  public abstract StateMachineLog setSmid(final String smid);
  
  public abstract Date getDate();
  
  public abstract StateMachineLog setDate(final Date date);
  
  public abstract String getActionName();
  
  public abstract StateMachineLog setActionName(final String actionName);
  
  public abstract StateMachineLogProxy toProxy();
}
