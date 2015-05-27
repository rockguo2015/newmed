package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.common.RCFaultLevel;
import com.fudanmed.platform.core.common.RCFaultLevelColorAdaptor;
import com.fudanmed.platform.core.common.RCFaultReportSource;
import com.fudanmed.platform.core.common.RCStandardColor;
import com.fudanmed.platform.core.common.impl.RCFaultLevelColorAdaptorImpl;
import com.fudanmed.platform.core.common.impl.RCFaultReportSourceImpl;
import com.fudanmed.platform.core.device.pm.RCDevicePMType;
import com.fudanmed.platform.core.device.pm.impl.RCDevicePMTypeImpl;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeStatus;
import com.fudanmed.platform.core.domain.RCEmployeeUser;
import com.fudanmed.platform.core.domain.RCFaultType;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.warehouse.RCProductType;
import com.google.common.base.Objects;
import edu.fudan.langlab.domain.security.AppFunction;
import edu.fudan.langlab.domain.security.UserRoleAssignment;
import edu.fudan.langlab.domain.security.impl.AppFunctionImpl;
import edu.fudan.langlab.domain.security.impl.UserRoleAssignmentImpl;
import edu.fudan.langlab.domain.updater.IUpgrader;
import edu.fudan.langlab.domain.updater.UpdateServie;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IGenericQuery;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("V_0_3_upgrade")
public class V_0_3_upgrade extends BaseService implements IUpgrader {
  public void devicePMTypes() {RCDevicePMType rCDevicePMType=RCDevicePMTypeImpl.create(getObjectFactory());
    final Procedure1<RCDevicePMType> _function = new Procedure1<RCDevicePMType>() {
        public void apply(final RCDevicePMType it) {
          it.setCodeid("001");
          it.setName("\u5927\u4FEE");
        }
      };
    ObjectExtensions.<RCDevicePMType>operator_doubleArrow(rCDevicePMType, _function);RCDevicePMType rCDevicePMType_1=RCDevicePMTypeImpl.create(getObjectFactory());
    final Procedure1<RCDevicePMType> _function_1 = new Procedure1<RCDevicePMType>() {
        public void apply(final RCDevicePMType it) {
          it.setCodeid("002");
          it.setName("\u4E2D\u4FEE");
        }
      };
    ObjectExtensions.<RCDevicePMType>operator_doubleArrow(rCDevicePMType_1, _function_1);RCDevicePMType rCDevicePMType_2=RCDevicePMTypeImpl.create(getObjectFactory());
    final Procedure1<RCDevicePMType> _function_2 = new Procedure1<RCDevicePMType>() {
        public void apply(final RCDevicePMType it) {
          it.setCodeid("003");
          it.setName("\u5C0F\u4FEE");
        }
      };
    ObjectExtensions.<RCDevicePMType>operator_doubleArrow(rCDevicePMType_2, _function_2);
  }
  
  public void FaultLevelColorConfigCreator1() {IGenericQuery<RCFaultLevel> query=getObjectFactory().createGenericQuery(RCFaultLevel.class,"select e from com.fudanmed.platform.core.common.impl.RCFaultLevelImpl as e   where  e.active = 1      ");
    Collection<RCFaultLevel> _list = query.list();
    final Procedure1<RCFaultLevel> _function = new Procedure1<RCFaultLevel>() {
        public void apply(final RCFaultLevel faultLevel) {RCFaultLevelColorAdaptor rCFaultLevelColorAdaptor=RCFaultLevelColorAdaptorImpl.create(getObjectFactory());
          final Procedure1<RCFaultLevelColorAdaptor> _function = new Procedure1<RCFaultLevelColorAdaptor>() {
              public void apply(final RCFaultLevelColorAdaptor it) {
                it.setColor(RCStandardColor.black);
                it.setFaultLevel(faultLevel);
              }
            };
          ObjectExtensions.<RCFaultLevelColorAdaptor>operator_doubleArrow(rCFaultLevelColorAdaptor, _function);
        }
      };
    IterableExtensions.<RCFaultLevel>forEach(_list, _function);
  }
  
