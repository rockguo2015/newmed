package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.warehouse.RCStockTakingItem;
import com.fudanmed.platform.core.warehouse.RCStockTakingRecord;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.impl.RCStockTakingListImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingListProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Collection;
import java.util.Date;

@EntityImplementation(implementBy = RCStockTakingListImpl.class)
public interface RCStockTakingList extends IModelObject {
  public abstract RCWarehouse getWarehouse();
  
  public abstract RCStockTakingList setWarehouse(final RCWarehouse warehouse);
  
  public abstract RCEmployee getOperator();
  
  public abstract RCStockTakingList setOperator(final RCEmployee operator);
  
  public abstract String getComment();
  
  public abstract RCStockTakingList setComment(final String comment);
  
  public abstract Date getDate();
  
  public abstract RCStockTakingList setDate(final Date date);
  
  public abstract RCStockTakingRecord getStockTakingRecord();
  
  public abstract RCStockTakingList setStockTakingRecord(final RCStockTakingRecord stockTakingRecord);
  
  public abstract Collection<RCStockTakingItem> getItems();
  
  public abstract RCStockTakingItem createAndAddtoItems();
  
  public abstract RCStockTakingList removeFromItems(final RCStockTakingItem rCStockTakingItem);
  
  public abstract RCStockTakingList removeAllItems();
  
  public abstract void initializeStockTakingItems(final RCEmployee operator);
  
  public abstract Boolean allDataCollected();
  
  public abstract Boolean getIsCommited();
  
  public abstract RCStockTakingRecord createStockTakingRecord();
  
  public abstract RCStockTakingListProxy toProxy();
}
