package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverOrganization;
import com.fudanmed.platform.core.deliver.DLDeliverOrganizationDAO;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverOrganizationProxy;
import com.fudanmed.platform.core.web.client.deliver.DeleteDeliverOrganizationCommandService;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.deliver.DeleteDeliverOrganizationCommandService")
@Transactional
public class DeleteDeliverOrganizationCommandServiceImpl extends BaseService implements DeleteDeliverOrganizationCommandService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DLDeliverOrganizationDAO dao;
  
  public void delete(final DLDeliverOrganizationProxy value) throws SessionTimeOutException, ValidationException {
    DLDeliverOrganization _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.deliver.DLDeliverOrganization)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    this.dao.delete( _resolved);
  }
}
