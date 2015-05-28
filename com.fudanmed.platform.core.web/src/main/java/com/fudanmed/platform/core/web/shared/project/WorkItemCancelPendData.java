package com.fudanmed.platform.core.web.shared.project;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class WorkItemCancelPendData implements IsSerializable {
  private Date finishDate;
  
  public Date getFinishDate() {
    return this.finishDate;
  }
  
  public void setFinishDate(final Date finishDate) {
    this.finishDate = finishDate;
  }
  
  public final static String P_FinishDate = "finishDate";
  
  public static IObjectFieldAccessor<WorkItemCancelPendData,Date> FinishDateAccessor = new IObjectFieldAccessor<WorkItemCancelPendData,Date>(){
    				public java.util.Date getValue(WorkItemCancelPendData object){
    					return object.getFinishDate();
    				}
    				public void setValue(WorkItemCancelPendData object,java.util.Date value){
    					object.setFinishDate(value);
    				}
    			};
  
  private Date finishTime;
  
  public Date getFinishTime() {
    return this.finishTime;
  }
  
  public void setFinishTime(final Date finishTime) {
    this.finishTime = finishTime;
  }
  
  public final static String P_FinishTime = "finishTime";
  
  public static IObjectFieldAccessor<WorkItemCancelPendData,Date> FinishTimeAccessor = new IObjectFieldAccessor<WorkItemCancelPendData,Date>(){
    				public java.util.Date getValue(WorkItemCancelPendData object){
    					return object.getFinishTime();
    				}
    				public void setValue(WorkItemCancelPendData object,java.util.Date value){
    					object.setFinishTime(value);
    				}
    			};
  
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public void setComment(final String comment) {
    this.comment = comment;
  }
  
  public final static String P_Comment = "comment";
  
  public static IObjectFieldAccessor<WorkItemCancelPendData,String> CommentAccessor = new IObjectFieldAccessor<WorkItemCancelPendData,String>(){
    				public String getValue(WorkItemCancelPendData object){
    					return object.getComment();
    				}
    				public void setValue(WorkItemCancelPendData object,String value){
    					object.setComment(value);
    				}
    			};
  
  private String deviceSid;
  
  public String getDeviceSid() {
    return this.deviceSid;
  }
  
  public void setDeviceSid(final String deviceSid) {
    this.deviceSid = deviceSid;
  }
  
  public final static String P_DeviceSid = "deviceSid";
  
  public static IObjectFieldAccessor<WorkItemCancelPendData,String> DeviceSidAccessor = new IObjectFieldAccessor<WorkItemCancelPendData,String>(){
    				public String getValue(WorkItemCancelPendData object){
    					return object.getDeviceSid();
    				}
    				public void setValue(WorkItemCancelPendData object,String value){
    					object.setDeviceSid(value);
    				}
    			};
  
  private Double price;
  
  public Double getPrice() {
    return this.price;
  }
  
  public void setPrice(final Double price) {
    this.price = price;
  }
  
  public final static String P_Price = "price";
  
  public static IObjectFieldAccessor<WorkItemCancelPendData,Double> PriceAccessor = new IObjectFieldAccessor<WorkItemCancelPendData,Double>(){
    				public Double getValue(WorkItemCancelPendData object){
    					return object.getPrice();
    				}
    				public void setValue(WorkItemCancelPendData object,Double value){
    					object.setPrice(value);
    				}
    			};
  
  private Boolean alsoReport;
  
  public Boolean getAlsoReport() {
    return this.alsoReport;
  }
  
  public void setAlsoReport(final Boolean alsoReport) {
    this.alsoReport = alsoReport;
  }
  
  public final static String P_AlsoReport = "alsoReport";
  
  public static IObjectFieldAccessor<WorkItemCancelPendData,Boolean> AlsoReportAccessor = new IObjectFieldAccessor<WorkItemCancelPendData,Boolean>(){
    				public Boolean getValue(WorkItemCancelPendData object){
    					return object.getAlsoReport();
    				}
    				public void setValue(WorkItemCancelPendData object,Boolean value){
    					object.setAlsoReport(value);
    				}
    			};
  
  private String reportComment;
  
  public String getReportComment() {
    return this.reportComment;
  }
  
  public void setReportComment(final String reportComment) {
    this.reportComment = reportComment;
  }
  
  public final static String P_ReportComment = "reportComment";
  
  public static IObjectFieldAccessor<WorkItemCancelPendData,String> ReportCommentAccessor = new IObjectFieldAccessor<WorkItemCancelPendData,String>(){
    				public String getValue(WorkItemCancelPendData object){
    					return object.getReportComment();
    				}
    				public void setValue(WorkItemCancelPendData object,String value){
    					object.setReportComment(value);
    				}
    			};
}
