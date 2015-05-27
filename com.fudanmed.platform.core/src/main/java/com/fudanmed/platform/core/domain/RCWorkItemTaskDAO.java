package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import edu.fudan.mylang.pf.IDAOService;

public interface RCWorkItemTaskDAO extends IDAOService<RCWorkItemTask> {
  public abstract Boolean workerIsBusy(final RCEmployee employee);
}
