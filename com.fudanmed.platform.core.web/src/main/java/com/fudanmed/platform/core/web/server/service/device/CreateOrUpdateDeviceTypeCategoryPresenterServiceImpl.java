package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDeviceTypeCategory;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDeviceTypeCategoryPresenterService;
import com.fudanmed.platform.core.web.server.service.device.DeviceTypeCategoryMapper;
import com.fudanmed.platform.core.web.shared.device.UIDeviceTypeCategory;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.CreateOrUpdateDeviceTypeCategoryPresenterService")
@Transactional
public class CreateOrUpdateDeviceTypeCategoryPresenterServiceImpl extends BaseService implements CreateOrUpdateDeviceTypeCategoryPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DeviceTypeCategoryMapper mapper;
  
  public UIDeviceTypeCategory loadValue(final RCDeviceTypeCategoryProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCDeviceTypeCategory _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.device.RCDeviceTypeCategory)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIDeviceTypeCategory _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIDeviceTypeCategory uivalue) throws SessionTimeOutException, ValidationException {
    RCDeviceTypeCategory _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.device.RCDeviceTypeCategory)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public RCDeviceTypeCategoryProxy createValue(final UIDeviceTypeCategory uivalue) throws SessionTimeOutException, ValidationException {
    RCDeviceTypeCategoryProxy _xblockexpression = null;
    {
      RCDeviceTypeCategory value = this.entities.<RCDeviceTypeCategory>create(RCDeviceTypeCategory.class);
      this.mapper.transform(uivalue, value);
      RCDeviceTypeCategoryProxy _proxy = value.toProxy();
      _xblockexpression = (_proxy);
    }
    return _xblockexpression;
  }
}
