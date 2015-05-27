package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.impl.RCStockTakingStatusImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingStatusProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;

@EntityImplementation(implementBy = RCStockTakingStatusImpl.class)
public interface RCStockTakingStatus extends IModelObject {
  public abstract Boolean getIsInStockTaking();
  
  public abstract RCStockTakingStatus setIsInStockTaking(final Boolean isInStockTaking);
  
  public abstract RCWarehouse getWarehouse();
  
  public abstract RCStockTakingStatus setWarehouse(final RCWarehouse warehouse);
  
  public abstract RCStockTakingStatusProxy toProxy();
}
