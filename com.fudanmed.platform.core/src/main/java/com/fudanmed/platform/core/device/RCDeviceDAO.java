package com.fudanmed.platform.core.device;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.RCDeviceType;
import edu.fudan.mylang.pf.IDAOService;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public interface RCDeviceDAO extends IDAOService<RCDevice> {
  public abstract RCDevice createDevice(final String sid, final Procedure1<? super RCDevice> preInit);
  
  public abstract void update(final RCDevice device, final Procedure1<? super RCDevice> updater);
  
  public abstract void delete(final RCDevice device, final Procedure1<? super RCDevice> postProc);
  
  public abstract RCDevice findDeviceBySid(final String sid);
  
  public abstract Collection<RCDevice> findDevicesByType(final RCDeviceType deviceType);
}
