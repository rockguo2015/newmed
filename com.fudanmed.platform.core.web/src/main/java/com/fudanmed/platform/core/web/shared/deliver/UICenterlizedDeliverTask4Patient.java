package com.fudanmed.platform.core.web.shared.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy;
import com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverEmergencyProxy;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy;
import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import com.fudanmed.platform.core.deliver.proxy.DLPatientDeliverMethodProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Collection;
import java.util.Date;

public class UICenterlizedDeliverTask4Patient extends GWTEntity {
  private Date planDate;
  
  public Date getPlanDate() {
    return this.planDate;
  }
  
  public void setPlanDate(final Date planDate) {
    this.planDate = planDate;
  }
  
  public final static String P_PlanDate = "planDate";
  
  public static IObjectFieldAccessor<UICenterlizedDeliverTask4Patient,Date> PlanDateAccessor = new IObjectFieldAccessor<UICenterlizedDeliverTask4Patient,Date>(){
    				public java.util.Date getValue(UICenterlizedDeliverTask4Patient object){
    					return object.getPlanDate();
    				}
    				public void setValue(UICenterlizedDeliverTask4Patient object,java.util.Date value){
    					object.setPlanDate(value);
    				}
    			};
  
  private Date planTime;
  
  public Date getPlanTime() {
    return this.planTime;
  }
  
  public void setPlanTime(final Date planTime) {
    this.planTime = planTime;
  }
  
  public final static String P_PlanTime = "planTime";
  
  public static IObjectFieldAccessor<UICenterlizedDeliverTask4Patient,Date> PlanTimeAccessor = new IObjectFieldAccessor<UICenterlizedDeliverTask4Patient,Date>(){
    				public java.util.Date getValue(UICenterlizedDeliverTask4Patient object){
    					return object.getPlanTime();
    				}
    				public void setValue(UICenterlizedDeliverTask4Patient object,java.util.Date value){
    					object.setPlanTime(value);
    				}
    			};
  
  private DLInHospitalPatientProxy patient;
  
  public DLInHospitalPatientProxy getPatient() {
    return this.patient;
  }
  
  public void setPatient(final DLInHospitalPatientProxy patient) {
    this.patient = patient;
  }
  
  public final static String P_Patient = "patient";
  
  public static IObjectFieldAccessor<UICenterlizedDeliverTask4Patient,DLInHospitalPatientProxy> PatientAccessor = new IObjectFieldAccessor<UICenterlizedDeliverTask4Patient,DLInHospitalPatientProxy>(){
    				public com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy getValue(UICenterlizedDeliverTask4Patient object){
    					return object.getPatient();
    				}
    				public void setValue(UICenterlizedDeliverTask4Patient object,com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy value){
    					object.setPatient(value);
    				}
    			};
  
  private DLCheckOrganizationProxy checkOrganization;
  
  public DLCheckOrganizationProxy getCheckOrganization() {
    return this.checkOrganization;
  }
  
  public void setCheckOrganization(final DLCheckOrganizationProxy checkOrganization) {
    this.checkOrganization = checkOrganization;
  }
  
  public final static String P_CheckOrganization = "checkOrganization";
  
  public static IObjectFieldAccessor<UICenterlizedDeliverTask4Patient,DLCheckOrganizationProxy> CheckOrganizationAccessor = new IObjectFieldAccessor<UICenterlizedDeliverTask4Patient,DLCheckOrganizationProxy>(){
    				public com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy getValue(UICenterlizedDeliverTask4Patient object){
    					return object.getCheckOrganization();
    				}
    				public void setValue(UICenterlizedDeliverTask4Patient object,com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy value){
    					object.setCheckOrganization(value);
    				}
    			};
  
  private DLDeliverPatientCheckTypeProxy checkType;
  
  public DLDeliverPatientCheckTypeProxy getCheckType() {
    return this.checkType;
  }
  
  public void setCheckType(final DLDeliverPatientCheckTypeProxy checkType) {
    this.checkType = checkType;
  }
  
