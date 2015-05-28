package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCDevicePMSpecification;
import com.fudanmed.platform.core.web.server.service.device.DevicePMSpecificationValidator;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMSpecification;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.DevicePMSpecificationMapper")
public class DevicePMSpecificationMapper extends AbstractEntityMapper<UIDevicePMSpecification,RCDevicePMSpecification> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCDevicePMSpecification loadEntityById(final Long id) {
    return entities.get(RCDevicePMSpecification.class,id);
  }
  
  public RCDevicePMSpecification create() {
    return entities.create(RCDevicePMSpecification.class);
  }
  
  @Autowired
  private DevicePMSpecificationValidator validator;
  
  public void copyToEntity(final UIDevicePMSpecification from, final RCDevicePMSpecification to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setDevice(convertService.toValue(com.fudanmed.platform.core.device.RCDevice.class,from.getDevice()));
    to.setPmType(convertService.toValue(com.fudanmed.platform.core.device.pm.RCDevicePMType.class,from.getPmType()));
    to.setIntervalInDays(convertService.toValue(java.lang.Integer.class,from.getIntervalInDays()));
    to.setDescription(convertService.toValue(java.lang.String.class,from.getDescription()));
    
  }
  
  public UIDevicePMSpecification copyFromEntity(final UIDevicePMSpecification result, final RCDevicePMSpecification entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setDevice(convertService.toValue(com.fudanmed.platform.core.device.proxy.RCDeviceProxy.class,entity.getDevice()));
    result.setPmType(convertService.toValue(com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy.class,entity.getPmType()));
    result.setIntervalInDays(convertService.toValue(java.lang.Integer.class,entity.getIntervalInDays()));
    result.setDescription(convertService.toValue(java.lang.String.class,entity.getDescription()));
    result.setLastPMPlanDate(convertService.toValue(java.util.Date.class,entity.getLastPMPlanDate()));
    if(entity. getDevice()  != null )
    	result.setSid(convertService.toValue(java.lang.String.class,entity.getDevice().getSid()));
    if(entity. getDevice()  != null )
    	result.setName(convertService.toValue(java.lang.String.class,entity.getDevice().getName()));
    if(entity. getDevice()  != null )
    	result.setSpecification(convertService.toValue(java.lang.String.class,entity.getDevice().getSpecification()));
    if(entity. getDevice()  != null )
    	result.setLocation(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy.class,entity.getDevice().getLocation()));
    if(entity. getDevice()  != null )
    	result.setProductor(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCSupplierProxy.class,entity.getDevice().getProductor()));
    if(entity. getDevice()  != null )
    	result.setSupplier(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCSupplierProxy.class,entity.getDevice().getSupplier()));
    if(entity. getDevice()  != null )
    	result.setDeviceType(convertService.toValue(com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy.class,entity.getDevice().getDeviceType()));
    return result;
    
  }
  
  public UIDevicePMSpecification buildFrom(final RCDevicePMSpecification entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.device.UIDevicePMSpecification result = new com.fudanmed.platform.core.web.shared.device.UIDevicePMSpecification();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIDevicePMSpecification.class;
  }
  
  public Class<?> getEntityClass() {
    return RCDevicePMSpecification.class;
  }
}
