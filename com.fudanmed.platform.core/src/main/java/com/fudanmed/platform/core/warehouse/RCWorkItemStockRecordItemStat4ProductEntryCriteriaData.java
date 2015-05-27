package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductSpecification;

public class RCWorkItemStockRecordItemStat4ProductEntryCriteriaData {
  public RCWorkItemStockRecordItemStat4ProductEntryCriteriaData(final RCProductSpecification productEntry, final Long cnt) {
    this.productEntry=productEntry;
    this.cnt=cnt;
    
  }
  
  private RCProductSpecification productEntry;
  
  public RCProductSpecification getProductEntry() {
    return this.productEntry;
  }
  
  private Long cnt;
  
  public Long getCnt() {
    return this.cnt;
  }
}
