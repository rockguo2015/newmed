package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCOutStockRecord;
import com.fudanmed.platform.core.warehouse.RCRecordItem;
import com.fudanmed.platform.core.warehouse.impl.RCOutStockRecordItemImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCOutStockRecordItemProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;

@EntityImplementation(implementBy = RCOutStockRecordItemImpl.class)
public interface RCOutStockRecordItem extends IModelObject {
  public abstract RCRecordItem getRecordItem();
  
  public abstract RCOutStockRecordItem setRecordItem(final RCRecordItem recordItem);
  
  public abstract RCOutStockRecord getRecord();
  
  public abstract RCOutStockRecordItem setRecord(final RCOutStockRecord record);
  
  public abstract RCOutStockRecordItemProxy toProxy();
}
