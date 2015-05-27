package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLInHospitalPatient;
import com.fudanmed.platform.core.deliver.DLInHospitalPatientDAO;
import com.fudanmed.platform.core.deliver.events.DLInHospitalPatientEventsManager;
import com.fudanmed.platform.core.deliver.impl.DLInHospitalPatientImpl;
import edu.fudan.mylang.pf.BaseDAOService;
import edu.fudan.mylang.pf.IGenericQuery;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.DLInHospitalPatientDAO")
public class DLInHospitalPatientDAOImpl extends BaseDAOService<DLInHospitalPatient> implements DLInHospitalPatientDAO {
  @Autowired
  private DLInHospitalPatientEventsManager eventsManager;
  
  public DLInHospitalPatient create(final Procedure1<? super DLInHospitalPatient> init) {DLInHospitalPatient dLInHospitalPatient=DLInHospitalPatientImpl.create(getObjectFactory());
    final Procedure1<DLInHospitalPatient> _function = new Procedure1<DLInHospitalPatient>() {
        public void apply(final DLInHospitalPatient it) {
          init.apply(it);
          DLInHospitalPatientDAOImpl.this.eventsManager.fireCreated(it);
        }
      };
    DLInHospitalPatient _doubleArrow = ObjectExtensions.<DLInHospitalPatient>operator_doubleArrow(dLInHospitalPatient, _function);
    return _doubleArrow;
  }
  
  public void delete(final DLInHospitalPatient value) {getObjectFactory().delete(value);
    
    this.eventsManager.fireDeleted(value);
  }
  
  public DLInHospitalPatient findByCode(final String sid) {
    IGenericQuery<DLInHospitalPatient> query=getObjectFactory().createGenericQuery(DLInHospitalPatient.class,"select e from com.fudanmed.platform.core.deliver.impl.DLInHospitalPatientImpl as e   where (e.sid = :sid) and  e.active = 1      ").setParameter("sid",sid);
    DLInHospitalPatient _uniqueResult = query.uniqueResult();
    return _uniqueResult;
  }
}
