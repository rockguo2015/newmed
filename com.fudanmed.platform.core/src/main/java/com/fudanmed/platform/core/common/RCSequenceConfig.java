package com.fudanmed.platform.core.common;

import com.fudanmed.platform.core.common.impl.RCSequenceConfigImpl;
import com.fudanmed.platform.core.common.proxy.RCSequenceConfigProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Date;

@EntityImplementation(implementBy = RCSequenceConfigImpl.class)
public interface RCSequenceConfig extends IModelObject {
  public abstract Date getSequenceDate();
  
  public abstract RCSequenceConfig setSequenceDate(final Date sequenceDate);
  
  public abstract Integer getInStockSequence();
  
  public abstract RCSequenceConfig setInStockSequence(final Integer inStockSequence);
  
  public abstract Integer getOutStockSequence();
  
  public abstract RCSequenceConfig setOutStockSequence(final Integer outStockSequence);
  
  public abstract Integer getStockTakingSequence();
  
  public abstract RCSequenceConfig setStockTakingSequence(final Integer stockTakingSequence);
  
  public abstract Integer getWorkitemOutStockSequence();
  
  public abstract RCSequenceConfig setWorkitemOutStockSequence(final Integer workitemOutStockSequence);
  
  public abstract Integer getWorkitemReturnStockSequence();
  
  public abstract RCSequenceConfig setWorkitemReturnStockSequence(final Integer workitemReturnStockSequence);
  
  public abstract Integer getTransferSequence();
  
  public abstract RCSequenceConfig setTransferSequence(final Integer transferSequence);
  
  public abstract Integer getWorkItemTaskSequence();
  
  public abstract RCSequenceConfig setWorkItemTaskSequence(final Integer workItemTaskSequence);
  
  public abstract Integer getRepairTaskSequence();
  
  public abstract RCSequenceConfig setRepairTaskSequence(final Integer repairTaskSequence);
  
  public abstract Integer getSettlementSequence();
  
  public abstract RCSequenceConfig setSettlementSequence(final Integer settlementSequence);
  
  public abstract Integer getPmWorkItemSequence();
  
  public abstract RCSequenceConfig setPmWorkItemSequence(final Integer pmWorkItemSequence);
  
  public abstract Integer getCenterilzedTaskSequence();
  
  public abstract RCSequenceConfig setCenterilzedTaskSequence(final Integer centerilzedTaskSequence);
  
  public abstract RCSequenceConfigProxy toProxy();
}
