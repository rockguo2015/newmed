package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLInHospitalLocation;
import com.fudanmed.platform.core.deliver.DLInHospitalLocationDAO;
import com.fudanmed.platform.core.deliver.events.DLInHospitalLocationEventsManager;
import com.fudanmed.platform.core.deliver.impl.DLInHospitalLocationImpl;
import edu.fudan.mylang.pf.BaseDAOService;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.DLInHospitalLocationDAO")
public class DLInHospitalLocationDAOImpl extends BaseDAOService<DLInHospitalLocation> implements DLInHospitalLocationDAO {
  @Autowired
  private DLInHospitalLocationEventsManager eventsManager;
  
  public DLInHospitalLocation create(final Procedure1<? super DLInHospitalLocation> init) {DLInHospitalLocation dLInHospitalLocation=DLInHospitalLocationImpl.create(getObjectFactory());
    final Procedure1<DLInHospitalLocation> _function = new Procedure1<DLInHospitalLocation>() {
        public void apply(final DLInHospitalLocation it) {
          init.apply(it);
          it.checkValid();
          DLInHospitalLocationDAOImpl.this.eventsManager.fireCreated(it);
        }
      };
    DLInHospitalLocation _doubleArrow = ObjectExtensions.<DLInHospitalLocation>operator_doubleArrow(dLInHospitalLocation, _function);
    return _doubleArrow;
  }
  
  public void delete(final DLInHospitalLocation value) {getObjectFactory().delete(value);
    
    this.eventsManager.fireDeleted(value);
  }
}
