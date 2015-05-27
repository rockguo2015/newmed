package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLCheckOrganization;
import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckType;
import com.fudanmed.platform.core.deliver.DLInHospitalLocation;
import com.fudanmed.platform.core.deliver.DLInHospitalPatient;
import com.fudanmed.platform.core.deliver.DLPatientCheckDeliver;
import com.fudanmed.platform.core.deliver.DLPatientCheckDeliverCriteria;
import com.fudanmed.platform.core.deliver.DLPatientDeliverMethod;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import org.hibernate.Query;

public class DLPatientCheckDeliverCriteriaImpl extends HQLBasedPagedQueryCriteria<DLPatientCheckDeliver> implements DLPatientCheckDeliverCriteria {
  private DLInHospitalPatient patient;
  
  public DLInHospitalPatient getPatient() {
    return this.patient;
  }
  
  public DLPatientCheckDeliverCriteria setPatient(final DLInHospitalPatient patient) {
    this.patient = patient;
    return this;			
    
  }
  
  private DLInHospitalLocation location;
  
  public DLInHospitalLocation getLocation() {
    return this.location;
  }
  
  public DLPatientCheckDeliverCriteria setLocation(final DLInHospitalLocation location) {
    this.location = location;
    return this;			
    
  }
  
  private String bedNumber;
  
  public String getBedNumber() {
    return this.bedNumber;
  }
  
  public DLPatientCheckDeliverCriteria setBedNumber(final String bedNumber) {
    this.bedNumber = bedNumber;
    return this;			
    
  }
  
  private DLCheckOrganization checkOrganization;
  
  public DLCheckOrganization getCheckOrganization() {
    return this.checkOrganization;
  }
  
  public DLPatientCheckDeliverCriteria setCheckOrganization(final DLCheckOrganization checkOrganization) {
    this.checkOrganization = checkOrganization;
    return this;			
    
  }
  
  private DLDeliverPatientCheckType checkType;
  
  public DLDeliverPatientCheckType getCheckType() {
    return this.checkType;
  }
  
  public DLPatientCheckDeliverCriteria setCheckType(final DLDeliverPatientCheckType checkType) {
    this.checkType = checkType;
    return this;			
    
  }
  
  private DLPatientDeliverMethod deliverMethod;
  
  public DLPatientDeliverMethod getDeliverMethod() {
    return this.deliverMethod;
  }
  
  public DLPatientCheckDeliverCriteria setDeliverMethod(final DLPatientDeliverMethod deliverMethod) {
    this.deliverMethod = deliverMethod;
    return this;			
    
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.deliver.impl.DLPatientCheckDeliverImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getPatient()) ){
    	hql += " and (this.patient = :patient)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getLocation()) ){
    	hql += " and (this.patient.location = :location)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getBedNumber()) ){
    	hql += " and (this.patient.bedNumber = :bedNumber)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getCheckOrganization()) ){
    	hql += " and (this.checkOrganization = :checkOrganization)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getCheckType()) ){
    	hql += " and (this.checkType = :checkType)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDeliverMethod()) ){
    	hql += " and (this.deliverMethod = :deliverMethod)" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getPatient())){
    	query.setParameter("patient",getPatient()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getLocation())){
    	query.setParameter("location",getLocation()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getBedNumber())){
    	query.setParameter("bedNumber",getBedNumber()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getCheckOrganization())){
    	query.setParameter("checkOrganization",getCheckOrganization()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getCheckType())){
    	query.setParameter("checkType",getCheckType()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDeliverMethod())){
    	query.setParameter("deliverMethod",getDeliverMethod()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public DLPatientCheckDeliverCriteriaImpl() {
    initOrderBys();
  }
}
