package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.common.RCFaultReportSource;
import com.fudanmed.platform.core.common.RCSequenceConfig;
import com.fudanmed.platform.core.common.RCSequenceService;
import com.fudanmed.platform.core.common.impl.RCFaultReportSourceImpl;
import com.fudanmed.platform.core.device.pm.RCPMWorkItem;
import com.fudanmed.platform.core.domain.RCGroupTask;
import com.fudanmed.platform.core.domain.RCOnsitePosition;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.entityextension.RCNumberWithUnitType;
import com.fudanmed.platform.core.entityextension.RCRangeType;
import com.fudanmed.platform.core.entityextension.impl.RCDateTypeImpl;
import com.fudanmed.platform.core.entityextension.impl.RCNumberTypeImpl;
import com.fudanmed.platform.core.entityextension.impl.RCNumberWithUnitTypeImpl;
import com.fudanmed.platform.core.entityextension.impl.RCRangeTypeImpl;
import com.fudanmed.platform.core.entityextension.impl.RCStringTypeImpl;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorage;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import edu.fudan.langlab.domain.security.AppFunction;
import edu.fudan.langlab.domain.security.impl.AppFunctionImpl;
import edu.fudan.langlab.domain.updater.IUpgrader;
import edu.fudan.langlab.domain.updater.UpdateServie;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IGenericQuery;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("V_0_4_upgrade")
public class V_0_4_upgrade extends BaseService implements IUpgrader {
  @Autowired
  private RCSequenceService sequenceService;
  
  public void updateRepairtaskMonth() {IGenericQuery<RCRepairTask> query=getObjectFactory().createGenericQuery(RCRepairTask.class,"select e from com.fudanmed.platform.core.domain.impl.RCRepairTaskImpl as e   where  e.active = 1      ");
    Collection<RCRepairTask> _list = query.list();
    final Procedure1<RCRepairTask> _function = new Procedure1<RCRepairTask>() {
        public void apply(final RCRepairTask it) {
          it.updateDerived();
        }
      };
    IterableExtensions.<RCRepairTask>forEach(_list, _function);
  }
  
  public void updateGrouptaskMonth() {IGenericQuery<RCGroupTask> query=getObjectFactory().createGenericQuery(RCGroupTask.class,"select e from com.fudanmed.platform.core.domain.impl.RCGroupTaskImpl as e   where  e.active = 1      ");
    Collection<RCGroupTask> _list = query.list();
    final Procedure1<RCGroupTask> _function = new Procedure1<RCGroupTask>() {
        public void apply(final RCGroupTask it) {
          it.updateDerived();
        }
      };
    IterableExtensions.<RCGroupTask>forEach(_list, _function);
  }
  
  public void updateWorkitemTaskMonth() {IGenericQuery<RCWorkItemTask> query=getObjectFactory().createGenericQuery(RCWorkItemTask.class,"select e from com.fudanmed.platform.core.domain.impl.RCWorkItemTaskImpl as e   where  e.active = 1      ");
    Collection<RCWorkItemTask> _list = query.list();
    final Procedure1<RCWorkItemTask> _function = new Procedure1<RCWorkItemTask>() {
        public void apply(final RCWorkItemTask it) {
          it.updateDerived();
        }
      };
    IterableExtensions.<RCWorkItemTask>forEach(_list, _function);
  }
  
  public void pmsequence() {
    RCSequenceConfig _computeConfig = this.sequenceService.computeConfig();
    _computeConfig.setPmWorkItemSequence(Integer.valueOf(0));IGenericQuery<RCPMWorkItem> query=getObjectFactory().createGenericQuery(RCPMWorkItem.class,"select e from com.fudanmed.platform.core.device.pm.impl.RCPMWorkItemImpl as e   where  e.active = 1      ");
    Collection<RCPMWorkItem> _list = query.list();
    final Procedure1<RCPMWorkItem> _function = new Procedure1<RCPMWorkItem>() {
        public void apply(final RCPMWorkItem it) {
          String _nextPMWorkItemSequence = V_0_4_upgrade.this.sequenceService.getNextPMWorkItemSequence();
          it.setSid(_nextPMWorkItemSequence);
        }
      };
    IterableExtensions.<RCPMWorkItem>forEach(_list, _function);
  }
  
  public void onlineReportCode() {RCFaultReportSource rCFaultReportSource=RCFaultReportSourceImpl.create(getObjectFactory());
    final Procedure1<RCFaultReportSource> _function = new Procedure1<RCFaultReportSource>() {
        public void apply(final RCFaultReportSource it) {
          it.setCodeid("_01");
          it.setName("\u81EA\u52A9\u62A5\u4FEE");
        }
      };
    ObjectExtensions.<RCFaultReportSource>operator_doubleArrow(rCFaultReportSource, _function);
  }
  
