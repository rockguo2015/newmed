package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeDAO;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.CreateOrUpdateEmployeePresenterService;
import com.fudanmed.platform.core.web.server.service.organization.EmployeeMapper;
import com.fudanmed.platform.core.web.shared.organization.UIEmployee;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.organization.CreateOrUpdateEmployeePresenterService")
@Transactional
public class CreateOrUpdateEmployeePresenterServiceImpl extends BaseService implements CreateOrUpdateEmployeePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private EmployeeMapper mapper;
  
  @Autowired
  private RCEmployeeDAO employeeDAO;
  
  public UIEmployee loadValue(final RCEmployeeProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCEmployee _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.domain.RCEmployee)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIEmployee _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIEmployee uivalue) throws SessionTimeOutException, ValidationException {
    RCEmployee _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.domain.RCEmployee)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public void createValue(final RCOrganizationProxy org, final UIEmployee uivalue) throws SessionTimeOutException, ValidationException {
    String _eid = uivalue.getEid();
    final Procedure1<RCEmployee> _function = new Procedure1<RCEmployee>() {
        public void apply(final RCEmployee it) {
          RCOrganization _resolved= null;
          if(org!=null) _resolved=(com.fudanmed.platform.core.domain.RCOrganization)com.uniquesoft.uidl.extensions.ModelObjects.resolve(org, entities);
          
          it.setOrganization( _resolved);
          CreateOrUpdateEmployeePresenterServiceImpl.this.mapper.transform(uivalue, it);
        }
      };
    this.employeeDAO.create(_eid, _function);
  }
}
