package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecordItem;
import com.fudanmed.platform.core.warehouse.RCWorkItemStockStatisticsCriteria;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import java.util.Date;
import org.hibernate.Query;

public class RCWorkItemStockStatisticsCriteriaImpl extends HQLBasedPagedQueryCriteria<RCWorkItemStockRecordItem> implements RCWorkItemStockStatisticsCriteria {
  private Date reportDateFrom;
  
  public Date getReportDateFrom() {
    return this.reportDateFrom;
  }
  
  public RCWorkItemStockStatisticsCriteria setReportDateFrom(final Date reportDateFrom) {
    this.reportDateFrom = reportDateFrom;
    return this;			
    
  }
  
  private Date reportDateTo;
  
  public Date getReportDateTo() {
    return this.reportDateTo;
  }
  
  public RCWorkItemStockStatisticsCriteria setReportDateTo(final Date reportDateTo) {
    this.reportDateTo = reportDateTo;
    return this;			
    
  }
  
  private RCMaintenanceTeam team;
  
  public RCMaintenanceTeam getTeam() {
    return this.team;
  }
  
  public RCWorkItemStockStatisticsCriteria setTeam(final RCMaintenanceTeam team) {
    this.team = team;
    return this;			
    
  }
  
  private RCOrganization reportOrg;
  
  public RCOrganization getReportOrg() {
    return this.reportOrg;
  }
  
  public RCWorkItemStockStatisticsCriteria setReportOrg(final RCOrganization reportOrg) {
    this.reportOrg = reportOrg;
    return this;			
    
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.warehouse.impl.RCWorkItemStockRecordItemImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getReportDateFrom()) ){
    	hql += " and (this.record.workItem.groupTask.repairTask.reportDate >= :reportDateFrom)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getReportDateTo()) ){
    	hql += " and (this.record.workItem.groupTask.repairTask.reportDate <= :reportDateTo)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getReportOrg()) ){
    	hql += " and (this.record.workItem.groupTask.repairTask.reportOrg = :reportOrg)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getTeam()) ){
    	hql += " and (this.record.workItem.groupTask.team = :team)" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    addOrder("this.record.date",edu.fudan.mylang.pf.query.OrderItem.DESC);
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getReportDateFrom())){
    	query.setParameter("reportDateFrom",getReportDateFrom()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getReportDateTo())){
    	query.setParameter("reportDateTo",getReportDateTo()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getTeam())){
    	query.setParameter("team",getTeam()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getReportOrg())){
    	query.setParameter("reportOrg",getReportOrg()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public RCWorkItemStockStatisticsCriteriaImpl() {
    initOrderBys();
  }
}
