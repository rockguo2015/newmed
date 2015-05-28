package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStockRecordItemProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class UIWorkItemStockRecordStatisticsData extends GWTEntity {
  private RCMaintenanceTeamProxy team;
  
  public RCMaintenanceTeamProxy getTeam() {
    return this.team;
  }
  
  public void setTeam(final RCMaintenanceTeamProxy team) {
    this.team = team;
  }
  
  public final static String P_Team = "team";
  
  public static IObjectFieldAccessor<UIWorkItemStockRecordStatisticsData,RCMaintenanceTeamProxy> TeamAccessor = new IObjectFieldAccessor<UIWorkItemStockRecordStatisticsData,RCMaintenanceTeamProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy getValue(UIWorkItemStockRecordStatisticsData object){
    					return object.getTeam();
    				}
    				public void setValue(UIWorkItemStockRecordStatisticsData object,com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy value){
    					object.setTeam(value);
    				}
    			};
  
  private String materialId;
  
  public String getMaterialId() {
    return this.materialId;
  }
  
  public void setMaterialId(final String materialId) {
    this.materialId = materialId;
  }
  
  public final static String P_MaterialId = "materialId";
  
  public static IObjectFieldAccessor<UIWorkItemStockRecordStatisticsData,String> MaterialIdAccessor = new IObjectFieldAccessor<UIWorkItemStockRecordStatisticsData,String>(){
    				public String getValue(UIWorkItemStockRecordStatisticsData object){
    					return object.getMaterialId();
    				}
    				public void setValue(UIWorkItemStockRecordStatisticsData object,String value){
    					object.setMaterialId(value);
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
  
  public static IObjectFieldAccessor<UIWorkItemStockRecordStatisticsData,String> NameAccessor = new IObjectFieldAccessor<UIWorkItemStockRecordStatisticsData,String>(){
    				public String getValue(UIWorkItemStockRecordStatisticsData object){
    					return object.getName();
    				}
    				public void setValue(UIWorkItemStockRecordStatisticsData object,String value){
    					object.setName(value);
    				}
    			};
  
  private String typeDesc;
  
  public String getTypeDesc() {
    return this.typeDesc;
  }
  
  public void setTypeDesc(final String typeDesc) {
    this.typeDesc = typeDesc;
  }
  
  public final static String P_TypeDesc = "typeDesc";
  
  public static IObjectFieldAccessor<UIWorkItemStockRecordStatisticsData,String> TypeDescAccessor = new IObjectFieldAccessor<UIWorkItemStockRecordStatisticsData,String>(){
    				public String getValue(UIWorkItemStockRecordStatisticsData object){
    					return object.getTypeDesc();
    				}
    				public void setValue(UIWorkItemStockRecordStatisticsData object,String value){
    					object.setTypeDesc(value);
    				}
    			};
  
  private RCProduceSpecificationUnitProxy unit;
  
  public RCProduceSpecificationUnitProxy getUnit() {
    return this.unit;
  }
  
  public void setUnit(final RCProduceSpecificationUnitProxy unit) {
    this.unit = unit;
  }
  
  public final static String P_Unit = "unit";
  
  public static IObjectFieldAccessor<UIWorkItemStockRecordStatisticsData,RCProduceSpecificationUnitProxy> UnitAccessor = new IObjectFieldAccessor<UIWorkItemStockRecordStatisticsData,RCProduceSpecificationUnitProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy getValue(UIWorkItemStockRecordStatisticsData object){
    					return object.getUnit();
    				}
    				public void setValue(UIWorkItemStockRecordStatisticsData object,com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy value){
    					object.setUnit(value);
    				}
    			};
  
  private Double price;
  
  public Double getPrice() {
    return this.price;
  }
  
  public void setPrice(final Double price) {
    this.price = price;
  }
  
  public final static String P_Price = "price";
  
  public static IObjectFieldAccessor<UIWorkItemStockRecordStatisticsData,Double> PriceAccessor = new IObjectFieldAccessor<UIWorkItemStockRecordStatisticsData,Double>(){
    				public Double getValue(UIWorkItemStockRecordStatisticsData object){
    					return object.getPrice();
    				}
    				public void setValue(UIWorkItemStockRecordStatisticsData object,Double value){
    					object.setPrice(value);
    				}
    			};
  
  private Integer quantity;
  
  public Integer getQuantity() {
    return this.quantity;
  }
  
  public void setQuantity(final Integer quantity) {
    this.quantity = quantity;
  }
  
  public final static String P_Quantity = "quantity";
  
  public static IObjectFieldAccessor<UIWorkItemStockRecordStatisticsData,Integer> QuantityAccessor = new IObjectFieldAccessor<UIWorkItemStockRecordStatisticsData,Integer>(){
    				public Integer getValue(UIWorkItemStockRecordStatisticsData object){
    					return object.getQuantity();
    				}
    				public void setValue(UIWorkItemStockRecordStatisticsData object,Integer value){
    					object.setQuantity(value);
    				}
    			};
  
  private Double amount;
  
  public Double getAmount() {
    return this.amount;
  }
  
  public void setAmount(final Double amount) {
    this.amount = amount;
  }
  
  public final static String P_Amount = "amount";
  
  public static IObjectFieldAccessor<UIWorkItemStockRecordStatisticsData,Double> AmountAccessor = new IObjectFieldAccessor<UIWorkItemStockRecordStatisticsData,Double>(){
    				public Double getValue(UIWorkItemStockRecordStatisticsData object){
    					return object.getAmount();
    				}
    				public void setValue(UIWorkItemStockRecordStatisticsData object,Double value){
    					object.setAmount(value);
    				}
    			};
  
  private RCOrganizationProxy reportOrg;
  
  public RCOrganizationProxy getReportOrg() {
    return this.reportOrg;
  }
  
  public void setReportOrg(final RCOrganizationProxy reportOrg) {
    this.reportOrg = reportOrg;
  }
  
  public final static String P_ReportOrg = "reportOrg";
  
  public static IObjectFieldAccessor<UIWorkItemStockRecordStatisticsData,RCOrganizationProxy> ReportOrgAccessor = new IObjectFieldAccessor<UIWorkItemStockRecordStatisticsData,RCOrganizationProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy getValue(UIWorkItemStockRecordStatisticsData object){
    					return object.getReportOrg();
    				}
    				public void setValue(UIWorkItemStockRecordStatisticsData object,com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy value){
    					object.setReportOrg(value);
    				}
    			};
  
  private Date date;
  
  public Date getDate() {
    return this.date;
  }
  
  public void setDate(final Date date) {
    this.date = date;
  }
  
  public final static String P_Date = "date";
  
  public static IObjectFieldAccessor<UIWorkItemStockRecordStatisticsData,Date> DateAccessor = new IObjectFieldAccessor<UIWorkItemStockRecordStatisticsData,Date>(){
    				public java.util.Date getValue(UIWorkItemStockRecordStatisticsData object){
    					return object.getDate();
    				}
    				public void setValue(UIWorkItemStockRecordStatisticsData object,java.util.Date value){
    					object.setDate(value);
    				}
    			};
  
  private String reportSid;
  
  public String getReportSid() {
    return this.reportSid;
  }
  
  public void setReportSid(final String reportSid) {
    this.reportSid = reportSid;
  }
  
  public final static String P_ReportSid = "reportSid";
  
  public static IObjectFieldAccessor<UIWorkItemStockRecordStatisticsData,String> ReportSidAccessor = new IObjectFieldAccessor<UIWorkItemStockRecordStatisticsData,String>(){
    				public String getValue(UIWorkItemStockRecordStatisticsData object){
    					return object.getReportSid();
    				}
    				public void setValue(UIWorkItemStockRecordStatisticsData object,String value){
    					object.setReportSid(value);
    				}
    			};
  
  private String workItemSid;
  
  public String getWorkItemSid() {
    return this.workItemSid;
  }
  
  public void setWorkItemSid(final String workItemSid) {
    this.workItemSid = workItemSid;
  }
  
  public final static String P_WorkItemSid = "workItemSid";
  
  public static IObjectFieldAccessor<UIWorkItemStockRecordStatisticsData,String> WorkItemSidAccessor = new IObjectFieldAccessor<UIWorkItemStockRecordStatisticsData,String>(){
    				public String getValue(UIWorkItemStockRecordStatisticsData object){
    					return object.getWorkItemSid();
    				}
    				public void setValue(UIWorkItemStockRecordStatisticsData object,String value){
    					object.setWorkItemSid(value);
    				}
    			};
  
  private String inoutStockSid;
  
  public String getInoutStockSid() {
    return this.inoutStockSid;
  }
  
  public void setInoutStockSid(final String inoutStockSid) {
    this.inoutStockSid = inoutStockSid;
  }
  
  public final static String P_InoutStockSid = "inoutStockSid";
  
  public static IObjectFieldAccessor<UIWorkItemStockRecordStatisticsData,String> InoutStockSidAccessor = new IObjectFieldAccessor<UIWorkItemStockRecordStatisticsData,String>(){
    				public String getValue(UIWorkItemStockRecordStatisticsData object){
    					return object.getInoutStockSid();
    				}
    				public void setValue(UIWorkItemStockRecordStatisticsData object,String value){
    					object.setInoutStockSid(value);
    				}
    			};
  
  public RCWorkItemStockRecordItemProxy toProxy() {
    return (RCWorkItemStockRecordItemProxy)super.toProxy();
    
  }
}
