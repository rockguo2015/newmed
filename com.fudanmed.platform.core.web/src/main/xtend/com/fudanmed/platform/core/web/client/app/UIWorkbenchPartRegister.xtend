package com.fudanmed.platform.core.web.client.app

import com.fudanmed.platform.core.web.client.app.resource.MedImages
import com.fudanmed.platform.core.web.client.device.DeviceManagementPresenter
import com.fudanmed.platform.core.web.client.device.DevicePMSpecificationManagementPresenter
import com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryManagementPresenter
import com.fudanmed.platform.core.web.client.device.NumberWithUnitTypeManagementPresenter
import com.fudanmed.platform.core.web.client.device.PMTeamWorkItemManagementPresenter
import com.fudanmed.platform.core.web.client.device.PMWorkItemManagementPresenter
import com.fudanmed.platform.core.web.client.organization.ChangePasswdPresenter
import com.fudanmed.platform.core.web.client.organization.EmployeeManagementPresenter
import com.fudanmed.platform.core.web.client.organization.FaultLevelColorAdaptorListPresenter
import com.fudanmed.platform.core.web.client.organization.OnsitePositionManagementPresenter
import com.fudanmed.platform.core.web.client.organization.OrganizationManagementPresenter
import com.fudanmed.platform.core.web.client.organization.SupplierManagementPresenter
import com.fudanmed.platform.core.web.client.project.EBoardPresenter
import com.fudanmed.platform.core.web.client.project.GroupTaskManagementPresenter
import com.fudanmed.platform.core.web.client.project.MaintenamceTypeManagementPresenter
import com.fudanmed.platform.core.web.client.project.MaintenanceTeamManagementPresenter
import com.fudanmed.platform.core.web.client.project.RepairTaskManagementPresenter
import com.fudanmed.platform.core.web.client.project.RepairTaskStatisticListPresenter
import com.fudanmed.platform.core.web.client.project.ReportManagementPresenter
import com.fudanmed.platform.core.web.client.project.SettlementListPresenter
import com.fudanmed.platform.core.web.client.project.WorkItemStockStatisticListPresenter
import com.fudanmed.platform.core.web.client.warehouse.InStockRecordListPresenter
import com.fudanmed.platform.core.web.client.warehouse.OutStockRecordListPresenter
import com.fudanmed.platform.core.web.client.warehouse.ProductCategoryManagementPresenter
import com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationManagementPresenter
import com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStorageSummaryManagementPresenter
import com.fudanmed.platform.core.web.client.warehouse.StockTakingListListPresenter
import com.fudanmed.platform.core.web.client.warehouse.TransferRecordListPresenter
import com.fudanmed.platform.core.web.client.warehouse.WarehouseManagementPresenter
import com.fudanmed.platform.core.web.client.warehouse.WorkItemStockRecordManagementPresenter
import com.fudanmed.platform.core.web.client.warehouse.WorkItemTaskManagementPresenter
import com.fudanmed.platform.core.web.client.workbench.HeaderPresenter
import com.fudanmed.platform.core.web.client.workbench.SystemParameterPresenter
import com.google.inject.Inject
import com.google.inject.Provider
import edu.fudan.langlab.uidl.domain.app.client.WorkbenchCategoryImpl
import edu.fudan.langlab.uidl.domain.app.client.WorkbenchManager
import edu.fudan.langlab.uidl.domain.app.client.security.RoleFunctionAssignmentPresenter
import edu.fudan.langlab.uidl.domain.app.client.security.RoleManagementPresenter
import edu.fudan.langlab.uidl.domain.code.client.web.CodeManagementPresenter
import com.fudanmed.platform.core.web.client.project.GroupTaskStatByTeamCommand
import com.fudanmed.platform.core.web.client.project.RepairTaskStatByMonthCommand
import com.fudanmed.platform.core.web.client.project.RepairTaskStatByReportSourceCommand
import com.fudanmed.platform.core.web.client.measure.ShowMeasureDeviceManagementPresenterCommand
import com.fudanmed.platform.core.web.client.measure.ShowMeasureDeviceValueManagementPresenterCommand
import com.fudanmed.platform.core.web.client.project.UpdateEBoardMessageCommand
import com.fudanmed.platform.core.web.client.deliver.ShowDLTaskManagementCommand
import com.fudanmed.platform.core.web.client.deliver.ShowCenterlizedDeliverTaskManagementCommand
import com.fudanmed.platform.core.web.client.device.ShowDevicePMPlanCommand
import com.fudanmed.platform.core.web.client.deliver.ShowInHospitalLocationManagementCommand
import com.fudanmed.platform.core.web.client.deliver.ShowCheckOrganizationManagementCommand
import com.fudanmed.platform.core.web.client.deliver.ShowDeliverPatientCheckTypeManagementCommand
import com.fudanmed.platform.core.web.client.deliver.ShowDeliverMaterialCategoryManagementCommand
import com.fudanmed.platform.core.web.client.warehouse.ShowProductSummarySnapshotManagementCommand
import com.fudanmed.platform.core.web.client.deliver.CreateDeliverOrganizationCommand
import com.fudanmed.platform.core.web.client.deliver.ShowDeliverOrganizationManagementCommand

