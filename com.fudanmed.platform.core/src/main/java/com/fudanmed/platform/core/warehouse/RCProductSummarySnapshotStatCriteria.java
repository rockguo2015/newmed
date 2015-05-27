package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductSummarySnapshotStatCriteriaData;
import edu.fudan.mylang.pf.query.BaseStatCriteria;
import java.util.Collection;

public class RCProductSummarySnapshotStatCriteria extends BaseStatCriteria<RCProductSummarySnapshotStatCriteriaData> {
  public void initOrderBys() {
    addOrder("this.storageSummary.productSpec.sid",edu.fudan.mylang.pf.query.OrderItem.ASC);
  }
  
  public Collection<RCProductSummarySnapshotStatCriteriaData> list() {
    criteria.postInitialize();
    String aggrCriteria = " select new com.fudanmed.platform.core.warehouse.RCProductSummarySnapshotStatCriteriaData(this.storageSummary,sum(this.inStockQuantity),sum(this.inStockAmount),sum(this.outStockQuantity),sum(this.outStockAmount),sum(this.stockTakingStockQuantity),sum(this.stockTakingStockAmount),sum(this.transferStockQuantity),sum(this.transferStockAmount),sum(this.workitemStockQuantity),sum(this.workitemStockAmount))"
    		+ criteria.getHQLFrom() + " " + criteria.getHQLBody();
    aggrCriteria += " group by this.storageSummary ";
    aggrCriteria += buildOrderByString();
    org.hibernate.Query query = entities.createQuery(aggrCriteria);
    criteria.fillParameters(query);
    return doList(query);
    
  }
}
