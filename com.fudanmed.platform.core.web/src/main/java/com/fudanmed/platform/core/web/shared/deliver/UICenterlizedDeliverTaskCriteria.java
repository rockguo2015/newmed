package com.fudanmed.platform.core.web.shared.deliver;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.shared.deliver.UITaskSourceType;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;
import java.util.Date;

public class UICenterlizedDeliverTaskCriteria implements IsSerializable, IPagedCriteria {
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public void setSid(final String sid) {
    this.sid = sid;
  }
  
  public final static String P_Sid = "sid";
  
  public static IObjectFieldAccessor<UICenterlizedDeliverTaskCriteria,String> SidAccessor = new IObjectFieldAccessor<UICenterlizedDeliverTaskCriteria,String>(){
    				public String getValue(UICenterlizedDeliverTaskCriteria object){
    					return object.getSid();
    				}
    				public void setValue(UICenterlizedDeliverTaskCriteria object,String value){
    					object.setSid(value);
    				}
    			};
  
  private Date createTimeFrom;
  
  public Date getCreateTimeFrom() {
    return this.createTimeFrom;
  }
  
  public void setCreateTimeFrom(final Date createTimeFrom) {
    this.createTimeFrom = createTimeFrom;
  }
  
  public final static String P_CreateTimeFrom = "createTimeFrom";
  
  public static IObjectFieldAccessor<UICenterlizedDeliverTaskCriteria,Date> CreateTimeFromAccessor = new IObjectFieldAccessor<UICenterlizedDeliverTaskCriteria,Date>(){
    				public java.util.Date getValue(UICenterlizedDeliverTaskCriteria object){
    					return object.getCreateTimeFrom();
    				}
    				public void setValue(UICenterlizedDeliverTaskCriteria object,java.util.Date value){
    					object.setCreateTimeFrom(value);
    				}
    			};
  
  private Date createTimeTo;
  
  public Date getCreateTimeTo() {
    return this.createTimeTo;
  }
  
  public void setCreateTimeTo(final Date createTimeTo) {
    this.createTimeTo = createTimeTo;
  }
  
  public final static String P_CreateTimeTo = "createTimeTo";
  
  public static IObjectFieldAccessor<UICenterlizedDeliverTaskCriteria,Date> CreateTimeToAccessor = new IObjectFieldAccessor<UICenterlizedDeliverTaskCriteria,Date>(){
    				public java.util.Date getValue(UICenterlizedDeliverTaskCriteria object){
    					return object.getCreateTimeTo();
    				}
    				public void setValue(UICenterlizedDeliverTaskCriteria object,java.util.Date value){
    					object.setCreateTimeTo(value);
    				}
    			};
  
  private RCEmployeeProxy performer;
  
  public RCEmployeeProxy getPerformer() {
    return this.performer;
  }
  
  public void setPerformer(final RCEmployeeProxy performer) {
    this.performer = performer;
  }
  
  public final static String P_Performer = "performer";
  
  public static IObjectFieldAccessor<UICenterlizedDeliverTaskCriteria,RCEmployeeProxy> PerformerAccessor = new IObjectFieldAccessor<UICenterlizedDeliverTaskCriteria,RCEmployeeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy getValue(UICenterlizedDeliverTaskCriteria object){
    					return object.getPerformer();
    				}
    				public void setValue(UICenterlizedDeliverTaskCriteria object,com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy value){
    					object.setPerformer(value);
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
  
  public static IObjectFieldAccessor<UICenterlizedDeliverTaskCriteria,UITaskSourceType> TaskSourceTypeAccessor = new IObjectFieldAccessor<UICenterlizedDeliverTaskCriteria,UITaskSourceType>(){
    				public com.fudanmed.platform.core.web.shared.deliver.UITaskSourceType getValue(UICenterlizedDeliverTaskCriteria object){
    					return object.getTaskSourceType();
    				}
    				public void setValue(UICenterlizedDeliverTaskCriteria object,com.fudanmed.platform.core.web.shared.deliver.UITaskSourceType value){
    					object.setTaskSourceType(value);
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
