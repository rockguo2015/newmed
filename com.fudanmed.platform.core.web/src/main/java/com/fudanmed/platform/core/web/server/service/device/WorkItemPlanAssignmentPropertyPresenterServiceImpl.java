package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignment;
import com.fudanmed.platform.core.device.pm.proxy.RCWorkItemPlanAssignmentProxy;
import com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentPropertyPresenterService;
import com.fudanmed.platform.core.web.server.service.device.WorkItemPlanAssignmentMapper;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignment;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentPropertyPresenterService")
@Transactional
public class WorkItemPlanAssignmentPropertyPresenterServiceImpl extends BaseService implements WorkItemPlanAssignmentPropertyPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private WorkItemPlanAssignmentMapper mapper;
  
  public UIWorkItemPlanAssignment loadValue(final RCWorkItemPlanAssignmentProxy value) throws SessionTimeOutException, ValidationException {
    RCWorkItemPlanAssignment _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignment)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    UIWorkItemPlanAssignment _transform = this.mapper.transform( _resolved);
    return _transform;
  }
}
