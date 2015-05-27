package com.fudanmed.platform.core.device.pm;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.pm.RCPMWorkItem;
import edu.fudan.mylang.pf.IDAOService;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public interface RCPMWorkItemDAO extends IDAOService<RCPMWorkItem> {
  public abstract RCPMWorkItem create(final Procedure1<? super RCPMWorkItem> preInit);
  
  public abstract void delete(final RCPMWorkItem e, final Procedure1<? super RCPMWorkItem> postAction);
  
  public abstract void update(final RCPMWorkItem e, final Procedure1<? super RCPMWorkItem> updator);
  
  public abstract Collection<RCPMWorkItem> findWorkItem4Device(final RCDevice device);
}
