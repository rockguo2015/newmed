package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIRepairTaskStatByFaultTypeCriteriaData implements IsSerializable {
  private Long cnt;
  
  public Long getCnt() {
    return this.cnt;
  }
  
  public void setCnt(final Long cnt) {
    this.cnt = cnt;
  }
  
  public final static String P_Cnt = "cnt";
  
  public static IObjectFieldAccessor<UIRepairTaskStatByFaultTypeCriteriaData,Long> CntAccessor = new IObjectFieldAccessor<UIRepairTaskStatByFaultTypeCriteriaData,Long>(){
    				public Long getValue(UIRepairTaskStatByFaultTypeCriteriaData object){
    					return object.getCnt();
    				}
    				public void setValue(UIRepairTaskStatByFaultTypeCriteriaData object,Long value){
    					object.setCnt(value);
    				}
    			};
  
  private RCFaultTypeProxy faultType;
  
  public RCFaultTypeProxy getFaultType() {
    return this.faultType;
  }
  
  public void setFaultType(final RCFaultTypeProxy faultType) {
    this.faultType = faultType;
  }
  
  public final static String P_FaultType = "faultType";
  
  public static IObjectFieldAccessor<UIRepairTaskStatByFaultTypeCriteriaData,RCFaultTypeProxy> FaultTypeAccessor = new IObjectFieldAccessor<UIRepairTaskStatByFaultTypeCriteriaData,RCFaultTypeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy getValue(UIRepairTaskStatByFaultTypeCriteriaData object){
    					return object.getFaultType();
    				}
    				public void setValue(UIRepairTaskStatByFaultTypeCriteriaData object,com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy value){
    					object.setFaultType(value);
    				}
    			};
}
