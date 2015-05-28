package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCWorkItemStorage;
import com.fudanmed.platform.core.web.server.service.warehouse.WorkItemStorageValidator;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStorage;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.WorkItemStorageMapper")
public class WorkItemStorageMapper extends AbstractEntityMapper<UIWorkItemStorage,RCWorkItemStorage> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCWorkItemStorage loadEntityById(final Long id) {
    return entities.get(RCWorkItemStorage.class,id);
  }
  
  public RCWorkItemStorage create() {
    return entities.create(RCWorkItemStorage.class);
  }
  
  @Autowired
  private WorkItemStorageValidator validator;
  
  public void copyToEntity(final UIWorkItemStorage from, final RCWorkItemStorage to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    
  }
  
  public UIWorkItemStorage copyFromEntity(final UIWorkItemStorage result, final RCWorkItemStorage entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setWorkItem(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy.class,entity.getWorkItem()));
    result.setAmount(convertService.toValue(java.lang.Double.class,entity.getAmount()));
    if(entity. getProductEntry()  != null )
    	result.setProductSpec(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy.class,entity.getProductEntry().getProductSpec()));
    if(entity. getProductEntry()  != null )
    	result.setSid(convertService.toValue(java.lang.String.class,entity.getProductEntry().getSid()));
    result.setQuantity(convertService.toValue(java.lang.Integer.class,entity.getQuantity()));
    if(entity. getProductEntry()  != null &&entity. getProductEntry().getProductSpec()  != null )
    	result.setProductSid(convertService.toValue(java.lang.String.class,entity.getProductEntry().getProductSpec().getSid()));
    if(entity. getProductEntry()  != null &&entity. getProductEntry().getProductSpec()  != null )
    	result.setTypeDesc(convertService.toValue(java.lang.String.class,entity.getProductEntry().getProductSpec().getTypeDesc()));
    if(entity. getProductEntry()  != null &&entity. getProductEntry().getProductSpec()  != null )
    	result.setUnit(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy.class,entity.getProductEntry().getProductSpec().getUnit()));
    if(entity. getProductEntry()  != null &&entity. getProductEntry().getProductSpec()  != null )
    	result.setMaterialId(convertService.toValue(java.lang.String.class,entity.getProductEntry().getProductSpec().getMaterialId()));
    if(entity. getProductEntry()  != null )
    	result.setPrice(convertService.toValue(java.lang.Double.class,entity.getProductEntry().getPrice()));
    if(entity. getProductEntry()  != null &&entity. getProductEntry().getProductSpec()  != null )
    	result.setBrand(convertService.toValue(com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy.class,entity.getProductEntry().getProductSpec().getBrandType()));
    return result;
    
  }
  
  public UIWorkItemStorage buildFrom(final RCWorkItemStorage entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStorage result = new com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStorage();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIWorkItemStorage.class;
  }
  
  public Class<?> getEntityClass() {
    return RCWorkItemStorage.class;
  }
}
