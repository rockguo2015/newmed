package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategory;
import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategoryDAO;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy;
import com.fudanmed.platform.core.web.client.deliver.DeleteDeliverPatientCheckCategoryCommandService;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.deliver.DeleteDeliverPatientCheckCategoryCommandService")
@Transactional
public class DeleteDeliverPatientCheckCategoryCommandServiceImpl extends BaseService implements DeleteDeliverPatientCheckCategoryCommandService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DLDeliverPatientCheckCategoryDAO dao;
  
  public void delete(final DLDeliverPatientCheckCategoryProxy value) throws SessionTimeOutException, ValidationException {
    DLDeliverPatientCheckCategory _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategory)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    this.dao.delete( _resolved);
  }
}
