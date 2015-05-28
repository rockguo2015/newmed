package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecordCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecordCriteria;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.WorkItemStockRecordCriteriaMapper")
public class WorkItemStockRecordCriteriaMapper extends AbstractDataTypeMapper<UIWorkItemStockRecordCriteria,RCWorkItemStockRecordCriteria> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UIWorkItemStockRecordCriteria from, final RCWorkItemStockRecordCriteria to) {
    to.setSid(convertService.toValue(java.lang.String.class,from.getInfo()));
    
  }
  
  public UIWorkItemStockRecordCriteria copyFromEntity(final UIWorkItemStockRecordCriteria result, final RCWorkItemStockRecordCriteria entity) {
    if(entity==null) return null;
    	result.setInfo(convertService.toValue(java.lang.String.class,entity.getSid()));
    return result;
    
  }
  
  public UIWorkItemStockRecordCriteria buildFrom(final RCWorkItemStockRecordCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecordCriteria result = new com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecordCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIWorkItemStockRecordCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return RCWorkItemStockRecordCriteria.class;
  }
}
