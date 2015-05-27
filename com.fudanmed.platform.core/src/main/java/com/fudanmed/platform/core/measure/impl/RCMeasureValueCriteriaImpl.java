package com.fudanmed.platform.core.measure.impl;

import com.fudanmed.platform.core.measure.RCMeasureDevice;
import com.fudanmed.platform.core.measure.RCMeasureDeviceType;
import com.fudanmed.platform.core.measure.RCMeasureValue;
import com.fudanmed.platform.core.measure.RCMeasureValueCriteria;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import java.util.Date;
import org.hibernate.Query;

public class RCMeasureValueCriteriaImpl extends HQLBasedPagedQueryCriteria<RCMeasureValue> implements RCMeasureValueCriteria {
  private RCMeasureDeviceType deviceType;
  
  public RCMeasureDeviceType getDeviceType() {
    return this.deviceType;
  }
  
  public RCMeasureValueCriteria setDeviceType(final RCMeasureDeviceType deviceType) {
    this.deviceType = deviceType;
    return this;			
    
  }
  
  private RCMeasureDevice device;
  
  public RCMeasureDevice getDevice() {
    return this.device;
  }
  
  public RCMeasureValueCriteria setDevice(final RCMeasureDevice device) {
    this.device = device;
    return this;			
    
  }
  
  private Date measureDateFrom;
  
  public Date getMeasureDateFrom() {
    return this.measureDateFrom;
  }
  
  public RCMeasureValueCriteria setMeasureDateFrom(final Date measureDateFrom) {
    this.measureDateFrom = measureDateFrom;
    return this;			
    
  }
  
  private Date measureDateTo;
  
  public Date getMeasureDateTo() {
    return this.measureDateTo;
  }
  
  public RCMeasureValueCriteria setMeasureDateTo(final Date measureDateTo) {
    this.measureDateTo = measureDateTo;
    return this;			
    
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.measure.impl.RCMeasureValueImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDeviceType()) ){
    	hql += " and (this.device.deviceType = :deviceType)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDevice()) ){
    	hql += " and (this.device = :device)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getMeasureDateFrom()) ){
    	hql += " and (this.measureDate >= :measureDateFrom)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getMeasureDateTo()) ){
    	hql += " and (this.measureDate <= :measureDateTo)" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    addOrder("this.measureDate",edu.fudan.mylang.pf.query.OrderItem.DESC);
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDeviceType())){
    	query.setParameter("deviceType",getDeviceType()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDevice())){
    	query.setParameter("device",getDevice()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getMeasureDateFrom())){
    	query.setParameter("measureDateFrom",getMeasureDateFrom()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getMeasureDateTo())){
    	query.setParameter("measureDateTo",getMeasureDateTo()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public RCMeasureValueCriteriaImpl() {
    initOrderBys();
  }
}
