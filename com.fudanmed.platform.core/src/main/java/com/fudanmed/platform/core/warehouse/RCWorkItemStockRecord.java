package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecordItem;
import com.fudanmed.platform.core.warehouse.impl.RCWorkItemStockRecordImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStockRecordProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Collection;
import java.util.Date;

@EntityImplementation(implementBy = RCWorkItemStockRecordImpl.class)
public interface RCWorkItemStockRecord extends IModelObject {
  public abstract String getSid();
  
  public abstract RCWorkItemStockRecord setSid(final String sid);
  
  public abstract RCEmployee getOperator();
  
  public abstract RCWorkItemStockRecord setOperator(final RCEmployee operator);
  
  public abstract Date getDate();
  
  public abstract RCWorkItemStockRecord setDate(final Date date);
  
  public abstract String getComment();
  
  public abstract RCWorkItemStockRecord setComment(final String comment);
  
  public abstract RCWorkItemTask getWorkItem();
  
  public abstract RCWorkItemStockRecord setWorkItem(final RCWorkItemTask workItem);
  
  public abstract Collection<RCWorkItemStockRecordItem> getItems();
  
  public abstract RCWorkItemStockRecordItem createAndAddtoItems();
  
  public abstract RCWorkItemStockRecord removeFromItems(final RCWorkItemStockRecordItem rCWorkItemStockRecordItem);
  
  public abstract RCWorkItemStockRecord removeAllItems();
  
  public abstract RCWarehouse getSourceStore();
  
  public abstract RCWorkItemStockRecord setSourceStore(final RCWarehouse sourceStore);
  
  public abstract Boolean getCommitted();
  
  public abstract RCWorkItemStockRecord setCommitted(final Boolean committed);
  
  public abstract String getTypeName();
  
  public abstract Double getTotalAmount();
  
  public abstract RCWorkItemStockRecordProxy toProxy();
}
