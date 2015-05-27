package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLCheckOrganization;
import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckType;
import com.fudanmed.platform.core.deliver.DLInHospitalPatient;
import com.fudanmed.platform.core.deliver.DLPatientCheckDeliver;
import com.fudanmed.platform.core.deliver.DLPatientDeliverMethod;
import com.fudanmed.platform.core.deliver.impl.DLCheckOrganizationImpl;
import com.fudanmed.platform.core.deliver.impl.DLDeliverPatientCheckTypeImpl;
import com.fudanmed.platform.core.deliver.impl.DLDeliverSubjectImpl;
import com.fudanmed.platform.core.deliver.impl.DLInHospitalPatientImpl;
import com.fudanmed.platform.core.deliver.impl.DLPatientDeliverMethodImpl;
import com.fudanmed.platform.core.deliver.proxy.DLPatientCheckDeliverProxy;
import com.google.common.base.Objects;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Entity
@DiscriminatorValue("DLPATIENTCHECKDELIVER_TYPE")
public class DLPatientCheckDeliverImpl extends DLDeliverSubjectImpl implements DLPatientCheckDeliver {
  public DLPatientCheckDeliverImpl() {
    super();
  }
  
  @JoinColumn(name = "patient_id")
  @ManyToOne(targetEntity = DLInHospitalPatientImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private DLInHospitalPatient patient;
  
  public DLInHospitalPatient getPatient() {
    return this.patient;
  }
  
  public DLPatientCheckDeliver setPatient(final DLInHospitalPatient patient) {
    this.patient = patient;
    return this;			
    
  }
  
  @JoinColumn(name = "checkType_id")
  @ManyToOne(targetEntity = DLDeliverPatientCheckTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private DLDeliverPatientCheckType checkType;
  
  public DLDeliverPatientCheckType getCheckType() {
    return this.checkType;
  }
  
  public DLPatientCheckDeliver setCheckType(final DLDeliverPatientCheckType checkType) {
    this.checkType = checkType;
    return this;			
    
  }
  
  @JoinColumn(name = "checkOrganization_id")
  @ManyToOne(targetEntity = DLCheckOrganizationImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private DLCheckOrganization checkOrganization;
  
  public DLCheckOrganization getCheckOrganization() {
    return this.checkOrganization;
  }
  
  public DLPatientCheckDeliver setCheckOrganization(final DLCheckOrganization checkOrganization) {
    this.checkOrganization = checkOrganization;
    return this;			
    
  }
  
  @JoinColumn(name = "deliverMethod_id")
  @ManyToOne(targetEntity = DLPatientDeliverMethodImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private DLPatientDeliverMethod deliverMethod;
  
  public DLPatientDeliverMethod getDeliverMethod() {
    return this.deliverMethod;
  }
  
  public DLPatientCheckDeliver setDeliverMethod(final DLPatientDeliverMethod deliverMethod) {
    this.deliverMethod = deliverMethod;
    return this;			
    
  }
  
  public String getEntityName() {
    String _entityName = this.patient.getEntityName();
    String _plus = (_entityName + ":");
    String _entityName_1 = this.checkType.getEntityName();
    String _plus_1 = (_plus + _entityName_1);
    return _plus_1;
  }
  
  public void update(final Procedure1<? super DLPatientCheckDeliver> updater) {
    updater.apply(this);
    this.checkValid();
  }
  
  public void checkValid() {
    super.checkValid();
    boolean _notEquals = (!Objects.equal(this.patient, null));
    Validates.Assert(_notEquals, "\u5FC5\u987B\u8BBE\u7F6E\u8FD0\u9001\u75C5\u4EBA");
    boolean _notEquals_1 = (!Objects.equal(this.checkOrganization, null));
    Validates.Assert(_notEquals_1, "\u5FC5\u987B\u8BBE\u7F6E\u68C0\u67E5\u79D1\u5BA4");
    boolean _notEquals_2 = (!Objects.equal(this.checkType, null));
    Validates.Assert(_notEquals_2, "\u5FC5\u987B\u8BBE\u7F6E\u68C0\u67E5\u9879\u76EE");
    boolean _notEquals_3 = (!Objects.equal(this.deliverMethod, null));
    Validates.Assert(_notEquals_3, "\u5FC5\u987B\u8BBE\u7F6E\u63A5\u9001\u65B9\u5F0F");
  }
  
  public static DLPatientCheckDeliver create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLPatientCheckDeliver dLPatientCheckDeliver = new com.fudanmed.platform.core.deliver.impl.DLPatientCheckDeliverImpl(
    );
    objectFactory.create(dLPatientCheckDeliver);
    return dLPatientCheckDeliver;			
    
  }
  
  public DLPatientCheckDeliverProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLPatientCheckDeliverProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLPatientCheckDeliverProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
