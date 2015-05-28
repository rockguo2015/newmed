package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecordItem;
import com.fudanmed.platform.core.web.server.service.warehouse.WorkItemStockRecordItemValidator;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecordItem;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.WorkItemStockRecordItemMapper")
public class WorkItemStockRecordItemMapper extends AbstractEntityMapper<UIWorkItemStockRecordItem,RCWorkItemStockRecordItem> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCWorkItemStockRecordItem loadEntityById(final Long id) {
    return entities.get(RCWorkItemStockRecordItem.class,id);
  }
  
  public RCWorkItemStockRecordItem create() {
    return entities.create(RCWorkItemStockRecordItem.class);
  }
  
  @Autowired
  private WorkItemStockRecordItemValidator validator;
  
  public void copyToEntity(final UIWorkItemStockRecordItem from, final RCWorkItemStockRecordItem to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    
  }
  
  public UIWorkItemStockRecordItem copyFromEntity(final UIWorkItemStockRecordItem result, final RCWorkItemStockRecordItem entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    if(entity. getRecordItem()  != null )
    	result.setQuantity(convertService.toValue(java.lang.Integer.class,entity.getRecordItem().getQuantity()));
    if(entity. getRecord()  != null )
    	result.setWorkItem(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy.class,entity.getRecord().getWorkItem()));
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
    	result.setMaterialId(convertService.toValue(java.lang.String.class,entity.getRecordItem().getProductEntry().getProductSpec().getMaterialId()));
    if(entity. getRecordItem()  != null &&entity. getRecordItem().getProductEntry()  != null )
    	result.setPrice(convertService.toValue(java.lang.Double.class,entity.getRecordItem().getProductEntry().getPrice()));
    if(entity. getRecordItem()  != null &&entity. getRecordItem().getProductEntry()  != null &&entity. getRecordItem().getProductEntry().getProductSpec()  != null )
    	result.setUnit(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy.class,entity.getRecordItem().getProductEntry().getProductSpec().getUnit()));
    if(entity. getRecordItem()  != null &&entity. getRecordItem().getProductEntry()  != null &&entity. getRecordItem().getProductEntry().getProductSpec()  != null )
    	result.setBrand(convertService.toValue(com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy.class,entity.getRecordItem().getProductEntry().getProductSpec().getBrandType()));
    return result;
    
  }
  
  public UIWorkItemStockRecordItem buildFrom(final RCWorkItemStockRecordItem entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecordItem result = new com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecordItem();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIWorkItemStockRecordItem.class;
  }
  
  public Class<?> getEntityClass() {
    return RCWorkItemStockRecordItem.class;
  }
}
