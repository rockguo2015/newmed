package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTask;
import com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTaskCriteria;
import com.fudanmed.platform.core.deliver.DLTaskSourceType;
import com.fudanmed.platform.core.domain.RCEmployee;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import java.util.Date;
import org.hibernate.Query;

public class DLCenterlizedDeliverTaskCriteriaImpl extends HQLBasedPagedQueryCriteria<DLCenterlizedDeliverTask> implements DLCenterlizedDeliverTaskCriteria {
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public DLCenterlizedDeliverTaskCriteria setSid(final String sid) {
    this.sid = sid;
    return this;			
    
  }
  
  private Date createTimeFrom;
  
  public Date getCreateTimeFrom() {
    return this.createTimeFrom;
  }
  
  public DLCenterlizedDeliverTaskCriteria setCreateTimeFrom(final Date createTimeFrom) {
    this.createTimeFrom = createTimeFrom;
    return this;			
    
  }
  
  private Date createTimeTo;
  
  public Date getCreateTimeTo() {
    return this.createTimeTo;
  }
  
  public DLCenterlizedDeliverTaskCriteria setCreateTimeTo(final Date createTimeTo) {
    this.createTimeTo = createTimeTo;
    return this;			
    
  }
  
  private RCEmployee performer;
  
  public RCEmployee getPerformer() {
    return this.performer;
  }
  
  public DLCenterlizedDeliverTaskCriteria setPerformer(final RCEmployee performer) {
    this.performer = performer;
    return this;			
    
  }
  
  private DLTaskSourceType taskSourceType;
  
  public DLTaskSourceType getTaskSourceType() {
    return this.taskSourceType;
  }
  
  public DLCenterlizedDeliverTaskCriteria setTaskSourceType(final DLTaskSourceType taskSourceType) {
    this.taskSourceType = taskSourceType;
    return this;			
    
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.deliver.impl.DLCenterlizedDeliverTaskImpl this  left join  this.performers as worker ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getSid()) ){
    	hql += " and (this.sid  LIKE :sid)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getCreateTimeFrom()) ){
    	hql += " and (this.createTime >= :createTimeFrom)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getCreateTimeTo()) ){
    	hql += " and (this.createTime <= :createTimeTo)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getPerformer()) ){
    	hql += " and (worker = :performer)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getTaskSourceType()) ){
    	hql += " and (this.taskSource.type = :taskSourceType)" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getSid())){
    	query.setParameter("sid",getSid()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getCreateTimeFrom())){
    	query.setParameter("createTimeFrom",getCreateTimeFrom()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getCreateTimeTo())){
    	query.setParameter("createTimeTo",getCreateTimeTo()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getPerformer())){
    	query.setParameter("performer",getPerformer()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getTaskSourceType())){
    	query.setParameter("taskSourceType",getTaskSourceType()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return true;
  }
  
  public DLCenterlizedDeliverTaskCriteriaImpl() {
    initOrderBys();
  }
}
