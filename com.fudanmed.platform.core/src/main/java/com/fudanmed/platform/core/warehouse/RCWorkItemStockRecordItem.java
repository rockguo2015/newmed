package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCRecordItem;
import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecord;
import com.fudanmed.platform.core.warehouse.impl.RCWorkItemStockRecordItemImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStockRecordItemProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;

@EntityImplementation(implementBy = RCWorkItemStockRecordItemImpl.class)
public interface RCWorkItemStockRecordItem extends IModelObject {
  public abstract RCRecordItem getRecordItem();
  
  public abstract RCWorkItemStockRecordItem setRecordItem(final RCRecordItem recordItem);
  
  public abstract RCWorkItemStockRecord getRecord();
  
  public abstract RCWorkItemStockRecordItem setRecord(final RCWorkItemStockRecord record);
  
  public abstract RCWorkItemStockRecordItemProxy toProxy();
}
