package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.RCDeviceDAO;
import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDevicePresenterService;
import com.fudanmed.platform.core.web.server.service.device.DeviceMapper;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.CreateOrUpdateDevicePresenterService")
@Transactional
public class CreateOrUpdateDevicePresenterServiceImpl extends BaseService implements CreateOrUpdateDevicePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DeviceMapper mapper;
  
  @Autowired
  private RCDeviceDAO deviceDAO;
  
  public UIDevice loadValue(final RCDeviceProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCDevice _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.device.RCDevice)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIDevice _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIDevice uivalue) throws SessionTimeOutException, ValidationException {
    RCDevice _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.device.RCDevice)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    final Procedure1<RCDevice> _function = new Procedure1<RCDevice>() {
        public void apply(final RCDevice it) {
          CreateOrUpdateDevicePresenterServiceImpl.this.mapper.transform(uivalue, it);
        }
      };
    this.deviceDAO.update( _resolved, _function);
  }
  
  public void createValue(final UIDevice uivalue) throws SessionTimeOutException, ValidationException {
    String _sid = uivalue.getSid();
    final Procedure1<RCDevice> _function = new Procedure1<RCDevice>() {
        public void apply(final RCDevice it) {
          CreateOrUpdateDevicePresenterServiceImpl.this.mapper.transform(uivalue, it);
        }
      };
    this.deviceDAO.createDevice(_sid, _function);
  }
}
