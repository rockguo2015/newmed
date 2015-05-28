package com.fudanmed.platform.core.web.shared.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.shared.deliver.UITaskSourceType;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Collection;
import java.util.Date;

public class UITask extends GWTEntity {
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public void setSid(final String sid) {
    this.sid = sid;
  }
  
  public final static String P_Sid = "sid";
  
  public static IObjectFieldAccessor<UITask,String> SidAccessor = new IObjectFieldAccessor<UITask,String>(){
    				public String getValue(UITask object){
    					return object.getSid();
    				}
    				public void setValue(UITask object,String value){
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
  
  public static IObjectFieldAccessor<UITask,Date> CreateTimeAccessor = new IObjectFieldAccessor<UITask,Date>(){
    				public java.util.Date getValue(UITask object){
    					return object.getCreateTime();
    				}
    				public void setValue(UITask object,java.util.Date value){
    					object.setCreateTime(value);
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
  
  public static IObjectFieldAccessor<UITask,Collection<RCEmployeeProxy>> PerformersAccessor = new IObjectFieldAccessor<UITask,Collection<RCEmployeeProxy>>(){
    				public java.util.Collection<com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy> getValue(UITask object){
    					return object.getPerformers();
    				}
    				public void setValue(UITask object,java.util.Collection<com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy> value){
    					object.setPerformers(value);
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
  
  public static IObjectFieldAccessor<UITask,RCEmployeeProxy> OperatorAccessor = new IObjectFieldAccessor<UITask,RCEmployeeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy getValue(UITask object){
    					return object.getOperator();
    				}
    				public void setValue(UITask object,com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy value){
    					object.setOperator(value);
    				}
    			};
  
  private UITaskSourceType taskSource;
  
  public UITaskSourceType getTaskSource() {
    return this.taskSource;
  }
  
  public void setTaskSource(final UITaskSourceType taskSource) {
    this.taskSource = taskSource;
  }
  
  public final static String P_TaskSource = "taskSource";
  
  public static IObjectFieldAccessor<UITask,UITaskSourceType> TaskSourceAccessor = new IObjectFieldAccessor<UITask,UITaskSourceType>(){
    				public com.fudanmed.platform.core.web.shared.deliver.UITaskSourceType getValue(UITask object){
    					return object.getTaskSource();
    				}
    				public void setValue(UITask object,com.fudanmed.platform.core.web.shared.deliver.UITaskSourceType value){
    					object.setTaskSource(value);
    				}
    			};
  
  public DLTaskProxy toProxy() {
    return (DLTaskProxy)super.toProxy();
    
  }
}
