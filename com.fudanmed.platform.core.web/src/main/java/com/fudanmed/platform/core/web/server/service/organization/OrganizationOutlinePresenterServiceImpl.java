package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCOrganizationService;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.OrganizationOutlinePresenterService;
import com.fudanmed.platform.core.web.server.service.organization.OrganizationMapper;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.organization.OrganizationOutlinePresenterService")
@Transactional
public class OrganizationOutlinePresenterServiceImpl extends BaseService implements OrganizationOutlinePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private OrganizationMapper mapper;
  
  @Autowired
  private RCOrganizationService organizationService;
  
  public Collection<UIOrganization> loadAllOrganization() throws SessionTimeOutException, ValidationException {
    Collection<RCOrganization> _aLlOrganization = this.organizationService.getALlOrganization();
    final Function1<RCOrganization,UIOrganization> _function = new Function1<RCOrganization,UIOrganization>() {
        public UIOrganization apply(final RCOrganization it) {
          UIOrganization _transform = OrganizationOutlinePresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIOrganization> _map = IterableExtensions.<RCOrganization, UIOrganization>map(_aLlOrganization, _function);
    Collection<UIOrganization> _unlazy = IterableExtensions2.<UIOrganization>unlazy(_map);
    return _unlazy;
  }
  
  public UIOrganization getValue(final RCOrganizationProxy org) throws SessionTimeOutException, ValidationException {
    RCOrganization _resolved= null;
    if(org!=null) _resolved=(com.fudanmed.platform.core.domain.RCOrganization)com.uniquesoft.uidl.extensions.ModelObjects.resolve(org, entities);
    
    UIOrganization _transform = this.mapper.transform( _resolved);
    return _transform;
  }
}
