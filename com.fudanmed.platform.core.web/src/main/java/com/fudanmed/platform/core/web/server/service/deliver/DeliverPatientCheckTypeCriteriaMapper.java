package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckTypeCriteria;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckTypeCriteria;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.deliver.DeliverPatientCheckTypeCriteriaMapper")
public class DeliverPatientCheckTypeCriteriaMapper extends AbstractDataTypeMapper<UIDeliverPatientCheckTypeCriteria,DLDeliverPatientCheckTypeCriteria> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UIDeliverPatientCheckTypeCriteria from, final DLDeliverPatientCheckTypeCriteria to) {
    to.setInfo(convertService.toValue(java.lang.String.class,from.getInfo()));
    to.setCategory(convertService.toValue(com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategory.class,from.getCategory()));
    
  }
  
  public UIDeliverPatientCheckTypeCriteria copyFromEntity(final UIDeliverPatientCheckTypeCriteria result, final DLDeliverPatientCheckTypeCriteria entity) {
    if(entity==null) return null;
    result.setInfo(convertService.toValue(java.lang.String.class,entity.getInfo()));
    result.setCategory(convertService.toValue(com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy.class,entity.getCategory()));
    return result;
    
  }
  
  public UIDeliverPatientCheckTypeCriteria buildFrom(final DLDeliverPatientCheckTypeCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckTypeCriteria result = new com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckTypeCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIDeliverPatientCheckTypeCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return DLDeliverPatientCheckTypeCriteria.class;
  }
}
