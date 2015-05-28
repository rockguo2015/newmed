package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.common.RCSystemParameter;
import com.fudanmed.platform.core.common.RCSystemParameterService;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemWorkerAssignmentProxy;
import com.fudanmed.platform.core.web.client.device.PrintPMWorkItemAssignmentCommandService;
import com.fudanmed.platform.core.web.server.service.template.PMWorkItemTemplate;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.PrintPMWorkItemAssignmentCommandService")
@Transactional
public class PrintPMWorkItemAssignmentCommandServiceImpl extends BaseService implements PrintPMWorkItemAssignmentCommandService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCSystemParameterService systemParameter;
  
  public String generatePrintContents(final RCPMWorkItemWorkerAssignmentProxy workItemTask) throws SessionTimeOutException, ValidationException {
    String _xblockexpression = null;
    {
      RCPMWorkItemWorkerAssignment _resolved= null;
      if(workItemTask!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment)com.uniquesoft.uidl.extensions.ModelObjects.resolve(workItemTask, entities);
      
      RCSystemParameter _systemParameter = this.systemParameter.getSystemParameter();
      final String result = PMWorkItemTemplate.template( _resolved, _systemParameter);
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
}
