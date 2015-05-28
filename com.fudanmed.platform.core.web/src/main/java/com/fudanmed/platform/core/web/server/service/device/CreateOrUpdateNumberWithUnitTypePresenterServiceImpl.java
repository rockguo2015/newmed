package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.entityextension.RCNumberWithUnitType;
import com.fudanmed.platform.core.entityextension.proxy.RCNumberWithUnitTypeProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdateNumberWithUnitTypePresenterService;
import com.fudanmed.platform.core.web.server.service.device.NumberWithUnitTypeMapper;
import com.fudanmed.platform.core.web.shared.device.UINumberWithUnitType;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.CreateOrUpdateNumberWithUnitTypePresenterService")
@Transactional
public class CreateOrUpdateNumberWithUnitTypePresenterServiceImpl extends BaseService implements CreateOrUpdateNumberWithUnitTypePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private NumberWithUnitTypeMapper mapper;
  
  public UINumberWithUnitType loadValue(final RCNumberWithUnitTypeProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCNumberWithUnitType _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.entityextension.RCNumberWithUnitType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UINumberWithUnitType _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UINumberWithUnitType uivalue) throws SessionTimeOutException, ValidationException {
    RCNumberWithUnitType _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.entityextension.RCNumberWithUnitType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public void createValue(final UINumberWithUnitType uivalue) throws SessionTimeOutException, ValidationException {
    RCNumberWithUnitType value = this.entities.<RCNumberWithUnitType>create(RCNumberWithUnitType.class);
    this.mapper.transform(uivalue, value);
  }
}
