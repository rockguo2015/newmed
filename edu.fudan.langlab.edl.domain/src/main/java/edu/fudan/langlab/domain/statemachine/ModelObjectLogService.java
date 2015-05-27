package edu.fudan.langlab.domain.statemachine;

import edu.fudan.langlab.domain.statemachine.StateMachineLog;
import edu.fudan.mylang.pf.IBaseService;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Collection;

public interface ModelObjectLogService extends IBaseService {
  public abstract StateMachineLog createLog(final IModelObject modelObject, final String smid, final String actionName);
  
  public abstract Collection<StateMachineLog> findLog(final IModelObject modelObject, final String smid);
}
