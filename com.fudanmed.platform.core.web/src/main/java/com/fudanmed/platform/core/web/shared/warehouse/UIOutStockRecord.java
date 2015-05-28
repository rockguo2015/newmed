package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.common.proxy.RCOutStockTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCOutStockRecordProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIWarehouseProductSpecSummary;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Collection;
import java.util.Date;

public class UIOutStockRecord extends GWTEntity {
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public void setSid(final String sid) {
    this.sid = sid;
  }
  
  public final static String P_Sid = "sid";
  
  public static IObjectFieldAccessor<UIOutStockRecord,String> SidAccessor = new IObjectFieldAccessor<UIOutStockRecord,String>(){
    				public String getValue(UIOutStockRecord object){
    					return object.getSid();
    				}
    				public void setValue(UIOutStockRecord object,String value){
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
  
  public static IObjectFieldAccessor<UIOutStockRecord,RCWarehouseProxy> SourceStoreAccessor = new IObjectFieldAccessor<UIOutStockRecord,RCWarehouseProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy getValue(UIOutStockRecord object){
    					return object.getSourceStore();
    				}
    				public void setValue(UIOutStockRecord object,com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy value){
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
  
  public static IObjectFieldAccessor<UIOutStockRecord,Date> DateAccessor = new IObjectFieldAccessor<UIOutStockRecord,Date>(){
    				public java.util.Date getValue(UIOutStockRecord object){
    					return object.getDate();
    				}
    				public void setValue(UIOutStockRecord object,java.util.Date value){
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
  
  public static IObjectFieldAccessor<UIOutStockRecord,RCEmployeeProxy> OperatorAccessor = new IObjectFieldAccessor<UIOutStockRecord,RCEmployeeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy getValue(UIOutStockRecord object){
    					return object.getOperator();
    				}
    				public void setValue(UIOutStockRecord object,com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy value){
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
  
  public static IObjectFieldAccessor<UIOutStockRecord,Collection<UIWarehouseProductSpecSummary>> ItemSummarysAccessor = new IObjectFieldAccessor<UIOutStockRecord,Collection<UIWarehouseProductSpecSummary>>(){
    				public java.util.Collection<com.fudanmed.platform.core.web.shared.warehouse.UIWarehouseProductSpecSummary> getValue(UIOutStockRecord object){
    					return object.getItemSummarys();
    				}
    				public void setValue(UIOutStockRecord object,java.util.Collection<com.fudanmed.platform.core.web.shared.warehouse.UIWarehouseProductSpecSummary> value){
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
  
  public static IObjectFieldAccessor<UIOutStockRecord,String> CommentAccessor = new IObjectFieldAccessor<UIOutStockRecord,String>(){
    				public String getValue(UIOutStockRecord object){
    					return object.getComment();
    				}
    				public void setValue(UIOutStockRecord object,String value){
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
  
  public static IObjectFieldAccessor<UIOutStockRecord,Boolean> PrintAccessor = new IObjectFieldAccessor<UIOutStockRecord,Boolean>(){
    				public Boolean getValue(UIOutStockRecord object){
    					return object.getPrint();
    				}
    				public void setValue(UIOutStockRecord object,Boolean value){
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
  
  public static IObjectFieldAccessor<UIOutStockRecord,Boolean> CommittedAccessor = new IObjectFieldAccessor<UIOutStockRecord,Boolean>(){
    				public Boolean getValue(UIOutStockRecord object){
    					return object.getCommitted();
    				}
    				public void setValue(UIOutStockRecord object,Boolean value){
    					object.setCommitted(value);
    				}
    			};
  
  private RCOutStockTypeProxy type;
  
  public RCOutStockTypeProxy getType() {
    return this.type;
  }
  
  public void setType(final RCOutStockTypeProxy type) {
    this.type = type;
  }
  
  public final static String P_Type = "type";
  
  public static IObjectFieldAccessor<UIOutStockRecord,RCOutStockTypeProxy> TypeAccessor = new IObjectFieldAccessor<UIOutStockRecord,RCOutStockTypeProxy>(){
    				public com.fudanmed.platform.core.common.proxy.RCOutStockTypeProxy getValue(UIOutStockRecord object){
    					return object.getType();
    				}
    				public void setValue(UIOutStockRecord object,com.fudanmed.platform.core.common.proxy.RCOutStockTypeProxy value){
    					object.setType(value);
    				}
    			};
  
  private RCMaintenanceTeamProxy team;
  
  public RCMaintenanceTeamProxy getTeam() {
    return this.team;
  }
  
  public void setTeam(final RCMaintenanceTeamProxy team) {
    this.team = team;
  }
  
  public final static String P_Team = "team";
  
  public static IObjectFieldAccessor<UIOutStockRecord,RCMaintenanceTeamProxy> TeamAccessor = new IObjectFieldAccessor<UIOutStockRecord,RCMaintenanceTeamProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy getValue(UIOutStockRecord object){
    					return object.getTeam();
    				}
    				public void setValue(UIOutStockRecord object,com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy value){
    					object.setTeam(value);
    				}
    			};
  
  private RCEmployeeProxy worker;
  
  public RCEmployeeProxy getWorker() {
    return this.worker;
  }
  
  public void setWorker(final RCEmployeeProxy worker) {
    this.worker = worker;
  }
  
  public final static String P_Worker = "worker";
  
  public static IObjectFieldAccessor<UIOutStockRecord,RCEmployeeProxy> WorkerAccessor = new IObjectFieldAccessor<UIOutStockRecord,RCEmployeeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy getValue(UIOutStockRecord object){
    					return object.getWorker();
    				}
    				public void setValue(UIOutStockRecord object,com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy value){
    					object.setWorker(value);
    				}
    			};
  
  public RCOutStockRecordProxy toProxy() {
    return (RCOutStockRecordProxy)super.toProxy();
    
  }
}
