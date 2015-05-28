package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCGroupTask;
import com.fudanmed.platform.core.domain.RCGroupTaskStatus;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.RCWorkItemTaskStatus;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.client.project.RepairTaskTreeInfoPresenterService;
import com.fudanmed.platform.core.web.server.service.project.RepairTaskMapper;
import com.fudanmed.platform.core.web.shared.project.UIGeneralTask;
import com.fudanmed.platform.core.web.shared.project.UIGeneralTaskType;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskStatus;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTaskStatus;
import com.google.common.base.Objects;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.DateUtil;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.RepairTaskTreeInfoPresenterService")
@Transactional
public class RepairTaskTreeInfoPresenterServiceImpl extends BaseService implements RepairTaskTreeInfoPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private RepairTaskMapper mapper;
  
  public Collection<UIGeneralTask> loadTree(final RCRepairTaskProxy value) throws SessionTimeOutException, ValidationException {
    ArrayList<UIGeneralTask> _xblockexpression = null;
    {
      final ArrayList<UIGeneralTask> result = CollectionLiterals.<UIGeneralTask>newArrayList();
      RCRepairTask _resolved= null;
      if(value!=null) _resolved=(com.fudanmed.platform.core.domain.RCRepairTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
      
      Collection<RCGroupTask> _groupTasks =  _resolved.getGroupTasks();
      final Procedure1<RCGroupTask> _function = new Procedure1<RCGroupTask>() {
          public void apply(final RCGroupTask groupTask) {
            UIGeneralTask _uIGeneralTask = new UIGeneralTask();
            final Procedure1<UIGeneralTask> _function = new Procedure1<UIGeneralTask>() {
                public void apply(final UIGeneralTask generalGroupTask) {
                  generalGroupTask.setTaskType(UIGeneralTaskType.groupTask);
                  Long _id = groupTask.getId();
                  generalGroupTask.setObjectId(_id);
                  Date _date = groupTask.getDate();
                  Date _time = groupTask.getTime();
                  Date _appendTime = DateUtil.appendTime(_date, _time);
                  generalGroupTask.setDateTime(_appendTime);
                  Date _finishDate = groupTask.getFinishDate();
                  Date _finishTime = groupTask.getFinishTime();
                  Date _appendTime_1 = DateUtil.appendTime(_finishDate, _finishTime);
                  generalGroupTask.setFinishDateTime(_appendTime_1);
                  RCMaintenanceTeam _team = groupTask.getTeam();
                  RCMaintenanceTeamProxy _proxy = _team.toProxy();
                  String _name = _proxy.getName();
                  generalGroupTask.setTaskOwner(_name);
                  RCGroupTaskStatus _status = groupTask.getStatus();
                  UIGroupTaskStatus _value = RepairTaskTreeInfoPresenterServiceImpl.this.convertService.<RCGroupTaskStatus, UIGroupTaskStatus>toValue(UIGroupTaskStatus.class, _status);
                  String _string = _value.toString();
                  generalGroupTask.setStatus(_string);
                  RCEmployee _operator = groupTask.getOperator();
                  RCEmployeeProxy _proxy_1 = _operator==null?(RCEmployeeProxy)null:_operator.toProxy();
                  generalGroupTask.setOperator(_proxy_1);
                  Collection<RCWorkItemTask> _tasks = groupTask.getTasks();
                  final Procedure1<RCWorkItemTask> _function = new Procedure1<RCWorkItemTask>() {
                      public void apply(final RCWorkItemTask workItemTask) {
                        UIGeneralTask _uIGeneralTask = new UIGeneralTask();
                        final Procedure1<UIGeneralTask> _function = new Procedure1<UIGeneralTask>() {
                            public void apply(final UIGeneralTask generalWorkItemTask) {
                              generalWorkItemTask.setTaskType(UIGeneralTaskType.workitemTask);
                              Long _id = workItemTask.getId();
                              generalWorkItemTask.setObjectId(_id);
                              Date _date = workItemTask.getDate();
                              Date _time = workItemTask.getTime();
                              Date _appendTime = DateUtil.appendTime(_date, _time);
                              generalWorkItemTask.setDateTime(_appendTime);
                              Date _finishDate = workItemTask.getFinishDate();
                              Date _finishTime = workItemTask.getFinishTime();
                              Date _appendTime_1 = DateUtil.appendTime(_finishDate, _finishTime);
                              generalWorkItemTask.setFinishDateTime(_appendTime_1);
                              Collection<RCEmployee> _workers = workItemTask.getWorkers();
                              final Function1<RCEmployee,String> _function = new Function1<RCEmployee,String>() {
                                  public String apply(final RCEmployee it) {
                                    String _entityName = it.getEntityName();
                                    return _entityName;
                                  }
                                };
                              Iterable<String> _map = IterableExtensions.<RCEmployee, String>map(_workers, _function);
                              String _join = IterableExtensions.join(_map, ",");
                              generalWorkItemTask.setTaskOwner(_join);
                              int _hashCode = generalGroupTask.hashCode();
                              generalWorkItemTask.setParent(Integer.valueOf(_hashCode));
                              RCWorkItemTaskStatus _status = workItemTask.getStatus();
                              UIWorkItemTaskStatus _value = RepairTaskTreeInfoPresenterServiceImpl.this.convertService.<RCWorkItemTaskStatus, UIWorkItemTaskStatus>toValue(UIWorkItemTaskStatus.class, _status);
                              String _string = _value.toString();
                              generalWorkItemTask.setStatus(_string);
                              RCEmployee _operator = workItemTask.getOperator();
                              RCEmployeeProxy _proxy = _operator==null?(RCEmployeeProxy)null:_operator.toProxy();
                              generalWorkItemTask.setOperator(_proxy);
                            }
                          };
                        UIGeneralTask _doubleArrow = ObjectExtensions.<UIGeneralTask>operator_doubleArrow(_uIGeneralTask, _function);
                        result.add(_doubleArrow);
                      }
                    };
                  IterableExtensions.<RCWorkItemTask>forEach(_tasks, _function);
                }
              };
            UIGeneralTask _doubleArrow = ObjectExtensions.<UIGeneralTask>operator_doubleArrow(_uIGeneralTask, _function);
            result.add(_doubleArrow);
          }
        };
      IterableExtensions.<RCGroupTask>forEach(_groupTasks, _function);
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public String loadComment(final UIGeneralTask generalTask) throws SessionTimeOutException, ValidationException {
    String _switchResult = null;
    UIGeneralTaskType _taskType = generalTask.getTaskType();
    final UIGeneralTaskType _switchValue = _taskType;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,UIGeneralTaskType.groupTask)) {
        _matched=true;
        Long _objectId = generalTask.getObjectId();
        RCGroupTask _get = this.entities.<RCGroupTask>get(RCGroupTask.class, _objectId);
        String _comment = _get.getComment();
        _switchResult = _comment;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,UIGeneralTaskType.workitemTask)) {
        _matched=true;
        Long _objectId_1 = generalTask.getObjectId();
        RCWorkItemTask _get_1 = this.entities.<RCWorkItemTask>get(RCWorkItemTask.class, _objectId_1);
        String _comment_1 = _get_1.getComment();
        _switchResult = _comment_1;
      }
    }
    return _switchResult;
  }
}
