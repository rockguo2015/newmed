package com.fudanmed.platform.core.web.shared.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMSpecificationProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class UIDevicePMSpecification extends GWTEntity {
  private RCDeviceProxy device;
  
  public RCDeviceProxy getDevice() {
    return this.device;
  }
  
  public void setDevice(final RCDeviceProxy device) {
    this.device = device;
  }
  
  public final static String P_Device = "device";
  
  public static IObjectFieldAccessor<UIDevicePMSpecification,RCDeviceProxy> DeviceAccessor = new IObjectFieldAccessor<UIDevicePMSpecification,RCDeviceProxy>(){
    				public com.fudanmed.platform.core.device.proxy.RCDeviceProxy getValue(UIDevicePMSpecification object){
    					return object.getDevice();
    				}
    				public void setValue(UIDevicePMSpecification object,com.fudanmed.platform.core.device.proxy.RCDeviceProxy value){
    					object.setDevice(value);
    				}
    			};
  
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public void setSid(final String sid) {
    this.sid = sid;
  }
  
  public final static String P_Sid = "sid";
  
  public static IObjectFieldAccessor<UIDevicePMSpecification,String> SidAccessor = new IObjectFieldAccessor<UIDevicePMSpecification,String>(){
    				public String getValue(UIDevicePMSpecification object){
    					return object.getSid();
    				}
    				public void setValue(UIDevicePMSpecification object,String value){
    					object.setSid(value);
    				}
    			};
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  public final static String P_Name = "name";
  
  public static IObjectFieldAccessor<UIDevicePMSpecification,String> NameAccessor = new IObjectFieldAccessor<UIDevicePMSpecification,String>(){
    				public String getValue(UIDevicePMSpecification object){
    					return object.getName();
    				}
    				public void setValue(UIDevicePMSpecification object,String value){
    					object.setName(value);
    				}
    			};
  
  private String specification;
  
  public String getSpecification() {
    return this.specification;
  }
  
  public void setSpecification(final String specification) {
    this.specification = specification;
  }
  
  public final static String P_Specification = "specification";
  
  public static IObjectFieldAccessor<UIDevicePMSpecification,String> SpecificationAccessor = new IObjectFieldAccessor<UIDevicePMSpecification,String>(){
    				public String getValue(UIDevicePMSpecification object){
    					return object.getSpecification();
    				}
    				public void setValue(UIDevicePMSpecification object,String value){
    					object.setSpecification(value);
    				}
    			};
  
  private RCOnsitePositionProxy location;
  
  public RCOnsitePositionProxy getLocation() {
    return this.location;
  }
  
  public void setLocation(final RCOnsitePositionProxy location) {
    this.location = location;
  }
  
  public final static String P_Location = "location";
  
  public static IObjectFieldAccessor<UIDevicePMSpecification,RCOnsitePositionProxy> LocationAccessor = new IObjectFieldAccessor<UIDevicePMSpecification,RCOnsitePositionProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy getValue(UIDevicePMSpecification object){
    					return object.getLocation();
    				}
    				public void setValue(UIDevicePMSpecification object,com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy value){
    					object.setLocation(value);
    				}
    			};
  
  private RCSupplierProxy productor;
  
  public RCSupplierProxy getProductor() {
    return this.productor;
  }
  
  public void setProductor(final RCSupplierProxy productor) {
    this.productor = productor;
  }
  
  public final static String P_Productor = "productor";
  
  public static IObjectFieldAccessor<UIDevicePMSpecification,RCSupplierProxy> ProductorAccessor = new IObjectFieldAccessor<UIDevicePMSpecification,RCSupplierProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCSupplierProxy getValue(UIDevicePMSpecification object){
    					return object.getProductor();
    				}
    				public void setValue(UIDevicePMSpecification object,com.fudanmed.platform.core.domain.proxy.RCSupplierProxy value){
    					object.setProductor(value);
    				}
    			};
  
  private RCSupplierProxy supplier;
  
  public RCSupplierProxy getSupplier() {
    return this.supplier;
  }
  
  public void setSupplier(final RCSupplierProxy supplier) {
    this.supplier = supplier;
  }
  
  public final static String P_Supplier = "supplier";
  
  public static IObjectFieldAccessor<UIDevicePMSpecification,RCSupplierProxy> SupplierAccessor = new IObjectFieldAccessor<UIDevicePMSpecification,RCSupplierProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCSupplierProxy getValue(UIDevicePMSpecification object){
    					return object.getSupplier();
    				}
    				public void setValue(UIDevicePMSpecification object,com.fudanmed.platform.core.domain.proxy.RCSupplierProxy value){
    					object.setSupplier(value);
    				}
    			};
  
  private RCDeviceTypeProxy deviceType;
  
  public RCDeviceTypeProxy getDeviceType() {
    return this.deviceType;
  }
  
  public void setDeviceType(final RCDeviceTypeProxy deviceType) {
    this.deviceType = deviceType;
  }
  
  public final static String P_DeviceType = "deviceType";
  
  public static IObjectFieldAccessor<UIDevicePMSpecification,RCDeviceTypeProxy> DeviceTypeAccessor = new IObjectFieldAccessor<UIDevicePMSpecification,RCDeviceTypeProxy>(){
    				public com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy getValue(UIDevicePMSpecification object){
    					return object.getDeviceType();
    				}
    				public void setValue(UIDevicePMSpecification object,com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy value){
    					object.setDeviceType(value);
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
  
  public static IObjectFieldAccessor<UIDevicePMSpecification,RCDevicePMTypeProxy> PmTypeAccessor = new IObjectFieldAccessor<UIDevicePMSpecification,RCDevicePMTypeProxy>(){
    				public com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy getValue(UIDevicePMSpecification object){
    					return object.getPmType();
    				}
    				public void setValue(UIDevicePMSpecification object,com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy value){
    					object.setPmType(value);
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
  
  public static IObjectFieldAccessor<UIDevicePMSpecification,Integer> IntervalInDaysAccessor = new IObjectFieldAccessor<UIDevicePMSpecification,Integer>(){
    				public Integer getValue(UIDevicePMSpecification object){
    					return object.getIntervalInDays();
    				}
    				public void setValue(UIDevicePMSpecification object,Integer value){
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
  
  public static IObjectFieldAccessor<UIDevicePMSpecification,String> DescriptionAccessor = new IObjectFieldAccessor<UIDevicePMSpecification,String>(){
    				public String getValue(UIDevicePMSpecification object){
    					return object.getDescription();
    				}
    				public void setValue(UIDevicePMSpecification object,String value){
    					object.setDescription(value);
    				}
    			};
  
  private Date lastPMPlanDate;
  
  public Date getLastPMPlanDate() {
    return this.lastPMPlanDate;
  }
  
  public void setLastPMPlanDate(final Date lastPMPlanDate) {
    this.lastPMPlanDate = lastPMPlanDate;
  }
  
  public final static String P_LastPMPlanDate = "lastPMPlanDate";
  
  public static IObjectFieldAccessor<UIDevicePMSpecification,Date> LastPMPlanDateAccessor = new IObjectFieldAccessor<UIDevicePMSpecification,Date>(){
    				public java.util.Date getValue(UIDevicePMSpecification object){
    					return object.getLastPMPlanDate();
    				}
    				public void setValue(UIDevicePMSpecification object,java.util.Date value){
    					object.setLastPMPlanDate(value);
    				}
    			};
  
  public RCDevicePMSpecificationProxy toProxy() {
    return (RCDevicePMSpecificationProxy)super.toProxy();
    
  }
}
