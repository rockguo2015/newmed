package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStockRecordProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class UIWorkItemStockRecord extends GWTEntity {
  private String typeName;
  
  public String getTypeName() {
    return this.typeName;
  }
  
  public void setTypeName(final String typeName) {
    this.typeName = typeName;
  }
  
  public final static String P_TypeName = "typeName";
  
  public static IObjectFieldAccessor<UIWorkItemStockRecord,String> TypeNameAccessor = new IObjectFieldAccessor<UIWorkItemStockRecord,String>(){
    				public String getValue(UIWorkItemStockRecord object){
    					return object.getTypeName();
    				}
    				public void setValue(UIWorkItemStockRecord object,String value){
    					object.setTypeName(value);
    				}
    			};
  
  private String reportSid;
  
  public String getReportSid() {
    return this.reportSid;
  }
  
  public void setReportSid(final String reportSid) {
    this.reportSid = reportSid;
  }
  
  public final static String P_ReportSid = "reportSid";
  
  public static IObjectFieldAccessor<UIWorkItemStockRecord,String> ReportSidAccessor = new IObjectFieldAccessor<UIWorkItemStockRecord,String>(){
    				public String getValue(UIWorkItemStockRecord object){
    					return object.getReportSid();
    				}
    				public void setValue(UIWorkItemStockRecord object,String value){
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
  
  public static IObjectFieldAccessor<UIWorkItemStockRecord,String> SidAccessor = new IObjectFieldAccessor<UIWorkItemStockRecord,String>(){
    				public String getValue(UIWorkItemStockRecord object){
    					return object.getSid();
    				}
    				public void setValue(UIWorkItemStockRecord object,String value){
    					object.setSid(value);
    				}
    			};
  
  private RCWarehouseProxy sourceStore;
  
  public RCWarehouseProxy getSourceStore() {
    return this.sourceStore;
  }
  
  public void setSourceStore(final RCWarehouseProxy sourceStore) {
    this.sourceStore = sourceStore;
  }
  
  public final static String P_SourceStore = "sourceStore";
  
  public static IObjectFieldAccessor<UIWorkItemStockRecord,RCWarehouseProxy> SourceStoreAccessor = new IObjectFieldAccessor<UIWorkItemStockRecord,RCWarehouseProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy getValue(UIWorkItemStockRecord object){
    					return object.getSourceStore();
    				}
    				public void setValue(UIWorkItemStockRecord object,com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy value){
    					object.setSourceStore(value);
    				}
    			};
  
  private RCWorkItemTaskProxy workItem;
  
  public RCWorkItemTaskProxy getWorkItem() {
    return this.workItem;
  }
  
  public void setWorkItem(final RCWorkItemTaskProxy workItem) {
    this.workItem = workItem;
  }
  
  public final static String P_WorkItem = "workItem";
  
  public static IObjectFieldAccessor<UIWorkItemStockRecord,RCWorkItemTaskProxy> WorkItemAccessor = new IObjectFieldAccessor<UIWorkItemStockRecord,RCWorkItemTaskProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy getValue(UIWorkItemStockRecord object){
    					return object.getWorkItem();
    				}
    				public void setValue(UIWorkItemStockRecord object,com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy value){
    					object.setWorkItem(value);
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
  
  public static IObjectFieldAccessor<UIWorkItemStockRecord,Date> DateAccessor = new IObjectFieldAccessor<UIWorkItemStockRecord,Date>(){
    				public java.util.Date getValue(UIWorkItemStockRecord object){
    					return object.getDate();
    				}
    				public void setValue(UIWorkItemStockRecord object,java.util.Date value){
    					object.setDate(value);
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
  
  public static IObjectFieldAccessor<UIWorkItemStockRecord,RCEmployeeProxy> OperatorAccessor = new IObjectFieldAccessor<UIWorkItemStockRecord,RCEmployeeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy getValue(UIWorkItemStockRecord object){
    					return object.getOperator();
    				}
    				public void setValue(UIWorkItemStockRecord object,com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy value){
    					object.setOperator(value);
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
  
  public static IObjectFieldAccessor<UIWorkItemStockRecord,String> CommentAccessor = new IObjectFieldAccessor<UIWorkItemStockRecord,String>(){
    				public String getValue(UIWorkItemStockRecord object){
    					return object.getComment();
    				}
    				public void setValue(UIWorkItemStockRecord object,String value){
    					object.setComment(value);
    				}
    			};
  
  public RCWorkItemStockRecordProxy toProxy() {
    return (RCWorkItemStockRecordProxy)super.toProxy();
    
  }
}
