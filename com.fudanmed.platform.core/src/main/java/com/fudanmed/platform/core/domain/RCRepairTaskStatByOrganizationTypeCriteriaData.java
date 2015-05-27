package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCOrganization;

public class RCRepairTaskStatByOrganizationTypeCriteriaData {
  public RCRepairTaskStatByOrganizationTypeCriteriaData(final RCOrganization reportOrg, final Long cnt) {
    this.reportOrg=reportOrg;
    this.cnt=cnt;
    
  }
  
  private RCOrganization reportOrg;
  
  public RCOrganization getReportOrg() {
    return this.reportOrg;
  }
  
  private Long cnt;
  
  public Long getCnt() {
    return this.cnt;
  }
}
