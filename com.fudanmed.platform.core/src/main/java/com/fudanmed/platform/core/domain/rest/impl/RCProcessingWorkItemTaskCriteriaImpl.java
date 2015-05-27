package com.fudanmed.platform.core.domain.rest.impl;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.RCWorkItemTaskStatus;
import com.fudanmed.platform.core.domain.rest.RCProcessingWorkItemTaskCriteria;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import org.hibernate.Query;

public class RCProcessingWorkItemTaskCriteriaImpl extends HQLBasedPagedQueryCriteria<RCWorkItemTask> implements RCProcessingWorkItemTaskCriteria {
  private RCEmployee owner;
  
  public RCEmployee getOwner() {
    return this.owner;
  }
  
  public RCProcessingWorkItemTaskCriteria setOwner(final RCEmployee owner) {
    this.owner = owner;
    return this;			
    
  }
  
  private RCWorkItemTaskStatus processingStatus;
  
  public RCWorkItemTaskStatus getProcessingStatus() {
    return this.processingStatus;
  }
  
  public RCProcessingWorkItemTaskCriteria setProcessingStatus(final RCWorkItemTaskStatus processingStatus) {
    this.processingStatus = processingStatus;
    return this;			
    
  }
  
  private RCWorkItemTaskStatus outsourcingStatus;
  
  public RCWorkItemTaskStatus getOutsourcingStatus() {
    return this.outsourcingStatus;
  }
  
  public RCProcessingWorkItemTaskCriteria setOutsourcingStatus(final RCWorkItemTaskStatus outsourcingStatus) {
    this.outsourcingStatus = outsourcingStatus;
    return this;			
    
  }
  
  private RCWorkItemTaskStatus pendingStatus;
  
  public RCWorkItemTaskStatus getPendingStatus() {
    return this.pendingStatus;
  }
  
  public RCProcessingWorkItemTaskCriteria setPendingStatus(final RCWorkItemTaskStatus pendingStatus) {
    this.pendingStatus = pendingStatus;
    return this;			
    
  }
  
  private RCWorkItemTaskStatus followupingStatus;
  
  public RCWorkItemTaskStatus getFollowupingStatus() {
    return this.followupingStatus;
  }
  
  public RCProcessingWorkItemTaskCriteria setFollowupingStatus(final RCWorkItemTaskStatus followupingStatus) {
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
    	hql += " and ((((this.Status = :processingStatus) or (this.Status = :outsourcingStatus)) or (this.Status = :pendingStatus)) or (this.Status = :followupingStatus))" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getOwner()) ){
    	hql += " and (worker = :owner)" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getOwner())){
    	query.setParameter("owner",getOwner()) ;
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
  
  public RCProcessingWorkItemTaskCriteriaImpl() {
    initOrderBys();
  }
}
