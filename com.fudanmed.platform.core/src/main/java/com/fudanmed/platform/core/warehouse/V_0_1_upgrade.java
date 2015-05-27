package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.device.RCDeviceUsageType;
import com.fudanmed.platform.core.device.impl.RCDeviceUsageTypeImpl;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.entityextension.RCNumberWithUnitType;
import com.fudanmed.platform.core.entityextension.RCRangeType;
import com.fudanmed.platform.core.entityextension.impl.RCDateTypeImpl;
import com.fudanmed.platform.core.entityextension.impl.RCNumberTypeImpl;
import com.fudanmed.platform.core.entityextension.impl.RCNumberWithUnitTypeImpl;
import com.fudanmed.platform.core.entityextension.impl.RCRangeTypeImpl;
import com.fudanmed.platform.core.entityextension.impl.RCStringTypeImpl;
import edu.fudan.langlab.domain.security.AppFunction;
import edu.fudan.langlab.domain.security.RoleFunctionAssignment;
import edu.fudan.langlab.domain.security.impl.AppFunctionImpl;
import edu.fudan.langlab.domain.updater.IUpgrader;
import edu.fudan.langlab.domain.updater.UpdateServie;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IGenericQuery;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("V_0_1_upgrade")
public class V_0_1_upgrade extends BaseService implements IUpgrader {
  public void primaryTypes() {RCNumberTypeImpl.create(getObjectFactory());RCNumberWithUnitType rCNumberWithUnitType=RCNumberWithUnitTypeImpl.create(getObjectFactory());
    final Procedure1<RCNumberWithUnitType> _function = new Procedure1<RCNumberWithUnitType>() {
        public void apply(final RCNumberWithUnitType it) {
          it.setUnit("\u5343\u74E6/\u65F6");
        }
      };
    ObjectExtensions.<RCNumberWithUnitType>operator_doubleArrow(rCNumberWithUnitType, _function);RCNumberWithUnitType rCNumberWithUnitType_1=RCNumberWithUnitTypeImpl.create(getObjectFactory());
    final Procedure1<RCNumberWithUnitType> _function_1 = new Procedure1<RCNumberWithUnitType>() {
        public void apply(final RCNumberWithUnitType it) {
          it.setUnit("\u6444\u6C0F\u5EA6");
        }
      };
    final RCNumberWithUnitType t1 = ObjectExtensions.<RCNumberWithUnitType>operator_doubleArrow(rCNumberWithUnitType_1, _function_1);RCRangeType rCRangeType=RCRangeTypeImpl.create(getObjectFactory());
    final Procedure1<RCRangeType> _function_2 = new Procedure1<RCRangeType>() {
        public void apply(final RCRangeType it) {
          it.setNumberType(t1);
        }
      };
    ObjectExtensions.<RCRangeType>operator_doubleArrow(rCRangeType, _function_2);RCStringTypeImpl.create(getObjectFactory());RCDateTypeImpl.create(getObjectFactory());RCNumberWithUnitType rCNumberWithUnitType_2=RCNumberWithUnitTypeImpl.create(getObjectFactory());
    final Procedure1<RCNumberWithUnitType> _function_3 = new Procedure1<RCNumberWithUnitType>() {
        public void apply(final RCNumberWithUnitType it) {
          it.setUnit("m3/h");
        }
      };
    ObjectExtensions.<RCNumberWithUnitType>operator_doubleArrow(rCNumberWithUnitType_2, _function_3);RCNumberWithUnitType rCNumberWithUnitType_3=RCNumberWithUnitTypeImpl.create(getObjectFactory());
    final Procedure1<RCNumberWithUnitType> _function_4 = new Procedure1<RCNumberWithUnitType>() {
        public void apply(final RCNumberWithUnitType it) {
          it.setUnit("KW");
        }
      };
    ObjectExtensions.<RCNumberWithUnitType>operator_doubleArrow(rCNumberWithUnitType_3, _function_4);RCNumberWithUnitType rCNumberWithUnitType_4=RCNumberWithUnitTypeImpl.create(getObjectFactory());
    final Procedure1<RCNumberWithUnitType> _function_5 = new Procedure1<RCNumberWithUnitType>() {
        public void apply(final RCNumberWithUnitType it) {
          it.setUnit("Pa");
        }
      };
    ObjectExtensions.<RCNumberWithUnitType>operator_doubleArrow(rCNumberWithUnitType_4, _function_5);RCNumberWithUnitType rCNumberWithUnitType_5=RCNumberWithUnitTypeImpl.create(getObjectFactory());
    final Procedure1<RCNumberWithUnitType> _function_6 = new Procedure1<RCNumberWithUnitType>() {
        public void apply(final RCNumberWithUnitType it) {
          it.setUnit("dB(A)");
        }
      };
    final RCNumberWithUnitType t2 = ObjectExtensions.<RCNumberWithUnitType>operator_doubleArrow(rCNumberWithUnitType_5, _function_6);RCNumberWithUnitType rCNumberWithUnitType_6=RCNumberWithUnitTypeImpl.create(getObjectFactory());
    final Procedure1<RCNumberWithUnitType> _function_7 = new Procedure1<RCNumberWithUnitType>() {
        public void apply(final RCNumberWithUnitType it) {
          it.setUnit("Kpa");
        }
      };
    ObjectExtensions.<RCNumberWithUnitType>operator_doubleArrow(rCNumberWithUnitType_6, _function_7);RCNumberWithUnitType rCNumberWithUnitType_7=RCNumberWithUnitTypeImpl.create(getObjectFactory());
    final Procedure1<RCNumberWithUnitType> _function_8 = new Procedure1<RCNumberWithUnitType>() {
        public void apply(final RCNumberWithUnitType it) {
          it.setUnit("Mpa");
        }
      };
    ObjectExtensions.<RCNumberWithUnitType>operator_doubleArrow(rCNumberWithUnitType_7, _function_8);RCNumberWithUnitType rCNumberWithUnitType_8=RCNumberWithUnitTypeImpl.create(getObjectFactory());
    final Procedure1<RCNumberWithUnitType> _function_9 = new Procedure1<RCNumberWithUnitType>() {
        public void apply(final RCNumberWithUnitType it) {
          it.setUnit("m/s");
        }
      };
    ObjectExtensions.<RCNumberWithUnitType>operator_doubleArrow(rCNumberWithUnitType_8, _function_9);RCRangeType rCRangeType_1=RCRangeTypeImpl.create(getObjectFactory());
    final Procedure1<RCRangeType> _function_10 = new Procedure1<RCRangeType>() {
        public void apply(final RCRangeType it) {
          it.setNumberType(t2);
        }
      };
    ObjectExtensions.<RCRangeType>operator_doubleArrow(rCRangeType_1, _function_10);
  }
  
