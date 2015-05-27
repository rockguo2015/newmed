package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductSummarySnapshot;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary;
import edu.fudan.mylang.pf.IDAOService;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public interface RCProductSummarySnapshotDAO extends IDAOService<RCProductSummarySnapshot> {
  public abstract RCProductSummarySnapshot createOrFindSnapshot(final Date date, final RCProductWarehouseStorageSummary storageSummary, final Procedure1<? super RCProductSummarySnapshot> init);
  
  public abstract RCProductSummarySnapshot findLastSnapshot(final Date date, final RCProductWarehouseStorageSummary storageSummary);
}
