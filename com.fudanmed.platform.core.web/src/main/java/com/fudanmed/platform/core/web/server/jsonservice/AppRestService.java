package com.fudanmed.platform.core.web.server.jsonservice;

import com.fudanmed.platform.core.common.RCSystemParameter;
import com.fudanmed.platform.core.common.RCSystemParameterService;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeUser;
import com.fudanmed.platform.core.domain.RCGroupTask;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCSecurityService;
import com.fudanmed.platform.core.domain.RCTaskDirtyManager;
import com.fudanmed.platform.core.domain.RCWorkItemPicture;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.RCWorkItemTaskStatus;
import com.fudanmed.platform.core.domain.rest.RCFinishedWorkItemTaskCriteria;
import com.fudanmed.platform.core.domain.rest.RCProcessingWorkItemTaskCriteria;
import com.fudanmed.platform.core.domain.rest.RCWorkItemTaskCriteria4Status;
import com.fudanmed.platform.core.measure.RCMeasureDevice;
import com.fudanmed.platform.core.measure.RCMeasureDeviceCriteria;
import com.fudanmed.platform.core.measure.RCMeasureDeviceType;
import com.fudanmed.platform.core.measure.RCMeasureDeviceTypeDAO;
import com.fudanmed.platform.core.measure.RCMeasureValue;
import com.fudanmed.platform.core.web.server.jsonservice.IAppRestService;
import com.fudanmed.platform.core.web.server.jsonservice.JSONUtil;
import com.fudanmed.platform.core.web.server.service.project.WorkItemTaskMapper;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTaskStatus;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import edu.fudan.langlab.domain.security.AppFunction;
import edu.fudan.langlab.domain.security.AppFunctionService;
import edu.fudan.langlab.domain.security.SecurityService;
import edu.fudan.langlab.domain.security.UserRoleAssignment;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IObjectFactory;
import edu.fudan.mylang.utils.DateUtil;
import java.io.File;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@SuppressWarnings("all")
public class AppRestService extends BaseService implements IAppRestService {
  @Autowired
  private RCSecurityService securityService;
  
  @Autowired
  private SecurityService roleService;
  
  @Autowired
  private AppFunctionService appFunctionService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCSystemParameterService systemParameterService;
  
  private File tempDir = new Function0<File>() {
    public File apply() {
      String _property = System.getProperty("java.io.tmpdir");
      File _file = new File(_property);
      return _file;
    }
  }.apply();
  
