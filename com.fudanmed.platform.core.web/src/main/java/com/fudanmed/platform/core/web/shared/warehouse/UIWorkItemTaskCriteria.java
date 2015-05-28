package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;

public class UIWorkItemTaskCriteria implements IsSerializable, IPagedCriteria {
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public void setSid(final String sid) {
    this.sid = sid;
  }
  
  public final static String P_Sid = "sid";
  
  public static IObjectFieldAccessor<UIWorkItemTaskCriteria,String> SidAccessor = new IObjectFieldAccessor<UIWorkItemTaskCriteria,String>(){
    				public String getValue(UIWorkItemTaskCriteria object){
    					return object.getSid();
    				}
    				public void setValue(UIWorkItemTaskCriteria object,String value){
    					object.setSid(value);
    				}
    			};
  
  private Boolean showAll;
  
  public Boolean getShowAll() {
    return this.showAll;
  }
  
  public void setShowAll(final Boolean showAll) {
    this.showAll = showAll;
  }
  
  public final static String P_ShowAll = "showAll";
  
  public static IObjectFieldAccessor<UIWorkItemTaskCriteria,Boolean> ShowAllAccessor = new IObjectFieldAccessor<UIWorkItemTaskCriteria,Boolean>(){
    				public Boolean getValue(UIWorkItemTaskCriteria object){
    					return object.getShowAll();
    				}
    				public void setValue(UIWorkItemTaskCriteria object,Boolean value){
    					object.setShowAll(value);
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
  
  public static IObjectFieldAccessor<UIWorkItemTaskCriteria,RCMaintenanceTeamProxy> TeamAccessor = new IObjectFieldAccessor<UIWorkItemTaskCriteria,RCMaintenanceTeamProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy getValue(UIWorkItemTaskCriteria object){
    					return object.getTeam();
    				}
    				public void setValue(UIWorkItemTaskCriteria object,com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy value){
    					object.setTeam(value);
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
