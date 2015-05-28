package com.fudanmed.platform.core.web.shared.device;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class BatchInitializePMPlanData implements IsSerializable {
  private Date fromDate;
  
  public Date getFromDate() {
    return this.fromDate;
  }
  
  public void setFromDate(final Date fromDate) {
    this.fromDate = fromDate;
  }
  
  public final static String P_FromDate = "fromDate";
  
  public static IObjectFieldAccessor<BatchInitializePMPlanData,Date> FromDateAccessor = new IObjectFieldAccessor<BatchInitializePMPlanData,Date>(){
    				public java.util.Date getValue(BatchInitializePMPlanData object){
    					return object.getFromDate();
    				}
    				public void setValue(BatchInitializePMPlanData object,java.util.Date value){
    					object.setFromDate(value);
    				}
    			};
  
  private Integer year;
  
  public Integer getYear() {
    return this.year;
  }
  
  public void setYear(final Integer year) {
    this.year = year;
  }
  
  public final static String P_Year = "year";
  
  public static IObjectFieldAccessor<BatchInitializePMPlanData,Integer> YearAccessor = new IObjectFieldAccessor<BatchInitializePMPlanData,Integer>(){
    				public Integer getValue(BatchInitializePMPlanData object){
    					return object.getYear();
    				}
    				public void setValue(BatchInitializePMPlanData object,Integer value){
    					object.setYear(value);
    				}
    			};
}