//import com.fudanmed.platform.core.web.client.organization.ShowTeacherManagementCommand

class UIWorkbenchPartRegister {
	@Inject WorkbenchManager workbenchManager
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
	private Provider<RoleFunctionAssignmentPresenter> roleFunctionAssignmentPresenter	
	@Inject
	private Provider<SystemParameterPresenter> systemParameterPresenter	
	@Inject
	private Provider<ReportManagementPresenter> reportManagementPresenter	
	@Inject
	private Provider<SettlementListPresenter> settlementListPresenter	
	@Inject
	private Provider<OutStockRecordListPresenter> outStockRecordListPresenter	
	@Inject
	private Provider<StockTakingListListPresenter> stockTakingListListPresenter	
	@Inject
	private Provider<DeviceManagementPresenter> deviceManagementPresenter	
	@Inject
	private Provider<DeviceTypeCategoryManagementPresenter> deviceTypeCategoryManagementPresenter	
	@Inject
	private Provider<NumberWithUnitTypeManagementPresenter> numberWithUnitTypeManagementPresenter	
	@Inject
	private Provider<DevicePMSpecificationManagementPresenter> devicePMSpecificationManagementPresenter	
	@Inject
	private Provider<PMWorkItemManagementPresenter> pmWorkItemManagementPresenter	
	@Inject
	private Provider<PMTeamWorkItemManagementPresenter> pmTeamWorkItemManagementPresenter
	@Inject
	private Provider<ChangePasswdPresenter> changePasswdPresenter
	@Inject
	private Provider<FaultLevelColorAdaptorListPresenter> faultLevelColorAdaptorListPresenter
	@Inject
	private Provider<RepairTaskStatisticListPresenter> repairTaskStatisticListPresenter
	@Inject
	private Provider<WorkItemStockStatisticListPresenter> workItemStockStatisticListPresenter
	@Inject
	private Provider<EBoardPresenter> eboardPresenter
	@Inject
	private GroupTaskStatByTeamCommand groupTaskStatByTeamCommand
	@Inject
	private RepairTaskStatByMonthCommand repairTaskStatByMonthCommand
	@Inject
	private RepairTaskStatByReportSourceCommand repairTaskStatByReportSourceCommand
	@Inject
	private ShowMeasureDeviceManagementPresenterCommand showMeasureDeviceManagementPresenterCommand
	@Inject
	private ShowMeasureDeviceValueManagementPresenterCommand showMeasureDeviceValueManagementPresenterCommand
	@Inject
	private UpdateEBoardMessageCommand updateEBoardMessageCommand
	@Inject
	private ShowDLTaskManagementCommand showDLTaskManagementCommand
	@Inject 
	private ShowCenterlizedDeliverTaskManagementCommand showCenterlizedDeliverTaskManagementCommand
	@Inject 
	private ShowDevicePMPlanCommand showDevicePMPlanCommand
	@Inject
	private ShowInHospitalLocationManagementCommand showInHospitalLocationManagementCommand
	@Inject
	private ShowCheckOrganizationManagementCommand showCheckOrganizationManagementCommand
	@Inject
	private ShowDeliverPatientCheckTypeManagementCommand showDeliverPatientCheckTypeManagementCommand
	@Inject
	private ShowDeliverMaterialCategoryManagementCommand showDeliverMaterialCategoryManagementCommand
	@Inject
	private ShowDeliverOrganizationManagementCommand showDeliverOrganizationManagementCommand
  @Inject
  private ShowProductSummarySnapshotManagementCommand showProductSummarySnapshotManagementCommand;
	
//	@Inject
//	private ShowTeacherManagementCommand showTeacherManagementCommand