  public void deviceCodes() {RCDeviceUsageType rCDeviceUsageType=RCDeviceUsageTypeImpl.create(getObjectFactory());
    final Procedure1<RCDeviceUsageType> _function = new Procedure1<RCDeviceUsageType>() {
        public void apply(final RCDeviceUsageType it) {
          it.setCodeid("001");
          it.setName("\u5728\u7528");
        }
      };
    ObjectExtensions.<RCDeviceUsageType>operator_doubleArrow(rCDeviceUsageType, _function);RCDeviceUsageType rCDeviceUsageType_1=RCDeviceUsageTypeImpl.create(getObjectFactory());
    final Procedure1<RCDeviceUsageType> _function_1 = new Procedure1<RCDeviceUsageType>() {
        public void apply(final RCDeviceUsageType it) {
          it.setCodeid("002");
          it.setName("\u505C\u7528");
        }
      };
    ObjectExtensions.<RCDeviceUsageType>operator_doubleArrow(rCDeviceUsageType_1, _function_1);RCDeviceUsageType rCDeviceUsageType_2=RCDeviceUsageTypeImpl.create(getObjectFactory());
    final Procedure1<RCDeviceUsageType> _function_2 = new Procedure1<RCDeviceUsageType>() {
        public void apply(final RCDeviceUsageType it) {
          it.setCodeid("003");
          it.setName("\u62A5\u5E9F");
        }
      };
    ObjectExtensions.<RCDeviceUsageType>operator_doubleArrow(rCDeviceUsageType_2, _function_2);RCDeviceUsageType rCDeviceUsageType_3=RCDeviceUsageTypeImpl.create(getObjectFactory());
    final Procedure1<RCDeviceUsageType> _function_3 = new Procedure1<RCDeviceUsageType>() {
        public void apply(final RCDeviceUsageType it) {
          it.setCodeid("004");
          it.setName("\u5C01\u5B58");
        }
      };
    ObjectExtensions.<RCDeviceUsageType>operator_doubleArrow(rCDeviceUsageType_3, _function_3);
  }
  
