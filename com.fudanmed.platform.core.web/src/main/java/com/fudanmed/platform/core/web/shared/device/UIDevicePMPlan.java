package com.fudanmed.platform.core.web.shared.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMPlanProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlanStatus;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class UIDevicePMPlan extends GWTEntity {
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public void setSid(final String sid) {
    this.sid = sid;
  }
  
  public final static String P_Sid = "sid";
  
  public static IObjectFieldAccessor<UIDevicePMPlan,String> SidAccessor = new IObjectFieldAccessor<UIDevicePMPlan,String>(){
    				public String getValue(UIDevicePMPlan object){
    					return object.getSid();
    				}
    				public void setValue(UIDevicePMPlan object,String value){
    					object.setSid(value);
    				}
    			};
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  public final static String P_Name = "name";
  
  public static IObjectFieldAccessor<UIDevicePMPlan,String> NameAccessor = new IObjectFieldAccessor<UIDevicePMPlan,String>(){
    				public String getValue(UIDevicePMPlan object){
    					return object.getName();
    				}
    				public void setValue(UIDevicePMPlan object,String value){
    					object.setName(value);
    				}
    			};
  
  private String specification;
  
  public String getSpecification() {
    return this.specification;
  }
  
  public void setSpecification(final String specification) {
    this.specification = specification;
  }
  
  public final static String P_Specification = "specification";
  
  public static IObjectFieldAccessor<UIDevicePMPlan,String> SpecificationAccessor = new IObjectFieldAccessor<UIDevicePMPlan,String>(){
    				public String getValue(UIDevicePMPlan object){
    					return object.getSpecification();
    				}
    				public void setValue(UIDevicePMPlan object,String value){
    					object.setSpecification(value);
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
  
  public static IObjectFieldAccessor<UIDevicePMPlan,RCOnsitePositionProxy> LocationAccessor = new IObjectFieldAccessor<UIDevicePMPlan,RCOnsitePositionProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy getValue(UIDevicePMPlan object){
    					return object.getLocation();
    				}
    				public void setValue(UIDevicePMPlan object,com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy value){
    					object.setLocation(value);
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
  
  public static IObjectFieldAccessor<UIDevicePMPlan,RCDeviceTypeProxy> DeviceTypeAccessor = new IObjectFieldAccessor<UIDevicePMPlan,RCDeviceTypeProxy>(){
    				public com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy getValue(UIDevicePMPlan object){
    					return object.getDeviceType();
    				}
    				public void setValue(UIDevicePMPlan object,com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy value){
    					object.setDeviceType(value);
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
  
  public static IObjectFieldAccessor<UIDevicePMPlan,RCDevicePMTypeProxy> PmTypeAccessor = new IObjectFieldAccessor<UIDevicePMPlan,RCDevicePMTypeProxy>(){
    				public com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy getValue(UIDevicePMPlan object){
    					return object.getPmType();
    				}
    				public void setValue(UIDevicePMPlan object,com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy value){
    					object.setPmType(value);
    				}
    			};
  
  private String description;
  
  public String getDescription() {
    return this.description;
  }
  
  public void setDescription(final String description) {
    this.description = description;
  }
  
  public final static String P_Description = "description";
  
  public static IObjectFieldAccessor<UIDevicePMPlan,String> DescriptionAccessor = new IObjectFieldAccessor<UIDevicePMPlan,String>(){
    				public String getValue(UIDevicePMPlan object){
    					return object.getDescription();
    				}
    				public void setValue(UIDevicePMPlan object,String value){
    					object.setDescription(value);
    				}
    			};
  
  private Date planDate;
  
  public Date getPlanDate() {
    return this.planDate;
  }
  
  public void setPlanDate(final Date planDate) {
    this.planDate = planDate;
  }
  
  public final static String P_PlanDate = "planDate";
  
  public static IObjectFieldAccessor<UIDevicePMPlan,Date> PlanDateAccessor = new IObjectFieldAccessor<UIDevicePMPlan,Date>(){
    				public java.util.Date getValue(UIDevicePMPlan object){
    					return object.getPlanDate();
    				}
    				public void setValue(UIDevicePMPlan object,java.util.Date value){
    					object.setPlanDate(value);
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
  
  public static IObjectFieldAccessor<UIDevicePMPlan,UIDevicePMPlanStatus> StatusAccessor = new IObjectFieldAccessor<UIDevicePMPlan,UIDevicePMPlanStatus>(){
    				public com.fudanmed.platform.core.web.shared.device.UIDevicePMPlanStatus getValue(UIDevicePMPlan object){
    					return object.getStatus();
    				}
    				public void setValue(UIDevicePMPlan object,com.fudanmed.platform.core.web.shared.device.UIDevicePMPlanStatus value){
    					object.setStatus(value);
    				}
    			};
  
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public void setComment(final String comment) {
    this.comment = comment;
  }
  
  public final static String P_Comment = "comment";
  
  public static IObjectFieldAccessor<UIDevicePMPlan,String> CommentAccessor = new IObjectFieldAccessor<UIDevicePMPlan,String>(){
    				public String getValue(UIDevicePMPlan object){
    					return object.getComment();
    				}
    				public void setValue(UIDevicePMPlan object,String value){
    					object.setComment(value);
    				}
    			};
  
  public RCDevicePMPlanProxy toProxy() {
    return (RCDevicePMPlanProxy)super.toProxy();
    
  }
}
