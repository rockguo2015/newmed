package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCInStockRecord;
import com.fudanmed.platform.core.warehouse.RCInStockRecordItem;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.web.server.service.warehouse.InStockRecordItemValidator;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductSpecificationMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecordItem;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.InStockRecordItemMapper")
public class InStockRecordItemMapper extends AbstractEntityMapper<UIInStockRecordItem,RCInStockRecordItem> {
  @Autowired
  private IConvertService convertService;
  
  public RCInStockRecordItem create(final UIInStockRecordItem gwtEntity, final Object context) {
    RCInStockRecordItem _createAndAddtoItems = ((RCInStockRecord) context).createAndAddtoItems();
    return _createAndAddtoItems;
  }
  
  @Autowired
  private IObjectFactory entities;
  
  public RCInStockRecordItem loadEntityById(final Long id) {
    return entities.get(RCInStockRecordItem.class,id);
  }
  
  public RCInStockRecordItem create() {
    return entities.create(RCInStockRecordItem.class);
  }
  
  @Autowired
  private ProductSpecificationMapper __ProductSpecificationMapper__;
  
  @Autowired
  private InStockRecordItemValidator validator;
  
  public void copyToEntity(final UIInStockRecordItem from, final RCInStockRecordItem to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setSid(convertService.toValue(java.lang.String.class,from.getSid()));
    to.setPrice(convertService.toValue(java.lang.Double.class,from.getPrice()));
    to.setQuantity(convertService.toValue(java.lang.Integer.class,from.getQuantity()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final UIInStockRecordItem _gwt, final RCInStockRecordItem _entity) {
    UIProductSpecification _uiProductSpec = _gwt.getUiProductSpec();
    Long _id = _uiProductSpec.getId();
    RCProductSpecification _get = this.entities.<RCProductSpecification>get(RCProductSpecification.class, _id);
    _entity.setProductSpec(_get);
  }
  
  public UIInStockRecordItem copyFromEntity(final UIInStockRecordItem result, final RCInStockRecordItem entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setSid(convertService.toValue(java.lang.String.class,entity.getSid()));
    result.setPrice(convertService.toValue(java.lang.Double.class,entity.getPrice()));
    result.setQuantity(convertService.toValue(java.lang.Integer.class,entity.getQuantity()));
    	result.setUiProductSpec(__ProductSpecificationMapper__.apply(entity.getProductSpec()));
    if(entity. getProductSpec()  != null )
    	result.setProductSid(convertService.toValue(java.lang.String.class,entity.getProductSpec().getSid()));
    if(entity. getProductSpec()  != null )
    	result.setMaterialId(convertService.toValue(java.lang.String.class,entity.getProductSpec().getMaterialId()));
    if(entity. getProductSpec()  != null )
    	result.setBrand(convertService.toValue(com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy.class,entity.getProductSpec().getBrandType()));
    if(entity. getProductSpec()  != null )
    	result.setTypeDesc(convertService.toValue(java.lang.String.class,entity.getProductSpec().getTypeDesc()));
    if(entity. getProductSpec()  != null )
    	result.setUnit(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy.class,entity.getProductSpec().getUnit()));
    if(entity. getProductSpec()  != null )
    	result.setProductSpecName(convertService.toValue(java.lang.String.class,entity.getProductSpec().getName()));
    return result;
    
  }
  
  public UIInStockRecordItem buildFrom(final RCInStockRecordItem entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecordItem result = new com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecordItem();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIInStockRecordItem.class;
  }
  
  public Class<?> getEntityClass() {
    return RCInStockRecordItem.class;
  }
}
