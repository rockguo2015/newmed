package edu.fudan.langlab.domain.task.impl;

import edu.fudan.langlab.domain.organization.Party;
import edu.fudan.langlab.domain.task.Task;
import edu.fudan.langlab.domain.task.TaskCriteria;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import java.util.Date;
import org.hibernate.Query;

public class TaskCriteriaImpl extends HQLBasedPagedQueryCriteria<Task> implements TaskCriteria {
  private Party owner;
  
  public Party getOwner() {
    return this.owner;
  }
  
  public TaskCriteria setOwner(final Party owner) {
    this.owner = owner;
    return this;			
    
  }
  
  private Date genDateFrom;
  
  public Date getGenDateFrom() {
    return this.genDateFrom;
  }
  
  public TaskCriteria setGenDateFrom(final Date genDateFrom) {
    this.genDateFrom = genDateFrom;
    return this;			
    
  }
  
  private Date genDateTo;
  
  public Date getGenDateTo() {
    return this.genDateTo;
  }
  
  public TaskCriteria setGenDateTo(final Date genDateTo) {
    this.genDateTo = genDateTo;
    return this;			
    
  }
  
  private Date dueDateFrom;
  
  public Date getDueDateFrom() {
    return this.dueDateFrom;
  }
  
  public TaskCriteria setDueDateFrom(final Date dueDateFrom) {
    this.dueDateFrom = dueDateFrom;
    return this;			
    
  }
  
  private Date dueDateTo;
  
  public Date getDueDateTo() {
    return this.dueDateTo;
  }
  
  public TaskCriteria setDueDateTo(final Date dueDateTo) {
    this.dueDateTo = dueDateTo;
    return this;			
    
  }
  
  private String description;
  
  public String getDescription() {
    return this.description;
  }
  
  public TaskCriteria setDescription(final String description) {
    this.description = description;
    return this;			
    
  }
  
  protected String buildHQLFrom() {
    return " from edu.fudan.langlab.domain.task.impl.TaskImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getOwner()) ){
    	hql += " and (this.owner = :owner)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getGenDateFrom()) ){
    	hql += " and (this.genDate >= :genDateFrom)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getGenDateTo()) ){
    	hql += " and (this.genDate <= :genDateTo)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDueDateFrom()) ){
    	hql += " and (this.dueDate >= :dueDateFrom)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDueDateTo()) ){
    	hql += " and (this.dueDate <= :dueDateTo)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDescription()) ){
    	hql += " and (this.description  LIKE :description)" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getOwner())){
    	query.setParameter("owner",getOwner()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getGenDateFrom())){
    	query.setParameter("genDateFrom",getGenDateFrom()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getGenDateTo())){
    	query.setParameter("genDateTo",getGenDateTo()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDueDateFrom())){
    	query.setParameter("dueDateFrom",getDueDateFrom()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDueDateTo())){
    	query.setParameter("dueDateTo",getDueDateTo()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDescription())){
    	query.setParameter("description",getDescription()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public TaskCriteriaImpl() {
    initOrderBys();
  }
}
