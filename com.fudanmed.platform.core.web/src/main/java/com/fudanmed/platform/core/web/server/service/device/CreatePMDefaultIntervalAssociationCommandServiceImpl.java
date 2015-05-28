package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.pm.RCPMDeviceTypeEntry;
import com.fudanmed.platform.core.device.pm.RCPMDeviceTypeEntryDAO;
import com.fudanmed.platform.core.device.pm.proxy.RCPMDeviceTypeEntryProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.device.CreatePMDefaultIntervalAssociationCommandService;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.CreatePMDefaultIntervalAssociationCommandService")
@Transactional
public class CreatePMDefaultIntervalAssociationCommandServiceImpl extends BaseService implements CreatePMDefaultIntervalAssociationCommandService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCPMDeviceTypeEntryDAO dao;
  
  public RCPMDeviceTypeEntryProxy getRCPMDeviceTypeEntry(final RCDeviceTypeProxy deviceType) throws SessionTimeOutException, ValidationException {
    RCDeviceType _resolved= null;
    if(deviceType!=null) _resolved=(com.fudanmed.platform.core.device.RCDeviceType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(deviceType, entities);
    
    RCPMDeviceTypeEntry _findByDeviceType = this.dao.findByDeviceType( _resolved);
    RCPMDeviceTypeEntryProxy _proxy = _findByDeviceType.toProxy();
    return _proxy;
  }
}
