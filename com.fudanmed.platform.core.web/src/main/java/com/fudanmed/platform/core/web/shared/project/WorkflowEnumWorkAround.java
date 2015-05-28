package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.domain.RCEvaluateState;
import com.fudanmed.platform.core.domain.RCGroupTaskCriteria;
import com.fudanmed.platform.core.domain.RCGroupTaskStatus;
import com.fudanmed.platform.core.domain.RCRepairTask4SettlementCriteria;
import com.fudanmed.platform.core.domain.RCRepairTaskCriteria;
import com.fudanmed.platform.core.domain.RCRepairTaskStatus;
import com.fudanmed.platform.core.domain.RCWorkItemTaskCriteria;
import com.fudanmed.platform.core.domain.RCWorkItemTaskStatus;

@SuppressWarnings("all")
public class WorkflowEnumWorkAround {
  public static void initGroupTaskCriteria(final RCGroupTaskCriteria c) {
    c.setFinishedStatus(RCGroupTaskStatus.finished);
    c.setMisDispatchedStatus(RCGroupTaskStatus.misDispatched);
    c.setCancelStatus(RCGroupTaskStatus.canceled);
  }
  
  public static void initRepairTaskCriteria(final RCRepairTaskCriteria c) {
    c.setCloseStatus(RCRepairTaskStatus.closed);
    c.setCancelStatus(RCRepairTaskStatus.cancel);
    c.setAutoCommitState(RCEvaluateState.autoCommitted);
    c.setFinishState(RCEvaluateState.finished);
  }
  
  public static void initWorkItemTaskCriteria(final RCWorkItemTaskCriteria c) {
    c.setProcessingStatus(RCWorkItemTaskStatus.processing);
  }
  
  public static void initRepairTask4SettlementCriteria(final RCRepairTask4SettlementCriteria c) {
    c.setCloseStatus(RCRepairTaskStatus.closed);
  }
}
