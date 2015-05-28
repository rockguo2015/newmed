package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCRepairEvaluate;
import com.fudanmed.platform.core.domain.proxy.RCRepairEvaluateProxy;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateRepairEvaluatePresenterService;
import com.fudanmed.platform.core.web.server.service.project.RepairEvaluateMapper;
import com.fudanmed.platform.core.web.shared.project.UIRepairEvaluate;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.CreateOrUpdateRepairEvaluatePresenterService")
@Transactional
public class CreateOrUpdateRepairEvaluatePresenterServiceImpl extends BaseService implements CreateOrUpdateRepairEvaluatePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RepairEvaluateMapper mapper;
  
  public UIRepairEvaluate loadValue(final RCRepairEvaluateProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCRepairEvaluate _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.domain.RCRepairEvaluate)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIRepairEvaluate _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIRepairEvaluate uivalue) throws SessionTimeOutException, ValidationException {
    RCRepairEvaluate _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.domain.RCRepairEvaluate)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    final RCRepairEvaluate evaluate =  _resolved;
    this.mapper.transform(uivalue, evaluate);
    evaluate.commit();
  }
}
