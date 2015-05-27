package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCOnsitePosition;
import com.fudanmed.platform.core.domain.RCOrganization;
import edu.fudan.mylang.pf.IBaseService;
import java.util.Collection;

public interface RCOrganizationService extends IBaseService {
  public abstract Collection<RCOrganization> getALlOrganization();
  
  public abstract Collection<RCOnsitePosition> getAllOnsitePositions();
  
  public abstract RCOrganization createRootOrganization(final String code, final String name);
  
  public abstract RCOnsitePosition createRootOnsitePosition(final String code, final String name);
  
  public abstract RCMaintenanceTeam selectAsMaintenanceTeam(final RCOrganization organization);
  
  public abstract void removeMaintenanceTeam(final RCMaintenanceTeam team);
}
