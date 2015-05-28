package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.common.RCFaultLevelColorAdaptor;
import com.fudanmed.platform.core.common.proxy.RCFaultLevelColorAdaptorProxy;
import com.fudanmed.platform.core.web.client.organization.CreateOrUpdateFaultLevelColorAdaptorPresenterService;
import com.fudanmed.platform.core.web.server.service.organization.FaultLevelColorAdaptorMapper;
import com.fudanmed.platform.core.web.shared.organization.UIFaultLevelColorAdaptor;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.organization.CreateOrUpdateFaultLevelColorAdaptorPresenterService")
@Transactional
public class CreateOrUpdateFaultLevelColorAdaptorPresenterServiceImpl extends BaseService implements CreateOrUpdateFaultLevelColorAdaptorPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private FaultLevelColorAdaptorMapper mapper;
  
  public UIFaultLevelColorAdaptor loadValue(final RCFaultLevelColorAdaptorProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCFaultLevelColorAdaptor _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.common.RCFaultLevelColorAdaptor)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIFaultLevelColorAdaptor _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIFaultLevelColorAdaptor uivalue) throws SessionTimeOutException, ValidationException {
    RCFaultLevelColorAdaptor _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.common.RCFaultLevelColorAdaptor)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
}
