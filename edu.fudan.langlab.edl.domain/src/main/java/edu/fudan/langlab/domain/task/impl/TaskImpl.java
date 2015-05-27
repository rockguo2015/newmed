package edu.fudan.langlab.domain.task.impl;

import edu.fudan.langlab.domain.organization.Party;
import edu.fudan.langlab.domain.organization.impl.PartyImpl;
import edu.fudan.langlab.domain.task.Task;
import edu.fudan.langlab.domain.task.proxy.TaskProxy;
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
@DiscriminatorValue("TASK_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "task")
public abstract class TaskImpl extends BaseModelObject implements Task {
  public TaskImpl() {
    super();
  }
  
  private String taskType;
  
  public String getTaskType() {
    return this.taskType;
  }
  
  public Task setTaskType(final String taskType) {
    this.taskType = taskType;
    return this;			
    
  }
  
  @JoinColumn(name = "owner_id")
  @ManyToOne(targetEntity = PartyImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private Party owner;
  
  public Party getOwner() {
    return this.owner;
  }
  
  public Task setOwner(final Party owner) {
    this.owner = owner;
    return this;			
    
  }
  
  private Date genDate;
  
  public Date getGenDate() {
    return this.genDate;
  }
  
  public Task setGenDate(final Date genDate) {
    this.genDate = genDate;
    return this;			
    
  }
  
  private Date dueDate;
  
  public Date getDueDate() {
    return this.dueDate;
  }
  
  public Task setDueDate(final Date dueDate) {
    this.dueDate = dueDate;
    return this;			
    
  }
  
  private String description;
  
  public String getDescription() {
    return this.description;
  }
  
  public Task setDescription(final String description) {
    this.description = description;
    return this;			
    
  }
  
  public String getEntityName() {
    return this.description;
  }
  
  public void forwardTo(final Party newOwner) {
    this.owner = newOwner;
  }
  
  public TaskProxy toProxy() {
    edu.fudan.langlab.domain.task.proxy.TaskProxy proxy = new edu.fudan.langlab.domain.task.proxy.TaskProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
