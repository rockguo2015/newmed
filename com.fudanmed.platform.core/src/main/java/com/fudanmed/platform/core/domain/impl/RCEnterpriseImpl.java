package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCEnterprise;
import com.fudanmed.platform.core.domain.proxy.RCEnterpriseProxy;
import edu.fudan.langlab.domain.organization.impl.PartyImpl;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RCENTERPRISE_TYPE")
public class RCEnterpriseImpl extends PartyImpl implements RCEnterprise {
  public RCEnterpriseImpl() {
    super();
  }
  
  private String code;
  
  public String getCode() {
    return this.code;
  }
  
  public RCEnterprise setCode(final String code) {
    this.code = code;
    return this;			
    
  }
  
  private String shortName;
  
  public String getShortName() {
    return this.shortName;
  }
  
  public RCEnterprise setShortName(final String shortName) {
    this.shortName = shortName;
    return this;			
    
  }
  
  private String ename;
  
  public String getEname() {
    return this.ename;
  }
  
  public RCEnterprise setEname(final String ename) {
    this.ename = ename;
    return this;			
    
  }
  
  private String spell;
  
  public String getSpell() {
    return this.spell;
  }
  
  public RCEnterprise setSpell(final String spell) {
    this.spell = spell;
    return this;			
    
  }
  
  private String helpCode;
  
  public String getHelpCode() {
    return this.helpCode;
  }
  
  public RCEnterprise setHelpCode(final String helpCode) {
    this.helpCode = helpCode;
    return this;			
    
  }
  
  private String enterpriseEnrolNum;
  
  public String getEnterpriseEnrolNum() {
    return this.enterpriseEnrolNum;
  }
  
  public RCEnterprise setEnterpriseEnrolNum(final String enterpriseEnrolNum) {
    this.enterpriseEnrolNum = enterpriseEnrolNum;
    return this;			
    
  }
  
  private String workNo;
  
  public String getWorkNo() {
    return this.workNo;
  }
  
  public RCEnterprise setWorkNo(final String workNo) {
    this.workNo = workNo;
    return this;			
    
  }
  
  private Double regCapital;
  
  public Double getRegCapital() {
    return this.regCapital;
  }
  
  public RCEnterprise setRegCapital(final Double regCapital) {
    this.regCapital = regCapital;
    return this;			
    
  }
  
  private String legalPerson;
  
  public String getLegalPerson() {
    return this.legalPerson;
  }
  
  public RCEnterprise setLegalPerson(final String legalPerson) {
    this.legalPerson = legalPerson;
    return this;			
    
  }
  
  private String aptitudeName;
  
  public String getAptitudeName() {
    return this.aptitudeName;
  }
  
  public RCEnterprise setAptitudeName(final String aptitudeName) {
    this.aptitudeName = aptitudeName;
    return this;			
    
  }
  
  private String aptitudeNo;
  
  public String getAptitudeNo() {
    return this.aptitudeNo;
  }
  
  public RCEnterprise setAptitudeNo(final String aptitudeNo) {
    this.aptitudeNo = aptitudeNo;
    return this;			
    
  }
  
  public static RCEnterprise create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.domain.RCEnterprise rCEnterprise = new com.fudanmed.platform.core.domain.impl.RCEnterpriseImpl(
    );
    objectFactory.create(rCEnterprise);
    return rCEnterprise;			
    
  }
  
  public RCEnterpriseProxy toProxy() {
    com.fudanmed.platform.core.domain.proxy.RCEnterpriseProxy proxy = new com.fudanmed.platform.core.domain.proxy.RCEnterpriseProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
