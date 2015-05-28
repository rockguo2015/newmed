package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCPMDefaultIntervalAssociation;
import com.fudanmed.platform.core.device.pm.RCPMDeviceTypeEntry;
import com.fudanmed.platform.core.device.pm.proxy.RCPMDefaultIntervalAssociationProxy;
import com.fudanmed.platform.core.web.client.device.DeletePMDefaultIntervalAssociationCommandService;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.DeletePMDefaultIntervalAssociationCommandService")
@Transactional
public class DeletePMDefaultIntervalAssociationCommandServiceImpl extends BaseService implements DeletePMDefaultIntervalAssociationCommandService {
  @Autowired
  private IObjectFactory entities;
  
  public void delete(final RCPMDefaultIntervalAssociationProxy value) throws SessionTimeOutException, ValidationException {
    RCPMDefaultIntervalAssociation _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMDefaultIntervalAssociation)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    RCPMDeviceTypeEntry _entry =  _resolved.getEntry();
    RCPMDefaultIntervalAssociation _resolved_1= null;
    if(value!=null) _resolved_1=(com.fudanmed.platform.core.device.pm.RCPMDefaultIntervalAssociation)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    _entry.removeFromIntervals( _resolved_1);
  }
}
