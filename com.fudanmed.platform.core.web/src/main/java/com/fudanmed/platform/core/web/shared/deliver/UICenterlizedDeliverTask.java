package com.fudanmed.platform.core.web.shared.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverSubjectProxy;
import com.fudanmed.platform.core.deliver.proxy.DLResourceProxy;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTaskStatus;
import com.fudanmed.platform.core.web.shared.deliver.UITaskSourceType;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Collection;
import java.util.Date;

public class UICenterlizedDeliverTask extends GWTEntity {
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public void setSid(final String sid) {
    this.sid = sid;
  }
  
  public final static String P_Sid = "sid";
  
  public static IObjectFieldAccessor<UICenterlizedDeliverTask,String> SidAccessor = new IObjectFieldAccessor<UICenterlizedDeliverTask,String>(){
    				public String getValue(UICenterlizedDeliverTask object){
    					return object.getSid();
    				}
    				public void setValue(UICenterlizedDeliverTask object,String value){
    					object.setSid(value);
    				}
    			};
  
  private Date createTime;
  
  public Date getCreateTime() {
    return this.createTime;
  }
  
  public void setCreateTime(final Date createTime) {
    this.createTime = createTime;
  }
  
  public final static String P_CreateTime = "createTime";
  
  public static IObjectFieldAccessor<UICenterlizedDeliverTask,Date> CreateTimeAccessor = new IObjectFieldAccessor<UICenterlizedDeliverTask,Date>(){
    				public java.util.Date getValue(UICenterlizedDeliverTask object){
    					return object.getCreateTime();
    				}
    				public void setValue(UICenterlizedDeliverTask object,java.util.Date value){
    					object.setCreateTime(value);
    				}
    			};
  
  private DLDeliverSubjectProxy subject;
  
  public DLDeliverSubjectProxy getSubject() {
    return this.subject;
  }
  
  public void setSubject(final DLDeliverSubjectProxy subject) {
    this.subject = subject;
  }
  
  public final static String P_Subject = "subject";
  
  public static IObjectFieldAccessor<UICenterlizedDeliverTask,DLDeliverSubjectProxy> SubjectAccessor = new IObjectFieldAccessor<UICenterlizedDeliverTask,DLDeliverSubjectProxy>(){
    				public com.fudanmed.platform.core.deliver.proxy.DLDeliverSubjectProxy getValue(UICenterlizedDeliverTask object){
    					return object.getSubject();
    				}
    				public void setValue(UICenterlizedDeliverTask object,com.fudanmed.platform.core.deliver.proxy.DLDeliverSubjectProxy value){
    					object.setSubject(value);
    				}
    			};
  
  private Collection<RCEmployeeProxy> performers = com.google.common.collect.Lists.newArrayList();
  
  public Collection<RCEmployeeProxy> getPerformers() {
    return this.performers;
  }
  
  public void setPerformers(final Collection<RCEmployeeProxy> performers) {
    this.performers = performers;
  }
  
  public final static String P_Performers = "performers";
  
  public static IObjectFieldAccessor<UICenterlizedDeliverTask,Collection<RCEmployeeProxy>> PerformersAccessor = new IObjectFieldAccessor<UICenterlizedDeliverTask,Collection<RCEmployeeProxy>>(){
    				public java.util.Collection<com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy> getValue(UICenterlizedDeliverTask object){
    					return object.getPerformers();
    				}
    				public void setValue(UICenterlizedDeliverTask object,java.util.Collection<com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy> value){
    					object.setPerformers(value);
    				}
    			};
  
  private Collection<DLResourceProxy> resources = com.google.common.collect.Lists.newArrayList();
  
  public Collection<DLResourceProxy> getResources() {
    return this.resources;
  }
  
  public void setResources(final Collection<DLResourceProxy> resources) {
    this.resources = resources;
  }
  
  public final static String P_Resources = "resources";
  
