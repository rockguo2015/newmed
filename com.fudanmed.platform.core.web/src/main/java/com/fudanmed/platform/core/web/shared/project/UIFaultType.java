package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy;
import com.fudanmed.platform.core.common.proxy.RCWorkTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIFaultType extends GWTEntity {
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  public final static String P_Name = "name";
  
  public static IObjectFieldAccessor<UIFaultType,String> NameAccessor = new IObjectFieldAccessor<UIFaultType,String>(){
    				public String getValue(UIFaultType object){
    					return object.getName();
    				}
    				public void setValue(UIFaultType object,String value){
    					object.setName(value);
    				}
    			};
  
  private Double standardCostTime;
  
  public Double getStandardCostTime() {
    return this.standardCostTime;
  }
  
  public void setStandardCostTime(final Double standardCostTime) {
    this.standardCostTime = standardCostTime;
  }
  
  public final static String P_StandardCostTime = "standardCostTime";
  
  public static IObjectFieldAccessor<UIFaultType,Double> StandardCostTimeAccessor = new IObjectFieldAccessor<UIFaultType,Double>(){
    				public Double getValue(UIFaultType object){
    					return object.getStandardCostTime();
    				}
    				public void setValue(UIFaultType object,Double value){
    					object.setStandardCostTime(value);
    				}
    			};
  
  private Double performanceWeight;
  
  public Double getPerformanceWeight() {
    return this.performanceWeight;
  }
  
  public void setPerformanceWeight(final Double performanceWeight) {
    this.performanceWeight = performanceWeight;
  }
  
  public final static String P_PerformanceWeight = "performanceWeight";
  
  public static IObjectFieldAccessor<UIFaultType,Double> PerformanceWeightAccessor = new IObjectFieldAccessor<UIFaultType,Double>(){
    				public Double getValue(UIFaultType object){
    					return object.getPerformanceWeight();
    				}
    				public void setValue(UIFaultType object,Double value){
    					object.setPerformanceWeight(value);
    				}
    			};
  
  private RCFaultLevelProxy faultRiskLevel;
  
  public RCFaultLevelProxy getFaultRiskLevel() {
    return this.faultRiskLevel;
  }
  
  public void setFaultRiskLevel(final RCFaultLevelProxy faultRiskLevel) {
    this.faultRiskLevel = faultRiskLevel;
  }
  
  public final static String P_FaultRiskLevel = "faultRiskLevel";
  
  public static IObjectFieldAccessor<UIFaultType,RCFaultLevelProxy> FaultRiskLevelAccessor = new IObjectFieldAccessor<UIFaultType,RCFaultLevelProxy>(){
    				public com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy getValue(UIFaultType object){
    					return object.getFaultRiskLevel();
    				}
    				public void setValue(UIFaultType object,com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy value){
    					object.setFaultRiskLevel(value);
    				}
    			};
  
  private RCMaintenanceTeamProxy team;
  
  public RCMaintenanceTeamProxy getTeam() {
    return this.team;
  }
  
  public void setTeam(final RCMaintenanceTeamProxy team) {
    this.team = team;
  }
  
  public final static String P_Team = "team";
  
  public static IObjectFieldAccessor<UIFaultType,RCMaintenanceTeamProxy> TeamAccessor = new IObjectFieldAccessor<UIFaultType,RCMaintenanceTeamProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy getValue(UIFaultType object){
    					return object.getTeam();
    				}
    				public void setValue(UIFaultType object,com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy value){
    					object.setTeam(value);
    				}
    			};
  
  private RCMaintenamceTypeProxy mtype;
  
  public RCMaintenamceTypeProxy getMtype() {
    return this.mtype;
  }
  
  public void setMtype(final RCMaintenamceTypeProxy mtype) {
    this.mtype = mtype;
  }
  
  public final static String P_Mtype = "mtype";
  
  public static IObjectFieldAccessor<UIFaultType,RCMaintenamceTypeProxy> MtypeAccessor = new IObjectFieldAccessor<UIFaultType,RCMaintenamceTypeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy getValue(UIFaultType object){
    					return object.getMtype();
    				}
    				public void setValue(UIFaultType object,com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy value){
    					object.setMtype(value);
    				}
    			};
  
  private RCWorkTypeProxy workType;
  
  public RCWorkTypeProxy getWorkType() {
    return this.workType;
  }
  
  public void setWorkType(final RCWorkTypeProxy workType) {
    this.workType = workType;
  }
  
  public final static String P_WorkType = "workType";
  
  public static IObjectFieldAccessor<UIFaultType,RCWorkTypeProxy> WorkTypeAccessor = new IObjectFieldAccessor<UIFaultType,RCWorkTypeProxy>(){
    				public com.fudanmed.platform.core.common.proxy.RCWorkTypeProxy getValue(UIFaultType object){
    					return object.getWorkType();
    				}
    				public void setValue(UIFaultType object,com.fudanmed.platform.core.common.proxy.RCWorkTypeProxy value){
    					object.setWorkType(value);
    				}
    			};
  
  private Boolean needAudit;
  
  public Boolean getNeedAudit() {
    return this.needAudit;
  }
  
  public void setNeedAudit(final Boolean needAudit) {
    this.needAudit = needAudit;
  }
  
  public final static String P_NeedAudit = "needAudit";
  
  public static IObjectFieldAccessor<UIFaultType,Boolean> NeedAuditAccessor = new IObjectFieldAccessor<UIFaultType,Boolean>(){
    				public Boolean getValue(UIFaultType object){
    					return object.getNeedAudit();
    				}
    				public void setValue(UIFaultType object,Boolean value){
    					object.setNeedAudit(value);
    				}
    			};
  
  private Boolean inputNext;
  
  public Boolean getInputNext() {
    return this.inputNext;
  }
  
  public void setInputNext(final Boolean inputNext) {
    this.inputNext = inputNext;
  }
  
  public final static String P_InputNext = "inputNext";
  
  public static IObjectFieldAccessor<UIFaultType,Boolean> InputNextAccessor = new IObjectFieldAccessor<UIFaultType,Boolean>(){
    				public Boolean getValue(UIFaultType object){
    					return object.getInputNext();
    				}
    				public void setValue(UIFaultType object,Boolean value){
    					object.setInputNext(value);
    				}
    			};
  
  private String teamName;
  
  public String getTeamName() {
    return this.teamName;
  }
  
  public void setTeamName(final String teamName) {
    this.teamName = teamName;
  }
  
  public final static String P_TeamName = "teamName";
  
  public static IObjectFieldAccessor<UIFaultType,String> TeamNameAccessor = new IObjectFieldAccessor<UIFaultType,String>(){
    				public String getValue(UIFaultType object){
    					return object.getTeamName();
    				}
    				public void setValue(UIFaultType object,String value){
    					object.setTeamName(value);
    				}
    			};
  
  public RCFaultTypeProxy toProxy() {
    return (RCFaultTypeProxy)super.toProxy();
    
  }
}
