package com.fudanmed.platform.core.web.shared.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCPMDeviceTypeEntryProxy;
import com.fudanmed.platform.core.web.shared.device.UIPMDefaultIntervalAssociation;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Collection;

public class UIPMDeviceTypeEntry extends GWTEntity {
  private Collection<UIPMDefaultIntervalAssociation> intervals = com.google.common.collect.Lists.newArrayList();
  
  public Collection<UIPMDefaultIntervalAssociation> getIntervals() {
    return this.intervals;
  }
  
  public void setIntervals(final Collection<UIPMDefaultIntervalAssociation> intervals) {
    this.intervals = intervals;
  }
  
  public final static String P_Intervals = "intervals";
  
  public static IObjectFieldAccessor<UIPMDeviceTypeEntry,Collection<UIPMDefaultIntervalAssociation>> IntervalsAccessor = new IObjectFieldAccessor<UIPMDeviceTypeEntry,Collection<UIPMDefaultIntervalAssociation>>(){
    				public java.util.Collection<com.fudanmed.platform.core.web.shared.device.UIPMDefaultIntervalAssociation> getValue(UIPMDeviceTypeEntry object){
    					return object.getIntervals();
    				}
    				public void setValue(UIPMDeviceTypeEntry object,java.util.Collection<com.fudanmed.platform.core.web.shared.device.UIPMDefaultIntervalAssociation> value){
    					object.setIntervals(value);
    				}
    			};
  
  private RCDevicePMTypeProxy pmType;
  
  public RCDevicePMTypeProxy getPmType() {
    return this.pmType;
  }
  
  public void setPmType(final RCDevicePMTypeProxy pmType) {
    this.pmType = pmType;
  }
  
  public final static String P_PmType = "pmType";
  
  public static IObjectFieldAccessor<UIPMDeviceTypeEntry,RCDevicePMTypeProxy> PmTypeAccessor = new IObjectFieldAccessor<UIPMDeviceTypeEntry,RCDevicePMTypeProxy>(){
    				public com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy getValue(UIPMDeviceTypeEntry object){
    					return object.getPmType();
    				}
    				public void setValue(UIPMDeviceTypeEntry object,com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy value){
    					object.setPmType(value);
    				}
    			};
  
  public RCPMDeviceTypeEntryProxy toProxy() {
    return (RCPMDeviceTypeEntryProxy)super.toProxy();
    
  }
}
