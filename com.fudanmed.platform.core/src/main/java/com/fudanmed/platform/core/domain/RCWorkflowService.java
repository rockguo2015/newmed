package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import edu.fudan.mylang.pf.IBaseService;
import java.util.Collection;

public interface RCWorkflowService extends IBaseService {
  public abstract Collection<RCMaintenanceTeam> loadMaintenanceTeams4SystemUser();
}
