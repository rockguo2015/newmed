package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCRepairTaskStatisticCriteria;
import com.fudanmed.platform.core.domain.RCRepairTaskStatus;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import java.util.Date;
import org.hibernate.Query;

public class RCRepairTaskStatisticCriteriaImpl extends HQLBasedPagedQueryCriteria<RCRepairTask> implements RCRepairTaskStatisticCriteria {
  private RCOrganization reportOrg;
  
  public RCOrganization getReportOrg() {
    return this.reportOrg;
  }
  
  public RCRepairTaskStatisticCriteria setReportOrg(final RCOrganization reportOrg) {
    this.reportOrg = reportOrg;
    return this;			
    
  }
  
  private RCMaintenanceTeam team;
  
  public RCMaintenanceTeam getTeam() {
    return this.team;
  }
  
  public RCRepairTaskStatisticCriteria setTeam(final RCMaintenanceTeam team) {
    this.team = team;
    return this;			
    
  }
  
  private RCEmployee worker;
  
  public RCEmployee getWorker() {
    return this.worker;
  }
  
  public RCRepairTaskStatisticCriteria setWorker(final RCEmployee worker) {
    this.worker = worker;
    return this;			
    
  }
  
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public RCRepairTaskStatisticCriteria setComment(final String comment) {
    this.comment = comment;
    return this;			
    
  }
  
  private RCRepairTaskStatus status;
  
  public RCRepairTaskStatus getStatus() {
    return this.status;
  }
  
  public RCRepairTaskStatisticCriteria setStatus(final RCRepairTaskStatus status) {
    this.status = status;
    return this;			
    
  }
  
  private Date reportDateFrom;
  
  public Date getReportDateFrom() {
    return this.reportDateFrom;
  }
  
  public RCRepairTaskStatisticCriteria setReportDateFrom(final Date reportDateFrom) {
    this.reportDateFrom = reportDateFrom;
    return this;			
    
  }
  
  private Date reportDateTo;
  
  public Date getReportDateTo() {
    return this.reportDateTo;
  }
  
  public RCRepairTaskStatisticCriteria setReportDateTo(final Date reportDateTo) {
    this.reportDateTo = reportDateTo;
    return this;			
    
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.domain.impl.RCRepairTaskImpl this  left join  this.groupTasks as groupTask  left join  groupTask.tasks as workItem  left join  workItem.workers as worker ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getComment()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getComment()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getComment()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getComment()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getComment()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getComment()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getComment()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getComment()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getComment()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getComment()) ){
    	hql += " and ((((((((((this.reporterName  LIKE :comment) or (this.reportOrg.name  LIKE :comment)) or (this.operator.name  LIKE :comment)) or (this.faultType.name  LIKE :comment)) or (this.faultReportSource.name  LIKE :comment)) or (this.faultLevel.name  LIKE :comment)) or (this.faultEmergencyLevel.name  LIKE :comment)) or (this.comment  LIKE :comment)) or (this.reportSid  LIKE :comment)) or (this.location  LIKE :comment))" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getReportOrg()) ){
    	hql += " and (this.reportOrg = :reportOrg)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getWorker()) ){
    	hql += " and (worker = :worker)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getTeam()) ){
    	hql += " and (groupTask.team = :team)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getReportDateFrom()) ){
    	hql += " and (this.reportDate >= :reportDateFrom)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getReportDateTo()) ){
    	hql += " and (this.reportDate <= :reportDateTo)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getStatus()) ){
    	hql += " and (this.Status = :status)" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    addOrder("this.reportTime",edu.fudan.mylang.pf.query.OrderItem.DESC);
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getReportOrg())){
    	query.setParameter("reportOrg",getReportOrg()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getTeam())){
    	query.setParameter("team",getTeam()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getWorker())){
    	query.setParameter("worker",getWorker()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getComment())){
    	query.setParameter("comment",getComment()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getStatus())){
    	query.setParameter("status",getStatus()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getReportDateFrom())){
    	query.setParameter("reportDateFrom",getReportDateFrom()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getReportDateTo())){
    	query.setParameter("reportDateTo",getReportDateTo()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return true;
  }
  
  public RCRepairTaskStatisticCriteriaImpl() {
    initOrderBys();
  }
}
