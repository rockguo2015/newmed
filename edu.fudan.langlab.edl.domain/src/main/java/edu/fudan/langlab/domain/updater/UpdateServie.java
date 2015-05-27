package edu.fudan.langlab.domain.updater;

import edu.fudan.langlab.domain.updater.UPSystemUpdateStatus;
import edu.fudan.mylang.pf.IBaseService;

public interface UpdateServie extends IBaseService {
  public abstract UPSystemUpdateStatus getSystemUpdateStatus();
  
  public abstract Boolean canPerformUpdate(final String upgrader, final String fromVersion, final String updaterTag);
  
  public abstract void updaterCommited(final String upgrader, final String fromVersion, final String updaterTag);
  
  public abstract void upgraderCommited(final String fromVersion, final String toVersion);
}
