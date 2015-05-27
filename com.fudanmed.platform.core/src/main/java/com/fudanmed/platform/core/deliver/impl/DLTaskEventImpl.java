package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLTask;
import com.fudanmed.platform.core.deliver.DLTaskEvent;
import com.fudanmed.platform.core.deliver.impl.DLTaskImpl;
import com.fudanmed.platform.core.deliver.proxy.DLTaskEventProxy;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.impl.RCEmployeeImpl;
import edu.fudan.mylang.pf.BaseModelObject;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("DLTASKEVENT_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "dltaskevent")
public abstract class DLTaskEventImpl extends BaseModelObject implements DLTaskEvent {
  public DLTaskEventImpl() {
    super();
  }
  
  public DLTaskEventImpl(final DLTask task) {
    super();
    this.task = task;
  }
  
  private Date createTime;
  
  public Date getCreateTime() {
    return this.createTime;
  }
  
  public DLTaskEvent setCreateTime(final Date createTime) {
    this.createTime = createTime;
    return this;			
    
  }
  
  @JoinColumn(name = "operator_id")
  @ManyToOne(targetEntity = RCEmployeeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCEmployee operator;
  
  public RCEmployee getOperator() {
    return this.operator;
  }
  
  public DLTaskEvent setOperator(final RCEmployee operator) {
    this.operator = operator;
    return this;			
    
  }
  
  @JoinColumn(name = "task_id")
  @ManyToOne(targetEntity = DLTaskImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private DLTask task;
  
  public DLTask getTask() {
    return this.task;
  }
  
  public DLTaskEvent setTask(final DLTask task) {
    this.task = task;
    return this;			
    
  }
  
  public DLTaskEventProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLTaskEventProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLTaskEventProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
