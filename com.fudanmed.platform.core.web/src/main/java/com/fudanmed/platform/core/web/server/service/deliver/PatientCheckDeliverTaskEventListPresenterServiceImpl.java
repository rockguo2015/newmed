package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTask;
import com.fudanmed.platform.core.deliver.DLPatientCheckDeliverTaskEvent;
import com.fudanmed.platform.core.deliver.DLTaskEvent;
import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy;
import com.fudanmed.platform.core.web.client.deliver.PatientCheckDeliverTaskEventListPresenterService;
import com.fudanmed.platform.core.web.server.service.deliver.PatientCheckDeliverTaskEventMapper;
import com.fudanmed.platform.core.web.shared.deliver.UIPatientCheckDeliverTaskEvent;
import com.google.common.collect.Iterables;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.deliver.PatientCheckDeliverTaskEventListPresenterService")
@Transactional
public class PatientCheckDeliverTaskEventListPresenterServiceImpl extends BaseService implements PatientCheckDeliverTaskEventListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private PatientCheckDeliverTaskEventMapper mapper;
  
  public Collection<UIPatientCheckDeliverTaskEvent> loadPatientCheckDeliverTaskEventList(final DLCenterlizedDeliverTaskProxy context) throws SessionTimeOutException, ValidationException {
    DLCenterlizedDeliverTask _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    Collection<DLTaskEvent> _events =  _resolved.getEvents();
    Iterable<DLPatientCheckDeliverTaskEvent> _filter = Iterables.<DLPatientCheckDeliverTaskEvent>filter(_events, DLPatientCheckDeliverTaskEvent.class);
    final Function1<DLPatientCheckDeliverTaskEvent,UIPatientCheckDeliverTaskEvent> _function = new Function1<DLPatientCheckDeliverTaskEvent,UIPatientCheckDeliverTaskEvent>() {
        public UIPatientCheckDeliverTaskEvent apply(final DLPatientCheckDeliverTaskEvent it) {
          UIPatientCheckDeliverTaskEvent _transform = PatientCheckDeliverTaskEventListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIPatientCheckDeliverTaskEvent> _map = IterableExtensions.<DLPatientCheckDeliverTaskEvent, UIPatientCheckDeliverTaskEvent>map(_filter, _function);
    Collection<UIPatientCheckDeliverTaskEvent> _unlazy = IterableExtensions2.<UIPatientCheckDeliverTaskEvent>unlazy(_map);
    return _unlazy;
  }
}
