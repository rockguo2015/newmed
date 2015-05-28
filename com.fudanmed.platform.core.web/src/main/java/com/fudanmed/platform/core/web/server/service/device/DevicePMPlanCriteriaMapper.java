package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCDevicePMPlanCriteria;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlanCriteria;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.DevicePMPlanCriteriaMapper")
public class DevicePMPlanCriteriaMapper extends AbstractDataTypeMapper<UIDevicePMPlanCriteria,RCDevicePMPlanCriteria> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UIDevicePMPlanCriteria from, final RCDevicePMPlanCriteria to) {
    to.setPlanDateFrom(convertService.toValue(java.util.Date.class,from.getPlanDateFrom()));
    to.setPlanDateTo(convertService.toValue(java.util.Date.class,from.getPlanDateTo()));
    to.setDeviceType(convertService.toValue(com.fudanmed.platform.core.device.RCDeviceType.class,from.getDeviceType()));
    to.setPmType(convertService.toValue(com.fudanmed.platform.core.device.pm.RCDevicePMType.class,from.getPmType()));
    to.setStatus(convertService.toValue(com.fudanmed.platform.core.device.pm.RCDevicePMPlanStatus.class,from.getStatus()));
    to.setLocation(convertService.toValue(com.fudanmed.platform.core.domain.RCOnsitePosition.class,from.getLocation()));
    to.setCategory(convertService.toValue(java.lang.String.class,from.getCategory()));
    
  }
  
  public UIDevicePMPlanCriteria copyFromEntity(final UIDevicePMPlanCriteria result, final RCDevicePMPlanCriteria entity) {
    if(entity==null) return null;
    result.setPlanDateFrom(convertService.toValue(java.util.Date.class,entity.getPlanDateFrom()));
    result.setPlanDateTo(convertService.toValue(java.util.Date.class,entity.getPlanDateTo()));
    result.setDeviceType(convertService.toValue(com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy.class,entity.getDeviceType()));
    result.setPmType(convertService.toValue(com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy.class,entity.getPmType()));
    result.setStatus(convertService.toValue(com.fudanmed.platform.core.web.shared.device.UIDevicePMPlanStatus.class,entity.getStatus()));
    result.setLocation(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy.class,entity.getLocation()));
    result.setCategory(convertService.toValue(java.lang.String.class,entity.getCategory()));
    return result;
    
  }
  
  public UIDevicePMPlanCriteria buildFrom(final RCDevicePMPlanCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.device.UIDevicePMPlanCriteria result = new com.fudanmed.platform.core.web.shared.device.UIDevicePMPlanCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIDevicePMPlanCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return RCDevicePMPlanCriteria.class;
  }
}
