package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.ChangeEmployeeDepartmentPresenterService;
import com.fudanmed.platform.core.web.server.service.organization.OrganizationMapper;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.google.common.base.Objects;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.organization.ChangeEmployeeDepartmentPresenterService")
@Transactional
public class ChangeEmployeeDepartmentPresenterServiceImpl extends BaseService implements ChangeEmployeeDepartmentPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private OrganizationMapper organizationMapper;
  
  public void changeOrganization(final RCEmployeeProxy employee, final RCOrganizationProxy newOrg) throws SessionTimeOutException, ValidationException {
    boolean _notEquals = (!Objects.equal(newOrg, null));
    if (_notEquals) {
      RCEmployee _resolved= null;
      if(employee!=null) _resolved=(com.fudanmed.platform.core.domain.RCEmployee)com.uniquesoft.uidl.extensions.ModelObjects.resolve(employee, entities);
      
      RCEmployee e =  _resolved;
      RCOrganization _resolved_1= null;
      if(newOrg!=null) _resolved_1=(com.fudanmed.platform.core.domain.RCOrganization)com.uniquesoft.uidl.extensions.ModelObjects.resolve(newOrg, entities);
      
      e.setOrganization( _resolved_1);
      e.updateOrgPath();
    }
  }
  
  public UIOrganization getOrganization4Employee(final RCEmployeeProxy employee) throws SessionTimeOutException, ValidationException {
    RCEmployee _resolved= null;
    if(employee!=null) _resolved=(com.fudanmed.platform.core.domain.RCEmployee)com.uniquesoft.uidl.extensions.ModelObjects.resolve(employee, entities);
    
    RCOrganization _organization =  _resolved.getOrganization();
    UIOrganization _transform = this.organizationMapper.transform(_organization);
    return _transform;
  }
}
