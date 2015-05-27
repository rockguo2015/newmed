package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.impl.RCRepairReportUserImpl;
import com.fudanmed.platform.core.domain.proxy.RCRepairReportUserProxy;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCRepairReportUserImpl.class)
public interface RCRepairReportUser extends User {
  public abstract RCOrganization getOrganization();
  
  public abstract RCRepairReportUser setOrganization(final RCOrganization organization);
  
  public abstract String getEntityName();
  
  public abstract RCRepairReportUserProxy toProxy();
}
