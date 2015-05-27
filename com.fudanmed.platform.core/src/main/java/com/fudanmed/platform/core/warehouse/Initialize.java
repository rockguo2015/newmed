package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.common.RCFaultEmergencyLevel;
import com.fudanmed.platform.core.common.RCFaultLevel;
import com.fudanmed.platform.core.common.RCOutStockType;
import com.fudanmed.platform.core.common.impl.RCFaultEmergencyLevelImpl;
import com.fudanmed.platform.core.common.impl.RCFaultLevelImpl;
import com.fudanmed.platform.core.common.impl.RCOutStockTypeImpl;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeDAO;
import com.fudanmed.platform.core.domain.RCOrganizationService;
import com.fudanmed.platform.core.warehouse.RCInStoreType;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.impl.RCInStoreTypeImpl;
import com.fudanmed.platform.core.warehouse.impl.RCWarehouseImpl;
import edu.fudan.langlab.domain.security.AppFunction;
import edu.fudan.langlab.domain.security.impl.AppFunctionImpl;
import edu.fudan.langlab.domain.updater.IUpgrader;
import edu.fudan.langlab.domain.updater.UpdateServie;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("Initialize")
public class Initialize extends BaseService implements IUpgrader {
  @Autowired
  private RCOrganizationService organizationService;
  
  @Autowired
  private RCEmployeeDAO employeeDAO;
  
  @Autowired
  private IObjectFactory entities;
  
  public void initAdmin() {
    final Procedure1<RCEmployee> _function = new Procedure1<RCEmployee>() {
        public void apply(final RCEmployee it) {
        }
      };
    RCEmployee _create = this.employeeDAO.create("admin", _function);
    final Procedure1<RCEmployee> _function_1 = new Procedure1<RCEmployee>() {
        public void apply(final RCEmployee it) {
          it.setName("\u7CFB\u7EDF\u7BA1\u7406\u5458");
        }
      };
    ObjectExtensions.<RCEmployee>operator_doubleArrow(_create, _function_1);
  }
  
  public void initOrgzniation() {
    this.organizationService.createRootOrganization("1", "XX\u533B\u9662");
    this.organizationService.createRootOrganization("2", "\u590D\u65E6\u540E\u52E4\u8FD0\u8425\u70B9");
  }
  
  public void initStore() {RCWarehouse rCWarehouse=RCWarehouseImpl.create(getObjectFactory());
    final Procedure1<RCWarehouse> _function = new Procedure1<RCWarehouse>() {
        public void apply(final RCWarehouse it) {
          it.setName("\u5DE5\u7A0B\u90E8\u4E3B\u4ED3");
          it.setLocation("\u5DE5\u7A0B\u90E8\u4E3B\u4ED3");
          it.setIsMajor(Boolean.valueOf(true));
        }
      };
    ObjectExtensions.<RCWarehouse>operator_doubleArrow(rCWarehouse, _function);
  }
  
