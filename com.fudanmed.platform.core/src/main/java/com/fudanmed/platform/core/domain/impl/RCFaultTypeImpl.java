package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.common.RCFaultLevel;
import com.fudanmed.platform.core.common.RCWorkType;
import com.fudanmed.platform.core.common.impl.RCFaultLevelImpl;
import com.fudanmed.platform.core.common.impl.RCWorkTypeImpl;
import com.fudanmed.platform.core.domain.RCFaultType;
import com.fudanmed.platform.core.domain.RCMaintenamceType;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.impl.RCMaintenamceTypeImpl;
import com.fudanmed.platform.core.domain.impl.RCMaintenanceTeamImpl;
import com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy;
import com.google.common.base.Objects;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCFAULTTYPE_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcfaulttype")
public class RCFaultTypeImpl extends BaseModelObject implements RCFaultType {
  public RCFaultTypeImpl() {
    super();
  }
  
  public RCFaultTypeImpl(final RCMaintenamceType mtype) {
    super();
    this.mtype = mtype;
  }
  
  @JoinColumn(name = "mtype_id")
  @ManyToOne(targetEntity = RCMaintenamceTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCMaintenamceType mtype;
  
  public RCMaintenamceType getMtype() {
    return this.mtype;
  }
  
  public RCFaultType setMtype(final RCMaintenamceType mtype) {
    this.mtype = mtype;
    return this;			
    
  }
  
  private String mtypePath;
  
  public String getMtypePath() {
    return this.mtypePath;
  }
  
  public RCFaultType setMtypePath(final String mtypePath) {
    this.mtypePath = mtypePath;
    return this;			
    
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public RCFaultType setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  private Boolean needAudit;
  
  public Boolean getNeedAudit() {
    return this.needAudit;
  }
  
  public RCFaultType setNeedAudit(final Boolean needAudit) {
    this.needAudit = needAudit;
    return this;			
    
  }
  
  private Double standardCostTime;
  
  public Double getStandardCostTime() {
    return this.standardCostTime;
  }
  
  public RCFaultType setStandardCostTime(final Double standardCostTime) {
    this.standardCostTime = standardCostTime;
    return this;			
    
  }
  
  private Double performanceWeight;
  
  public Double getPerformanceWeight() {
    return this.performanceWeight;
  }
  
  public RCFaultType setPerformanceWeight(final Double performanceWeight) {
    this.performanceWeight = performanceWeight;
    return this;			
    
  }
  
  @JoinColumn(name = "faultRiskLevel_id")
  @ManyToOne(targetEntity = RCFaultLevelImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCFaultLevel faultRiskLevel;
  
  public RCFaultLevel getFaultRiskLevel() {
    return this.faultRiskLevel;
  }
  
  public RCFaultType setFaultRiskLevel(final RCFaultLevel faultRiskLevel) {
    this.faultRiskLevel = faultRiskLevel;
    return this;			
    
  }
  
  @JoinColumn(name = "team_id")
  @ManyToOne(targetEntity = RCMaintenanceTeamImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCMaintenanceTeam team;
  
  public RCMaintenanceTeam getTeam() {
    return this.team;
  }
  
  public RCFaultType setTeam(final RCMaintenanceTeam team) {
    this.team = team;
    return this;			
    
  }
  
  private String simplePy;
  
  public String getSimplePy() {
    return this.simplePy;
  }
  
  public RCFaultType setSimplePy(final String simplePy) {
    this.simplePy = simplePy;
    return this;			
    
  }
  
  @JoinColumn(name = "workType_id")
  @ManyToOne(targetEntity = RCWorkTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCWorkType workType;
  
  public RCWorkType getWorkType() {
    return this.workType;
  }
  
  public RCFaultType setWorkType(final RCWorkType workType) {
    this.workType = workType;
    return this;			
    
  }
  
  public String getEntityName() {
    return this.name;
  }
  
  public String getNameField() {
    return "name";
  }
  
  public void buildPath() {
    RCMaintenamceType curP = this.mtype;
    String mtypePath = "";
    boolean _notEquals = (!Objects.equal(curP, null));
    boolean _while = _notEquals;
    while (_while) {
      {
        String _plus = (mtypePath + "[");
        Long _id = curP.getId();
        String _plus_1 = (_plus + _id);
        String _plus_2 = (_plus_1 + "]");
        mtypePath = _plus_2;
        RCMaintenamceType _parent = curP.getParent();
        curP = _parent;
      }
      boolean _notEquals_1 = (!Objects.equal(curP, null));
      _while = _notEquals_1;
    }
    this.mtypePath = mtypePath;
  }
  
  public static RCFaultType create(final RCMaintenamceType mtype, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.domain.RCFaultType rCFaultType = new com.fudanmed.platform.core.domain.impl.RCFaultTypeImpl(
    	mtype
    );
    objectFactory.create(rCFaultType);
    return rCFaultType;			
    
  }
  
  public RCFaultTypeProxy toProxy() {
    com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy proxy = new com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
