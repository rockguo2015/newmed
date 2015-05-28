package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCDevicePMPlan;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlan;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.DevicePMPlanMapper")
public class DevicePMPlanMapper extends AbstractEntityMapper<UIDevicePMPlan,RCDevicePMPlan> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCDevicePMPlan loadEntityById(final Long id) {
    return entities.get(RCDevicePMPlan.class,id);
  }
  
  public RCDevicePMPlan create() {
    return entities.create(RCDevicePMPlan.class);
  }
  
  public void copyToEntity(final UIDevicePMPlan from, final RCDevicePMPlan to) {
    to.setVersion(from.getVersion());
    to.setPlanDate(convertService.toValue(java.util.Date.class,from.getPlanDate()));
    
  }
  
  public UIDevicePMPlan copyFromEntity(final UIDevicePMPlan result, final RCDevicePMPlan entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setPlanDate(convertService.toValue(java.util.Date.class,entity.getPlanDate()));
    result.setStatus(convertService.toValue(com.fudanmed.platform.core.web.shared.device.UIDevicePMPlanStatus.class,entity.getStatus()));
    if(entity. getSpec()  != null )
    	result.setDescription(convertService.toValue(java.lang.String.class,entity.getSpec().getDescription()));
    if(entity. getSpec()  != null &&entity. getSpec().getDevice()  != null )
    	result.setSid(convertService.toValue(java.lang.String.class,entity.getSpec().getDevice().getSid()));
    if(entity. getSpec()  != null &&entity. getSpec().getDevice()  != null )
    	result.setName(convertService.toValue(java.lang.String.class,entity.getSpec().getDevice().getName()));
    if(entity. getSpec()  != null &&entity. getSpec().getDevice()  != null )
    	result.setSpecification(convertService.toValue(java.lang.String.class,entity.getSpec().getDevice().getSpecification()));
    if(entity. getSpec()  != null &&entity. getSpec().getDevice()  != null )
    	result.setLocation(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy.class,entity.getSpec().getDevice().getLocation()));
    if(entity. getSpec()  != null )
    	result.setPmType(convertService.toValue(com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy.class,entity.getSpec().getPmType()));
    if(entity. getSpec()  != null &&entity. getSpec().getDevice()  != null )
    	result.setDeviceType(convertService.toValue(com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy.class,entity.getSpec().getDevice().getDeviceType()));
    	result.setComment(convertService.toValue(java.lang.String.class,entity.getComment()));
    return result;
    
  }
  
  public UIDevicePMPlan buildFrom(final RCDevicePMPlan entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.device.UIDevicePMPlan result = new com.fudanmed.platform.core.web.shared.device.UIDevicePMPlan();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIDevicePMPlan.class;
  }
  
  public Class<?> getEntityClass() {
    return RCDevicePMPlan.class;
  }
}
