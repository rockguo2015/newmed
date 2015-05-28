package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.RCDeviceTypeCategory;
import com.fudanmed.platform.core.web.server.service.device.DeviceTypeValidator;
import com.fudanmed.platform.core.web.shared.device.UIDeviceType;
import com.google.common.base.Objects;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.DeviceTypeMapper")
public class DeviceTypeMapper extends AbstractEntityMapper<UIDeviceType,RCDeviceType> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCDeviceType loadEntityById(final Long id) {
    return entities.get(RCDeviceType.class,id);
  }
  
  public RCDeviceType create() {
    return entities.create(RCDeviceType.class);
  }
  
  @Autowired
  private DeviceTypeValidator validator;
  
  public void copyToEntity(final UIDeviceType from, final RCDeviceType to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setCode(convertService.toValue(java.lang.String.class,from.getCode()));
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    to.setDepreciationYears(convertService.toValue(java.lang.Integer.class,from.getDepreciationYears()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final UIDeviceType _gwt, final RCDeviceType _entity) {
    String path = "";
    RCDeviceTypeCategory curObj = _entity.getCategory();
    boolean _notEquals = (!Objects.equal(curObj, null));
    boolean _while = _notEquals;
    while (_while) {
      {
        String _plus = (path + "[");
        Long _id = curObj.getId();
        String _string = _id.toString();
        String _plus_1 = (_plus + _string);
        String _plus_2 = (_plus_1 + "]");
        path = _plus_2;
        RCDeviceTypeCategory _parent = curObj.getParent();
        curObj = _parent;
      }
      boolean _notEquals_1 = (!Objects.equal(curObj, null));
      _while = _notEquals_1;
    }
    _entity.setPath(path);
  }
  
  public UIDeviceType copyFromEntity(final UIDeviceType result, final RCDeviceType entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setCode(convertService.toValue(java.lang.String.class,entity.getCode()));
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setDepreciationYears(convertService.toValue(java.lang.Integer.class,entity.getDepreciationYears()));
    return result;
    
  }
  
  public UIDeviceType buildFrom(final RCDeviceType entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.device.UIDeviceType result = new com.fudanmed.platform.core.web.shared.device.UIDeviceType();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIDeviceType.class;
  }
  
  public Class<?> getEntityClass() {
    return RCDeviceType.class;
  }
}
