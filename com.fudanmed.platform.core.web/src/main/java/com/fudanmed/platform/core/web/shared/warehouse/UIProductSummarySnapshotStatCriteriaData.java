package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductWarehouseStorageSummaryProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIProductSummarySnapshotStatCriteriaData implements IsSerializable {
  private RCProductWarehouseStorageSummaryProxy storageSummary;
  
  public RCProductWarehouseStorageSummaryProxy getStorageSummary() {
    return this.storageSummary;
  }
  
  public void setStorageSummary(final RCProductWarehouseStorageSummaryProxy storageSummary) {
    this.storageSummary = storageSummary;
  }
  
  public final static String P_StorageSummary = "storageSummary";
  
  public static IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,RCProductWarehouseStorageSummaryProxy> StorageSummaryAccessor = new IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,RCProductWarehouseStorageSummaryProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProductWarehouseStorageSummaryProxy getValue(UIProductSummarySnapshotStatCriteriaData object){
    					return object.getStorageSummary();
    				}
    				public void setValue(UIProductSummarySnapshotStatCriteriaData object,com.fudanmed.platform.core.warehouse.proxy.RCProductWarehouseStorageSummaryProxy value){
    					object.setStorageSummary(value);
    				}
    			};
  
  private RCWarehouseProxy store;
  
  public RCWarehouseProxy getStore() {
    return this.store;
  }
  
  public void setStore(final RCWarehouseProxy store) {
    this.store = store;
  }
  
  public final static String P_Store = "store";
  
  public static IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,RCWarehouseProxy> StoreAccessor = new IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,RCWarehouseProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy getValue(UIProductSummarySnapshotStatCriteriaData object){
    					return object.getStore();
    				}
    				public void setValue(UIProductSummarySnapshotStatCriteriaData object,com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy value){
    					object.setStore(value);
    				}
    			};
  
  private RCProductSpecificationProxy productSpec;
  
  public RCProductSpecificationProxy getProductSpec() {
    return this.productSpec;
  }
  
  public void setProductSpec(final RCProductSpecificationProxy productSpec) {
    this.productSpec = productSpec;
  }
  
  public final static String P_ProductSpec = "productSpec";
  
  public static IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,RCProductSpecificationProxy> ProductSpecAccessor = new IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,RCProductSpecificationProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy getValue(UIProductSummarySnapshotStatCriteriaData object){
    					return object.getProductSpec();
    				}
    				public void setValue(UIProductSummarySnapshotStatCriteriaData object,com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy value){
    					object.setProductSpec(value);
    				}
    			};
  
  private Long startQuantity;
  
  public Long getStartQuantity() {
    return this.startQuantity;
  }
  
  public void setStartQuantity(final Long startQuantity) {
    this.startQuantity = startQuantity;
  }
  
  public final static String P_StartQuantity = "startQuantity";
  
  public static IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,Long> StartQuantityAccessor = new IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,Long>(){
    				public Long getValue(UIProductSummarySnapshotStatCriteriaData object){
    					return object.getStartQuantity();
    				}
    				public void setValue(UIProductSummarySnapshotStatCriteriaData object,Long value){
    					object.setStartQuantity(value);
    				}
    			};
  
  private Double startAmount;
  
  public Double getStartAmount() {
    return this.startAmount;
  }
  
  public void setStartAmount(final Double startAmount) {
    this.startAmount = startAmount;
  }
  
  public final static String P_StartAmount = "startAmount";
  
  public static IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,Double> StartAmountAccessor = new IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,Double>(){
    				public Double getValue(UIProductSummarySnapshotStatCriteriaData object){
    					return object.getStartAmount();
    				}
    				public void setValue(UIProductSummarySnapshotStatCriteriaData object,Double value){
    					object.setStartAmount(value);
    				}
    			};
  
  private Long finishQuantity;
  
  public Long getFinishQuantity() {
    return this.finishQuantity;
  }
  
  public void setFinishQuantity(final Long finishQuantity) {
    this.finishQuantity = finishQuantity;
  }
  
  public final static String P_FinishQuantity = "finishQuantity";
  
  public static IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,Long> FinishQuantityAccessor = new IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,Long>(){
    				public Long getValue(UIProductSummarySnapshotStatCriteriaData object){
    					return object.getFinishQuantity();
    				}
    				public void setValue(UIProductSummarySnapshotStatCriteriaData object,Long value){
    					object.setFinishQuantity(value);
    				}
    			};
  
  private Double finishAmount;
  
  public Double getFinishAmount() {
    return this.finishAmount;
  }
  
  public void setFinishAmount(final Double finishAmount) {
    this.finishAmount = finishAmount;
  }
  
  public final static String P_FinishAmount = "finishAmount";
  
  public static IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,Double> FinishAmountAccessor = new IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,Double>(){
    				public Double getValue(UIProductSummarySnapshotStatCriteriaData object){
    					return object.getFinishAmount();
    				}
    				public void setValue(UIProductSummarySnapshotStatCriteriaData object,Double value){
    					object.setFinishAmount(value);
    				}
    			};
  
  private Long inStockQuantity;
  
  public Long getInStockQuantity() {
    return this.inStockQuantity;
  }
  
  public void setInStockQuantity(final Long inStockQuantity) {
    this.inStockQuantity = inStockQuantity;
  }
  
  public final static String P_InStockQuantity = "inStockQuantity";
  
  public static IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,Long> InStockQuantityAccessor = new IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,Long>(){
    				public Long getValue(UIProductSummarySnapshotStatCriteriaData object){
    					return object.getInStockQuantity();
    				}
    				public void setValue(UIProductSummarySnapshotStatCriteriaData object,Long value){
    					object.setInStockQuantity(value);
    				}
    			};
  
  private Double inStockAmount;
  
  public Double getInStockAmount() {
    return this.inStockAmount;
  }
  
  public void setInStockAmount(final Double inStockAmount) {
    this.inStockAmount = inStockAmount;
  }
  
  public final static String P_InStockAmount = "inStockAmount";
  
  public static IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,Double> InStockAmountAccessor = new IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,Double>(){
    				public Double getValue(UIProductSummarySnapshotStatCriteriaData object){
    					return object.getInStockAmount();
    				}
    				public void setValue(UIProductSummarySnapshotStatCriteriaData object,Double value){
    					object.setInStockAmount(value);
    				}
    			};
  
  private Long outStockQuantity;
  
  public Long getOutStockQuantity() {
    return this.outStockQuantity;
  }
  
  public void setOutStockQuantity(final Long outStockQuantity) {
    this.outStockQuantity = outStockQuantity;
  }
  
  public final static String P_OutStockQuantity = "outStockQuantity";
  
  public static IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,Long> OutStockQuantityAccessor = new IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,Long>(){
    				public Long getValue(UIProductSummarySnapshotStatCriteriaData object){
    					return object.getOutStockQuantity();
    				}
    				public void setValue(UIProductSummarySnapshotStatCriteriaData object,Long value){
    					object.setOutStockQuantity(value);
    				}
    			};
  
  private Double outStockAmount;
  
  public Double getOutStockAmount() {
    return this.outStockAmount;
  }
  
  public void setOutStockAmount(final Double outStockAmount) {
    this.outStockAmount = outStockAmount;
  }
  
  public final static String P_OutStockAmount = "outStockAmount";
  
  public static IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,Double> OutStockAmountAccessor = new IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,Double>(){
    				public Double getValue(UIProductSummarySnapshotStatCriteriaData object){
    					return object.getOutStockAmount();
    				}
    				public void setValue(UIProductSummarySnapshotStatCriteriaData object,Double value){
    					object.setOutStockAmount(value);
    				}
    			};
  
  private Long stockTakingStockQuantity;
  
  public Long getStockTakingStockQuantity() {
    return this.stockTakingStockQuantity;
  }
  
  public void setStockTakingStockQuantity(final Long stockTakingStockQuantity) {
    this.stockTakingStockQuantity = stockTakingStockQuantity;
  }
  
  public final static String P_StockTakingStockQuantity = "stockTakingStockQuantity";
  
  public static IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,Long> StockTakingStockQuantityAccessor = new IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,Long>(){
    				public Long getValue(UIProductSummarySnapshotStatCriteriaData object){
    					return object.getStockTakingStockQuantity();
    				}
    				public void setValue(UIProductSummarySnapshotStatCriteriaData object,Long value){
    					object.setStockTakingStockQuantity(value);
    				}
    			};
  
  private Double stockTakingStockAmount;
  
  public Double getStockTakingStockAmount() {
    return this.stockTakingStockAmount;
  }
  
  public void setStockTakingStockAmount(final Double stockTakingStockAmount) {
    this.stockTakingStockAmount = stockTakingStockAmount;
  }
  
  public final static String P_StockTakingStockAmount = "stockTakingStockAmount";
  
  public static IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,Double> StockTakingStockAmountAccessor = new IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,Double>(){
    				public Double getValue(UIProductSummarySnapshotStatCriteriaData object){
    					return object.getStockTakingStockAmount();
    				}
    				public void setValue(UIProductSummarySnapshotStatCriteriaData object,Double value){
    					object.setStockTakingStockAmount(value);
    				}
    			};
  
  private Long transferStockQuantity;
  
  public Long getTransferStockQuantity() {
    return this.transferStockQuantity;
  }
  
  public void setTransferStockQuantity(final Long transferStockQuantity) {
    this.transferStockQuantity = transferStockQuantity;
  }
  
  public final static String P_TransferStockQuantity = "transferStockQuantity";
  
  public static IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,Long> TransferStockQuantityAccessor = new IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,Long>(){
    				public Long getValue(UIProductSummarySnapshotStatCriteriaData object){
    					return object.getTransferStockQuantity();
    				}
    				public void setValue(UIProductSummarySnapshotStatCriteriaData object,Long value){
    					object.setTransferStockQuantity(value);
    				}
    			};
  
  private Double transferStockAmount;
  
  public Double getTransferStockAmount() {
    return this.transferStockAmount;
  }
  
  public void setTransferStockAmount(final Double transferStockAmount) {
    this.transferStockAmount = transferStockAmount;
  }
  
  public final static String P_TransferStockAmount = "transferStockAmount";
  
  public static IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,Double> TransferStockAmountAccessor = new IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,Double>(){
    				public Double getValue(UIProductSummarySnapshotStatCriteriaData object){
    					return object.getTransferStockAmount();
    				}
    				public void setValue(UIProductSummarySnapshotStatCriteriaData object,Double value){
    					object.setTransferStockAmount(value);
    				}
    			};
  
  private Long workitemStockQuantity;
  
  public Long getWorkitemStockQuantity() {
    return this.workitemStockQuantity;
  }
  
  public void setWorkitemStockQuantity(final Long workitemStockQuantity) {
    this.workitemStockQuantity = workitemStockQuantity;
  }
  
  public final static String P_WorkitemStockQuantity = "workitemStockQuantity";
  
  public static IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,Long> WorkitemStockQuantityAccessor = new IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,Long>(){
    				public Long getValue(UIProductSummarySnapshotStatCriteriaData object){
    					return object.getWorkitemStockQuantity();
    				}
    				public void setValue(UIProductSummarySnapshotStatCriteriaData object,Long value){
    					object.setWorkitemStockQuantity(value);
    				}
    			};
  
  private Double workitemStockAmount;
  
  public Double getWorkitemStockAmount() {
    return this.workitemStockAmount;
  }
  
  public void setWorkitemStockAmount(final Double workitemStockAmount) {
    this.workitemStockAmount = workitemStockAmount;
  }
  
  public final static String P_WorkitemStockAmount = "workitemStockAmount";
  
  public static IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,Double> WorkitemStockAmountAccessor = new IObjectFieldAccessor<UIProductSummarySnapshotStatCriteriaData,Double>(){
    				public Double getValue(UIProductSummarySnapshotStatCriteriaData object){
    					return object.getWorkitemStockAmount();
    				}
    				public void setValue(UIProductSummarySnapshotStatCriteriaData object,Double value){
    					object.setWorkitemStockAmount(value);
    				}
    			};
}
