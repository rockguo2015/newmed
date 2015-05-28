package com.fudanmed.platform.core.web.shared.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlanStatus;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;
import java.util.Date;

public class UIDevicePMPlanCriteria implements IsSerializable, IPagedCriteria {
  private Date planDateFrom;
  
  public Date getPlanDateFrom() {
    return this.planDateFrom;
  }
  
  public void setPlanDateFrom(final Date planDateFrom) {
    this.planDateFrom = planDateFrom;
  }
  
  public final static String P_PlanDateFrom = "planDateFrom";
  
  public static IObjectFieldAccessor<UIDevicePMPlanCriteria,Date> PlanDateFromAccessor = new IObjectFieldAccessor<UIDevicePMPlanCriteria,Date>(){
    				public java.util.Date getValue(UIDevicePMPlanCriteria object){
    					return object.getPlanDateFrom();
    				}
    				public void setValue(UIDevicePMPlanCriteria object,java.util.Date value){
    					object.setPlanDateFrom(value);
    				}
    			};
  
  private Date planDateTo;
  
  public Date getPlanDateTo() {
    return this.planDateTo;
  }
  
  public void setPlanDateTo(final Date planDateTo) {
    this.planDateTo = planDateTo;
  }
  
  public final static String P_PlanDateTo = "planDateTo";
  
  public static IObjectFieldAccessor<UIDevicePMPlanCriteria,Date> PlanDateToAccessor = new IObjectFieldAccessor<UIDevicePMPlanCriteria,Date>(){
    				public java.util.Date getValue(UIDevicePMPlanCriteria object){
    					return object.getPlanDateTo();
    				}
    				public void setValue(UIDevicePMPlanCriteria object,java.util.Date value){
    					object.setPlanDateTo(value);
    				}
    			};
  
  private RCDeviceTypeProxy deviceType;
  
  public RCDeviceTypeProxy getDeviceType() {
    return this.deviceType;
  }
  
  public void setDeviceType(final RCDeviceTypeProxy deviceType) {
    this.deviceType = deviceType;
  }
  
  public final static String P_DeviceType = "deviceType";
  
  public static IObjectFieldAccessor<UIDevicePMPlanCriteria,RCDeviceTypeProxy> DeviceTypeAccessor = new IObjectFieldAccessor<UIDevicePMPlanCriteria,RCDeviceTypeProxy>(){
    				public com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy getValue(UIDevicePMPlanCriteria object){
    					return object.getDeviceType();
    				}
    				public void setValue(UIDevicePMPlanCriteria object,com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy value){
    					object.setDeviceType(value);
    				}
    			};
  
  private String category;
  
  public String getCategory() {
    return this.category;
  }
  
  public void setCategory(final String category) {
    this.category = category;
  }
  
  public final static String P_Category = "category";
  
  public static IObjectFieldAccessor<UIDevicePMPlanCriteria,String> CategoryAccessor = new IObjectFieldAccessor<UIDevicePMPlanCriteria,String>(){
    				public String getValue(UIDevicePMPlanCriteria object){
    					return object.getCategory();
    				}
    				public void setValue(UIDevicePMPlanCriteria object,String value){
    					object.setCategory(value);
    				}
    			};
  
  private RCDevicePMTypeProxy pmType;
  
  public RCDevicePMTypeProxy getPmType() {
    return this.pmType;
  }
  
  public void setPmType(final RCDevicePMTypeProxy pmType) {
    this.pmType = pmType;
  }
  
  public final static String P_PmType = "pmType";
  
  public static IObjectFieldAccessor<UIDevicePMPlanCriteria,RCDevicePMTypeProxy> PmTypeAccessor = new IObjectFieldAccessor<UIDevicePMPlanCriteria,RCDevicePMTypeProxy>(){
    				public com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy getValue(UIDevicePMPlanCriteria object){
    					return object.getPmType();
    				}
    				public void setValue(UIDevicePMPlanCriteria object,com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy value){
    					object.setPmType(value);
    				}
    			};
  
  private RCOnsitePositionProxy location;
  
  public RCOnsitePositionProxy getLocation() {
    return this.location;
  }
  
  public void setLocation(final RCOnsitePositionProxy location) {
    this.location = location;
  }
  
  public final static String P_Location = "location";
  
  public static IObjectFieldAccessor<UIDevicePMPlanCriteria,RCOnsitePositionProxy> LocationAccessor = new IObjectFieldAccessor<UIDevicePMPlanCriteria,RCOnsitePositionProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy getValue(UIDevicePMPlanCriteria object){
    					return object.getLocation();
    				}
    				public void setValue(UIDevicePMPlanCriteria object,com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy value){
    					object.setLocation(value);
    				}
    			};
  
  private UIDevicePMPlanStatus status;
  
  public UIDevicePMPlanStatus getStatus() {
    return this.status;
  }
  
  public void setStatus(final UIDevicePMPlanStatus status) {
    this.status = status;
  }
  
  public final static String P_Status = "status";
  
  public static IObjectFieldAccessor<UIDevicePMPlanCriteria,UIDevicePMPlanStatus> StatusAccessor = new IObjectFieldAccessor<UIDevicePMPlanCriteria,UIDevicePMPlanStatus>(){
    				public com.fudanmed.platform.core.web.shared.device.UIDevicePMPlanStatus getValue(UIDevicePMPlanCriteria object){
    					return object.getStatus();
    				}
    				public void setValue(UIDevicePMPlanCriteria object,com.fudanmed.platform.core.web.shared.device.UIDevicePMPlanStatus value){
    					object.setStatus(value);
    				}
    			};
  
  private Integer page;
  
  public Integer getPage() {
    return this.page;
  }
  
  public void setPage(final Integer page) {
    this.page = page;
  }
  
  private Integer pageSize;
  
  public Integer getPageSize() {
    return this.pageSize;
  }
  
  public void setPageSize(final Integer pageSize) {
    this.pageSize = pageSize;
  }
}
