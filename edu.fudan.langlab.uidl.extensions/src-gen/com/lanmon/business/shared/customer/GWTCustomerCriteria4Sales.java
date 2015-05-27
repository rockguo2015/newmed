package com.lanmon.business.shared.customer;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.lanmon.business.shared.customer.GWTCustomerStatus;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;
import java.util.Date;

public class GWTCustomerCriteria4Sales implements IsSerializable, IPagedCriteria {
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  public final static String P_Name = "name";
  
  public static IObjectFieldAccessor<GWTCustomerCriteria4Sales,String> NameAccessor = new IObjectFieldAccessor<GWTCustomerCriteria4Sales,String>(){
    				public String getValue(GWTCustomerCriteria4Sales object){
    					return object.getName();
    				}
    				public void setValue(GWTCustomerCriteria4Sales object,String value){
    					object.setName(value);
    				}
    			};
  
  private String address;
  
  public String getAddress() {
    return this.address;
  }
  
  public void setAddress(final String address) {
    this.address = address;
  }
  
  public final static String P_Address = "address";
  
  public static IObjectFieldAccessor<GWTCustomerCriteria4Sales,String> AddressAccessor = new IObjectFieldAccessor<GWTCustomerCriteria4Sales,String>(){
    				public String getValue(GWTCustomerCriteria4Sales object){
    					return object.getAddress();
    				}
    				public void setValue(GWTCustomerCriteria4Sales object,String value){
    					object.setAddress(value);
    				}
    			};
  
  private GWTNamedEntity domainCode;
  
  public GWTNamedEntity getDomainCode() {
    return this.domainCode;
  }
  
  public void setDomainCode(final GWTNamedEntity domainCode) {
    this.domainCode = domainCode;
  }
  
  public final static String P_DomainCode = "domainCode";
  
  public static IObjectFieldAccessor<GWTCustomerCriteria4Sales,GWTNamedEntity> DomainCodeAccessor = new IObjectFieldAccessor<GWTCustomerCriteria4Sales,GWTNamedEntity>(){
    				public GWTNamedEntity getValue(GWTCustomerCriteria4Sales object){
    					return object.getDomainCode();
    				}
    				public void setValue(GWTCustomerCriteria4Sales object,GWTNamedEntity value){
    					object.setDomainCode(value);
    				}
    			};
  
  private GWTNamedEntity scaleCode;
  
  public GWTNamedEntity getScaleCode() {
    return this.scaleCode;
  }
  
  public void setScaleCode(final GWTNamedEntity scaleCode) {
    this.scaleCode = scaleCode;
  }
  
  public final static String P_ScaleCode = "scaleCode";
  
  public static IObjectFieldAccessor<GWTCustomerCriteria4Sales,GWTNamedEntity> ScaleCodeAccessor = new IObjectFieldAccessor<GWTCustomerCriteria4Sales,GWTNamedEntity>(){
    				public GWTNamedEntity getValue(GWTCustomerCriteria4Sales object){
    					return object.getScaleCode();
    				}
    				public void setValue(GWTCustomerCriteria4Sales object,GWTNamedEntity value){
    					object.setScaleCode(value);
    				}
    			};
  
  private GWTNamedEntity propertyCode;
  
  public GWTNamedEntity getPropertyCode() {
    return this.propertyCode;
  }
  
  public void setPropertyCode(final GWTNamedEntity propertyCode) {
    this.propertyCode = propertyCode;
  }
  
  public final static String P_PropertyCode = "propertyCode";
  
  public static IObjectFieldAccessor<GWTCustomerCriteria4Sales,GWTNamedEntity> PropertyCodeAccessor = new IObjectFieldAccessor<GWTCustomerCriteria4Sales,GWTNamedEntity>(){
    				public GWTNamedEntity getValue(GWTCustomerCriteria4Sales object){
    					return object.getPropertyCode();
    				}
    				public void setValue(GWTCustomerCriteria4Sales object,GWTNamedEntity value){
    					object.setPropertyCode(value);
    				}
    			};
  
  private GWTCustomerStatus status;
  
  public GWTCustomerStatus getStatus() {
    return this.status;
  }
  
  public void setStatus(final GWTCustomerStatus status) {
    this.status = status;
  }
  
  public final static String P_Status = "status";
  
  public static IObjectFieldAccessor<GWTCustomerCriteria4Sales,GWTCustomerStatus> StatusAccessor = new IObjectFieldAccessor<GWTCustomerCriteria4Sales,GWTCustomerStatus>(){
    				public GWTCustomerStatus getValue(GWTCustomerCriteria4Sales object){
    					return object.getStatus();
    				}
    				public void setValue(GWTCustomerCriteria4Sales object,GWTCustomerStatus value){
    					object.setStatus(value);
    				}
    			};
  
