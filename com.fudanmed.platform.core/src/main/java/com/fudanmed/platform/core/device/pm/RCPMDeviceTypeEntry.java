package com.fudanmed.platform.core.device.pm;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.pm.RCPMDefaultIntervalAssociation;
import com.fudanmed.platform.core.device.pm.impl.RCPMDeviceTypeEntryImpl;
import com.fudanmed.platform.core.device.pm.proxy.RCPMDeviceTypeEntryProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@EntityImplementation(implementBy = RCPMDeviceTypeEntryImpl.class)
public interface RCPMDeviceTypeEntry extends IModelObject {
  public abstract RCDeviceType getDeviceType();
  
  public abstract RCPMDeviceTypeEntry setDeviceType(final RCDeviceType deviceType);
  
  public abstract Collection<RCPMDefaultIntervalAssociation> getIntervals();
  
  public abstract RCPMDefaultIntervalAssociation createAndAddtoIntervals();
  
  public abstract RCPMDeviceTypeEntry removeFromIntervals(final RCPMDefaultIntervalAssociation rCPMDefaultIntervalAssociation);
  
  public abstract RCPMDeviceTypeEntry removeAllIntervals();
  
  public abstract RCPMDefaultIntervalAssociation createInterval(final Procedure1<? super RCPMDefaultIntervalAssociation> init);
  
  public abstract void removeInterval(final RCPMDefaultIntervalAssociation interval);
  
  public abstract void populateToDevice(final RCDevice device);
  
  public abstract RCPMDeviceTypeEntryProxy toProxy();
}
