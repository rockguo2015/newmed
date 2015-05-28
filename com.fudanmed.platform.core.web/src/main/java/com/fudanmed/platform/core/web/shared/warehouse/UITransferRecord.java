package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCTransferRecordProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIWarehouseProductSpecSummary;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Collection;
import java.util.Date;

public class UITransferRecord extends GWTEntity {
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public void setSid(final String sid) {
    this.sid = sid;
  }
  
  public final static String P_Sid = "sid";
  
  public static IObjectFieldAccessor<UITransferRecord,String> SidAccessor = new IObjectFieldAccessor<UITransferRecord,String>(){
    				public String getValue(UITransferRecord object){
    					return object.getSid();
    				}
    				public void setValue(UITransferRecord object,String value){
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
  
  public static IObjectFieldAccessor<UITransferRecord,RCWarehouseProxy> SourceStoreAccessor = new IObjectFieldAccessor<UITransferRecord,RCWarehouseProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy getValue(UITransferRecord object){
    					return object.getSourceStore();
    				}
    				public void setValue(UITransferRecord object,com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy value){
    					object.setSourceStore(value);
    				}
    			};
  
  private RCWarehouseProxy targetStore;
  
  public RCWarehouseProxy getTargetStore() {
    return this.targetStore;
  }
  
  public void setTargetStore(final RCWarehouseProxy targetStore) {
    this.targetStore = targetStore;
  }
  
  public final static String P_TargetStore = "targetStore";
  
  public static IObjectFieldAccessor<UITransferRecord,RCWarehouseProxy> TargetStoreAccessor = new IObjectFieldAccessor<UITransferRecord,RCWarehouseProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy getValue(UITransferRecord object){
    					return object.getTargetStore();
    				}
    				public void setValue(UITransferRecord object,com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy value){
    					object.setTargetStore(value);
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
  
  public static IObjectFieldAccessor<UITransferRecord,Date> DateAccessor = new IObjectFieldAccessor<UITransferRecord,Date>(){
    				public java.util.Date getValue(UITransferRecord object){
    					return object.getDate();
    				}
    				public void setValue(UITransferRecord object,java.util.Date value){
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
  
  public static IObjectFieldAccessor<UITransferRecord,RCEmployeeProxy> OperatorAccessor = new IObjectFieldAccessor<UITransferRecord,RCEmployeeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy getValue(UITransferRecord object){
    					return object.getOperator();
    				}
    				public void setValue(UITransferRecord object,com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy value){
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
  
  public static IObjectFieldAccessor<UITransferRecord,Collection<UIWarehouseProductSpecSummary>> ItemSummarysAccessor = new IObjectFieldAccessor<UITransferRecord,Collection<UIWarehouseProductSpecSummary>>(){
    				public java.util.Collection<com.fudanmed.platform.core.web.shared.warehouse.UIWarehouseProductSpecSummary> getValue(UITransferRecord object){
    					return object.getItemSummarys();
    				}
    				public void setValue(UITransferRecord object,java.util.Collection<com.fudanmed.platform.core.web.shared.warehouse.UIWarehouseProductSpecSummary> value){
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
  
  public static IObjectFieldAccessor<UITransferRecord,String> CommentAccessor = new IObjectFieldAccessor<UITransferRecord,String>(){
    				public String getValue(UITransferRecord object){
    					return object.getComment();
    				}
    				public void setValue(UITransferRecord object,String value){
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
  
  public static IObjectFieldAccessor<UITransferRecord,Boolean> PrintAccessor = new IObjectFieldAccessor<UITransferRecord,Boolean>(){
    				public Boolean getValue(UITransferRecord object){
    					return object.getPrint();
    				}
    				public void setValue(UITransferRecord object,Boolean value){
    					object.setPrint(value);
    				}
    			};
  
  public RCTransferRecordProxy toProxy() {
    return (RCTransferRecordProxy)super.toProxy();
    
  }
}
