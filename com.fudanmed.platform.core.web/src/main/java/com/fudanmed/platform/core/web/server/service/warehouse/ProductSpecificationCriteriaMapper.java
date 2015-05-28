package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductSpecificationCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecificationCriteria;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.ProductSpecificationCriteriaMapper")
public class ProductSpecificationCriteriaMapper extends AbstractDataTypeMapper<UIProductSpecificationCriteria,RCProductSpecificationCriteria> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UIProductSpecificationCriteria from, final RCProductSpecificationCriteria to) {
    to.setInfo(convertService.toValue(java.lang.String.class,from.getInfo()));
    to.setCategory(convertService.toValue(com.fudanmed.platform.core.warehouse.RCProductCategory.class,from.getCategory()));
    
  }
  
  public UIProductSpecificationCriteria copyFromEntity(final UIProductSpecificationCriteria result, final RCProductSpecificationCriteria entity) {
    if(entity==null) return null;
    result.setInfo(convertService.toValue(java.lang.String.class,entity.getInfo()));
    result.setCategory(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy.class,entity.getCategory()));
    return result;
    
  }
  
  public UIProductSpecificationCriteria buildFrom(final RCProductSpecificationCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecificationCriteria result = new com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecificationCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIProductSpecificationCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return RCProductSpecificationCriteria.class;
  }
}