  public void CodeInit_FaultReportSource() {RCFaultReportSource rCFaultReportSource=RCFaultReportSourceImpl.create(getObjectFactory());
    final Procedure1<RCFaultReportSource> _function = new Procedure1<RCFaultReportSource>() {
        public void apply(final RCFaultReportSource it) {
          it.setCodeid("001");
          it.setName("\u7528\u6237\u62A5\u4FEE");
        }
      };
    ObjectExtensions.<RCFaultReportSource>operator_doubleArrow(rCFaultReportSource, _function);RCFaultReportSource rCFaultReportSource_1=RCFaultReportSourceImpl.create(getObjectFactory());
    final Procedure1<RCFaultReportSource> _function_1 = new Procedure1<RCFaultReportSource>() {
        public void apply(final RCFaultReportSource it) {
          it.setCodeid("002");
          it.setName("\u5DE1\u68C0\u62A5\u4FEE");
        }
      };
    ObjectExtensions.<RCFaultReportSource>operator_doubleArrow(rCFaultReportSource_1, _function_1);
  }
  
  public void ReporterName() {IGenericQuery<RCRepairTask> query=getObjectFactory().createGenericQuery(RCRepairTask.class,"select e from com.fudanmed.platform.core.domain.impl.RCRepairTaskImpl as e   where  e.active = 1      ");
    Collection<RCRepairTask> _list = query.list();
    final Procedure1<RCRepairTask> _function = new Procedure1<RCRepairTask>() {
        public void apply(final RCRepairTask it) {
          RCEmployee _reporter = it.getReporter();
          String _name = _reporter.getName();
          it.setReporterName(_name);
          RCEmployee _reporter_1 = it.getReporter();
          String _workTel = _reporter_1.getWorkTel();
          it.setReporterPhone(_workTel);
        }
      };
    IterableExtensions.<RCRepairTask>forEach(_list, _function);
  }
  
  public void IfFromReporter() {IGenericQuery<RCRepairTask> query=getObjectFactory().createGenericQuery(RCRepairTask.class,"select e from com.fudanmed.platform.core.domain.impl.RCRepairTaskImpl as e   where  e.active = 1      ");
    Collection<RCRepairTask> _list = query.list();
    final Procedure1<RCRepairTask> _function = new Procedure1<RCRepairTask>() {
        public void apply(final RCRepairTask it) {
          it.setIsFromReporter(Boolean.valueOf(false));
        }
      };
    IterableExtensions.<RCRepairTask>forEach(_list, _function);
  }
  
  public void employeeLeaveStatus() {IGenericQuery<RCEmployee> query=getObjectFactory().createGenericQuery(RCEmployee.class,"select e from com.fudanmed.platform.core.domain.impl.RCEmployeeImpl as e   where  e.active = 1      ");
    Collection<RCEmployee> _list = query.list();
    final Procedure1<RCEmployee> _function = new Procedure1<RCEmployee>() {
        public void apply(final RCEmployee it) {
          RCEmployeeStatus _status = it.getStatus();
          boolean _equals = Objects.equal(_status, null);
          if (_equals) {
            it.start();
          }
        }
      };
    IterableExtensions.<RCEmployee>forEach(_list, _function);
  }
  
  public void requireAuditInfo() {IGenericQuery<RCFaultType> query=getObjectFactory().createGenericQuery(RCFaultType.class,"select e from com.fudanmed.platform.core.domain.impl.RCFaultTypeImpl as e   where  e.active = 1      ");
    Collection<RCFaultType> _list = query.list();
    final Procedure1<RCFaultType> _function = new Procedure1<RCFaultType>() {
        public void apply(final RCFaultType it) {
          it.setNeedAudit(Boolean.valueOf(false));
        }
      };
    IterableExtensions.<RCFaultType>forEach(_list, _function);
  }
  
  public void updateCategoryPath() {IGenericQuery<RCProductType> query=getObjectFactory().createGenericQuery(RCProductType.class,"select e from com.fudanmed.platform.core.warehouse.impl.RCProductTypeImpl as e   where  e.active = 1      ");
    Collection<RCProductType> _list = query.list();
    final Procedure1<RCProductType> _function = new Procedure1<RCProductType>() {
        public void apply(final RCProductType it) {
          it.updateCategoryPath();
        }
      };
    IterableExtensions.<RCProductType>forEach(_list, _function);
  }
  
