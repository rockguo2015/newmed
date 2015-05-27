package com.fudanmed.platform.core.domain.rest.impl;

import com.fudanmed.platform.core.common.RCSystemParameter;
import com.fudanmed.platform.core.common.RCSystemParameterService;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeUser;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCSecurityService;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.RCWorkItemTaskStatus;
import com.fudanmed.platform.core.domain.rest.LoginResult;
import com.fudanmed.platform.core.domain.rest.MeasureInstrument;
import com.fudanmed.platform.core.domain.rest.MeasureInstrumentType;
import com.fudanmed.platform.core.domain.rest.MeasureValueSubmitInfo;
import com.fudanmed.platform.core.domain.rest.RCFinishedWorkItemTaskCriteria;
import com.fudanmed.platform.core.domain.rest.RCProcessingWorkItemTaskCriteria;
import com.fudanmed.platform.core.domain.rest.RCWorkItemTaskCriteria4Status;
import com.fudanmed.platform.core.domain.rest.RestService;
import com.fudanmed.platform.core.domain.rest.WorkItemBreifInfo;
import com.fudanmed.platform.core.domain.rest.WorkItemFinishInfo;
import com.fudanmed.platform.core.domain.rest.WorkItemInfo;
import com.fudanmed.platform.core.domain.rest.WorkItemReportInfo;
import com.fudanmed.platform.core.measure.RCMeasureDevice;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import edu.fudan.langlab.domain.security.AppFunction;
import edu.fudan.langlab.domain.security.AppFunctionService;
import edu.fudan.langlab.domain.security.SecurityService;
import edu.fudan.langlab.domain.security.UserRoleAssignment;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.rest.RestService")
public class RestServiceImpl extends BaseService implements RestService {
  @Autowired
  private RCSecurityService securityService;
  
  @Autowired
  private SecurityService roleService;
  
  @Autowired
  private AppFunctionService appFunctionService;
  
  @Autowired
  private RCSystemParameterService systemParameterService;
  
  @Autowired
  private IObjectFactory entities;
  
