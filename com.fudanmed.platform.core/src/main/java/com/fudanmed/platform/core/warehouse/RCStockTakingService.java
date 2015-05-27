package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.warehouse.RCStockTakingList;
import com.fudanmed.platform.core.warehouse.RCStockTakingStatus;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import edu.fudan.mylang.pf.IBaseService;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

public interface RCStockTakingService extends IBaseService {
  public abstract RCStockTakingStatus getStockTakingStatus(final RCWarehouse warehouse);
  
  public abstract Boolean canPerformStockOperation(final RCWarehouse warehouse);
  
  /**
   * 开始盘点时生成盘点单
   */
  public abstract RCStockTakingList startStockTaking(final Function1<? super RCStockTakingList,? extends RCStockTakingList> preInit);
  
  public abstract void commitStockTaking(final RCStockTakingList stockTakingList, final RCEmployee operator);
  
  public abstract void cancelStockTaking(final RCStockTakingList stockTakingList);
}
