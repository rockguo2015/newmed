package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductCategory;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductCategoryValidator;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductCategory;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.ProductCategoryMapper")
public class ProductCategoryMapper extends AbstractEntityMapper<UIProductCategory,RCProductCategory> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCProductCategory loadEntityById(final Long id) {
    return entities.get(RCProductCategory.class,id);
  }
  
  public RCProductCategory create() {
    return entities.create(RCProductCategory.class);
  }
  
  @Autowired
  private ProductCategoryValidator validator;
  
  public void copyToEntity(final UIProductCategory from, final RCProductCategory to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    to.setCode(convertService.toValue(java.lang.String.class,from.getCode()));
    to.setParent(convertService.toValue(com.fudanmed.platform.core.warehouse.RCProductCategory.class,from.getParent()));
    
  }
  
  public UIProductCategory copyFromEntity(final UIProductCategory result, final RCProductCategory entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setCode(convertService.toValue(java.lang.String.class,entity.getCode()));
    result.setParent(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy.class,entity.getParent()));
    result.setSimplePy(convertService.toValue(java.lang.String.class,entity.getSimplePy()));
    return result;
    
  }
  
  public UIProductCategory buildFrom(final RCProductCategory entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.warehouse.UIProductCategory result = new com.fudanmed.platform.core.web.shared.warehouse.UIProductCategory();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIProductCategory.class;
  }
  
  public Class<?> getEntityClass() {
    return RCProductCategory.class;
  }
}
