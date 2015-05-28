package com.fudanmed.platform.core.web.shared.project;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIRepairTaskStatByMonthCriteriaData implements IsSerializable {
  private Long cnt;
  
  public Long getCnt() {
    return this.cnt;
  }
  
  public void setCnt(final Long cnt) {
    this.cnt = cnt;
  }
  
  public final static String P_Cnt = "cnt";
  
  public static IObjectFieldAccessor<UIRepairTaskStatByMonthCriteriaData,Long> CntAccessor = new IObjectFieldAccessor<UIRepairTaskStatByMonthCriteriaData,Long>(){
    				public Long getValue(UIRepairTaskStatByMonthCriteriaData object){
    					return object.getCnt();
    				}
    				public void setValue(UIRepairTaskStatByMonthCriteriaData object,Long value){
    					object.setCnt(value);
    				}
    			};
  
  private String month;
  
  public String getMonth() {
    return this.month;
  }
  
  public void setMonth(final String month) {
    this.month = month;
  }
  
  public final static String P_Month = "month";
  
  public static IObjectFieldAccessor<UIRepairTaskStatByMonthCriteriaData,String> MonthAccessor = new IObjectFieldAccessor<UIRepairTaskStatByMonthCriteriaData,String>(){
    				public String getValue(UIRepairTaskStatByMonthCriteriaData object){
    					return object.getMonth();
    				}
    				public void setValue(UIRepairTaskStatByMonthCriteriaData object,String value){
    					object.setMonth(value);
    				}
    			};
}
