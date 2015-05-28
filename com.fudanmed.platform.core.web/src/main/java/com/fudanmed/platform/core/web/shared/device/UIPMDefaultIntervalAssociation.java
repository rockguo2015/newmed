package com.fudanmed.platform.core.web.shared.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCPMDefaultIntervalAssociationProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIPMDefaultIntervalAssociation extends GWTEntity {
  private RCDevicePMTypeProxy type;
  
  public RCDevicePMTypeProxy getType() {
    return this.type;
  }
  
  public void setType(final RCDevicePMTypeProxy type) {
    this.type = type;
  }
  
  public final static String P_Type = "type";
  
  public static IObjectFieldAccessor<UIPMDefaultIntervalAssociation,RCDevicePMTypeProxy> TypeAccessor = new IObjectFieldAccessor<UIPMDefaultIntervalAssociation,RCDevicePMTypeProxy>(){
    				public com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy getValue(UIPMDefaultIntervalAssociation object){
    					return object.getType();
    				}
    				public void setValue(UIPMDefaultIntervalAssociation object,com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy value){
    					object.setType(value);
    				}
    			};
  
  private Integer intervalInDays;
  
  public Integer getIntervalInDays() {
    return this.intervalInDays;
  }
  
  public void setIntervalInDays(final Integer intervalInDays) {
    this.intervalInDays = intervalInDays;
  }
  
  public final static String P_IntervalInDays = "intervalInDays";
  
  public static IObjectFieldAccessor<UIPMDefaultIntervalAssociation,Integer> IntervalInDaysAccessor = new IObjectFieldAccessor<UIPMDefaultIntervalAssociation,Integer>(){
    				public Integer getValue(UIPMDefaultIntervalAssociation object){
    					return object.getIntervalInDays();
    				}
    				public void setValue(UIPMDefaultIntervalAssociation object,Integer value){
    					object.setIntervalInDays(value);
    				}
    			};
  
  private String description;
  
  public String getDescription() {
    return this.description;
  }
  
  public void setDescription(final String description) {
    this.description = description;
  }
  
  public final static String P_Description = "description";
  
  public static IObjectFieldAccessor<UIPMDefaultIntervalAssociation,String> DescriptionAccessor = new IObjectFieldAccessor<UIPMDefaultIntervalAssociation,String>(){
    				public String getValue(UIPMDefaultIntervalAssociation object){
    					return object.getDescription();
    				}
    				public void setValue(UIPMDefaultIntervalAssociation object,String value){
    					object.setDescription(value);
    				}
    			};
  
  public RCPMDefaultIntervalAssociationProxy toProxy() {
    return (RCPMDefaultIntervalAssociationProxy)super.toProxy();
    
  }
}
