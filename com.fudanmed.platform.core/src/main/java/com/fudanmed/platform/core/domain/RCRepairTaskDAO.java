package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCRepairTask;
import edu.fudan.mylang.pf.IDAOService;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public interface RCRepairTaskDAO extends IDAOService<RCRepairTask> {
  public abstract RCRepairTask createRepairTask4Reporter(final Procedure1<? super RCRepairTask> postCreate);
}
