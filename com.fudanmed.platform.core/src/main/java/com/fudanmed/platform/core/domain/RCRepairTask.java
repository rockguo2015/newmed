package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.common.RCFaultEmergencyLevel;
import com.fudanmed.platform.core.common.RCFaultLevel;
import com.fudanmed.platform.core.common.RCFaultReportSource;
import com.fudanmed.platform.core.domain.RCComplaint;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCFaultType;
import com.fudanmed.platform.core.domain.RCGroupTask;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCRepairEvaluate;
import com.fudanmed.platform.core.domain.RCRepairTaskStatus;
import com.fudanmed.platform.core.domain.RCSettlement;
import com.fudanmed.platform.core.domain.RCTaskDirtyManager;
import com.fudanmed.platform.core.domain.impl.RCRepairTaskImpl;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.warehouse.RCWorkItemStorage;
import edu.fudan.langlab.domain.document.IDocument;
import edu.fudan.langlab.domain.document.IHasDocuments;
import edu.fudan.langlab.domain.organization.Party;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Collection;
import java.util.Date;

@EntityImplementation(implementBy = RCRepairTaskImpl.class)
public interface RCRepairTask extends IModelObject, IHasDocuments {
  public abstract RCFaultReportSource getFaultReportSource();
  
  public abstract RCRepairTask setFaultReportSource(final RCFaultReportSource faultReportSource);
  
  public abstract String getReportSid();
  
  public abstract RCRepairTask setReportSid(final String reportSid);
  
  public abstract Date getReportDate();
  
  public abstract RCRepairTask setReportDate(final Date reportDate);
  
  public abstract Date getReportTime();
  
  public abstract RCRepairTask setReportTime(final Date reportTime);
  
  public abstract Date getReserveDate();
  
  public abstract RCRepairTask setReserveDate(final Date reserveDate);
  
  public abstract Date getReserveTime();
  
  public abstract RCRepairTask setReserveTime(final Date reserveTime);
  
  public abstract Date getPlanFinishDate();
  
  public abstract RCRepairTask setPlanFinishDate(final Date planFinishDate);
  
  public abstract Date getPlanFinishTime();
  
  public abstract RCRepairTask setPlanFinishTime(final Date planFinishTime);
  
  public abstract Date getFinishDate();
  
  public abstract RCRepairTask setFinishDate(final Date finishDate);
  
  public abstract Date getFinishTime();
  
  public abstract RCRepairTask setFinishTime(final Date finishTime);
  
  public abstract String getLocation();
  
  public abstract RCRepairTask setLocation(final String location);
  
  public abstract String getComment();
  
  public abstract RCRepairTask setComment(final String comment);
  
  public abstract RCEmployee getReporter();
  
  public abstract RCRepairTask setReporter(final RCEmployee reporter);
  
  public abstract String getReporterName();
  
  public abstract RCRepairTask setReporterName(final String reporterName);
  
  public abstract String getReporterPhone();
  
  public abstract RCRepairTask setReporterPhone(final String reporterPhone);
  
  public abstract RCOrganization getReportOrg();
  
  public abstract RCRepairTask setReportOrg(final RCOrganization reportOrg);
  
  public abstract RCFaultLevel getFaultLevel();
  
  public abstract RCRepairTask setFaultLevel(final RCFaultLevel faultLevel);
  
  public abstract RCFaultEmergencyLevel getFaultEmergencyLevel();
  
  public abstract RCRepairTask setFaultEmergencyLevel(final RCFaultEmergencyLevel faultEmergencyLevel);
  
  public abstract RCFaultType getFaultType();
  
  public abstract RCRepairTask setFaultType(final RCFaultType faultType);
  
  public abstract Boolean getIsFromReporter();
  
  public abstract RCRepairTask setIsFromReporter(final Boolean isFromReporter);
  
  public abstract Party getOperator();
  
  public abstract RCRepairTask setOperator(final Party operator);
  
  public abstract String getMonth();
  
  public abstract RCRepairTask setMonth(final String month);
  
  public abstract Collection<RCGroupTask> getGroupTasks();
  
  public abstract RCGroupTask createAndAddtoGroupTasks();
  
  public abstract RCRepairTask removeFromGroupTasks(final RCGroupTask rCGroupTask);
  
  public abstract RCRepairTask removeAllGroupTasks();
  
  public abstract Collection<RCComplaint> getComplaints();
  
  public abstract RCComplaint createAndAddtoComplaints();
  
  public abstract RCRepairTask removeFromComplaints(final RCComplaint rCComplaint);
  
  public abstract RCRepairTask removeAllComplaints();
  
  public abstract RCGroupTask getActiveGroupTask();
  
  public abstract RCRepairTask setActiveGroupTask(final RCGroupTask activeGroupTask);
  
  public abstract RCSettlement getSettlement();
  
  public abstract RCRepairTask setSettlement(final RCSettlement settlement);
  
  public abstract RCRepairEvaluate getRepairEvaluate();
  
  public abstract RCRepairTask setRepairEvaluate(final RCRepairEvaluate repairEvaluate);
  
  public abstract void attachToSettlement(final RCSettlement settlement);
  
  public abstract void cancelSettlement();
  
  public abstract Boolean isEnd();
  
  public abstract Collection<RCWorkItemStorage> getStorage();
  
  public abstract RCTaskDirtyManager getTaskDirtyManager();
  
  public abstract RCComplaint createCompaint();
  
  public abstract Double getAmount();
  
  public abstract Boolean isColsed();
  
  public abstract void updateDerived();
  
  public abstract Collection<? extends IDocument> getDocuments();
  
  public abstract RCRepairTaskStatus getStatus();
  
  public abstract void start(final Boolean byReporter);
  
  public abstract void cancel();
  
  public abstract void updated();
  
  public abstract void firstWorkItemCreated();
  
  public abstract void misdispatch(final RCGroupTask groupTask);
  
  public abstract void groupTaskFinished(final RCGroupTask groupTask);
  
  public abstract void close();
  
  public abstract void createGroupTask(final RCMaintenanceTeam team);
  
  public abstract Boolean isNewCreated();
  
  public abstract Boolean isScheduled();
  
  public abstract Boolean isWait4SchedulerProcess();
  
  public abstract Boolean isWait4GroupTaskFinish();
  
  public abstract Boolean isWait4Close();
  
  public abstract Boolean isClosed();
  
  public abstract Boolean isCancel();
  
  public abstract RCRepairTaskProxy toProxy();
}
