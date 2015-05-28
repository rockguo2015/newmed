package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDeviceCriteria;
import com.fudanmed.platform.core.web.shared.device.UIDeviceCriteria;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.DeviceCriteriaMapper")
public class DeviceCriteriaMapper extends AbstractDataTypeMapper<UIDeviceCriteria,RCDeviceCriteria> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UIDeviceCriteria from, final RCDeviceCriteria to) {
    to.setSid(convertService.toValue(java.lang.String.class,from.getSid()));
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    to.setDeviceType(convertService.toValue(com.fudanmed.platform.core.device.RCDeviceType.class,from.getDeviceType()));
    to.setCategory(convertService.toValue(java.lang.String.class,from.getCategory()));
    to.setLocation(convertService.toValue(com.fudanmed.platform.core.domain.RCOnsitePosition.class,from.getLocation()));
    
  }
  
  public UIDeviceCriteria copyFromEntity(final UIDeviceCriteria result, final RCDeviceCriteria entity) {
    if(entity==null) return null;
    result.setSid(convertService.toValue(java.lang.String.class,entity.getSid()));
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setDeviceType(convertService.toValue(com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy.class,entity.getDeviceType()));
    result.setCategory(convertService.toValue(java.lang.String.class,entity.getCategory()));
    result.setLocation(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy.class,entity.getLocation()));
    return result;
    
  }
  
  public UIDeviceCriteria buildFrom(final RCDeviceCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.device.UIDeviceCriteria result = new com.fudanmed.platform.core.web.shared.device.UIDeviceCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIDeviceCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return RCDeviceCriteria.class;
  }
}