  private GWTNamedEntity sales;
  
  public GWTNamedEntity getSales() {
    return this.sales;
  }
  
  public void setSales(final GWTNamedEntity sales) {
    this.sales = sales;
  }
  
  public final static String P_Sales = "sales";
  
  public static IObjectFieldAccessor<GWTCustomerCriteria4Sales,GWTNamedEntity> SalesAccessor = new IObjectFieldAccessor<GWTCustomerCriteria4Sales,GWTNamedEntity>(){
    				public GWTNamedEntity getValue(GWTCustomerCriteria4Sales object){
    					return object.getSales();
    				}
    				public void setValue(GWTCustomerCriteria4Sales object,GWTNamedEntity value){
    					object.setSales(value);
    				}
    			};
  
  private GWTNamedEntity contactType;
  
  public GWTNamedEntity getContactType() {
    return this.contactType;
  }
  
  public void setContactType(final GWTNamedEntity contactType) {
    this.contactType = contactType;
  }
  
  public final static String P_ContactType = "contactType";
  
  public static IObjectFieldAccessor<GWTCustomerCriteria4Sales,GWTNamedEntity> ContactTypeAccessor = new IObjectFieldAccessor<GWTCustomerCriteria4Sales,GWTNamedEntity>(){
    				public GWTNamedEntity getValue(GWTCustomerCriteria4Sales object){
    					return object.getContactType();
    				}
    				public void setValue(GWTCustomerCriteria4Sales object,GWTNamedEntity value){
    					object.setContactType(value);
    				}
    			};
  
  private Date emailUpdateDate;
  
  public Date getEmailUpdateDate() {
    return this.emailUpdateDate;
  }
  
  public void setEmailUpdateDate(final Date emailUpdateDate) {
    this.emailUpdateDate = emailUpdateDate;
  }
  
  public final static String P_EmailUpdateDate = "emailUpdateDate";
  
  public static IObjectFieldAccessor<GWTCustomerCriteria4Sales,Date> EmailUpdateDateAccessor = new IObjectFieldAccessor<GWTCustomerCriteria4Sales,Date>(){
    				public Date getValue(GWTCustomerCriteria4Sales object){
    					return object.getEmailUpdateDate();
    				}
    				public void setValue(GWTCustomerCriteria4Sales object,Date value){
    					object.setEmailUpdateDate(value);
    				}
    			};
  
  private String annotation;
  
  public String getAnnotation() {
    return this.annotation;
  }
  
  public void setAnnotation(final String annotation) {
    this.annotation = annotation;
  }
  
  public final static String P_Annotation = "annotation";
  
  public static IObjectFieldAccessor<GWTCustomerCriteria4Sales,String> AnnotationAccessor = new IObjectFieldAccessor<GWTCustomerCriteria4Sales,String>(){
    				public String getValue(GWTCustomerCriteria4Sales object){
    					return object.getAnnotation();
    				}
    				public void setValue(GWTCustomerCriteria4Sales object,String value){
    					object.setAnnotation(value);
    				}
    			};
  
  private Integer page;
  
  public Integer getPage() {
    return this.page;
  }
  
  public void setPage(final Integer page) {
    this.page = page;
  }
  
  public final static String P_Page = "page";
  
  public static IObjectFieldAccessor<GWTCustomerCriteria4Sales,Integer> PageAccessor = new IObjectFieldAccessor<GWTCustomerCriteria4Sales,Integer>(){
    				public Integer getValue(GWTCustomerCriteria4Sales object){
    					return object.getPage();
    				}
    				public void setValue(GWTCustomerCriteria4Sales object,Integer value){
    					object.setPage(value);
    				}
    			};
  
  private Integer pageSize;
  
  public Integer getPageSize() {
    return this.pageSize;
  }
  
  public void setPageSize(final Integer pageSize) {
    this.pageSize = pageSize;
  }
  
  public final static String P_PageSize = "pageSize";
  
  public static IObjectFieldAccessor<GWTCustomerCriteria4Sales,Integer> PageSizeAccessor = new IObjectFieldAccessor<GWTCustomerCriteria4Sales,Integer>(){
    				public Integer getValue(GWTCustomerCriteria4Sales object){
    					return object.getPageSize();
    				}
    				public void setValue(GWTCustomerCriteria4Sales object,Integer value){
    					object.setPageSize(value);
    				}
    			};
}
