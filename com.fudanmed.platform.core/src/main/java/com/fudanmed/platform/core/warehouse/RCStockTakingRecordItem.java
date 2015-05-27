package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCRecordItem;
import com.fudanmed.platform.core.warehouse.RCStockTakingRecord;
import com.fudanmed.platform.core.warehouse.impl.RCStockTakingRecordItemImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingRecordItemProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;

@EntityImplementation(implementBy = RCStockTakingRecordItemImpl.class)
public interface RCStockTakingRecordItem extends IModelObject {
  public abstract RCRecordItem getRecordItem();
  
  public abstract RCStockTakingRecordItem setRecordItem(final RCRecordItem recordItem);
  
  public abstract RCStockTakingRecord getRecord();
  
  public abstract RCStockTakingRecordItem setRecord(final RCStockTakingRecord record);
  
  public abstract RCStockTakingRecordItemProxy toProxy();
}
