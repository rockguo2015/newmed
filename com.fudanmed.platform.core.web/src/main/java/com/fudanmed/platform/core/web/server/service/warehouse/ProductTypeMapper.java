package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductType;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductTypeValidator;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductType;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.ProductTypeMapper")
public class ProductTypeMapper extends AbstractEntityMapper<UIProductType,RCProductType> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCProductType loadEntityById(final Long id) {
    return entities.get(RCProductType.class,id);
  }
  
  public RCProductType create() {
    return entities.create(RCProductType.class);
  }
  
  @Autowired
  private ProductTypeValidator validator;
  
  public void copyToEntity(final UIProductType from, final RCProductType to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setCode(convertService.toValue(java.lang.String.class,from.getCode()));
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final UIProductType _gwt, final RCProductType _entity) {
    _entity.updateCategoryPath();
  }
  
  public UIProductType copyFromEntity(final UIProductType result, final RCProductType entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setCode(convertService.toValue(java.lang.String.class,entity.getCode()));
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setCategory(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy.class,entity.getCategory()));
    return result;
    
  }
  
  public UIProductType buildFrom(final RCProductType entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.warehouse.UIProductType result = new com.fudanmed.platform.core.web.shared.warehouse.UIProductType();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIProductType.class;
  }
  
  public Class<?> getEntityClass() {
    return RCProductType.class;
  }
}
