package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.ProductWarehouseStorageSummaryMapper")
public class ProductWarehouseStorageSummaryMapper extends AbstractEntityMapper<UIProductWarehouseStorageSummary,RCProductWarehouseStorageSummary> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCProductWarehouseStorageSummary loadEntityById(final Long id) {
    return entities.get(RCProductWarehouseStorageSummary.class,id);
  }
  
  public RCProductWarehouseStorageSummary create() {
    return entities.create(RCProductWarehouseStorageSummary.class);
  }
  
  public void copyToEntity(final UIProductWarehouseStorageSummary from, final RCProductWarehouseStorageSummary to) {
    to.setVersion(from.getVersion());
    
  }
  
  public UIProductWarehouseStorageSummary copyFromEntity(final UIProductWarehouseStorageSummary result, final RCProductWarehouseStorageSummary entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setStore(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy.class,entity.getStore()));
    result.setQuantity(convertService.toValue(java.lang.Integer.class,entity.getQuantity()));
    if(entity. getProductSpec()  != null )
    	result.setProductSpecsSid(convertService.toValue(java.lang.String.class,entity.getProductSpec().getSid()));
    if(entity. getProductSpec()  != null )
    	result.setMaterialId(convertService.toValue(java.lang.String.class,entity.getProductSpec().getMaterialId()));
    if(entity. getProductSpec()  != null )
    	result.setBrand(convertService.toValue(com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy.class,entity.getProductSpec().getBrandType()));
    if(entity. getProductSpec()  != null )
    	result.setName(convertService.toValue(java.lang.String.class,entity.getProductSpec().getName()));
    if(entity. getProductSpec()  != null )
    	result.setTypeDesc(convertService.toValue(java.lang.String.class,entity.getProductSpec().getTypeDesc()));
    if(entity. getProductSpec()  != null )
    	result.setUnit(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy.class,entity.getProductSpec().getUnit()));
    return result;
    
  }
  
  public UIProductWarehouseStorageSummary buildFrom(final RCProductWarehouseStorageSummary entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary result = new com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIProductWarehouseStorageSummary.class;
  }
  
  public Class<?> getEntityClass() {
    return RCProductWarehouseStorageSummary.class;
  }
}
