package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCOrganizationService;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.OrganizationManagementPresenterService;
import com.fudanmed.platform.core.web.server.service.organization.OrganizationMapper;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.organization.OrganizationManagementPresenterService")
@Transactional
public class OrganizationManagementPresenterServiceImpl extends BaseService implements OrganizationManagementPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private OrganizationMapper mapper;
  
  @Autowired
  private RCOrganizationService organizationService;
  
  public void delete(final RCOrganizationProxy value) throws SessionTimeOutException, ValidationException {
    RCOrganization _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.domain.RCOrganization)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    this.entities.delete( _resolved);
  }
}
