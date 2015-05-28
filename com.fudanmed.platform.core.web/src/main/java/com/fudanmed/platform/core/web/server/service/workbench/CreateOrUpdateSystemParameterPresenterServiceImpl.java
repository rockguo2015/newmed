package com.fudanmed.platform.core.web.server.service.workbench;

import com.fudanmed.platform.core.common.RCSystemParameter;
import com.fudanmed.platform.core.common.RCSystemParameterService;
import com.fudanmed.platform.core.web.client.workbench.CreateOrUpdateSystemParameterPresenterService;
import com.fudanmed.platform.core.web.server.service.workbench.SystemParameterMapper;
import com.fudanmed.platform.core.web.shared.workbench.UISystemParameter;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.workbench.CreateOrUpdateSystemParameterPresenterService")
@Transactional
public class CreateOrUpdateSystemParameterPresenterServiceImpl extends BaseService implements CreateOrUpdateSystemParameterPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCSystemParameterService parameterService;
  
  @Autowired
  private SystemParameterMapper mapper;
  
  public UISystemParameter loadValue() throws SessionTimeOutException, ValidationException {
    RCSystemParameter _systemParameter = this.parameterService.getSystemParameter();
    UISystemParameter _transform = this.mapper.transform(_systemParameter);
    return _transform;
  }
  
  public void updateValue(final UISystemParameter uivalue) throws SessionTimeOutException, ValidationException {
    RCSystemParameter _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.common.RCSystemParameter)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
}
