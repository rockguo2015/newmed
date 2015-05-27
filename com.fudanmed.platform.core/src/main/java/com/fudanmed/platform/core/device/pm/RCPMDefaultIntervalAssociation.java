package com.fudanmed.platform.core.device.pm;

import com.fudanmed.platform.core.device.pm.RCDevicePMType;
import com.fudanmed.platform.core.device.pm.RCPMDeviceTypeEntry;
import com.fudanmed.platform.core.device.pm.impl.RCPMDefaultIntervalAssociationImpl;
import com.fudanmed.platform.core.device.pm.proxy.RCPMDefaultIntervalAssociationProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@EntityImplementation(implementBy = RCPMDefaultIntervalAssociationImpl.class)
public interface RCPMDefaultIntervalAssociation extends IModelObject {
  public abstract RCPMDeviceTypeEntry getEntry();
  
  public abstract RCPMDefaultIntervalAssociation setEntry(final RCPMDeviceTypeEntry entry);
  
  public abstract RCDevicePMType getType();
  
  public abstract RCPMDefaultIntervalAssociation setType(final RCDevicePMType type);
  
  public abstract Integer getIntervalInDays();
  
  public abstract RCPMDefaultIntervalAssociation setIntervalInDays(final Integer intervalInDays);
  
  public abstract String getDescription();
  
  public abstract RCPMDefaultIntervalAssociation setDescription(final String description);
  
  public abstract void update(final Procedure1<? super RCPMDefaultIntervalAssociation> updater);
  
  public abstract RCPMDefaultIntervalAssociationProxy toProxy();
}
