package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.RCDeviceTypeCategory;
import com.fudanmed.platform.core.device.RCDeviceTypeCategoryDAO;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDeviceTypePresenterService;
import com.fudanmed.platform.core.web.server.service.device.DeviceTypeMapper;
import com.fudanmed.platform.core.web.shared.device.UIDeviceType;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.CreateOrUpdateDeviceTypePresenterService")
@Transactional
public class CreateOrUpdateDeviceTypePresenterServiceImpl extends BaseService implements CreateOrUpdateDeviceTypePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DeviceTypeMapper mapper;
  
  @Autowired
  private RCDeviceTypeCategoryDAO dao;
  
  public UIDeviceType loadValue(final RCDeviceTypeProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCDeviceType _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.device.RCDeviceType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIDeviceType _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIDeviceType uivalue) throws SessionTimeOutException, ValidationException {
    RCDeviceType _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.device.RCDeviceType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public void createValueWithClone(final RCDeviceTypeCategoryProxy categoryType, final RCDeviceTypeProxy cloneSource, final UIDeviceType uivalue) throws SessionTimeOutException, ValidationException {
    RCDeviceTypeCategory _resolved= null;
    if(categoryType!=null) _resolved=(com.fudanmed.platform.core.device.RCDeviceTypeCategory)com.uniquesoft.uidl.extensions.ModelObjects.resolve(categoryType, entities);
    
    RCDeviceType _resolved_1= null;
    if(cloneSource!=null) _resolved_1=(com.fudanmed.platform.core.device.RCDeviceType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(cloneSource, entities);
    
    RCDeviceType _cloneDeviceType =  _resolved.cloneDeviceType( _resolved_1);
    final Procedure1<RCDeviceType> _function = new Procedure1<RCDeviceType>() {
        public void apply(final RCDeviceType it) {
          CreateOrUpdateDeviceTypePresenterServiceImpl.this.mapper.transform(uivalue, it);
        }
      };
    ObjectExtensions.<RCDeviceType>operator_doubleArrow(_cloneDeviceType, _function);
  }
  
  public void createValue(final RCDeviceTypeCategoryProxy categoryType, final UIDeviceType uivalue) throws SessionTimeOutException, ValidationException {
    RCDeviceTypeCategory _resolved= null;
    if(categoryType!=null) _resolved=(com.fudanmed.platform.core.device.RCDeviceTypeCategory)com.uniquesoft.uidl.extensions.ModelObjects.resolve(categoryType, entities);
    
    RCDeviceType _createDeviceType =  _resolved.createDeviceType();
    this.mapper.transform(uivalue, _createDeviceType);
  }
  
  public RCDeviceTypeCategoryProxy loadCategory(final RCDeviceTypeProxy deviceType) throws SessionTimeOutException, ValidationException {
    RCDeviceType _resolved= null;
    if(deviceType!=null) _resolved=(com.fudanmed.platform.core.device.RCDeviceType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(deviceType, entities);
    
    RCDeviceTypeCategory _category =  _resolved.getCategory();
    RCDeviceTypeCategoryProxy _proxy = _category.toProxy();
    return _proxy;
  }
}
