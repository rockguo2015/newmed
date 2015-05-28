package com.fudanmed.platform.core.web.shared.device;

import com.fudanmed.platform.core.device.proxy.RCAcquireTypeProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceIndicatorProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceUsageTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class UIDevice extends GWTEntity {
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public void setSid(final String sid) {
    this.sid = sid;
  }
  
  public final static String P_Sid = "sid";
  
  public static IObjectFieldAccessor<UIDevice,String> SidAccessor = new IObjectFieldAccessor<UIDevice,String>(){
    				public String getValue(UIDevice object){
    					return object.getSid();
    				}
    				public void setValue(UIDevice object,String value){
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
  
  public static IObjectFieldAccessor<UIDevice,String> NameAccessor = new IObjectFieldAccessor<UIDevice,String>(){
    				public String getValue(UIDevice object){
    					return object.getName();
    				}
    				public void setValue(UIDevice object,String value){
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
  
  public static IObjectFieldAccessor<UIDevice,String> SpecificationAccessor = new IObjectFieldAccessor<UIDevice,String>(){
    				public String getValue(UIDevice object){
    					return object.getSpecification();
    				}
    				public void setValue(UIDevice object,String value){
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
  
  public static IObjectFieldAccessor<UIDevice,RCOnsitePositionProxy> LocationAccessor = new IObjectFieldAccessor<UIDevice,RCOnsitePositionProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy getValue(UIDevice object){
    					return object.getLocation();
    				}
    				public void setValue(UIDevice object,com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy value){
    					object.setLocation(value);
    				}
    			};
  
  private String locationName;
  
  public String getLocationName() {
    return this.locationName;
  }
  
  public void setLocationName(final String locationName) {
    this.locationName = locationName;
  }
  
  public final static String P_LocationName = "locationName";
  
  public static IObjectFieldAccessor<UIDevice,String> LocationNameAccessor = new IObjectFieldAccessor<UIDevice,String>(){
    				public String getValue(UIDevice object){
    					return object.getLocationName();
    				}
    				public void setValue(UIDevice object,String value){
    					object.setLocationName(value);
    				}
    			};
  
  private String serviceLocationName;
  
  public String getServiceLocationName() {
    return this.serviceLocationName;
  }
  
  public void setServiceLocationName(final String serviceLocationName) {
    this.serviceLocationName = serviceLocationName;
  }
  
  public final static String P_ServiceLocationName = "serviceLocationName";
  
  public static IObjectFieldAccessor<UIDevice,String> ServiceLocationNameAccessor = new IObjectFieldAccessor<UIDevice,String>(){
    				public String getValue(UIDevice object){
    					return object.getServiceLocationName();
    				}
    				public void setValue(UIDevice object,String value){
    					object.setServiceLocationName(value);
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
  
  public static IObjectFieldAccessor<UIDevice,RCSupplierProxy> ProductorAccessor = new IObjectFieldAccessor<UIDevice,RCSupplierProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCSupplierProxy getValue(UIDevice object){
    					return object.getProductor();
    				}
    				public void setValue(UIDevice object,com.fudanmed.platform.core.domain.proxy.RCSupplierProxy value){
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
  
  public static IObjectFieldAccessor<UIDevice,RCSupplierProxy> SupplierAccessor = new IObjectFieldAccessor<UIDevice,RCSupplierProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCSupplierProxy getValue(UIDevice object){
    					return object.getSupplier();
    				}
    				public void setValue(UIDevice object,com.fudanmed.platform.core.domain.proxy.RCSupplierProxy value){
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
  
  public static IObjectFieldAccessor<UIDevice,RCDeviceTypeProxy> DeviceTypeAccessor = new IObjectFieldAccessor<UIDevice,RCDeviceTypeProxy>(){
    				public com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy getValue(UIDevice object){
    					return object.getDeviceType();
    				}
    				public void setValue(UIDevice object,com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy value){
    					object.setDeviceType(value);
    				}
    			};
  
  private RCDeviceIndicatorProxy deviceIndicator;
  
  public RCDeviceIndicatorProxy getDeviceIndicator() {
    return this.deviceIndicator;
  }
  
  public void setDeviceIndicator(final RCDeviceIndicatorProxy deviceIndicator) {
    this.deviceIndicator = deviceIndicator;
  }
  
  public final static String P_DeviceIndicator = "deviceIndicator";
  
  public static IObjectFieldAccessor<UIDevice,RCDeviceIndicatorProxy> DeviceIndicatorAccessor = new IObjectFieldAccessor<UIDevice,RCDeviceIndicatorProxy>(){
    				public com.fudanmed.platform.core.device.proxy.RCDeviceIndicatorProxy getValue(UIDevice object){
    					return object.getDeviceIndicator();
    				}
    				public void setValue(UIDevice object,com.fudanmed.platform.core.device.proxy.RCDeviceIndicatorProxy value){
    					object.setDeviceIndicator(value);
    				}
    			};
  
  private RCDeviceUsageTypeProxy usageType;
  
  public RCDeviceUsageTypeProxy getUsageType() {
    return this.usageType;
  }
  
  public void setUsageType(final RCDeviceUsageTypeProxy usageType) {
    this.usageType = usageType;
  }
  
  public final static String P_UsageType = "usageType";
  
  public static IObjectFieldAccessor<UIDevice,RCDeviceUsageTypeProxy> UsageTypeAccessor = new IObjectFieldAccessor<UIDevice,RCDeviceUsageTypeProxy>(){
    				public com.fudanmed.platform.core.device.proxy.RCDeviceUsageTypeProxy getValue(UIDevice object){
    					return object.getUsageType();
    				}
    				public void setValue(UIDevice object,com.fudanmed.platform.core.device.proxy.RCDeviceUsageTypeProxy value){
    					object.setUsageType(value);
    				}
    			};
  
  private RCAcquireTypeProxy acquireType;
  
  public RCAcquireTypeProxy getAcquireType() {
    return this.acquireType;
  }
  
  public void setAcquireType(final RCAcquireTypeProxy acquireType) {
    this.acquireType = acquireType;
  }
  
  public final static String P_AcquireType = "acquireType";
  
  public static IObjectFieldAccessor<UIDevice,RCAcquireTypeProxy> AcquireTypeAccessor = new IObjectFieldAccessor<UIDevice,RCAcquireTypeProxy>(){
    				public com.fudanmed.platform.core.device.proxy.RCAcquireTypeProxy getValue(UIDevice object){
    					return object.getAcquireType();
    				}
    				public void setValue(UIDevice object,com.fudanmed.platform.core.device.proxy.RCAcquireTypeProxy value){
    					object.setAcquireType(value);
    				}
    			};
  
  private Date buyTime;
  
  public Date getBuyTime() {
    return this.buyTime;
  }
  
  public void setBuyTime(final Date buyTime) {
    this.buyTime = buyTime;
  }
  
  public final static String P_BuyTime = "buyTime";
  
  public static IObjectFieldAccessor<UIDevice,Date> BuyTimeAccessor = new IObjectFieldAccessor<UIDevice,Date>(){
    				public java.util.Date getValue(UIDevice object){
    					return object.getBuyTime();
    				}
    				public void setValue(UIDevice object,java.util.Date value){
    					object.setBuyTime(value);
    				}
    			};
  
  private Double buyPrice;
  
  public Double getBuyPrice() {
    return this.buyPrice;
  }
  
  public void setBuyPrice(final Double buyPrice) {
    this.buyPrice = buyPrice;
  }
  
  public final static String P_BuyPrice = "buyPrice";
  
  public static IObjectFieldAccessor<UIDevice,Double> BuyPriceAccessor = new IObjectFieldAccessor<UIDevice,Double>(){
    				public Double getValue(UIDevice object){
    					return object.getBuyPrice();
    				}
    				public void setValue(UIDevice object,Double value){
    					object.setBuyPrice(value);
    				}
    			};
  
  private Date outStockTime;
  
  public Date getOutStockTime() {
    return this.outStockTime;
  }
  
  public void setOutStockTime(final Date outStockTime) {
    this.outStockTime = outStockTime;
  }
  
  public final static String P_OutStockTime = "outStockTime";
  
  public static IObjectFieldAccessor<UIDevice,Date> OutStockTimeAccessor = new IObjectFieldAccessor<UIDevice,Date>(){
    				public java.util.Date getValue(UIDevice object){
    					return object.getOutStockTime();
    				}
    				public void setValue(UIDevice object,java.util.Date value){
    					object.setOutStockTime(value);
    				}
    			};
  
  private Double netPrice;
  
  public Double getNetPrice() {
    return this.netPrice;
  }
  
  public void setNetPrice(final Double netPrice) {
    this.netPrice = netPrice;
  }
  
  public final static String P_NetPrice = "netPrice";
  
  public static IObjectFieldAccessor<UIDevice,Double> NetPriceAccessor = new IObjectFieldAccessor<UIDevice,Double>(){
    				public Double getValue(UIDevice object){
    					return object.getNetPrice();
    				}
    				public void setValue(UIDevice object,Double value){
    					object.setNetPrice(value);
    				}
    			};
  
  private RCEmployeeProxy owner;
  
  public RCEmployeeProxy getOwner() {
    return this.owner;
  }
  
  public void setOwner(final RCEmployeeProxy owner) {
    this.owner = owner;
  }
  
  public final static String P_Owner = "owner";
  
  public static IObjectFieldAccessor<UIDevice,RCEmployeeProxy> OwnerAccessor = new IObjectFieldAccessor<UIDevice,RCEmployeeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy getValue(UIDevice object){
    					return object.getOwner();
    				}
    				public void setValue(UIDevice object,com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy value){
    					object.setOwner(value);
    				}
    			};
  
  private Integer depreciationYears;
  
  public Integer getDepreciationYears() {
    return this.depreciationYears;
  }
  
  public void setDepreciationYears(final Integer depreciationYears) {
    this.depreciationYears = depreciationYears;
  }
  
  public final static String P_DepreciationYears = "depreciationYears";
  
  public static IObjectFieldAccessor<UIDevice,Integer> DepreciationYearsAccessor = new IObjectFieldAccessor<UIDevice,Integer>(){
    				public Integer getValue(UIDevice object){
    					return object.getDepreciationYears();
    				}
    				public void setValue(UIDevice object,Integer value){
    					object.setDepreciationYears(value);
    				}
    			};
  
  private Double netLeaveRate;
  
  public Double getNetLeaveRate() {
    return this.netLeaveRate;
  }
  
  public void setNetLeaveRate(final Double netLeaveRate) {
    this.netLeaveRate = netLeaveRate;
  }
  
  public final static String P_NetLeaveRate = "netLeaveRate";
  
  public static IObjectFieldAccessor<UIDevice,Double> NetLeaveRateAccessor = new IObjectFieldAccessor<UIDevice,Double>(){
    				public Double getValue(UIDevice object){
    					return object.getNetLeaveRate();
    				}
    				public void setValue(UIDevice object,Double value){
    					object.setNetLeaveRate(value);
    				}
    			};
  
  private RCEmployeeProxy operator;
  
  public RCEmployeeProxy getOperator() {
    return this.operator;
  }
  
  public void setOperator(final RCEmployeeProxy operator) {
    this.operator = operator;
  }
  
  public final static String P_Operator = "operator";
  
  public static IObjectFieldAccessor<UIDevice,RCEmployeeProxy> OperatorAccessor = new IObjectFieldAccessor<UIDevice,RCEmployeeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy getValue(UIDevice object){
    					return object.getOperator();
    				}
    				public void setValue(UIDevice object,com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy value){
    					object.setOperator(value);
    				}
    			};
  
  private String ownerDepartmentName;
  
  public String getOwnerDepartmentName() {
    return this.ownerDepartmentName;
  }
  
  public void setOwnerDepartmentName(final String ownerDepartmentName) {
    this.ownerDepartmentName = ownerDepartmentName;
  }
  
  public final static String P_OwnerDepartmentName = "ownerDepartmentName";
  
  public static IObjectFieldAccessor<UIDevice,String> OwnerDepartmentNameAccessor = new IObjectFieldAccessor<UIDevice,String>(){
    				public String getValue(UIDevice object){
    					return object.getOwnerDepartmentName();
    				}
    				public void setValue(UIDevice object,String value){
    					object.setOwnerDepartmentName(value);
    				}
    			};
  
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public void setComment(final String comment) {
    this.comment = comment;
  }
  
  public final static String P_Comment = "comment";
  
  public static IObjectFieldAccessor<UIDevice,String> CommentAccessor = new IObjectFieldAccessor<UIDevice,String>(){
    				public String getValue(UIDevice object){
    					return object.getComment();
    				}
    				public void setValue(UIDevice object,String value){
    					object.setComment(value);
    				}
    			};
  
  public RCDeviceProxy toProxy() {
    return (RCDeviceProxy)super.toProxy();
    
  }
}
