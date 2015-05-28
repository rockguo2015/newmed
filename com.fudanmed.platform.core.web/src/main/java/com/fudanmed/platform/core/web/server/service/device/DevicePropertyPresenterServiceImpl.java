package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.web.client.device.DevicePropertyPresenterService;
import com.fudanmed.platform.core.web.server.service.device.DeviceMapper;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.DevicePropertyPresenterService")
@Transactional
public class DevicePropertyPresenterServiceImpl extends BaseService implements DevicePropertyPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DeviceMapper mapper;
  
  public UIDevice loadDeviceInfo(final RCDeviceProxy device) throws SessionTimeOutException, ValidationException {
    RCDevice _resolved= null;
    if(device!=null) _resolved=(com.fudanmed.platform.core.device.RCDevice)com.uniquesoft.uidl.extensions.ModelObjects.resolve(device, entities);
    
    UIDevice _transform = this.mapper.transform( _resolved);
    return _transform;
  }
}
