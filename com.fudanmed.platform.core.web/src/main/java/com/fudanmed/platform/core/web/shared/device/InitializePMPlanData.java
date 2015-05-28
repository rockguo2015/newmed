package com.fudanmed.platform.core.web.shared.device;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class InitializePMPlanData implements IsSerializable {
  private Integer year;
  
  public Integer getYear() {
    return this.year;
  }
  
  public void setYear(final Integer year) {
    this.year = year;
  }
  
  public final static String P_Year = "year";
  
  public static IObjectFieldAccessor<InitializePMPlanData,Integer> YearAccessor = new IObjectFieldAccessor<InitializePMPlanData,Integer>(){
    				public Integer getValue(InitializePMPlanData object){
    					return object.getYear();
    				}
    				public void setValue(InitializePMPlanData object,Integer value){
    					object.setYear(value);
    				}
    			};
  
  private Date fromDate;
  
  public Date getFromDate() {
    return this.fromDate;
  }
  
  public void setFromDate(final Date fromDate) {
    this.fromDate = fromDate;
  }
  
  public final static String P_FromDate = "fromDate";
  
  public static IObjectFieldAccessor<InitializePMPlanData,Date> FromDateAccessor = new IObjectFieldAccessor<InitializePMPlanData,Date>(){
    				public java.util.Date getValue(InitializePMPlanData object){
    					return object.getFromDate();
    				}
    				public void setValue(InitializePMPlanData object,java.util.Date value){
    					object.setFromDate(value);
    				}
    			};
}
