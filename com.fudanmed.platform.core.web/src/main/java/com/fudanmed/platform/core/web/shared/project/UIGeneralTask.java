package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.shared.project.UIGeneralTaskType;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class UIGeneralTask implements IsSerializable {
  private Long objectId;
  
  public Long getObjectId() {
    return this.objectId;
  }
  
  public void setObjectId(final Long objectId) {
    this.objectId = objectId;
  }
  
  public final static String P_ObjectId = "objectId";
  
  public static IObjectFieldAccessor<UIGeneralTask,Long> ObjectIdAccessor = new IObjectFieldAccessor<UIGeneralTask,Long>(){
    				public Long getValue(UIGeneralTask object){
    					return object.getObjectId();
    				}
    				public void setValue(UIGeneralTask object,Long value){
    					object.setObjectId(value);
    				}
    			};
  
  private UIGeneralTaskType taskType;
  
  public UIGeneralTaskType getTaskType() {
    return this.taskType;
  }
  
  public void setTaskType(final UIGeneralTaskType taskType) {
    this.taskType = taskType;
  }
  
  public final static String P_TaskType = "taskType";
  
  public static IObjectFieldAccessor<UIGeneralTask,UIGeneralTaskType> TaskTypeAccessor = new IObjectFieldAccessor<UIGeneralTask,UIGeneralTaskType>(){
    				public com.fudanmed.platform.core.web.shared.project.UIGeneralTaskType getValue(UIGeneralTask object){
    					return object.getTaskType();
    				}
    				public void setValue(UIGeneralTask object,com.fudanmed.platform.core.web.shared.project.UIGeneralTaskType value){
    					object.setTaskType(value);
    				}
    			};
  
  private String taskOwner;
  
  public String getTaskOwner() {
    return this.taskOwner;
  }
  
  public void setTaskOwner(final String taskOwner) {
    this.taskOwner = taskOwner;
  }
  
  public final static String P_TaskOwner = "taskOwner";
  
  public static IObjectFieldAccessor<UIGeneralTask,String> TaskOwnerAccessor = new IObjectFieldAccessor<UIGeneralTask,String>(){
    				public String getValue(UIGeneralTask object){
    					return object.getTaskOwner();
    				}
    				public void setValue(UIGeneralTask object,String value){
    					object.setTaskOwner(value);
    				}
    			};
  
  private Date dateTime;
  
  public Date getDateTime() {
    return this.dateTime;
  }
  
  public void setDateTime(final Date dateTime) {
    this.dateTime = dateTime;
  }
  
  public final static String P_DateTime = "dateTime";
  
  public static IObjectFieldAccessor<UIGeneralTask,Date> DateTimeAccessor = new IObjectFieldAccessor<UIGeneralTask,Date>(){
    				public java.util.Date getValue(UIGeneralTask object){
    					return object.getDateTime();
    				}
    				public void setValue(UIGeneralTask object,java.util.Date value){
    					object.setDateTime(value);
    				}
    			};
  
  private Date finishDateTime;
  
  public Date getFinishDateTime() {
    return this.finishDateTime;
  }
  
  public void setFinishDateTime(final Date finishDateTime) {
    this.finishDateTime = finishDateTime;
  }
  
  public final static String P_FinishDateTime = "finishDateTime";
  
  public static IObjectFieldAccessor<UIGeneralTask,Date> FinishDateTimeAccessor = new IObjectFieldAccessor<UIGeneralTask,Date>(){
    				public java.util.Date getValue(UIGeneralTask object){
    					return object.getFinishDateTime();
    				}
    				public void setValue(UIGeneralTask object,java.util.Date value){
    					object.setFinishDateTime(value);
    				}
    			};
  
  private String status;
  
  public String getStatus() {
    return this.status;
  }
  
  public void setStatus(final String status) {
    this.status = status;
  }
  
  public final static String P_Status = "status";
  
  public static IObjectFieldAccessor<UIGeneralTask,String> StatusAccessor = new IObjectFieldAccessor<UIGeneralTask,String>(){
    				public String getValue(UIGeneralTask object){
    					return object.getStatus();
    				}
    				public void setValue(UIGeneralTask object,String value){
    					object.setStatus(value);
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
  
  public static IObjectFieldAccessor<UIGeneralTask,RCEmployeeProxy> OperatorAccessor = new IObjectFieldAccessor<UIGeneralTask,RCEmployeeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy getValue(UIGeneralTask object){
    					return object.getOperator();
    				}
    				public void setValue(UIGeneralTask object,com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy value){
    					object.setOperator(value);
    				}
    			};
  
  private Integer parent;
  
  public Integer getParent() {
    return this.parent;
  }
  
  public void setParent(final Integer parent) {
    this.parent = parent;
  }
  
  public final static String P_Parent = "parent";
  
  public static IObjectFieldAccessor<UIGeneralTask,Integer> ParentAccessor = new IObjectFieldAccessor<UIGeneralTask,Integer>(){
    				public Integer getValue(UIGeneralTask object){
    					return object.getParent();
    				}
    				public void setValue(UIGeneralTask object,Integer value){
    					object.setParent(value);
    				}
    			};
  
  public int hashCode() {
    String _name = this.taskType.name();
    String _string = this.objectId.toString();
    String _plus = (_name + _string);
    int _hashCode = _plus.hashCode();
    return _hashCode;
  }
}
