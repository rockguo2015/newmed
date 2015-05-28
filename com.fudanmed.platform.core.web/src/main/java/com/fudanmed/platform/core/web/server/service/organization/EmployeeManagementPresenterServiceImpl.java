package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeCriteria;
import com.fudanmed.platform.core.domain.RCEmployeeDAO;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCOrganizationService;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.client.organization.EmployeeManagementPresenterService;
import com.fudanmed.platform.core.web.server.service.organization.EmployeeCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.organization.EmployeeMapper;
import com.fudanmed.platform.core.web.server.service.organization.OrganizationMapper;
import com.fudanmed.platform.core.web.shared.organization.UIEmployee;
import com.fudanmed.platform.core.web.shared.organization.UIEmployeeCriteria;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.google.common.base.Function;
import com.uniquesoft.gwt.server.common.pager.PagedQueries;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.langlab.domain.security.proxy.UserProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.organization.EmployeeManagementPresenterService")
@Transactional
public class EmployeeManagementPresenterServiceImpl extends BaseService implements EmployeeManagementPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private EmployeeCriteriaMapper criteriaMapper;
  
  @Autowired
  private EmployeeMapper mapper;
  
  @Autowired
  private OrganizationMapper organizationMapper;
  
  @Autowired
  private RCOrganizationService organizationService;
  
  @Autowired
  private RCEmployeeDAO dao;
  
  public IPagedResult<UIEmployee> filter(final UIEmployeeCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UIEmployee> _xblockexpression = null;
    {
      RCEmployeeCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCEmployeeCriteria.class, this.criteriaMapper, this.entities);
      final Function1<RCEmployee,UIEmployee> _function = new Function1<RCEmployee,UIEmployee>() {
          public UIEmployee apply(final RCEmployee it) {
            UIEmployee _apply = EmployeeManagementPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      IPagedResult<UIEmployee> _listAndTransform = PagedQueries.<UIEmployee, RCEmployee>listAndTransform(c, new Function<RCEmployee,UIEmployee>() {
          public UIEmployee apply(RCEmployee input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
  
  public void delete(final RCEmployeeProxy value) throws SessionTimeOutException, ValidationException {
    RCEmployee _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.domain.RCEmployee)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    this.dao.delete( _resolved);
  }
  
  public Collection<UIOrganization> getAllOrganization() throws SessionTimeOutException, ValidationException {
    Collection<RCOrganization> _aLlOrganization = this.organizationService.getALlOrganization();
    final Function1<RCOrganization,UIOrganization> _function = new Function1<RCOrganization,UIOrganization>() {
        public UIOrganization apply(final RCOrganization it) {
          UIOrganization _transform = EmployeeManagementPresenterServiceImpl.this.organizationMapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIOrganization> _map = IterableExtensions.<RCOrganization, UIOrganization>map(_aLlOrganization, _function);
    Collection<UIOrganization> _unlazy = IterableExtensions2.<UIOrganization>unlazy(_map);
    return _unlazy;
  }
  
  public UserProxy asUser(final RCEmployeeProxy employee) throws SessionTimeOutException, ValidationException {
    RCEmployee _resolved= null;
    if(employee!=null) _resolved=(com.fudanmed.platform.core.domain.RCEmployee)com.uniquesoft.uidl.extensions.ModelObjects.resolve(employee, entities);
    
    User _asUser =  _resolved.asUser();
    UserProxy _proxy = _asUser.toProxy();
    return _proxy;
  }
  
  public void leaveJob(final RCEmployeeProxy value) throws SessionTimeOutException, ValidationException {
    RCEmployee _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.domain.RCEmployee)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
     _resolved.leaveJob();
  }
  
  public void resumeJob(final RCEmployeeProxy value) throws SessionTimeOutException, ValidationException {
    RCEmployee _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.domain.RCEmployee)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
     _resolved.returnJob();
  }
}
