package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCDevicePMSpecification;
import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMSpecificationProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDevicePMSpecificationPresenterService;
import com.fudanmed.platform.core.web.server.service.device.DevicePMSpecificationMapper;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMSpecification;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.CreateOrUpdateDevicePMSpecificationPresenterService")
@Transactional
public class CreateOrUpdateDevicePMSpecificationPresenterServiceImpl extends BaseService implements CreateOrUpdateDevicePMSpecificationPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DevicePMSpecificationMapper mapper;
  
  public UIDevicePMSpecification loadValue(final RCDevicePMSpecificationProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCDevicePMSpecification _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCDevicePMSpecification)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIDevicePMSpecification _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIDevicePMSpecification uivalue) throws SessionTimeOutException, ValidationException {
    RCDevicePMSpecification _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCDevicePMSpecification)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public void createValue(final UIDevicePMSpecification uivalue) throws SessionTimeOutException, ValidationException {
    RCDevicePMSpecification value = this.entities.<RCDevicePMSpecification>create(RCDevicePMSpecification.class);
    this.mapper.transform(uivalue, value);
  }
}
