package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.domain.proxy.RCSettlementProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class UISettlement extends GWTEntity {
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public void setSid(final String sid) {
    this.sid = sid;
  }
  
  public final static String P_Sid = "sid";
  
  public static IObjectFieldAccessor<UISettlement,String> SidAccessor = new IObjectFieldAccessor<UISettlement,String>(){
    				public String getValue(UISettlement object){
    					return object.getSid();
    				}
    				public void setValue(UISettlement object,String value){
    					object.setSid(value);
    				}
    			};
  
  private Date date;
  
  public Date getDate() {
    return this.date;
  }
  
  public void setDate(final Date date) {
    this.date = date;
  }
  
  public final static String P_Date = "date";
  
  public static IObjectFieldAccessor<UISettlement,Date> DateAccessor = new IObjectFieldAccessor<UISettlement,Date>(){
    				public java.util.Date getValue(UISettlement object){
    					return object.getDate();
    				}
    				public void setValue(UISettlement object,java.util.Date value){
    					object.setDate(value);
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
  
  public static IObjectFieldAccessor<UISettlement,Date> FromDateAccessor = new IObjectFieldAccessor<UISettlement,Date>(){
    				public java.util.Date getValue(UISettlement object){
    					return object.getFromDate();
    				}
    				public void setValue(UISettlement object,java.util.Date value){
    					object.setFromDate(value);
    				}
    			};
  
  private Date toDate;
  
  public Date getToDate() {
    return this.toDate;
  }
  
  public void setToDate(final Date toDate) {
    this.toDate = toDate;
  }
  
  public final static String P_ToDate = "toDate";
  
  public static IObjectFieldAccessor<UISettlement,Date> ToDateAccessor = new IObjectFieldAccessor<UISettlement,Date>(){
    				public java.util.Date getValue(UISettlement object){
    					return object.getToDate();
    				}
    				public void setValue(UISettlement object,java.util.Date value){
    					object.setToDate(value);
    				}
    			};
  
  private String description;
  
  public String getDescription() {
    return this.description;
  }
  
  public void setDescription(final String description) {
    this.description = description;
  }
  
  public final static String P_Description = "description";
  
  public static IObjectFieldAccessor<UISettlement,String> DescriptionAccessor = new IObjectFieldAccessor<UISettlement,String>(){
    				public String getValue(UISettlement object){
    					return object.getDescription();
    				}
    				public void setValue(UISettlement object,String value){
    					object.setDescription(value);
    				}
    			};
  
  private Double totalAmount;
  
  public Double getTotalAmount() {
    return this.totalAmount;
  }
  
  public void setTotalAmount(final Double totalAmount) {
    this.totalAmount = totalAmount;
  }
  
  public final static String P_TotalAmount = "totalAmount";
  
  public static IObjectFieldAccessor<UISettlement,Double> TotalAmountAccessor = new IObjectFieldAccessor<UISettlement,Double>(){
    				public Double getValue(UISettlement object){
    					return object.getTotalAmount();
    				}
    				public void setValue(UISettlement object,Double value){
    					object.setTotalAmount(value);
    				}
    			};
  
  public RCSettlementProxy toProxy() {
    return (RCSettlementProxy)super.toProxy();
    
  }
}
