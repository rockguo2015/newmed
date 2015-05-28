package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTask;
import com.fudanmed.platform.core.deliver.DLCheckOrganization;
import com.fudanmed.platform.core.deliver.DLDeliverEmergency;
import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckType;
import com.fudanmed.platform.core.deliver.DLDeliverSubject;
import com.fudanmed.platform.core.deliver.DLInHospitalPatient;
import com.fudanmed.platform.core.deliver.DLPatientCheckDeliver;
import com.fudanmed.platform.core.deliver.DLPatientDeliverMethod;
import com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverEmergencyProxy;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy;
import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import com.fudanmed.platform.core.deliver.proxy.DLPatientDeliverMethodProxy;
import com.fudanmed.platform.core.web.server.service.deliver.CenterlizedDeliverTask4PatientValidator;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask4Patient;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.deliver.CenterlizedDeliverTask4PatientMapper")
public class CenterlizedDeliverTask4PatientMapper extends AbstractEntityMapper<UICenterlizedDeliverTask4Patient,DLCenterlizedDeliverTask> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public DLCenterlizedDeliverTask loadEntityById(final Long id) {
    return entities.get(DLCenterlizedDeliverTask.class,id);
  }
  
  public DLCenterlizedDeliverTask create() {
    return entities.create(DLCenterlizedDeliverTask.class);
  }
  
  @Autowired
  private CenterlizedDeliverTask4PatientValidator validator;
  
  public void copyToEntity(final UICenterlizedDeliverTask4Patient from, final DLCenterlizedDeliverTask to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.getPlanDateTime().setPlanDate(convertService.toValue(java.util.Date.class,from.getPlanDate()));
    to.getPlanDateTime().setPlanTime(convertService.toValue(java.util.Date.class,from.getPlanTime()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final UICenterlizedDeliverTask4Patient _gwt, final DLCenterlizedDeliverTask _entity) {
    DLDeliverSubject _subject = _entity.getSubject();
    DLInHospitalPatientProxy _patient = _gwt.getPatient();
    DLInHospitalPatient _resolved= null;
    if(_patient!=null) _resolved=(com.fudanmed.platform.core.deliver.DLInHospitalPatient)com.uniquesoft.uidl.extensions.ModelObjects.resolve(_patient, entities);
    
    ((DLPatientCheckDeliver) _subject).setPatient( _resolved);
    DLDeliverSubject _subject_1 = _entity.getSubject();
    DLCheckOrganizationProxy _checkOrganization = _gwt.getCheckOrganization();
    DLCheckOrganization _resolved_1= null;
    if(_checkOrganization!=null) _resolved_1=(com.fudanmed.platform.core.deliver.DLCheckOrganization)com.uniquesoft.uidl.extensions.ModelObjects.resolve(_checkOrganization, entities);
    
    ((DLPatientCheckDeliver) _subject_1).setCheckOrganization( _resolved_1);
    DLDeliverSubject _subject_2 = _entity.getSubject();
    DLDeliverPatientCheckTypeProxy _checkType = _gwt.getCheckType();
    DLDeliverPatientCheckType _resolved_2= null;
    if(_checkType!=null) _resolved_2=(com.fudanmed.platform.core.deliver.DLDeliverPatientCheckType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(_checkType, entities);
    
    ((DLPatientCheckDeliver) _subject_2).setCheckType( _resolved_2);
    DLDeliverSubject _subject_3 = _entity.getSubject();
    DLPatientDeliverMethodProxy _deliverMethod = _gwt.getDeliverMethod();
    DLPatientDeliverMethod _resolved_3= null;
    if(_deliverMethod!=null) _resolved_3=(com.fudanmed.platform.core.deliver.DLPatientDeliverMethod)com.uniquesoft.uidl.extensions.ModelObjects.resolve(_deliverMethod, entities);
    
    ((DLPatientCheckDeliver) _subject_3).setDeliverMethod( _resolved_3);
    DLDeliverSubject _subject_4 = _entity.getSubject();
    DLDeliverEmergencyProxy _emergency = _gwt.getEmergency();
    DLDeliverEmergency _resolved_4= null;
    if(_emergency!=null) _resolved_4=(com.fudanmed.platform.core.deliver.DLDeliverEmergency)com.uniquesoft.uidl.extensions.ModelObjects.resolve(_emergency, entities);
    
    ((DLPatientCheckDeliver) _subject_4).setEmergency( _resolved_4);
  }
  
  public UICenterlizedDeliverTask4Patient copyFromEntity(final UICenterlizedDeliverTask4Patient result, final DLCenterlizedDeliverTask entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    if(entity. getPlanDateTime()  != null )
    	result.setPlanDate(convertService.toValue(java.util.Date.class,entity.getPlanDateTime().getPlanDate()));
    if(entity. getPlanDateTime()  != null )
    	result.setPlanTime(convertService.toValue(java.util.Date.class,entity.getPlanDateTime().getPlanTime()));
    buildFromCust(result,entity);
    return result;
    
  }
  
  public UICenterlizedDeliverTask4Patient buildFrom(final DLCenterlizedDeliverTask entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask4Patient result = new com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask4Patient();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  protected void buildFromCust(final UICenterlizedDeliverTask4Patient _gwt, final DLCenterlizedDeliverTask _entity) {
    DLDeliverSubject _subject = _entity.getSubject();
    DLInHospitalPatient _patient = ((DLPatientCheckDeliver) _subject).getPatient();
    DLInHospitalPatientProxy _proxy = _patient.toProxy();
    _gwt.setPatient(_proxy);
    DLDeliverSubject _subject_1 = _entity.getSubject();
    DLCheckOrganization _checkOrganization = ((DLPatientCheckDeliver) _subject_1).getCheckOrganization();
    DLCheckOrganizationProxy _proxy_1 = _checkOrganization.toProxy();
    _gwt.setCheckOrganization(_proxy_1);
    DLDeliverSubject _subject_2 = _entity.getSubject();
    DLDeliverPatientCheckType _checkType = ((DLPatientCheckDeliver) _subject_2).getCheckType();
    DLDeliverPatientCheckTypeProxy _proxy_2 = _checkType.toProxy();
    _gwt.setCheckType(_proxy_2);
    DLDeliverSubject _subject_3 = _entity.getSubject();
    DLPatientDeliverMethod _deliverMethod = ((DLPatientCheckDeliver) _subject_3).getDeliverMethod();
    DLPatientDeliverMethodProxy _proxy_3 = _deliverMethod.toProxy();
    _gwt.setDeliverMethod(_proxy_3);
    DLDeliverSubject _subject_4 = _entity.getSubject();
    DLDeliverEmergency _emergency = ((DLPatientCheckDeliver) _subject_4).getEmergency();
    DLDeliverEmergencyProxy _proxy_4 = _emergency.toProxy();
    _gwt.setEmergency(_proxy_4);
  }
  
  public Class<?> getUIClass() {
    return UICenterlizedDeliverTask4Patient.class;
  }
  
  public Class<?> getEntityClass() {
    return DLCenterlizedDeliverTask.class;
  }
}
