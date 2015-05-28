package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIGroupTaskStatByTeamCriteriaData implements IsSerializable {
  private Long cnt;
  
  public Long getCnt() {
    return this.cnt;
  }
  
  public void setCnt(final Long cnt) {
    this.cnt = cnt;
  }
  
  public final static String P_Cnt = "cnt";
  
  public static IObjectFieldAccessor<UIGroupTaskStatByTeamCriteriaData,Long> CntAccessor = new IObjectFieldAccessor<UIGroupTaskStatByTeamCriteriaData,Long>(){
    				public Long getValue(UIGroupTaskStatByTeamCriteriaData object){
    					return object.getCnt();
    				}
    				public void setValue(UIGroupTaskStatByTeamCriteriaData object,Long value){
    					object.setCnt(value);
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
  
  public static IObjectFieldAccessor<UIGroupTaskStatByTeamCriteriaData,RCMaintenanceTeamProxy> TeamAccessor = new IObjectFieldAccessor<UIGroupTaskStatByTeamCriteriaData,RCMaintenanceTeamProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy getValue(UIGroupTaskStatByTeamCriteriaData object){
    					return object.getTeam();
    				}
    				public void setValue(UIGroupTaskStatByTeamCriteriaData object,com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy value){
    					object.setTeam(value);
    				}
    			};
}
