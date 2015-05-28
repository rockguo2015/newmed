package com.fudanmed.platform.core.web.shared.measure;

import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceTypeProxy;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;
import java.util.Date;

public class UIMeasureValueCriteria implements IsSerializable, IPagedCriteria {
  private RCMeasureDeviceTypeProxy deviceType;
  
  public RCMeasureDeviceTypeProxy getDeviceType() {
    return this.deviceType;
  }
  
  public void setDeviceType(final RCMeasureDeviceTypeProxy deviceType) {
    this.deviceType = deviceType;
  }
  
  public final static String P_DeviceType = "deviceType";
  
  public static IObjectFieldAccessor<UIMeasureValueCriteria,RCMeasureDeviceTypeProxy> DeviceTypeAccessor = new IObjectFieldAccessor<UIMeasureValueCriteria,RCMeasureDeviceTypeProxy>(){
    				public com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceTypeProxy getValue(UIMeasureValueCriteria object){
    					return object.getDeviceType();
    				}
    				public void setValue(UIMeasureValueCriteria object,com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceTypeProxy value){
    					object.setDeviceType(value);
    				}
    			};
  
  private RCMeasureDeviceProxy device;
  
  public RCMeasureDeviceProxy getDevice() {
    return this.device;
  }
  
  public void setDevice(final RCMeasureDeviceProxy device) {
    this.device = device;
  }
  
  public final static String P_Device = "device";
  
  public static IObjectFieldAccessor<UIMeasureValueCriteria,RCMeasureDeviceProxy> DeviceAccessor = new IObjectFieldAccessor<UIMeasureValueCriteria,RCMeasureDeviceProxy>(){
    				public com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy getValue(UIMeasureValueCriteria object){
    					return object.getDevice();
    				}
    				public void setValue(UIMeasureValueCriteria object,com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy value){
    					object.setDevice(value);
    				}
    			};
  
  private Date measureDateFrom;
  
  public Date getMeasureDateFrom() {
    return this.measureDateFrom;
  }
  
  public void setMeasureDateFrom(final Date measureDateFrom) {
    this.measureDateFrom = measureDateFrom;
  }
  
  public final static String P_MeasureDateFrom = "measureDateFrom";
  
  public static IObjectFieldAccessor<UIMeasureValueCriteria,Date> MeasureDateFromAccessor = new IObjectFieldAccessor<UIMeasureValueCriteria,Date>(){
    				public java.util.Date getValue(UIMeasureValueCriteria object){
    					return object.getMeasureDateFrom();
    				}
    				public void setValue(UIMeasureValueCriteria object,java.util.Date value){
    					object.setMeasureDateFrom(value);
    				}
    			};
  
  private Date measureDateTo;
  
  public Date getMeasureDateTo() {
    return this.measureDateTo;
  }
  
  public void setMeasureDateTo(final Date measureDateTo) {
    this.measureDateTo = measureDateTo;
  }
  
  public final static String P_MeasureDateTo = "measureDateTo";
  
  public static IObjectFieldAccessor<UIMeasureValueCriteria,Date> MeasureDateToAccessor = new IObjectFieldAccessor<UIMeasureValueCriteria,Date>(){
    				public java.util.Date getValue(UIMeasureValueCriteria object){
    					return object.getMeasureDateTo();
    				}
    				public void setValue(UIMeasureValueCriteria object,java.util.Date value){
    					object.setMeasureDateTo(value);
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