  public void pmTeamFunction() {AppFunction appFunction=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.pmTeamWorkItemManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.device.PMTeamWorkItemManagementPresenter.assignWorkerRequest");
          it.setName("\u6D3E\u5DE5");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction, _function);AppFunction appFunction_1=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_1 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.pmTeamWorkItemManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.device.PMTeamWorkItemManagementPresenter.reportFinishRequest");
          it.setName("\u5B8C\u6210");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_1, _function_1);AppFunction appFunction_2=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_2 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.pmTeamWorkItemManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.device.PMTeamWorkItemManagementPresenter.reportAllFinishRequest");
          it.setName("\u5B8C\u5DE5\u4E0A\u62A5");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_2, _function_2);AppFunction appFunction_3=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_3 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.pmTeamWorkItemManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.device.PMTeamWorkItemManagementPresenter.pendRequest");
          it.setName("\u5EF6\u8FDF");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_3, _function_3);
  }
  
  public void statFunction() {AppFunction appFunction=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.statistics");
          it.setFunctionId("com.fudanmed.platform.core.web.GroupTaskStatByTeamCommand");
          it.setName("\u73ED\u7EC4\u63A5\u4FEE\u7EDF\u8BA1");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction, _function);AppFunction appFunction_1=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_1 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.statistics");
          it.setFunctionId("com.fudanmed.platform.core.web.RepairTaskStatByMonthCommand");
          it.setName("\u6708\u4EFD\u62A5\u4FEE\u7EDF\u8BA1");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_1, _function_1);AppFunction appFunction_2=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_2 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.process");
          it.setFunctionId("com.fudanmed.platform.core.web.pmTeamWorkItemManagementPresenter");
          it.setName("\u73ED\u7EC4PM\u5DE5\u4F5C\u53F0");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_2, _function_2);AppFunction appFunction_3=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_3 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.deviceManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.device.AttributeSlotTreeListPresenter.editSlotValueRequest");
          it.setName("\u4FEE\u6539\u8BBE\u5907\u53C2\u6570");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_3, _function_3);
  }
  
  public void reportSourceStatFunction() {AppFunction appFunction=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.statistics");
          it.setFunctionId("com.fudanmed.platform.core.web.RepairTaskStatByReportSourceCommand");
          it.setName("\u62A5\u4FEE\u6765\u6E90\u7EDF\u8BA1");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction, _function);
  }
  
  public void lostFunction20150115() {AppFunction appFunction=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.groupTaskManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.GroupTaskManagementPresenter.printWorkItemRequest");
          it.setName("\u6253\u5370\u5DE5\u5355");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction, _function);AppFunction appFunction_1=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_1 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.deviceTypeCategoryManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.device.DeviceTypeManagementPresenter.showAttributeSlotEditorRequest");
          it.setName("\u6269\u5C55\u6280\u672F\u53C2\u6570");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_1, _function_1);
  }
  
  public void primaryTypes2() {RCStringTypeImpl.create(getObjectFactory());RCDateTypeImpl.create(getObjectFactory());RCNumberTypeImpl.create(getObjectFactory());RCNumberWithUnitType rCNumberWithUnitType=RCNumberWithUnitTypeImpl.create(getObjectFactory());
    final Procedure1<RCNumberWithUnitType> _function = new Procedure1<RCNumberWithUnitType>() {
        public void apply(final RCNumberWithUnitType it) {
          it.setAlias("\u529F\u7387");
          it.setUnit("\u5343\u74E6/\u65F6");
        }
      };
    ObjectExtensions.<RCNumberWithUnitType>operator_doubleArrow(rCNumberWithUnitType, _function);RCNumberWithUnitType rCNumberWithUnitType_1=RCNumberWithUnitTypeImpl.create(getObjectFactory());
    final Procedure1<RCNumberWithUnitType> _function_1 = new Procedure1<RCNumberWithUnitType>() {
        public void apply(final RCNumberWithUnitType it) {
          it.setAlias("\u6E29\u5EA6");
          it.setUnit("\u6444\u6C0F\u5EA6");
        }
      };
    final RCNumberWithUnitType t1 = ObjectExtensions.<RCNumberWithUnitType>operator_doubleArrow(rCNumberWithUnitType_1, _function_1);RCRangeType rCRangeType=RCRangeTypeImpl.create(getObjectFactory());
    final Procedure1<RCRangeType> _function_2 = new Procedure1<RCRangeType>() {
        public void apply(final RCRangeType it) {
          it.setNumberType(t1);
        }
      };
    ObjectExtensions.<RCRangeType>operator_doubleArrow(rCRangeType, _function_2);RCNumberWithUnitType rCNumberWithUnitType_2=RCNumberWithUnitTypeImpl.create(getObjectFactory());
    final Procedure1<RCNumberWithUnitType> _function_3 = new Procedure1<RCNumberWithUnitType>() {
        public void apply(final RCNumberWithUnitType it) {
          it.setAlias("\u6D41\u91CF");
          it.setUnit("m3/h");
        }
      };
    ObjectExtensions.<RCNumberWithUnitType>operator_doubleArrow(rCNumberWithUnitType_2, _function_3);RCNumberWithUnitType rCNumberWithUnitType_3=RCNumberWithUnitTypeImpl.create(getObjectFactory());
    final Procedure1<RCNumberWithUnitType> _function_4 = new Procedure1<RCNumberWithUnitType>() {
        public void apply(final RCNumberWithUnitType it) {
          it.setAlias("\u529F");
          it.setUnit("KW");
        }
      };
    ObjectExtensions.<RCNumberWithUnitType>operator_doubleArrow(rCNumberWithUnitType_3, _function_4);RCNumberWithUnitType rCNumberWithUnitType_4=RCNumberWithUnitTypeImpl.create(getObjectFactory());
    final Procedure1<RCNumberWithUnitType> _function_5 = new Procedure1<RCNumberWithUnitType>() {
        public void apply(final RCNumberWithUnitType it) {
          it.setAlias("\u538B\u5F3A");
          it.setUnit("Pa");
        }
      };
    ObjectExtensions.<RCNumberWithUnitType>operator_doubleArrow(rCNumberWithUnitType_4, _function_5);RCNumberWithUnitType rCNumberWithUnitType_5=RCNumberWithUnitTypeImpl.create(getObjectFactory());
    final Procedure1<RCNumberWithUnitType> _function_6 = new Procedure1<RCNumberWithUnitType>() {
        public void apply(final RCNumberWithUnitType it) {
          it.setAlias("\u97F3\u91CF");
          it.setUnit("dB(A)");
        }
      };
    ObjectExtensions.<RCNumberWithUnitType>operator_doubleArrow(rCNumberWithUnitType_5, _function_6);RCNumberWithUnitType rCNumberWithUnitType_6=RCNumberWithUnitTypeImpl.create(getObjectFactory());
    final Procedure1<RCNumberWithUnitType> _function_7 = new Procedure1<RCNumberWithUnitType>() {
        public void apply(final RCNumberWithUnitType it) {
          it.setAlias("\u538B\u5F3A");
          it.setUnit("Kpa");
        }
      };
    ObjectExtensions.<RCNumberWithUnitType>operator_doubleArrow(rCNumberWithUnitType_6, _function_7);RCNumberWithUnitType rCNumberWithUnitType_7=RCNumberWithUnitTypeImpl.create(getObjectFactory());
    final Procedure1<RCNumberWithUnitType> _function_8 = new Procedure1<RCNumberWithUnitType>() {
        public void apply(final RCNumberWithUnitType it) {
          it.setAlias("\u538B\u5F3A");
          it.setUnit("Mpa");
        }
      };
    ObjectExtensions.<RCNumberWithUnitType>operator_doubleArrow(rCNumberWithUnitType_7, _function_8);RCNumberWithUnitType rCNumberWithUnitType_8=RCNumberWithUnitTypeImpl.create(getObjectFactory());
    final Procedure1<RCNumberWithUnitType> _function_9 = new Procedure1<RCNumberWithUnitType>() {
        public void apply(final RCNumberWithUnitType it) {
          it.setAlias("\u6D41\u91CF");
          it.setUnit("m/s");
        }
      };
    ObjectExtensions.<RCNumberWithUnitType>operator_doubleArrow(rCNumberWithUnitType_8, _function_9);
  }
  
  public void StockTakingMistake() {
    IGenericQuery<RCProductWarehouseStorage> query=getObjectFactory().createGenericQuery(RCProductWarehouseStorage.class,"select e from com.fudanmed.platform.core.warehouse.impl.RCProductWarehouseStorageImpl as e   where (e.quantity < 0) and  e.active = 1      ");
    Collection<RCProductWarehouseStorage> _list = query.list();
    final Function1<RCProductWarehouseStorage,RCProductWarehouseStorageSummary> _function = new Function1<RCProductWarehouseStorage,RCProductWarehouseStorageSummary>() {
        public RCProductWarehouseStorageSummary apply(final RCProductWarehouseStorage it) {
          RCProductWarehouseStorageSummary _summary = it.getSummary();
          return _summary;
        }
      };
    Iterable<RCProductWarehouseStorageSummary> _map = IterableExtensions.<RCProductWarehouseStorage, RCProductWarehouseStorageSummary>map(_list, _function);
    Set<RCProductWarehouseStorageSummary> _set = IterableExtensions.<RCProductWarehouseStorageSummary>toSet(_map);
    final Procedure1<RCProductWarehouseStorageSummary> _function_1 = new Procedure1<RCProductWarehouseStorageSummary>() {
        public void apply(final RCProductWarehouseStorageSummary summary) {
          RCWarehouse _store = summary.getStore();
          String _entityName = _store.getEntityName();
          String _plus = (_entityName + ":");
          RCProductSpecification _productSpec = summary.getProductSpec();
          String _sid = _productSpec.getSid();
          String _plus_1 = (_plus + _sid);
          InputOutput.<String>println(_plus_1);
          Collection<RCProductWarehouseStorage> _productWarehouseStorages = summary.getProductWarehouseStorages();
          final Procedure1<RCProductWarehouseStorage> _function = new Procedure1<RCProductWarehouseStorage>() {
              public void apply(final RCProductWarehouseStorage it) {
                it.setQuantity(Integer.valueOf(0));
              }
            };
          IterableExtensions.<RCProductWarehouseStorage>forEach(_productWarehouseStorages, _function);
          Collection<RCProductWarehouseStorage> _productWarehouseStorages_1 = summary.getProductWarehouseStorages();
          List<RCProductWarehouseStorage> _list = IterableExtensions.<RCProductWarehouseStorage>toList(_productWarehouseStorages_1);
          List<RCProductWarehouseStorage> _reverse = ListExtensions.<RCProductWarehouseStorage>reverse(_list);
          RCProductWarehouseStorage _head = IterableExtensions.<RCProductWarehouseStorage>head(_reverse);
          Integer _quantity = summary.getQuantity();
          _head.setQuantity(_quantity);
        }
      };
    IterableExtensions.<RCProductWarehouseStorageSummary>forEach(_set, _function_1);
  }
  
  public void OnsitePositionFullIdPath() {IGenericQuery<RCOnsitePosition> query=getObjectFactory().createGenericQuery(RCOnsitePosition.class,"select p from com.fudanmed.platform.core.domain.impl.RCOnsitePositionImpl as p   where  p.active = 1      ");
    Collection<RCOnsitePosition> _list = query.list();
    final Procedure1<RCOnsitePosition> _function = new Procedure1<RCOnsitePosition>() {
        public void apply(final RCOnsitePosition it) {
          String _fullIdPath = it.fullIdPath();
          it.setPath(_fullIdPath);
        }
      };
    IterableExtensions.<RCOnsitePosition>forEach(_list, _function);
  }
  
  public void fixFunctionDefinition() {
    IGenericQuery<AppFunction> query=getObjectFactory().createGenericQuery(AppFunction.class,"select f from edu.fudan.langlab.domain.security.impl.AppFunctionImpl as f   where (f.functionId  LIKE  'com.fudanmed.platform.core.web.client.device.DeviceTypeManagementPresenter%' ) and  f.active = 1      ");
    Collection<AppFunction> _list = query.list();
    final Procedure1<AppFunction> _function = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.deviceTypeCategoryManagementPresenter");
        }
      };
    IterableExtensions.<AppFunction>forEach(_list, _function);
    IGenericQuery<AppFunction> query_1=getObjectFactory().createGenericQuery(AppFunction.class,"select f from edu.fudan.langlab.domain.security.impl.AppFunctionImpl as f   where (f.functionId =  'com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryManagementPresenter.createChildRequest' ) and  f.active = 1      ");
    AppFunction _uniqueResult = query_1.uniqueResult();
    final Procedure1<AppFunction> _function_1 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          String _name = it.getName();
          String _plus = (_name + "[X]");
          it.setName(_plus);
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(_uniqueResult, _function_1);
    IGenericQuery<AppFunction> query_2=getObjectFactory().createGenericQuery(AppFunction.class,"select f from edu.fudan.langlab.domain.security.impl.AppFunctionImpl as f   where (f.functionId =  'com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryManagementPresenter.modifyChildRequest' ) and  f.active = 1      ");
    AppFunction _uniqueResult_1 = query_2.uniqueResult();
    final Procedure1<AppFunction> _function_2 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          String _name = it.getName();
          String _plus = (_name + "[X]");
          it.setName(_plus);
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(_uniqueResult_1, _function_2);
    IGenericQuery<AppFunction> query_3=getObjectFactory().createGenericQuery(AppFunction.class,"select f from edu.fudan.langlab.domain.security.impl.AppFunctionImpl as f   where (f.functionId =  'com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryManagementPresenter.deleteChildRequest' ) and  f.active = 1      ");
    AppFunction _uniqueResult_2 = query_3.uniqueResult();
    final Procedure1<AppFunction> _function_3 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          String _name = it.getName();
          String _plus = (_name + "[X]");
          it.setName(_plus);
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(_uniqueResult_2, _function_3);
  }
  
  @Autowired
  private UpdateServie updateService;
  
  public void doUpgrade() {
    if (updateService.canPerformUpdate("V_0_4_upgrade", "V_0_4", "updateRepairtaskMonth")) {
    	updateRepairtaskMonth();
    	updateService.updaterCommited("V_0_4_upgrade", "V_0_4", "updateRepairtaskMonth");
    }
    if (updateService.canPerformUpdate("V_0_4_upgrade", "V_0_4", "updateGrouptaskMonth")) {
    	updateGrouptaskMonth();
    	updateService.updaterCommited("V_0_4_upgrade", "V_0_4", "updateGrouptaskMonth");
    }
    if (updateService.canPerformUpdate("V_0_4_upgrade", "V_0_4", "updateWorkitemTaskMonth")) {
    	updateWorkitemTaskMonth();
    	updateService.updaterCommited("V_0_4_upgrade", "V_0_4", "updateWorkitemTaskMonth");
    }
    if (updateService.canPerformUpdate("V_0_4_upgrade", "V_0_4", "pmsequence")) {
    	pmsequence();
    	updateService.updaterCommited("V_0_4_upgrade", "V_0_4", "pmsequence");
    }
    if (updateService.canPerformUpdate("V_0_4_upgrade", "V_0_4", "onlineReportCode")) {
    	onlineReportCode();
    	updateService.updaterCommited("V_0_4_upgrade", "V_0_4", "onlineReportCode");
    }
    if (updateService.canPerformUpdate("V_0_4_upgrade", "V_0_4", "pmTeamFunction")) {
    	pmTeamFunction();
    	updateService.updaterCommited("V_0_4_upgrade", "V_0_4", "pmTeamFunction");
    }
    if (updateService.canPerformUpdate("V_0_4_upgrade", "V_0_4", "statFunction")) {
    	statFunction();
    	updateService.updaterCommited("V_0_4_upgrade", "V_0_4", "statFunction");
    }
    if (updateService.canPerformUpdate("V_0_4_upgrade", "V_0_4", "reportSourceStatFunction")) {
    	reportSourceStatFunction();
    	updateService.updaterCommited("V_0_4_upgrade", "V_0_4", "reportSourceStatFunction");
    }
    if (updateService.canPerformUpdate("V_0_4_upgrade", "V_0_4", "lostFunction20150115")) {
    	lostFunction20150115();
    	updateService.updaterCommited("V_0_4_upgrade", "V_0_4", "lostFunction20150115");
    }
    if (updateService.canPerformUpdate("V_0_4_upgrade", "V_0_4", "primaryTypes2")) {
    	primaryTypes2();
    	updateService.updaterCommited("V_0_4_upgrade", "V_0_4", "primaryTypes2");
    }
    if (updateService.canPerformUpdate("V_0_4_upgrade", "V_0_4", "StockTakingMistake")) {
    	StockTakingMistake();
    	updateService.updaterCommited("V_0_4_upgrade", "V_0_4", "StockTakingMistake");
    }
    if (updateService.canPerformUpdate("V_0_4_upgrade", "V_0_4", "OnsitePositionFullIdPath")) {
    	OnsitePositionFullIdPath();
    	updateService.updaterCommited("V_0_4_upgrade", "V_0_4", "OnsitePositionFullIdPath");
    }
    if (updateService.canPerformUpdate("V_0_4_upgrade", "V_0_4", "fixFunctionDefinition")) {
    	fixFunctionDefinition();
    	updateService.updaterCommited("V_0_4_upgrade", "V_0_4", "fixFunctionDefinition");
    }
    updateService.upgraderCommited("V_0_4", "V_0_5");
  }
}
