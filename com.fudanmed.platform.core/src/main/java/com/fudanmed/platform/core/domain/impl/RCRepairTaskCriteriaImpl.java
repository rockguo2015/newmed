package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.common.RCFaultReportSource;
import com.fudanmed.platform.core.domain.RCEvaluateState;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCRepairTaskCriteria;
import com.fudanmed.platform.core.domain.RCRepairTaskStatus;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import java.util.Date;
import org.hibernate.Query;

public class RCRepairTaskCriteriaImpl extends HQLBasedPagedQueryCriteria<RCRepairTask> implements RCRepairTaskCriteria {
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public RCRepairTaskCriteria setComment(final String comment) {
    this.comment = comment;
    return this;			
    
  }
  
  private RCOrganization reportOrg;
  
  public RCOrganization getReportOrg() {
    return this.reportOrg;
  }
  
  public RCRepairTaskCriteria setReportOrg(final RCOrganization reportOrg) {
    this.reportOrg = reportOrg;
    return this;			
    
  }
  
  private Boolean includeFinishedTask = Boolean.valueOf(true);
  
  public Boolean getIncludeFinishedTask() {
    return this.includeFinishedTask;
  }
  
  public RCRepairTaskCriteria setIncludeFinishedTask(final Boolean includeFinishedTask) {
    this.includeFinishedTask = includeFinishedTask;
    return this;			
    
  }
  
  private Boolean includeFinishedTask4Reporter = Boolean.valueOf(true);
  
  public Boolean getIncludeFinishedTask4Reporter() {
    return this.includeFinishedTask4Reporter;
  }
  
  public RCRepairTaskCriteria setIncludeFinishedTask4Reporter(final Boolean includeFinishedTask4Reporter) {
    this.includeFinishedTask4Reporter = includeFinishedTask4Reporter;
    return this;			
    
  }
  
  private RCRepairTaskStatus closeStatus;
  
  public RCRepairTaskStatus getCloseStatus() {
    return this.closeStatus;
  }
  
  public RCRepairTaskCriteria setCloseStatus(final RCRepairTaskStatus closeStatus) {
    this.closeStatus = closeStatus;
    return this;			
    
  }
  
  private RCRepairTaskStatus cancelStatus;
  
  public RCRepairTaskStatus getCancelStatus() {
    return this.cancelStatus;
  }
  
  public RCRepairTaskCriteria setCancelStatus(final RCRepairTaskStatus cancelStatus) {
    this.cancelStatus = cancelStatus;
    return this;			
    
  }
  
  private RCEvaluateState finishState;
  
  public RCEvaluateState getFinishState() {
    return this.finishState;
  }
  
  public RCRepairTaskCriteria setFinishState(final RCEvaluateState finishState) {
    this.finishState = finishState;
    return this;			
    
  }
  
  private RCEvaluateState autoCommitState;
  
  public RCEvaluateState getAutoCommitState() {
    return this.autoCommitState;
  }
  
  public RCRepairTaskCriteria setAutoCommitState(final RCEvaluateState autoCommitState) {
    this.autoCommitState = autoCommitState;
    return this;			
    
  }
  
  private RCFaultReportSource faultReportSource;
  
  public RCFaultReportSource getFaultReportSource() {
    return this.faultReportSource;
  }
  
  public RCRepairTaskCriteria setFaultReportSource(final RCFaultReportSource faultReportSource) {
    this.faultReportSource = faultReportSource;
    return this;			
    
  }
  
  private Date reportDateFrom;
  
  public Date getReportDateFrom() {
    return this.reportDateFrom;
  }
  
  public RCRepairTaskCriteria setReportDateFrom(final Date reportDateFrom) {
    this.reportDateFrom = reportDateFrom;
    return this;			
    
  }
  
  private Date reportDateTo;
  
  public Date getReportDateTo() {
    return this.reportDateTo;
  }
  
  public RCRepairTaskCriteria setReportDateTo(final Date reportDateTo) {
    this.reportDateTo = reportDateTo;
    return this;			
    
  }
  
  private RCRepairTaskStatus status;
  
  public RCRepairTaskStatus getStatus() {
    return this.status;
  }
  
  public RCRepairTaskCriteria setStatus(final RCRepairTaskStatus status) {
    this.status = status;
    return this;			
    
  }
  
  private String month;
  
  public String getMonth() {
    return this.month;
  }
  
  public RCRepairTaskCriteria setMonth(final String month) {
    this.month = month;
    return this;			
    
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.domain.impl.RCRepairTaskImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getComment()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getComment()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getComment()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getComment()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getComment()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getComment()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getComment()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getComment()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getComment()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getComment()) ){
    	hql += " and ((((((((((this.reporterName  LIKE :comment) or (this.reportOrg.name  LIKE :comment)) or (this.operator.name  LIKE :comment)) or (this.faultType.name  LIKE :comment)) or (this.faultReportSource.name  LIKE :comment)) or (this.faultLevel.name  LIKE :comment)) or (this.faultEmergencyLevel.name  LIKE :comment)) or (this.comment  LIKE :comment)) or (this.reportSid  LIKE :comment)) or (this.location  LIKE :comment))" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getReportOrg()) ){
    	hql += " and (this.reportOrg = :reportOrg)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getIncludeFinishedTask()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getCloseStatus()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getCancelStatus()) ){
    	hql += " and ((:includeFinishedTask = true) or (((this.Status <> :closeStatus) and (this.Status <> :cancelStatus))))" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getIncludeFinishedTask4Reporter()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getFinishState()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getAutoCommitState()) ){
    	hql += " and ((:includeFinishedTask4Reporter = true) or (((this.repairEvaluate.evaluateState <> :finishState) and (this.repairEvaluate.evaluateState <> :autoCommitState))))" ;
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
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getMonth()) ){
    	hql += " and (this.month = :month)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getFaultReportSource()) ){
    	hql += " and (this.faultReportSource = :faultReportSource)" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    addOrder("this.reportTime",edu.fudan.mylang.pf.query.OrderItem.DESC);
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getComment())){
    	query.setParameter("comment",getComment()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getReportOrg())){
    	query.setParameter("reportOrg",getReportOrg()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getIncludeFinishedTask())){
    	query.setParameter("includeFinishedTask",getIncludeFinishedTask()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getIncludeFinishedTask4Reporter())){
    	query.setParameter("includeFinishedTask4Reporter",getIncludeFinishedTask4Reporter()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getCloseStatus())){
    	query.setParameter("closeStatus",getCloseStatus()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getCancelStatus())){
    	query.setParameter("cancelStatus",getCancelStatus()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getFinishState())){
    	query.setParameter("finishState",getFinishState()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getAutoCommitState())){
    	query.setParameter("autoCommitState",getAutoCommitState()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getFaultReportSource())){
    	query.setParameter("faultReportSource",getFaultReportSource()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getReportDateFrom())){
    	query.setParameter("reportDateFrom",getReportDateFrom()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getReportDateTo())){
    	query.setParameter("reportDateTo",getReportDateTo()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getStatus())){
    	query.setParameter("status",getStatus()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getMonth())){
    	query.setParameter("month",getMonth()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public RCRepairTaskCriteriaImpl() {
    initOrderBys();
  }
}
