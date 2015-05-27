package edu.fudan.langlab.domain.task.impl;

import edu.fudan.langlab.domain.organization.Party;
import edu.fudan.langlab.domain.task.NormalTask;
import edu.fudan.langlab.domain.task.Task;
import edu.fudan.langlab.domain.task.TaskEventListener;
import edu.fudan.langlab.domain.task.TaskService;
import edu.fudan.langlab.domain.task.impl.NormalTaskImpl;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IGenericQuery;
import edu.fudan.mylang.utils.DateUtil;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("edu.fudan.langlab.domain.task.TaskService")
public class TaskServiceImpl extends BaseService implements TaskService {
  @Autowired
  private Collection<TaskEventListener> taskEventListeners;
  
  public Collection<Task> findTasks4Owner(final Party owner) {
    IGenericQuery<Task> query=getObjectFactory().createGenericQuery(Task.class,"select task from edu.fudan.langlab.domain.task.impl.TaskImpl as task   where (task.owner = :owner) and  task.active = 1  order by task.genDate ASC    ").setParameter("owner",owner);
    Collection<Task> _list = query.list();
    return _list;
  }
  
  public NormalTask registerNormalTask(final Procedure1<? super NormalTask> preInitializer) {NormalTask normalTask=NormalTaskImpl.create(getObjectFactory());
    final Procedure1<NormalTask> _function = new Procedure1<NormalTask>() {
        public void apply(final NormalTask it) {
          preInitializer.apply(it);
          it.setTaskType("__NormalTask__");
          Date _now = DateUtil.now();
          it.setGenDate(_now);
          TaskServiceImpl.this.notifyTaskCreated(it);
        }
      };
    NormalTask _doubleArrow = ObjectExtensions.<NormalTask>operator_doubleArrow(normalTask, _function);
    return _doubleArrow;
  }
  
  public void deleteNormalTask(final NormalTask task) {
    this.notifyTaskTeBeDeleted(task);getObjectFactory().delete(task);
    
  }
  
  public void redistributeTask(final Task task, final Party party) {
    task.setOwner(party);
  }
  
  public void notifyTaskCreated(final Task task) {
    final Procedure1<TaskEventListener> _function = new Procedure1<TaskEventListener>() {
        public void apply(final TaskEventListener it) {
          it.afterTaskCreated(task);
        }
      };
    IterableExtensions.<TaskEventListener>forEach(this.taskEventListeners, _function);
  }
  
  public void notifyTaskTeBeDeleted(final Task task) {
    final Procedure1<TaskEventListener> _function = new Procedure1<TaskEventListener>() {
        public void apply(final TaskEventListener it) {
          it.beforeTaskDelete(task);
        }
      };
    IterableExtensions.<TaskEventListener>forEach(this.taskEventListeners, _function);
  }
}
