package com.fudanmed.platform.core.domain;

public enum RCGroupTaskStatus {
  newCreated,

  wait4TeamOwnerProcess,

  wait4TasksFinish,

  finished,

  misDispatched,

  canceled;
}
