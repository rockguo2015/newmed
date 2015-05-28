package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLCheckOrganization;
import com.fudanmed.platform.core.deliver.DLCheckOrganizationDAO;
import com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateCheckOrganizationPresenterService;
import com.fudanmed.platform.core.web.server.service.deliver.CheckOrganizationMapper;
import com.fudanmed.platform.core.web.shared.deliver.UICheckOrganization;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateCheckOrganizationPresenterService")
@Transactional
public class CreateOrUpdateCheckOrganizationPresenterServiceImpl extends BaseService implements CreateOrUpdateCheckOrganizationPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private CheckOrganizationMapper mapper;
  
  @Autowired
  private DLCheckOrganizationDAO dao;
  
  public UICheckOrganization loadValue(final DLCheckOrganizationProxy pvalue) throws SessionTimeOutException, ValidationException {
    DLCheckOrganization _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.deliver.DLCheckOrganization)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UICheckOrganization _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UICheckOrganization uivalue) throws SessionTimeOutException, ValidationException {
    DLCheckOrganization _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.deliver.DLCheckOrganization)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public void createValue(final UICheckOrganization uivalue) throws SessionTimeOutException, ValidationException {
    final Procedure1<DLCheckOrganization> _function = new Procedure1<DLCheckOrganization>() {
        public void apply(final DLCheckOrganization it) {
          CreateOrUpdateCheckOrganizationPresenterServiceImpl.this.mapper.transform(uivalue, it);
        }
      };
    this.dao.create(_function);
  }
}
