package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCPMWorkItem;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemEvaluate;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.web.client.device.CreatePMWorkItemTeamFinishReportPresenterService;
import com.fudanmed.platform.core.web.server.service.device.PMWorkItemEvaluateMapper;
import com.fudanmed.platform.core.web.server.service.device.PMWorkItemTeamFinishReportDataValidator;
import com.fudanmed.platform.core.web.server.service.device.PMWorkItemWorkerAssignmentMapper;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemEvaluate;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemTeamFinishReportData;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.CreatePMWorkItemTeamFinishReportPresenterService")
@Transactional
public class CreatePMWorkItemTeamFinishReportPresenterServiceImpl extends BaseService implements CreatePMWorkItemTeamFinishReportPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private PMWorkItemWorkerAssignmentMapper mapper;
  
  @Autowired
  private PMWorkItemTeamFinishReportDataValidator validator;
  
  @Autowired
  private PMWorkItemEvaluateMapper evaluateMapper;
  
  public void updateValue(final RCPMWorkItemProxy workItem, final UIPMWorkItemTeamFinishReportData uivalue) throws SessionTimeOutException, ValidationException {
    Validates.<UIPMWorkItemTeamFinishReportData>validateWith(uivalue, this.validator);
    RCPMWorkItem _resolved= null;
    if(workItem!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMWorkItem)com.uniquesoft.uidl.extensions.ModelObjects.resolve(workItem, entities);
    
    Date _finishDate = uivalue.getFinishDate();
    String _comment = uivalue.getComment();
     _resolved.teamFinish(_finishDate, _comment);
    UIPMWorkItemEvaluate _evaluate = uivalue.getEvaluate();
    RCPMWorkItem _resolved_1= null;
    if(workItem!=null) _resolved_1=(com.fudanmed.platform.core.device.pm.RCPMWorkItem)com.uniquesoft.uidl.extensions.ModelObjects.resolve(workItem, entities);
    
    RCPMWorkItemEvaluate _evaluate_1 =  _resolved_1.getEvaluate();
    this.evaluateMapper.transform(_evaluate, _evaluate_1);
  }
}