	@Inject HeaderPresenter headerPresenter;
	def initialize(){
		val basic = new WorkbenchCategoryImpl("com.fudanmed.platform.core.web.basic","基础数据维护",MedImages::INSTANCE.nav1)
		workbenchManager.registerPresenterCategory(basic)
		workbenchManager.registerPresenterCategory(
			new WorkbenchCategoryImpl("com.fudanmed.platform.core.web.project","设备工程数据维护",MedImages::INSTANCE.nav2)
		)
		workbenchManager.registerPresenterCategory(
			new WorkbenchCategoryImpl("com.fudanmed.platform.core.web.process","工程日常业务",MedImages::INSTANCE.nav3)
		)
		workbenchManager.registerPresenterCategory(
			new WorkbenchCategoryImpl("com.fudanmed.platform.core.web.department","科室日常业务",MedImages::INSTANCE.nav3)
		)
		workbenchManager.registerPresenterCategory(
			new WorkbenchCategoryImpl("com.fudanmed.platform.core.web.warehousecore","工程仓库数据维护",MedImages::INSTANCE.nav4)
		)
		val warehouseCategory = new WorkbenchCategoryImpl("com.fudanmed.platform.core.web.warehouse","工程仓库管理",MedImages::INSTANCE.nav5)
		workbenchManager.registerPresenterCategory(warehouseCategory)
		workbenchManager.registerPresenterCategory(
			new WorkbenchCategoryImpl("com.fudanmed.platform.core.web.device","设备台账管理",MedImages::INSTANCE.nav5)
		)
		val pmCategory = new WorkbenchCategoryImpl("com.fudanmed.platform.core.web.pm","PM管理",MedImages::INSTANCE.nav5)
		workbenchManager.registerPresenterCategory(
			pmCategory
		)
		val statCategory = new WorkbenchCategoryImpl("com.fudanmed.platform.core.web.statistics","统计查询",MedImages::INSTANCE.nav5)
		workbenchManager.registerPresenterCategory(
			statCategory
		)
		val measureCategory = new WorkbenchCategoryImpl("com.fudanmed.platform.core.web.measure","抄表管理",MedImages::INSTANCE.nav5)
		workbenchManager.registerPresenterCategory(
			measureCategory
		)
		val deliverCategory = new WorkbenchCategoryImpl("com.fudanmed.platform.core.web.deliver","运送管理",MedImages::INSTANCE.nav3)
		workbenchManager.registerPresenterCategory(
			deliverCategory
		)
		
		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.basic",
			"edu.fudan.langlab.uidl.domain.app.codeManagementPresenter",
			codeManagerPresenter, 
			"基础代码维护"
		)
		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.basic",
			"com.fudanmed.platform.core.web.onsitePositionManagementPresenter",[
				init| onsitePositionManagementPresenter.get.setup[init.apply(it)]
			], 
			"区域位置维护"
		)
		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.basic",
			"com.fudanmed.platform.core.web.organizationManagementPresenter",[
				init| organizationManagementPresenter.get.setup[init.apply(it)]
			], 
			"组织机构维护"
		)
		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.basic",
			"com.fudanmed.platform.core.web.employeeManagementPresenter",
			employeeManagementPresenter, 
			"员工维护"
		)
		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.basic",
			"com.fudanmed.platform.core.web.supplierManagementPresenter",
			supplierManagementPresenter, 
			"供应商维护"
		)
		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.basic",
			"edu.fudan.langlab.uidl.domain.app.roleManagementPresenter",
			[
				init| roleManagementPresenter.get.setup[init.apply(it)]
			],
			"系统角色维护")
		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.basic",
			"edu.fudan.langlab.uidl.domain.app.roleFunctionAssignmentPresenter", 
			[
				init| roleFunctionAssignmentPresenter.get.setup[init.apply(it)]
			],
			"系统功能权限设置")
		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.basic",
			"edu.fudan.langlab.uidl.domain.app.systemParameterPresenter", 
			[
				init| systemParameterPresenter.get.setup[init.apply(it)]
			],
			"系统参数设置")
		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.basic",
			"edu.fudan.langlab.uidl.domain.app.faultLevelColorAdaptorListPresenter", 
			[
				init| faultLevelColorAdaptorListPresenter.get.setup[init.apply(it)]
			],
			"风险等级颜色设置")
		workbenchManager.registerDialogProxy(
			"com.fudanmed.platform.core.web.basic",
			"edu.fudan.langlab.uidl.domain.app.changePasswdPresenter", 
			[
				init| changePasswdPresenter.get.setup[init.apply(it)]
			],
			"修改密码")
		workbenchManager.registerDialogProxy(
			"com.fudanmed.platform.core.web.basic",
			"edu.fudan.langlab.uidl.domain.app.eboardPresenter", 
			[
				init| eboardPresenter.get.setup[init.apply(it)]
			],
			"电子屏")
		workbenchManager.registerCommand(basic,updateEBoardMessageCommand)


		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.project",
			"com.fudanmed.platform.core.web.maintenanceTypeManagerPresenter",[
				init| maintenamceTypeManagerPresenter.get.setup[init.apply(it)]
			], 
			"维修类别维护"
		)
		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.project",
			"com.fudanmed.platform.core.web.maintenanceTeamManagementPresenter",[
				init| maintenanceTeamManagementPresenter.get.setup[init.apply(it)]
			], 
			"维修班组设置"
		)
		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.process",
			"com.fudanmed.platform.core.web.repairReportManagementPresenter",[
				init| repairReportManagementPresenter.get.setup[init.apply(it)]
			], "调度工作台"
		)
		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.process",
			"com.fudanmed.platform.core.web.groupTaskManagementPresenter",[
				init| groupTaskManagementPresenter.get.setup[init.apply(it)]
			], "班组报修工作台"
		)
		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.process",
			"com.fudanmed.platform.core.web.pmTeamWorkItemManagementPresenter",[
				init| pmTeamWorkItemManagementPresenter.get.setup[init.apply(it)]
			], "班组PM工作台"
		)
		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.department",
			"com.fudanmed.platform.core.web.reportManagementPresenter",[
				init| reportManagementPresenter.get.setup[init.apply(it)]
			], "科室报修工作台"
		)
		workbenchManager.registerHeaderPresenter(headerPresenter)
		
		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.warehousecore",
			"com.fudanmed.platform.core.web.productCategoryManagementPresenter",[
				init| productCategoryManagementPresenter.get.setup[init.apply(it)]
			], 
			"物品类别信息维护"
		)
		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.warehousecore",
			"com.fudanmed.platform.core.web.productSpecificationManagementPresenter",[
				init| productSpecificationManagementPresenter.get.setup[init.apply(it)]
			], 
			"物品信息维护"
		)
		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.warehousecore",
			"com.fudanmed.platform.core.web.warehouseManagementPresenter",[
				init| warehouseManagementPresenter.get.setup[init.apply(it)]
			], 
			"仓库信息维护"
		)
