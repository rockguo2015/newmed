package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLCheckOrganization;
import com.fudanmed.platform.core.deliver.DLCheckOrganizationDAO;
import com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy;
import com.fudanmed.platform.core.web.client.deliver.DeleteCheckOrganizationCommandService;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.deliver.DeleteCheckOrganizationCommandService")
@Transactional
public class DeleteCheckOrganizationCommandServiceImpl extends BaseService implements DeleteCheckOrganizationCommandService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DLCheckOrganizationDAO dao;
  
  public void delete(final DLCheckOrganizationProxy value) throws SessionTimeOutException, ValidationException {
    DLCheckOrganization _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.deliver.DLCheckOrganization)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    this.dao.delete( _resolved);
  }
}
