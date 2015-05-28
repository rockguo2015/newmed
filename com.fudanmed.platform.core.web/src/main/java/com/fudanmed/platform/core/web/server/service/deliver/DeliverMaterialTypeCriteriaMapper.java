package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverMaterialTypeCriteria;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialTypeCriteria;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.deliver.DeliverMaterialTypeCriteriaMapper")
public class DeliverMaterialTypeCriteriaMapper extends AbstractDataTypeMapper<UIDeliverMaterialTypeCriteria,DLDeliverMaterialTypeCriteria> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UIDeliverMaterialTypeCriteria from, final DLDeliverMaterialTypeCriteria to) {
    to.setInfo(convertService.toValue(java.lang.String.class,from.getInfo()));
    to.setCategory(convertService.toValue(com.fudanmed.platform.core.deliver.DLDeliverMaterialCategory.class,from.getCategory()));
    
  }
  
  public UIDeliverMaterialTypeCriteria copyFromEntity(final UIDeliverMaterialTypeCriteria result, final DLDeliverMaterialTypeCriteria entity) {
    if(entity==null) return null;
    result.setInfo(convertService.toValue(java.lang.String.class,entity.getInfo()));
    result.setCategory(convertService.toValue(com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy.class,entity.getCategory()));
    return result;
    
  }
  
  public UIDeliverMaterialTypeCriteria buildFrom(final DLDeliverMaterialTypeCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialTypeCriteria result = new com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialTypeCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIDeliverMaterialTypeCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return DLDeliverMaterialTypeCriteria.class;
  }
}
