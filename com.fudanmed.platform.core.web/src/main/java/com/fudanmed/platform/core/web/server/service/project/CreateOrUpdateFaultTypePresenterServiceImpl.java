package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCFaultType;
import com.fudanmed.platform.core.domain.RCMaintenamceType;
import com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateFaultTypePresenterService;
import com.fudanmed.platform.core.web.server.service.project.FaultTypeMapper;
import com.fudanmed.platform.core.web.shared.project.UIFaultType;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.CreateOrUpdateFaultTypePresenterService")
@Transactional
public class CreateOrUpdateFaultTypePresenterServiceImpl extends BaseService implements CreateOrUpdateFaultTypePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private FaultTypeMapper mapper;
  
  public UIFaultType loadValue(final RCFaultTypeProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCFaultType _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.domain.RCFaultType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIFaultType _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIFaultType uivalue) throws SessionTimeOutException, ValidationException {
    RCFaultType _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.domain.RCFaultType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public void createValue(final RCMaintenamceTypeProxy parent, final UIFaultType uivalue) throws SessionTimeOutException, ValidationException {
    RCMaintenamceType _resolved= null;
    if(parent!=null) _resolved=(com.fudanmed.platform.core.domain.RCMaintenamceType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(parent, entities);
    
    RCFaultType value =  _resolved.createAndAddtoFaultTypes();
    this.mapper.transform(uivalue, value);
  }
}
