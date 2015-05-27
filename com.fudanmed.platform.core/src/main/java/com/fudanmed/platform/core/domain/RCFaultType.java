package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.common.RCFaultLevel;
import com.fudanmed.platform.core.common.RCWorkType;
import com.fudanmed.platform.core.domain.RCMaintenamceType;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.impl.RCFaultTypeImpl;
import com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IHasSimplePy;
import edu.fudan.mylang.pf.IModelObject;

@EntityImplementation(implementBy = RCFaultTypeImpl.class)
public interface RCFaultType extends IModelObject, IHasSimplePy {
  public abstract RCMaintenamceType getMtype();
  
  public abstract RCFaultType setMtype(final RCMaintenamceType mtype);
  
  public abstract String getMtypePath();
  
  public abstract RCFaultType setMtypePath(final String mtypePath);
  
  public abstract String getName();
  
  public abstract RCFaultType setName(final String name);
  
  public abstract Boolean getNeedAudit();
  
  public abstract RCFaultType setNeedAudit(final Boolean needAudit);
  
  public abstract Double getStandardCostTime();
  
  public abstract RCFaultType setStandardCostTime(final Double standardCostTime);
  
  public abstract Double getPerformanceWeight();
  
  public abstract RCFaultType setPerformanceWeight(final Double performanceWeight);
  
  public abstract RCFaultLevel getFaultRiskLevel();
  
  public abstract RCFaultType setFaultRiskLevel(final RCFaultLevel faultRiskLevel);
  
  public abstract RCMaintenanceTeam getTeam();
  
  public abstract RCFaultType setTeam(final RCMaintenanceTeam team);
  
  public abstract String getSimplePy();
  
  public abstract RCFaultType setSimplePy(final String simplePy);
  
  public abstract RCWorkType getWorkType();
  
  public abstract RCFaultType setWorkType(final RCWorkType workType);
  
  public abstract String getEntityName();
  
  public abstract String getNameField();
  
  public abstract void buildPath();
  
  public abstract RCFaultTypeProxy toProxy();
}
