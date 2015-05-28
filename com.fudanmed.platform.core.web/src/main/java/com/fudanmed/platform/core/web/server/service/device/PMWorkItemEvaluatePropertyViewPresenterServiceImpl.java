package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCPMWorkItem;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemEvaluate;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.web.client.device.PMWorkItemEvaluatePropertyViewPresenterService;
import com.fudanmed.platform.core.web.server.service.device.PMWorkItemEvaluateMapper;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemEvaluate;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.PMWorkItemEvaluatePropertyViewPresenterService")
@Transactional
public class PMWorkItemEvaluatePropertyViewPresenterServiceImpl extends BaseService implements PMWorkItemEvaluatePropertyViewPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private PMWorkItemEvaluateMapper mapper;
  
  public UIPMWorkItemEvaluate loadValue(final RCPMWorkItemProxy value) throws SessionTimeOutException, ValidationException {
    RCPMWorkItem _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMWorkItem)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    RCPMWorkItemEvaluate _evaluate =  _resolved.getEvaluate();
    UIPMWorkItemEvaluate _transform = this.mapper.transform(_evaluate);
    return _transform;
  }
}
