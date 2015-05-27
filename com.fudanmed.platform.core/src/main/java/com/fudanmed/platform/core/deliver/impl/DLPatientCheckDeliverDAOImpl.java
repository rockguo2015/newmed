package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLPatientCheckDeliver;
import com.fudanmed.platform.core.deliver.DLPatientCheckDeliverDAO;
import com.fudanmed.platform.core.deliver.events.DLPatientCheckDeliverEventsManager;
import com.fudanmed.platform.core.deliver.impl.DLPatientCheckDeliverImpl;
import edu.fudan.mylang.pf.BaseDAOService;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.DLPatientCheckDeliverDAO")
public class DLPatientCheckDeliverDAOImpl extends BaseDAOService<DLPatientCheckDeliver> implements DLPatientCheckDeliverDAO {
  @Autowired
  private DLPatientCheckDeliverEventsManager eventsManager;
  
  public DLPatientCheckDeliver create(final Procedure1<? super DLPatientCheckDeliver> init) {DLPatientCheckDeliver dLPatientCheckDeliver=DLPatientCheckDeliverImpl.create(getObjectFactory());
    final Procedure1<DLPatientCheckDeliver> _function = new Procedure1<DLPatientCheckDeliver>() {
        public void apply(final DLPatientCheckDeliver it) {
          init.apply(it);
          it.checkValid();
          DLPatientCheckDeliverDAOImpl.this.eventsManager.fireCreated(it);
        }
      };
    DLPatientCheckDeliver _doubleArrow = ObjectExtensions.<DLPatientCheckDeliver>operator_doubleArrow(dLPatientCheckDeliver, _function);
    return _doubleArrow;
  }
  
  public void delete(final DLPatientCheckDeliver value) {getObjectFactory().delete(value);
    
    this.eventsManager.fireDeleted(value);
  }
}
