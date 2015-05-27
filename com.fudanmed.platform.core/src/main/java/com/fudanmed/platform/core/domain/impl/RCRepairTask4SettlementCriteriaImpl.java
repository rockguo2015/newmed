package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCRepairTask4SettlementCriteria;
import com.fudanmed.platform.core.domain.RCRepairTaskStatus;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import java.util.Date;
import org.hibernate.Query;

public class RCRepairTask4SettlementCriteriaImpl extends HQLBasedPagedQueryCriteria<RCRepairTask> implements RCRepairTask4SettlementCriteria {
  private Boolean hasMadeSettlement;
  
  public Boolean getHasMadeSettlement() {
    return this.hasMadeSettlement;
  }
  
  public RCRepairTask4SettlementCriteria setHasMadeSettlement(final Boolean hasMadeSettlement) {
    this.hasMadeSettlement = hasMadeSettlement;
    return this;			
    
  }
  
  private RCRepairTaskStatus closeStatus;
  
  public RCRepairTaskStatus getCloseStatus() {
    return this.closeStatus;
  }
  
  public RCRepairTask4SettlementCriteria setCloseStatus(final RCRepairTaskStatus closeStatus) {
    this.closeStatus = closeStatus;
    return this;			
    
  }
  
  private Date finishDateFrom;
  
  public Date getFinishDateFrom() {
    return this.finishDateFrom;
  }
  
  public RCRepairTask4SettlementCriteria setFinishDateFrom(final Date finishDateFrom) {
    this.finishDateFrom = finishDateFrom;
    return this;			
    
  }
  
  private Date finishDateTo;
  
  public Date getFinishDateTo() {
    return this.finishDateTo;
  }
  
  public RCRepairTask4SettlementCriteria setFinishDateTo(final Date finishDateTo) {
    this.finishDateTo = finishDateTo;
    return this;			
    
  }
  
  private RCMaintenanceTeam team;
  
  public RCMaintenanceTeam getTeam() {
    return this.team;
  }
  
  public RCRepairTask4SettlementCriteria setTeam(final RCMaintenanceTeam team) {
    this.team = team;
    return this;			
    
  }
  
  private RCOrganization reportOrg;
  
  public RCOrganization getReportOrg() {
    return this.reportOrg;
  }
  
  public RCRepairTask4SettlementCriteria setReportOrg(final RCOrganization reportOrg) {
    this.reportOrg = reportOrg;
    return this;			
    
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.domain.impl.RCRepairTaskImpl this  left join  this.groupTasks as groupTask ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getCloseStatus()) ){
    	hql += " and (this.Status = :closeStatus)" ;
    }
    	hql += " and (this.settlement IS   NULL )" ;
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getFinishDateFrom()) ){
    	hql += " and (this.finishDate >= :finishDateFrom)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getFinishDateTo()) ){
    	hql += " and (this.finishDate <= :finishDateTo)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getTeam()) ){
    	hql += " and (groupTask.team = :team)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getReportOrg()) ){
    	hql += " and (this.reportOrg = :reportOrg)" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    addOrder("this.finishDate",edu.fudan.mylang.pf.query.OrderItem.DESC);
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getHasMadeSettlement())){
    	query.setParameter("hasMadeSettlement",getHasMadeSettlement()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getCloseStatus())){
    	query.setParameter("closeStatus",getCloseStatus()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getFinishDateFrom())){
    	query.setParameter("finishDateFrom",getFinishDateFrom()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getFinishDateTo())){
    	query.setParameter("finishDateTo",getFinishDateTo()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getTeam())){
    	query.setParameter("team",getTeam()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getReportOrg())){
    	query.setParameter("reportOrg",getReportOrg()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return true;
  }
  
  public RCRepairTask4SettlementCriteriaImpl() {
    initOrderBys();
  }
}
