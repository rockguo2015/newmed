package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverMaterialCategory;
import com.fudanmed.platform.core.web.server.service.deliver.DeliverMaterialCategoryValidator;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialCategory;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.deliver.DeliverMaterialCategoryMapper")
public class DeliverMaterialCategoryMapper extends AbstractEntityMapper<UIDeliverMaterialCategory,DLDeliverMaterialCategory> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public DLDeliverMaterialCategory loadEntityById(final Long id) {
    return entities.get(DLDeliverMaterialCategory.class,id);
  }
  
  public DLDeliverMaterialCategory create() {
    return entities.create(DLDeliverMaterialCategory.class);
  }
  
  @Autowired
  private DeliverMaterialCategoryValidator validator;
  
  public void copyToEntity(final UIDeliverMaterialCategory from, final DLDeliverMaterialCategory to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setCode(convertService.toValue(java.lang.String.class,from.getCode()));
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    
  }
  
  public UIDeliverMaterialCategory copyFromEntity(final UIDeliverMaterialCategory result, final DLDeliverMaterialCategory entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setCode(convertService.toValue(java.lang.String.class,entity.getCode()));
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setParentCategory(convertService.toValue(com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy.class,entity.getParentCategory()));
    return result;
    
  }
  
  public UIDeliverMaterialCategory buildFrom(final DLDeliverMaterialCategory entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialCategory result = new com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialCategory();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIDeliverMaterialCategory.class;
  }
  
  public Class<?> getEntityClass() {
    return DLDeliverMaterialCategory.class;
  }
}
