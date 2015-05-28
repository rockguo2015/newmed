package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeUser;
import com.fudanmed.platform.core.web.server.service.device.DeviceValidator;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.langlab.domain.security.ISystemUserService;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.DeviceMapper")
public class DeviceMapper extends AbstractEntityMapper<UIDevice,RCDevice> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCDevice loadEntityById(final Long id) {
    return entities.get(RCDevice.class,id);
  }
  
  public RCDevice create() {
    return entities.create(RCDevice.class);
  }
  
  @Autowired
  private ISystemUserService systemUserService;
  
  @Autowired
  private DeviceValidator validator;
  
  public void copyToEntity(final UIDevice from, final RCDevice to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setSid(convertService.toValue(java.lang.String.class,from.getSid()));
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    to.setSpecification(convertService.toValue(java.lang.String.class,from.getSpecification()));
    to.setLocation(convertService.toValue(com.fudanmed.platform.core.domain.RCOnsitePosition.class,from.getLocation()));
    to.setLocationName(convertService.toValue(java.lang.String.class,from.getLocationName()));
    to.setServiceLocationName(convertService.toValue(java.lang.String.class,from.getServiceLocationName()));
    to.setProductor(convertService.toValue(com.fudanmed.platform.core.domain.RCSupplier.class,from.getProductor()));
    to.setSupplier(convertService.toValue(com.fudanmed.platform.core.domain.RCSupplier.class,from.getSupplier()));
    to.setDeviceType(convertService.toValue(com.fudanmed.platform.core.device.RCDeviceType.class,from.getDeviceType()));
    to.setDeviceIndicator(convertService.toValue(com.fudanmed.platform.core.device.RCDeviceIndicator.class,from.getDeviceIndicator()));
    to.setUsageType(convertService.toValue(com.fudanmed.platform.core.device.RCDeviceUsageType.class,from.getUsageType()));
    to.setAcquireType(convertService.toValue(com.fudanmed.platform.core.device.RCAcquireType.class,from.getAcquireType()));
    to.setBuyTime(convertService.toValue(java.util.Date.class,from.getBuyTime()));
    to.setBuyPrice(convertService.toValue(java.lang.Double.class,from.getBuyPrice()));
    to.setOutStockTime(convertService.toValue(java.util.Date.class,from.getOutStockTime()));
    to.setNetPrice(convertService.toValue(java.lang.Double.class,from.getNetPrice()));
    to.setOwner(convertService.toValue(com.fudanmed.platform.core.domain.RCEmployee.class,from.getOwner()));
    to.setOwnerDepartmentName(convertService.toValue(java.lang.String.class,from.getOwnerDepartmentName()));
    to.setDepreciationYears(convertService.toValue(java.lang.Integer.class,from.getDepreciationYears()));
    to.setNetLeaveRate(convertService.toValue(java.lang.Double.class,from.getNetLeaveRate()));
    to.setComment(convertService.toValue(java.lang.String.class,from.getComment()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final UIDevice _gwt, final RCDevice _entity) {
    User _currentUser = this.systemUserService.getCurrentUser();
    RCEmployee _employee = ((RCEmployeeUser) _currentUser).getEmployee();
    _entity.setOperator(_employee);
  }
  
  public UIDevice copyFromEntity(final UIDevice result, final RCDevice entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setSid(convertService.toValue(java.lang.String.class,entity.getSid()));
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setSpecification(convertService.toValue(java.lang.String.class,entity.getSpecification()));
    result.setLocation(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy.class,entity.getLocation()));
    result.setLocationName(convertService.toValue(java.lang.String.class,entity.getLocationName()));
    result.setServiceLocationName(convertService.toValue(java.lang.String.class,entity.getServiceLocationName()));
    result.setProductor(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCSupplierProxy.class,entity.getProductor()));
    result.setSupplier(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCSupplierProxy.class,entity.getSupplier()));
    result.setDeviceType(convertService.toValue(com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy.class,entity.getDeviceType()));
    result.setDeviceIndicator(convertService.toValue(com.fudanmed.platform.core.device.proxy.RCDeviceIndicatorProxy.class,entity.getDeviceIndicator()));
    result.setUsageType(convertService.toValue(com.fudanmed.platform.core.device.proxy.RCDeviceUsageTypeProxy.class,entity.getUsageType()));
    result.setAcquireType(convertService.toValue(com.fudanmed.platform.core.device.proxy.RCAcquireTypeProxy.class,entity.getAcquireType()));
    result.setBuyTime(convertService.toValue(java.util.Date.class,entity.getBuyTime()));
    result.setBuyPrice(convertService.toValue(java.lang.Double.class,entity.getBuyPrice()));
    result.setOutStockTime(convertService.toValue(java.util.Date.class,entity.getOutStockTime()));
    result.setNetPrice(convertService.toValue(java.lang.Double.class,entity.getNetPrice()));
    result.setOwner(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy.class,entity.getOwner()));
    result.setOwnerDepartmentName(convertService.toValue(java.lang.String.class,entity.getOwnerDepartmentName()));
    result.setDepreciationYears(convertService.toValue(java.lang.Integer.class,entity.getDepreciationYears()));
    result.setNetLeaveRate(convertService.toValue(java.lang.Double.class,entity.getNetLeaveRate()));
    result.setComment(convertService.toValue(java.lang.String.class,entity.getComment()));
    result.setOperator(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy.class,entity.getOperator()));
    return result;
    
  }
  
  public UIDevice buildFrom(final RCDevice entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.device.UIDevice result = new com.fudanmed.platform.core.web.shared.device.UIDevice();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIDevice.class;
  }
  
  public Class<?> getEntityClass() {
    return RCDevice.class;
  }
}
