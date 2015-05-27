package edu.fudan.langlab.domain.statemachine.impl;

import edu.fudan.langlab.domain.statemachine.ModelObjectLogService;
import edu.fudan.langlab.domain.statemachine.StateMachineLog;
import edu.fudan.langlab.domain.statemachine.impl.StateMachineLogImpl;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IGenericQuery;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.stereotype.Service;

@Service("edu.fudan.langlab.domain.statemachine.ModelObjectLogService")
public class ModelObjectLogServiceImpl extends BaseService implements ModelObjectLogService {
  public StateMachineLog createLog(final IModelObject modelObject, final String smid, final String actionName) {StateMachineLog stateMachineLog=StateMachineLogImpl.create(getObjectFactory());
    final Procedure1<StateMachineLog> _function = new Procedure1<StateMachineLog>() {
        public void apply(final StateMachineLog it) {
          Class<? extends Object> _class = modelObject.getClass();
          String _name = _class.getName();
          it.setType(_name);
          Long _id = modelObject.getId();
          it.setTargetid(_id);
          it.setSmid(smid);
          it.setActionName(actionName);
          Date _date = new Date();
          it.setDate(_date);
        }
      };
    StateMachineLog _doubleArrow = ObjectExtensions.<StateMachineLog>operator_doubleArrow(stateMachineLog, _function);
    return _doubleArrow;
  }
  
  public Collection<StateMachineLog> findLog(final IModelObject modelObject, final String smid) {
    Collection<StateMachineLog> _xblockexpression = null;
    {
      Class<? extends Object> _class = modelObject.getClass();
      final String typeName = _class.getName();
      Long objectId = modelObject.getId();
      IGenericQuery<StateMachineLog> query=getObjectFactory().createGenericQuery(StateMachineLog.class,"select sm from edu.fudan.langlab.domain.statemachine.impl.StateMachineLogImpl as sm   where (((sm.type = :typeName) and (sm.targetid = :objectId)) and (sm.smid = :smid)) and  sm.active = 1  order by sm.date ASC    ").setParameter("typeName",typeName).setParameter("objectId",objectId).setParameter("smid",smid);
      Collection<StateMachineLog> _list = query.list();
      _xblockexpression = (_list);
    }
    return _xblockexpression;
  }
}
