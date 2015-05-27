package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCEmployee;

public class RCWorkItemTask4WorkersStatCriteriaData {
  public RCWorkItemTask4WorkersStatCriteriaData(final RCEmployee worker, final Long cnt) {
    this.worker=worker;
    this.cnt=cnt;
    
  }
  
  private RCEmployee worker;
  
  public RCEmployee getWorker() {
    return this.worker;
  }
  
  private Long cnt;
  
  public Long getCnt() {
    return this.cnt;
  }
}
