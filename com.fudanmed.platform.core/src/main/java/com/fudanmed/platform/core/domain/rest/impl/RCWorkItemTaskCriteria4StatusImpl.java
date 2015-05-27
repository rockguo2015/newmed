package com.fudanmed.platform.core.domain.rest.impl;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.RCWorkItemTaskStatus;
import com.fudanmed.platform.core.domain.rest.RCWorkItemTaskCriteria4Status;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import java.util.Date;
import org.hibernate.Query;

public class RCWorkItemTaskCriteria4StatusImpl extends HQLBasedPagedQueryCriteria<RCWorkItemTask> implements RCWorkItemTaskCriteria4Status {
  private RCEmployee owner;
  
  public RCEmployee getOwner() {
    return this.owner;
  }
  
  public RCWorkItemTaskCriteria4Status setOwner(final RCEmployee owner) {
    this.owner = owner;
    return this;			
    
  }
  
  private RCWorkItemTaskStatus status;
  
  public RCWorkItemTaskStatus getStatus() {
    return this.status;
  }
  
  public RCWorkItemTaskCriteria4Status setStatus(final RCWorkItemTaskStatus status) {
    this.status = status;
    return this;			
    
  }
  
  private Date fromDate;
  
  public Date getFromDate() {
    return this.fromDate;
  }
  
  public RCWorkItemTaskCriteria4Status setFromDate(final Date fromDate) {
    this.fromDate = fromDate;
    return this;			
    
  }
  
  private Date toDate;
  
  public Date getToDate() {
    return this.toDate;
  }
  
  public RCWorkItemTaskCriteria4Status setToDate(final Date toDate) {
    this.toDate = toDate;
    return this;			
    
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.domain.impl.RCWorkItemTaskImpl this  left join  this.workers as worker ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getOwner()) ){
    	hql += " and (worker = :owner)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getStatus()) ){
    	hql += " and (this.Status = :status)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getFromDate()) ){
    	hql += " and (this.groupTask.repairTask.reportDate >= :fromDate)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getToDate()) ){
    	hql += " and (this.groupTask.repairTask.reportDate <= :toDate)" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getOwner())){
    	query.setParameter("owner",getOwner()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getStatus())){
    	query.setParameter("status",getStatus()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getFromDate())){
    	query.setParameter("fromDate",getFromDate()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getToDate())){
    	query.setParameter("toDate",getToDate()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return true;
  }
  
  public RCWorkItemTaskCriteria4StatusImpl() {
    initOrderBys();
  }
}
