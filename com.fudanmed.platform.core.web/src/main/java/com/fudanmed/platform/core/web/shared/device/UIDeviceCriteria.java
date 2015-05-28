package com.fudanmed.platform.core.web.shared.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;

public class UIDeviceCriteria implements IsSerializable, IPagedCriteria {
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public void setSid(final String sid) {
    this.sid = sid;
  }
  
  public final static String P_Sid = "sid";
  
  public static IObjectFieldAccessor<UIDeviceCriteria,String> SidAccessor = new IObjectFieldAccessor<UIDeviceCriteria,String>(){
    				public String getValue(UIDeviceCriteria object){
    					return object.getSid();
    				}
    				public void setValue(UIDeviceCriteria object,String value){
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
  
  public static IObjectFieldAccessor<UIDeviceCriteria,String> NameAccessor = new IObjectFieldAccessor<UIDeviceCriteria,String>(){
    				public String getValue(UIDeviceCriteria object){
    					return object.getName();
    				}
    				public void setValue(UIDeviceCriteria object,String value){
    					object.setName(value);
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
  
  public static IObjectFieldAccessor<UIDeviceCriteria,RCDeviceTypeProxy> DeviceTypeAccessor = new IObjectFieldAccessor<UIDeviceCriteria,RCDeviceTypeProxy>(){
    				public com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy getValue(UIDeviceCriteria object){
    					return object.getDeviceType();
    				}
    				public void setValue(UIDeviceCriteria object,com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy value){
    					object.setDeviceType(value);
    				}
    			};
  
  private String category;
  
  public String getCategory() {
    return this.category;
  }
  
  public void setCategory(final String category) {
    this.category = category;
  }
  
  public final static String P_Category = "category";
  
  public static IObjectFieldAccessor<UIDeviceCriteria,String> CategoryAccessor = new IObjectFieldAccessor<UIDeviceCriteria,String>(){
    				public String getValue(UIDeviceCriteria object){
    					return object.getCategory();
    				}
    				public void setValue(UIDeviceCriteria object,String value){
    					object.setCategory(value);
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
  
  public static IObjectFieldAccessor<UIDeviceCriteria,RCOnsitePositionProxy> LocationAccessor = new IObjectFieldAccessor<UIDeviceCriteria,RCOnsitePositionProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy getValue(UIDeviceCriteria object){
    					return object.getLocation();
    				}
    				public void setValue(UIDeviceCriteria object,com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy value){
    					object.setLocation(value);
    				}
    			};
  
  private Integer page;
  
  public Integer getPage() {
    return this.page;
  }
  
  public void setPage(final Integer page) {
    this.page = page;
  }
  
  private Integer pageSize;
  
  public Integer getPageSize() {
    return this.pageSize;
  }
  
  public void setPageSize(final Integer pageSize) {
    this.pageSize = pageSize;
  }
}
