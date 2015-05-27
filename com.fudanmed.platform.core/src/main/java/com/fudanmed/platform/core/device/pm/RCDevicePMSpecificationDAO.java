package com.fudanmed.platform.core.device.pm;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.pm.RCDevicePMSpecification;
import edu.fudan.mylang.pf.IDAOService;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public interface RCDevicePMSpecificationDAO extends IDAOService<RCDevicePMSpecification> {
  public abstract RCDevicePMSpecification create(final Procedure1<? super RCDevicePMSpecification> preInit);
  
  public abstract void delete(final RCDevicePMSpecification value, final Procedure1<? super RCDevicePMSpecification> postProc);
  
  public abstract Collection<RCDevicePMSpecification> findByDevice(final RCDevice device);
  
  public abstract void batchInitializePMPlanUptoYear(final Integer year);
  
  public abstract void batchInitializePMPlanUptoYear(final RCDevice device, final Date fromDate, final Integer year);
}
