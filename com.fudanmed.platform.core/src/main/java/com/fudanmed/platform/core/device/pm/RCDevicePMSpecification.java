package com.fudanmed.platform.core.device.pm;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.pm.RCDevicePMPlan;
import com.fudanmed.platform.core.device.pm.RCDevicePMType;
import com.fudanmed.platform.core.device.pm.impl.RCDevicePMSpecificationImpl;
import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMSpecificationProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@EntityImplementation(implementBy = RCDevicePMSpecificationImpl.class)
public interface RCDevicePMSpecification extends IModelObject {
  public abstract RCDevice getDevice();
  
  public abstract RCDevicePMSpecification setDevice(final RCDevice device);
  
  public abstract RCDevicePMType getPmType();
  
  public abstract RCDevicePMSpecification setPmType(final RCDevicePMType pmType);
  
  public abstract String getDescription();
  
  public abstract RCDevicePMSpecification setDescription(final String description);
  
  public abstract Integer getIntervalInDays();
  
  public abstract RCDevicePMSpecification setIntervalInDays(final Integer intervalInDays);
  
  public abstract Date getLastPMPlanDate();
  
  public abstract RCDevicePMSpecification setLastPMPlanDate(final Date lastPMPlanDate);
  
  public abstract Collection<RCDevicePMPlan> getPlans();
  
  public abstract RCDevicePMPlan createAndAddtoPlans();
  
  public abstract RCDevicePMSpecification removeFromPlans(final RCDevicePMPlan rCDevicePMPlan);
  
  public abstract RCDevicePMSpecification removeAllPlans();
  
  public abstract void removePlan(final RCDevicePMPlan plan);
  
  public abstract RCDevicePMPlan createPlan(final Procedure1<? super RCDevicePMPlan> init);
  
  /**
   * 从指定日期开始生成到指定年内的PM计划
   */
  public abstract void initializePMPlanUptoYear(final Date startDate, final Integer year);
  
  public abstract RCDevicePMSpecificationProxy toProxy();
}
