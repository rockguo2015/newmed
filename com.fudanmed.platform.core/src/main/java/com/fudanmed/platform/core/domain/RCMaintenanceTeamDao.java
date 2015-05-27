package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import edu.fudan.mylang.pf.IDAOService;

public interface RCMaintenanceTeamDao extends IDAOService<RCMaintenanceTeam> {
  public abstract Iterable<RCMaintenanceTeam> getAllStoreValidTeam4CurrentUser();
}
