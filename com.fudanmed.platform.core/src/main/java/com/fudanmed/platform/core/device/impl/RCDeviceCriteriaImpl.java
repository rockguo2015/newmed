package com.fudanmed.platform.core.device.impl;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.RCDeviceCriteria;
import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.domain.RCOnsitePosition;
import com.google.common.base.Objects;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import org.hibernate.Query;

public class RCDeviceCriteriaImpl extends HQLBasedPagedQueryCriteria<RCDevice> implements RCDeviceCriteria {
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public RCDeviceCriteria setSid(final String sid) {
    this.sid = sid;
    return this;			
    
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public RCDeviceCriteria setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  private RCDeviceType deviceType;
  
  public RCDeviceType getDeviceType() {
    return this.deviceType;
  }
  
  public RCDeviceCriteria setDeviceType(final RCDeviceType deviceType) {
    this.deviceType = deviceType;
    return this;			
    
  }
  
  private String category;
  
  public String getCategory() {
    return this.category;
  }
  
  public RCDeviceCriteria setCategory(final String category) {
    this.category = category;
    return this;			
    
  }
  
  private RCOnsitePosition location;
  
  public RCOnsitePosition getLocation() {
    return this.location;
  }
  
  public RCDeviceCriteria setLocation(final RCOnsitePosition location) {
    this.location = location;
    return this;			
    
  }
  
  private String locationPathName;
  
  public String getLocationPathName() {
    return this.locationPathName;
  }
  
  public RCDeviceCriteria setLocationPathName(final String locationPathName) {
    this.locationPathName = locationPathName;
    return this;			
    
  }
  
  public void postInitialize() {
    boolean _notEquals = (!Objects.equal(this.location, null));
    if (_notEquals) {
      Long _id = this.location.getId();
      String _plus = ("%[" + _id);
      String _plus_1 = (_plus + "]%");
      this.locationPathName = _plus_1;
    }
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.device.impl.RCDeviceImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getSid()) ){
    	hql += " and (this.sid  LIKE :sid)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getName()) ){
    	hql += " and (this.name  LIKE :name)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDeviceType()) ){
    	hql += " and (this.deviceType = :deviceType)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getCategory()) ){
    	hql += " and (this.deviceType.path  LIKE :category)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getLocationPathName()) ){
    	hql += " and (this.location.path  LIKE :locationPathName)" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getSid())){
    	query.setParameter("sid",getSid()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getName())){
    	query.setParameter("name",getName()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDeviceType())){
    	query.setParameter("deviceType",getDeviceType()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getCategory())){
    	query.setParameter("category",getCategory()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getLocationPathName())){
    	query.setParameter("locationPathName",getLocationPathName()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public RCDeviceCriteriaImpl() {
    initOrderBys();
  }
}
