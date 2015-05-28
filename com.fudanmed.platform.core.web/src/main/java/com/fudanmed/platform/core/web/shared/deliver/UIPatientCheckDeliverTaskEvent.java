package com.fudanmed.platform.core.web.shared.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLPatientCheckDeliverTaskEventProxy;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIPatientCheckDeliverTaskEventType;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class UIPatientCheckDeliverTaskEvent extends GWTEntity {
  private Date createTime;
  
  public Date getCreateTime() {
    return this.createTime;
  }
  
  public void setCreateTime(final Date createTime) {
    this.createTime = createTime;
  }
  
  public final static String P_CreateTime = "createTime";
  
  public static IObjectFieldAccessor<UIPatientCheckDeliverTaskEvent,Date> CreateTimeAccessor = new IObjectFieldAccessor<UIPatientCheckDeliverTaskEvent,Date>(){
    				public java.util.Date getValue(UIPatientCheckDeliverTaskEvent object){
    					return object.getCreateTime();
    				}
    				public void setValue(UIPatientCheckDeliverTaskEvent object,java.util.Date value){
    					object.setCreateTime(value);
    				}
    			};
  
  private RCEmployeeProxy operator;
  
  public RCEmployeeProxy getOperator() {
    return this.operator;
  }
  
  public void setOperator(final RCEmployeeProxy operator) {
    this.operator = operator;
  }
  
  public final static String P_Operator = "operator";
  
  public static IObjectFieldAccessor<UIPatientCheckDeliverTaskEvent,RCEmployeeProxy> OperatorAccessor = new IObjectFieldAccessor<UIPatientCheckDeliverTaskEvent,RCEmployeeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy getValue(UIPatientCheckDeliverTaskEvent object){
    					return object.getOperator();
    				}
    				public void setValue(UIPatientCheckDeliverTaskEvent object,com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy value){
    					object.setOperator(value);
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
  
  public static IObjectFieldAccessor<UIPatientCheckDeliverTaskEvent,String> DescriptionAccessor = new IObjectFieldAccessor<UIPatientCheckDeliverTaskEvent,String>(){
    				public String getValue(UIPatientCheckDeliverTaskEvent object){
    					return object.getDescription();
    				}
    				public void setValue(UIPatientCheckDeliverTaskEvent object,String value){
    					object.setDescription(value);
    				}
    			};
  
  private UIPatientCheckDeliverTaskEventType eventType;
  
  public UIPatientCheckDeliverTaskEventType getEventType() {
    return this.eventType;
  }
  
  public void setEventType(final UIPatientCheckDeliverTaskEventType eventType) {
    this.eventType = eventType;
  }
  
  public final static String P_EventType = "eventType";
  
  public static IObjectFieldAccessor<UIPatientCheckDeliverTaskEvent,UIPatientCheckDeliverTaskEventType> EventTypeAccessor = new IObjectFieldAccessor<UIPatientCheckDeliverTaskEvent,UIPatientCheckDeliverTaskEventType>(){
    				public com.fudanmed.platform.core.web.shared.deliver.UIPatientCheckDeliverTaskEventType getValue(UIPatientCheckDeliverTaskEvent object){
    					return object.getEventType();
    				}
    				public void setValue(UIPatientCheckDeliverTaskEvent object,com.fudanmed.platform.core.web.shared.deliver.UIPatientCheckDeliverTaskEventType value){
    					object.setEventType(value);
    				}
    			};
  
  public DLPatientCheckDeliverTaskEventProxy toProxy() {
    return (DLPatientCheckDeliverTaskEventProxy)super.toProxy();
    
  }
}
