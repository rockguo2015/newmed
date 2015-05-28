package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;
import java.util.Date;

public class UIWorkItemStockRecordItemStatCriteria implements IsSerializable, IPagedCriteria {
  private Date dateFrom;
  
  public Date getDateFrom() {
    return this.dateFrom;
  }
  
  public void setDateFrom(final Date dateFrom) {
    this.dateFrom = dateFrom;
  }
  
  public final static String P_DateFrom = "dateFrom";
  
  public static IObjectFieldAccessor<UIWorkItemStockRecordItemStatCriteria,Date> DateFromAccessor = new IObjectFieldAccessor<UIWorkItemStockRecordItemStatCriteria,Date>(){
    				public java.util.Date getValue(UIWorkItemStockRecordItemStatCriteria object){
    					return object.getDateFrom();
    				}
    				public void setValue(UIWorkItemStockRecordItemStatCriteria object,java.util.Date value){
    					object.setDateFrom(value);
    				}
    			};
  
  private Date dateTo;
  
  public Date getDateTo() {
    return this.dateTo;
  }
  
  public void setDateTo(final Date dateTo) {
    this.dateTo = dateTo;
  }
  
  public final static String P_DateTo = "dateTo";
  
  public static IObjectFieldAccessor<UIWorkItemStockRecordItemStatCriteria,Date> DateToAccessor = new IObjectFieldAccessor<UIWorkItemStockRecordItemStatCriteria,Date>(){
    				public java.util.Date getValue(UIWorkItemStockRecordItemStatCriteria object){
    					return object.getDateTo();
    				}
    				public void setValue(UIWorkItemStockRecordItemStatCriteria object,java.util.Date value){
    					object.setDateTo(value);
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
  
  public static IObjectFieldAccessor<UIWorkItemStockRecordItemStatCriteria,RCMaintenanceTeamProxy> TeamAccessor = new IObjectFieldAccessor<UIWorkItemStockRecordItemStatCriteria,RCMaintenanceTeamProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy getValue(UIWorkItemStockRecordItemStatCriteria object){
    					return object.getTeam();
    				}
    				public void setValue(UIWorkItemStockRecordItemStatCriteria object,com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy value){
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
