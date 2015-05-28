package com.fudanmed.platform.core.web.shared.deliver;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class UIPlanDateTime implements IsSerializable {
  private Date planDate;
  
  public Date getPlanDate() {
    return this.planDate;
  }
  
  public void setPlanDate(final Date planDate) {
    this.planDate = planDate;
  }
  
  public final static String P_PlanDate = "planDate";
  
  public static IObjectFieldAccessor<UIPlanDateTime,Date> PlanDateAccessor = new IObjectFieldAccessor<UIPlanDateTime,Date>(){
    				public java.util.Date getValue(UIPlanDateTime object){
    					return object.getPlanDate();
    				}
    				public void setValue(UIPlanDateTime object,java.util.Date value){
    					object.setPlanDate(value);
    				}
    			};
  
  private Date planTime;
  
  public Date getPlanTime() {
    return this.planTime;
  }
  
  public void setPlanTime(final Date planTime) {
    this.planTime = planTime;
  }
  
  public final static String P_PlanTime = "planTime";
  
  public static IObjectFieldAccessor<UIPlanDateTime,Date> PlanTimeAccessor = new IObjectFieldAccessor<UIPlanDateTime,Date>(){
    				public java.util.Date getValue(UIPlanDateTime object){
    					return object.getPlanTime();
    				}
    				public void setValue(UIPlanDateTime object,java.util.Date value){
    					object.setPlanTime(value);
    				}
    			};
}