  public JSONObject login(final String userid, final String passwd) {
    JSONObject _xblockexpression = null;
    {
      final RCEmployeeUser user = this.securityService.employeeUserLogin(userid, passwd);
      JSONObject _xifexpression = null;
      boolean _equals = Objects.equal(user, null);
      if (_equals) {
        JSONObject _fail = JSONUtil.fail("\u65E0\u6548\u7528\u6237\u540D\u6216\u5BC6\u7801");
        _xifexpression = _fail;
      } else {
        JSONObject _xblockexpression_1 = null;
        {
          Collection<UserRoleAssignment> _allRoles4User = this.roleService.getAllRoles4User(userid);
          final Function1<UserRoleAssignment,Collection<AppFunction>> _function = new Function1<UserRoleAssignment,Collection<AppFunction>>() {
              public Collection<AppFunction> apply(final UserRoleAssignment it) {
                String _roleId = it.getRoleId();
                Collection<AppFunction> _loadAllFunctions4Role = AppRestService.this.appFunctionService.loadAllFunctions4Role(_roleId);
                return _loadAllFunctions4Role;
              }
            };
          Iterable<Collection<AppFunction>> _map = IterableExtensions.<UserRoleAssignment, Collection<AppFunction>>map(_allRoles4User, _function);
          Iterable<AppFunction> _flatten = Iterables.<AppFunction>concat(_map);
          Set<AppFunction> _set = IterableExtensions.<AppFunction>toSet(_flatten);
          final Function1<AppFunction,Boolean> _function_1 = new Function1<AppFunction,Boolean>() {
              public Boolean apply(final AppFunction it) {
                boolean _and = false;
                AppFunction _parent = it.getParent();
                boolean _notEquals = (!Objects.equal(_parent, null));
                if (!_notEquals) {
                  _and = false;
                } else {
                  AppFunction _parent_1 = it.getParent();
                  String _functionId = _parent_1.getFunctionId();
                  boolean _equals = "com.fudanmed.platform.core.app".equals(_functionId);
                  _and = (_notEquals && _equals);
                }
                return Boolean.valueOf(_and);
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
          final List<String> roles = IterableExtensions.<String>toList(_map_1);
          final Procedure1<JSONObject> _function_3 = new Procedure1<JSONObject>() {
              public void apply(final JSONObject it) {
                try {
                  JSONObject _put = it.put("sessionid", userid);
                  RCEmployee _employee = user.getEmployee();
                  String _name = _employee.getName();
                  JSONObject _put_1 = _put.put("userName", _name);
                  RCSystemParameter _systemParameter = AppRestService.this.systemParameterService.getSystemParameter();
                  String _orgName = _systemParameter.getOrgName();
                  JSONObject _put_2 = _put_1.put("hospitalName", _orgName);
                  RCEmployee _employee_1 = user.getEmployee();
                  RCOrganization _organization = _employee_1.getOrganization();
                  String _name_1 = _organization.getName();
                  JSONObject _put_3 = _put_2.put("departmentName", _name_1);
                  _put_3.put("roles", roles);
                } catch (Exception _e) {
                  throw Exceptions.sneakyThrow(_e);
                }
              }
            };
          JSONObject _success = JSONUtil.success(_function_3);
          _xblockexpression_1 = (_success);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public JSONObject modifyPasswd(final String userid, final String oldPasswd, final String newPasswd) {
    JSONObject _xblockexpression = null;
    {
      final RCEmployeeUser user = this.securityService.employeeUserLogin(userid, oldPasswd);
      JSONObject _xifexpression = null;
      boolean _notEquals = (!Objects.equal(user, null));
      if (_notEquals) {
        JSONObject _xblockexpression_1 = null;
        {
          user.setPasswd(newPasswd);
          final Procedure1<JSONObject> _function = new Procedure1<JSONObject>() {
              public void apply(final JSONObject it) {
              }
            };
          JSONObject _success = JSONUtil.success(_function);
          _xblockexpression_1 = (_success);
        }
        _xifexpression = _xblockexpression_1;
      } else {
        JSONObject _fail = JSONUtil.fail("\u65E0\u6548\u7528\u6237\u540D\u6216\u5BC6\u7801");
        _xifexpression = _fail;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public RCWorkItemTaskStatus toWorkItemTaskStatus(final String status) {
    RCWorkItemTaskStatus _valueOf = RCWorkItemTaskStatus.valueOf(status);
    return _valueOf;
  }
  
  public JSONObject getFinishedCount(final String userid, final String startDate, final String endDate) {
    final Procedure1<JSONObject> _function = new Procedure1<JSONObject>() {
        public void apply(final JSONObject it) {
          try {
            RCFinishedWorkItemTaskCriteria _createQueryCriteria = AppRestService.this.entities.createQueryCriteria(RCFinishedWorkItemTaskCriteria.class);
            final Procedure1<RCFinishedWorkItemTaskCriteria> _function = new Procedure1<RCFinishedWorkItemTaskCriteria>() {
                public void apply(final RCFinishedWorkItemTaskCriteria it) {
                  RCEmployeeUser _asEmployeeUser = AppRestService.this.securityService.asEmployeeUser(userid);
                  RCEmployee _employee = _asEmployeeUser.getEmployee();
                  it.setOwner(_employee);
                  Date _date = JSONUtil.toDate(startDate);
                  it.setStartDate(_date);
                  Date _date_1 = JSONUtil.toDate(endDate);
                  it.setEndDate(_date_1);
                }
              };
            RCFinishedWorkItemTaskCriteria _doubleArrow = ObjectExtensions.<RCFinishedWorkItemTaskCriteria>operator_doubleArrow(_createQueryCriteria, _function);
            Integer _count = _doubleArrow.count();
            it.put("count", _count);
          } catch (Exception _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
    JSONObject _success = JSONUtil.success(_function);
    return _success;
  }
  
  @Autowired
  private WorkItemTaskMapper workitemTaskMapper;
  
  @Autowired
  private RCTaskDirtyManager taskDirtyManager;
  
  public JSONObject getFinishedWorkItems(final String userid, final String startDate, final String endDate, final String startNumber, final String endNumber) {
    JSONObject _xblockexpression = null;
    {
      RCFinishedWorkItemTaskCriteria _createQueryCriteria = this.entities.createQueryCriteria(RCFinishedWorkItemTaskCriteria.class);
      final Procedure1<RCFinishedWorkItemTaskCriteria> _function = new Procedure1<RCFinishedWorkItemTaskCriteria>() {
          public void apply(final RCFinishedWorkItemTaskCriteria it) {
            RCEmployeeUser _asEmployeeUser = AppRestService.this.securityService.asEmployeeUser(userid);
            RCEmployee _employee = _asEmployeeUser.getEmployee();
            it.setOwner(_employee);
            Date _date = JSONUtil.toDate(startDate);
            it.setStartDate(_date);
            Date _date_1 = JSONUtil.toDate(endDate);
            it.setEndDate(_date_1);
            Integer _integer = JSONUtil.toInteger(startNumber);
            it.setStart(_integer);
            Integer _integer_1 = JSONUtil.toInteger(endNumber);
            Integer _start = it.getStart();
            int _minus = ((_integer_1).intValue() - (_start).intValue());
            int _plus = (_minus + 1);
            it.setLimit(Integer.valueOf(_plus));
          }
        };
      RCFinishedWorkItemTaskCriteria _doubleArrow = ObjectExtensions.<RCFinishedWorkItemTaskCriteria>operator_doubleArrow(_createQueryCriteria, _function);
      Collection<RCWorkItemTask> _list = _doubleArrow.list();
      final Function1<RCWorkItemTask,JSONObject> _function_1 = new Function1<RCWorkItemTask,JSONObject>() {
          public JSONObject apply(final RCWorkItemTask item) {
            JSONObject _xblockexpression = null;
            {
              final UIWorkItemTask workitem = AppRestService.this.workitemTaskMapper.transform(item);
              JSONObject _jSONObject = new JSONObject();
              final Procedure1<JSONObject> _function = new Procedure1<JSONObject>() {
                  public void apply(final JSONObject it) {
                    try {
                      Long _id = workitem.getId();
                      it.put("id", _id);
                      String _sid = workitem.getSid();
                      it.put("sid", _sid);
                      RCGroupTask _groupTask = item.getGroupTask();
                      RCRepairTask _repairTask = _groupTask.getRepairTask();
                      RCOrganization _reportOrg = _repairTask.getReportOrg();
                      String _entityName = _reportOrg.getEntityName();
                      it.put("department", _entityName);
                      RCGroupTask _groupTask_1 = item.getGroupTask();
                      RCRepairTask _repairTask_1 = _groupTask_1.getRepairTask();
                      String _comment = _repairTask_1.getComment();
                      it.put("comment", _comment);
                      UIWorkItemTaskStatus _status = workitem.getStatus();
                      String _string = _status.toString();
                      it.put("status", _string);
                      Date _time = workitem.getTime();
                      String _dateTimeString = JSONUtil.toDateTimeString(_time);
                      it.put("time", _dateTimeString);
                      RCGroupTask _groupTask_2 = item.getGroupTask();
                      RCRepairTask _repairTask_2 = _groupTask_2.getRepairTask();
                      Date _reportTime = _repairTask_2.getReportTime();
                      String _dateTimeString_1 = JSONUtil.toDateTimeString(_reportTime);
                      it.put("reportTime", _dateTimeString_1);
                      Date _finishTime = item.getFinishTime();
                      String _dateTimeString_2 = JSONUtil.toDateTimeString(_finishTime);
                      it.put("finishTime", _dateTimeString_2);
                    } catch (Exception _e) {
                      throw Exceptions.sneakyThrow(_e);
                    }
                  }
                };
              JSONObject _doubleArrow = ObjectExtensions.<JSONObject>operator_doubleArrow(_jSONObject, _function);
              _xblockexpression = (_doubleArrow);
            }
            return _xblockexpression;
          }
        };
      final Iterable<JSONObject> datas = IterableExtensions.<RCWorkItemTask, JSONObject>map(_list, _function_1);
      List<JSONObject> _list_1 = IterableExtensions.<JSONObject>toList(datas);
      JSONObject _success = JSONUtil.success(_list_1);
      _xblockexpression = (_success);
    }
    return _xblockexpression;
  }
  
  public JSONObject getProcessingCount(final String userid) {
    final Procedure1<JSONObject> _function = new Procedure1<JSONObject>() {
        public void apply(final JSONObject it) {
          try {
            RCProcessingWorkItemTaskCriteria _createQueryCriteria = AppRestService.this.entities.createQueryCriteria(RCProcessingWorkItemTaskCriteria.class);
            final Procedure1<RCProcessingWorkItemTaskCriteria> _function = new Procedure1<RCProcessingWorkItemTaskCriteria>() {
                public void apply(final RCProcessingWorkItemTaskCriteria it) {
                  RCEmployeeUser _asEmployeeUser = AppRestService.this.securityService.asEmployeeUser(userid);
                  RCEmployee _employee = _asEmployeeUser.getEmployee();
                  it.setOwner(_employee);
                }
              };
            RCProcessingWorkItemTaskCriteria _doubleArrow = ObjectExtensions.<RCProcessingWorkItemTaskCriteria>operator_doubleArrow(_createQueryCriteria, _function);
            Integer _count = _doubleArrow.count();
            it.put("count", _count);
          } catch (Exception _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
    JSONObject _success = JSONUtil.success(_function);
    return _success;
  }
  
  public JSONObject getProcessingWorkItems(final String userid, final String startNumber, final String endNumber) {
    JSONObject _xblockexpression = null;
    {
      RCProcessingWorkItemTaskCriteria _createQueryCriteria = this.entities.createQueryCriteria(RCProcessingWorkItemTaskCriteria.class);
      final Procedure1<RCProcessingWorkItemTaskCriteria> _function = new Procedure1<RCProcessingWorkItemTaskCriteria>() {
          public void apply(final RCProcessingWorkItemTaskCriteria it) {
            RCEmployeeUser _asEmployeeUser = AppRestService.this.securityService.asEmployeeUser(userid);
            RCEmployee _employee = _asEmployeeUser.getEmployee();
            it.setOwner(_employee);
            Integer _integer = JSONUtil.toInteger(startNumber);
            it.setStart(_integer);
            Integer _integer_1 = JSONUtil.toInteger(endNumber);
            Integer _integer_2 = JSONUtil.toInteger(startNumber);
            int _minus = ((_integer_1).intValue() - (_integer_2).intValue());
            it.setLimit(Integer.valueOf(_minus));
          }
        };
      RCProcessingWorkItemTaskCriteria _doubleArrow = ObjectExtensions.<RCProcessingWorkItemTaskCriteria>operator_doubleArrow(_createQueryCriteria, _function);
      Collection<RCWorkItemTask> _list = _doubleArrow.list();
      final Function1<RCWorkItemTask,JSONObject> _function_1 = new Function1<RCWorkItemTask,JSONObject>() {
          public JSONObject apply(final RCWorkItemTask item) {
            JSONObject _xblockexpression = null;
            {
              final UIWorkItemTask workitem = AppRestService.this.workitemTaskMapper.transform(item);
              JSONObject _jSONObject = new JSONObject();
              final Procedure1<JSONObject> _function = new Procedure1<JSONObject>() {
                  public void apply(final JSONObject it) {
                    try {
                      Long _id = workitem.getId();
                      it.put("id", _id);
                      String _sid = workitem.getSid();
                      it.put("sid", _sid);
                      RCGroupTask _groupTask = item.getGroupTask();
                      RCRepairTask _repairTask = _groupTask.getRepairTask();
                      RCOrganization _reportOrg = _repairTask.getReportOrg();
                      String _entityName = _reportOrg.getEntityName();
                      it.put("department", _entityName);
                      RCGroupTask _groupTask_1 = item.getGroupTask();
                      RCRepairTask _repairTask_1 = _groupTask_1.getRepairTask();
                      String _comment = _repairTask_1.getComment();
                      it.put("comment", _comment);
                      UIWorkItemTaskStatus _status = workitem.getStatus();
                      String _string = _status.toString();
                      it.put("status", _string);
                      Date _time = workitem.getTime();
                      String _dateTimeString = JSONUtil.toDateTimeString(_time);
                      it.put("time", _dateTimeString);
                      RCGroupTask _groupTask_2 = item.getGroupTask();
                      RCRepairTask _repairTask_2 = _groupTask_2.getRepairTask();
                      Date _reportTime = _repairTask_2.getReportTime();
                      String _dateTimeString_1 = JSONUtil.toDateTimeString(_reportTime);
                      it.put("reportTime", _dateTimeString_1);
                      Date _finishTime = item.getFinishTime();
                      String _dateTimeString_2 = JSONUtil.toDateTimeString(_finishTime);
                      it.put("finishTime", _dateTimeString_2);
                    } catch (Exception _e) {
                      throw Exceptions.sneakyThrow(_e);
                    }
                  }
                };
              JSONObject _doubleArrow = ObjectExtensions.<JSONObject>operator_doubleArrow(_jSONObject, _function);
              _xblockexpression = (_doubleArrow);
            }
            return _xblockexpression;
          }
        };
      final Iterable<JSONObject> datas = IterableExtensions.<RCWorkItemTask, JSONObject>map(_list, _function_1);
      List<JSONObject> _list_1 = IterableExtensions.<JSONObject>toList(datas);
      JSONObject _success = JSONUtil.success(_list_1);
      _xblockexpression = (_success);
    }
    return _xblockexpression;
  }
  
  public JSONObject getWorkItem4Status(final String userid, final String startNumber, final String endNumber, final String fromDate, final String toDate, final String status) {
    JSONObject _xblockexpression = null;
    {
      RCWorkItemTaskCriteria4Status _createQueryCriteria = this.entities.createQueryCriteria(RCWorkItemTaskCriteria4Status.class);
      final Procedure1<RCWorkItemTaskCriteria4Status> _function = new Procedure1<RCWorkItemTaskCriteria4Status>() {
          public void apply(final RCWorkItemTaskCriteria4Status it) {
            RCEmployeeUser _asEmployeeUser = AppRestService.this.securityService.asEmployeeUser(userid);
            RCEmployee _employee = _asEmployeeUser.getEmployee();
            it.setOwner(_employee);
            RCWorkItemTaskStatus _workItemTaskStatus = AppRestService.this.toWorkItemTaskStatus(status);
            it.setStatus(_workItemTaskStatus);
            Integer _integer = JSONUtil.toInteger(startNumber);
            it.setStart(_integer);
            Date _date = JSONUtil.toDate(fromDate);
            it.setFromDate(_date);
            Date _date_1 = JSONUtil.toDate(toDate);
            it.setToDate(_date_1);
            Integer _integer_1 = JSONUtil.toInteger(endNumber);
            Integer _integer_2 = JSONUtil.toInteger(startNumber);
            int _minus = ((_integer_1).intValue() - (_integer_2).intValue());
            it.setLimit(Integer.valueOf(_minus));
          }
        };
      RCWorkItemTaskCriteria4Status _doubleArrow = ObjectExtensions.<RCWorkItemTaskCriteria4Status>operator_doubleArrow(_createQueryCriteria, _function);
      Collection<RCWorkItemTask> _list = _doubleArrow.list();
      final Function1<RCWorkItemTask,JSONObject> _function_1 = new Function1<RCWorkItemTask,JSONObject>() {
          public JSONObject apply(final RCWorkItemTask item) {
            JSONObject _xblockexpression = null;
            {
              final UIWorkItemTask workitem = AppRestService.this.workitemTaskMapper.transform(item);
              JSONObject _jSONObject = new JSONObject();
              final Procedure1<JSONObject> _function = new Procedure1<JSONObject>() {
                  public void apply(final JSONObject it) {
                    try {
                      Long _id = workitem.getId();
                      it.put("id", _id);
                      String _sid = workitem.getSid();
                      it.put("sid", _sid);
                      RCGroupTask _groupTask = item.getGroupTask();
                      RCRepairTask _repairTask = _groupTask.getRepairTask();
                      RCOrganization _reportOrg = _repairTask.getReportOrg();
                      String _entityName = _reportOrg.getEntityName();
                      it.put("department", _entityName);
                      RCGroupTask _groupTask_1 = item.getGroupTask();
                      RCRepairTask _repairTask_1 = _groupTask_1.getRepairTask();
                      String _comment = _repairTask_1.getComment();
                      it.put("comment", _comment);
                      UIWorkItemTaskStatus _status = workitem.getStatus();
                      String _string = _status.toString();
                      it.put("status", _string);
                      Date _time = workitem.getTime();
                      String _dateTimeString = JSONUtil.toDateTimeString(_time);
                      it.put("time", _dateTimeString);
                      RCGroupTask _groupTask_2 = item.getGroupTask();
                      RCRepairTask _repairTask_2 = _groupTask_2.getRepairTask();
                      Date _reportTime = _repairTask_2.getReportTime();
                      String _dateTimeString_1 = JSONUtil.toDateTimeString(_reportTime);
                      it.put("reportTime", _dateTimeString_1);
                      Date _finishTime = item.getFinishTime();
                      String _dateTimeString_2 = JSONUtil.toDateTimeString(_finishTime);
                      it.put("finishTime", _dateTimeString_2);
                    } catch (Exception _e) {
                      throw Exceptions.sneakyThrow(_e);
                    }
                  }
                };
              JSONObject _doubleArrow = ObjectExtensions.<JSONObject>operator_doubleArrow(_jSONObject, _function);
              _xblockexpression = (_doubleArrow);
            }
            return _xblockexpression;
          }
        };
      final Iterable<JSONObject> datas = IterableExtensions.<RCWorkItemTask, JSONObject>map(_list, _function_1);
      List<JSONObject> _list_1 = IterableExtensions.<JSONObject>toList(datas);
      JSONObject _success = JSONUtil.success(_list_1);
      _xblockexpression = (_success);
    }
    return _xblockexpression;
  }
  
  public JSONObject getWorkItemDetail(final String workitemId) {
    JSONObject _xblockexpression = null;
    {
      Long _long = JSONUtil.toLong(workitemId);
      final RCWorkItemTask workitem = this.entities.<RCWorkItemTask>get(RCWorkItemTask.class, _long);
      Long _long_1 = JSONUtil.toLong(workitemId);
      RCWorkItemTask _get = this.entities.<RCWorkItemTask>get(RCWorkItemTask.class, _long_1);
      final UIWorkItemTask tWorkitem = this.workitemTaskMapper.transform(_get);
      final Procedure1<JSONObject> _function = new Procedure1<JSONObject>() {
          public void apply(final JSONObject it) {
            try {
              Long _id = workitem.getId();
              JSONObject _put = it.put("id", _id);
              String _sid = workitem.getSid();
              JSONObject _put_1 = _put.put("sid", _sid);
              RCGroupTask _groupTask = workitem.getGroupTask();
              RCRepairTask _repairTask = _groupTask.getRepairTask();
              String _reportSid = _repairTask.getReportSid();
              JSONObject _put_2 = _put_1.put("reportSid", _reportSid);
              UIWorkItemTaskStatus _status = tWorkitem.getStatus();
              String _string = _status.toString();
              JSONObject _put_3 = _put_2.put("status", _string);
              RCGroupTask _groupTask_1 = workitem.getGroupTask();
              RCRepairTask _repairTask_1 = _groupTask_1.getRepairTask();
              Date _reportTime = _repairTask_1.getReportTime();
              String _dateTimeString = JSONUtil.toDateTimeString(_reportTime);
              JSONObject _put_4 = _put_3.put("reportTime", _dateTimeString);
              Date _finishTime = workitem.getFinishTime();
              String _dateTimeString_1 = JSONUtil.toDateTimeString(_finishTime);
              JSONObject _put_5 = _put_4.put("finishTime", _dateTimeString_1);
              Date _time = workitem.getTime();
              String _dateTimeString_2 = JSONUtil.toDateTimeString(_time);
              JSONObject _put_6 = _put_5.put("time", _dateTimeString_2);
              Collection<RCEmployee> _workers = workitem.getWorkers();
              final Function1<RCEmployee,String> _function = new Function1<RCEmployee,String>() {
                  public String apply(final RCEmployee it) {
                    String _name = it.getName();
                    return _name;
                  }
                };
              Iterable<String> _map = IterableExtensions.<RCEmployee, String>map(_workers, _function);
              String _join = IterableExtensions.join(_map, ",");
              JSONObject _put_7 = _put_6.put("workers", _join);
              RCGroupTask _groupTask_2 = workitem.getGroupTask();
              RCRepairTask _repairTask_2 = _groupTask_2.getRepairTask();
              String _comment = _repairTask_2.getComment();
              JSONObject _put_8 = _put_7.put("comment", _comment);
              RCGroupTask _groupTask_3 = workitem.getGroupTask();
              RCRepairTask _repairTask_3 = _groupTask_3.getRepairTask();
              String _location = _repairTask_3.getLocation();
              JSONObject _put_9 = _put_8.put("location", _location);
              RCGroupTask _groupTask_4 = workitem.getGroupTask();
              RCRepairTask _repairTask_4 = _groupTask_4.getRepairTask();
              RCOrganization _reportOrg = _repairTask_4.getReportOrg();
              String _entityName = _reportOrg.getEntityName();
              JSONObject _put_10 = _put_9.put("organization", _entityName);
              RCGroupTask _groupTask_5 = workitem.getGroupTask();
              RCRepairTask _repairTask_5 = _groupTask_5.getRepairTask();
              String _reporterName = _repairTask_5.getReporterName();
              JSONObject _put_11 = _put_10.put("reporter", _reporterName);
              RCGroupTask _groupTask_6 = workitem.getGroupTask();
              RCRepairTask _repairTask_6 = _groupTask_6.getRepairTask();
              String _reporterPhone = _repairTask_6.getReporterPhone();
              _put_11.put("reporterPhone", _reporterPhone);
            } catch (Exception _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          }
        };
      JSONObject _success = JSONUtil.success(_function);
      _xblockexpression = (_success);
    }
    return _xblockexpression;
  }
  
  public JSONObject pendWorkItem(final String workitemId, final String comment) {
    JSONObject _xblockexpression = null;
    {
      Long _long = JSONUtil.toLong(workitemId);
      final RCWorkItemTask workitem = this.entities.<RCWorkItemTask>get(RCWorkItemTask.class, _long);
      workitem.setComment(comment);
      workitem.pend();
      final Procedure1<JSONObject> _function = new Procedure1<JSONObject>() {
          public void apply(final JSONObject it) {
          }
        };
      JSONObject _success = JSONUtil.success(_function);
      _xblockexpression = (_success);
    }
    return _xblockexpression;
  }
  
  public JSONObject cancelPendWorkItem(final String workitemId, final String desciption, final String reportTime, final String deviceNumber, final String[] photoIds) {
    JSONObject _xblockexpression = null;
    {
      Long _long = JSONUtil.toLong(workitemId);
      final RCWorkItemTask workitem = this.entities.<RCWorkItemTask>get(RCWorkItemTask.class, _long);
      workitem.setComment(desciption);
      Date _time = JSONUtil.toTime(reportTime);
      workitem.setFinishTime(_time);
      Date _finishTime = workitem.getFinishTime();
      Date _trimDate = DateUtil.trimDate(_finishTime);
      workitem.setFinishDate(_trimDate);
      workitem.cancelPend();
      RCGroupTask _groupTask = workitem.getGroupTask();
      Boolean _allTasksFinishedExcept = _groupTask.allTasksFinishedExcept(workitem);
      if ((_allTasksFinishedExcept).booleanValue()) {
        RCGroupTask _groupTask_1 = workitem.getGroupTask();
        RCMaintenanceTeam _team = _groupTask_1.getTeam();
        this.taskDirtyManager.notifyTeam(_team);
      }
      final Procedure1<JSONObject> _function = new Procedure1<JSONObject>() {
          public void apply(final JSONObject it) {
          }
        };
      JSONObject _success = JSONUtil.success(_function);
      _xblockexpression = (_success);
    }
    return _xblockexpression;
  }
  
  public JSONObject outsourceWorkItem(final String workitemId, final String comment) {
    JSONObject _xblockexpression = null;
    {
      Long _long = JSONUtil.toLong(workitemId);
      final RCWorkItemTask workitem = this.entities.<RCWorkItemTask>get(RCWorkItemTask.class, _long);
      workitem.setComment(comment);
      workitem.outsource();
      final Procedure1<JSONObject> _function = new Procedure1<JSONObject>() {
          public void apply(final JSONObject it) {
          }
        };
      JSONObject _success = JSONUtil.success(_function);
      _xblockexpression = (_success);
    }
    return _xblockexpression;
  }
  
  public JSONObject finishOutsourceWorkItem(final String workitemId, final String desciption, final String reportTime, final String deviceNumber, final String[] photoIds) {
    JSONObject _xblockexpression = null;
    {
      Long _long = JSONUtil.toLong(workitemId);
      final RCWorkItemTask workitem = this.entities.<RCWorkItemTask>get(RCWorkItemTask.class, _long);
      workitem.setComment(desciption);
      Date _time = JSONUtil.toTime(reportTime);
      workitem.setFinishTime(_time);
      Date _finishTime = workitem.getFinishTime();
      Date _trimDate = DateUtil.trimDate(_finishTime);
      workitem.setFinishDate(_trimDate);
      workitem.finishOutsource();
      RCGroupTask _groupTask = workitem.getGroupTask();
      Boolean _allTasksFinishedExcept = _groupTask.allTasksFinishedExcept(workitem);
      if ((_allTasksFinishedExcept).booleanValue()) {
        RCGroupTask _groupTask_1 = workitem.getGroupTask();
        RCMaintenanceTeam _team = _groupTask_1.getTeam();
        this.taskDirtyManager.notifyTeam(_team);
      }
      final Procedure1<JSONObject> _function = new Procedure1<JSONObject>() {
          public void apply(final JSONObject it) {
          }
        };
      JSONObject _success = JSONUtil.success(_function);
      _xblockexpression = (_success);
    }
    return _xblockexpression;
  }
  
  public JSONObject finishWorkItem(final String workitemId, final String desciption, final String reportTime, final String deviceNumber, final String[] photoIds) {
    JSONObject _xblockexpression = null;
    {
      Long _long = JSONUtil.toLong(workitemId);
      final RCWorkItemTask workitem = this.entities.<RCWorkItemTask>get(RCWorkItemTask.class, _long);
      workitem.setComment(desciption);
      Date _time = JSONUtil.toTime(reportTime);
      workitem.setFinishTime(_time);
      Date _finishTime = workitem.getFinishTime();
      Date _trimDate = DateUtil.trimDate(_finishTime);
      workitem.setFinishDate(_trimDate);
      workitem.finish();
      RCGroupTask _groupTask = workitem.getGroupTask();
      Boolean _allTasksFinishedExcept = _groupTask.allTasksFinishedExcept(workitem);
      if ((_allTasksFinishedExcept).booleanValue()) {
        RCGroupTask _groupTask_1 = workitem.getGroupTask();
        RCMaintenanceTeam _team = _groupTask_1.getTeam();
        this.taskDirtyManager.notifyTeam(_team);
      }
      String _plus = ("submit finish workitem:" + photoIds);
      InputOutput.<String>println(_plus);
      boolean _notEquals = (!Objects.equal(photoIds, null));
      if (_notEquals) {
        final Procedure1<String> _function = new Procedure1<String>() {
            public void apply(final String photoId) {
              String _plus = ("photoId:" + photoId);
              InputOutput.<String>println(_plus);
              RCWorkItemPicture _createAndAddtoDocuments = workitem.createAndAddtoDocuments();
              final Procedure1<RCWorkItemPicture> _function = new Procedure1<RCWorkItemPicture>() {
                  public void apply(final RCWorkItemPicture it) {
                    String _sid = workitem.getSid();
                    it.setName(_sid);
                    it.setFileName(photoId);
                    File _file = new File(AppRestService.this.tempDir, photoId);
                    it.setFile(_file);
                  }
                };
              ObjectExtensions.<RCWorkItemPicture>operator_doubleArrow(_createAndAddtoDocuments, _function);
            }
          };
        IterableExtensions.<String>forEach(((Iterable<String>)Conversions.doWrapArray(photoIds)), _function);
      }
      final Procedure1<JSONObject> _function_1 = new Procedure1<JSONObject>() {
          public void apply(final JSONObject it) {
          }
        };
      JSONObject _success = JSONUtil.success(_function_1);
      _xblockexpression = (_success);
    }
    return _xblockexpression;
  }
  
  public JSONObject followupWorkItem(final String workitemId, final String desciption, final String reportTime) {
    JSONObject _xblockexpression = null;
    {
      Long _long = JSONUtil.toLong(workitemId);
      final RCWorkItemTask workitem = this.entities.<RCWorkItemTask>get(RCWorkItemTask.class, _long);
      workitem.setComment(desciption);
      workitem.followup();
      final Procedure1<JSONObject> _function = new Procedure1<JSONObject>() {
          public void apply(final JSONObject it) {
          }
        };
      JSONObject _success = JSONUtil.success(_function);
      _xblockexpression = (_success);
    }
    return _xblockexpression;
  }
  
  public JSONObject misdispatchWorkItem(final String workitemId, final String desciption, final String reportTime) {
    JSONObject _xblockexpression = null;
    {
      Long _long = JSONUtil.toLong(workitemId);
      final RCWorkItemTask workitem = this.entities.<RCWorkItemTask>get(RCWorkItemTask.class, _long);
      workitem.setComment(desciption);
      Date _time = JSONUtil.toTime(reportTime);
      workitem.setFinishTime(_time);
      Date _finishTime = workitem.getFinishTime();
      Date _trimDate = DateUtil.trimDate(_finishTime);
      workitem.setFinishDate(_trimDate);
      workitem.misDispatching();
      RCGroupTask _groupTask = workitem.getGroupTask();
      Boolean _allTasksFinishedExcept = _groupTask.allTasksFinishedExcept(workitem);
      if ((_allTasksFinishedExcept).booleanValue()) {
        RCGroupTask _groupTask_1 = workitem.getGroupTask();
        RCMaintenanceTeam _team = _groupTask_1.getTeam();
        this.taskDirtyManager.notifyTeam(_team);
      }
      final Procedure1<JSONObject> _function = new Procedure1<JSONObject>() {
          public void apply(final JSONObject it) {
          }
        };
      JSONObject _success = JSONUtil.success(_function);
      _xblockexpression = (_success);
    }
    return _xblockexpression;
  }
  
  @Autowired
  private RCMeasureDeviceTypeDAO deviceTypeDAO;
  
  public JSONObject getMeasureDeviceList(final String deviceType, final String startNumber, final String endNumber, final String deviceSid) {
    JSONObject _xblockexpression = null;
    {
      RCMeasureDeviceCriteria _createQueryCriteria = this.entities.createQueryCriteria(RCMeasureDeviceCriteria.class);
      final Procedure1<RCMeasureDeviceCriteria> _function = new Procedure1<RCMeasureDeviceCriteria>() {
          public void apply(final RCMeasureDeviceCriteria it) {
            String _switchResult = null;
            boolean _matched = false;
            if (!_matched) {
              if (Objects.equal(deviceType,"1")) {
                _matched=true;
                _switchResult = "\u6C34\u8868";
              }
            }
            if (!_matched) {
              if (Objects.equal(deviceType,"2")) {
                _matched=true;
                _switchResult = "\u7535\u8868";
              }
            }
            if (!_matched) {
              if (Objects.equal(deviceType,"3")) {
                _matched=true;
                _switchResult = "\u6C14\u8868";
              }
            }
            if (!_matched) {
              if (Objects.equal(deviceType,"4")) {
                _matched=true;
                _switchResult = "\u5CF0\u8C37\u7535\u8868";
              }
            }
            if (!_matched) {
              _switchResult = "INVALID";
            }
            final String dt = _switchResult;
            RCMeasureDeviceType _findByName = AppRestService.this.deviceTypeDAO.findByName(dt);
            it.setType(_findByName);
            boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(deviceSid);
            boolean _not = (!_isNullOrEmpty);
            if (_not) {
              it.setSid(deviceSid);
            }
            Integer _integer = JSONUtil.toInteger(startNumber);
            it.setStart(_integer);
            Integer _integer_1 = JSONUtil.toInteger(endNumber);
            Integer _integer_2 = JSONUtil.toInteger(startNumber);
            int _minus = ((_integer_1).intValue() - (_integer_2).intValue());
            it.setLimit(Integer.valueOf(_minus));
          }
        };
      RCMeasureDeviceCriteria _doubleArrow = ObjectExtensions.<RCMeasureDeviceCriteria>operator_doubleArrow(_createQueryCriteria, _function);
      Collection<RCMeasureDevice> _list = _doubleArrow.list();
      final Function1<RCMeasureDevice,JSONObject> _function_1 = new Function1<RCMeasureDevice,JSONObject>() {
          public JSONObject apply(final RCMeasureDevice item) {
            JSONObject _jSONObject = new JSONObject();
            final Procedure1<JSONObject> _function = new Procedure1<JSONObject>() {
                public void apply(final JSONObject it) {
                  try {
                    Long _id = item.getId();
                    it.put("id", _id);
                    String _sid = item.getSid();
                    it.put("sid", _sid);
                    String _name = item.getName();
                    it.put("name", _name);
                    int _switchResult = (int) 0;
                    RCMeasureDeviceType _deviceType = item.getDeviceType();
                    String _name_1 = _deviceType.getName();
                    final String _switchValue = _name_1;
                    boolean _matched = false;
                    if (!_matched) {
                      if (Objects.equal(_switchValue,"\u6C34\u8868")) {
                        _matched=true;
                        _switchResult = 1;
                      }
                    }
                    if (!_matched) {
                      if (Objects.equal(_switchValue,"\u7535\u8868")) {
                        _matched=true;
                        _switchResult = 2;
                      }
                    }
                    if (!_matched) {
                      if (Objects.equal(_switchValue,"\u6C14\u8868")) {
                        _matched=true;
                        _switchResult = 3;
                      }
                    }
                    if (!_matched) {
                      if (Objects.equal(_switchValue,"\u5CF0\u8C37\u7535\u8868")) {
                        _matched=true;
                        _switchResult = 4;
                      }
                    }
                    if (!_matched) {
                      _switchResult = 0;
                    }
                    final int dtype = _switchResult;
                    it.put("deviceType", dtype);
                    RCMeasureValue _lastValue = item.getLastValue();
                    boolean _notEquals = (!Objects.equal(_lastValue, null));
                    if (_notEquals) {
                      RCMeasureValue _lastValue_1 = item.getLastValue();
                      Date _measureDate = _lastValue_1.getMeasureDate();
                      String _dateTimeString = JSONUtil.toDateTimeString(_measureDate);
                      it.put("lastDate", _dateTimeString);
                      RCMeasureValue _lastValue_2 = item.getLastValue();
                      Collection<Double> _serializeValues = _lastValue_2.serializeValues();
                      it.put("lastValue", _serializeValues);
                    }
                  } catch (Exception _e) {
                    throw Exceptions.sneakyThrow(_e);
                  }
                }
              };
            JSONObject _doubleArrow = ObjectExtensions.<JSONObject>operator_doubleArrow(_jSONObject, _function);
            return _doubleArrow;
          }
        };
      final Iterable<JSONObject> datas = IterableExtensions.<RCMeasureDevice, JSONObject>map(_list, _function_1);
      List<JSONObject> _list_1 = IterableExtensions.<JSONObject>toList(datas);
      JSONObject _success = JSONUtil.success(_list_1);
      _xblockexpression = (_success);
    }
    return _xblockexpression;
  }
  
  public JSONObject submitMeasureResult(final String userid, final String id, final Collection<String> values, final String date) {
    JSONObject _xblockexpression = null;
    {
      Long _long = JSONUtil.toLong(id);
      final RCMeasureDevice device = this.entities.<RCMeasureDevice>get(RCMeasureDevice.class, _long);
      Date _time = JSONUtil.toTime(date);
      RCEmployeeUser _asEmployeeUser = this.securityService.asEmployeeUser(userid);
      RCEmployee _employee = _asEmployeeUser.getEmployee();
      String _entityName = _employee.getEntityName();
      RCMeasureValue _createValue = device.createValue(_time, _entityName);
      final Procedure1<RCMeasureValue> _function = new Procedure1<RCMeasureValue>() {
          public void apply(final RCMeasureValue it) {
            final Function1<String,Double> _function = new Function1<String,Double>() {
                public Double apply(final String it) {
                  Double _double = JSONUtil.toDouble(it);
                  return _double;
                }
              };
            Iterable<Double> _map = IterableExtensions.<String, Double>map(values, _function);
            List<Double> _list = IterableExtensions.<Double>toList(_map);
            it.deserializeValues(_list);
          }
        };
      ObjectExtensions.<RCMeasureValue>operator_doubleArrow(_createValue, _function);
      final Procedure1<JSONObject> _function_1 = new Procedure1<JSONObject>() {
          public void apply(final JSONObject it) {
          }
        };
      JSONObject _success = JSONUtil.success(_function_1);
      _xblockexpression = (_success);
    }
    return _xblockexpression;
  }
}
