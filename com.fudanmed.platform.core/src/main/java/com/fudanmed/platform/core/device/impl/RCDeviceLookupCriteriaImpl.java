package com.fudanmed.platform.core.device.impl;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.RCDeviceLookupCriteria;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import org.hibernate.Query;

public class RCDeviceLookupCriteriaImpl extends HQLBasedPagedQueryCriteria<RCDevice> implements RCDeviceLookupCriteria {
  private String info;
  
  public String getInfo() {
    return this.info;
  }
  
  public RCDeviceLookupCriteria setInfo(final String info) {
    this.info = info;
    return this;			
    
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.device.impl.RCDeviceImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) ){
    	hql += " and (((this.sid  LIKE :info) or (this.name  LIKE :info)) or (this.specification  LIKE :info))" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo())){
    	query.setParameter("info",getInfo()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public RCDeviceLookupCriteriaImpl() {
    initOrderBys();
  }
}