  public void updateHospitalEmployeeRoles1() {IGenericQuery<RCEmployeeUser> query=getObjectFactory().createGenericQuery(RCEmployeeUser.class,"select e from com.fudanmed.platform.core.domain.impl.RCEmployeeUserImpl as e   where  e.active = 1      ");
    Collection<RCEmployeeUser> _list = query.list();
    final Function1<RCEmployeeUser,Boolean> _function = new Function1<RCEmployeeUser,Boolean>() {
        public Boolean apply(final RCEmployeeUser it) {
          RCEmployee _employee = it.getEmployee();
          String _cardNumber = _employee.getCardNumber();
          boolean _equals = Objects.equal(_cardNumber, null);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<RCEmployeeUser> _filter = IterableExtensions.<RCEmployeeUser>filter(_list, _function);
    final Procedure1<RCEmployeeUser> _function_1 = new Procedure1<RCEmployeeUser>() {
        public void apply(final RCEmployeeUser emp) {
          String _userid = emp.getUserid();
          boolean _notEquals = (!Objects.equal(_userid, "admin"));
          if (_notEquals) {UserRoleAssignment userRoleAssignment=UserRoleAssignmentImpl.create(getObjectFactory());
            final Procedure1<UserRoleAssignment> _function = new Procedure1<UserRoleAssignment>() {
                public void apply(final UserRoleAssignment it) {
                  it.setUser(emp);
                  it.setRoleId("06");
                }
              };
            ObjectExtensions.<UserRoleAssignment>operator_doubleArrow(userRoleAssignment, _function);
          }
        }
      };
    IterableExtensions.<RCEmployeeUser>forEach(_filter, _function_1);
  }
  
  public void functions1() {AppFunction appFunction=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setFunctionId("com.fudanmed.platform.core.web.device");
          it.setName("\u8BBE\u5907\u53F0\u8D26");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction, _function);AppFunction appFunction_1=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_1 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.device");
          it.setFunctionId("com.fudanmed.platform.core.web.deviceManagementPresenter");
          it.setName("\u8BBE\u5907\u7BA1\u7406");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_1, _function_1);AppFunction appFunction_2=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_2 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.device");
          it.setFunctionId("com.fudanmed.platform.core.web.deviceTypeCategoryManagementPresenter");
          it.setName("\u8BBE\u5907\u7C7B\u578B\u7BA1\u7406");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_2, _function_2);AppFunction appFunction_3=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_3 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.device");
          it.setFunctionId("com.fudanmed.platform.core.web.numberWithUnitTypeManagementPresenter");
          it.setName("\u53C2\u6570\u7C7B\u578B\u7BA1\u7406");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_3, _function_3);AppFunction appFunction_4=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_4 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setFunctionId("com.fudanmed.platform.core.web.pm");
          it.setName("PM\u7BA1\u7406");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_4, _function_4);AppFunction appFunction_5=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_5 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.pm");
          it.setFunctionId("com.fudanmed.platform.core.web.devicePMSpecificationManagementPresenter");
          it.setName("PM\u8BA1\u5212\u7BA1\u7406");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_5, _function_5);AppFunction appFunction_6=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_6 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.pm");
          it.setFunctionId("com.fudanmed.platform.core.web.pmWorkItemManagementPresenter");
          it.setName("PM\u4EFB\u52A1\u7BA1\u7406");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_6, _function_6);AppFunction appFunction_7=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_7 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setFunctionId("com.fudanmed.platform.core.web.statistics");
          it.setName("\u7EDF\u8BA1\u67E5\u8BE2");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_7, _function_7);AppFunction appFunction_8=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_8 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.statistics");
          it.setFunctionId("com.fudanmed.platform.core.web.repairTaskStatisticListPresenter");
          it.setName("\u62A5\u4FEE\u5355\u7EDF\u8BA1\u8868");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_8, _function_8);AppFunction appFunction_9=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_9 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.statistics");
          it.setFunctionId("com.fudanmed.platform.core.web.workItemStockStatisticListPresenter");
          it.setName("\u62A5\u4FEE\u7528\u6599\u7EDF\u8BA1\u8868");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_9, _function_9);AppFunction appFunction_10=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_10 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.numberWithUnitTypeManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.device.NumberWithUnitTypeManagementPresenter.createRequest");
          it.setName("\u65B0\u5EFA\u53C2\u6570\u7C7B\u578B");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_10, _function_10);AppFunction appFunction_11=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_11 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.numberWithUnitTypeManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.device.NumberWithUnitTypeManagementPresenter.deleteRequest");
          it.setName("\u5220\u9664\u53C2\u6570\u7C7B\u578B");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_11, _function_11);AppFunction appFunction_12=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_12 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.numberWithUnitTypeManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.device.NumberWithUnitTypeManagementPresenter.modifyRequest");
          it.setName("\u4FEE\u6539\u53C2\u6570\u7C7B\u578B");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_12, _function_12);AppFunction appFunction_13=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_13 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.numberWithUnitTypeManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.device.NumberWithUnitTypeManagementPresenter.createRangeTypeRequest");
          it.setName("\u65B0\u5EFA\u8303\u56F4\u7C7B\u578B");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_13, _function_13);AppFunction appFunction_14=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_14 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.productCategoryManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.device.PMDefaultIntervalAssociationListPresenter.setPMSpecRequest");
          it.setName("\u8BBE\u7F6E\u9ED8\u8BA4PM\u8BA1\u5212");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_14, _function_14);AppFunction appFunction_15=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_15 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.pmWorkItemManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.device.PMWorkItemManagementPresenter.createRequest");
          it.setName("\u65B0\u5EFAPM\u4EFB\u52A1");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_15, _function_15);AppFunction appFunction_16=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_16 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.pmWorkItemManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.device.PMWorkItemManagementPresenter.finishWorkItemRequest");
          it.setName("PM\u4EFB\u52A1\u7ED3\u5355");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_16, _function_16);AppFunction appFunction_17=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_17 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.devicePMSpecificationManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.device.DevicePMSpecificationManagementPresenter.createRequest");
          it.setName("\u65B0\u5EFAPM\u8BA1\u5212");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_17, _function_17);AppFunction appFunction_18=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_18 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.devicePMSpecificationManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.device.DevicePMSpecificationManagementPresenter.deleteRequest");
          it.setName("\u5220\u9664PM\u8BA1\u5212");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_18, _function_18);AppFunction appFunction_19=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_19 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.devicePMSpecificationManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.device.DevicePMSpecificationManagementPresenter.modifyRequest");
          it.setName("\u4FEE\u6539PM\u8BA1\u5212");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_19, _function_19);AppFunction appFunction_20=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_20 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.devicePMSpecificationManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.device.DevicePMSpecificationManagementPresenter.initPM4DeviceRequest");
          it.setName("\u751F\u6210PM\u4EFB\u52A1");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_20, _function_20);AppFunction appFunction_21=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_21 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.productCategoryManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.device.DeviceTypeManagementPresenter.createChildRequest");
          it.setName("\u65B0\u5EFA\u8BBE\u5907\u7C7B\u522B");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_21, _function_21);AppFunction appFunction_22=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_22 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.productCategoryManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.device.DeviceTypeManagementPresenter.modifyChildRequest");
          it.setName("\u4FEE\u6539\u8BBE\u5907\u7C7B\u522B");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_22, _function_22);AppFunction appFunction_23=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_23 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.productCategoryManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.device.DeviceTypeManagementPresenter.deleteChildRequest");
          it.setName("\u5220\u9664\u8BBE\u5907\u7C7B\u522B");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_23, _function_23);AppFunction appFunction_24=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_24 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.deviceManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.device.DeviceManagementPresenter.createRequest");
          it.setName("\u65B0\u5EFA\u8BBE\u5907");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_24, _function_24);AppFunction appFunction_25=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_25 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.deviceManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.device.DeviceManagementPresenter.deleteRequest");
          it.setName("\u5220\u9664\u8BBE\u5907");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_25, _function_25);AppFunction appFunction_26=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_26 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.deviceManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.device.DeviceManagementPresenter.modifyRequest");
          it.setName("\u4FEE\u6539\u8BBE\u5907");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_26, _function_26);AppFunction appFunction_27=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_27 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.deviceTypeCategoryManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryManagementPresenter.createRequest");
          it.setName("\u65B0\u5EFA\u8BBE\u5907\u5927\u7C7B");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_27, _function_27);AppFunction appFunction_28=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_28 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.deviceTypeCategoryManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryManagementPresenter.deleteRequest");
          it.setName("\u5220\u9664\u8BBE\u5907\u5927\u7C7B");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_28, _function_28);AppFunction appFunction_29=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_29 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.deviceTypeCategoryManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryManagementPresenter.modifyRequest");
          it.setName("\u4FEE\u6539\u8BBE\u5907\u5927\u7C7B");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_29, _function_29);AppFunction appFunction_30=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_30 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.deviceTypeCategoryManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryManagementPresenter.createChildRequest");
          it.setName("\u65B0\u5EFA\u8BBE\u5907\u7C7B\u522B");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_30, _function_30);AppFunction appFunction_31=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_31 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.deviceTypeCategoryManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryManagementPresenter.modifyChildRequest");
          it.setName("\u4FEE\u6539\u8BBE\u5907\u7C7B\u522B");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_31, _function_31);AppFunction appFunction_32=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_32 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.deviceTypeCategoryManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryManagementPresenter.deleteChildRequest");
          it.setName("\u5220\u9664\u8BBE\u5907\u7C7B\u522B");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_32, _function_32);AppFunction appFunction_33=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_33 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.deviceTypeCategoryManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryManagementPresenter.setPMSpecRequest");
          it.setName("\u8BBE\u7F6E\u9ED8\u8BA4PM\u8BA1\u5212");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_33, _function_33);
  }
  
  public void functions2() {AppFunction appFunction=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.basic");
          it.setFunctionId("edu.fudan.langlab.uidl.domain.app.changePasswdPresenter");
          it.setName("\u4FEE\u6539\u5BC6\u7801");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction, _function);
  }
  
  @Autowired
  private UpdateServie updateService;
  
  public void doUpgrade() {
    if (updateService.canPerformUpdate("V_0_3_upgrade", "V_0_3", "devicePMTypes")) {
    	devicePMTypes();
    	updateService.updaterCommited("V_0_3_upgrade", "V_0_3", "devicePMTypes");
    }
    if (updateService.canPerformUpdate("V_0_3_upgrade", "V_0_3", "FaultLevelColorConfigCreator1")) {
    	FaultLevelColorConfigCreator1();
    	updateService.updaterCommited("V_0_3_upgrade", "V_0_3", "FaultLevelColorConfigCreator1");
    }
    if (updateService.canPerformUpdate("V_0_3_upgrade", "V_0_3", "CodeInit_FaultReportSource")) {
    	CodeInit_FaultReportSource();
    	updateService.updaterCommited("V_0_3_upgrade", "V_0_3", "CodeInit_FaultReportSource");
    }
    if (updateService.canPerformUpdate("V_0_3_upgrade", "V_0_3", "ReporterName")) {
    	ReporterName();
    	updateService.updaterCommited("V_0_3_upgrade", "V_0_3", "ReporterName");
    }
    if (updateService.canPerformUpdate("V_0_3_upgrade", "V_0_3", "IfFromReporter")) {
    	IfFromReporter();
    	updateService.updaterCommited("V_0_3_upgrade", "V_0_3", "IfFromReporter");
    }
    if (updateService.canPerformUpdate("V_0_3_upgrade", "V_0_3", "employeeLeaveStatus")) {
    	employeeLeaveStatus();
    	updateService.updaterCommited("V_0_3_upgrade", "V_0_3", "employeeLeaveStatus");
    }
    if (updateService.canPerformUpdate("V_0_3_upgrade", "V_0_3", "requireAuditInfo")) {
    	requireAuditInfo();
    	updateService.updaterCommited("V_0_3_upgrade", "V_0_3", "requireAuditInfo");
    }
    if (updateService.canPerformUpdate("V_0_3_upgrade", "V_0_3", "updateCategoryPath")) {
    	updateCategoryPath();
    	updateService.updaterCommited("V_0_3_upgrade", "V_0_3", "updateCategoryPath");
    }
    if (updateService.canPerformUpdate("V_0_3_upgrade", "V_0_3", "updateHospitalEmployeeRoles1")) {
    	updateHospitalEmployeeRoles1();
    	updateService.updaterCommited("V_0_3_upgrade", "V_0_3", "updateHospitalEmployeeRoles1");
    }
    if (updateService.canPerformUpdate("V_0_3_upgrade", "V_0_3", "functions1")) {
    	functions1();
    	updateService.updaterCommited("V_0_3_upgrade", "V_0_3", "functions1");
    }
    if (updateService.canPerformUpdate("V_0_3_upgrade", "V_0_3", "functions2")) {
    	functions2();
    	updateService.updaterCommited("V_0_3_upgrade", "V_0_3", "functions2");
    }
    updateService.upgraderCommited("V_0_3", "V_0_4");
  }
}
