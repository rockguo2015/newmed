package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.common.RCFaultReportSource;
import com.fudanmed.platform.core.domain.RCGroupTask;
import com.fudanmed.platform.core.domain.RCGroupTaskCriteria;
import com.fudanmed.platform.core.domain.RCGroupTaskStatus;
import com.fudanmed.platform.core.domain.RCOrganization;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.hibernate.Query;

public class RCGroupTaskCriteriaImpl extends HQLBasedPagedQueryCriteria<RCGroupTask> implements RCGroupTaskCriteria {
  private Date dateFrom;
  
  public Date getDateFrom() {
    return this.dateFrom;
  }
  
  public RCGroupTaskCriteria setDateFrom(final Date dateFrom) {
    this.dateFrom = dateFrom;
    return this;			
    
  }
  
  private Date dateTo;
  
  public Date getDateTo() {
    return this.dateTo;
  }
  
  public RCGroupTaskCriteria setDateTo(final Date dateTo) {
    this.dateTo = dateTo;
    return this;			
    
  }
  
  private Boolean includeFinishedTask;
  
  public Boolean getIncludeFinishedTask() {
    return this.includeFinishedTask;
  }
  
  public RCGroupTaskCriteria setIncludeFinishedTask(final Boolean includeFinishedTask) {
    this.includeFinishedTask = includeFinishedTask;
    return this;			
    
  }
  
  private RCGroupTaskStatus finishedStatus;
  
  public RCGroupTaskStatus getFinishedStatus() {
    return this.finishedStatus;
  }
  
  public RCGroupTaskCriteria setFinishedStatus(final RCGroupTaskStatus finishedStatus) {
    this.finishedStatus = finishedStatus;
    return this;			
    
  }
  
  private RCGroupTaskStatus misDispatchedStatus;
  
  public RCGroupTaskStatus getMisDispatchedStatus() {
    return this.misDispatchedStatus;
  }
  
  public RCGroupTaskCriteria setMisDispatchedStatus(final RCGroupTaskStatus misDispatchedStatus) {
    this.misDispatchedStatus = misDispatchedStatus;
    return this;			
    
  }
  
  private RCGroupTaskStatus cancelStatus;
  
  public RCGroupTaskStatus getCancelStatus() {
    return this.cancelStatus;
  }
  
  public RCGroupTaskCriteria setCancelStatus(final RCGroupTaskStatus cancelStatus) {
    this.cancelStatus = cancelStatus;
    return this;			
    
  }
  
  private Collection<Long> teams = new Function0<Collection<Long>>() {
    public Collection<Long> apply() {
      ArrayList<Long> _newArrayList = CollectionLiterals.<Long>newArrayList();
      return _newArrayList;
    }
  }.apply();
  
  public Collection<Long> getTeams() {
    return this.teams;
  }
  
  public RCGroupTaskCriteria setTeams(final Collection<Long> teams) {
    this.teams = teams;
    return this;			
    
  }
  
  private RCGroupTaskStatus status;
  
  public RCGroupTaskStatus getStatus() {
    return this.status;
  }
  
  public RCGroupTaskCriteria setStatus(final RCGroupTaskStatus status) {
    this.status = status;
    return this;			
    
  }
  
  private RCOrganization reportOrg;
  
  public RCOrganization getReportOrg() {
    return this.reportOrg;
  }
  
  public RCGroupTaskCriteria setReportOrg(final RCOrganization reportOrg) {
    this.reportOrg = reportOrg;
    return this;			
    
  }
  
  private RCFaultReportSource faultReportSource;
  
  public RCFaultReportSource getFaultReportSource() {
    return this.faultReportSource;
  }
  
  public RCGroupTaskCriteria setFaultReportSource(final RCFaultReportSource faultReportSource) {
    this.faultReportSource = faultReportSource;
    return this;			
    
  }
  
  private String month;
  
  public String getMonth() {
    return this.month;
  }
  
  public RCGroupTaskCriteria setMonth(final String month) {
    this.month = month;
    return this;			
    
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.domain.impl.RCGroupTaskImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDateFrom()) ){
    	hql += " and (this.date >= :dateFrom)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDateTo()) ){
    	hql += " and (this.date <= :dateTo)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getIncludeFinishedTask()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getFinishedStatus()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getMisDispatchedStatus()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getCancelStatus()) ){
    	hql += " and ((:includeFinishedTask = true) or ((((this.Status <> :finishedStatus) and (this.Status <> :misDispatchedStatus)) and (this.Status <> :cancelStatus))))" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getTeams()) ){
    	hql += " and (this.team.id  IN (:teams))" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getStatus()) ){
    	hql += " and (this.Status = :status)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getReportOrg()) ){
    	hql += " and (this.repairTask.reportOrg = :reportOrg)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getFaultReportSource()) ){
    	hql += " and (this.repairTask.faultReportSource = :faultReportSource)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getMonth()) ){
    	hql += " and (this.month = :month)" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    addOrder("this.time",edu.fudan.mylang.pf.query.OrderItem.DESC);
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDateFrom())){
    	query.setParameter("dateFrom",getDateFrom()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDateTo())){
    	query.setParameter("dateTo",getDateTo()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getIncludeFinishedTask())){
    	query.setParameter("includeFinishedTask",getIncludeFinishedTask()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getFinishedStatus())){
    	query.setParameter("finishedStatus",getFinishedStatus()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getMisDispatchedStatus())){
    	query.setParameter("misDispatchedStatus",getMisDispatchedStatus()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getCancelStatus())){
    	query.setParameter("cancelStatus",getCancelStatus()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getTeams())){
    	query.setParameterList("teams",getTeams()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getStatus())){
    	query.setParameter("status",getStatus()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getReportOrg())){
    	query.setParameter("reportOrg",getReportOrg()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getFaultReportSource())){
    	query.setParameter("faultReportSource",getFaultReportSource()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getMonth())){
    	query.setParameter("month",getMonth()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public RCGroupTaskCriteriaImpl() {
    initOrderBys();
  }
}
