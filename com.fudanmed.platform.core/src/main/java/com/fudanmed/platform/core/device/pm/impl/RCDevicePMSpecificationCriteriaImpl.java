package com.fudanmed.platform.core.device.pm.impl;

import com.fudanmed.platform.core.device.pm.RCDevicePMSpecification;
import com.fudanmed.platform.core.device.pm.RCDevicePMSpecificationCriteria;
import com.fudanmed.platform.core.device.pm.RCDevicePMType;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import java.util.Date;
import org.hibernate.Query;

public class RCDevicePMSpecificationCriteriaImpl extends HQLBasedPagedQueryCriteria<RCDevicePMSpecification> implements RCDevicePMSpecificationCriteria {
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public RCDevicePMSpecificationCriteria setSid(final String sid) {
    this.sid = sid;
    return this;			
    
  }
  
  private RCDevicePMType pmType;
  
  public RCDevicePMType getPmType() {
    return this.pmType;
  }
  
  public RCDevicePMSpecificationCriteria setPmType(final RCDevicePMType pmType) {
    this.pmType = pmType;
    return this;			
    
  }
  
  private Date lastPMPlanDateFrom;
  
  public Date getLastPMPlanDateFrom() {
    return this.lastPMPlanDateFrom;
  }
  
  public RCDevicePMSpecificationCriteria setLastPMPlanDateFrom(final Date lastPMPlanDateFrom) {
    this.lastPMPlanDateFrom = lastPMPlanDateFrom;
    return this;			
    
  }
  
  private Date lastPMPlanDateTo;
  
  public Date getLastPMPlanDateTo() {
    return this.lastPMPlanDateTo;
  }
  
  public RCDevicePMSpecificationCriteria setLastPMPlanDateTo(final Date lastPMPlanDateTo) {
    this.lastPMPlanDateTo = lastPMPlanDateTo;
    return this;			
    
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.device.pm.impl.RCDevicePMSpecificationImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getSid()) ){
    	hql += " and (this.device.sid  LIKE :sid)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getPmType()) ){
    	hql += " and (this.pmType = :pmType)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getLastPMPlanDateFrom()) ){
    	hql += " and (this.lastPMPlanDate >= :lastPMPlanDateFrom)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getLastPMPlanDateTo()) ){
    	hql += " and (this.lastPMPlanDate <= :lastPMPlanDateTo)" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getSid())){
    	query.setParameter("sid",getSid()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getPmType())){
    	query.setParameter("pmType",getPmType()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getLastPMPlanDateFrom())){
    	query.setParameter("lastPMPlanDateFrom",getLastPMPlanDateFrom()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getLastPMPlanDateTo())){
    	query.setParameter("lastPMPlanDateTo",getLastPMPlanDateTo()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public RCDevicePMSpecificationCriteriaImpl() {
    initOrderBys();
  }
}
