package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductSummarySnapshotStatCriteriaData;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSummarySnapshotStatCriteriaData;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.ProductSummarySnapshotStatCriteriaDataMapper")
public class ProductSummarySnapshotStatCriteriaDataMapper extends AbstractDataTypeMapper<UIProductSummarySnapshotStatCriteriaData,RCProductSummarySnapshotStatCriteriaData> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UIProductSummarySnapshotStatCriteriaData from, final RCProductSummarySnapshotStatCriteriaData to) {
    
  }
  
  public UIProductSummarySnapshotStatCriteriaData copyFromEntity(final UIProductSummarySnapshotStatCriteriaData result, final RCProductSummarySnapshotStatCriteriaData entity) {
    if(entity==null) return null;
    result.setStorageSummary(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCProductWarehouseStorageSummaryProxy.class,entity.getStorageSummary()));
    if(entity. getStorageSummary()  != null )
    	result.setStore(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy.class,entity.getStorageSummary().getStore()));
    if(entity. getStorageSummary()  != null )
    	result.setProductSpec(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy.class,entity.getStorageSummary().getProductSpec()));
    result.setInStockQuantity(convertService.toValue(java.lang.Long.class,entity.getInStockQuantity()));
    result.setOutStockQuantity(convertService.toValue(java.lang.Long.class,entity.getOutStockQuantity()));
    result.setStockTakingStockQuantity(convertService.toValue(java.lang.Long.class,entity.getStockTakingStockQuantity()));
    result.setTransferStockQuantity(convertService.toValue(java.lang.Long.class,entity.getTransferStockQuantity()));
    result.setWorkitemStockQuantity(convertService.toValue(java.lang.Long.class,entity.getWorkitemStockQuantity()));
    result.setInStockAmount(convertService.toValue(java.lang.Double.class,entity.getInStockAmount()));
    result.setStockTakingStockAmount(convertService.toValue(java.lang.Double.class,entity.getStockTakingStockAmount()));
    result.setTransferStockAmount(convertService.toValue(java.lang.Double.class,entity.getTransferStockAmount()));
    result.setWorkitemStockAmount(convertService.toValue(java.lang.Double.class,entity.getWorkitemStockAmount()));
    result.setOutStockAmount(convertService.toValue(java.lang.Double.class,entity.getOutStockAmount()));
    return result;
    
  }
  
  public UIProductSummarySnapshotStatCriteriaData buildFrom(final RCProductSummarySnapshotStatCriteriaData entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.warehouse.UIProductSummarySnapshotStatCriteriaData result = new com.fudanmed.platform.core.web.shared.warehouse.UIProductSummarySnapshotStatCriteriaData();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIProductSummarySnapshotStatCriteriaData.class;
  }
  
  public Class<?> getEntityClass() {
    return RCProductSummarySnapshotStatCriteriaData.class;
  }
}
