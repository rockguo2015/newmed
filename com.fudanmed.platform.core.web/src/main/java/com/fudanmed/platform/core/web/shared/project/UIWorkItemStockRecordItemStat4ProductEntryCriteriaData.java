package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIWorkItemStockRecordItemStat4ProductEntryCriteriaData implements IsSerializable {
  private RCProductSpecificationProxy productEntry;
  
  public RCProductSpecificationProxy getProductEntry() {
    return this.productEntry;
  }
  
  public void setProductEntry(final RCProductSpecificationProxy productEntry) {
    this.productEntry = productEntry;
  }
  
  public final static String P_ProductEntry = "productEntry";
  
  public static IObjectFieldAccessor<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData,RCProductSpecificationProxy> ProductEntryAccessor = new IObjectFieldAccessor<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData,RCProductSpecificationProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy getValue(UIWorkItemStockRecordItemStat4ProductEntryCriteriaData object){
    					return object.getProductEntry();
    				}
    				public void setValue(UIWorkItemStockRecordItemStat4ProductEntryCriteriaData object,com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy value){
    					object.setProductEntry(value);
    				}
    			};
  
  private String typeDesc;
  
  public String getTypeDesc() {
    return this.typeDesc;
  }
  
  public void setTypeDesc(final String typeDesc) {
    this.typeDesc = typeDesc;
  }
  
  public final static String P_TypeDesc = "typeDesc";
  
  public static IObjectFieldAccessor<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData,String> TypeDescAccessor = new IObjectFieldAccessor<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData,String>(){
    				public String getValue(UIWorkItemStockRecordItemStat4ProductEntryCriteriaData object){
    					return object.getTypeDesc();
    				}
    				public void setValue(UIWorkItemStockRecordItemStat4ProductEntryCriteriaData object,String value){
    					object.setTypeDesc(value);
    				}
    			};
  
  private Long cnt;
  
  public Long getCnt() {
    return this.cnt;
  }
  
  public void setCnt(final Long cnt) {
    this.cnt = cnt;
  }
  
  public final static String P_Cnt = "cnt";
  
  public static IObjectFieldAccessor<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData,Long> CntAccessor = new IObjectFieldAccessor<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData,Long>(){
    				public Long getValue(UIWorkItemStockRecordItemStat4ProductEntryCriteriaData object){
    					return object.getCnt();
    				}
    				public void setValue(UIWorkItemStockRecordItemStat4ProductEntryCriteriaData object,Long value){
    					object.setCnt(value);
    				}
    			};
  
  private String unit;
  
  public String getUnit() {
    return this.unit;
  }
  
  public void setUnit(final String unit) {
    this.unit = unit;
  }
  
  public final static String P_Unit = "unit";
  
  public static IObjectFieldAccessor<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData,String> UnitAccessor = new IObjectFieldAccessor<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData,String>(){
    				public String getValue(UIWorkItemStockRecordItemStat4ProductEntryCriteriaData object){
    					return object.getUnit();
    				}
    				public void setValue(UIWorkItemStockRecordItemStat4ProductEntryCriteriaData object,String value){
    					object.setUnit(value);
    				}
    			};
}
