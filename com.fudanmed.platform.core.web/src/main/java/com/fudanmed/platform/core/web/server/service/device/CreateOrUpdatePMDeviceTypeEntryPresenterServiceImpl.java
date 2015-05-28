package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.pm.RCPMDeviceTypeEntry;
import com.fudanmed.platform.core.device.pm.RCPMDeviceTypeEntryDAO;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMDeviceTypeEntryPresenterService;
import com.fudanmed.platform.core.web.server.service.device.PMDeviceTypeEntryMapper;
import com.fudanmed.platform.core.web.shared.device.UIPMDeviceTypeEntry;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMDeviceTypeEntryPresenterService")
@Transactional
public class CreateOrUpdatePMDeviceTypeEntryPresenterServiceImpl extends BaseService implements CreateOrUpdatePMDeviceTypeEntryPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private PMDeviceTypeEntryMapper mapper;
  
  @Autowired
  private RCPMDeviceTypeEntryDAO dao;
  
  public UIPMDeviceTypeEntry loadValue(final RCDeviceTypeProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCDeviceType _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.device.RCDeviceType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    RCPMDeviceTypeEntry _findByDeviceType = this.dao.findByDeviceType( _resolved);
    UIPMDeviceTypeEntry _transform = this.mapper.transform(_findByDeviceType);
    return _transform;
  }
  
  public void updateValue(final UIPMDeviceTypeEntry uivalue) throws SessionTimeOutException, ValidationException {
    RCPMDeviceTypeEntry _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMDeviceTypeEntry)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
}