  public LoginResult login(final String userid, final String passwd) {
    LoginResult _xblockexpression = null;
    {
      final RCEmployeeUser user = this.securityService.employeeUserLogin(userid, passwd);
      LoginResult _xifexpression = null;
      boolean _equals = Objects.equal(user, null);
      if (_equals) {
        _xifexpression = null;
      } else {
        LoginResult _loginResult = new LoginResult();
        final Procedure1<LoginResult> _function = new Procedure1<LoginResult>() {
            public void apply(final LoginResult it) {
              RCEmployee _employee = user.getEmployee();
              String _name = _employee.getName();
              it.setUserName(_name);
              RCEmployee _employee_1 = user.getEmployee();
              RCOrganization _organization = _employee_1.getOrganization();
              String _name_1 = _organization.getName();
              it.setDepartment(_name_1);
              Collection<UserRoleAssignment> _allRoles4User = RestServiceImpl.this.roleService.getAllRoles4User(userid);
              final Function1<UserRoleAssignment,Collection<AppFunction>> _function = new Function1<UserRoleAssignment,Collection<AppFunction>>() {
                  public Collection<AppFunction> apply(final UserRoleAssignment it) {
                    String _roleId = it.getRoleId();
                    Collection<AppFunction> _loadAllFunctions4Role = RestServiceImpl.this.appFunctionService.loadAllFunctions4Role(_roleId);
                    return _loadAllFunctions4Role;
                  }
                };
              Iterable<Collection<AppFunction>> _map = IterableExtensions.<UserRoleAssignment, Collection<AppFunction>>map(_allRoles4User, _function);
              Iterable<AppFunction> _flatten = Iterables.<AppFunction>concat(_map);
              Set<AppFunction> _set = IterableExtensions.<AppFunction>toSet(_flatten);
              final Function1<AppFunction,Boolean> _function_1 = new Function1<AppFunction,Boolean>() {
                  public Boolean apply(final AppFunction it) {
                    AppFunction _parent = it.getParent();
                    String _functionId = _parent.getFunctionId();
                    boolean _equals = "com.fudanmed.platform.core.app".equals(_functionId);
                    return Boolean.valueOf(_equals);
                  }
                };
              Iterable<AppFunction> _filter = IterableExtensions.<AppFunction>filter(_set, _function_1);
              final Function1<AppFunction,String> _function_2 = new Function1<AppFunction,String>() {
                  public String apply(final AppFunction it) {
                    String _name = it.getName();
                    return _name;
                  }
                };
              Iterable<String> _map_1 = IterableExtensions.<AppFunction, String>map(_filter, _function_2);
              String _join = IterableExtensions.join(_map_1, ",");
              it.setRoles(_join);
              RCSystemParameter _systemParameter = RestServiceImpl.this.systemParameterService.getSystemParameter();
              String _orgName = _systemParameter.getOrgName();
              it.setHospitalName(_orgName);
            }
          };
        LoginResult _doubleArrow = ObjectExtensions.<LoginResult>operator_doubleArrow(_loginResult, _function);
        _xifexpression = _doubleArrow;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public Boolean modifyPasswd(final String userid, final String oldPasswd, final String newPasswd) {
    boolean _xblockexpression = false;
    {
      final RCEmployeeUser user = this.securityService.employeeUserLogin(userid, oldPasswd);
      boolean _xifexpression = false;
      boolean _notEquals = (!Objects.equal(user, null));
      if (_notEquals) {
        boolean _xblockexpression_1 = false;
        {
          user.setPasswd(newPasswd);
          _xblockexpression_1 = (true);
        }
        _xifexpression = _xblockexpression_1;
      } else {
        _xifexpression = false;
      }
      _xblockexpression = (_xifexpression);
    }
    return Boolean.valueOf(_xblockexpression);
  }
  
  /**
   * 本月已完成的工单数
   */
  public Integer finishedCount(final RCEmployee employee, final Date startDate, final Date endDate) {
    RCFinishedWorkItemTaskCriteria _createQueryCriteria = this.entities.createQueryCriteria(RCFinishedWorkItemTaskCriteria.class);
    final Procedure1<RCFinishedWorkItemTaskCriteria> _function = new Procedure1<RCFinishedWorkItemTaskCriteria>() {
        public void apply(final RCFinishedWorkItemTaskCriteria it) {
          it.setOwner(employee);
          it.setStartDate(startDate);
          it.setEndDate(endDate);
        }
      };
    RCFinishedWorkItemTaskCriteria _doubleArrow = ObjectExtensions.<RCFinishedWorkItemTaskCriteria>operator_doubleArrow(_createQueryCriteria, _function);
    Integer _count = _doubleArrow.count();
    return _count;
  }
  
  /**
   * 本月已完成的工单
   */
  public Collection<WorkItemBreifInfo> getFinishedWorkItem(final RCEmployee employee, final Date startDate, final Date endDate, final Integer startNumber, final Integer endNumber) {
    RCFinishedWorkItemTaskCriteria _createQueryCriteria = this.entities.createQueryCriteria(RCFinishedWorkItemTaskCriteria.class);
    final Procedure1<RCFinishedWorkItemTaskCriteria> _function = new Procedure1<RCFinishedWorkItemTaskCriteria>() {
        public void apply(final RCFinishedWorkItemTaskCriteria it) {
          it.setOwner(employee);
          it.setStartDate(startDate);
          it.setEndDate(endDate);
          it.setStart(startNumber);
          int _minus = ((endNumber).intValue() - (startNumber).intValue());
          it.setLimit(Integer.valueOf(_minus));
        }
      };
    RCFinishedWorkItemTaskCriteria _doubleArrow = ObjectExtensions.<RCFinishedWorkItemTaskCriteria>operator_doubleArrow(_createQueryCriteria, _function);
    Collection<RCWorkItemTask> _list = _doubleArrow.list();
    final Function1<RCWorkItemTask,WorkItemBreifInfo> _function_1 = new Function1<RCWorkItemTask,WorkItemBreifInfo>() {
        public WorkItemBreifInfo apply(final RCWorkItemTask item) {
          WorkItemBreifInfo _workItemBreifInfo = new WorkItemBreifInfo();
          final Procedure1<WorkItemBreifInfo> _function = new Procedure1<WorkItemBreifInfo>() {
              public void apply(final WorkItemBreifInfo it) {
                Long _id = item.getId();
                it.setId(_id);
                String _sid = item.getSid();
                it.setSid(_sid);
                Date _date = item.getDate();
                it.setTime(_date);
              }
            };
          WorkItemBreifInfo _doubleArrow = ObjectExtensions.<WorkItemBreifInfo>operator_doubleArrow(_workItemBreifInfo, _function);
          return _doubleArrow;
        }
      };
    Iterable<WorkItemBreifInfo> _map = IterableExtensions.<RCWorkItemTask, WorkItemBreifInfo>map(_list, _function_1);
    List<WorkItemBreifInfo> _list_1 = IterableExtensions.<WorkItemBreifInfo>toList(_map);
    return _list_1;
  }
  
  /**
   * 当前未完成的工单数
   */
  public Integer getProcessingCount(final RCEmployee employee) {
    RCProcessingWorkItemTaskCriteria _createQueryCriteria = this.entities.createQueryCriteria(RCProcessingWorkItemTaskCriteria.class);
    final Procedure1<RCProcessingWorkItemTaskCriteria> _function = new Procedure1<RCProcessingWorkItemTaskCriteria>() {
        public void apply(final RCProcessingWorkItemTaskCriteria it) {
          it.setOwner(employee);
        }
      };
    RCProcessingWorkItemTaskCriteria _doubleArrow = ObjectExtensions.<RCProcessingWorkItemTaskCriteria>operator_doubleArrow(_createQueryCriteria, _function);
    Integer _count = _doubleArrow.count();
    return _count;
  }
  
  /**
   * 当前未完成的工单
   */
  public Collection<WorkItemBreifInfo> getProcessingWorkItem(final RCEmployee employee, final Integer startNumber, final Integer endNumber) {
    RCProcessingWorkItemTaskCriteria _createQueryCriteria = this.entities.createQueryCriteria(RCProcessingWorkItemTaskCriteria.class);
    final Procedure1<RCProcessingWorkItemTaskCriteria> _function = new Procedure1<RCProcessingWorkItemTaskCriteria>() {
        public void apply(final RCProcessingWorkItemTaskCriteria it) {
          it.setOwner(employee);
          it.setStart(startNumber);
          int _minus = ((endNumber).intValue() - (startNumber).intValue());
          it.setLimit(Integer.valueOf(_minus));
        }
      };
    RCProcessingWorkItemTaskCriteria _doubleArrow = ObjectExtensions.<RCProcessingWorkItemTaskCriteria>operator_doubleArrow(_createQueryCriteria, _function);
    Collection<RCWorkItemTask> _list = _doubleArrow.list();
    final Function1<RCWorkItemTask,WorkItemBreifInfo> _function_1 = new Function1<RCWorkItemTask,WorkItemBreifInfo>() {
        public WorkItemBreifInfo apply(final RCWorkItemTask item) {
          WorkItemBreifInfo _workItemBreifInfo = new WorkItemBreifInfo();
          final Procedure1<WorkItemBreifInfo> _function = new Procedure1<WorkItemBreifInfo>() {
              public void apply(final WorkItemBreifInfo it) {
                Long _id = item.getId();
                it.setId(_id);
                String _sid = item.getSid();
                it.setSid(_sid);
                Date _date = item.getDate();
                it.setTime(_date);
              }
            };
          WorkItemBreifInfo _doubleArrow = ObjectExtensions.<WorkItemBreifInfo>operator_doubleArrow(_workItemBreifInfo, _function);
          return _doubleArrow;
        }
      };
    Iterable<WorkItemBreifInfo> _map = IterableExtensions.<RCWorkItemTask, WorkItemBreifInfo>map(_list, _function_1);
    List<WorkItemBreifInfo> _list_1 = IterableExtensions.<WorkItemBreifInfo>toList(_map);
    return _list_1;
  }
  
  /**
   * 获取指定状态的工单信息
   */
  public Collection<WorkItemBreifInfo> getWorkItem4Status(final RCEmployee employee, final RCWorkItemTaskStatus status, final Integer startNumber, final Integer endNumber) {
    RCWorkItemTaskCriteria4Status _createQueryCriteria = this.entities.createQueryCriteria(RCWorkItemTaskCriteria4Status.class);
    final Procedure1<RCWorkItemTaskCriteria4Status> _function = new Procedure1<RCWorkItemTaskCriteria4Status>() {
        public void apply(final RCWorkItemTaskCriteria4Status it) {
          it.setOwner(employee);
          it.setStatus(status);
          it.setStart(startNumber);
          int _minus = ((endNumber).intValue() - (startNumber).intValue());
          it.setLimit(Integer.valueOf(_minus));
        }
      };
    RCWorkItemTaskCriteria4Status _doubleArrow = ObjectExtensions.<RCWorkItemTaskCriteria4Status>operator_doubleArrow(_createQueryCriteria, _function);
    Collection<RCWorkItemTask> _list = _doubleArrow.list();
    final Function1<RCWorkItemTask,WorkItemBreifInfo> _function_1 = new Function1<RCWorkItemTask,WorkItemBreifInfo>() {
        public WorkItemBreifInfo apply(final RCWorkItemTask item) {
          WorkItemBreifInfo _workItemBreifInfo = new WorkItemBreifInfo();
          final Procedure1<WorkItemBreifInfo> _function = new Procedure1<WorkItemBreifInfo>() {
              public void apply(final WorkItemBreifInfo it) {
                Long _id = item.getId();
                it.setId(_id);
                String _sid = item.getSid();
                it.setSid(_sid);
                Date _date = item.getDate();
                it.setTime(_date);
              }
            };
          WorkItemBreifInfo _doubleArrow = ObjectExtensions.<WorkItemBreifInfo>operator_doubleArrow(_workItemBreifInfo, _function);
          return _doubleArrow;
        }
      };
    Iterable<WorkItemBreifInfo> _map = IterableExtensions.<RCWorkItemTask, WorkItemBreifInfo>map(_list, _function_1);
    List<WorkItemBreifInfo> _list_1 = IterableExtensions.<WorkItemBreifInfo>toList(_map);
    return _list_1;
  }
  
  /**
   * 获取工单详情
   */
  public WorkItemInfo getWorkItemDetail(final RCWorkItemTask workItem) {
    return null;
  }
  
  /**
   * 提交文件，系统返回一个文件标识
   */
  public String submitPhoto(final Byte[] bytes) {
    return null;
  }
  
  /**
   * 挂起
   */
  public void pend(final RCWorkItemTask workitem, final WorkItemReportInfo info) {
    String _description = info.getDescription();
    workitem.setComment(_description);
    workitem.pend();
  }
  
  /**
   * 结束挂起
   */
  public void cancelPend(final RCWorkItemTask workitem, final WorkItemFinishInfo info) {
  }
  
  /**
   * 需外协
   */
  public void outsource(final RCWorkItemTask workitem, final WorkItemReportInfo info) {
  }
  
  /**
   * 完成外协
   */
  public void finishOutsource(final RCWorkItemTask workitem, final WorkItemFinishInfo info) {
  }
  
  /**
   * 工单串单
   */
  public void misDispatching(final RCWorkItemTask workitem, final WorkItemReportInfo info) {
  }
  
  /**
   * 工单跟进
   */
  public void followup(final RCWorkItemTask workitem, final WorkItemReportInfo info) {
  }
  
  /**
   * 工单完工
   */
  public void finish(final RCWorkItemTask workitem, final WorkItemFinishInfo info) {
  }
  
  /**
   * 获取指定类型的计量设备
   */
  public Collection<MeasureInstrument> getMeasureInstruments(final MeasureInstrumentType type) {
    return null;
  }
  
  /**
   * 提交指定设备的本次读数
   */
  public void submitMeasureResult(final RCMeasureDevice sid, final MeasureValueSubmitInfo info) {
  }
}
