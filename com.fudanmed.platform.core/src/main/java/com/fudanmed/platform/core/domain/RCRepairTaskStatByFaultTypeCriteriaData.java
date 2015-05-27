package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCFaultType;

public class RCRepairTaskStatByFaultTypeCriteriaData {
  public RCRepairTaskStatByFaultTypeCriteriaData(final RCFaultType faultType, final Long cnt) {
    this.faultType=faultType;
    this.cnt=cnt;
    
  }
  
  private RCFaultType faultType;
  
  public RCFaultType getFaultType() {
    return this.faultType;
  }
  
  private Long cnt;
  
  public Long getCnt() {
    return this.cnt;
  }
}
