package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTask;
import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverTaskCancelDispatchDataPresenterService;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverTaskCancelDispatchData;
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

@Service("com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverTaskCancelDispatchDataPresenterService")
@Transactional
public class CreateOrUpdateDeliverTaskCancelDispatchDataPresenterServiceImpl extends BaseService implements CreateOrUpdateDeliverTaskCancelDispatchDataPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  public void commit(final Collection<DLCenterlizedDeliverTaskProxy> deliverTasks, final UIDeliverTaskCancelDispatchData uivalue) throws SessionTimeOutException, ValidationException {
    final Procedure1<DLCenterlizedDeliverTaskProxy> _function = new Procedure1<DLCenterlizedDeliverTaskProxy>() {
        public void apply(final DLCenterlizedDeliverTaskProxy deliverTask) {
          DLCenterlizedDeliverTask _resolved= null;
          if(deliverTask!=null) _resolved=(com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(deliverTask, entities);
          
          String _comment = uivalue.getComment();
           _resolved.cancelDispatch(_comment);
        }
      };
    IterableExtensions.<DLCenterlizedDeliverTaskProxy>forEach(deliverTasks, _function);
  }
}
