package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTask;
import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy;
import com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTaskDispatchCommandService;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTaskDispatchCommandService")
@Transactional
public class CenterlizedDeliverTaskDispatchCommandServiceImpl extends BaseService implements CenterlizedDeliverTaskDispatchCommandService {
  @Autowired
  private IObjectFactory entities;
  
  public void accept(final DLCenterlizedDeliverTaskProxy value) throws SessionTimeOutException, ValidationException {
    DLCenterlizedDeliverTask _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
     _resolved.dispatch(null);
  }
}
