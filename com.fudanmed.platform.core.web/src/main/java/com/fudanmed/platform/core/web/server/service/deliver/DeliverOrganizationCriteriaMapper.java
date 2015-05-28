package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverOrganizationCriteria;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverOrganizationCriteria;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.deliver.DeliverOrganizationCriteriaMapper")
public class DeliverOrganizationCriteriaMapper extends AbstractDataTypeMapper<UIDeliverOrganizationCriteria,DLDeliverOrganizationCriteria> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UIDeliverOrganizationCriteria from, final DLDeliverOrganizationCriteria to) {
    to.setInfo(convertService.toValue(java.lang.String.class,from.getInfo()));
    
  }
  
  public UIDeliverOrganizationCriteria copyFromEntity(final UIDeliverOrganizationCriteria result, final DLDeliverOrganizationCriteria entity) {
    if(entity==null) return null;
    result.setInfo(convertService.toValue(java.lang.String.class,entity.getInfo()));
    return result;
    
  }
  
  public UIDeliverOrganizationCriteria buildFrom(final DLDeliverOrganizationCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.deliver.UIDeliverOrganizationCriteria result = new com.fudanmed.platform.core.web.shared.deliver.UIDeliverOrganizationCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIDeliverOrganizationCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return DLDeliverOrganizationCriteria.class;
  }
}
