package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.client.project.RepairTaskDetailInfoPresenterService;
import com.fudanmed.platform.core.web.server.service.project.RepairTaskMapper;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.RepairTaskDetailInfoPresenterService")
@Transactional
public class RepairTaskDetailInfoPresenterServiceImpl extends BaseService implements RepairTaskDetailInfoPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RepairTaskMapper mapper;
  
  public UIRepairTask loadRepairTask(final RCRepairTaskProxy repairTask) throws SessionTimeOutException, ValidationException {
    RCRepairTask _resolved= null;
    if(repairTask!=null) _resolved=(com.fudanmed.platform.core.domain.RCRepairTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(repairTask, entities);
    
    UIRepairTask _transform = this.mapper.transform( _resolved);
    return _transform;
  }
}
