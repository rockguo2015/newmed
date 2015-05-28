package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategory;
import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckType;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy;
import com.fudanmed.platform.core.web.client.deliver.DeleteDeliverPatientCheckTypeCommandService;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.deliver.DeleteDeliverPatientCheckTypeCommandService")
@Transactional
public class DeleteDeliverPatientCheckTypeCommandServiceImpl extends BaseService implements DeleteDeliverPatientCheckTypeCommandService {
  @Autowired
  private IObjectFactory entities;
  
  public void delete(final DLDeliverPatientCheckTypeProxy value) throws SessionTimeOutException, ValidationException {
    DLDeliverPatientCheckType _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.deliver.DLDeliverPatientCheckType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    final DLDeliverPatientCheckType delTarget =  _resolved;
    DLDeliverPatientCheckCategory _category = delTarget.getCategory();
    _category.deleteCheckType(delTarget);
  }
}