  public void test001() {IGenericQuery<RCRepairTask> query=getObjectFactory().createGenericQuery(RCRepairTask.class,"select t from com.fudanmed.platform.core.domain.impl.RCRepairTaskImpl as t   where  t.active = 1      ");
    Collection<RCRepairTask> _list = query.list();
    final Procedure1<RCRepairTask> _function = new Procedure1<RCRepairTask>() {
        public void apply(final RCRepairTask it) {
          Date _date = new Date();
          it.setFinishDate(_date);
          Date _date_1 = new Date();
          it.setFinishTime(_date_1);
        }
      };
    IterableExtensions.<RCRepairTask>forEach(_list, _function);
  }
  
  public void initAdditionalFunctions() {AppFunction appFunction=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.stockTakingListListPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.warehouse.StockTakingListListPresenter.printListlRequest");
          it.setName("\u6253\u5370\u76D8\u70B9\u5355");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction, _function);AppFunction appFunction_1=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_1 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.settlementListPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.SettlementListPresenter.printSettlementRequest");
          it.setName("\u6253\u5370\u7ED3\u7B97\u5355");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_1, _function_1);
    final String funcId = "com.fudanmed.platform.core.web.stockTakingRecordListPresenter";
    IGenericQuery<AppFunction> query=getObjectFactory().createGenericQuery(AppFunction.class,"select e1 from edu.fudan.langlab.domain.security.impl.AppFunctionImpl as e1   where (e1.parentFunctionId = :funcId) and  e1.active = 1      ").setParameter("funcId",funcId);
    Collection<AppFunction> _list = query.list();
    final Procedure1<AppFunction> _function_2 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          IGenericQuery<RoleFunctionAssignment> query=getObjectFactory().createGenericQuery(RoleFunctionAssignment.class,"select rf1 from edu.fudan.langlab.domain.security.impl.RoleFunctionAssignmentImpl as rf1   where (rf1.function = :it) and  rf1.active = 1      ").setParameter("it",it);
          Collection<RoleFunctionAssignment> _list = query.list();
          final Procedure1<RoleFunctionAssignment> _function = new Procedure1<RoleFunctionAssignment>() {
              public void apply(final RoleFunctionAssignment it) {getObjectFactory().delete(it);
                
              }
            };
          IterableExtensions.<RoleFunctionAssignment>forEach(_list, _function);getObjectFactory().delete(it);
          
        }
      };
    IterableExtensions.<AppFunction>forEach(_list, _function_2);
    IGenericQuery<AppFunction> query_1=getObjectFactory().createGenericQuery(AppFunction.class,"select e2 from edu.fudan.langlab.domain.security.impl.AppFunctionImpl as e2   where (e2.functionId = :funcId) and  e2.active = 1      ").setParameter("funcId",funcId);
    Collection<AppFunction> _list_1 = query_1.list();
    final Procedure1<AppFunction> _function_3 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          IGenericQuery<RoleFunctionAssignment> query=getObjectFactory().createGenericQuery(RoleFunctionAssignment.class,"select rf2 from edu.fudan.langlab.domain.security.impl.RoleFunctionAssignmentImpl as rf2   where (rf2.function = :it) and  rf2.active = 1      ").setParameter("it",it);
          Collection<RoleFunctionAssignment> _list = query.list();
          final Procedure1<RoleFunctionAssignment> _function = new Procedure1<RoleFunctionAssignment>() {
              public void apply(final RoleFunctionAssignment it) {getObjectFactory().delete(it);
                
              }
            };
          IterableExtensions.<RoleFunctionAssignment>forEach(_list, _function);getObjectFactory().delete(it);
          
        }
      };
    IterableExtensions.<AppFunction>forEach(_list_1, _function_3);
  }
  
  @Autowired
  private UpdateServie updateService;
  
  public void doUpgrade() {
    if (updateService.canPerformUpdate("V_0_1_upgrade", "V_0_1", "primaryTypes")) {
    	primaryTypes();
    	updateService.updaterCommited("V_0_1_upgrade", "V_0_1", "primaryTypes");
    }
    if (updateService.canPerformUpdate("V_0_1_upgrade", "V_0_1", "deviceCodes")) {
    	deviceCodes();
    	updateService.updaterCommited("V_0_1_upgrade", "V_0_1", "deviceCodes");
    }
    if (updateService.canPerformUpdate("V_0_1_upgrade", "V_0_1", "test001")) {
    	test001();
    	updateService.updaterCommited("V_0_1_upgrade", "V_0_1", "test001");
    }
    if (updateService.canPerformUpdate("V_0_1_upgrade", "V_0_1", "initAdditionalFunctions")) {
    	initAdditionalFunctions();
    	updateService.updaterCommited("V_0_1_upgrade", "V_0_1", "initAdditionalFunctions");
    }
    updateService.upgraderCommited("V_0_1", "V_0_2");
  }
}
