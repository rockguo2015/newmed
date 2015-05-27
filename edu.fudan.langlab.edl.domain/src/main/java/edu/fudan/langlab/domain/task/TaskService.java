package edu.fudan.langlab.domain.task;

import edu.fudan.langlab.domain.organization.Party;
import edu.fudan.langlab.domain.task.NormalTask;
import edu.fudan.langlab.domain.task.Task;
import edu.fudan.mylang.pf.IBaseService;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public interface TaskService extends IBaseService {
  public abstract Collection<Task> findTasks4Owner(final Party owner);
  
  public abstract NormalTask registerNormalTask(final Procedure1<? super NormalTask> preInitializer);
  
  public abstract void deleteNormalTask(final NormalTask task);
  
  public abstract void redistributeTask(final Task task, final Party party);
  
  public abstract void notifyTaskCreated(final Task task);
  
  public abstract void notifyTaskTeBeDeleted(final Task task);
}
