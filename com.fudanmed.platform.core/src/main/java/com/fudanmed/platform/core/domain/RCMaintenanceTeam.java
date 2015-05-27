package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.impl.RCMaintenanceTeamImpl;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import edu.fudan.langlab.domain.security.Role;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.INamedModelObject;

@EntityImplementation(implementBy = RCMaintenanceTeamImpl.class)
public interface RCMaintenanceTeam extends IModelObject, INamedModelObject {
  public abstract String getAliasName();
  
  public abstract RCMaintenanceTeam setAliasName(final String aliasName);
  
  public abstract RCOrganization getOrganization();
  
  public abstract RCMaintenanceTeam setOrganization(final RCOrganization organization);
  
  public abstract Role getRole();
  
  public abstract RCMaintenanceTeam setRole(final Role role);
  
  public abstract String getEntityName();
  
  public abstract RCMaintenanceTeamProxy toProxy();
}
