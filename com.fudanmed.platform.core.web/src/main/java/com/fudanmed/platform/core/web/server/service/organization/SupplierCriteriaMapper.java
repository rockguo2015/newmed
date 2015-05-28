package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCSupplierCriteria;
import com.fudanmed.platform.core.web.shared.organization.UISupplierCriteria;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.organization.SupplierCriteriaMapper")
public class SupplierCriteriaMapper extends AbstractDataTypeMapper<UISupplierCriteria,RCSupplierCriteria> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UISupplierCriteria from, final RCSupplierCriteria to) {
    to.setInfo(convertService.toValue(java.lang.String.class,from.getInfo()));
    
  }
  
  public UISupplierCriteria copyFromEntity(final UISupplierCriteria result, final RCSupplierCriteria entity) {
    if(entity==null) return null;
    result.setInfo(convertService.toValue(java.lang.String.class,entity.getInfo()));
    return result;
    
  }
  
  public UISupplierCriteria buildFrom(final RCSupplierCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.organization.UISupplierCriteria result = new com.fudanmed.platform.core.web.shared.organization.UISupplierCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UISupplierCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return RCSupplierCriteria.class;
  }
}
