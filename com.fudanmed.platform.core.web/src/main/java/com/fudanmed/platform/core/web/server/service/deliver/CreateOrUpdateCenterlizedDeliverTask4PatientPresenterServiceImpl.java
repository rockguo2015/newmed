package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTask;
import com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTaskDAO;
import com.fudanmed.platform.core.deliver.DLInHospitalPatient;
import com.fudanmed.platform.core.deliver.DLPatientCheckDeliver;
import com.fudanmed.platform.core.deliver.DLPatientCheckDeliverDAO;
import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy;
import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateCenterlizedDeliverTask4PatientPresenterService;
import com.fudanmed.platform.core.web.server.service.deliver.CenterlizedDeliverTask4PatientMapper;
import com.fudanmed.platform.core.web.server.service.deliver.InHospitalPatientMapper;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask4Patient;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalPatient;
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

@Service("com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateCenterlizedDeliverTask4PatientPresenterService")
@Transactional
public class CreateOrUpdateCenterlizedDeliverTask4PatientPresenterServiceImpl extends BaseService implements CreateOrUpdateCenterlizedDeliverTask4PatientPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private CenterlizedDeliverTask4PatientMapper mapper;
  
  @Autowired
  private DLCenterlizedDeliverTaskDAO dao;
  
  @Autowired
  private DLPatientCheckDeliverDAO patientDao;
  
  @Autowired
  private InHospitalPatientMapper inHospitalPatientMapper;
  
  public UICenterlizedDeliverTask4Patient loadValue(final DLCenterlizedDeliverTaskProxy pvalue) throws SessionTimeOutException, ValidationException {
    return null;
  }
  
  public void updateValue(final UICenterlizedDeliverTask4Patient uivalue) throws SessionTimeOutException, ValidationException {
  }
  
  public void createValue(final UICenterlizedDeliverTask4Patient uivalue, final Collection<UICenterlizedDeliverTask4Patient> patients) throws SessionTimeOutException, ValidationException {
    final Procedure1<UICenterlizedDeliverTask4Patient> _function = new Procedure1<UICenterlizedDeliverTask4Patient>() {
        public void apply(final UICenterlizedDeliverTask4Patient patientTask) {
          final Procedure1<DLPatientCheckDeliver> _function = new Procedure1<DLPatientCheckDeliver>() {
              public void apply(final DLPatientCheckDeliver patientDeliver) {
                final Procedure1<DLCenterlizedDeliverTask> _function = new Procedure1<DLCenterlizedDeliverTask>() {
                    public void apply(final DLCenterlizedDeliverTask it) {
                      CreateOrUpdateCenterlizedDeliverTask4PatientPresenterServiceImpl.this.mapper.transform(patientTask, it);
                    }
                  };
                CreateOrUpdateCenterlizedDeliverTask4PatientPresenterServiceImpl.this.dao.createPatientCheckDeliverTask(patientDeliver, _function);
              }
            };
          CreateOrUpdateCenterlizedDeliverTask4PatientPresenterServiceImpl.this.patientDao.create(_function);
        }
      };
    IterableExtensions.<UICenterlizedDeliverTask4Patient>forEach(patients, _function);
  }
  
  public UIInHospitalPatient loadPatientDetail(final DLInHospitalPatientProxy newPatient) throws SessionTimeOutException, ValidationException {
    DLInHospitalPatient _resolved= null;
    if(newPatient!=null) _resolved=(com.fudanmed.platform.core.deliver.DLInHospitalPatient)com.uniquesoft.uidl.extensions.ModelObjects.resolve(newPatient, entities);
    
    UIInHospitalPatient _transform = this.inHospitalPatientMapper.transform( _resolved);
    return _transform;
  }
}
