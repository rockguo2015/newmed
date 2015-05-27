package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecordItemStat4ProductEntryCriteriaData;
import edu.fudan.mylang.pf.query.BaseStatCriteria;
import java.util.Collection;

public class RCWorkItemStockRecordItemStat4ProductEntryCriteria extends BaseStatCriteria<RCWorkItemStockRecordItemStat4ProductEntryCriteriaData> {
  public void initOrderBys() {
    
  }
  
  public Collection<RCWorkItemStockRecordItemStat4ProductEntryCriteriaData> list() {
    criteria.postInitialize();
    String aggrCriteria = " select new com.fudanmed.platform.core.warehouse.RCWorkItemStockRecordItemStat4ProductEntryCriteriaData(this.recordItem.productEntry.productSpec,sum(this.recordItem.quantity))"
    		+ criteria.getHQLFrom() + " " + criteria.getHQLBody();
    aggrCriteria += " group by this.recordItem.productEntry.productSpec ";
    aggrCriteria += buildOrderByString();
    org.hibernate.Query query = entities.createQuery(aggrCriteria);
    criteria.fillParameters(query);
    return doList(query);
    
  }
}
