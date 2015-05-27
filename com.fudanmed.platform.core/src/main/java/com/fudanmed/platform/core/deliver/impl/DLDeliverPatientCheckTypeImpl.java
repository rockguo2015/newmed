package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLCheckOrganization;
import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategory;
import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckType;
import com.fudanmed.platform.core.deliver.impl.DLCheckOrganizationImpl;
import com.fudanmed.platform.core.deliver.impl.DLDeliverPatientCheckCategoryImpl;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("DLDELIVERPATIENTCHECKTYPE_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "dldeliverpatientchecktype")
public class DLDeliverPatientCheckTypeImpl extends BaseModelObject implements DLDeliverPatientCheckType {
  public DLDeliverPatientCheckTypeImpl() {
    super();
  }
  
  public DLDeliverPatientCheckTypeImpl(final DLDeliverPatientCheckCategory category) {
    super();
    this.category = category;
  }
  
  @JoinColumn(name = "category_id")
  @ManyToOne(targetEntity = DLDeliverPatientCheckCategoryImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private DLDeliverPatientCheckCategory category;
  
  public DLDeliverPatientCheckCategory getCategory() {
    return this.category;
  }
  
  public DLDeliverPatientCheckType setCategory(final DLDeliverPatientCheckCategory category) {
    this.category = category;
    return this;			
    
  }
  
  private String code;
  
  public String getCode() {
    return this.code;
  }
  
  public DLDeliverPatientCheckType setCode(final String code) {
    this.code = code;
    return this;			
    
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public DLDeliverPatientCheckType setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  private Integer performence;
  
  public Integer getPerformence() {
    return this.performence;
  }
  
  public DLDeliverPatientCheckType setPerformence(final Integer performence) {
    this.performence = performence;
    return this;			
    
  }
  
  private Integer timeLimitation;
  
  public Integer getTimeLimitation() {
    return this.timeLimitation;
  }
  
  public DLDeliverPatientCheckType setTimeLimitation(final Integer timeLimitation) {
    this.timeLimitation = timeLimitation;
    return this;			
    
  }
  
  @ManyToMany(targetEntity = DLCheckOrganizationImpl.class)
  @JoinTable(name = "m2m_dldeliverpatientchecktype_checkorganization", joinColumns = @JoinColumn(name = "dldeliverpatientchecktype_id") , inverseJoinColumns = @JoinColumn(name = "dLCheckOrganization_inv_id") )
  private Collection<DLCheckOrganization> checkOrganization = new java.util.ArrayList<com.fudanmed.platform.core.deliver.DLCheckOrganization>();;
  
  public Collection<DLCheckOrganization> getCheckOrganization() {
    return this.checkOrganization;
  }
  
  public DLDeliverPatientCheckType setCheckOrganization(final Iterable<DLCheckOrganization> checkOrganization) {
    removeAllCheckOrganization();
    for(DLCheckOrganization ca : checkOrganization){
    	addtoCheckOrganization(ca);
    }
    return this;		
    
  }
  
  public DLDeliverPatientCheckType addtoCheckOrganization(final DLCheckOrganization dLCheckOrganization) {
    this.checkOrganization.add(dLCheckOrganization);
    return this;
    
  }
  
  public DLDeliverPatientCheckType removeAllCheckOrganization() {
    this.checkOrganization.clear();
    return this;	
    
  }
  
  public DLDeliverPatientCheckType removeFromCheckOrganization(final DLCheckOrganization dLCheckOrganization) {
    this.checkOrganization.remove(dLCheckOrganization);
    return this;
    
  }
  
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public DLDeliverPatientCheckType setComment(final String comment) {
    this.comment = comment;
    return this;			
    
  }
  
  public void update(final Procedure1<? super DLDeliverPatientCheckType> updater) {
    updater.apply(this);
    this.checkValid();
  }
  
  public String getEntityName() {
    return this.name;
  }
  
  private String simplePy;
  
  public String getSimplePy() {
    return this.simplePy;
  }
  
  public DLDeliverPatientCheckType setSimplePy(final String simplePy) {
    this.simplePy = simplePy;
    return this;			
    
  }
  
  public String getNameField() {
    return "name";
  }
  
  public static DLDeliverPatientCheckType create(final DLDeliverPatientCheckCategory category, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLDeliverPatientCheckType dLDeliverPatientCheckType = new com.fudanmed.platform.core.deliver.impl.DLDeliverPatientCheckTypeImpl(
    	category
    );
    objectFactory.create(dLDeliverPatientCheckType);
    return dLDeliverPatientCheckType;			
    
  }
  
  public DLDeliverPatientCheckTypeProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