  public final static String P_CheckType = "checkType";
  
  public static IObjectFieldAccessor<UICenterlizedDeliverTask4Patient,DLDeliverPatientCheckTypeProxy> CheckTypeAccessor = new IObjectFieldAccessor<UICenterlizedDeliverTask4Patient,DLDeliverPatientCheckTypeProxy>(){
    				public com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy getValue(UICenterlizedDeliverTask4Patient object){
    					return object.getCheckType();
    				}
    				public void setValue(UICenterlizedDeliverTask4Patient object,com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy value){
    					object.setCheckType(value);
    				}
    			};
  
  private DLPatientDeliverMethodProxy deliverMethod;
  
  public DLPatientDeliverMethodProxy getDeliverMethod() {
    return this.deliverMethod;
  }
  
  public void setDeliverMethod(final DLPatientDeliverMethodProxy deliverMethod) {
    this.deliverMethod = deliverMethod;
  }
  
  public final static String P_DeliverMethod = "deliverMethod";
  
  public static IObjectFieldAccessor<UICenterlizedDeliverTask4Patient,DLPatientDeliverMethodProxy> DeliverMethodAccessor = new IObjectFieldAccessor<UICenterlizedDeliverTask4Patient,DLPatientDeliverMethodProxy>(){
    				public com.fudanmed.platform.core.deliver.proxy.DLPatientDeliverMethodProxy getValue(UICenterlizedDeliverTask4Patient object){
    					return object.getDeliverMethod();
    				}
    				public void setValue(UICenterlizedDeliverTask4Patient object,com.fudanmed.platform.core.deliver.proxy.DLPatientDeliverMethodProxy value){
    					object.setDeliverMethod(value);
    				}
    			};
  
  private DLDeliverEmergencyProxy emergency;
  
  public DLDeliverEmergencyProxy getEmergency() {
    return this.emergency;
  }
  
  public void setEmergency(final DLDeliverEmergencyProxy emergency) {
    this.emergency = emergency;
  }
  
  public final static String P_Emergency = "emergency";
  
  public static IObjectFieldAccessor<UICenterlizedDeliverTask4Patient,DLDeliverEmergencyProxy> EmergencyAccessor = new IObjectFieldAccessor<UICenterlizedDeliverTask4Patient,DLDeliverEmergencyProxy>(){
    				public com.fudanmed.platform.core.deliver.proxy.DLDeliverEmergencyProxy getValue(UICenterlizedDeliverTask4Patient object){
    					return object.getEmergency();
    				}
    				public void setValue(UICenterlizedDeliverTask4Patient object,com.fudanmed.platform.core.deliver.proxy.DLDeliverEmergencyProxy value){
    					object.setEmergency(value);
    				}
    			};
  
  private Collection<UICenterlizedDeliverTask4Patient> patients = com.google.common.collect.Lists.newArrayList();
  
  public Collection<UICenterlizedDeliverTask4Patient> getPatients() {
    return this.patients;
  }
  
  public void setPatients(final Collection<UICenterlizedDeliverTask4Patient> patients) {
    this.patients = patients;
  }
  
  public final static String P_Patients = "patients";
  
  public static IObjectFieldAccessor<UICenterlizedDeliverTask4Patient,Collection<UICenterlizedDeliverTask4Patient>> PatientsAccessor = new IObjectFieldAccessor<UICenterlizedDeliverTask4Patient,Collection<UICenterlizedDeliverTask4Patient>>(){
    				public java.util.Collection<com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask4Patient> getValue(UICenterlizedDeliverTask4Patient object){
    					return object.getPatients();
    				}
    				public void setValue(UICenterlizedDeliverTask4Patient object,java.util.Collection<com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask4Patient> value){
    					object.setPatients(value);
    				}
    			};
  
  public DLCenterlizedDeliverTaskProxy toProxy() {
    return (DLCenterlizedDeliverTaskProxy)super.toProxy();
    
  }
}
