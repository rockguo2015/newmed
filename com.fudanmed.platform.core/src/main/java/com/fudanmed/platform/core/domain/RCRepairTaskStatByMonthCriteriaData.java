package com.fudanmed.platform.core.domain;

public class RCRepairTaskStatByMonthCriteriaData {
  public RCRepairTaskStatByMonthCriteriaData(final String month, final Long cnt) {
    this.month=month;
    this.cnt=cnt;
    
  }
  
  private String month;
  
  public String getMonth() {
    return this.month;
  }
  
  private Long cnt;
  
  public Long getCnt() {
    return this.cnt;
  }
}
