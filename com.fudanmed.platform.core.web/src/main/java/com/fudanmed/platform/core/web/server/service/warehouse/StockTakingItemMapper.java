package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCStockTakingItem;
import com.fudanmed.platform.core.web.server.service.warehouse.StockTakingItemValidator;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingItem;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.StockTakingItemMapper")
public class StockTakingItemMapper extends AbstractEntityMapper<UIStockTakingItem,RCStockTakingItem> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCStockTakingItem loadEntityById(final Long id) {
    return entities.get(RCStockTakingItem.class,id);
  }
  
  public RCStockTakingItem create() {
    return entities.create(RCStockTakingItem.class);
  }
  
  @Autowired
  private StockTakingItemValidator validator;
  
  public void copyToEntity(final UIStockTakingItem from, final RCStockTakingItem to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setProductSpec(convertService.toValue(com.fudanmed.platform.core.warehouse.RCProductSpecification.class,from.getProductSpec()));
    to.setQuantity(convertService.toValue(java.lang.Integer.class,from.getQuantity()));
    to.setRealQuantity(convertService.toValue(java.lang.Integer.class,from.getRealQuantity()));
    to.setComment(convertService.toValue(java.lang.String.class,from.getComment()));
    
  }
  
  public UIStockTakingItem copyFromEntity(final UIStockTakingItem result, final RCStockTakingItem entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setProductSpec(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy.class,entity.getProductSpec()));
    result.setQuantity(convertService.toValue(java.lang.Integer.class,entity.getQuantity()));
    result.setRealQuantity(convertService.toValue(java.lang.Integer.class,entity.getRealQuantity()));
    result.setComment(convertService.toValue(java.lang.String.class,entity.getComment()));
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
  
  public UIStockTakingItem buildFrom(final RCStockTakingItem entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingItem result = new com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingItem();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIStockTakingItem.class;
  }
  
  public Class<?> getEntityClass() {
    return RCStockTakingItem.class;
  }
}
