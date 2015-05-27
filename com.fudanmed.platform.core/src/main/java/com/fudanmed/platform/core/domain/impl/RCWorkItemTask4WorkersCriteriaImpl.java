package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.RCWorkItemTask4WorkersCriteria;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import java.util.Date;
import org.hibernate.Query;

public class RCWorkItemTask4WorkersCriteriaImpl extends HQLBasedPagedQueryCriteria<RCWorkItemTask> implements RCWorkItemTask4WorkersCriteria {
  private Date dateFrom;
  
  public Date getDateFrom() {
    return this.dateFrom;
  }
  
  public RCWorkItemTask4WorkersCriteria setDateFrom(final Date dateFrom) {
    this.dateFrom = dateFrom;
    return this;			
    
  }
  
  private Date dateTo;
  
  public Date getDateTo() {
    return this.dateTo;
  }
  
  public RCWorkItemTask4WorkersCriteria setDateTo(final Date dateTo) {
    this.dateTo = dateTo;
    return this;			
    
  }
  
  private RCMaintenanceTeam department;
  
  public RCMaintenanceTeam getDepartment() {
    return this.department;
  }
  
  public RCWorkItemTask4WorkersCriteria setDepartment(final RCMaintenanceTeam department) {
    this.department = department;
    return this;			
    
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.domain.impl.RCWorkItemTaskImpl this  left join  this.workers as worker ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDepartment()) ){
    	hql += " and (this.groupTask.team = :department)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDateFrom()) ){
    	hql += " and (this.date >= :dateFrom)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDateTo()) ){
    	hql += " and (this.date <= :dateTo)" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDateFrom())){
    	query.setParameter("dateFrom",getDateFrom()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDateTo())){
    	query.setParameter("dateTo",getDateTo()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDepartment())){
    	query.setParameter("department",getDepartment()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public RCWorkItemTask4WorkersCriteriaImpl() {
    initOrderBys();
  }
}
