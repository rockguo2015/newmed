package edu.fudan.langlab.domain.task;

import edu.fudan.langlab.domain.organization.Party;
import edu.fudan.langlab.domain.task.impl.TaskImpl;
import edu.fudan.langlab.domain.task.proxy.TaskProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.INamedModelObject;
import java.util.Date;

@EntityImplementation(implementBy = TaskImpl.class)
public interface Task extends IModelObject, INamedModelObject {
  public abstract String getTaskCategory();
  
  public abstract String getTaskType();
  
  public abstract Task setTaskType(final String taskType);
  
  public abstract String getTaskTypeName();
  
  public abstract Party getOwner();
  
  public abstract Task setOwner(final Party owner);
  
  public abstract Date getGenDate();
  
  public abstract Task setGenDate(final Date genDate);
  
  public abstract Date getDueDate();
  
  public abstract Task setDueDate(final Date dueDate);
  
  public abstract String getDescription();
  
  public abstract Task setDescription(final String description);
  
  public abstract String getEntityName();
  
  public abstract void forwardTo(final Party newOwner);
  
  public abstract TaskProxy toProxy();
}
