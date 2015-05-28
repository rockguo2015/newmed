package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCDevicePMSpecificationCriteria;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMSpecificationCriteria;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.DevicePMSpecificationCriteriaMapper")
public class DevicePMSpecificationCriteriaMapper extends AbstractDataTypeMapper<UIDevicePMSpecificationCriteria,RCDevicePMSpecificationCriteria> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UIDevicePMSpecificationCriteria from, final RCDevicePMSpecificationCriteria to) {
    to.setSid(convertService.toValue(java.lang.String.class,from.getSid()));
    
  }
  
  public UIDevicePMSpecificationCriteria copyFromEntity(final UIDevicePMSpecificationCriteria result, final RCDevicePMSpecificationCriteria entity) {
    if(entity==null) return null;
    result.setSid(convertService.toValue(java.lang.String.class,entity.getSid()));
    return result;
    
  }
  
  public UIDevicePMSpecificationCriteria buildFrom(final RCDevicePMSpecificationCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.device.UIDevicePMSpecificationCriteria result = new com.fudanmed.platform.core.web.shared.device.UIDevicePMSpecificationCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIDevicePMSpecificationCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return RCDevicePMSpecificationCriteria.class;
  }
}
