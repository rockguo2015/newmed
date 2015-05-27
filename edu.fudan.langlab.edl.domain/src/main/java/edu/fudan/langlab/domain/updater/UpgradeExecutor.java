package edu.fudan.langlab.domain.updater;

import edu.fudan.mylang.pf.IBaseService;

public interface UpgradeExecutor extends IBaseService {
  public abstract void execute();
}
