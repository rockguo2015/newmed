package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCSettlement;
import edu.fudan.mylang.pf.IBaseService;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public interface RCSettlementService extends IBaseService {
  public abstract RCSettlement createSettlement(final Procedure1<? super RCSettlement> preInit);
  
  public abstract void cancelSettlement(final RCSettlement settlement);
  
  public abstract void attachSettlementItems(final RCSettlement settlement, final Iterable<RCRepairTask> repairTasks);
  
  public abstract void detachSettlementItem(final RCSettlement settlement, final RCRepairTask repairTask);
}
