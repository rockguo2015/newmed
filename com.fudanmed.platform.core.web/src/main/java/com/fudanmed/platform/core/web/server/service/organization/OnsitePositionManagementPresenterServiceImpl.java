package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCOnsitePosition;
import com.fudanmed.platform.core.domain.RCOrganizationService;
import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.client.organization.OnsitePositionManagementPresenterService;
import com.fudanmed.platform.core.web.server.service.organization.OnsitePositionMapper;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.organization.OnsitePositionManagementPresenterService")
@Transactional
public class OnsitePositionManagementPresenterServiceImpl extends BaseService implements OnsitePositionManagementPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private OnsitePositionMapper mapper;
  
  @Autowired
  private RCOrganizationService OnsitePositionService;
  
  public void delete(final RCOnsitePositionProxy value) throws SessionTimeOutException, ValidationException {
    RCOnsitePosition _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.domain.RCOnsitePosition)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    this.entities.delete( _resolved);
  }
}
