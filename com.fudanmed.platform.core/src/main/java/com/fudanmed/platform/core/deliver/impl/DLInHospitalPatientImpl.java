package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLGender;
import com.fudanmed.platform.core.deliver.DLInHospitalLocation;
import com.fudanmed.platform.core.deliver.DLInHospitalPatient;
import com.fudanmed.platform.core.deliver.events.DLInHospitalPatientEventsManager;
import com.fudanmed.platform.core.deliver.impl.DLInHospitalLocationImpl;
import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.hibernate.annotations.DiscriminatorOptions;
import org.springframework.beans.factory.BeanFactory;

@Entity
@DiscriminatorValue("DLINHOSPITALPATIENT_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "dlinhospitalpatient")
public class DLInHospitalPatientImpl extends BaseModelObject implements DLInHospitalPatient {
  public DLInHospitalPatientImpl() {
    super();
  }
  
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public DLInHospitalPatient setSid(final String sid) {
    this.sid = sid;
    return this;			
    
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public DLInHospitalPatient setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  private Integer age;
  
  public Integer getAge() {
    return this.age;
  }
  
  public DLInHospitalPatient setAge(final Integer age) {
    this.age = age;
    return this;			
    
  }
  
  private DLGender gender;
  
  public DLGender getGender() {
    return this.gender;
  }
  
  public DLInHospitalPatient setGender(final DLGender gender) {
    this.gender = gender;
    return this;			
    
  }
  
  @JoinColumn(name = "location_id")
  @ManyToOne(targetEntity = DLInHospitalLocationImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private DLInHospitalLocation location;
  
  public DLInHospitalLocation getLocation() {
    return this.location;
  }
  
  public DLInHospitalPatient setLocation(final DLInHospitalLocation location) {
    this.location = location;
    return this;			
    
  }
  
  private String bedNumber;
  
  public String getBedNumber() {
    return this.bedNumber;
  }
  
  public DLInHospitalPatient setBedNumber(final String bedNumber) {
    this.bedNumber = bedNumber;
    return this;			
    
  }
  
  private String simplePy;
  
  public String getSimplePy() {
    return this.simplePy;
  }
  
  public DLInHospitalPatient setSimplePy(final String simplePy) {
    this.simplePy = simplePy;
    return this;			
    
  }
  
  public String getNameField() {
    return "name";
  }
  
  public String getEntityName() {
    return this.name;
  }
  
  public void update(final Procedure1<? super DLInHospitalPatient> updater) {
    updater.apply(this);
    this.checkValid();
    BeanFactory _beanFactory = this.getBeanFactory();
    DLInHospitalPatientEventsManager _bean = _beanFactory.<DLInHospitalPatientEventsManager>getBean(DLInHospitalPatientEventsManager.class);
    _bean.fireUpdateded(this);
  }
  
  public static DLInHospitalPatient create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLInHospitalPatient dLInHospitalPatient = new com.fudanmed.platform.core.deliver.impl.DLInHospitalPatientImpl(
    );
    objectFactory.create(dLInHospitalPatient);
    return dLInHospitalPatient;			
    
  }
  
  public DLInHospitalPatientProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
