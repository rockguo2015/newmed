package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCArrivalTime;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEvaluateState;
import com.fudanmed.platform.core.domain.RCFrequencyProblem;
import com.fudanmed.platform.core.domain.RCRepairEvaluate;
import com.fudanmed.platform.core.domain.RCRepairQuality;
import com.fudanmed.platform.core.domain.RCServiceAttitude;
import com.fudanmed.platform.core.domain.impl.RCEmployeeImpl;
import com.fudanmed.platform.core.domain.proxy.RCRepairEvaluateProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import edu.fudan.mylang.utils.DateUtil;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCREPAIREVALUATE_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcrepairevaluate")
public class RCRepairEvaluateImpl extends BaseModelObject implements RCRepairEvaluate {
  public RCRepairEvaluateImpl() {
    super();
  }
  
  private RCEvaluateState evaluateState = RCEvaluateState.notReady;
  
  public RCEvaluateState getEvaluateState() {
    return this.evaluateState;
  }
  
  public RCRepairEvaluate setEvaluateState(final RCEvaluateState evaluateState) {
    this.evaluateState = evaluateState;
    return this;			
    
  }
  
  private RCArrivalTime arrivalTime;
  
  public RCArrivalTime getArrivalTime() {
    return this.arrivalTime;
  }
  
  public RCRepairEvaluate setArrivalTime(final RCArrivalTime arrivalTime) {
    this.arrivalTime = arrivalTime;
    return this;			
    
  }
  
  private RCServiceAttitude serviceAttitude;
  
  public RCServiceAttitude getServiceAttitude() {
    return this.serviceAttitude;
  }
  
  public RCRepairEvaluate setServiceAttitude(final RCServiceAttitude serviceAttitude) {
    this.serviceAttitude = serviceAttitude;
    return this;			
    
  }
  
  private RCFrequencyProblem frequencyProblem;
  
  public RCFrequencyProblem getFrequencyProblem() {
    return this.frequencyProblem;
  }
  
  public RCRepairEvaluate setFrequencyProblem(final RCFrequencyProblem frequencyProblem) {
    this.frequencyProblem = frequencyProblem;
    return this;			
    
  }
  
  private RCRepairQuality repairQuality;
  
  public RCRepairQuality getRepairQuality() {
    return this.repairQuality;
  }
  
  public RCRepairEvaluate setRepairQuality(final RCRepairQuality repairQuality) {
    this.repairQuality = repairQuality;
    return this;			
    
  }
  
  private Integer arrivalTimeValue;
  
  public Integer getArrivalTimeValue() {
    return this.arrivalTimeValue;
  }
  
  public RCRepairEvaluate setArrivalTimeValue(final Integer arrivalTimeValue) {
    this.arrivalTimeValue = arrivalTimeValue;
    return this;			
    
  }
  
  private Integer serviceAttitudeValue;
  
  public Integer getServiceAttitudeValue() {
    return this.serviceAttitudeValue;
  }
  
  public RCRepairEvaluate setServiceAttitudeValue(final Integer serviceAttitudeValue) {
    this.serviceAttitudeValue = serviceAttitudeValue;
    return this;			
    
  }
  
  private Integer frequencyProblemValue;
  
  public Integer getFrequencyProblemValue() {
    return this.frequencyProblemValue;
  }
  
  public RCRepairEvaluate setFrequencyProblemValue(final Integer frequencyProblemValue) {
    this.frequencyProblemValue = frequencyProblemValue;
    return this;			
    
  }
  
  private Integer repairQualityValue;
  
  public Integer getRepairQualityValue() {
    return this.repairQualityValue;
  }
  
  public RCRepairEvaluate setRepairQualityValue(final Integer repairQualityValue) {
    this.repairQualityValue = repairQualityValue;
    return this;			
    
  }
  
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public RCRepairEvaluate setComment(final String comment) {
    this.comment = comment;
    return this;			
    
  }
  
  @JoinColumn(name = "evaluator_id")
  @ManyToOne(targetEntity = RCEmployeeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCEmployee evaluator;
  
  public RCEmployee getEvaluator() {
    return this.evaluator;
  }
  
  public RCRepairEvaluate setEvaluator(final RCEmployee evaluator) {
    this.evaluator = evaluator;
    return this;			
    
  }
  
  private Date readyDate;
  
  public Date getReadyDate() {
    return this.readyDate;
  }
  
  public RCRepairEvaluate setReadyDate(final Date readyDate) {
    this.readyDate = readyDate;
    return this;			
    
  }
  
  private Date evaluateDate;
  
  public Date getEvaluateDate() {
    return this.evaluateDate;
  }
  
  public RCRepairEvaluate setEvaluateDate(final Date evaluateDate) {
    this.evaluateDate = evaluateDate;
    return this;			
    
  }
  
  public void commit() {
    this.evaluateState = RCEvaluateState.finished;
  }
  
  public void autoCommit() {
    this.evaluateState = RCEvaluateState.autoCommitted;
    Date _day = DateUtil.today();
    this.evaluateDate = _day;
    this.arrivalTimeValue = Integer.valueOf(5);
    this.serviceAttitudeValue = Integer.valueOf(5);
    this.frequencyProblemValue = Integer.valueOf(5);
    this.repairQualityValue = Integer.valueOf(5);
  }
  
  public static RCRepairEvaluate create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.domain.RCRepairEvaluate rCRepairEvaluate = new com.fudanmed.platform.core.domain.impl.RCRepairEvaluateImpl(
    );
    objectFactory.create(rCRepairEvaluate);
    return rCRepairEvaluate;			
    
  }
  
  public RCRepairEvaluateProxy toProxy() {
    com.fudanmed.platform.core.domain.proxy.RCRepairEvaluateProxy proxy = new com.fudanmed.platform.core.domain.proxy.RCRepairEvaluateProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
