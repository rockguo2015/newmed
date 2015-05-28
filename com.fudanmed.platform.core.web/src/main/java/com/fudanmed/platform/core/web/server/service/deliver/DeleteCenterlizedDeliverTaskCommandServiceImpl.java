package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTask;
import com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTaskDAO;
import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy;
import com.fudanmed.platform.core.web.client.deliver.DeleteCenterlizedDeliverTaskCommandService;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.deliver.DeleteCenterlizedDeliverTaskCommandService")
@Transactional
public class DeleteCenterlizedDeliverTaskCommandServiceImpl extends BaseService implements DeleteCenterlizedDeliverTaskCommandService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DLCenterlizedDeliverTaskDAO dao;
  
  public void delete(final DLCenterlizedDeliverTaskProxy value) throws SessionTimeOutException, ValidationException {
    DLCenterlizedDeliverTask _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    this.dao.delete( _resolved);
  }
}
