package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.common.RCFaultReportSource;

public class RCRepairTaskStatByReportSourceCriteriaData {
  public RCRepairTaskStatByReportSourceCriteriaData(final RCFaultReportSource faultReportSource, final Long cnt) {
    this.faultReportSource=faultReportSource;
    this.cnt=cnt;
    
  }
  
  private RCFaultReportSource faultReportSource;
  
  public RCFaultReportSource getFaultReportSource() {
    return this.faultReportSource;
  }
  
  private Long cnt;
  
  public Long getCnt() {
    return this.cnt;
  }
}
