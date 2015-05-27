package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.entityextension.RCNumberWithUnitType;
import com.fudanmed.platform.core.entityextension.RCRangeType;
import com.fudanmed.platform.core.entityextension.impl.RCDateTypeImpl;
import com.fudanmed.platform.core.entityextension.impl.RCNumberTypeImpl;
import com.fudanmed.platform.core.entityextension.impl.RCNumberWithUnitTypeImpl;
import com.fudanmed.platform.core.entityextension.impl.RCRangeTypeImpl;
import com.fudanmed.platform.core.entityextension.impl.RCStringTypeImpl;
import edu.fudan.langlab.domain.updater.IUpgrader;
import edu.fudan.langlab.domain.updater.UpdateServie;
import edu.fudan.mylang.pf.BaseService;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("V_0_2_upgrade")
public class V_0_2_upgrade extends BaseService implements IUpgrader {
  public void primaryTypes1() {RCStringTypeImpl.create(getObjectFactory());RCDateTypeImpl.create(getObjectFactory());RCNumberTypeImpl.create(getObjectFactory());RCNumberWithUnitType rCNumberWithUnitType=RCNumberWithUnitTypeImpl.create(getObjectFactory());
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
    final RCNumberWithUnitType t2 = ObjectExtensions.<RCNumberWithUnitType>operator_doubleArrow(rCNumberWithUnitType_5, _function_6);RCNumberWithUnitType rCNumberWithUnitType_6=RCNumberWithUnitTypeImpl.create(getObjectFactory());
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
    ObjectExtensions.<RCNumberWithUnitType>operator_doubleArrow(rCNumberWithUnitType_8, _function_9);RCRangeType rCRangeType_1=RCRangeTypeImpl.create(getObjectFactory());
    final Procedure1<RCRangeType> _function_10 = new Procedure1<RCRangeType>() {
        public void apply(final RCRangeType it) {
          it.setNumberType(t2);
        }
      };
    ObjectExtensions.<RCRangeType>operator_doubleArrow(rCRangeType_1, _function_10);
  }
  
  @Autowired
  private UpdateServie updateService;
  
  public void doUpgrade() {
    if (updateService.canPerformUpdate("V_0_2_upgrade", "V_0_2", "primaryTypes1")) {
    	primaryTypes1();
    	updateService.updaterCommited("V_0_2_upgrade", "V_0_2", "primaryTypes1");
    }
    updateService.upgraderCommited("V_0_2", "V_0_3");
  }
}
