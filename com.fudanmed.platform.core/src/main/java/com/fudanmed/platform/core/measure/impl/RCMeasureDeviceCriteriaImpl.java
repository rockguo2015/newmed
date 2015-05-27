package com.fudanmed.platform.core.measure.impl;

import com.fudanmed.platform.core.measure.RCMeasureDevice;
import com.fudanmed.platform.core.measure.RCMeasureDeviceCriteria;
import com.fudanmed.platform.core.measure.RCMeasureDeviceType;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import org.hibernate.Query;

public class RCMeasureDeviceCriteriaImpl extends HQLBasedPagedQueryCriteria<RCMeasureDevice> implements RCMeasureDeviceCriteria {
  private RCMeasureDeviceType type;
  
  public RCMeasureDeviceType getType() {
    return this.type;
  }
  
  public RCMeasureDeviceCriteria setType(final RCMeasureDeviceType type) {
    this.type = type;
    return this;			
    
  }
  
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public RCMeasureDeviceCriteria setSid(final String sid) {
    this.sid = sid;
    return this;			
    
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.measure.impl.RCMeasureDeviceImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getType()) ){
    	hql += " and (this.deviceType = :type)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getSid()) ){
    	hql += " and (this.sid = :sid)" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getType())){
    	query.setParameter("type",getType()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getSid())){
    	query.setParameter("sid",getSid()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public RCMeasureDeviceCriteriaImpl() {
    initOrderBys();
  }
}
