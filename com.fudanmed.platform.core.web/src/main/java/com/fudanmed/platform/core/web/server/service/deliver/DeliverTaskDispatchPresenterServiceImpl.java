package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTask;
import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.client.deliver.DeliverTaskDispatchPresenterService;
import com.fudanmed.platform.core.web.server.service.deliver.CenterlizedDeliverTaskMapper;
import com.fudanmed.platform.core.web.server.service.deliver.DeliverTaskDispatchDataValidator;
import com.fudanmed.platform.core.web.shared.deliver.DeliverTaskDispatchData;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.deliver.DeliverTaskDispatchPresenterService")
@Transactional
public class DeliverTaskDispatchPresenterServiceImpl extends BaseService implements DeliverTaskDispatchPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DeliverTaskDispatchDataValidator validator;
  
  @Autowired
  private CenterlizedDeliverTaskMapper mapper;
  
  public void commit(final Collection<DLCenterlizedDeliverTaskProxy> context, final DeliverTaskDispatchData data) throws SessionTimeOutException, ValidationException {
    Validates.<DeliverTaskDispatchData>validateWith(data, this.validator);
    final Procedure1<DLCenterlizedDeliverTaskProxy> _function = new Procedure1<DLCenterlizedDeliverTaskProxy>() {
        public void apply(final DLCenterlizedDeliverTaskProxy it) {
          DLCenterlizedDeliverTask _resolved= null;
          if(it!=null) _resolved=(com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(it, entities);
          
          Collection<RCEmployeeProxy> _haulier = data.getHaulier();
          final Function1<RCEmployeeProxy,RCEmployee> _function = new Function1<RCEmployeeProxy,RCEmployee>() {
              public RCEmployee apply(final RCEmployeeProxy it) {
                RCEmployee _resolved= null;
                if(it!=null) _resolved=(com.fudanmed.platform.core.domain.RCEmployee)com.uniquesoft.uidl.extensions.ModelObjects.resolve(it, entities);
                
                return  _resolved;
              }
            };
          Iterable<RCEmployee> _map = IterableExtensions.<RCEmployeeProxy, RCEmployee>map(_haulier, _function);
          List<RCEmployee> _list = IterableExtensions.<RCEmployee>toList(_map);
           _resolved.dispatch(_list);
        }
      };
    IterableExtensions.<DLCenterlizedDeliverTaskProxy>forEach(context, _function);
  }
  
  public Collection<UICenterlizedDeliverTask> resolveTasks(final Collection<DLCenterlizedDeliverTaskProxy> tasks) throws SessionTimeOutException, ValidationException {
    final Function1<DLCenterlizedDeliverTaskProxy,UICenterlizedDeliverTask> _function = new Function1<DLCenterlizedDeliverTaskProxy,UICenterlizedDeliverTask>() {
        public UICenterlizedDeliverTask apply(final DLCenterlizedDeliverTaskProxy it) {
          DLCenterlizedDeliverTask _resolved= null;
          if(it!=null) _resolved=(com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(it, entities);
          
          UICenterlizedDeliverTask _transform = DeliverTaskDispatchPresenterServiceImpl.this.mapper.transform( _resolved);
          return _transform;
        }
      };
    Iterable<UICenterlizedDeliverTask> _map = IterableExtensions.<DLCenterlizedDeliverTaskProxy, UICenterlizedDeliverTask>map(tasks, _function);
    List<UICenterlizedDeliverTask> _list = IterableExtensions.<UICenterlizedDeliverTask>toList(_map);
    return _list;
  }
}
