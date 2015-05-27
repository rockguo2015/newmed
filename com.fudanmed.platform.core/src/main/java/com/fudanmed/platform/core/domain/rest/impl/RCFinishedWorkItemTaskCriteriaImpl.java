package com.fudanmed.platform.core.domain.rest.impl;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.RCWorkItemTaskStatus;
import com.fudanmed.platform.core.domain.rest.RCFinishedWorkItemTaskCriteria;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import java.util.Date;
import org.hibernate.Query;

public class RCFinishedWorkItemTaskCriteriaImpl extends HQLBasedPagedQueryCriteria<RCWorkItemTask> implements RCFinishedWorkItemTaskCriteria {
  private RCEmployee owner;
  
  public RCEmployee getOwner() {
    return this.owner;
  }
  
  public RCFinishedWorkItemTaskCriteria setOwner(final RCEmployee owner) {
    this.owner = owner;
    return this;			
    
  }
  
  private Date startDate;
  
  public Date getStartDate() {
    return this.startDate;
  }
  
  public RCFinishedWorkItemTaskCriteria setStartDate(final Date startDate) {
    this.startDate = startDate;
    return this;			
    
  }
  
  private Date endDate;
  
  public Date getEndDate() {
    return this.endDate;
  }
  
  public RCFinishedWorkItemTaskCriteria setEndDate(final Date endDate) {
    this.endDate = endDate;
    return this;			
    
  }
  
  private RCWorkItemTaskStatus processingStatus;
  
  public RCWorkItemTaskStatus getProcessingStatus() {
    return this.processingStatus;
  }
  
  public RCFinishedWorkItemTaskCriteria setProcessingStatus(final RCWorkItemTaskStatus processingStatus) {
    this.processingStatus = processingStatus;
    return this;			
    
  }
  
  private RCWorkItemTaskStatus outsourcingStatus;
  
  public RCWorkItemTaskStatus getOutsourcingStatus() {
    return this.outsourcingStatus;
  }
  
  public RCFinishedWorkItemTaskCriteria setOutsourcingStatus(final RCWorkItemTaskStatus outsourcingStatus) {
    this.outsourcingStatus = outsourcingStatus;
    return this;			
    
  }
  
  private RCWorkItemTaskStatus pendingStatus;
  
  public RCWorkItemTaskStatus getPendingStatus() {
    return this.pendingStatus;
  }
  
  public RCFinishedWorkItemTaskCriteria setPendingStatus(final RCWorkItemTaskStatus pendingStatus) {
    this.pendingStatus = pendingStatus;
    return this;			
    
  }
  
  private RCWorkItemTaskStatus followupingStatus;
  
  public RCWorkItemTaskStatus getFollowupingStatus() {
    return this.followupingStatus;
  }
  
  public RCFinishedWorkItemTaskCriteria setFollowupingStatus(final RCWorkItemTaskStatus followupingStatus) {
    this.followupingStatus = followupingStatus;
    return this;			
    
  }
  
  public void postInitialize() {
    RCWorkItemTaskStatus _valueOf = RCWorkItemTaskStatus.<RCWorkItemTaskStatus>valueOf(RCWorkItemTaskStatus.class, "processing");
    this.processingStatus = _valueOf;
    RCWorkItemTaskStatus _valueOf_1 = RCWorkItemTaskStatus.<RCWorkItemTaskStatus>valueOf(RCWorkItemTaskStatus.class, "outsourcing");
    this.outsourcingStatus = _valueOf_1;
    RCWorkItemTaskStatus _valueOf_2 = RCWorkItemTaskStatus.<RCWorkItemTaskStatus>valueOf(RCWorkItemTaskStatus.class, "pending");
    this.pendingStatus = _valueOf_2;
    RCWorkItemTaskStatus _valueOf_3 = RCWorkItemTaskStatus.<RCWorkItemTaskStatus>valueOf(RCWorkItemTaskStatus.class, "followuping");
    this.followupingStatus = _valueOf_3;
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.domain.impl.RCWorkItemTaskImpl this  left join  this.workers as worker ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getProcessingStatus()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getOutsourcingStatus()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getPendingStatus()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getFollowupingStatus()) ){
    	hql += " and ((((this.Status <> :processingStatus) and (this.Status <> :outsourcingStatus)) and (this.Status <> :pendingStatus)) and (this.Status <> :followupingStatus))" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getOwner()) ){
    	hql += " and (worker = :owner)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getStartDate()) ){
    	hql += " and (this.date >= :startDate)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getEndDate()) ){
    	hql += " and (this.date <= :endDate)" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getOwner())){
    	query.setParameter("owner",getOwner()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getStartDate())){
    	query.setParameter("startDate",getStartDate()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getEndDate())){
    	query.setParameter("endDate",getEndDate()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getProcessingStatus())){
    	query.setParameter("processingStatus",getProcessingStatus()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getOutsourcingStatus())){
    	query.setParameter("outsourcingStatus",getOutsourcingStatus()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getPendingStatus())){
    	query.setParameter("pendingStatus",getPendingStatus()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getFollowupingStatus())){
    	query.setParameter("followupingStatus",getFollowupingStatus()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return true;
  }
  
  public RCFinishedWorkItemTaskCriteriaImpl() {
    initOrderBys();
  }
}
