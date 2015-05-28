package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLInHospitalPatient;
import com.fudanmed.platform.core.deliver.DLInHospitalPatientDAO;
import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import com.fudanmed.platform.core.web.client.deliver.DeleteInHospitalPatientCommandService;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.deliver.DeleteInHospitalPatientCommandService")
@Transactional
public class DeleteInHospitalPatientCommandServiceImpl extends BaseService implements DeleteInHospitalPatientCommandService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DLInHospitalPatientDAO dao;
  
  public void delete(final DLInHospitalPatientProxy value) throws SessionTimeOutException, ValidationException {
    DLInHospitalPatient _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.deliver.DLInHospitalPatient)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    this.dao.delete( _resolved);
  }
}
