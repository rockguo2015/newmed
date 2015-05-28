package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemReturnStockRecordProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemProductSpecSummary;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Collection;
import java.util.Date;

public class UIWorkItemReturnStockRecord extends GWTEntity {
  private String reportSid;
  
  public String getReportSid() {
    return this.reportSid;
  }
  
  public void setReportSid(final String reportSid) {
    this.reportSid = reportSid;
  }
  
  public final static String P_ReportSid = "reportSid";
  
  public static IObjectFieldAccessor<UIWorkItemReturnStockRecord,String> ReportSidAccessor = new IObjectFieldAccessor<UIWorkItemReturnStockRecord,String>(){
    				public String getValue(UIWorkItemReturnStockRecord object){
    					return object.getReportSid();
    				}
    				public void setValue(UIWorkItemReturnStockRecord object,String value){
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
  
  public static IObjectFieldAccessor<UIWorkItemReturnStockRecord,String> SidAccessor = new IObjectFieldAccessor<UIWorkItemReturnStockRecord,String>(){
    				public String getValue(UIWorkItemReturnStockRecord object){
    					return object.getSid();
    				}
    				public void setValue(UIWorkItemReturnStockRecord object,String value){
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
  
  public static IObjectFieldAccessor<UIWorkItemReturnStockRecord,RCWarehouseProxy> SourceStoreAccessor = new IObjectFieldAccessor<UIWorkItemReturnStockRecord,RCWarehouseProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy getValue(UIWorkItemReturnStockRecord object){
    					return object.getSourceStore();
    				}
    				public void setValue(UIWorkItemReturnStockRecord object,com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy value){
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
  
  public static IObjectFieldAccessor<UIWorkItemReturnStockRecord,RCWorkItemTaskProxy> WorkItemAccessor = new IObjectFieldAccessor<UIWorkItemReturnStockRecord,RCWorkItemTaskProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy getValue(UIWorkItemReturnStockRecord object){
    					return object.getWorkItem();
    				}
    				public void setValue(UIWorkItemReturnStockRecord object,com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy value){
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
  
  public static IObjectFieldAccessor<UIWorkItemReturnStockRecord,Date> DateAccessor = new IObjectFieldAccessor<UIWorkItemReturnStockRecord,Date>(){
    				public java.util.Date getValue(UIWorkItemReturnStockRecord object){
    					return object.getDate();
    				}
    				public void setValue(UIWorkItemReturnStockRecord object,java.util.Date value){
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
  
  public static IObjectFieldAccessor<UIWorkItemReturnStockRecord,RCEmployeeProxy> OperatorAccessor = new IObjectFieldAccessor<UIWorkItemReturnStockRecord,RCEmployeeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy getValue(UIWorkItemReturnStockRecord object){
    					return object.getOperator();
    				}
    				public void setValue(UIWorkItemReturnStockRecord object,com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy value){
    					object.setOperator(value);
    				}
    			};
  
  private Collection<UIWorkItemProductSpecSummary> itemSummarys = com.google.common.collect.Lists.newArrayList();
  
  public Collection<UIWorkItemProductSpecSummary> getItemSummarys() {
    return this.itemSummarys;
  }
  
  public void setItemSummarys(final Collection<UIWorkItemProductSpecSummary> itemSummarys) {
    this.itemSummarys = itemSummarys;
  }
  
  public final static String P_ItemSummarys = "itemSummarys";
  
  public static IObjectFieldAccessor<UIWorkItemReturnStockRecord,Collection<UIWorkItemProductSpecSummary>> ItemSummarysAccessor = new IObjectFieldAccessor<UIWorkItemReturnStockRecord,Collection<UIWorkItemProductSpecSummary>>(){
    				public java.util.Collection<com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemProductSpecSummary> getValue(UIWorkItemReturnStockRecord object){
    					return object.getItemSummarys();
    				}
    				public void setValue(UIWorkItemReturnStockRecord object,java.util.Collection<com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemProductSpecSummary> value){
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
  
  public static IObjectFieldAccessor<UIWorkItemReturnStockRecord,String> CommentAccessor = new IObjectFieldAccessor<UIWorkItemReturnStockRecord,String>(){
    				public String getValue(UIWorkItemReturnStockRecord object){
    					return object.getComment();
    				}
    				public void setValue(UIWorkItemReturnStockRecord object,String value){
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
  
  public static IObjectFieldAccessor<UIWorkItemReturnStockRecord,Boolean> PrintAccessor = new IObjectFieldAccessor<UIWorkItemReturnStockRecord,Boolean>(){
    				public Boolean getValue(UIWorkItemReturnStockRecord object){
    					return object.getPrint();
    				}
    				public void setValue(UIWorkItemReturnStockRecord object,Boolean value){
    					object.setPrint(value);
    				}
    			};
  
  public RCWorkItemReturnStockRecordProxy toProxy() {
    return (RCWorkItemReturnStockRecordProxy)super.toProxy();
    
  }
}
