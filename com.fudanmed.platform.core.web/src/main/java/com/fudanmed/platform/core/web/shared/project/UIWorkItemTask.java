package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTaskStatus;
import com.fudanmed.platform.core.web.shared.project.UIWorker;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Collection;
import java.util.Date;

public class UIWorkItemTask extends GWTEntity {
  private String reportSid;
  
  public String getReportSid() {
    return this.reportSid;
  }
  
  public void setReportSid(final String reportSid) {
    this.reportSid = reportSid;
  }
  
  public final static String P_ReportSid = "reportSid";
  
  public static IObjectFieldAccessor<UIWorkItemTask,String> ReportSidAccessor = new IObjectFieldAccessor<UIWorkItemTask,String>(){
    				public String getValue(UIWorkItemTask object){
    					return object.getReportSid();
    				}
    				public void setValue(UIWorkItemTask object,String value){
    					object.setReportSid(value);
    				}
    			};
  
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public void setSid(final String sid) {
    this.sid = sid;
  }
  
  public final static String P_Sid = "sid";
  
  public static IObjectFieldAccessor<UIWorkItemTask,String> SidAccessor = new IObjectFieldAccessor<UIWorkItemTask,String>(){
    				public String getValue(UIWorkItemTask object){
    					return object.getSid();
    				}
    				public void setValue(UIWorkItemTask object,String value){
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
  
  public static IObjectFieldAccessor<UIWorkItemTask,Date> DateAccessor = new IObjectFieldAccessor<UIWorkItemTask,Date>(){
    				public java.util.Date getValue(UIWorkItemTask object){
    					return object.getDate();
    				}
    				public void setValue(UIWorkItemTask object,java.util.Date value){
    					object.setDate(value);
    				}
    			};
  
  private Date time;
  
  public Date getTime() {
    return this.time;
  }
  
  public void setTime(final Date time) {
    this.time = time;
  }
  
  public final static String P_Time = "time";
  
  public static IObjectFieldAccessor<UIWorkItemTask,Date> TimeAccessor = new IObjectFieldAccessor<UIWorkItemTask,Date>(){
    				public java.util.Date getValue(UIWorkItemTask object){
    					return object.getTime();
    				}
    				public void setValue(UIWorkItemTask object,java.util.Date value){
    					object.setTime(value);
    				}
    			};
  
  private Date dateTime;
  
  public Date getDateTime() {
    return this.dateTime;
  }
  
  public void setDateTime(final Date dateTime) {
    this.dateTime = dateTime;
  }
  
  public final static String P_DateTime = "dateTime";
  
  public static IObjectFieldAccessor<UIWorkItemTask,Date> DateTimeAccessor = new IObjectFieldAccessor<UIWorkItemTask,Date>(){
    				public java.util.Date getValue(UIWorkItemTask object){
    					return object.getDateTime();
    				}
    				public void setValue(UIWorkItemTask object,java.util.Date value){
    					object.setDateTime(value);
    				}
    			};
  
  private RCEmployeeProxy operator;
  
  public RCEmployeeProxy getOperator() {
    return this.operator;
  }
  
  public void setOperator(final RCEmployeeProxy operator) {
    this.operator = operator;
  }
  
  public final static String P_Operator = "operator";
  
  public static IObjectFieldAccessor<UIWorkItemTask,RCEmployeeProxy> OperatorAccessor = new IObjectFieldAccessor<UIWorkItemTask,RCEmployeeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy getValue(UIWorkItemTask object){
    					return object.getOperator();
    				}
    				public void setValue(UIWorkItemTask object,com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy value){
    					object.setOperator(value);
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
  
  public static IObjectFieldAccessor<UIWorkItemTask,RCFaultTypeProxy> FaultTypeAccessor = new IObjectFieldAccessor<UIWorkItemTask,RCFaultTypeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy getValue(UIWorkItemTask object){
    					return object.getFaultType();
    				}
    				public void setValue(UIWorkItemTask object,com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy value){
    					object.setFaultType(value);
    				}
    			};
  
  private String faultDescription;
  
  public String getFaultDescription() {
    return this.faultDescription;
  }
  
  public void setFaultDescription(final String faultDescription) {
    this.faultDescription = faultDescription;
  }
  
  public final static String P_FaultDescription = "faultDescription";
  
  public static IObjectFieldAccessor<UIWorkItemTask,String> FaultDescriptionAccessor = new IObjectFieldAccessor<UIWorkItemTask,String>(){
    				public String getValue(UIWorkItemTask object){
    					return object.getFaultDescription();
    				}
    				public void setValue(UIWorkItemTask object,String value){
    					object.setFaultDescription(value);
    				}
    			};
  
  private String stockStatus;
  
  public String getStockStatus() {
    return this.stockStatus;
  }
  
  public void setStockStatus(final String stockStatus) {
    this.stockStatus = stockStatus;
  }
  
  public final static String P_StockStatus = "stockStatus";
  
  public static IObjectFieldAccessor<UIWorkItemTask,String> StockStatusAccessor = new IObjectFieldAccessor<UIWorkItemTask,String>(){
    				public String getValue(UIWorkItemTask object){
    					return object.getStockStatus();
    				}
    				public void setValue(UIWorkItemTask object,String value){
    					object.setStockStatus(value);
    				}
    			};
  
  private Boolean bStockStatus;
  
  public Boolean getBStockStatus() {
    return this.bStockStatus;
  }
  
  public void setBStockStatus(final Boolean bStockStatus) {
    this.bStockStatus = bStockStatus;
  }
  
  public final static String P_BStockStatus = "bStockStatus";
  
  public static IObjectFieldAccessor<UIWorkItemTask,Boolean> BStockStatusAccessor = new IObjectFieldAccessor<UIWorkItemTask,Boolean>(){
    				public Boolean getValue(UIWorkItemTask object){
    					return object.getBStockStatus();
    				}
    				public void setValue(UIWorkItemTask object,Boolean value){
    					object.setBStockStatus(value);
    				}
    			};
  
  private Date finishDate;
  
  public Date getFinishDate() {
    return this.finishDate;
  }
  
  public void setFinishDate(final Date finishDate) {
    this.finishDate = finishDate;
  }
  
  public final static String P_FinishDate = "finishDate";
  
  public static IObjectFieldAccessor<UIWorkItemTask,Date> FinishDateAccessor = new IObjectFieldAccessor<UIWorkItemTask,Date>(){
    				public java.util.Date getValue(UIWorkItemTask object){
    					return object.getFinishDate();
    				}
    				public void setValue(UIWorkItemTask object,java.util.Date value){
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
  
  public static IObjectFieldAccessor<UIWorkItemTask,Date> FinishTimeAccessor = new IObjectFieldAccessor<UIWorkItemTask,Date>(){
    				public java.util.Date getValue(UIWorkItemTask object){
    					return object.getFinishTime();
    				}
    				public void setValue(UIWorkItemTask object,java.util.Date value){
    					object.setFinishTime(value);
    				}
    			};
  
  private Date finishDateTime;
  
  public Date getFinishDateTime() {
    return this.finishDateTime;
  }
  
  public void setFinishDateTime(final Date finishDateTime) {
    this.finishDateTime = finishDateTime;
  }
  
  public final static String P_FinishDateTime = "finishDateTime";
  
  public static IObjectFieldAccessor<UIWorkItemTask,Date> FinishDateTimeAccessor = new IObjectFieldAccessor<UIWorkItemTask,Date>(){
    				public java.util.Date getValue(UIWorkItemTask object){
    					return object.getFinishDateTime();
    				}
    				public void setValue(UIWorkItemTask object,java.util.Date value){
    					object.setFinishDateTime(value);
    				}
    			};
  
  private Collection<UIWorker> workers = com.google.common.collect.Lists.newArrayList();
  
  public Collection<UIWorker> getWorkers() {
    return this.workers;
  }
  
  public void setWorkers(final Collection<UIWorker> workers) {
    this.workers = workers;
  }
  
  public final static String P_Workers = "workers";
  
  public static IObjectFieldAccessor<UIWorkItemTask,Collection<UIWorker>> WorkersAccessor = new IObjectFieldAccessor<UIWorkItemTask,Collection<UIWorker>>(){
    				public java.util.Collection<com.fudanmed.platform.core.web.shared.project.UIWorker> getValue(UIWorkItemTask object){
    					return object.getWorkers();
    				}
    				public void setValue(UIWorkItemTask object,java.util.Collection<com.fudanmed.platform.core.web.shared.project.UIWorker> value){
    					object.setWorkers(value);
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
  
  public static IObjectFieldAccessor<UIWorkItemTask,String> CommentAccessor = new IObjectFieldAccessor<UIWorkItemTask,String>(){
    				public String getValue(UIWorkItemTask object){
    					return object.getComment();
    				}
    				public void setValue(UIWorkItemTask object,String value){
    					object.setComment(value);
    				}
    			};
  
  private UIWorkItemTaskStatus status;
  
  public UIWorkItemTaskStatus getStatus() {
    return this.status;
  }
  
  public void setStatus(final UIWorkItemTaskStatus status) {
    this.status = status;
  }
  
  public final static String P_Status = "status";
  
  public static IObjectFieldAccessor<UIWorkItemTask,UIWorkItemTaskStatus> StatusAccessor = new IObjectFieldAccessor<UIWorkItemTask,UIWorkItemTaskStatus>(){
    				public com.fudanmed.platform.core.web.shared.project.UIWorkItemTaskStatus getValue(UIWorkItemTask object){
    					return object.getStatus();
    				}
    				public void setValue(UIWorkItemTask object,com.fudanmed.platform.core.web.shared.project.UIWorkItemTaskStatus value){
    					object.setStatus(value);
    				}
    			};
  
  private Boolean hasDocuments;
  
  public Boolean getHasDocuments() {
    return this.hasDocuments;
  }
  
  public void setHasDocuments(final Boolean hasDocuments) {
    this.hasDocuments = hasDocuments;
  }
  
  public final static String P_HasDocuments = "hasDocuments";
  
  public static IObjectFieldAccessor<UIWorkItemTask,Boolean> HasDocumentsAccessor = new IObjectFieldAccessor<UIWorkItemTask,Boolean>(){
    				public Boolean getValue(UIWorkItemTask object){
    					return object.getHasDocuments();
    				}
    				public void setValue(UIWorkItemTask object,Boolean value){
    					object.setHasDocuments(value);
    				}
    			};
  
  private Boolean print;
  
  public Boolean getPrint() {
    return this.print;
  }
  
  public void setPrint(final Boolean print) {
    this.print = print;
  }
  
  public final static String P_Print = "print";
  
  public static IObjectFieldAccessor<UIWorkItemTask,Boolean> PrintAccessor = new IObjectFieldAccessor<UIWorkItemTask,Boolean>(){
    				public Boolean getValue(UIWorkItemTask object){
    					return object.getPrint();
    				}
    				public void setValue(UIWorkItemTask object,Boolean value){
    					object.setPrint(value);
    				}
    			};
  
  public RCWorkItemTaskProxy toProxy() {
    return (RCWorkItemTaskProxy)super.toProxy();
    
  }
}
