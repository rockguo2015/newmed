package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTask;
import com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTaskDAO;
import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy;
import com.fudanmed.platform.core.web.client.deliver.DeliverTaskDeleteCommandService;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.deliver.DeliverTaskDeleteCommandService")
@Transactional
public class DeliverTaskDeleteCommandServiceImpl extends BaseService implements DeliverTaskDeleteCommandService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DLCenterlizedDeliverTaskDAO dao;
  
  public void deleteAll(final Collection<DLCenterlizedDeliverTaskProxy> toDeletes) throws SessionTimeOutException, ValidationException {
    final Procedure1<DLCenterlizedDeliverTaskProxy> _function = new Procedure1<DLCenterlizedDeliverTaskProxy>() {
        public void apply(final DLCenterlizedDeliverTaskProxy it) {
          DLCenterlizedDeliverTask _resolved= null;
          if(it!=null) _resolved=(com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(it, entities);
          
          DeliverTaskDeleteCommandServiceImpl.this.dao.delete( _resolved);
        }
      };
    IterableExtensions.<DLCenterlizedDeliverTaskProxy>forEach(toDeletes, _function);
  }
}
