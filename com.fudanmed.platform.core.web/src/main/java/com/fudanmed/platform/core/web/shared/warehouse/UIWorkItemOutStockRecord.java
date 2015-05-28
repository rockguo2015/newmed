package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemOutStockRecordProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIWarehouseProductSpecSummary;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Collection;
import java.util.Date;

public class UIWorkItemOutStockRecord extends GWTEntity {
  private String reportSid;
  
  public String getReportSid() {
    return this.reportSid;
  }
  
  public void setReportSid(final String reportSid) {
    this.reportSid = reportSid;
  }
  
  public final static String P_ReportSid = "reportSid";
  
  public static IObjectFieldAccessor<UIWorkItemOutStockRecord,String> ReportSidAccessor = new IObjectFieldAccessor<UIWorkItemOutStockRecord,String>(){
    				public String getValue(UIWorkItemOutStockRecord object){
    					return object.getReportSid();
    				}
    				public void setValue(UIWorkItemOutStockRecord object,String value){
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
  
  public static IObjectFieldAccessor<UIWorkItemOutStockRecord,String> SidAccessor = new IObjectFieldAccessor<UIWorkItemOutStockRecord,String>(){
    				public String getValue(UIWorkItemOutStockRecord object){
    					return object.getSid();
    				}
    				public void setValue(UIWorkItemOutStockRecord object,String value){
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
  
  public static IObjectFieldAccessor<UIWorkItemOutStockRecord,RCWarehouseProxy> SourceStoreAccessor = new IObjectFieldAccessor<UIWorkItemOutStockRecord,RCWarehouseProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy getValue(UIWorkItemOutStockRecord object){
    					return object.getSourceStore();
    				}
    				public void setValue(UIWorkItemOutStockRecord object,com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy value){
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
  
  public static IObjectFieldAccessor<UIWorkItemOutStockRecord,RCWorkItemTaskProxy> WorkItemAccessor = new IObjectFieldAccessor<UIWorkItemOutStockRecord,RCWorkItemTaskProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy getValue(UIWorkItemOutStockRecord object){
    					return object.getWorkItem();
    				}
    				public void setValue(UIWorkItemOutStockRecord object,com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy value){
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
  
  public static IObjectFieldAccessor<UIWorkItemOutStockRecord,Date> DateAccessor = new IObjectFieldAccessor<UIWorkItemOutStockRecord,Date>(){
    				public java.util.Date getValue(UIWorkItemOutStockRecord object){
    					return object.getDate();
    				}
    				public void setValue(UIWorkItemOutStockRecord object,java.util.Date value){
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
  
  public static IObjectFieldAccessor<UIWorkItemOutStockRecord,RCEmployeeProxy> OperatorAccessor = new IObjectFieldAccessor<UIWorkItemOutStockRecord,RCEmployeeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy getValue(UIWorkItemOutStockRecord object){
    					return object.getOperator();
    				}
    				public void setValue(UIWorkItemOutStockRecord object,com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy value){
    					object.setOperator(value);
    				}
    			};
  
  private Collection<UIWarehouseProductSpecSummary> itemSummarys = com.google.common.collect.Lists.newArrayList();
  
  public Collection<UIWarehouseProductSpecSummary> getItemSummarys() {
    return this.itemSummarys;
  }
  
  public void setItemSummarys(final Collection<UIWarehouseProductSpecSummary> itemSummarys) {
    this.itemSummarys = itemSummarys;
  }
  
  public final static String P_ItemSummarys = "itemSummarys";
  
  public static IObjectFieldAccessor<UIWorkItemOutStockRecord,Collection<UIWarehouseProductSpecSummary>> ItemSummarysAccessor = new IObjectFieldAccessor<UIWorkItemOutStockRecord,Collection<UIWarehouseProductSpecSummary>>(){
    				public java.util.Collection<com.fudanmed.platform.core.web.shared.warehouse.UIWarehouseProductSpecSummary> getValue(UIWorkItemOutStockRecord object){
    					return object.getItemSummarys();
    				}
    				public void setValue(UIWorkItemOutStockRecord object,java.util.Collection<com.fudanmed.platform.core.web.shared.warehouse.UIWarehouseProductSpecSummary> value){
    					object.setItemSummarys(value);
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
  
  public static IObjectFieldAccessor<UIWorkItemOutStockRecord,String> CommentAccessor = new IObjectFieldAccessor<UIWorkItemOutStockRecord,String>(){
    				public String getValue(UIWorkItemOutStockRecord object){
    					return object.getComment();
    				}
    				public void setValue(UIWorkItemOutStockRecord object,String value){
    					object.setComment(value);
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
  
  public static IObjectFieldAccessor<UIWorkItemOutStockRecord,Boolean> PrintAccessor = new IObjectFieldAccessor<UIWorkItemOutStockRecord,Boolean>(){
    				public Boolean getValue(UIWorkItemOutStockRecord object){
    					return object.getPrint();
    				}
    				public void setValue(UIWorkItemOutStockRecord object,Boolean value){
    					object.setPrint(value);
    				}
    			};
  
  private Boolean fitPrint;
  
  public Boolean getFitPrint() {
    return this.fitPrint;
  }
  
  public void setFitPrint(final Boolean fitPrint) {
    this.fitPrint = fitPrint;
  }
  
  public final static String P_FitPrint = "fitPrint";
  
  public static IObjectFieldAccessor<UIWorkItemOutStockRecord,Boolean> FitPrintAccessor = new IObjectFieldAccessor<UIWorkItemOutStockRecord,Boolean>(){
    				public Boolean getValue(UIWorkItemOutStockRecord object){
    					return object.getFitPrint();
    				}
    				public void setValue(UIWorkItemOutStockRecord object,Boolean value){
    					object.setFitPrint(value);
    				}
    			};
  
  public RCWorkItemOutStockRecordProxy toProxy() {
    return (RCWorkItemOutStockRecordProxy)super.toProxy();
    
  }
}
