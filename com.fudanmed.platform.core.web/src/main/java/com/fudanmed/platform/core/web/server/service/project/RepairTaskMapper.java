package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.common.RCFaultLevel;
import com.fudanmed.platform.core.common.RCFaultLevelColorAdaptorDao;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCFaultType;
import com.fudanmed.platform.core.domain.RCGroupTask;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCSettlement;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.web.server.service.project.FaultTypeMapper;
import com.fudanmed.platform.core.web.shared.project.UIFaultType;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.uniquesoft.gwt.shared.DateUtil;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.RepairTaskMapper")
public class RepairTaskMapper extends AbstractEntityMapper<UIRepairTask,RCRepairTask> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCRepairTask loadEntityById(final Long id) {
    return entities.get(RCRepairTask.class,id);
  }
  
  public RCRepairTask create() {
    return entities.create(RCRepairTask.class);
  }
  
  @Autowired
  private RCFaultLevelColorAdaptorDao dao;
  
  @Autowired
  private FaultTypeMapper __FaultTypeMapper__;
  
  public void copyToEntity(final UIRepairTask from, final RCRepairTask to) {
    to.setVersion(from.getVersion());
    to.setFaultReportSource(convertService.toValue(com.fudanmed.platform.core.common.RCFaultReportSource.class,from.getFaultReportSource()));
    to.setReportDate(convertService.toValue(java.util.Date.class,from.getReportDate()));
    to.setReportTime(convertService.toValue(java.util.Date.class,from.getReportTime()));
    to.setReserveDate(convertService.toValue(java.util.Date.class,from.getReserveDate()));
    to.setReserveTime(convertService.toValue(java.util.Date.class,from.getReserveTime()));
    to.setPlanFinishDate(convertService.toValue(java.util.Date.class,from.getPlanFinishDate()));
    to.setPlanFinishTime(convertService.toValue(java.util.Date.class,from.getPlanFinishTime()));
    to.setLocation(convertService.toValue(java.lang.String.class,from.getLocation()));
    to.setComment(convertService.toValue(java.lang.String.class,from.getComment()));
    to.setReporterName(convertService.toValue(java.lang.String.class,from.getReporterName()));
    to.setReporterPhone(convertService.toValue(java.lang.String.class,from.getReporterPhone()));
    to.setReportOrg(convertService.toValue(com.fudanmed.platform.core.domain.RCOrganization.class,from.getReportOrg()));
    to.setFaultLevel(convertService.toValue(com.fudanmed.platform.core.common.RCFaultLevel.class,from.getFaultLevel()));
    to.setFaultEmergencyLevel(convertService.toValue(com.fudanmed.platform.core.common.RCFaultEmergencyLevel.class,from.getFaultEmergencyLevel()));
    to.setOperator(convertService.toValue(edu.fudan.langlab.domain.organization.Party.class,from.getOperator()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final UIRepairTask _gwt, final RCRepairTask _entity) {
    UIFaultType _faultType = _gwt.getFaultType();
    boolean _notEquals = (!Objects.equal(_faultType, null));
    if (_notEquals) {
      UIFaultType _faultType_1 = _gwt.getFaultType();
      Long _id = _faultType_1.getId();
      RCFaultType _get = this.entities.<RCFaultType>get(RCFaultType.class, _id);
      _entity.setFaultType(_get);
    }
  }
  
  public UIRepairTask copyFromEntity(final UIRepairTask result, final RCRepairTask entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setReportSid(convertService.toValue(java.lang.String.class,entity.getReportSid()));
    result.setFaultReportSource(convertService.toValue(com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy.class,entity.getFaultReportSource()));
    result.setReportDate(convertService.toValue(java.util.Date.class,entity.getReportDate()));
    result.setReportTime(convertService.toValue(java.util.Date.class,entity.getReportTime()));
    result.setReserveDate(convertService.toValue(java.util.Date.class,entity.getReserveDate()));
    result.setReserveTime(convertService.toValue(java.util.Date.class,entity.getReserveTime()));
    result.setPlanFinishDate(convertService.toValue(java.util.Date.class,entity.getPlanFinishDate()));
    result.setPlanFinishTime(convertService.toValue(java.util.Date.class,entity.getPlanFinishTime()));
    result.setFinishDate(convertService.toValue(java.util.Date.class,entity.getFinishDate()));
    result.setFinishTime(convertService.toValue(java.util.Date.class,entity.getFinishTime()));
    result.setLocation(convertService.toValue(java.lang.String.class,entity.getLocation()));
    result.setComment(convertService.toValue(java.lang.String.class,entity.getComment()));
    result.setReporterName(convertService.toValue(java.lang.String.class,entity.getReporterName()));
    result.setReporterPhone(convertService.toValue(java.lang.String.class,entity.getReporterPhone()));
    result.setReportOrg(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy.class,entity.getReportOrg()));
    result.setFaultLevel(convertService.toValue(com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy.class,entity.getFaultLevel()));
    result.setFaultType(__FaultTypeMapper__.apply(entity.getFaultType()));
    if(entity. getFaultType()  != null )
    	result.setNeedAudit(convertService.toValue(java.lang.Boolean.class,entity.getFaultType().getNeedAudit()));
    result.setFaultEmergencyLevel(convertService.toValue(com.fudanmed.platform.core.common.proxy.RCFaultEmergencyLevelProxy.class,entity.getFaultEmergencyLevel()));
    	result.setStatus(convertService.toValue(com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatus.class,entity.getStatus()));
    result.setOperator(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy.class,entity.getOperator()));
    result.setAmount(convertService.toValue(java.lang.Double.class,entity.getAmount()));
    if(entity. getRepairEvaluate()  != null )
    	result.setEvaluateState(convertService.toValue(com.fudanmed.platform.core.web.shared.project.UIEvaluateState.class,entity.getRepairEvaluate().getEvaluateState()));
    result.setIsFromReporter(convertService.toValue(java.lang.Boolean.class,entity.getIsFromReporter()));
    buildFromCust(result,entity);
    return result;
    
  }
  
  public UIRepairTask buildFrom(final RCRepairTask entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.project.UIRepairTask result = new com.fudanmed.platform.core.web.shared.project.UIRepairTask();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  protected void buildFromCust(final UIRepairTask _gwt, final RCRepairTask _entity) {
    RCGroupTask _activeGroupTask = _entity.getActiveGroupTask();
    boolean _notEquals = (!Objects.equal(_activeGroupTask, null));
    if (_notEquals) {
      RCGroupTask _activeGroupTask_1 = _entity.getActiveGroupTask();
      RCMaintenanceTeam _team = _activeGroupTask_1.getTeam();
      RCMaintenanceTeamProxy _proxy = _team.toProxy();
      _gwt.setActiveTeam(_proxy);
      RCGroupTask _activeGroupTask_2 = _entity.getActiveGroupTask();
      Collection<RCWorkItemTask> _tasks = _activeGroupTask_2.getTasks();
      final Function1<RCWorkItemTask,Collection<RCEmployee>> _function = new Function1<RCWorkItemTask,Collection<RCEmployee>>() {
          public Collection<RCEmployee> apply(final RCWorkItemTask it) {
            Collection<RCEmployee> _workers = it.getWorkers();
            return _workers;
          }
        };
      Iterable<Collection<RCEmployee>> _map = IterableExtensions.<RCWorkItemTask, Collection<RCEmployee>>map(_tasks, _function);
      Iterable<RCEmployee> _flatten = Iterables.<RCEmployee>concat(_map);
      Set<RCEmployee> _set = IterableExtensions.<RCEmployee>toSet(_flatten);
      final Function1<RCEmployee,String> _function_1 = new Function1<RCEmployee,String>() {
          public String apply(final RCEmployee it) {
            String _name = it.getName();
            return _name;
          }
        };
      final Iterable<String> workerNames = IterableExtensions.<RCEmployee, String>map(_set, _function_1);
      String _xifexpression = null;
      int _size = IterableExtensions.size(workerNames);
      boolean _equals = (_size == 0);
      if (_equals) {
        _xifexpression = "";
      } else {
        String _xifexpression_1 = null;
        int _size_1 = IterableExtensions.size(workerNames);
        boolean _equals_1 = (_size_1 == 1);
        if (_equals_1) {
          String _head = IterableExtensions.<String>head(workerNames);
          _xifexpression_1 = _head;
        } else {
          String _head_1 = IterableExtensions.<String>head(workerNames);
          String _plus = (_head_1 + "\u7B49");
          _xifexpression_1 = _plus;
        }
        _xifexpression = _xifexpression_1;
      }
      _gwt.setAbbtActiveWorkers(_xifexpression);
    }
    RCSettlement _settlement = _entity.getSettlement();
    boolean _notEquals_1 = (!Objects.equal(_settlement, null));
    _gwt.setSettlementState(Boolean.valueOf(_notEquals_1));
    Date _reportDate = _entity.getReportDate();
    Date _reportTime = _entity.getReportTime();
    Date _appendTime = DateUtil.appendTime(_reportDate, _reportTime);
    _gwt.setReportDateTime(_appendTime);
    Date _planFinishDate = _entity.getPlanFinishDate();
    Date _planFinishTime = _entity.getPlanFinishTime();
    Date _appendTime_1 = DateUtil.appendTime(_planFinishDate, _planFinishTime);
    _gwt.setPlanFinishDateTime(_appendTime_1);
    RCFaultLevel _faultLevel = _entity.getFaultLevel();
    String _color = this.dao.getColor(_faultLevel);
    _gwt.setFaultLevelColor(_color);
    Collection<RCGroupTask> _groupTasks = _entity.getGroupTasks();
    final Function1<RCGroupTask,RCMaintenanceTeamProxy> _function_2 = new Function1<RCGroupTask,RCMaintenanceTeamProxy>() {
        public RCMaintenanceTeamProxy apply(final RCGroupTask it) {
          RCMaintenanceTeam _team = it.getTeam();
          RCMaintenanceTeamProxy _proxy = _team.toProxy();
          return _proxy;
        }
      };
    Iterable<RCMaintenanceTeamProxy> _map_1 = IterableExtensions.<RCGroupTask, RCMaintenanceTeamProxy>map(_groupTasks, _function_2);
    Collection<RCMaintenanceTeamProxy> _unlazy = IterableExtensions2.<RCMaintenanceTeamProxy>unlazy(_map_1);
    _gwt.setTeams(_unlazy);
    Date _planFinishDateTime = _gwt.getPlanFinishDateTime();
    boolean _notEquals_2 = (!Objects.equal(_planFinishDateTime, null));
    if (_notEquals_2) {
      Date _planFinishDateTime_1 = _gwt.getPlanFinishDateTime();
      Date _now = DateUtil.now();
      boolean _lessThan = (_planFinishDateTime_1.compareTo(_now) < 0);
      _gwt.setIsTimeOut(Boolean.valueOf(_lessThan));
    } else {
      _gwt.setIsTimeOut(Boolean.valueOf(false));
    }
  }
  
  public Class<?> getUIClass() {
    return UIRepairTask.class;
  }
  
  public Class<?> getEntityClass() {
    return RCRepairTask.class;
  }
}
