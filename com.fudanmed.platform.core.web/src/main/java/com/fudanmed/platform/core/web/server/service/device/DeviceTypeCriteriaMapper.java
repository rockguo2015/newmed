package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDeviceTypeCriteria;
import com.fudanmed.platform.core.web.shared.device.UIDeviceTypeCriteria;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.DeviceTypeCriteriaMapper")
public class DeviceTypeCriteriaMapper extends AbstractDataTypeMapper<UIDeviceTypeCriteria,RCDeviceTypeCriteria> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UIDeviceTypeCriteria from, final RCDeviceTypeCriteria to) {
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    to.setCategory(convertService.toValue(java.lang.String.class,from.getCategory()));
    
  }
  
  public UIDeviceTypeCriteria copyFromEntity(final UIDeviceTypeCriteria result, final RCDeviceTypeCriteria entity) {
    if(entity==null) return null;
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setCategory(convertService.toValue(java.lang.String.class,entity.getCategory()));
    return result;
    
  }
  
  public UIDeviceTypeCriteria buildFrom(final RCDeviceTypeCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.device.UIDeviceTypeCriteria result = new com.fudanmed.platform.core.web.shared.device.UIDeviceTypeCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIDeviceTypeCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return RCDeviceTypeCriteria.class;
  }
}