  public void initCodes() {RCFaultLevel rCFaultLevel=RCFaultLevelImpl.create(getObjectFactory());
    final Procedure1<RCFaultLevel> _function = new Procedure1<RCFaultLevel>() {
        public void apply(final RCFaultLevel it) {
          it.setCodeid("001");
          it.setName("\u666E\u901A");
        }
      };
    ObjectExtensions.<RCFaultLevel>operator_doubleArrow(rCFaultLevel, _function);RCFaultLevel rCFaultLevel_1=RCFaultLevelImpl.create(getObjectFactory());
    final Procedure1<RCFaultLevel> _function_1 = new Procedure1<RCFaultLevel>() {
        public void apply(final RCFaultLevel it) {
          it.setCodeid("002");
          it.setName("\u8F83\u5927");
        }
      };
    ObjectExtensions.<RCFaultLevel>operator_doubleArrow(rCFaultLevel_1, _function_1);RCFaultLevel rCFaultLevel_2=RCFaultLevelImpl.create(getObjectFactory());
    final Procedure1<RCFaultLevel> _function_2 = new Procedure1<RCFaultLevel>() {
        public void apply(final RCFaultLevel it) {
          it.setCodeid("003");
          it.setName("\u4E25\u91CD");
        }
      };
    ObjectExtensions.<RCFaultLevel>operator_doubleArrow(rCFaultLevel_2, _function_2);RCFaultLevel rCFaultLevel_3=RCFaultLevelImpl.create(getObjectFactory());
    final Procedure1<RCFaultLevel> _function_3 = new Procedure1<RCFaultLevel>() {
        public void apply(final RCFaultLevel it) {
          it.setCodeid("004");
          it.setName("\u91CD\u5927");
        }
      };
    ObjectExtensions.<RCFaultLevel>operator_doubleArrow(rCFaultLevel_3, _function_3);RCFaultEmergencyLevel rCFaultEmergencyLevel=RCFaultEmergencyLevelImpl.create(getObjectFactory());
    final Procedure1<RCFaultEmergencyLevel> _function_4 = new Procedure1<RCFaultEmergencyLevel>() {
        public void apply(final RCFaultEmergencyLevel it) {
          it.setCodeid("001");
          it.setName("\u666E\u901A");
        }
      };
    ObjectExtensions.<RCFaultEmergencyLevel>operator_doubleArrow(rCFaultEmergencyLevel, _function_4);RCFaultEmergencyLevel rCFaultEmergencyLevel_1=RCFaultEmergencyLevelImpl.create(getObjectFactory());
    final Procedure1<RCFaultEmergencyLevel> _function_5 = new Procedure1<RCFaultEmergencyLevel>() {
        public void apply(final RCFaultEmergencyLevel it) {
          it.setCodeid("002");
          it.setName("\u4E00\u822C");
        }
      };
    ObjectExtensions.<RCFaultEmergencyLevel>operator_doubleArrow(rCFaultEmergencyLevel_1, _function_5);RCFaultEmergencyLevel rCFaultEmergencyLevel_2=RCFaultEmergencyLevelImpl.create(getObjectFactory());
    final Procedure1<RCFaultEmergencyLevel> _function_6 = new Procedure1<RCFaultEmergencyLevel>() {
        public void apply(final RCFaultEmergencyLevel it) {
          it.setCodeid("003");
          it.setName("\u7D27\u6025");
        }
      };
    ObjectExtensions.<RCFaultEmergencyLevel>operator_doubleArrow(rCFaultEmergencyLevel_2, _function_6);RCFaultEmergencyLevel rCFaultEmergencyLevel_3=RCFaultEmergencyLevelImpl.create(getObjectFactory());
    final Procedure1<RCFaultEmergencyLevel> _function_7 = new Procedure1<RCFaultEmergencyLevel>() {
        public void apply(final RCFaultEmergencyLevel it) {
          it.setCodeid("004");
          it.setName("\u7279\u6025");
        }
      };
    ObjectExtensions.<RCFaultEmergencyLevel>operator_doubleArrow(rCFaultEmergencyLevel_3, _function_7);RCOutStockType rCOutStockType=RCOutStockTypeImpl.create(getObjectFactory());
    final Procedure1<RCOutStockType> _function_8 = new Procedure1<RCOutStockType>() {
        public void apply(final RCOutStockType it) {
          it.setCodeid("001");
          it.setName("\u666E\u901A\u51FA\u5E93");
        }
      };
    ObjectExtensions.<RCOutStockType>operator_doubleArrow(rCOutStockType, _function_8);RCOutStockType rCOutStockType_1=RCOutStockTypeImpl.create(getObjectFactory());
    final Procedure1<RCOutStockType> _function_9 = new Procedure1<RCOutStockType>() {
        public void apply(final RCOutStockType it) {
          it.setCodeid("002");
          it.setName("\u9000\u8D27\u51FA\u5E93");
        }
      };
    ObjectExtensions.<RCOutStockType>operator_doubleArrow(rCOutStockType_1, _function_9);RCInStoreType rCInStoreType=RCInStoreTypeImpl.create(getObjectFactory());
    final Procedure1<RCInStoreType> _function_10 = new Procedure1<RCInStoreType>() {
        public void apply(final RCInStoreType it) {
          it.setCodeid("001");
          it.setName("\u91C7\u8D2D\u5165\u5E93");
        }
      };
    ObjectExtensions.<RCInStoreType>operator_doubleArrow(rCInStoreType, _function_10);RCInStoreType rCInStoreType_1=RCInStoreTypeImpl.create(getObjectFactory());
    final Procedure1<RCInStoreType> _function_11 = new Procedure1<RCInStoreType>() {
        public void apply(final RCInStoreType it) {
          it.setCodeid("001");
          it.setName("\u666E\u901A\u5165\u5E93");
        }
      };
    ObjectExtensions.<RCInStoreType>operator_doubleArrow(rCInStoreType_1, _function_11);
  }
  
