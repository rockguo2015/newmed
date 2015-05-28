package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCPMWorkItem;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.web.client.device.PMWorkItemPropertyPresenterService;
import com.fudanmed.platform.core.web.server.service.device.PMWorkItemMapper;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItem;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.PMWorkItemPropertyPresenterService")
@Transactional
public class PMWorkItemPropertyPresenterServiceImpl extends BaseService implements PMWorkItemPropertyPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private PMWorkItemMapper mapper;
  
  public UIPMWorkItem loadValue(final RCPMWorkItemProxy value) throws SessionTimeOutException, ValidationException {
    RCPMWorkItem _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMWorkItem)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    UIPMWorkItem _transform = this.mapper.transform( _resolved);
    return _transform;
  }
}
