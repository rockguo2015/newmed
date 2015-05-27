package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCOutStockRecord;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductSpecificationSummary;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary;
import com.fudanmed.platform.core.warehouse.RCStockTakingRecord;
import com.fudanmed.platform.core.warehouse.RCTransferRecord;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.RCWorkItemOutStockRecord;
import com.fudanmed.platform.core.warehouse.RCWorkItemReturnStockRecord;
import com.fudanmed.platform.core.warehouse.RCWorkItemStorage;
import edu.fudan.mylang.pf.IBaseService;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public interface RCWarehouseService extends IBaseService {
  public abstract RCWarehouse getMajorWarehouse();
  
  public abstract Collection<RCWarehouse> getSubWarehouses();
  
  public abstract RCProductWarehouseStorageSummary findOrCreateSummaryData(final RCWarehouse store, final RCProductSpecification productSpec);
  
  public abstract RCTransferRecord createTransferRecord(final Procedure1<? super RCTransferRecord> preinit);
  
  public abstract RCWorkItemOutStockRecord createWorkItemOutStockRecord(final Procedure1<? super RCWorkItemOutStockRecord> preinit);
  
  public abstract RCWorkItemReturnStockRecord createWorkItemReturnStockRecord(final Procedure1<? super RCWorkItemReturnStockRecord> preinit);
  
  public abstract RCOutStockRecord createOutStockRecord(final Procedure1<? super RCOutStockRecord> preinit);
  
  public abstract RCStockTakingRecord createStockTakingRecord(final Procedure1<? super RCStockTakingRecord> preinit);
  
  public abstract Collection<RCProductSpecificationSummary> getProductSpecificationSummary(final Collection<RCWorkItemStorage> workItemStorages);
}
