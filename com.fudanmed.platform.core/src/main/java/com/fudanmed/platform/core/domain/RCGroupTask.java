package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCGroupTaskStatus;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCTaskDirtyManager;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.impl.RCGroupTaskImpl;
import com.fudanmed.platform.core.domain.proxy.RCGroupTaskProxy;
import com.fudanmed.platform.core.warehouse.RCWorkItemStorage;
import edu.fudan.langlab.domain.document.IDocument;
import edu.fudan.langlab.domain.document.IHasDocuments;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Collection;
import java.util.Date;

@EntityImplementation(implementBy = RCGroupTaskImpl.class)
public interface RCGroupTask extends IModelObject, IHasDocuments {
  public abstract RCRepairTask getRepairTask();
  
  public abstract RCGroupTask setRepairTask(final RCRepairTask repairTask);
  
  public abstract RCMaintenanceTeam getTeam();
  
  public abstract RCGroupTask setTeam(final RCMaintenanceTeam team);
  
  public abstract Date getDate();
  
  public abstract RCGroupTask setDate(final Date date);
  
  public abstract Date getTime();
  
  public abstract RCGroupTask setTime(final Date time);
  
  public abstract String getComment();
  
  public abstract RCGroupTask setComment(final String comment);
  
  public abstract Date getFinishDate();
  
  public abstract RCGroupTask setFinishDate(final Date finishDate);
  
  public abstract Date getFinishTime();
  
  public abstract RCGroupTask setFinishTime(final Date finishTime);
  
  public abstract RCEmployee getOperator();
  
  public abstract RCGroupTask setOperator(final RCEmployee operator);
  
  public abstract String getMonth();
  
  public abstract RCGroupTask setMonth(final String month);
  
  public abstract Collection<RCWorkItemTask> getTasks();
  
  public abstract RCWorkItemTask createAndAddtoTasks();
  
  public abstract RCGroupTask removeFromTasks(final RCWorkItemTask rCWorkItemTask);
  
  public abstract RCGroupTask removeAllTasks();
  
  public abstract Double getAmount();
  
  public abstract Boolean allTasksFinished();
  
  public abstract Boolean allTasksFinishedExcept(final RCWorkItemTask task);
  
  public abstract void updateDerived();
  
  public abstract Boolean hasMisDispatchedTask();
  
  public abstract Boolean isEnd();
  
  public abstract Collection<RCWorkItemStorage> getStorage();
  
  public abstract RCTaskDirtyManager getTaskDirtyManager();
  
  public abstract Collection<? extends IDocument> getDocuments();
  
  public abstract RCWorkItemTask createWorkItemTask();
  
  public abstract RCGroupTaskStatus getStatus();
  
  public abstract void start();
  
  public abstract void reportFinish();
  
  public abstract void cancel();
  
  public abstract void reportMisdispatch();
  
  public abstract void taskCreated(final RCWorkItemTask task);
  
  public abstract void taskFinished(final RCWorkItemTask task);
  
  public abstract Boolean isNewCreated();
  
  public abstract Boolean isWait4TeamOwnerProcess();
  
  public abstract Boolean isWait4TasksFinish();
  
  public abstract Boolean isFinished();
  
  public abstract Boolean isMisDispatched();
  
  public abstract Boolean isCanceled();
  
  public abstract RCGroupTaskProxy toProxy();
}
