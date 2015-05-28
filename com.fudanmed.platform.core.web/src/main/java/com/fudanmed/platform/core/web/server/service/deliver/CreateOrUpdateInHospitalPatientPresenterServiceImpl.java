package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLInHospitalPatient;
import com.fudanmed.platform.core.deliver.DLInHospitalPatientDAO;
import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateInHospitalPatientPresenterService;
import com.fudanmed.platform.core.web.server.service.deliver.InHospitalPatientMapper;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalPatient;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateInHospitalPatientPresenterService")
@Transactional
public class CreateOrUpdateInHospitalPatientPresenterServiceImpl extends BaseService implements CreateOrUpdateInHospitalPatientPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private InHospitalPatientMapper mapper;
  
  @Autowired
  private DLInHospitalPatientDAO dao;
  
  public UIInHospitalPatient loadValue(final DLInHospitalPatientProxy pvalue) throws SessionTimeOutException, ValidationException {
    DLInHospitalPatient _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.deliver.DLInHospitalPatient)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIInHospitalPatient _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIInHospitalPatient uivalue) throws SessionTimeOutException, ValidationException {
    DLInHospitalPatient _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.deliver.DLInHospitalPatient)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public DLInHospitalPatientProxy createValue(final UIInHospitalPatient uivalue) throws SessionTimeOutException, ValidationException {
    final Procedure1<DLInHospitalPatient> _function = new Procedure1<DLInHospitalPatient>() {
        public void apply(final DLInHospitalPatient it) {
          CreateOrUpdateInHospitalPatientPresenterServiceImpl.this.mapper.transform(uivalue, it);
        }
      };
    DLInHospitalPatient _create = this.dao.create(_function);
    DLInHospitalPatientProxy _proxy = _create.toProxy();
    return _proxy;
  }
}
