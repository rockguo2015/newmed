package com.fudanmed.platform.core.web.shared.device;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemStatue;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;
import java.util.Collection;
import java.util.Date;

public class UIPMWorkItemCriteria implements IsSerializable, IPagedCriteria {
  private Date assignDateFrom;
  
  public Date getAssignDateFrom() {
    return this.assignDateFrom;
  }
  
  public void setAssignDateFrom(final Date assignDateFrom) {
    this.assignDateFrom = assignDateFrom;
  }
  
  public final static String P_AssignDateFrom = "assignDateFrom";
  
  public static IObjectFieldAccessor<UIPMWorkItemCriteria,Date> AssignDateFromAccessor = new IObjectFieldAccessor<UIPMWorkItemCriteria,Date>(){
    				public java.util.Date getValue(UIPMWorkItemCriteria object){
    					return object.getAssignDateFrom();
    				}
    				public void setValue(UIPMWorkItemCriteria object,java.util.Date value){
    					object.setAssignDateFrom(value);
    				}
    			};
  
  private Date assignDateTo;
  
  public Date getAssignDateTo() {
    return this.assignDateTo;
  }
  
  public void setAssignDateTo(final Date assignDateTo) {
    this.assignDateTo = assignDateTo;
  }
  
  public final static String P_AssignDateTo = "assignDateTo";
  
  public static IObjectFieldAccessor<UIPMWorkItemCriteria,Date> AssignDateToAccessor = new IObjectFieldAccessor<UIPMWorkItemCriteria,Date>(){
    				public java.util.Date getValue(UIPMWorkItemCriteria object){
    					return object.getAssignDateTo();
    				}
    				public void setValue(UIPMWorkItemCriteria object,java.util.Date value){
    					object.setAssignDateTo(value);
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
  
  public static IObjectFieldAccessor<UIPMWorkItemCriteria,RCMaintenanceTeamProxy> TeamAccessor = new IObjectFieldAccessor<UIPMWorkItemCriteria,RCMaintenanceTeamProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy getValue(UIPMWorkItemCriteria object){
    					return object.getTeam();
    				}
    				public void setValue(UIPMWorkItemCriteria object,com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy value){
    					object.setTeam(value);
    				}
    			};
  
  private UIPMWorkItemStatue status;
  
  public UIPMWorkItemStatue getStatus() {
    return this.status;
  }
  
  public void setStatus(final UIPMWorkItemStatue status) {
    this.status = status;
  }
  
  public final static String P_Status = "status";
  
  public static IObjectFieldAccessor<UIPMWorkItemCriteria,UIPMWorkItemStatue> StatusAccessor = new IObjectFieldAccessor<UIPMWorkItemCriteria,UIPMWorkItemStatue>(){
    				public com.fudanmed.platform.core.web.shared.device.UIPMWorkItemStatue getValue(UIPMWorkItemCriteria object){
    					return object.getStatus();
    				}
    				public void setValue(UIPMWorkItemCriteria object,com.fudanmed.platform.core.web.shared.device.UIPMWorkItemStatue value){
    					object.setStatus(value);
    				}
    			};
  
  private Boolean includeFinishedItems;
  
  public Boolean getIncludeFinishedItems() {
    return this.includeFinishedItems;
  }
  
  public void setIncludeFinishedItems(final Boolean includeFinishedItems) {
    this.includeFinishedItems = includeFinishedItems;
  }
  
  public final static String P_IncludeFinishedItems = "includeFinishedItems";
  
  public static IObjectFieldAccessor<UIPMWorkItemCriteria,Boolean> IncludeFinishedItemsAccessor = new IObjectFieldAccessor<UIPMWorkItemCriteria,Boolean>(){
    				public Boolean getValue(UIPMWorkItemCriteria object){
    					return object.getIncludeFinishedItems();
    				}
    				public void setValue(UIPMWorkItemCriteria object,Boolean value){
    					object.setIncludeFinishedItems(value);
    				}
    			};
  
  private Collection<?> teams;
  
  public Collection<?> getTeams() {
    return this.teams;
  }
  
  public void setTeams(final Collection<?> teams) {
    this.teams = teams;
  }
  
  public final static String P_Teams = "teams";
  
  public static IObjectFieldAccessor<UIPMWorkItemCriteria,Collection<?>> TeamsAccessor = new IObjectFieldAccessor<UIPMWorkItemCriteria,Collection<?>>(){
    				public java.util.Collection<?> getValue(UIPMWorkItemCriteria object){
    					return object.getTeams();
    				}
    				public void setValue(UIPMWorkItemCriteria object,java.util.Collection<?> value){
    					object.setTeams(value);
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
