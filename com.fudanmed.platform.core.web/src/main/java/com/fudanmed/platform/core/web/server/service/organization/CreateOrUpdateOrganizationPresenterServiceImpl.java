package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCOrganizationDAO;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.CreateOrUpdateOrganizationPresenterService;
import com.fudanmed.platform.core.web.server.service.organization.OrganizationMapper;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.organization.CreateOrUpdateOrganizationPresenterService")
@Transactional
public class CreateOrUpdateOrganizationPresenterServiceImpl extends BaseService implements CreateOrUpdateOrganizationPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private OrganizationMapper mapper;
  
  @Autowired
  private RCOrganizationDAO organizationDAO;
  
  public UIOrganization loadValue(final RCOrganizationProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCOrganization _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.domain.RCOrganization)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIOrganization _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIOrganization uivalue) throws SessionTimeOutException, ValidationException {
    RCOrganization _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.domain.RCOrganization)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public RCOrganizationProxy createValue(final UIOrganization uivalue) throws SessionTimeOutException, ValidationException {
    final Function1<RCOrganization,RCOrganization> _function = new Function1<RCOrganization,RCOrganization>() {
        public RCOrganization apply(final RCOrganization it) {
          RCOrganization _transform = CreateOrUpdateOrganizationPresenterServiceImpl.this.mapper.transform(uivalue, it);
          return _transform;
        }
      };
    RCOrganization _createOrganization = this.organizationDAO.createOrganization(null, _function);
    RCOrganizationProxy _proxy = _createOrganization.toProxy();
    return _proxy;
  }
}
