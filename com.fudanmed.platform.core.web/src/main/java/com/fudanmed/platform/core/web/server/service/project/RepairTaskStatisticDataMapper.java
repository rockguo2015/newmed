package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCGroupTask;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCSettlement;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatisticData;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.RepairTaskStatisticDataMapper")
public class RepairTaskStatisticDataMapper extends AbstractEntityMapper<UIRepairTaskStatisticData,RCRepairTask> {
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
  
  public void copyToEntity(final UIRepairTaskStatisticData from, final RCRepairTask to) {
    to.setVersion(from.getVersion());
    
  }
  
  public UIRepairTaskStatisticData copyFromEntity(final UIRepairTaskStatisticData result, final RCRepairTask entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setReportOrg(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy.class,entity.getReportOrg()));
    result.setReporterName(convertService.toValue(java.lang.String.class,entity.getReporterName()));
    result.setLocation(convertService.toValue(java.lang.String.class,entity.getLocation()));
    result.setFaultReportSource(convertService.toValue(com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy.class,entity.getFaultReportSource()));
    result.setOperator(convertService.toValue(edu.fudan.langlab.domain.organization.proxy.PartyProxy.class,entity.getOperator()));
    result.setReportSid(convertService.toValue(java.lang.String.class,entity.getReportSid()));
    result.setReportTime(convertService.toValue(java.util.Date.class,entity.getReportTime()));
    result.setStatus(convertService.toValue(com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatus.class,entity.getStatus()));
    result.setFaultEmergencyLevel(convertService.toValue(com.fudanmed.platform.core.common.proxy.RCFaultEmergencyLevelProxy.class,entity.getFaultEmergencyLevel()));
    result.setFaultType(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy.class,entity.getFaultType()));
    if(entity. getFaultType()  != null )
    	result.setMType(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy.class,entity.getFaultType().getMtype()));
    result.setComment(convertService.toValue(java.lang.String.class,entity.getComment()));
    result.setFinishTime(convertService.toValue(java.util.Date.class,entity.getFinishTime()));
    if(entity. getRepairEvaluate()  != null )
    	result.setEvaluateComment(convertService.toValue(java.lang.String.class,entity.getRepairEvaluate().getComment()));
    if(entity. getRepairEvaluate()  != null )
    	result.setEvaluater(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy.class,entity.getRepairEvaluate().getEvaluator()));
    if(entity. getRepairEvaluate()  != null )
    	result.setEvaluateTime(convertService.toValue(java.util.Date.class,entity.getRepairEvaluate().getEvaluateDate()));
    buildFromCust(result,entity);
    return result;
    
  }
  
  public UIRepairTaskStatisticData buildFrom(final RCRepairTask entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatisticData result = new com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatisticData();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  protected void buildFromCust(final UIRepairTaskStatisticData _gwt, final RCRepairTask _entity) {
    Collection<RCGroupTask> _groupTasks = _entity.getGroupTasks();
    final Function1<RCGroupTask,RCMaintenanceTeamProxy> _function = new Function1<RCGroupTask,RCMaintenanceTeamProxy>() {
        public RCMaintenanceTeamProxy apply(final RCGroupTask it) {
          RCMaintenanceTeam _team = it.getTeam();
          RCMaintenanceTeamProxy _proxy = _team.toProxy();
          return _proxy;
        }
      };
    Iterable<RCMaintenanceTeamProxy> _map = IterableExtensions.<RCGroupTask, RCMaintenanceTeamProxy>map(_groupTasks, _function);
    Set<RCMaintenanceTeamProxy> _set = IterableExtensions.<RCMaintenanceTeamProxy>toSet(_map);
    _gwt.setTeams(_set);
    Collection<RCGroupTask> _groupTasks_1 = _entity.getGroupTasks();
    final Function1<RCGroupTask,Collection<RCWorkItemTask>> _function_1 = new Function1<RCGroupTask,Collection<RCWorkItemTask>>() {
        public Collection<RCWorkItemTask> apply(final RCGroupTask it) {
          Collection<RCWorkItemTask> _tasks = it.getTasks();
          return _tasks;
        }
      };
    Iterable<Collection<RCWorkItemTask>> _map_1 = IterableExtensions.<RCGroupTask, Collection<RCWorkItemTask>>map(_groupTasks_1, _function_1);
    Iterable<RCWorkItemTask> _flatten = Iterables.<RCWorkItemTask>concat(_map_1);
    final Function1<RCWorkItemTask,Collection<RCEmployee>> _function_2 = new Function1<RCWorkItemTask,Collection<RCEmployee>>() {
        public Collection<RCEmployee> apply(final RCWorkItemTask it) {
          Collection<RCEmployee> _workers = it.getWorkers();
          return _workers;
        }
      };
    Iterable<Collection<RCEmployee>> _map_2 = IterableExtensions.<RCWorkItemTask, Collection<RCEmployee>>map(_flatten, _function_2);
    Iterable<RCEmployee> _flatten_1 = Iterables.<RCEmployee>concat(_map_2);
    final Function1<RCEmployee,RCEmployeeProxy> _function_3 = new Function1<RCEmployee,RCEmployeeProxy>() {
        public RCEmployeeProxy apply(final RCEmployee it) {
          RCEmployeeProxy _proxy = it.toProxy();
          return _proxy;
        }
      };
    Iterable<RCEmployeeProxy> _map_3 = IterableExtensions.<RCEmployee, RCEmployeeProxy>map(_flatten_1, _function_3);
    Set<RCEmployeeProxy> _set_1 = IterableExtensions.<RCEmployeeProxy>toSet(_map_3);
    _gwt.setWorkers(_set_1);
    Collection<RCGroupTask> _groupTasks_2 = _entity.getGroupTasks();
    final Function1<RCGroupTask,Date> _function_4 = new Function1<RCGroupTask,Date>() {
        public Date apply(final RCGroupTask it) {
          Date _time = it.getTime();
          return _time;
        }
      };
    List<RCGroupTask> _sortBy = IterableExtensions.<RCGroupTask, Date>sortBy(_groupTasks_2, _function_4);
    RCGroupTask _head = IterableExtensions.<RCGroupTask>head(_sortBy);
    Date _time = _head==null?(Date)null:_head.getTime();
    _gwt.setDispatchTime(_time);
    String _xifexpression = null;
    RCSettlement _settlement = _entity.getSettlement();
    boolean _notEquals = (!Objects.equal(_settlement, null));
    if (_notEquals) {
      _xifexpression = "\u5DF2\u7ED3\u7B97";
    } else {
      _xifexpression = "\u672A\u7ED3\u7B97";
    }
    _gwt.setHasSettlement(_xifexpression);
    RCOrganization _reportOrg = _entity.getReportOrg();
    String _fullPath = _reportOrg.fullPath();
    _gwt.setReportOrgFullPath(_fullPath);
  }
  
  public Class<?> getUIClass() {
    return UIRepairTaskStatisticData.class;
  }
  
  public Class<?> getEntityClass() {
    return RCRepairTask.class;
  }
}
