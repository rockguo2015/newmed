package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCStockTakingRecordItem;
import com.fudanmed.platform.core.web.server.service.warehouse.StockTakingRecordItemValidator;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecordItem;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.StockTakingRecordItemMapper")
public class StockTakingRecordItemMapper extends AbstractEntityMapper<UIStockTakingRecordItem,RCStockTakingRecordItem> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCStockTakingRecordItem loadEntityById(final Long id) {
    return entities.get(RCStockTakingRecordItem.class,id);
  }
  
  public RCStockTakingRecordItem create() {
    return entities.create(RCStockTakingRecordItem.class);
  }
  
  @Autowired
  private StockTakingRecordItemValidator validator;
  
  public void copyToEntity(final UIStockTakingRecordItem from, final RCStockTakingRecordItem to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    
  }
  
  public UIStockTakingRecordItem copyFromEntity(final UIStockTakingRecordItem result, final RCStockTakingRecordItem entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    if(entity. getRecordItem()  != null )
    	result.setQuantity(convertService.toValue(java.lang.Integer.class,entity.getRecordItem().getQuantity()));
    if(entity. getRecord()  != null )
    	result.setSourceStore(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy.class,entity.getRecord().getSourceStore()));
    if(entity. getRecordItem()  != null &&entity. getRecordItem().getProductEntry()  != null )
    	result.setProductSpec(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy.class,entity.getRecordItem().getProductEntry().getProductSpec()));
    if(entity. getRecordItem()  != null &&entity. getRecordItem().getProductEntry()  != null )
    	result.setSid(convertService.toValue(java.lang.String.class,entity.getRecordItem().getProductEntry().getSid()));
    if(entity. getRecordItem()  != null &&entity. getRecordItem().getProductEntry()  != null &&entity. getRecordItem().getProductEntry().getProductSpec()  != null )
    	result.setProductSid(convertService.toValue(java.lang.String.class,entity.getRecordItem().getProductEntry().getProductSpec().getSid()));
    if(entity. getRecordItem()  != null &&entity. getRecordItem().getProductEntry()  != null &&entity. getRecordItem().getProductEntry().getProductSpec()  != null )
    	result.setTypeDesc(convertService.toValue(java.lang.String.class,entity.getRecordItem().getProductEntry().getProductSpec().getTypeDesc()));
    if(entity. getRecordItem()  != null &&entity. getRecordItem().getProductEntry()  != null &&entity. getRecordItem().getProductEntry().getProductSpec()  != null )
    	result.setUnit(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy.class,entity.getRecordItem().getProductEntry().getProductSpec().getUnit()));
    return result;
    
  }
  
  public UIStockTakingRecordItem buildFrom(final RCStockTakingRecordItem entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecordItem result = new com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecordItem();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIStockTakingRecordItem.class;
  }
  
  public Class<?> getEntityClass() {
    return RCStockTakingRecordItem.class;
  }
}
