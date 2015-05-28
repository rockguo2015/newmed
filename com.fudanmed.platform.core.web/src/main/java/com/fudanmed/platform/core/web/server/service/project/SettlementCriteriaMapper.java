package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCSettlementCriteria;
import com.fudanmed.platform.core.web.shared.project.UISettlementCriteria;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.SettlementCriteriaMapper")
public class SettlementCriteriaMapper extends AbstractDataTypeMapper<UISettlementCriteria,RCSettlementCriteria> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UISettlementCriteria from, final RCSettlementCriteria to) {
    
  }
  
  public UISettlementCriteria copyFromEntity(final UISettlementCriteria result, final RCSettlementCriteria entity) {
    if(entity==null) return null;
    return result;
    
  }
  
  public UISettlementCriteria buildFrom(final RCSettlementCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.project.UISettlementCriteria result = new com.fudanmed.platform.core.web.shared.project.UISettlementCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UISettlementCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return RCSettlementCriteria.class;
  }
}