//		workbenchManager.registerPresenterProxy("com.fudanmed.platform.core.web.warehouse",[
//			init| productWarehouseStorageManagementPresenter.get.setup[init.apply(it)]
//		], "仓库管理工作台")
		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.warehouse",
			"com.fudanmed.platform.core.web.productWarehouseStorageSummaryManagementPresenter",[
				init| productWarehouseStorageSummaryManagementPresenter.get.setup[init.apply(it)]
			], "库存台帐"
		)
		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.warehouse",
			"com.fudanmed.platform.core.web.inStockRecordListPresenter",[
				init| inStockRecordListPresenter.get.setup[init.apply(it)]
			], 
			"入库管理"
		)
		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.warehouse",
			"com.fudanmed.platform.core.web.outStockRecordListPresenter",[
				init| outStockRecordListPresenter.get.setup[init.apply(it)]
			], 
			"出库管理"
		)
		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.warehouse",
			"com.fudanmed.platform.core.web.transferRecordListPresenter",[
				init| transferRecordListPresenter.get.setup[init.apply(it)]
			], 
			"调拨管理"
		)
				
		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.warehouse",
			"com.fudanmed.platform.core.web.workItemTaskManagementPresenter",[
				init| workItemTaskManagementPresenter.get.setup[init.apply(it)]
			], 
			"工单领/退料"
		)
		

		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.warehouse",
			"com.fudanmed.platform.core.web.workItemStockRecordManagementPresenter",[
				init| workItemStockRecordManagementPresenter.get.setup[init.apply(it)]
			], 
			"领/退料单查询"
		)
		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.warehouse",
			"com.fudanmed.platform.core.web.settlementListPresenter",[
				init| settlementListPresenter.get.setup[init.apply(it)]
			], 
			"结算管理"
		)
		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.warehouse",
			"com.fudanmed.platform.core.web.stockTakingListListPresenter",[
				init| stockTakingListListPresenter.get.setup[init.apply(it)]
			], 
			"盘点管理"
		)
		workbenchManager.registerCommand(warehouseCategory,showProductSummarySnapshotManagementCommand)
		
		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.device",
			"com.fudanmed.platform.core.web.deviceManagementPresenter",[
				init| deviceManagementPresenter.get.setup[init.apply(it)]
			], 
			"设备管理"
		)
		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.device",
			"com.fudanmed.platform.core.web.deviceTypeCategoryManagementPresenter",[
				init| deviceTypeCategoryManagementPresenter.get.setup[init.apply(it)]
			], 
			"设备类型管理"
		)
		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.device",
			"com.fudanmed.platform.core.web.numberWithUnitTypeManagementPresenter",[
				init| numberWithUnitTypeManagementPresenter.get.setup[init.apply(it)]
			], 
			"数值参数单位管理"
		)
		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.pm",
			"com.fudanmed.platform.core.web.devicePMSpecificationManagementPresenter",[
				init| devicePMSpecificationManagementPresenter.get.setup[init.apply(it)]
			], 
			"设备PM计划管理"
		)
		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.pm",
			"com.fudanmed.platform.core.web.pmWorkItemManagementPresenter",[
				init| pmWorkItemManagementPresenter.get.setup[init.apply(it)]
			], 
			"PM调度工作台"
		)
