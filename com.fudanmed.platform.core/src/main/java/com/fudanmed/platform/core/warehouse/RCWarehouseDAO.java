package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import edu.fudan.mylang.pf.IDAOService;
import java.util.Collection;

public interface RCWarehouseDAO extends IDAOService<RCWarehouse> {
  public abstract Collection<RCWarehouse> findManagedWarehouse(final RCEmployee employee);
  
  public abstract Collection<RCWarehouse> findManagedWarehouse();
}
