package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCStockTakingRecordCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecordCriteria;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.StockTakingRecordCriteriaMapper")
public class StockTakingRecordCriteriaMapper extends AbstractDataTypeMapper<UIStockTakingRecordCriteria,RCStockTakingRecordCriteria> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UIStockTakingRecordCriteria from, final RCStockTakingRecordCriteria to) {
    to.setSid(convertService.toValue(java.lang.String.class,from.getSid()));
    to.setDateFrom(convertService.toValue(java.util.Date.class,from.getDateFrom()));
    to.setDateTo(convertService.toValue(java.util.Date.class,from.getDateTo()));
    
  }
  
  public UIStockTakingRecordCriteria copyFromEntity(final UIStockTakingRecordCriteria result, final RCStockTakingRecordCriteria entity) {
    if(entity==null) return null;
    result.setSid(convertService.toValue(java.lang.String.class,entity.getSid()));
    result.setDateFrom(convertService.toValue(java.util.Date.class,entity.getDateFrom()));
    result.setDateTo(convertService.toValue(java.util.Date.class,entity.getDateTo()));
    return result;
    
  }
  
  public UIStockTakingRecordCriteria buildFrom(final RCStockTakingRecordCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecordCriteria result = new com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecordCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIStockTakingRecordCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return RCStockTakingRecordCriteria.class;
  }
}