  public void initFrameworkFunctions() {AppFunction appFunction=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("edu.fudan.langlab.uidl.domain.app.roleFunctionAssignmentPresenter");
          it.setFunctionId("edu.fudan.langlab.uidl.domain.app.client.security.RoleFunctionAssignmentPresenter.modifyAssignmentRequest");
          it.setName("\u4FEE\u6539\u529F\u80FD\u5206\u914D");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction, _function);AppFunction appFunction_1=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_1 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("edu.fudan.langlab.uidl.domain.app.roleManagementPresenter");
          it.setFunctionId("edu.fudan.langlab.uidl.domain.app.client.security.RoleManagementPresenter.createRoleRequest");
          it.setName("\u65B0\u5EFA");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_1, _function_1);AppFunction appFunction_2=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_2 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("edu.fudan.langlab.uidl.domain.app.roleManagementPresenter");
          it.setFunctionId("edu.fudan.langlab.uidl.domain.app.client.security.RoleManagementPresenter.modifyRoleRequest");
          it.setName("\u4FEE\u6539");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_2, _function_2);AppFunction appFunction_3=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_3 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("edu.fudan.langlab.uidl.domain.app.roleManagementPresenter");
          it.setFunctionId("edu.fudan.langlab.uidl.domain.app.client.security.RoleManagementPresenter.deleteRoleRequest");
          it.setName("\u5220\u9664");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_3, _function_3);AppFunction appFunction_4=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_4 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setFunctionId("edu.fudan.langlab.uidl.domain.app.systemadmin");
          it.setName("\u7CFB\u7EDF\u7BA1\u7406");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_4, _function_4);AppFunction appFunction_5=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_5 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("edu.fudan.langlab.uidl.domain.app.systemadmin");
          it.setFunctionId("edu.fudan.langlab.uidl.domain.app.roleManagementPresenter");
          it.setName("\u7CFB\u7EDF\u89D2\u8272\u7BA1\u7406");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_5, _function_5);AppFunction appFunction_6=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_6 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("edu.fudan.langlab.uidl.domain.app.systemadmin");
          it.setFunctionId("edu.fudan.langlab.uidl.domain.app.roleFunctionAssignmentPresenter");
          it.setName("\u7CFB\u7EDF\u529F\u80FD\u6743\u9650\u8BBE\u7F6E");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_6, _function_6);AppFunction appFunction_7=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_7 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("edu.fudan.langlab.uidl.domain.app.systemadmin");
          it.setFunctionId("edu.fudan.langlab.uidl.domain.app.codeManagementPresenter");
          it.setName("\u57FA\u7840\u4EE3\u7801\u7BA1\u7406");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_7, _function_7);AppFunction appFunction_8=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_8 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("edu.fudan.langlab.uidl.domain.app.codeManagementPresenter");
          it.setFunctionId("edu.fudan.langlab.uidl.domain.code.client.web.CodeManagementPresenter.createRequest");
          it.setName("\u65B0\u5EFA");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_8, _function_8);AppFunction appFunction_9=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_9 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("edu.fudan.langlab.uidl.domain.app.codeManagementPresenter");
          it.setFunctionId("edu.fudan.langlab.uidl.domain.code.client.web.CodeManagementPresenter.deleteRequest");
          it.setName("\u5220\u9664");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_9, _function_9);AppFunction appFunction_10=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_10 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("edu.fudan.langlab.uidl.domain.app.codeManagementPresenter");
          it.setFunctionId("edu.fudan.langlab.uidl.domain.code.client.web.CodeManagementPresenter.modifyRequest");
          it.setName("\u4FEE\u6539");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_10, _function_10);
  }
  
  public void initApplicationFunctions() {AppFunction appFunction=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.organizationManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.organization.OrganizationManagementPresenter.createRequest");
          it.setName("\u65B0\u5EFA");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction, _function);AppFunction appFunction_1=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_1 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.organizationManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.organization.OrganizationManagementPresenter.importRequest");
          it.setName("\u5BFC\u5165");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_1, _function_1);AppFunction appFunction_2=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_2 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.organizationManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.organization.OrganizationManagementPresenter.deleteRequest");
          it.setName("\u5220\u9664");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_2, _function_2);AppFunction appFunction_3=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_3 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.organizationManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.organization.OrganizationManagementPresenter.modifyRequest");
          it.setName("\u4FEE\u6539");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_3, _function_3);AppFunction appFunction_4=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_4 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.systemParameterPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.workbench.SystemParameterPresenter.modifyParameterRequest");
          it.setName("\u4FEE\u6539\u7CFB\u7EDF\u53C2\u6570");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_4, _function_4);AppFunction appFunction_5=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_5 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.employeeManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.organization.EmployeeManagementPresenter.createRequest");
          it.setName("\u65B0\u5EFA");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_5, _function_5);AppFunction appFunction_6=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_6 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.employeeManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.organization.EmployeeManagementPresenter.importRequest");
          it.setName("\u5BFC\u5165");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_6, _function_6);AppFunction appFunction_7=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_7 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.employeeManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.organization.EmployeeManagementPresenter.deleteRequest");
          it.setName("\u5220\u9664");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_7, _function_7);AppFunction appFunction_8=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_8 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.employeeManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.organization.EmployeeManagementPresenter.modifyRequest");
          it.setName("\u4FEE\u6539");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_8, _function_8);AppFunction appFunction_9=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_9 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.employeeManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.organization.EmployeeManagementPresenter.assignRolesRequest");
          it.setName("\u5206\u914D\u89D2\u8272");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_9, _function_9);AppFunction appFunction_10=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_10 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.onsitePositionManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.organization.OnsitePositionManagementPresenter.createRequest");
          it.setName("\u65B0\u5EFA");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_10, _function_10);AppFunction appFunction_11=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_11 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.onsitePositionManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.organization.OnsitePositionManagementPresenter.importRequest");
          it.setName("\u5BFC\u5165");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_11, _function_11);AppFunction appFunction_12=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_12 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.onsitePositionManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.organization.OnsitePositionManagementPresenter.deleteRequest");
          it.setName("\u5220\u9664");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_12, _function_12);AppFunction appFunction_13=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_13 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.onsitePositionManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.organization.OnsitePositionManagementPresenter.modifyRequest");
          it.setName("\u4FEE\u6539");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_13, _function_13);AppFunction appFunction_14=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_14 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.supplierManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.organization.SupplierManagementPresenter.createRequest");
          it.setName("\u65B0\u5EFA");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_14, _function_14);AppFunction appFunction_15=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_15 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.supplierManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.organization.SupplierManagementPresenter.deleteRequest");
          it.setName("\u5220\u9664");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_15, _function_15);AppFunction appFunction_16=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_16 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.supplierManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.organization.SupplierManagementPresenter.modifyRequest");
          it.setName("\u4FEE\u6539");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_16, _function_16);AppFunction appFunction_17=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_17 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.workItemTaskManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.warehouse.WorkItemTaskManagementPresenter.showWorkItemOutStockRecordDetail");
          it.setName("\u67E5\u770B\u9886/\u9000\u6599\u4FE1\u606F");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_17, _function_17);AppFunction appFunction_18=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_18 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.workItemTaskManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.warehouse.WorkItemTaskManagementPresenter.createWorkItemOutStoreRequest");
          it.setName("\u9886\u6599");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_18, _function_18);AppFunction appFunction_19=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_19 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.workItemTaskManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.warehouse.WorkItemTaskManagementPresenter.createWorkItemReturnStoreRequest");
          it.setName("\u9000\u6599");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_19, _function_19);AppFunction appFunction_20=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_20 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.transferRecordListPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.warehouse.TransferRecordListPresenter.transferRequest");
          it.setName("\u8C03\u62E8");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_20, _function_20);AppFunction appFunction_21=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_21 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.stockTakingListListPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.warehouse.StockTakingListListPresenter.createStockTakingListRequest");
          it.setName("\u65B0\u5EFA\u5B9E\u76D8\u6E05\u5355");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_21, _function_21);AppFunction appFunction_22=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_22 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.stockTakingListListPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.warehouse.StockTakingListListPresenter.cancelStockTakingListRequest");
          it.setName("\u53D6\u6D88\u5B9E\u76D8");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_22, _function_22);AppFunction appFunction_23=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_23 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.stockTakingListListPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.warehouse.StockTakingListListPresenter.inputQuantity");
          it.setName("\u5B9E\u76D8\u4FE1\u606F\u5F55\u5165");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_23, _function_23);AppFunction appFunction_24=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_24 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.stockTakingListListPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.warehouse.StockTakingListListPresenter.commit");
          it.setName("\u63D0\u4EA4");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_24, _function_24);AppFunction appFunction_25=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_25 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.stockTakingListListPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.warehouse.StockTakingListListPresenter.export");
          it.setName("\u5BFC\u51FA");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_25, _function_25);AppFunction appFunction_26=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_26 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.stockTakingRecordListPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.warehouse.StockTakingRecordListPresenter.StockTakingRequest");
          it.setName("\u7269\u54C1\u76D8\u70B9");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_26, _function_26);AppFunction appFunction_27=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_27 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.stockTakingRecordListPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.warehouse.StockTakingRecordListPresenter.modifyStockTakingRequest");
          it.setName("\u4FEE\u6539\u76D8\u70B9\u5355");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_27, _function_27);AppFunction appFunction_28=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_28 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.productCategoryManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.warehouse.ProductCategoryManagementPresenter.createRequest");
          it.setName("\u65B0\u5EFA\u7269\u54C1\u5927\u7C7B");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_28, _function_28);AppFunction appFunction_29=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_29 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.productCategoryManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.warehouse.ProductCategoryManagementPresenter.deleteRequest");
          it.setName("\u5220\u9664\u7269\u54C1\u5927\u7C7B");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_29, _function_29);AppFunction appFunction_30=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_30 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.productCategoryManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.warehouse.ProductCategoryManagementPresenter.modifyRequest");
          it.setName("\u4FEE\u6539\u7269\u54C1\u5927\u7C7B");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_30, _function_30);AppFunction appFunction_31=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_31 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.productCategoryManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.warehouse.ProductCategoryManagementPresenter.createChildRequest");
          it.setName("\u65B0\u5EFA\u7269\u54C1\u7C7B\u522B");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_31, _function_31);AppFunction appFunction_32=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_32 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.productCategoryManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.warehouse.ProductCategoryManagementPresenter.modifyChildRequest");
          it.setName("\u4FEE\u6539\u7269\u54C1\u7C7B\u522B");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_32, _function_32);AppFunction appFunction_33=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_33 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.productCategoryManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.warehouse.ProductCategoryManagementPresenter.deleteChildRequest");
          it.setName("\u5220\u9664\u7269\u54C1\u7C7B\u522B");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_33, _function_33);AppFunction appFunction_34=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_34 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.productSpecificationManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationManagementPresenter.createRequest");
          it.setName("\u65B0\u5EFA");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_34, _function_34);AppFunction appFunction_35=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_35 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.productSpecificationManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationManagementPresenter.importRequest");
          it.setName("\u5BFC\u5165");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_35, _function_35);AppFunction appFunction_36=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_36 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.productSpecificationManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationManagementPresenter.deleteRequest");
          it.setName("\u5220\u9664");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_36, _function_36);AppFunction appFunction_37=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_37 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.productSpecificationManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationManagementPresenter.modifyRequest");
          it.setName("\u4FEE\u6539");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_37, _function_37);AppFunction appFunction_38=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_38 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.outStockRecordListPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.warehouse.OutStockRecordListPresenter.OutStockRequest");
          it.setName("\u7269\u54C1\u51FA\u5E93");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_38, _function_38);AppFunction appFunction_39=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_39 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.outStockRecordListPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.warehouse.OutStockRecordListPresenter.modifyOutStockRequest");
          it.setName("\u4FEE\u6539\u51FA\u5E93\u5355");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_39, _function_39);AppFunction appFunction_40=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_40 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.inStockRecordListPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.warehouse.InStockRecordListPresenter.inStockRequest");
          it.setName("\u7269\u54C1\u5165\u5E93");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_40, _function_40);AppFunction appFunction_41=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_41 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.inStockRecordListPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.warehouse.InStockRecordListPresenter.modifyInStockRequest");
          it.setName("\u4FEE\u6539\u5165\u5E93\u5355");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_41, _function_41);AppFunction appFunction_42=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_42 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.warehouseManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.warehouse.WarehouseManagementPresenter.createWarehouseRequest");
          it.setName("\u65B0\u5EFA");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_42, _function_42);AppFunction appFunction_43=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_43 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.warehouseManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.warehouse.WarehouseManagementPresenter.updateWarehouseRequest");
          it.setName("\u4FEE\u6539");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_43, _function_43);AppFunction appFunction_44=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_44 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.warehouseManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.warehouse.WarehouseManagementPresenter.deleteWarehouseRequest");
          it.setName("\u5220\u9664");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_44, _function_44);AppFunction appFunction_45=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_45 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.maintenanceTypeManagerPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.MaintenamceTypeManagementPresenter.createRequest");
          it.setName("\u65B0\u5EFA\u7EF4\u4FEE\u7C7B\u522B");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_45, _function_45);AppFunction appFunction_46=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_46 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.maintenanceTypeManagerPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.MaintenamceTypeManagementPresenter.deleteRequest");
          it.setName("\u5220\u9664\u7EF4\u4FEE\u7C7B\u522B");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_46, _function_46);AppFunction appFunction_47=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_47 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.maintenanceTypeManagerPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.MaintenamceTypeManagementPresenter.modifyRequest");
          it.setName("\u4FEE\u6539\u7EF4\u4FEE\u7C7B\u522B");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_47, _function_47);AppFunction appFunction_48=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_48 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.maintenanceTypeManagerPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.MaintenamceTypeManagementPresenter.createChildRequest");
          it.setName("\u65B0\u5EFA\u7EF4\u4FEE\u9879\u76EE");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_48, _function_48);AppFunction appFunction_49=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_49 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.maintenanceTypeManagerPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.MaintenamceTypeManagementPresenter.modifyChildRequest");
          it.setName("\u4FEE\u6539\u7EF4\u4FEE\u9879\u76EE");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_49, _function_49);AppFunction appFunction_50=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_50 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.maintenanceTypeManagerPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.MaintenamceTypeManagementPresenter.deleteChildRequest");
          it.setName("\u5220\u9664\u7EF4\u4FEE\u9879\u76EE");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_50, _function_50);AppFunction appFunction_51=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_51 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.maintenanceTeamManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.MaintenanceTeamManagementPresenter.selectAsTeam");
          it.setName("\u9009\u5B9A\u7EF4\u4FEE\u73ED\u7EC4");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_51, _function_51);AppFunction appFunction_52=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_52 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.maintenanceTeamManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.MaintenanceTeamManagementPresenter.removeFromTeam");
          it.setName("\u79FB\u9664\u7EF4\u4FEE\u73ED\u7EC4");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_52, _function_52);AppFunction appFunction_53=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_53 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.settlementListPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.SettlementListPresenter.createSettlementRequest");
          it.setName("\u65B0\u5EFA\u7ED3\u7B97\u5355");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_53, _function_53);AppFunction appFunction_54=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_54 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.settlementListPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.SettlementListPresenter.modifySettlementRequest");
          it.setName("\u4FEE\u6539\u7ED3\u7B97\u5355");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_54, _function_54);AppFunction appFunction_55=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_55 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.settlementListPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.SettlementListPresenter.cancelSettlementRequest");
          it.setName("\u53D6\u6D88\u7ED3\u7B97");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_55, _function_55);AppFunction appFunction_56=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_56 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.settlementListPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.SettlementListPresenter.addRepairTaskItemsRequest");
          it.setName("\u6DFB\u52A0\u7ED3\u7B97\u4FDD\u4FEE\u5355");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_56, _function_56);AppFunction appFunction_57=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_57 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.settlementListPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.SettlementListPresenter.cancelSettlementItemRequest");
          it.setName("\u79FB\u9664\u7ED3\u7B97\u62A5\u4FEE\u5355");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_57, _function_57);AppFunction appFunction_58=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_58 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.reportManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.ReportManagementPresenter.createRequest");
          it.setName("\u65B0\u5EFA\u62A5\u4FEE");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_58, _function_58);AppFunction appFunction_59=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_59 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.reportManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.ReportManagementPresenter.complaintRequest");
          it.setName("\u6295\u8BC9");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_59, _function_59);AppFunction appFunction_60=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_60 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.reportManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.ReportManagementPresenter.doEvaluate");
          it.setName("\u8BC4\u4EF7");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_60, _function_60);AppFunction appFunction_61=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_61 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.repairReportManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.RepairTaskManagementPresenter.createRequest");
          it.setName("\u65B0\u5EFA\u62A5\u4FEE");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_61, _function_61);AppFunction appFunction_62=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_62 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.repairReportManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.RepairTaskManagementPresenter.deleteRequest");
          it.setName("\u5220\u9664\u62A5\u4FEE");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_62, _function_62);AppFunction appFunction_63=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_63 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.repairReportManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.RepairTaskManagementPresenter.modifyRequest");
          it.setName("\u4FEE\u6539\u62A5\u4FEE");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_63, _function_63);AppFunction appFunction_64=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_64 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.repairReportManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.RepairTaskManagementPresenter.dispatchRequest");
          it.setName("\u6D3E\u53D1\u73ED\u7EC4");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_64, _function_64);AppFunction appFunction_65=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_65 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.repairReportManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.RepairTaskManagementPresenter.closeRepairTaskRequest");
          it.setName("\u62A5\u4FEE\u7ED3\u5355");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_65, _function_65);AppFunction appFunction_66=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_66 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.repairReportManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.RepairTaskManagementPresenter.surveyRepairTaskRequest");
          it.setName("\u62A5\u4FEE\u56DE\u8BBF");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_66, _function_66);AppFunction appFunction_67=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_67 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.groupTaskManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.GroupTaskManagementPresenter.createWorkItemTaskRequest");
          it.setName("\u5DE5\u5355\u6D3E\u5DE5");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_67, _function_67);AppFunction appFunction_68=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_68 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.groupTaskManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.GroupTaskManagementPresenter.finishGroupTaskRequest");
          it.setName("\u5B8C\u5DE5\u4E0A\u62A5");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_68, _function_68);AppFunction appFunction_69=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_69 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.groupTaskManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.GroupTaskManagementPresenter.misDispatchGroupTaskRequest");
          it.setName("\u4E32\u5355\u4E0A\u62A5");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_69, _function_69);AppFunction appFunction_70=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_70 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.groupTaskManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.GroupTaskManagementPresenter.pendWorkItemTaskRequest");
          it.setName("\u5DE5\u5355\u6302\u8D77");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_70, _function_70);AppFunction appFunction_71=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_71 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.groupTaskManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.GroupTaskManagementPresenter.cancelPendWorkItemTaskRequest");
          it.setName("\u7ED3\u675F\u6302\u8D77");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_71, _function_71);AppFunction appFunction_72=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_72 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.groupTaskManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.GroupTaskManagementPresenter.outsourceWorkItemTaskRequest");
          it.setName("\u5916\u534F");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_72, _function_72);AppFunction appFunction_73=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_73 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.groupTaskManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.GroupTaskManagementPresenter.finishOutsourceWorkItemTaskRequest");
          it.setName("\u5B8C\u6210\u5916\u534F");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_73, _function_73);AppFunction appFunction_74=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_74 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.groupTaskManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.GroupTaskManagementPresenter.misDispatchingWorkItemTaskRequest");
          it.setName("\u4E32\u5355");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_74, _function_74);AppFunction appFunction_75=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_75 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.groupTaskManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.GroupTaskManagementPresenter.finishWorkItemTaskRequest");
          it.setName("\u5DE5\u5355\u5B8C\u5DE5");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_75, _function_75);AppFunction appFunction_76=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_76 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.groupTaskManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.GroupTaskManagementPresenter.followUpWOrkItemTaskRequest");
          it.setName("\u8DDF\u8FDB");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_76, _function_76);AppFunction appFunction_77=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_77 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setFunctionId("com.fudanmed.platform.core.web.basic");
          it.setName("\u57FA\u7840\u6570\u636E\u7EF4\u62A4");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_77, _function_77);AppFunction appFunction_78=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_78 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.basic");
          it.setFunctionId("com.fudanmed.platform.core.web.onsitePositionManagementPresenter");
          it.setName("\u533A\u57DF\u4F4D\u7F6E\u7EF4\u62A4");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_78, _function_78);AppFunction appFunction_79=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_79 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.basic");
          it.setFunctionId("com.fudanmed.platform.core.web.organizationManagementPresenter");
          it.setName("\u7EC4\u7EC7\u673A\u6784\u7EF4\u62A4");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_79, _function_79);AppFunction appFunction_80=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_80 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.basic");
          it.setFunctionId("com.fudanmed.platform.core.web.employeeManagementPresenter");
          it.setName("\u5458\u5DE5\u7EF4\u62A4");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_80, _function_80);AppFunction appFunction_81=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_81 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.basic");
          it.setFunctionId("com.fudanmed.platform.core.web.supplierManagementPresenter");
          it.setName("\u4F9B\u5E94\u5546\u7EF4\u62A4");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_81, _function_81);AppFunction appFunction_82=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_82 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.basic");
          it.setFunctionId("com.fudanmed.platform.core.web.systemParameterPresenter");
          it.setName("\u7CFB\u7EDF\u53C2\u6570\u7EF4\u62A4");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_82, _function_82);AppFunction appFunction_83=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_83 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setFunctionId("com.fudanmed.platform.core.web.project");
          it.setName("\u8BBE\u5907\u5DE5\u7A0B\u6570\u636E\u7EF4\u62A4");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_83, _function_83);AppFunction appFunction_84=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_84 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.project");
          it.setFunctionId("com.fudanmed.platform.core.web.maintenanceTypeManagerPresenter");
          it.setName("\u7EF4\u4FEE\u7C7B\u522B\u7EF4\u62A4");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_84, _function_84);AppFunction appFunction_85=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_85 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.project");
          it.setFunctionId("com.fudanmed.platform.core.web.maintenanceTeamManagementPresenter");
          it.setName("\u7EF4\u4FEE\u73ED\u7EC4\u8BBE\u7F6E");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_85, _function_85);AppFunction appFunction_86=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_86 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setFunctionId("com.fudanmed.platform.core.web.department");
          it.setName("\u79D1\u5BA4\u65E5\u5E38\u4E1A\u52A1");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_86, _function_86);AppFunction appFunction_87=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_87 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.department");
          it.setFunctionId("com.fudanmed.platform.core.web.reportManagementPresenter");
          it.setName("\u79D1\u5BA4\u62A5\u4FEE\u5DE5\u4F5C\u53F0");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_87, _function_87);AppFunction appFunction_88=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_88 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setFunctionId("com.fudanmed.platform.core.web.process");
          it.setName("\u5DE5\u7A0B\u65E5\u5E38\u4E1A\u52A1");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_88, _function_88);AppFunction appFunction_89=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_89 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.process");
          it.setFunctionId("com.fudanmed.platform.core.web.repairReportManagementPresenter");
          it.setName("\u8C03\u5EA6\u5DE5\u4F5C\u53F0");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_89, _function_89);AppFunction appFunction_90=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_90 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.process");
          it.setFunctionId("com.fudanmed.platform.core.web.groupTaskManagementPresenter");
          it.setName("\u73ED\u7EC4\u5DE5\u4F5C\u53F0");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_90, _function_90);AppFunction appFunction_91=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_91 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setFunctionId("com.fudanmed.platform.core.web.warehousecore");
          it.setName("\u5DE5\u7A0B\u4ED3\u5E93\u6570\u636E\u7EF4\u62A4");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_91, _function_91);AppFunction appFunction_92=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_92 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.warehousecore");
          it.setFunctionId("com.fudanmed.platform.core.web.productCategoryManagementPresenter");
          it.setName("\u7269\u54C1\u7C7B\u578B\u4FE1\u606F\u7EF4\u62A4");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_92, _function_92);AppFunction appFunction_93=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_93 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.warehousecore");
          it.setFunctionId("com.fudanmed.platform.core.web.warehouseManagementPresenter");
          it.setName("\u4ED3\u5E93\u4FE1\u606F\u7EF4\u62A4");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_93, _function_93);AppFunction appFunction_94=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_94 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.warehousecore");
          it.setFunctionId("com.fudanmed.platform.core.web.productSpecificationManagementPresenter");
          it.setName("\u7269\u54C1\u4FE1\u606F\u7EF4\u62A4");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_94, _function_94);AppFunction appFunction_95=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_95 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setFunctionId("com.fudanmed.platform.core.web.warehouse");
          it.setName("\u5DE5\u7A0B\u4ED3\u5E93\u7BA1\u7406");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_95, _function_95);AppFunction appFunction_96=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_96 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.warehouse");
          it.setFunctionId("com.fudanmed.platform.core.web.productWarehouseStorageSummaryManagementPresenter");
          it.setName("\u5E93\u5B58\u53F0\u5E10");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_96, _function_96);AppFunction appFunction_97=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_97 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.warehouse");
          it.setFunctionId("com.fudanmed.platform.core.web.inStockRecordListPresenter");
          it.setName("\u5165\u5E93\u7BA1\u7406");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_97, _function_97);AppFunction appFunction_98=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_98 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.warehouse");
          it.setFunctionId("com.fudanmed.platform.core.web.outStockRecordListPresenter");
          it.setName("\u51FA\u5E93\u7BA1\u7406");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_98, _function_98);AppFunction appFunction_99=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_99 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.warehouse");
          it.setFunctionId("com.fudanmed.platform.core.web.workItemTaskManagementPresenter");
          it.setName("\u5DE5\u5355\u9886/\u9000\u6599\u7BA1\u7406");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_99, _function_99);AppFunction appFunction_100=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_100 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.warehouse");
          it.setFunctionId("com.fudanmed.platform.core.web.transferRecordListPresenter");
          it.setName("\u8C03\u62E8\u7BA1\u7406");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_100, _function_100);AppFunction appFunction_101=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_101 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.warehouse");
          it.setFunctionId("com.fudanmed.platform.core.web.workItemStockRecordManagementPresenter");
          it.setName("\u9886\u6599/\u9000\u6599\u5355\u67E5\u8BE2");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_101, _function_101);AppFunction appFunction_102=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_102 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.warehouse");
          it.setFunctionId("com.fudanmed.platform.core.web.settlementListPresenter");
          it.setName("\u7ED3\u7B97\u7BA1\u7406");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_102, _function_102);AppFunction appFunction_103=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_103 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.warehouse");
          it.setFunctionId("com.fudanmed.platform.core.web.stockTakingListListPresenter");
          it.setName("\u76D8\u70B9\u7BA1\u7406");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_103, _function_103);AppFunction appFunction_104=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_104 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.warehouse");
          it.setFunctionId("com.fudanmed.platform.core.web.stockTakingRecordListPresenter");
          it.setName("\u76D8\u70B9\u7BA1\u7406");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_104, _function_104);
  }
  
  @Autowired
  private UpdateServie updateService;
  
  public void doUpgrade() {
    if (updateService.canPerformUpdate("Initialize", "V_0_0", "initAdmin")) {
    	initAdmin();
    	updateService.updaterCommited("Initialize", "V_0_0", "initAdmin");
    }
    if (updateService.canPerformUpdate("Initialize", "V_0_0", "initOrgzniation")) {
    	initOrgzniation();
    	updateService.updaterCommited("Initialize", "V_0_0", "initOrgzniation");
    }
    if (updateService.canPerformUpdate("Initialize", "V_0_0", "initStore")) {
    	initStore();
    	updateService.updaterCommited("Initialize", "V_0_0", "initStore");
    }
    if (updateService.canPerformUpdate("Initialize", "V_0_0", "initCodes")) {
    	initCodes();
    	updateService.updaterCommited("Initialize", "V_0_0", "initCodes");
    }
    if (updateService.canPerformUpdate("Initialize", "V_0_0", "initFrameworkFunctions")) {
    	initFrameworkFunctions();
    	updateService.updaterCommited("Initialize", "V_0_0", "initFrameworkFunctions");
    }
    if (updateService.canPerformUpdate("Initialize", "V_0_0", "initApplicationFunctions")) {
    	initApplicationFunctions();
    	updateService.updaterCommited("Initialize", "V_0_0", "initApplicationFunctions");
    }
    updateService.upgraderCommited("V_0_0", "V_0_1");
  }
}
