package com.fudanmed.platform.core.device.pm.impl;

import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.pm.RCDevicePMPlan;
import com.fudanmed.platform.core.device.pm.RCDevicePMPlanCriteria;
import com.fudanmed.platform.core.device.pm.RCDevicePMPlanStatus;
import com.fudanmed.platform.core.device.pm.RCDevicePMType;
import com.fudanmed.platform.core.domain.RCOnsitePosition;
import com.google.common.base.Objects;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import java.util.Date;
import org.hibernate.Query;

public class RCDevicePMPlanCriteriaImpl extends HQLBasedPagedQueryCriteria<RCDevicePMPlan> implements RCDevicePMPlanCriteria {
  private Date planDateFrom;
  
  public Date getPlanDateFrom() {
    return this.planDateFrom;
  }
  
  public RCDevicePMPlanCriteria setPlanDateFrom(final Date planDateFrom) {
    this.planDateFrom = planDateFrom;
    return this;			
    
  }
  
  private Date planDateTo;
  
  public Date getPlanDateTo() {
    return this.planDateTo;
  }
  
  public RCDevicePMPlanCriteria setPlanDateTo(final Date planDateTo) {
    this.planDateTo = planDateTo;
    return this;			
    
  }
  
  private RCDeviceType deviceType;
  
  public RCDeviceType getDeviceType() {
    return this.deviceType;
  }
  
  public RCDevicePMPlanCriteria setDeviceType(final RCDeviceType deviceType) {
    this.deviceType = deviceType;
    return this;			
    
  }
  
  private String category;
  
  public String getCategory() {
    return this.category;
  }
  
  public RCDevicePMPlanCriteria setCategory(final String category) {
    this.category = category;
    return this;			
    
  }
  
  private RCDevicePMType pmType;
  
  public RCDevicePMType getPmType() {
    return this.pmType;
  }
  
  public RCDevicePMPlanCriteria setPmType(final RCDevicePMType pmType) {
    this.pmType = pmType;
    return this;			
    
  }
  
  private RCDevicePMPlanStatus status;
  
  public RCDevicePMPlanStatus getStatus() {
    return this.status;
  }
  
  public RCDevicePMPlanCriteria setStatus(final RCDevicePMPlanStatus status) {
    this.status = status;
    return this;			
    
  }
  
  private RCOnsitePosition location;
  
  public RCOnsitePosition getLocation() {
    return this.location;
  }
  
  public RCDevicePMPlanCriteria setLocation(final RCOnsitePosition location) {
    this.location = location;
    return this;			
    
  }
  
  private String locationPathId;
  
  public String getLocationPathId() {
    return this.locationPathId;
  }
  
  public RCDevicePMPlanCriteria setLocationPathId(final String locationPathId) {
    this.locationPathId = locationPathId;
    return this;			
    
  }
  
  public void postInitialize() {
    boolean _notEquals = (!Objects.equal(this.location, null));
    if (_notEquals) {
      Long _id = this.location.getId();
      String _plus = ("%[" + _id);
      String _plus_1 = (_plus + "]%");
      this.locationPathId = _plus_1;
    }
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.device.pm.impl.RCDevicePMPlanImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getPlanDateFrom()) ){
    	hql += " and (this.planDate >= :planDateFrom)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getPlanDateTo()) ){
    	hql += " and (this.planDate <= :planDateTo)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getStatus()) ){
    	hql += " and (this.status = :status)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDeviceType()) ){
    	hql += " and (this.spec.device.deviceType = :deviceType)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getCategory()) ){
    	hql += " and (this.spec.device.deviceType.path  LIKE :category)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getPmType()) ){
    	hql += " and (this.spec.pmType = :pmType)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getLocationPathId()) ){
    	hql += " and (this.spec.device.location.path  LIKE :locationPathId)" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    addOrder("this.planDate",edu.fudan.mylang.pf.query.OrderItem.ASC);
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getPlanDateFrom())){
    	query.setParameter("planDateFrom",getPlanDateFrom()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getPlanDateTo())){
    	query.setParameter("planDateTo",getPlanDateTo()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDeviceType())){
    	query.setParameter("deviceType",getDeviceType()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getCategory())){
    	query.setParameter("category",getCategory()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getPmType())){
    	query.setParameter("pmType",getPmType()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getStatus())){
    	query.setParameter("status",getStatus()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getLocationPathId())){
    	query.setParameter("locationPathId",getLocationPathId()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public RCDevicePMPlanCriteriaImpl() {
    initOrderBys();
  }
}
