package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCMaintenanceTeam;

public class RCGroupTaskStatByTeamCriteriaData {
  public RCGroupTaskStatByTeamCriteriaData(final Long cnt, final RCMaintenanceTeam team) {
    this.cnt=cnt;
    this.team=team;
    
  }
  
  private Long cnt;
  
  public Long getCnt() {
    return this.cnt;
  }
  
  private RCMaintenanceTeam team;
  
  public RCMaintenanceTeam getTeam() {
    return this.team;
  }
}
