package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingRecordProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIWarehouseProductSpecSummary;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Collection;
import java.util.Date;

public class UIStockTakingRecord extends GWTEntity {
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public void setSid(final String sid) {
    this.sid = sid;
  }
  
  public final static String P_Sid = "sid";
  
  public static IObjectFieldAccessor<UIStockTakingRecord,String> SidAccessor = new IObjectFieldAccessor<UIStockTakingRecord,String>(){
    				public String getValue(UIStockTakingRecord object){
    					return object.getSid();
    				}
    				public void setValue(UIStockTakingRecord object,String value){
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
  
  public static IObjectFieldAccessor<UIStockTakingRecord,RCWarehouseProxy> SourceStoreAccessor = new IObjectFieldAccessor<UIStockTakingRecord,RCWarehouseProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy getValue(UIStockTakingRecord object){
    					return object.getSourceStore();
    				}
    				public void setValue(UIStockTakingRecord object,com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy value){
    					object.setSourceStore(value);
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
  
  public static IObjectFieldAccessor<UIStockTakingRecord,Date> DateAccessor = new IObjectFieldAccessor<UIStockTakingRecord,Date>(){
    				public java.util.Date getValue(UIStockTakingRecord object){
    					return object.getDate();
    				}
    				public void setValue(UIStockTakingRecord object,java.util.Date value){
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
  
  public static IObjectFieldAccessor<UIStockTakingRecord,RCEmployeeProxy> OperatorAccessor = new IObjectFieldAccessor<UIStockTakingRecord,RCEmployeeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy getValue(UIStockTakingRecord object){
    					return object.getOperator();
    				}
    				public void setValue(UIStockTakingRecord object,com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy value){
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
  
  public static IObjectFieldAccessor<UIStockTakingRecord,Collection<UIWarehouseProductSpecSummary>> ItemSummarysAccessor = new IObjectFieldAccessor<UIStockTakingRecord,Collection<UIWarehouseProductSpecSummary>>(){
    				public java.util.Collection<com.fudanmed.platform.core.web.shared.warehouse.UIWarehouseProductSpecSummary> getValue(UIStockTakingRecord object){
    					return object.getItemSummarys();
    				}
    				public void setValue(UIStockTakingRecord object,java.util.Collection<com.fudanmed.platform.core.web.shared.warehouse.UIWarehouseProductSpecSummary> value){
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
  
  public static IObjectFieldAccessor<UIStockTakingRecord,String> CommentAccessor = new IObjectFieldAccessor<UIStockTakingRecord,String>(){
    				public String getValue(UIStockTakingRecord object){
    					return object.getComment();
    				}
    				public void setValue(UIStockTakingRecord object,String value){
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
  
  public static IObjectFieldAccessor<UIStockTakingRecord,Boolean> PrintAccessor = new IObjectFieldAccessor<UIStockTakingRecord,Boolean>(){
    				public Boolean getValue(UIStockTakingRecord object){
    					return object.getPrint();
    				}
    				public void setValue(UIStockTakingRecord object,Boolean value){
    					object.setPrint(value);
    				}
    			};
  
  private Boolean committed;
  
  public Boolean getCommitted() {
    return this.committed;
  }
  
  public void setCommitted(final Boolean committed) {
    this.committed = committed;
  }
  
  public final static String P_Committed = "committed";
  
  public static IObjectFieldAccessor<UIStockTakingRecord,Boolean> CommittedAccessor = new IObjectFieldAccessor<UIStockTakingRecord,Boolean>(){
    				public Boolean getValue(UIStockTakingRecord object){
    					return object.getCommitted();
    				}
    				public void setValue(UIStockTakingRecord object,Boolean value){
    					object.setCommitted(value);
    				}
    			};
  
  public RCStockTakingRecordProxy toProxy() {
    return (RCStockTakingRecordProxy)super.toProxy();
    
  }
}
