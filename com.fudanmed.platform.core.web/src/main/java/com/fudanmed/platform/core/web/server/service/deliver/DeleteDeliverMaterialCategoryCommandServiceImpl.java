package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverMaterialCategory;
import com.fudanmed.platform.core.deliver.DLDeliverMaterialCategoryDAO;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy;
import com.fudanmed.platform.core.web.client.deliver.DeleteDeliverMaterialCategoryCommandService;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.deliver.DeleteDeliverMaterialCategoryCommandService")
@Transactional
public class DeleteDeliverMaterialCategoryCommandServiceImpl extends BaseService implements DeleteDeliverMaterialCategoryCommandService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DLDeliverMaterialCategoryDAO dao;
  
  public void delete(final DLDeliverMaterialCategoryProxy value) throws SessionTimeOutException, ValidationException {
    DLDeliverMaterialCategory _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.deliver.DLDeliverMaterialCategory)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    this.dao.delete( _resolved);
  }
}
