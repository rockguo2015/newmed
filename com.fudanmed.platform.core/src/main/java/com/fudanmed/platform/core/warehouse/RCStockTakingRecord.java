package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.warehouse.RCProductSpecificationSummary;
import com.fudanmed.platform.core.warehouse.RCStockTakingRecordItem;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.impl.RCStockTakingRecordImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingRecordProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Collection;
import java.util.Date;

@EntityImplementation(implementBy = RCStockTakingRecordImpl.class)
public interface RCStockTakingRecord extends IModelObject {
  public abstract String getSid();
  
  public abstract RCStockTakingRecord setSid(final String sid);
  
  public abstract RCEmployee getOperator();
  
  public abstract RCStockTakingRecord setOperator(final RCEmployee operator);
  
  public abstract Date getDate();
  
  public abstract RCStockTakingRecord setDate(final Date date);
  
  public abstract String getComment();
  
  public abstract RCStockTakingRecord setComment(final String comment);
  
  public abstract Collection<RCStockTakingRecordItem> getItems();
  
  public abstract RCStockTakingRecordItem createAndAddtoItems();
  
  public abstract RCStockTakingRecord removeFromItems(final RCStockTakingRecordItem rCStockTakingRecordItem);
  
  public abstract RCStockTakingRecord removeAllItems();
  
  public abstract RCWarehouse getSourceStore();
  
  public abstract RCStockTakingRecord setSourceStore(final RCWarehouse sourceStore);
  
  public abstract Boolean getCommitted();
  
  public abstract RCStockTakingRecord setCommitted(final Boolean committed);
  
  public abstract String getTypeName();
  
  public abstract Double getTotalAmount();
  
  public abstract void initItemsFromSummary(final Collection<RCProductSpecificationSummary> summaryItems);
  
  public abstract void commit(final RCEmployee operator);
  
  public abstract RCStockTakingRecordProxy toProxy();
}
