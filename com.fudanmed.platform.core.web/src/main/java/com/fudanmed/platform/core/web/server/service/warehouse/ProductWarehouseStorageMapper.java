package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorage;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorage;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.ProductWarehouseStorageMapper")
public class ProductWarehouseStorageMapper extends AbstractEntityMapper<UIProductWarehouseStorage,RCProductWarehouseStorage> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCProductWarehouseStorage loadEntityById(final Long id) {
    return entities.get(RCProductWarehouseStorage.class,id);
  }
  
  public RCProductWarehouseStorage create() {
    return entities.create(RCProductWarehouseStorage.class);
  }
  
  public void copyToEntity(final UIProductWarehouseStorage from, final RCProductWarehouseStorage to) {
    to.setVersion(from.getVersion());
    
  }
  
  public UIProductWarehouseStorage copyFromEntity(final UIProductWarehouseStorage result, final RCProductWarehouseStorage entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setStore(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy.class,entity.getStore()));
    result.setQuantity(convertService.toValue(java.lang.Integer.class,entity.getQuantity()));
    if(entity. getProductEntry()  != null )
    	result.setSid(convertService.toValue(java.lang.String.class,entity.getProductEntry().getSid()));
    if(entity. getProductEntry()  != null &&entity. getProductEntry().getProductSpec()  != null )
    	result.setProductSpecsSid(convertService.toValue(java.lang.String.class,entity.getProductEntry().getProductSpec().getSid()));
    if(entity. getProductEntry()  != null &&entity. getProductEntry().getProductSpec()  != null )
    	result.setName(convertService.toValue(java.lang.String.class,entity.getProductEntry().getProductSpec().getName()));
    if(entity. getProductEntry()  != null &&entity. getProductEntry().getProductSpec()  != null )
    	result.setTypeDesc(convertService.toValue(java.lang.String.class,entity.getProductEntry().getProductSpec().getTypeDesc()));
    if(entity. getProductEntry()  != null &&entity. getProductEntry().getProductSpec()  != null )
    	result.setUnit(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy.class,entity.getProductEntry().getProductSpec().getUnit()));
    if(entity. getProductEntry()  != null )
    	result.setPrice(convertService.toValue(java.lang.Double.class,entity.getProductEntry().getPrice()));
    result.setProductEntry(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCProductEntryProxy.class,entity.getProductEntry()));
    if(entity. getProductEntry()  != null &&entity. getProductEntry().getInStockRecord()  != null )
    	result.setSupplier(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCSupplierProxy.class,entity.getProductEntry().getInStockRecord().getSupplier()));
    if(entity. getProductEntry()  != null &&entity. getProductEntry().getInStockRecord()  != null )
    	result.setInstockDate(convertService.toValue(java.util.Date.class,entity.getProductEntry().getInStockRecord().getDate()));
    return result;
    
  }
  
  public UIProductWarehouseStorage buildFrom(final RCProductWarehouseStorage entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorage result = new com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorage();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIProductWarehouseStorage.class;
  }
  
  public Class<?> getEntityClass() {
    return RCProductWarehouseStorage.class;
  }
}
