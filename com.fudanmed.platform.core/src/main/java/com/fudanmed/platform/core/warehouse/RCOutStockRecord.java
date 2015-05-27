package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.common.RCOutStockType;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.warehouse.RCOutStockRecordItem;
import com.fudanmed.platform.core.warehouse.RCProductSpecificationSummary;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.impl.RCOutStockRecordImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCOutStockRecordProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Collection;
import java.util.Date;

@EntityImplementation(implementBy = RCOutStockRecordImpl.class)
public interface RCOutStockRecord extends IModelObject {
  public abstract String getSid();
  
  public abstract RCOutStockRecord setSid(final String sid);
  
  public abstract RCEmployee getOperator();
  
  public abstract RCOutStockRecord setOperator(final RCEmployee operator);
  
  public abstract Date getDate();
  
  public abstract RCOutStockRecord setDate(final Date date);
  
  public abstract String getComment();
  
  public abstract RCOutStockRecord setComment(final String comment);
  
  public abstract RCMaintenanceTeam getTeam();
  
  public abstract RCOutStockRecord setTeam(final RCMaintenanceTeam team);
  
  public abstract RCEmployee getWorker();
  
  public abstract RCOutStockRecord setWorker(final RCEmployee worker);
  
  public abstract RCOutStockType getType();
  
  public abstract RCOutStockRecord setType(final RCOutStockType type);
  
  public abstract Collection<RCOutStockRecordItem> getItems();
  
  public abstract RCOutStockRecordItem createAndAddtoItems();
  
  public abstract RCOutStockRecord removeFromItems(final RCOutStockRecordItem rCOutStockRecordItem);
  
  public abstract RCOutStockRecord removeAllItems();
  
  public abstract RCWarehouse getSourceStore();
  
  public abstract RCOutStockRecord setSourceStore(final RCWarehouse sourceStore);
  
  public abstract Boolean getCommitted();
  
  public abstract RCOutStockRecord setCommitted(final Boolean committed);
  
  public abstract String getTypeName();
  
  public abstract Double getTotalAmount();
  
  public abstract void initItemsFromSummary(final Collection<RCProductSpecificationSummary> summaryItems);
  
  public abstract void commit(final RCEmployee operator);
  
  public abstract RCOutStockRecordProxy toProxy();
}
