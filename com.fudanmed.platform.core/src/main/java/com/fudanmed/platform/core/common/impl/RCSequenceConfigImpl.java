package com.fudanmed.platform.core.common.impl;

import com.fudanmed.platform.core.common.RCSequenceConfig;
import com.fudanmed.platform.core.common.proxy.RCSequenceConfigProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Date;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCSEQUENCECONFIG_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcsequenceconfig")
public class RCSequenceConfigImpl extends BaseModelObject implements RCSequenceConfig {
  public RCSequenceConfigImpl() {
    super();
  }
  
  private Date sequenceDate;
  
  public Date getSequenceDate() {
    return this.sequenceDate;
  }
  
  public RCSequenceConfig setSequenceDate(final Date sequenceDate) {
    this.sequenceDate = sequenceDate;
    return this;			
    
  }
  
  private Integer inStockSequence;
  
  public Integer getInStockSequence() {
    return this.inStockSequence;
  }
  
  public RCSequenceConfig setInStockSequence(final Integer inStockSequence) {
    this.inStockSequence = inStockSequence;
    return this;			
    
  }
  
  private Integer outStockSequence;
  
  public Integer getOutStockSequence() {
    return this.outStockSequence;
  }
  
  public RCSequenceConfig setOutStockSequence(final Integer outStockSequence) {
    this.outStockSequence = outStockSequence;
    return this;			
    
  }
  
  private Integer stockTakingSequence;
  
  public Integer getStockTakingSequence() {
    return this.stockTakingSequence;
  }
  
  public RCSequenceConfig setStockTakingSequence(final Integer stockTakingSequence) {
    this.stockTakingSequence = stockTakingSequence;
    return this;			
    
  }
  
  private Integer workitemOutStockSequence;
  
  public Integer getWorkitemOutStockSequence() {
    return this.workitemOutStockSequence;
  }
  
  public RCSequenceConfig setWorkitemOutStockSequence(final Integer workitemOutStockSequence) {
    this.workitemOutStockSequence = workitemOutStockSequence;
    return this;			
    
  }
  
  private Integer workitemReturnStockSequence;
  
  public Integer getWorkitemReturnStockSequence() {
    return this.workitemReturnStockSequence;
  }
  
  public RCSequenceConfig setWorkitemReturnStockSequence(final Integer workitemReturnStockSequence) {
    this.workitemReturnStockSequence = workitemReturnStockSequence;
    return this;			
    
  }
  
  private Integer transferSequence;
  
  public Integer getTransferSequence() {
    return this.transferSequence;
  }
  
  public RCSequenceConfig setTransferSequence(final Integer transferSequence) {
    this.transferSequence = transferSequence;
    return this;			
    
  }
  
  private Integer workItemTaskSequence;
  
  public Integer getWorkItemTaskSequence() {
    return this.workItemTaskSequence;
  }
  
  public RCSequenceConfig setWorkItemTaskSequence(final Integer workItemTaskSequence) {
    this.workItemTaskSequence = workItemTaskSequence;
    return this;			
    
  }
  
  private Integer repairTaskSequence;
  
  public Integer getRepairTaskSequence() {
    return this.repairTaskSequence;
  }
  
  public RCSequenceConfig setRepairTaskSequence(final Integer repairTaskSequence) {
    this.repairTaskSequence = repairTaskSequence;
    return this;			
    
  }
  
  private Integer settlementSequence;
  
  public Integer getSettlementSequence() {
    return this.settlementSequence;
  }
  
  public RCSequenceConfig setSettlementSequence(final Integer settlementSequence) {
    this.settlementSequence = settlementSequence;
    return this;			
    
  }
  
  private Integer pmWorkItemSequence;
  
  public Integer getPmWorkItemSequence() {
    return this.pmWorkItemSequence;
  }
  
  public RCSequenceConfig setPmWorkItemSequence(final Integer pmWorkItemSequence) {
    this.pmWorkItemSequence = pmWorkItemSequence;
    return this;			
    
  }
  
  private Integer centerilzedTaskSequence;
  
  public Integer getCenterilzedTaskSequence() {
    return this.centerilzedTaskSequence;
  }
  
  public RCSequenceConfig setCenterilzedTaskSequence(final Integer centerilzedTaskSequence) {
    this.centerilzedTaskSequence = centerilzedTaskSequence;
    return this;			
    
  }
  
  public static RCSequenceConfig create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.common.RCSequenceConfig rCSequenceConfig = new com.fudanmed.platform.core.common.impl.RCSequenceConfigImpl(
    );
    objectFactory.create(rCSequenceConfig);
    return rCSequenceConfig;			
    
  }
  
  public RCSequenceConfigProxy toProxy() {
    com.fudanmed.platform.core.common.proxy.RCSequenceConfigProxy proxy = new com.fudanmed.platform.core.common.proxy.RCSequenceConfigProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
