package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingListProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class UIStockTakingList extends GWTEntity {
  private Date date;
  
  public Date getDate() {
    return this.date;
  }
  
  public void setDate(final Date date) {
    this.date = date;
  }
  
  public final static String P_Date = "date";
  
  public static IObjectFieldAccessor<UIStockTakingList,Date> DateAccessor = new IObjectFieldAccessor<UIStockTakingList,Date>(){
    				public java.util.Date getValue(UIStockTakingList object){
    					return object.getDate();
    				}
    				public void setValue(UIStockTakingList object,java.util.Date value){
    					object.setDate(value);
    				}
    			};
  
  private RCWarehouseProxy warehouse;
  
  public RCWarehouseProxy getWarehouse() {
    return this.warehouse;
  }
  
  public void setWarehouse(final RCWarehouseProxy warehouse) {
    this.warehouse = warehouse;
  }
  
  public final static String P_Warehouse = "warehouse";
  
  public static IObjectFieldAccessor<UIStockTakingList,RCWarehouseProxy> WarehouseAccessor = new IObjectFieldAccessor<UIStockTakingList,RCWarehouseProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy getValue(UIStockTakingList object){
    					return object.getWarehouse();
    				}
    				public void setValue(UIStockTakingList object,com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy value){
    					object.setWarehouse(value);
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
  
  public static IObjectFieldAccessor<UIStockTakingList,String> CommentAccessor = new IObjectFieldAccessor<UIStockTakingList,String>(){
    				public String getValue(UIStockTakingList object){
    					return object.getComment();
    				}
    				public void setValue(UIStockTakingList object,String value){
    					object.setComment(value);
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
  
  public static IObjectFieldAccessor<UIStockTakingList,RCEmployeeProxy> OperatorAccessor = new IObjectFieldAccessor<UIStockTakingList,RCEmployeeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy getValue(UIStockTakingList object){
    					return object.getOperator();
    				}
    				public void setValue(UIStockTakingList object,com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy value){
    					object.setOperator(value);
    				}
    			};
  
  private Boolean isCommited;
  
  public Boolean getIsCommited() {
    return this.isCommited;
  }
  
  public void setIsCommited(final Boolean isCommited) {
    this.isCommited = isCommited;
  }
  
  public final static String P_IsCommited = "isCommited";
  
  public static IObjectFieldAccessor<UIStockTakingList,Boolean> IsCommitedAccessor = new IObjectFieldAccessor<UIStockTakingList,Boolean>(){
    				public Boolean getValue(UIStockTakingList object){
    					return object.getIsCommited();
    				}
    				public void setValue(UIStockTakingList object,Boolean value){
    					object.setIsCommited(value);
    				}
    			};
  
  public RCStockTakingListProxy toProxy() {
    return (RCStockTakingListProxy)super.toProxy();
    
  }
}
