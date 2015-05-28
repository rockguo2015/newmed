package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.RCDeviceTypeCategory;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryManagementPresenterService;
import com.fudanmed.platform.core.web.server.service.device.DeviceTypeCategoryMapper;
import com.fudanmed.platform.core.web.server.service.device.DeviceTypeMapper;
import com.fudanmed.platform.core.web.shared.device.UIDeviceType;
import com.fudanmed.platform.core.web.shared.device.UIDeviceTypeCategory;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryManagementPresenterService")
@Transactional
public class DeviceTypeCategoryManagementPresenterServiceImpl extends BaseService implements DeviceTypeCategoryManagementPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DeviceTypeCategoryMapper mapper;
  
  @Autowired
  private DeviceTypeMapper DeviceTypeMapper;
  
  public Collection<UIDeviceTypeCategory> loadAllDeviceTypeCategory() throws SessionTimeOutException, ValidationException {
    Collection<RCDeviceTypeCategory> _all = this.entities.<RCDeviceTypeCategory>all(RCDeviceTypeCategory.class);
    final Function1<RCDeviceTypeCategory,UIDeviceTypeCategory> _function = new Function1<RCDeviceTypeCategory,UIDeviceTypeCategory>() {
        public UIDeviceTypeCategory apply(final RCDeviceTypeCategory it) {
          UIDeviceTypeCategory _transform = DeviceTypeCategoryManagementPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIDeviceTypeCategory> _map = IterableExtensions.<RCDeviceTypeCategory, UIDeviceTypeCategory>map(_all, _function);
    Collection<UIDeviceTypeCategory> _unlazy = IterableExtensions2.<UIDeviceTypeCategory>unlazy(_map);
    return _unlazy;
  }
  
  public void delete(final RCDeviceTypeCategoryProxy value) throws SessionTimeOutException, ValidationException {
    RCDeviceTypeCategory _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.device.RCDeviceTypeCategory)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    this.entities.delete( _resolved);
  }
  
  public UIDeviceTypeCategory getValue(final RCDeviceTypeCategoryProxy org) throws SessionTimeOutException, ValidationException {
    RCDeviceTypeCategory _resolved= null;
    if(org!=null) _resolved=(com.fudanmed.platform.core.device.RCDeviceTypeCategory)com.uniquesoft.uidl.extensions.ModelObjects.resolve(org, entities);
    
    UIDeviceTypeCategory _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public Collection<UIDeviceType> loadItems(final RCDeviceTypeCategoryProxy value) throws SessionTimeOutException, ValidationException {
    RCDeviceTypeCategory _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.device.RCDeviceTypeCategory)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    Collection<RCDeviceType> _deviceTypes =  _resolved.getDeviceTypes();
    final Function1<RCDeviceType,UIDeviceType> _function = new Function1<RCDeviceType,UIDeviceType>() {
        public UIDeviceType apply(final RCDeviceType it) {
          UIDeviceType _transform = DeviceTypeCategoryManagementPresenterServiceImpl.this.DeviceTypeMapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIDeviceType> _map = IterableExtensions.<RCDeviceType, UIDeviceType>map(_deviceTypes, _function);
    Collection<UIDeviceType> _unlazy = IterableExtensions2.<UIDeviceType>unlazy(_map);
    return _unlazy;
  }
  
  public void deleteChild(final RCDeviceTypeProxy child) throws SessionTimeOutException, ValidationException {
    RCDeviceType _resolved= null;
    if(child!=null) _resolved=(com.fudanmed.platform.core.device.RCDeviceType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(child, entities);
    
    RCDeviceTypeCategory _category =  _resolved.getCategory();
    RCDeviceType _resolved_1= null;
    if(child!=null) _resolved_1=(com.fudanmed.platform.core.device.RCDeviceType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(child, entities);
    
    _category.deleteDeviceType( _resolved_1);
  }
}
