package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverMaterialType;
import com.fudanmed.platform.core.web.server.service.deliver.DeliverMaterialTypeValidator;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialType;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.deliver.DeliverMaterialTypeMapper")
public class DeliverMaterialTypeMapper extends AbstractEntityMapper<UIDeliverMaterialType,DLDeliverMaterialType> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public DLDeliverMaterialType loadEntityById(final Long id) {
    return entities.get(DLDeliverMaterialType.class,id);
  }
  
  public DLDeliverMaterialType create() {
    return entities.create(DLDeliverMaterialType.class);
  }
  
  @Autowired
  private DeliverMaterialTypeValidator validator;
  
  public void copyToEntity(final UIDeliverMaterialType from, final DLDeliverMaterialType to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setCode(convertService.toValue(java.lang.String.class,from.getCode()));
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    to.setUnit(convertService.toValue(java.lang.String.class,from.getUnit()));
    to.setComment(convertService.toValue(java.lang.String.class,from.getComment()));
    
  }
  
  public UIDeliverMaterialType copyFromEntity(final UIDeliverMaterialType result, final DLDeliverMaterialType entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setCategory(convertService.toValue(com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy.class,entity.getCategory()));
    result.setCode(convertService.toValue(java.lang.String.class,entity.getCode()));
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setUnit(convertService.toValue(java.lang.String.class,entity.getUnit()));
    result.setComment(convertService.toValue(java.lang.String.class,entity.getComment()));
    return result;
    
  }
  
  public UIDeliverMaterialType buildFrom(final DLDeliverMaterialType entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialType result = new com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialType();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIDeliverMaterialType.class;
  }
  
  public Class<?> getEntityClass() {
    return DLDeliverMaterialType.class;
  }
}
