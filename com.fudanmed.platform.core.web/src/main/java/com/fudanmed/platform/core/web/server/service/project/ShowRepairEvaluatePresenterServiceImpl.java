package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCRepairEvaluate;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.client.project.ShowRepairEvaluatePresenterService;
import com.fudanmed.platform.core.web.server.service.project.RepairEvaluateMapper;
import com.fudanmed.platform.core.web.shared.project.UIRepairEvaluate;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.ShowRepairEvaluatePresenterService")
@Transactional
public class ShowRepairEvaluatePresenterServiceImpl extends BaseService implements ShowRepairEvaluatePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RepairEvaluateMapper repairEvaluateMapper;
  
  public UIRepairEvaluate loadEvaluate(final RCRepairTaskProxy repairTask) throws SessionTimeOutException, ValidationException {
    RCRepairTask _resolved= null;
    if(repairTask!=null) _resolved=(com.fudanmed.platform.core.domain.RCRepairTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(repairTask, entities);
    
    RCRepairEvaluate _repairEvaluate =  _resolved.getRepairEvaluate();
    UIRepairEvaluate _transform = this.repairEvaluateMapper.transform(_repairEvaluate);
    return _transform;
  }
}
