package com.fudanmed.platform.core.common;

import com.fudanmed.platform.core.common.RCSequenceConfig;
import edu.fudan.mylang.pf.IBaseService;

public interface RCSequenceService extends IBaseService {
  public abstract String getNextInStockSequence();
  
  public abstract String getNextOutStockSequence();
  
  public abstract String getNextStockTakingSequence();
  
  public abstract String getNextWorkItemTaskSequence();
  
  public abstract String getNextRepairTaskSequence();
  
  public abstract String getNextWorkitemOutStockSequence();
  
  public abstract String getNextWorkitemReturnStockSequence();
  
  public abstract String getNextTransferSequence();
  
  public abstract String getNextSettlementSequence();
  
  public abstract String getNextPMWorkItemSequence();
  
  public abstract String getNextCenterilzedTaskSequence();
  
  public abstract RCSequenceConfig computeConfig();
}
