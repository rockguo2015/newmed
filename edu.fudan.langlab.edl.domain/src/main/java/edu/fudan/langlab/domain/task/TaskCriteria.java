package edu.fudan.langlab.domain.task;

import edu.fudan.langlab.domain.organization.Party;
import edu.fudan.langlab.domain.task.Task;
import edu.fudan.langlab.domain.task.impl.TaskCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;
import java.util.Date;

@QueryImplementation(implementBy = TaskCriteriaImpl.class)
public interface TaskCriteria extends IPagedCriteria<Task> {
  public abstract Party getOwner();
  
  public abstract TaskCriteria setOwner(final Party owner);
  
  public abstract Date getGenDateFrom();
  
  public abstract TaskCriteria setGenDateFrom(final Date genDateFrom);
  
  public abstract Date getGenDateTo();
  
  public abstract TaskCriteria setGenDateTo(final Date genDateTo);
  
  public abstract Date getDueDateFrom();
  
  public abstract TaskCriteria setDueDateFrom(final Date dueDateFrom);
  
  public abstract Date getDueDateTo();
  
  public abstract TaskCriteria setDueDateTo(final Date dueDateTo);
  
  public abstract String getDescription();
  
  public abstract TaskCriteria setDescription(final String description);
}
