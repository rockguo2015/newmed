package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.common.RCWorkType;
import com.fudanmed.platform.core.domain.RCEmployeeStatus;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.impl.RCEmployeeImpl;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import edu.fudan.langlab.domain.organization.Party;
import edu.fudan.langlab.domain.security.Role;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.mylang.pf.EntityImplementation;
import java.util.Collection;

@EntityImplementation(implementBy = RCEmployeeImpl.class)
public interface RCEmployee extends Party {
  public abstract String getEid();
  
  public abstract RCEmployee setEid(final String eid);
  
  public abstract String getMobil();
  
  public abstract RCEmployee setMobil(final String mobil);
  
  public abstract String getTel();
  
  public abstract RCEmployee setTel(final String tel);
  
  public abstract String getWorkTel();
  
  public abstract RCEmployee setWorkTel(final String workTel);
  
  public abstract String getComment();
  
  public abstract RCEmployee setComment(final String comment);
  
  public abstract Collection<RCWorkType> getWorkTypes();
  
  public abstract RCEmployee addtoWorkTypes(final RCWorkType rCWorkType);
  
  public abstract RCEmployee setWorkTypes(final Iterable<RCWorkType> workTypes);
  
  public abstract RCEmployee removeFromWorkTypes(final RCWorkType rCWorkType);
  
  public abstract RCEmployee removeAllWorkTypes();
  
  public abstract RCOrganization getOrganization();
  
  public abstract RCEmployee setOrganization(final RCOrganization organization);
  
  public abstract String getCardNumber();
  
  public abstract RCEmployee setCardNumber(final String cardNumber);
  
  public abstract String getOrgPath();
  
  public abstract RCEmployee setOrgPath(final String orgPath);
  
  public abstract Boolean getIsLeaveJob();
  
  public abstract RCEmployee setIsLeaveJob(final Boolean isLeaveJob);
  
  public abstract User asUser();
  
  public abstract Collection<Role> getRoles();
  
  public abstract void updateOrgPath();
  
  public abstract RCEmployeeStatus getStatus();
  
  public abstract void start();
  
  public abstract void leaveJob();
  
  public abstract void returnJob();
  
  public abstract Boolean isOnJob();
  
  public abstract Boolean isLeaveJob();
  
  public abstract RCEmployeeProxy toProxy();
}
