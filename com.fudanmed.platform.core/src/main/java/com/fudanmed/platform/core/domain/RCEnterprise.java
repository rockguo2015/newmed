package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.impl.RCEnterpriseImpl;
import com.fudanmed.platform.core.domain.proxy.RCEnterpriseProxy;
import edu.fudan.langlab.domain.organization.Party;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCEnterpriseImpl.class)
public interface RCEnterprise extends Party {
  public abstract String getCode();
  
  public abstract RCEnterprise setCode(final String code);
  
  public abstract String getShortName();
  
  public abstract RCEnterprise setShortName(final String shortName);
  
  public abstract String getEname();
  
  public abstract RCEnterprise setEname(final String ename);
  
  public abstract String getSpell();
  
  public abstract RCEnterprise setSpell(final String spell);
  
  public abstract String getHelpCode();
  
  public abstract RCEnterprise setHelpCode(final String helpCode);
  
  public abstract String getEnterpriseEnrolNum();
  
  public abstract RCEnterprise setEnterpriseEnrolNum(final String enterpriseEnrolNum);
  
  public abstract String getWorkNo();
  
  public abstract RCEnterprise setWorkNo(final String workNo);
  
  public abstract Double getRegCapital();
  
  public abstract RCEnterprise setRegCapital(final Double regCapital);
  
  public abstract String getLegalPerson();
  
  public abstract RCEnterprise setLegalPerson(final String legalPerson);
  
  public abstract String getAptitudeName();
  
  public abstract RCEnterprise setAptitudeName(final String aptitudeName);
  
  public abstract String getAptitudeNo();
  
  public abstract RCEnterprise setAptitudeNo(final String aptitudeNo);
  
  public abstract RCEnterpriseProxy toProxy();
}
