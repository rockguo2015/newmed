package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatus;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;
import java.util.Date;

public class UIRepairTask4SettlementCriteria implements IsSerializable, IPagedCriteria {
  private Boolean hasMadeSettlement;
  
  public Boolean getHasMadeSettlement() {
    return this.hasMadeSettlement;
  }
  
  public void setHasMadeSettlement(final Boolean hasMadeSettlement) {
    this.hasMadeSettlement = hasMadeSettlement;
  }
  
  public final static String P_HasMadeSettlement = "hasMadeSettlement";
  
  public static IObjectFieldAccessor<UIRepairTask4SettlementCriteria,Boolean> HasMadeSettlementAccessor = new IObjectFieldAccessor<UIRepairTask4SettlementCriteria,Boolean>(){
    				public Boolean getValue(UIRepairTask4SettlementCriteria object){
    					return object.getHasMadeSettlement();
    				}
    				public void setValue(UIRepairTask4SettlementCriteria object,Boolean value){
    					object.setHasMadeSettlement(value);
    				}
    			};
  
  private UIRepairTaskStatus closeStatus;
  
  public UIRepairTaskStatus getCloseStatus() {
    return this.closeStatus;
  }
  
  public void setCloseStatus(final UIRepairTaskStatus closeStatus) {
    this.closeStatus = closeStatus;
  }
  
  public final static String P_CloseStatus = "closeStatus";
  
  public static IObjectFieldAccessor<UIRepairTask4SettlementCriteria,UIRepairTaskStatus> CloseStatusAccessor = new IObjectFieldAccessor<UIRepairTask4SettlementCriteria,UIRepairTaskStatus>(){
    				public com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatus getValue(UIRepairTask4SettlementCriteria object){
    					return object.getCloseStatus();
    				}
    				public void setValue(UIRepairTask4SettlementCriteria object,com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatus value){
    					object.setCloseStatus(value);
    				}
    			};
  
  private Date finishDateFrom;
  
  public Date getFinishDateFrom() {
    return this.finishDateFrom;
  }
  
  public void setFinishDateFrom(final Date finishDateFrom) {
    this.finishDateFrom = finishDateFrom;
  }
  
  public final static String P_FinishDateFrom = "finishDateFrom";
  
  public static IObjectFieldAccessor<UIRepairTask4SettlementCriteria,Date> FinishDateFromAccessor = new IObjectFieldAccessor<UIRepairTask4SettlementCriteria,Date>(){
    				public java.util.Date getValue(UIRepairTask4SettlementCriteria object){
    					return object.getFinishDateFrom();
    				}
    				public void setValue(UIRepairTask4SettlementCriteria object,java.util.Date value){
    					object.setFinishDateFrom(value);
    				}
    			};
  
  private Date finishDateTo;
  
  public Date getFinishDateTo() {
    return this.finishDateTo;
  }
  
  public void setFinishDateTo(final Date finishDateTo) {
    this.finishDateTo = finishDateTo;
  }
  
  public final static String P_FinishDateTo = "finishDateTo";
  
  public static IObjectFieldAccessor<UIRepairTask4SettlementCriteria,Date> FinishDateToAccessor = new IObjectFieldAccessor<UIRepairTask4SettlementCriteria,Date>(){
    				public java.util.Date getValue(UIRepairTask4SettlementCriteria object){
    					return object.getFinishDateTo();
    				}
    				public void setValue(UIRepairTask4SettlementCriteria object,java.util.Date value){
    					object.setFinishDateTo(value);
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
  
  public static IObjectFieldAccessor<UIRepairTask4SettlementCriteria,RCMaintenanceTeamProxy> TeamAccessor = new IObjectFieldAccessor<UIRepairTask4SettlementCriteria,RCMaintenanceTeamProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy getValue(UIRepairTask4SettlementCriteria object){
    					return object.getTeam();
    				}
    				public void setValue(UIRepairTask4SettlementCriteria object,com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy value){
    					object.setTeam(value);
    				}
    			};
  
  private RCOrganizationProxy reportOrg;
  
  public RCOrganizationProxy getReportOrg() {
    return this.reportOrg;
  }
  
  public void setReportOrg(final RCOrganizationProxy reportOrg) {
    this.reportOrg = reportOrg;
  }
  
  public final static String P_ReportOrg = "reportOrg";
  
  public static IObjectFieldAccessor<UIRepairTask4SettlementCriteria,RCOrganizationProxy> ReportOrgAccessor = new IObjectFieldAccessor<UIRepairTask4SettlementCriteria,RCOrganizationProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy getValue(UIRepairTask4SettlementCriteria object){
    					return object.getReportOrg();
    				}
    				public void setValue(UIRepairTask4SettlementCriteria object,com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy value){
    					object.setReportOrg(value);
    				}
    			};
  
  private Integer page;
  
  public Integer getPage() {
    return this.page;
  }
  
  public void setPage(final Integer page) {
    this.page = page;
  }
  
  private Integer pageSize;
  
  public Integer getPageSize() {
    return this.pageSize;
  }
  
  public void setPageSize(final Integer pageSize) {
    this.pageSize = pageSize;
  }
}
