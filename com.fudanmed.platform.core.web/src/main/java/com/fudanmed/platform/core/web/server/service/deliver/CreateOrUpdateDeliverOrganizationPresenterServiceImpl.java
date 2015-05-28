package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverOrganization;
import com.fudanmed.platform.core.deliver.DLDeliverOrganizationDAO;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverOrganizationProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverOrganizationPresenterService;
import com.fudanmed.platform.core.web.server.service.deliver.DeliverOrganizationMapper;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverOrganization;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverOrganizationPresenterService")
@Transactional
public class CreateOrUpdateDeliverOrganizationPresenterServiceImpl extends BaseService implements CreateOrUpdateDeliverOrganizationPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DeliverOrganizationMapper mapper;
  
  @Autowired
  private DLDeliverOrganizationDAO dao;
  
  public UIDeliverOrganization loadValue(final DLDeliverOrganizationProxy pvalue) throws SessionTimeOutException, ValidationException {
    DLDeliverOrganization _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.deliver.DLDeliverOrganization)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIDeliverOrganization _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIDeliverOrganization uivalue) throws SessionTimeOutException, ValidationException {
    DLDeliverOrganization _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.deliver.DLDeliverOrganization)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public void createValue(final UIDeliverOrganization uivalue) throws SessionTimeOutException, ValidationException {
    final Procedure1<DLDeliverOrganization> _function = new Procedure1<DLDeliverOrganization>() {
        public void apply(final DLDeliverOrganization it) {
          CreateOrUpdateDeliverOrganizationPresenterServiceImpl.this.mapper.transform(uivalue, it);
        }
      };
    this.dao.create(_function);
  }
}
