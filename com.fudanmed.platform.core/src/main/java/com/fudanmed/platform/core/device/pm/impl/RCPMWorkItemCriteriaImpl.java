package com.fudanmed.platform.core.device.pm.impl;

import com.fudanmed.platform.core.device.pm.RCPMWorkItem;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemCriteria;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemStatue;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.google.common.base.Objects;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.hibernate.Query;

public class RCPMWorkItemCriteriaImpl extends HQLBasedPagedQueryCriteria<RCPMWorkItem> implements RCPMWorkItemCriteria {
  private Date assignDateFrom;
  
  public Date getAssignDateFrom() {
    return this.assignDateFrom;
  }
  
  public RCPMWorkItemCriteria setAssignDateFrom(final Date assignDateFrom) {
    this.assignDateFrom = assignDateFrom;
    return this;			
    
  }
  
  private Date assignDateTo;
  
  public Date getAssignDateTo() {
    return this.assignDateTo;
  }
  
  public RCPMWorkItemCriteria setAssignDateTo(final Date assignDateTo) {
    this.assignDateTo = assignDateTo;
    return this;			
    
  }
  
  private RCPMWorkItemStatue status;
  
  public RCPMWorkItemStatue getStatus() {
    return this.status;
  }
  
  public RCPMWorkItemCriteria setStatus(final RCPMWorkItemStatue status) {
    this.status = status;
    return this;			
    
  }
  
  private RCMaintenanceTeam team;
  
  public RCMaintenanceTeam getTeam() {
    return this.team;
  }
  
  public RCPMWorkItemCriteria setTeam(final RCMaintenanceTeam team) {
    this.team = team;
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
  
  public RCPMWorkItemCriteria setTeams(final Collection<Long> teams) {
    this.teams = teams;
    return this;			
    
  }
  
  private Boolean includeFinishedItems;
  
  public Boolean getIncludeFinishedItems() {
    return this.includeFinishedItems;
  }
  
  public RCPMWorkItemCriteria setIncludeFinishedItems(final Boolean includeFinishedItems) {
    this.includeFinishedItems = includeFinishedItems;
    return this;			
    
  }
  
  private RCPMWorkItemStatue finishedStatus;
  
  public RCPMWorkItemStatue getFinishedStatus() {
    return this.finishedStatus;
  }
  
  public RCPMWorkItemCriteria setFinishedStatus(final RCPMWorkItemStatue finishedStatus) {
    this.finishedStatus = finishedStatus;
    return this;			
    
  }
  
  public void postInitialize() {
    boolean _equals = Objects.equal(this.includeFinishedItems, null);
    if (_equals) {
      this.includeFinishedItems = Boolean.valueOf(false);
    }
    this.finishedStatus = RCPMWorkItemStatue.finished;
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.device.pm.impl.RCPMWorkItemImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getAssignDateFrom()) ){
    	hql += " and (this.assignDate >= :assignDateFrom)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getAssignDateTo()) ){
    	hql += " and (this.assignDate <= :assignDateTo)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getStatus()) ){
    	hql += " and (this.status = :status)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getTeams()) ){
    	hql += " and (this.team.id  IN (:teams))" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getTeam()) ){
    	hql += " and (this.team = :team)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getIncludeFinishedItems()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getFinishedStatus()) ){
    	hql += " and ((:includeFinishedItems = true) or (this.status <> :finishedStatus))" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    addOrder("this.sid",edu.fudan.mylang.pf.query.OrderItem.DESC);
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getAssignDateFrom())){
    	query.setParameter("assignDateFrom",getAssignDateFrom()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getAssignDateTo())){
    	query.setParameter("assignDateTo",getAssignDateTo()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getStatus())){
    	query.setParameter("status",getStatus()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getTeam())){
    	query.setParameter("team",getTeam()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getTeams())){
    	query.setParameterList("teams",getTeams()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getIncludeFinishedItems())){
    	query.setParameter("includeFinishedItems",getIncludeFinishedItems()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getFinishedStatus())){
    	query.setParameter("finishedStatus",getFinishedStatus()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public RCPMWorkItemCriteriaImpl() {
    initOrderBys();
  }
}
