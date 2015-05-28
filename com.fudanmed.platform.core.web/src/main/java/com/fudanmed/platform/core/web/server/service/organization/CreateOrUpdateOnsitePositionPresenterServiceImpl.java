package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCOnsitePosition;
import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.client.organization.CreateOrUpdateOnsitePositionPresenterService;
import com.fudanmed.platform.core.web.server.service.organization.OnsitePositionMapper;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.organization.CreateOrUpdateOnsitePositionPresenterService")
@Transactional
public class CreateOrUpdateOnsitePositionPresenterServiceImpl extends BaseService implements CreateOrUpdateOnsitePositionPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private OnsitePositionMapper mapper;
  
  public UIOnsitePosition loadValue(final RCOnsitePositionProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCOnsitePosition _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.domain.RCOnsitePosition)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIOnsitePosition _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIOnsitePosition uivalue) throws SessionTimeOutException, ValidationException {
    RCOnsitePosition _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.domain.RCOnsitePosition)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public RCOnsitePositionProxy createValue(final UIOnsitePosition uivalue) throws SessionTimeOutException, ValidationException {
    RCOnsitePositionProxy _xblockexpression = null;
    {
      RCOnsitePosition value = this.entities.<RCOnsitePosition>create(RCOnsitePosition.class);
      this.mapper.transform(uivalue, value);
      RCOnsitePositionProxy _proxy = value.toProxy();
      _xblockexpression = (_proxy);
    }
    return _xblockexpression;
  }
}