  public static IObjectFieldAccessor<UICenterlizedDeliverTask,Collection<DLResourceProxy>> ResourcesAccessor = new IObjectFieldAccessor<UICenterlizedDeliverTask,Collection<DLResourceProxy>>(){
    				public java.util.Collection<com.fudanmed.platform.core.deliver.proxy.DLResourceProxy> getValue(UICenterlizedDeliverTask object){
    					return object.getResources();
    				}
    				public void setValue(UICenterlizedDeliverTask object,java.util.Collection<com.fudanmed.platform.core.deliver.proxy.DLResourceProxy> value){
    					object.setResources(value);
    				}
    			};
  
  private UITaskSourceType taskSourceType;
  
  public UITaskSourceType getTaskSourceType() {
    return this.taskSourceType;
  }
  
  public void setTaskSourceType(final UITaskSourceType taskSourceType) {
    this.taskSourceType = taskSourceType;
  }
  
  public final static String P_TaskSourceType = "taskSourceType";
  
  public static IObjectFieldAccessor<UICenterlizedDeliverTask,UITaskSourceType> TaskSourceTypeAccessor = new IObjectFieldAccessor<UICenterlizedDeliverTask,UITaskSourceType>(){
    				public com.fudanmed.platform.core.web.shared.deliver.UITaskSourceType getValue(UICenterlizedDeliverTask object){
    					return object.getTaskSourceType();
    				}
    				public void setValue(UICenterlizedDeliverTask object,com.fudanmed.platform.core.web.shared.deliver.UITaskSourceType value){
    					object.setTaskSourceType(value);
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
  
  public static IObjectFieldAccessor<UICenterlizedDeliverTask,RCEmployeeProxy> OperatorAccessor = new IObjectFieldAccessor<UICenterlizedDeliverTask,RCEmployeeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy getValue(UICenterlizedDeliverTask object){
    					return object.getOperator();
    				}
    				public void setValue(UICenterlizedDeliverTask object,com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy value){
    					object.setOperator(value);
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
  
  public static IObjectFieldAccessor<UICenterlizedDeliverTask,Date> PlanDateAccessor = new IObjectFieldAccessor<UICenterlizedDeliverTask,Date>(){
    				public java.util.Date getValue(UICenterlizedDeliverTask object){
    					return object.getPlanDate();
    				}
    				public void setValue(UICenterlizedDeliverTask object,java.util.Date value){
    					object.setPlanDate(value);
    				}
    			};
  
  private Date planTime;
  
  public Date getPlanTime() {
    return this.planTime;
  }
  
  public void setPlanTime(final Date planTime) {
    this.planTime = planTime;
  }
  
  public final static String P_PlanTime = "planTime";
  
  public static IObjectFieldAccessor<UICenterlizedDeliverTask,Date> PlanTimeAccessor = new IObjectFieldAccessor<UICenterlizedDeliverTask,Date>(){
    				public java.util.Date getValue(UICenterlizedDeliverTask object){
    					return object.getPlanTime();
    				}
    				public void setValue(UICenterlizedDeliverTask object,java.util.Date value){
    					object.setPlanTime(value);
    				}
    			};
  
  private UICenterlizedDeliverTaskStatus status;
  
  public UICenterlizedDeliverTaskStatus getStatus() {
    return this.status;
  }
  
  public void setStatus(final UICenterlizedDeliverTaskStatus status) {
    this.status = status;
  }
  
  public final static String P_Status = "status";
  
  public static IObjectFieldAccessor<UICenterlizedDeliverTask,UICenterlizedDeliverTaskStatus> StatusAccessor = new IObjectFieldAccessor<UICenterlizedDeliverTask,UICenterlizedDeliverTaskStatus>(){
    				public com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTaskStatus getValue(UICenterlizedDeliverTask object){
    					return object.getStatus();
    				}
    				public void setValue(UICenterlizedDeliverTask object,com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTaskStatus value){
    					object.setStatus(value);
    				}
    			};
  
  public DLCenterlizedDeliverTaskProxy toProxy() {
    return (DLCenterlizedDeliverTaskProxy)super.toProxy();
    
  }
}
