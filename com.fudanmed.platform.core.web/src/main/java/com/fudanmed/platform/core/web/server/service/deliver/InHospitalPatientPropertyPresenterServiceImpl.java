package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLInHospitalPatient;
import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import com.fudanmed.platform.core.web.client.deliver.InHospitalPatientPropertyPresenterService;
import com.fudanmed.platform.core.web.server.service.deliver.InHospitalPatientMapper;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalPatient;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.deliver.InHospitalPatientPropertyPresenterService")
@Transactional
public class InHospitalPatientPropertyPresenterServiceImpl extends BaseService implements InHospitalPatientPropertyPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private InHospitalPatientMapper mapper;
  
  public UIInHospitalPatient loadValue(final DLInHospitalPatientProxy value) throws SessionTimeOutException, ValidationException {
    DLInHospitalPatient _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.deliver.DLInHospitalPatient)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    UIInHospitalPatient _transform = this.mapper.transform( _resolved);
    return _transform;
  }
}
