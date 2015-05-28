package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductSummarySnapshotCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSummarySnapshotCriteria;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.ProductSummarySnapshotCriteriaMapper")
public class ProductSummarySnapshotCriteriaMapper extends AbstractDataTypeMapper<UIProductSummarySnapshotCriteria,RCProductSummarySnapshotCriteria> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public void copyToEntity(final UIProductSummarySnapshotCriteria from, final RCProductSummarySnapshotCriteria to) {
    to.setDateFrom(convertService.toValue(java.util.Date.class,from.getDateFrom()));
    to.setDateTo(convertService.toValue(java.util.Date.class,from.getDateTo()));
    to.setStore(convertService.toValue(com.fudanmed.platform.core.warehouse.RCWarehouse.class,from.getStore()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final UIProductSummarySnapshotCriteria _gwt, final RCProductSummarySnapshotCriteria _entity) {
    UIProductSpecification _productSpec = _gwt.getProductSpec();
    RCProductSpecification _resolved= null;
    if(_productSpec!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCProductSpecification)com.uniquesoft.uidl.extensions.ModelObjects.resolve(_productSpec, entities);
    
    _entity.setProductSpec( _resolved);
  }
  
  public UIProductSummarySnapshotCriteria copyFromEntity(final UIProductSummarySnapshotCriteria result, final RCProductSummarySnapshotCriteria entity) {
    if(entity==null) return null;
    result.setDateFrom(convertService.toValue(java.util.Date.class,entity.getDateFrom()));
    result.setDateTo(convertService.toValue(java.util.Date.class,entity.getDateTo()));
    result.setStore(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy.class,entity.getStore()));
    return result;
    
  }
  
  public UIProductSummarySnapshotCriteria buildFrom(final RCProductSummarySnapshotCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.warehouse.UIProductSummarySnapshotCriteria result = new com.fudanmed.platform.core.web.shared.warehouse.UIProductSummarySnapshotCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIProductSummarySnapshotCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return RCProductSummarySnapshotCriteria.class;
  }
}