//		workbenchManager.registerCommand((pmCategory,showDevicePMPlanCommand)
		workbenchManager.registerCommand(pmCategory,showDevicePMPlanCommand)
		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.statistics",
			"com.fudanmed.platform.core.web.repairTaskStatisticListPresenter",[
				init| repairTaskStatisticListPresenter.get.setup[init.apply(it)]
			], 
			"报修单统计表"
		)
		workbenchManager.registerPresenterProxy(
			"com.fudanmed.platform.core.web.statistics",
			"com.fudanmed.platform.core.web.workItemStockStatisticListPresenter",[
				init| workItemStockStatisticListPresenter.get.setup[init.apply(it)]
			], 
			"报修单用料统计表"
		)
		workbenchManager.registerCommand(statCategory,groupTaskStatByTeamCommand)
		workbenchManager.registerCommand(statCategory,repairTaskStatByMonthCommand)
		workbenchManager.registerCommand(statCategory,repairTaskStatByReportSourceCommand)
		workbenchManager.registerCommand(statCategory,repairTaskStatByReportSourceCommand)
		workbenchManager.registerCommand(measureCategory,showMeasureDeviceManagementPresenterCommand)
		workbenchManager.registerCommand(measureCategory,showMeasureDeviceValueManagementPresenterCommand)
		
		workbenchManager.registerCommand(deliverCategory,showDLTaskManagementCommand)
		workbenchManager.registerCommand(deliverCategory,showCenterlizedDeliverTaskManagementCommand)
		workbenchManager.registerCommand(deliverCategory,showInHospitalLocationManagementCommand)
		workbenchManager.registerCommand(deliverCategory,showCheckOrganizationManagementCommand)
		workbenchManager.registerCommand(deliverCategory,showDeliverPatientCheckTypeManagementCommand)
		workbenchManager.registerCommand(deliverCategory,showDeliverOrganizationManagementCommand)
		
//		workbenchManager.registerCommand(statCategory,showTeacherManagementCommand)
		
	}	
}