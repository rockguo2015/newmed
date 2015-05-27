package edu.fudan.langlab.domain.updater;

import edu.fudan.langlab.domain.updater.impl.UPSystemUpdateStatusImpl;
import edu.fudan.langlab.domain.updater.proxy.UPSystemUpdateStatusProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;

@EntityImplementation(implementBy = UPSystemUpdateStatusImpl.class)
public interface UPSystemUpdateStatus extends IModelObject {
  public abstract String getCurVersion();
  
  public abstract UPSystemUpdateStatus setCurVersion(final String curVersion);
  
  public abstract UPSystemUpdateStatusProxy toProxy();
}
