package com.fudanmed.platform.core.domain;

public enum RCRepairTaskStatus {
  newCreated,

  scheduled,

  wait4SchedulerProcess,

  wait4GroupTaskFinish,

  wait4Close,

  closed,

  cancel;
}
