package com.fudanmed.platform.core.web.shared.project;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class WorkItemFinishReportData implements IsSerializable {
  private Date finishDate;
  
  public Date getFinishDate() {
    return this.finishDate;
  }
  
  public void setFinishDate(final Date finishDate) {
    this.finishDate = finishDate;
  }
  
  public final static String P_FinishDate = "finishDate";
  
  public static IObjectFieldAccessor<WorkItemFinishReportData,Date> FinishDateAccessor = new IObjectFieldAccessor<WorkItemFinishReportData,Date>(){
    				public java.util.Date getValue(WorkItemFinishReportData object){
    					return object.getFinishDate();
    				}
    				public void setValue(WorkItemFinishReportData object,java.util.Date value){
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
  
  public static IObjectFieldAccessor<WorkItemFinishReportData,Date> FinishTimeAccessor = new IObjectFieldAccessor<WorkItemFinishReportData,Date>(){
    				public java.util.Date getValue(WorkItemFinishReportData object){
    					return object.getFinishTime();
    				}
    				public void setValue(WorkItemFinishReportData object,java.util.Date value){
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
  
  public static IObjectFieldAccessor<WorkItemFinishReportData,String> CommentAccessor = new IObjectFieldAccessor<WorkItemFinishReportData,String>(){
    				public String getValue(WorkItemFinishReportData object){
    					return object.getComment();
    				}
    				public void setValue(WorkItemFinishReportData object,String value){
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
  
  public static IObjectFieldAccessor<WorkItemFinishReportData,String> DeviceSidAccessor = new IObjectFieldAccessor<WorkItemFinishReportData,String>(){
    				public String getValue(WorkItemFinishReportData object){
    					return object.getDeviceSid();
    				}
    				public void setValue(WorkItemFinishReportData object,String value){
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
  
  public static IObjectFieldAccessor<WorkItemFinishReportData,Double> PriceAccessor = new IObjectFieldAccessor<WorkItemFinishReportData,Double>(){
    				public Double getValue(WorkItemFinishReportData object){
    					return object.getPrice();
    				}
    				public void setValue(WorkItemFinishReportData object,Double value){
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
  
  public static IObjectFieldAccessor<WorkItemFinishReportData,Boolean> AlsoReportAccessor = new IObjectFieldAccessor<WorkItemFinishReportData,Boolean>(){
    				public Boolean getValue(WorkItemFinishReportData object){
    					return object.getAlsoReport();
    				}
    				public void setValue(WorkItemFinishReportData object,Boolean value){
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
  
  public static IObjectFieldAccessor<WorkItemFinishReportData,String> ReportCommentAccessor = new IObjectFieldAccessor<WorkItemFinishReportData,String>(){
    				public String getValue(WorkItemFinishReportData object){
    					return object.getReportComment();
    				}
    				public void setValue(WorkItemFinishReportData object,String value){
    					object.setReportComment(value);
    				}
    			};
}
