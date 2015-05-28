package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.entityextension.RCCustomizableTypeCriteria;
import com.fudanmed.platform.core.web.shared.device.UICustomizableTypeCriteria;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.CustomizableTypeCriteriaMapper")
public class CustomizableTypeCriteriaMapper extends AbstractDataTypeMapper<UICustomizableTypeCriteria,RCCustomizableTypeCriteria> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UICustomizableTypeCriteria from, final RCCustomizableTypeCriteria to) {
    
  }
  
  public UICustomizableTypeCriteria copyFromEntity(final UICustomizableTypeCriteria result, final RCCustomizableTypeCriteria entity) {
    if(entity==null) return null;
    return result;
    
  }
  
  public UICustomizableTypeCriteria buildFrom(final RCCustomizableTypeCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.device.UICustomizableTypeCriteria result = new com.fudanmed.platform.core.web.shared.device.UICustomizableTypeCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UICustomizableTypeCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return RCCustomizableTypeCriteria.class;
  }
}
