package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCArrivalTime;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEvaluateState;
import com.fudanmed.platform.core.domain.RCFrequencyProblem;
import com.fudanmed.platform.core.domain.RCRepairQuality;
import com.fudanmed.platform.core.domain.RCServiceAttitude;
import com.fudanmed.platform.core.domain.impl.RCRepairEvaluateImpl;
import com.fudanmed.platform.core.domain.proxy.RCRepairEvaluateProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Date;

@EntityImplementation(implementBy = RCRepairEvaluateImpl.class)
public interface RCRepairEvaluate extends IModelObject {
  public abstract RCEvaluateState getEvaluateState();
  
  public abstract RCRepairEvaluate setEvaluateState(final RCEvaluateState evaluateState);
  
  public abstract RCArrivalTime getArrivalTime();
  
  public abstract RCRepairEvaluate setArrivalTime(final RCArrivalTime arrivalTime);
  
  public abstract RCServiceAttitude getServiceAttitude();
  
  public abstract RCRepairEvaluate setServiceAttitude(final RCServiceAttitude serviceAttitude);
  
  public abstract RCFrequencyProblem getFrequencyProblem();
  
  public abstract RCRepairEvaluate setFrequencyProblem(final RCFrequencyProblem frequencyProblem);
  
  public abstract RCRepairQuality getRepairQuality();
  
  public abstract RCRepairEvaluate setRepairQuality(final RCRepairQuality repairQuality);
  
  public abstract Integer getArrivalTimeValue();
  
  public abstract RCRepairEvaluate setArrivalTimeValue(final Integer arrivalTimeValue);
  
  public abstract Integer getServiceAttitudeValue();
  
  public abstract RCRepairEvaluate setServiceAttitudeValue(final Integer serviceAttitudeValue);
  
  public abstract Integer getFrequencyProblemValue();
  
  public abstract RCRepairEvaluate setFrequencyProblemValue(final Integer frequencyProblemValue);
  
  public abstract Integer getRepairQualityValue();
  
  public abstract RCRepairEvaluate setRepairQualityValue(final Integer repairQualityValue);
  
  public abstract String getComment();
  
  public abstract RCRepairEvaluate setComment(final String comment);
  
  public abstract RCEmployee getEvaluator();
  
  public abstract RCRepairEvaluate setEvaluator(final RCEmployee evaluator);
  
  public abstract Date getReadyDate();
  
  public abstract RCRepairEvaluate setReadyDate(final Date readyDate);
  
  public abstract Date getEvaluateDate();
  
  public abstract RCRepairEvaluate setEvaluateDate(final Date evaluateDate);
  
  public abstract void commit();
  
  public abstract void autoCommit();
  
  public abstract RCRepairEvaluateProxy toProxy();
}
