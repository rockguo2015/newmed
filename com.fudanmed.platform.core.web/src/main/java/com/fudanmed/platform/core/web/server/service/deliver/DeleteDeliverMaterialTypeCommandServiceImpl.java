package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverMaterialCategory;
import com.fudanmed.platform.core.deliver.DLDeliverMaterialType;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialTypeProxy;
import com.fudanmed.platform.core.web.client.deliver.DeleteDeliverMaterialTypeCommandService;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.deliver.DeleteDeliverMaterialTypeCommandService")
@Transactional
public class DeleteDeliverMaterialTypeCommandServiceImpl extends BaseService implements DeleteDeliverMaterialTypeCommandService {
  @Autowired
  private IObjectFactory entities;
  
  public void delete(final DLDeliverMaterialTypeProxy value) throws SessionTimeOutException, ValidationException {
    DLDeliverMaterialType _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.deliver.DLDeliverMaterialType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    final DLDeliverMaterialType delTarget =  _resolved;
    DLDeliverMaterialCategory _category = delTarget.getCategory();
    _category.deleteMaterialType(delTarget);
  }
}
