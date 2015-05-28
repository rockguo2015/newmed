package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIRepairTaskStatByReportSourceCriteriaData implements IsSerializable {
  private Long cnt;
  
  public Long getCnt() {
    return this.cnt;
  }
  
  public void setCnt(final Long cnt) {
    this.cnt = cnt;
  }
  
  public final static String P_Cnt = "cnt";
  
  public static IObjectFieldAccessor<UIRepairTaskStatByReportSourceCriteriaData,Long> CntAccessor = new IObjectFieldAccessor<UIRepairTaskStatByReportSourceCriteriaData,Long>(){
    				public Long getValue(UIRepairTaskStatByReportSourceCriteriaData object){
    					return object.getCnt();
    				}
    				public void setValue(UIRepairTaskStatByReportSourceCriteriaData object,Long value){
    					object.setCnt(value);
    				}
    			};
  
  private RCFaultReportSourceProxy faultReportSource;
  
  public RCFaultReportSourceProxy getFaultReportSource() {
    return this.faultReportSource;
  }
  
  public void setFaultReportSource(final RCFaultReportSourceProxy faultReportSource) {
    this.faultReportSource = faultReportSource;
  }
  
  public final static String P_FaultReportSource = "faultReportSource";
  
  public static IObjectFieldAccessor<UIRepairTaskStatByReportSourceCriteriaData,RCFaultReportSourceProxy> FaultReportSourceAccessor = new IObjectFieldAccessor<UIRepairTaskStatByReportSourceCriteriaData,RCFaultReportSourceProxy>(){
    				public com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy getValue(UIRepairTaskStatByReportSourceCriteriaData object){
    					return object.getFaultReportSource();
    				}
    				public void setValue(UIRepairTaskStatByReportSourceCriteriaData object,com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy value){
    					object.setFaultReportSource(value);
    				}
    			};
}
