package com.fudanmed.platform.core.web.client.app;

import com.fudanmed.platform.core.web.client.app.resource.MedImages;
import com.fudanmed.platform.core.web.client.device.DeviceManagementPresenter;
import com.fudanmed.platform.core.web.client.device.DevicePMSpecificationManagementPresenter;
import com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryManagementPresenter;
import com.fudanmed.platform.core.web.client.device.NumberWithUnitTypeManagementPresenter;
import com.fudanmed.platform.core.web.client.device.PMTeamWorkItemManagementPresenter;
import com.fudanmed.platform.core.web.client.device.PMWorkItemManagementPresenter;
import com.fudanmed.platform.core.web.client.organization.ChangePasswdPresenter;
import com.fudanmed.platform.core.web.client.organization.EmployeeManagementPresenter;
import com.fudanmed.platform.core.web.client.organization.FaultLevelColorAdaptorListPresenter;
import com.fudanmed.platform.core.web.client.organization.OnsitePositionManagementPresenter;
import com.fudanmed.platform.core.web.client.organization.OrganizationManagementPresenter;
import com.fudanmed.platform.core.web.client.organization.SupplierManagementPresenter;
import com.fudanmed.platform.core.web.client.project.EBoardPresenter;
import com.fudanmed.platform.core.web.client.project.GroupTaskManagementPresenter;
import com.fudanmed.platform.core.web.client.project.GroupTaskStatByTeamCommand;
import com.fudanmed.platform.core.web.client.project.MaintenamceTypeManagementPresenter;
import com.fudanmed.platform.core.web.client.project.MaintenanceTeamManagementPresenter;
import com.fudanmed.platform.core.web.client.project.RepairTaskManagementPresenter;
import com.fudanmed.platform.core.web.client.project.RepairTaskStatByMonthCommand;
import com.fudanmed.platform.core.web.client.project.RepairTaskStatisticListPresenter;
import com.fudanmed.platform.core.web.client.project.ReportManagementPresenter;
import com.fudanmed.platform.core.web.client.project.SettlementListPresenter;
import com.fudanmed.platform.core.web.client.project.WorkItemStockStatisticListPresenter;
import com.fudanmed.platform.core.web.client.warehouse.InStockRecordListPresenter;
import com.fudanmed.platform.core.web.client.warehouse.OutStockRecordListPresenter;
import com.fudanmed.platform.core.web.client.warehouse.ProductCategoryManagementPresenter;
import com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationManagementPresenter;
import com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStorageSummaryManagementPresenter;
import com.fudanmed.platform.core.web.client.warehouse.StockTakingListListPresenter;
import com.fudanmed.platform.core.web.client.warehouse.TransferRecordListPresenter;
import com.fudanmed.platform.core.web.client.warehouse.WarehouseManagementPresenter;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemStockRecordManagementPresenter;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemTaskManagementPresenter;
import com.fudanmed.platform.core.web.client.workbench.HeaderPresenter;
import com.fudanmed.platform.core.web.client.workbench.SystemParameterPresenter;
import com.google.gwt.resources.client.ImageResource;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.Presenter;
import edu.fudan.langlab.uidl.domain.app.client.WorkbenchCategoryImpl;
import edu.fudan.langlab.uidl.domain.app.client.WorkbenchManager;
import edu.fudan.langlab.uidl.domain.app.client.security.RoleFunctionAssignmentPresenter;
import edu.fudan.langlab.uidl.domain.app.client.security.RoleManagementPresenter;
import edu.fudan.langlab.uidl.domain.code.client.web.CodeManagementPresenter;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class UIWorkbenchPartRegister {
  @Inject
  private WorkbenchManager workbenchManager;
  
  @Inject
  private Provider<CodeManagementPresenter> codeManagerPresenter;
  
  @Inject
  private Provider<EmployeeManagementPresenter> employeeManagementPresenter;
  
  @Inject
  private Provider<SupplierManagementPresenter> supplierManagementPresenter;
  
  @Inject
  private Provider<MaintenamceTypeManagementPresenter> maintenamceTypeManagerPresenter;
  
  @Inject
  private Provider<OnsitePositionManagementPresenter> onsitePositionManagementPresenter;
  
  @Inject
  private Provider<OrganizationManagementPresenter> organizationManagementPresenter;
  
  @Inject
  private Provider<MaintenanceTeamManagementPresenter> maintenanceTeamManagementPresenter;
  
  @Inject
  private Provider<RepairTaskManagementPresenter> repairReportManagementPresenter;
  
  @Inject
  private Provider<GroupTaskManagementPresenter> groupTaskManagementPresenter;
  
  @Inject
  private Provider<WarehouseManagementPresenter> warehouseManagementPresenter;
  
  @Inject
  private Provider<ProductSpecificationManagementPresenter> productSpecificationManagementPresenter;
  
  @Inject
  private Provider<InStockRecordListPresenter> inStockRecordListPresenter;
  
  @Inject
  private Provider<TransferRecordListPresenter> transferRecordListPresenter;
  
  @Inject
  private Provider<ProductCategoryManagementPresenter> productCategoryManagementPresenter;
  
  @Inject
  private Provider<WorkItemStockRecordManagementPresenter> workItemStockRecordManagementPresenter;
  
  @Inject
  private Provider<WorkItemTaskManagementPresenter> workItemTaskManagementPresenter;
  
  @Inject
  private Provider<ProductWarehouseStorageSummaryManagementPresenter> productWarehouseStorageSummaryManagementPresenter;
  
  @Inject
  private Provider<RoleManagementPresenter> roleManagementPresenter;
  
  @Inject
  private Provider<RoleFunctionAssignmentPresenter> roleFunctionAssignmentPresenter;
  
  @Inject
  private Provider<SystemParameterPresenter> systemParameterPresenter;
  
  @Inject
  private Provider<ReportManagementPresenter> reportManagementPresenter;
  
  @Inject
  private Provider<SettlementListPresenter> settlementListPresenter;
  
  @Inject
  private Provider<OutStockRecordListPresenter> outStockRecordListPresenter;
  
  @Inject
  private Provider<StockTakingListListPresenter> stockTakingListListPresenter;
  
  @Inject
  private Provider<DeviceManagementPresenter> deviceManagementPresenter;
  
  @Inject
  private Provider<DeviceTypeCategoryManagementPresenter> deviceTypeCategoryManagementPresenter;
  
  @Inject
  private Provider<NumberWithUnitTypeManagementPresenter> numberWithUnitTypeManagementPresenter;
  
  @Inject
  private Provider<DevicePMSpecificationManagementPresenter> devicePMSpecificationManagementPresenter;
  
  @Inject
  private Provider<PMWorkItemManagementPresenter> pmWorkItemManagementPresenter;
  
  @Inject
  private Provider<PMTeamWorkItemManagementPresenter> pmTeamWorkItemManagementPresenter;
  
  @Inject
  private Provider<ChangePasswdPresenter> changePasswdPresenter;
  
  @Inject
  private Provider<FaultLevelColorAdaptorListPresenter> faultLevelColorAdaptorListPresenter;
  
  @Inject
  private Provider<RepairTaskStatisticListPresenter> repairTaskStatisticListPresenter;
  
  @Inject
  private Provider<WorkItemStockStatisticListPresenter> workItemStockStatisticListPresenter;
  
  @Inject
  private Provider<EBoardPresenter> eboardPresenter;
  
  @Inject
  private GroupTaskStatByTeamCommand groupTaskStatByTeamCommand;
  
  @Inject
  private RepairTaskStatByMonthCommand repairTaskStatByMonthCommand;
  
  @Inject
  private HeaderPresenter headerPresenter;
  
  public void initialize() {
    ImageResource _nav1 = MedImages.INSTANCE.nav1();
    WorkbenchCategoryImpl _workbenchCategoryImpl = new WorkbenchCategoryImpl("com.fudanmed.platform.core.web.basic", "\u57FA\u7840\u6570\u636E\u7EF4\u62A4", _nav1);
    this.workbenchManager.registerPresenterCategory(_workbenchCategoryImpl);
    ImageResource _nav2 = MedImages.INSTANCE.nav2();
    WorkbenchCategoryImpl _workbenchCategoryImpl_1 = new WorkbenchCategoryImpl("com.fudanmed.platform.core.web.project", "\u8BBE\u5907\u5DE5\u7A0B\u6570\u636E\u7EF4\u62A4", _nav2);
    this.workbenchManager.registerPresenterCategory(_workbenchCategoryImpl_1);
    ImageResource _nav3 = MedImages.INSTANCE.nav3();
    WorkbenchCategoryImpl _workbenchCategoryImpl_2 = new WorkbenchCategoryImpl("com.fudanmed.platform.core.web.process", "\u5DE5\u7A0B\u65E5\u5E38\u4E1A\u52A1", _nav3);
    this.workbenchManager.registerPresenterCategory(_workbenchCategoryImpl_2);
    ImageResource _nav3_1 = MedImages.INSTANCE.nav3();
    WorkbenchCategoryImpl _workbenchCategoryImpl_3 = new WorkbenchCategoryImpl("com.fudanmed.platform.core.web.department", "\u79D1\u5BA4\u65E5\u5E38\u4E1A\u52A1", _nav3_1);
    this.workbenchManager.registerPresenterCategory(_workbenchCategoryImpl_3);
    ImageResource _nav4 = MedImages.INSTANCE.nav4();
    WorkbenchCategoryImpl _workbenchCategoryImpl_4 = new WorkbenchCategoryImpl("com.fudanmed.platform.core.web.warehousecore", "\u5DE5\u7A0B\u4ED3\u5E93\u6570\u636E\u7EF4\u62A4", _nav4);
    this.workbenchManager.registerPresenterCategory(_workbenchCategoryImpl_4);
    ImageResource _nav5 = MedImages.INSTANCE.nav5();
    WorkbenchCategoryImpl _workbenchCategoryImpl_5 = new WorkbenchCategoryImpl("com.fudanmed.platform.core.web.warehouse", "\u5DE5\u7A0B\u4ED3\u5E93\u7BA1\u7406", _nav5);
    this.workbenchManager.registerPresenterCategory(_workbenchCategoryImpl_5);
    ImageResource _nav5_1 = MedImages.INSTANCE.nav5();
    WorkbenchCategoryImpl _workbenchCategoryImpl_6 = new WorkbenchCategoryImpl("com.fudanmed.platform.core.web.device", "\u8BBE\u5907\u53F0\u8D26\u7BA1\u7406", _nav5_1);
    this.workbenchManager.registerPresenterCategory(_workbenchCategoryImpl_6);
    ImageResource _nav5_2 = MedImages.INSTANCE.nav5();
    WorkbenchCategoryImpl _workbenchCategoryImpl_7 = new WorkbenchCategoryImpl("com.fudanmed.platform.core.web.pm", "PM\u7BA1\u7406", _nav5_2);
    this.workbenchManager.registerPresenterCategory(_workbenchCategoryImpl_7);
    ImageResource _nav5_3 = MedImages.INSTANCE.nav5();
    WorkbenchCategoryImpl _workbenchCategoryImpl_8 = new WorkbenchCategoryImpl("com.fudanmed.platform.core.web.statistics", "\u7EDF\u8BA1\u67E5\u8BE2", _nav5_3);
    final WorkbenchCategoryImpl statCategory = _workbenchCategoryImpl_8;
    this.workbenchManager.registerPresenterCategory(statCategory);
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.basic", 
      "edu.fudan.langlab.uidl.domain.app.codeManagementPresenter", 
      this.codeManagerPresenter, 
      "\u57FA\u7840\u4EE3\u7801\u7EF4\u62A4");
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          OnsitePositionManagementPresenter _get = UIWorkbenchPartRegister.this.onsitePositionManagementPresenter.get();
          final Procedure1<OnsitePositionManagementPresenter> _function = new Procedure1<OnsitePositionManagementPresenter>() {
              public void apply(final OnsitePositionManagementPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(_function);
        }
      };
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.basic", 
      "com.fudanmed.platform.core.web.onsitePositionManagementPresenter", _function, 
      "\u533A\u57DF\u4F4D\u7F6E\u7EF4\u62A4");
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function_1 = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          OrganizationManagementPresenter _get = UIWorkbenchPartRegister.this.organizationManagementPresenter.get();
          final Procedure1<OrganizationManagementPresenter> _function = new Procedure1<OrganizationManagementPresenter>() {
              public void apply(final OrganizationManagementPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(_function);
        }
      };
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.basic", 
      "com.fudanmed.platform.core.web.organizationManagementPresenter", _function_1, 
      "\u7EC4\u7EC7\u673A\u6784\u7EF4\u62A4");
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.basic", 
      "com.fudanmed.platform.core.web.employeeManagementPresenter", 
      this.employeeManagementPresenter, 
      "\u5458\u5DE5\u7EF4\u62A4");
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.basic", 
      "com.fudanmed.platform.core.web.supplierManagementPresenter", 
      this.supplierManagementPresenter, 
      "\u4F9B\u5E94\u5546\u7EF4\u62A4");
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function_2 = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          RoleManagementPresenter _get = UIWorkbenchPartRegister.this.roleManagementPresenter.get();
          final Procedure1<RoleManagementPresenter> _function = new Procedure1<RoleManagementPresenter>() {
              public void apply(final RoleManagementPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(_function);
        }
      };
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.basic", 
      "edu.fudan.langlab.uidl.domain.app.roleManagementPresenter", _function_2, 
      "\u7CFB\u7EDF\u89D2\u8272\u7EF4\u62A4");
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function_3 = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          RoleFunctionAssignmentPresenter _get = UIWorkbenchPartRegister.this.roleFunctionAssignmentPresenter.get();
          final Procedure1<RoleFunctionAssignmentPresenter> _function = new Procedure1<RoleFunctionAssignmentPresenter>() {
              public void apply(final RoleFunctionAssignmentPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(_function);
        }
      };
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.basic", 
      "edu.fudan.langlab.uidl.domain.app.roleFunctionAssignmentPresenter", _function_3, 
      "\u7CFB\u7EDF\u529F\u80FD\u6743\u9650\u8BBE\u7F6E");
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function_4 = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          SystemParameterPresenter _get = UIWorkbenchPartRegister.this.systemParameterPresenter.get();
          final Procedure1<SystemParameterPresenter> _function = new Procedure1<SystemParameterPresenter>() {
              public void apply(final SystemParameterPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(_function);
        }
      };
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.basic", 
      "edu.fudan.langlab.uidl.domain.app.systemParameterPresenter", _function_4, 
      "\u7CFB\u7EDF\u53C2\u6570\u8BBE\u7F6E");
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function_5 = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          FaultLevelColorAdaptorListPresenter _get = UIWorkbenchPartRegister.this.faultLevelColorAdaptorListPresenter.get();
          final Procedure1<FaultLevelColorAdaptorListPresenter> _function = new Procedure1<FaultLevelColorAdaptorListPresenter>() {
              public void apply(final FaultLevelColorAdaptorListPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(new IPresenterInitiazerNotifier<FaultLevelColorAdaptorListPresenter>() {
              public void done(FaultLevelColorAdaptorListPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.basic", 
      "edu.fudan.langlab.uidl.domain.app.faultLevelColorAdaptorListPresenter", _function_5, 
      "\u98CE\u9669\u7B49\u7EA7\u989C\u8272\u8BBE\u7F6E");
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function_6 = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          ChangePasswdPresenter _get = UIWorkbenchPartRegister.this.changePasswdPresenter.get();
          final Procedure1<ChangePasswdPresenter> _function = new Procedure1<ChangePasswdPresenter>() {
              public void apply(final ChangePasswdPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(new IPresenterInitiazerNotifier<ChangePasswdPresenter>() {
              public void done(ChangePasswdPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    this.workbenchManager.registerDialogProxy(
      "com.fudanmed.platform.core.web.basic", 
      "edu.fudan.langlab.uidl.domain.app.changePasswdPresenter", _function_6, 
      "\u4FEE\u6539\u5BC6\u7801");
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function_7 = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          EBoardPresenter _get = UIWorkbenchPartRegister.this.eboardPresenter.get();
          final Procedure1<EBoardPresenter> _function = new Procedure1<EBoardPresenter>() {
              public void apply(final EBoardPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(new IPresenterInitiazerNotifier<EBoardPresenter>() {
              public void done(EBoardPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    this.workbenchManager.registerDialogProxy(
      "com.fudanmed.platform.core.web.basic", 
      "edu.fudan.langlab.uidl.domain.app.eboardPresenter", _function_7, 
      "\u7535\u5B50\u5C4F");
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function_8 = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          MaintenamceTypeManagementPresenter _get = UIWorkbenchPartRegister.this.maintenamceTypeManagerPresenter.get();
          final Procedure1<MaintenamceTypeManagementPresenter> _function = new Procedure1<MaintenamceTypeManagementPresenter>() {
              public void apply(final MaintenamceTypeManagementPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(_function);
        }
      };
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.project", 
      "com.fudanmed.platform.core.web.maintenanceTypeManagerPresenter", _function_8, 
      "\u7EF4\u4FEE\u7C7B\u522B\u7EF4\u62A4");
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function_9 = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          MaintenanceTeamManagementPresenter _get = UIWorkbenchPartRegister.this.maintenanceTeamManagementPresenter.get();
          final Procedure1<MaintenanceTeamManagementPresenter> _function = new Procedure1<MaintenanceTeamManagementPresenter>() {
              public void apply(final MaintenanceTeamManagementPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(_function);
        }
      };
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.project", 
      "com.fudanmed.platform.core.web.maintenanceTeamManagementPresenter", _function_9, 
      "\u7EF4\u4FEE\u73ED\u7EC4\u8BBE\u7F6E");
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function_10 = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          RepairTaskManagementPresenter _get = UIWorkbenchPartRegister.this.repairReportManagementPresenter.get();
          final Procedure1<RepairTaskManagementPresenter> _function = new Procedure1<RepairTaskManagementPresenter>() {
              public void apply(final RepairTaskManagementPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(new IPresenterInitiazerNotifier<RepairTaskManagementPresenter>() {
              public void done(RepairTaskManagementPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.process", 
      "com.fudanmed.platform.core.web.repairReportManagementPresenter", _function_10, "\u8C03\u5EA6\u5DE5\u4F5C\u53F0");
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function_11 = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          GroupTaskManagementPresenter _get = UIWorkbenchPartRegister.this.groupTaskManagementPresenter.get();
          final Procedure1<GroupTaskManagementPresenter> _function = new Procedure1<GroupTaskManagementPresenter>() {
              public void apply(final GroupTaskManagementPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(new IPresenterInitiazerNotifier<GroupTaskManagementPresenter>() {
              public void done(GroupTaskManagementPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.process", 
      "com.fudanmed.platform.core.web.groupTaskManagementPresenter", _function_11, "\u73ED\u7EC4\u62A5\u4FEE\u5DE5\u4F5C\u53F0");
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function_12 = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          PMTeamWorkItemManagementPresenter _get = UIWorkbenchPartRegister.this.pmTeamWorkItemManagementPresenter.get();
          final Procedure1<PMTeamWorkItemManagementPresenter> _function = new Procedure1<PMTeamWorkItemManagementPresenter>() {
              public void apply(final PMTeamWorkItemManagementPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(new IPresenterInitiazerNotifier<PMTeamWorkItemManagementPresenter>() {
              public void done(PMTeamWorkItemManagementPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.process", 
      "com.fudanmed.platform.core.web.pmTeamWorkItemManagementPresenter", _function_12, "\u73ED\u7EC4PM\u5DE5\u4F5C\u53F0");
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function_13 = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          ReportManagementPresenter _get = UIWorkbenchPartRegister.this.reportManagementPresenter.get();
          final Procedure1<ReportManagementPresenter> _function = new Procedure1<ReportManagementPresenter>() {
              public void apply(final ReportManagementPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(_function);
        }
      };
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.department", 
      "com.fudanmed.platform.core.web.reportManagementPresenter", _function_13, "\u79D1\u5BA4\u62A5\u4FEE\u5DE5\u4F5C\u53F0");
    this.workbenchManager.registerHeaderPresenter(this.headerPresenter);
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function_14 = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          ProductCategoryManagementPresenter _get = UIWorkbenchPartRegister.this.productCategoryManagementPresenter.get();
          final Procedure1<ProductCategoryManagementPresenter> _function = new Procedure1<ProductCategoryManagementPresenter>() {
              public void apply(final ProductCategoryManagementPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(_function);
        }
      };
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.warehousecore", 
      "com.fudanmed.platform.core.web.productCategoryManagementPresenter", _function_14, 
      "\u7269\u54C1\u7C7B\u522B\u4FE1\u606F\u7EF4\u62A4");
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function_15 = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          ProductSpecificationManagementPresenter _get = UIWorkbenchPartRegister.this.productSpecificationManagementPresenter.get();
          final Procedure1<ProductSpecificationManagementPresenter> _function = new Procedure1<ProductSpecificationManagementPresenter>() {
              public void apply(final ProductSpecificationManagementPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(_function);
        }
      };
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.warehousecore", 
      "com.fudanmed.platform.core.web.productSpecificationManagementPresenter", _function_15, 
      "\u7269\u54C1\u4FE1\u606F\u7EF4\u62A4");
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function_16 = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          WarehouseManagementPresenter _get = UIWorkbenchPartRegister.this.warehouseManagementPresenter.get();
          final Procedure1<WarehouseManagementPresenter> _function = new Procedure1<WarehouseManagementPresenter>() {
              public void apply(final WarehouseManagementPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(_function);
        }
      };
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.warehousecore", 
      "com.fudanmed.platform.core.web.warehouseManagementPresenter", _function_16, 
      "\u4ED3\u5E93\u4FE1\u606F\u7EF4\u62A4");
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function_17 = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          ProductWarehouseStorageSummaryManagementPresenter _get = UIWorkbenchPartRegister.this.productWarehouseStorageSummaryManagementPresenter.get();
          final Procedure1<ProductWarehouseStorageSummaryManagementPresenter> _function = new Procedure1<ProductWarehouseStorageSummaryManagementPresenter>() {
              public void apply(final ProductWarehouseStorageSummaryManagementPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(_function);
        }
      };
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.warehouse", 
      "com.fudanmed.platform.core.web.productWarehouseStorageSummaryManagementPresenter", _function_17, "\u5E93\u5B58\u53F0\u5E10");
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function_18 = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          InStockRecordListPresenter _get = UIWorkbenchPartRegister.this.inStockRecordListPresenter.get();
          final Procedure1<InStockRecordListPresenter> _function = new Procedure1<InStockRecordListPresenter>() {
              public void apply(final InStockRecordListPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(_function);
        }
      };
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.warehouse", 
      "com.fudanmed.platform.core.web.inStockRecordListPresenter", _function_18, 
      "\u5165\u5E93\u7BA1\u7406");
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function_19 = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          OutStockRecordListPresenter _get = UIWorkbenchPartRegister.this.outStockRecordListPresenter.get();
          final Procedure1<OutStockRecordListPresenter> _function = new Procedure1<OutStockRecordListPresenter>() {
              public void apply(final OutStockRecordListPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(_function);
        }
      };
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.warehouse", 
      "com.fudanmed.platform.core.web.outStockRecordListPresenter", _function_19, 
      "\u51FA\u5E93\u7BA1\u7406");
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function_20 = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          TransferRecordListPresenter _get = UIWorkbenchPartRegister.this.transferRecordListPresenter.get();
          final Procedure1<TransferRecordListPresenter> _function = new Procedure1<TransferRecordListPresenter>() {
              public void apply(final TransferRecordListPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(_function);
        }
      };
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.warehouse", 
      "com.fudanmed.platform.core.web.transferRecordListPresenter", _function_20, 
      "\u8C03\u62E8\u7BA1\u7406");
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function_21 = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          WorkItemTaskManagementPresenter _get = UIWorkbenchPartRegister.this.workItemTaskManagementPresenter.get();
          final Procedure1<WorkItemTaskManagementPresenter> _function = new Procedure1<WorkItemTaskManagementPresenter>() {
              public void apply(final WorkItemTaskManagementPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(_function);
        }
      };
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.warehouse", 
      "com.fudanmed.platform.core.web.workItemTaskManagementPresenter", _function_21, 
      "\u5DE5\u5355\u9886/\u9000\u6599");
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function_22 = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          WorkItemStockRecordManagementPresenter _get = UIWorkbenchPartRegister.this.workItemStockRecordManagementPresenter.get();
          final Procedure1<WorkItemStockRecordManagementPresenter> _function = new Procedure1<WorkItemStockRecordManagementPresenter>() {
              public void apply(final WorkItemStockRecordManagementPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(_function);
        }
      };
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.warehouse", 
      "com.fudanmed.platform.core.web.workItemStockRecordManagementPresenter", _function_22, 
      "\u9886/\u9000\u6599\u5355\u67E5\u8BE2");
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function_23 = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          SettlementListPresenter _get = UIWorkbenchPartRegister.this.settlementListPresenter.get();
          final Procedure1<SettlementListPresenter> _function = new Procedure1<SettlementListPresenter>() {
              public void apply(final SettlementListPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(_function);
        }
      };
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.warehouse", 
      "com.fudanmed.platform.core.web.settlementListPresenter", _function_23, 
      "\u7ED3\u7B97\u7BA1\u7406");
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function_24 = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          StockTakingListListPresenter _get = UIWorkbenchPartRegister.this.stockTakingListListPresenter.get();
          final Procedure1<StockTakingListListPresenter> _function = new Procedure1<StockTakingListListPresenter>() {
              public void apply(final StockTakingListListPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(_function);
        }
      };
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.warehouse", 
      "com.fudanmed.platform.core.web.stockTakingListListPresenter", _function_24, 
      "\u76D8\u70B9\u7BA1\u7406");
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function_25 = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          DeviceManagementPresenter _get = UIWorkbenchPartRegister.this.deviceManagementPresenter.get();
          final Procedure1<DeviceManagementPresenter> _function = new Procedure1<DeviceManagementPresenter>() {
              public void apply(final DeviceManagementPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(new IPresenterInitiazerNotifier<DeviceManagementPresenter>() {
              public void done(DeviceManagementPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.device", 
      "com.fudanmed.platform.core.web.deviceManagementPresenter", _function_25, 
      "\u8BBE\u5907\u7BA1\u7406");
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function_26 = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          DeviceTypeCategoryManagementPresenter _get = UIWorkbenchPartRegister.this.deviceTypeCategoryManagementPresenter.get();
          final Procedure1<DeviceTypeCategoryManagementPresenter> _function = new Procedure1<DeviceTypeCategoryManagementPresenter>() {
              public void apply(final DeviceTypeCategoryManagementPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(_function);
        }
      };
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.device", 
      "com.fudanmed.platform.core.web.deviceTypeCategoryManagementPresenter", _function_26, 
      "\u8BBE\u5907\u7C7B\u578B\u7BA1\u7406");
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function_27 = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          NumberWithUnitTypeManagementPresenter _get = UIWorkbenchPartRegister.this.numberWithUnitTypeManagementPresenter.get();
          final Procedure1<NumberWithUnitTypeManagementPresenter> _function = new Procedure1<NumberWithUnitTypeManagementPresenter>() {
              public void apply(final NumberWithUnitTypeManagementPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(new IPresenterInitiazerNotifier<NumberWithUnitTypeManagementPresenter>() {
              public void done(NumberWithUnitTypeManagementPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.device", 
      "com.fudanmed.platform.core.web.numberWithUnitTypeManagementPresenter", _function_27, 
      "\u53C2\u6570\u7C7B\u578B\u7BA1\u7406");
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function_28 = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          DevicePMSpecificationManagementPresenter _get = UIWorkbenchPartRegister.this.devicePMSpecificationManagementPresenter.get();
          final Procedure1<DevicePMSpecificationManagementPresenter> _function = new Procedure1<DevicePMSpecificationManagementPresenter>() {
              public void apply(final DevicePMSpecificationManagementPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(new IPresenterInitiazerNotifier<DevicePMSpecificationManagementPresenter>() {
              public void done(DevicePMSpecificationManagementPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.pm", 
      "com.fudanmed.platform.core.web.devicePMSpecificationManagementPresenter", _function_28, 
      "PM\u8BA1\u5212\u7BA1\u7406");
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function_29 = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          PMWorkItemManagementPresenter _get = UIWorkbenchPartRegister.this.pmWorkItemManagementPresenter.get();
          final Procedure1<PMWorkItemManagementPresenter> _function = new Procedure1<PMWorkItemManagementPresenter>() {
              public void apply(final PMWorkItemManagementPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(new IPresenterInitiazerNotifier<PMWorkItemManagementPresenter>() {
              public void done(PMWorkItemManagementPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.pm", 
      "com.fudanmed.platform.core.web.pmWorkItemManagementPresenter", _function_29, 
      "PM\u4EFB\u52A1\u7BA1\u7406");
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function_30 = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          RepairTaskStatisticListPresenter _get = UIWorkbenchPartRegister.this.repairTaskStatisticListPresenter.get();
          final Procedure1<RepairTaskStatisticListPresenter> _function = new Procedure1<RepairTaskStatisticListPresenter>() {
              public void apply(final RepairTaskStatisticListPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(new IPresenterInitiazerNotifier<RepairTaskStatisticListPresenter>() {
              public void done(RepairTaskStatisticListPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.statistics", 
      "com.fudanmed.platform.core.web.repairTaskStatisticListPresenter", _function_30, 
      "\u62A5\u4FEE\u5355\u7EDF\u8BA1\u8868");
    final Procedure1<Procedure1<? super Presenter<? extends Object>>> _function_31 = new Procedure1<Procedure1<? super Presenter<? extends Object>>>() {
        public void apply(final Procedure1<? super Presenter<? extends Object>> init) {
          WorkItemStockStatisticListPresenter _get = UIWorkbenchPartRegister.this.workItemStockStatisticListPresenter.get();
          final Procedure1<WorkItemStockStatisticListPresenter> _function = new Procedure1<WorkItemStockStatisticListPresenter>() {
              public void apply(final WorkItemStockStatisticListPresenter it) {
                init.apply(it);
              }
            };
          _get.setup(new IPresenterInitiazerNotifier<WorkItemStockStatisticListPresenter>() {
              public void done(WorkItemStockStatisticListPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    this.workbenchManager.registerPresenterProxy(
      "com.fudanmed.platform.core.web.statistics", 
      "com.fudanmed.platform.core.web.workItemStockStatisticListPresenter", _function_31, 
      "\u62A5\u4FEE\u5355\u7528\u6599\u7EDF\u8BA1\u8868");
    this.workbenchManager.registerCommand(statCategory, this.groupTaskStatByTeamCommand);
    this.workbenchManager.registerCommand(statCategory, this.repairTaskStatByMonthCommand);
  }
}
