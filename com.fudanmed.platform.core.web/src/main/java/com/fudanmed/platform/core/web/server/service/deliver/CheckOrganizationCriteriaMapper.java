package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLCheckOrganizationCriteria;
import com.fudanmed.platform.core.web.shared.deliver.UICheckOrganizationCriteria;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.deliver.CheckOrganizationCriteriaMapper")
public class CheckOrganizationCriteriaMapper extends AbstractDataTypeMapper<UICheckOrganizationCriteria,DLCheckOrganizationCriteria> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UICheckOrganizationCriteria from, final DLCheckOrganizationCriteria to) {
    to.setInfo(convertService.toValue(java.lang.String.class,from.getInfo()));
    
  }
  
  public UICheckOrganizationCriteria copyFromEntity(final UICheckOrganizationCriteria result, final DLCheckOrganizationCriteria entity) {
    if(entity==null) return null;
    result.setInfo(convertService.toValue(java.lang.String.class,entity.getInfo()));
    return result;
    
  }
  
  public UICheckOrganizationCriteria buildFrom(final DLCheckOrganizationCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.deliver.UICheckOrganizationCriteria result = new com.fudanmed.platform.core.web.shared.deliver.UICheckOrganizationCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UICheckOrganizationCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return DLCheckOrganizationCriteria.class;
  }
}
