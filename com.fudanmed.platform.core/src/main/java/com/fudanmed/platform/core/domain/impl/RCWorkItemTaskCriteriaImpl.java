package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCMaintenanceTeamDao;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.RCWorkItemTaskCriteria;
import com.fudanmed.platform.core.domain.RCWorkItemTaskStatus;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.hibernate.Query;
import org.springframework.beans.factory.BeanFactory;

public class RCWorkItemTaskCriteriaImpl extends HQLBasedPagedQueryCriteria<RCWorkItemTask> implements RCWorkItemTaskCriteria {
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public RCWorkItemTaskCriteria setSid(final String sid) {
    this.sid = sid;
    return this;			
    
  }
  
  private RCMaintenanceTeam team;
  
  public RCMaintenanceTeam getTeam() {
    return this.team;
  }
  
  public RCWorkItemTaskCriteria setTeam(final RCMaintenanceTeam team) {
    this.team = team;
    return this;			
    
  }
  
  private Boolean showAll;
  
  public Boolean getShowAll() {
    return this.showAll;
  }
  
  public RCWorkItemTaskCriteria setShowAll(final Boolean showAll) {
    this.showAll = showAll;
    return this;			
    
  }
  
  private RCWorkItemTaskStatus processingStatus;
  
  public RCWorkItemTaskStatus getProcessingStatus() {
    return this.processingStatus;
  }
  
  public RCWorkItemTaskCriteria setProcessingStatus(final RCWorkItemTaskStatus processingStatus) {
    this.processingStatus = processingStatus;
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
  
  public RCWorkItemTaskCriteria setTeams(final Collection<Long> teams) {
    this.teams = teams;
    return this;			
    
  }
  
  public void postInitialize() {
    BeanFactory _beanFactory = this.getBeanFactory();
    RCMaintenanceTeamDao _bean = _beanFactory.<RCMaintenanceTeamDao>getBean(RCMaintenanceTeamDao.class);
    Iterable<RCMaintenanceTeam> _allStoreValidTeam4CurrentUser = _bean.getAllStoreValidTeam4CurrentUser();
    final Function1<RCMaintenanceTeam,Long> _function = new Function1<RCMaintenanceTeam,Long>() {
        public Long apply(final RCMaintenanceTeam it) {
          Long _id = it.getId();
          return _id;
        }
      };
    Iterable<Long> _map = IterableExtensions.<RCMaintenanceTeam, Long>map(_allStoreValidTeam4CurrentUser, _function);
    Set<Long> _set = IterableExtensions.<Long>toSet(_map);
    this.teams = _set;
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.domain.impl.RCWorkItemTaskImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getTeams()) ){
    	hql += " and (this.groupTask.team.id  IN (:teams))" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getSid()) ){
    	hql += " and (this.sid  LIKE :sid)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getShowAll()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getProcessingStatus()) ){
    	hql += " and ((:showAll = true) or (this.Status = :processingStatus))" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getTeam()) ){
    	hql += " and (this.groupTask.team = :team)" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    addOrder("this.time",edu.fudan.mylang.pf.query.OrderItem.DESC);
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getSid())){
    	query.setParameter("sid",getSid()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getTeam())){
    	query.setParameter("team",getTeam()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getShowAll())){
    	query.setParameter("showAll",getShowAll()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getProcessingStatus())){
    	query.setParameter("processingStatus",getProcessingStatus()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getTeams())){
    	query.setParameterList("teams",getTeams()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public RCWorkItemTaskCriteriaImpl() {
    initOrderBys();
  }
}
