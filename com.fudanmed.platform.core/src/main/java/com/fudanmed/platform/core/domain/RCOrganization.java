package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCOnsitePosition;
import com.fudanmed.platform.core.domain.impl.RCOrganizationImpl;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import edu.fudan.langlab.domain.organization.Party;
import edu.fudan.mylang.pf.EntityImplementation;
import java.util.Collection;

@EntityImplementation(implementBy = RCOrganizationImpl.class)
public interface RCOrganization extends Party {
  public abstract String getCode();
  
  public abstract RCOrganization setCode(final String code);
  
  public abstract Collection<RCOrganization> getSubOrganizations();
  
  public abstract RCOrganization createAndAddtoSubOrganizations();
  
  public abstract RCOrganization removeFromSubOrganizations(final RCOrganization rCOrganization);
  
  public abstract RCOrganization removeAllSubOrganizations();
  
  public abstract RCOrganization getParent();
  
  public abstract RCOrganization setParent(final RCOrganization parent);
  
  public abstract Collection<RCOnsitePosition> getPositions();
  
  public abstract RCOrganization addtoPositions(final RCOnsitePosition rCOnsitePosition);
  
  public abstract RCOrganization setPositions(final Iterable<RCOnsitePosition> positions);
  
  public abstract RCOrganization removeFromPositions(final RCOnsitePosition rCOnsitePosition);
  
  public abstract RCOrganization removeAllPositions();
  
  public abstract Collection<RCEmployee> getAllEmployees();
  
  public abstract String getEntityName();
  
  public abstract Collection<RCEmployee> getOnJobEmployees();
  
  public abstract String fullPath();
  
  public abstract RCOrganizationProxy toProxy();
}
