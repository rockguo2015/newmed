package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCRecordItem;
import com.fudanmed.platform.core.warehouse.RCTransferRecord;
import com.fudanmed.platform.core.warehouse.impl.RCTransferRecordItemImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCTransferRecordItemProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;

@EntityImplementation(implementBy = RCTransferRecordItemImpl.class)
public interface RCTransferRecordItem extends IModelObject {
  public abstract RCTransferRecord getTransferRecord();
  
  public abstract RCTransferRecordItem setTransferRecord(final RCTransferRecord transferRecord);
  
  public abstract RCRecordItem getRecordItem();
  
  public abstract RCTransferRecordItem setRecordItem(final RCRecordItem recordItem);
  
  public abstract RCTransferRecordItemProxy toProxy();
}
