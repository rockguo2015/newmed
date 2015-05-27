package com.lanmon.business.shared.customer;

import com.lanmon.business.shared.customer.GWTCustomerStatus;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.datatype.DateRange;
import java.util.Date;

public class GWTCustomer extends GWTEntity {
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  public final static String P_Name = "name";
  
  public static IObjectFieldAccessor<GWTCustomer,String> NameAccessor = new IObjectFieldAccessor<GWTCustomer,String>(){
    				public String getValue(GWTCustomer object){
    					return object.getName();
    				}
    				public void setValue(GWTCustomer object,String value){
    					object.setName(value);
    				}
    			};
  
  private String phone;
  
  public String getPhone() {
    return this.phone;
  }
  
  public void setPhone(final String phone) {
    this.phone = phone;
  }
  
  public final static String P_Phone = "phone";
  
  public static IObjectFieldAccessor<GWTCustomer,String> PhoneAccessor = new IObjectFieldAccessor<GWTCustomer,String>(){
    				public String getValue(GWTCustomer object){
    					return object.getPhone();
    				}
    				public void setValue(GWTCustomer object,String value){
    					object.setPhone(value);
    				}
    			};
  
  private String fax;
  
  public String getFax() {
    return this.fax;
  }
  
  public void setFax(final String fax) {
    this.fax = fax;
  }
  
  public final static String P_Fax = "fax";
  
  public static IObjectFieldAccessor<GWTCustomer,String> FaxAccessor = new IObjectFieldAccessor<GWTCustomer,String>(){
    				public String getValue(GWTCustomer object){
    					return object.getFax();
    				}
    				public void setValue(GWTCustomer object,String value){
    					object.setFax(value);
    				}
    			};
  
  private String postcode;
  
  public String getPostcode() {
    return this.postcode;
  }
  
  public void setPostcode(final String postcode) {
    this.postcode = postcode;
  }
  
  public final static String P_Postcode = "postcode";
  
  public static IObjectFieldAccessor<GWTCustomer,String> PostcodeAccessor = new IObjectFieldAccessor<GWTCustomer,String>(){
    				public String getValue(GWTCustomer object){
    					return object.getPostcode();
    				}
    				public void setValue(GWTCustomer object,String value){
    					object.setPostcode(value);
    				}
    			};
  
  private String addressInfo;
  
  public String getAddressInfo() {
    return this.addressInfo;
  }
  
  public void setAddressInfo(final String addressInfo) {
    this.addressInfo = addressInfo;
  }
  
  public final static String P_AddressInfo = "addressInfo";
  
  public static IObjectFieldAccessor<GWTCustomer,String> AddressInfoAccessor = new IObjectFieldAccessor<GWTCustomer,String>(){
    				public String getValue(GWTCustomer object){
    					return object.getAddressInfo();
    				}
    				public void setValue(GWTCustomer object,String value){
    					object.setAddressInfo(value);
    				}
    			};
  
  private String contractor;
  
  public String getContractor() {
    return this.contractor;
  }
  
  public void setContractor(final String contractor) {
    this.contractor = contractor;
  }
  
  public final static String P_Contractor = "contractor";
  
  public static IObjectFieldAccessor<GWTCustomer,String> ContractorAccessor = new IObjectFieldAccessor<GWTCustomer,String>(){
    				public String getValue(GWTCustomer object){
    					return object.getContractor();
    				}
    				public void setValue(GWTCustomer object,String value){
    					object.setContractor(value);
    				}
    			};
  
  private String email;
  
  public String getEmail() {
    return this.email;
  }
  
  public void setEmail(final String email) {
    this.email = email;
  }
  
  public final static String P_Email = "email";
  
  public static IObjectFieldAccessor<GWTCustomer,String> EmailAccessor = new IObjectFieldAccessor<GWTCustomer,String>(){
    				public String getValue(GWTCustomer object){
    					return object.getEmail();
    				}
    				public void setValue(GWTCustomer object,String value){
    					object.setEmail(value);
    				}
    			};
  
  private String homePage;
  
  public String getHomePage() {
    return this.homePage;
  }
  
  public void setHomePage(final String homePage) {
    this.homePage = homePage;
  }
  
  public final static String P_HomePage = "homePage";
  
  public static IObjectFieldAccessor<GWTCustomer,String> HomePageAccessor = new IObjectFieldAccessor<GWTCustomer,String>(){
    				public String getValue(GWTCustomer object){
    					return object.getHomePage();
    				}
    				public void setValue(GWTCustomer object,String value){
    					object.setHomePage(value);
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
  
  public static IObjectFieldAccessor<GWTCustomer,GWTCustomerStatus> StatusAccessor = new IObjectFieldAccessor<GWTCustomer,GWTCustomerStatus>(){
    				public GWTCustomerStatus getValue(GWTCustomer object){
    					return object.getStatus();
    				}
    				public void setValue(GWTCustomer object,GWTCustomerStatus value){
    					object.setStatus(value);
    				}
    			};
  
  private GWTNamedEntity phoneSaleOwner;
  
  public GWTNamedEntity getPhoneSaleOwner() {
    return this.phoneSaleOwner;
  }
  
  public void setPhoneSaleOwner(final GWTNamedEntity phoneSaleOwner) {
    this.phoneSaleOwner = phoneSaleOwner;
  }
  
  public final static String P_PhoneSaleOwner = "phoneSaleOwner";
  
  public static IObjectFieldAccessor<GWTCustomer,GWTNamedEntity> PhoneSaleOwnerAccessor = new IObjectFieldAccessor<GWTCustomer,GWTNamedEntity>(){
    				public GWTNamedEntity getValue(GWTCustomer object){
    					return object.getPhoneSaleOwner();
    				}
    				public void setValue(GWTCustomer object,GWTNamedEntity value){
    					object.setPhoneSaleOwner(value);
    				}
    			};
  
  private GWTNamedEntity onsiteSaleOwner;
  
  public GWTNamedEntity getOnsiteSaleOwner() {
    return this.onsiteSaleOwner;
  }
  
  public void setOnsiteSaleOwner(final GWTNamedEntity onsiteSaleOwner) {
    this.onsiteSaleOwner = onsiteSaleOwner;
  }
  
  public final static String P_OnsiteSaleOwner = "onsiteSaleOwner";
  
  public static IObjectFieldAccessor<GWTCustomer,GWTNamedEntity> OnsiteSaleOwnerAccessor = new IObjectFieldAccessor<GWTCustomer,GWTNamedEntity>(){
    				public GWTNamedEntity getValue(GWTCustomer object){
    					return object.getOnsiteSaleOwner();
    				}
    				public void setValue(GWTCustomer object,GWTNamedEntity value){
    					object.setOnsiteSaleOwner(value);
    				}
    			};
  
  private DateRange contractDate;
  
  public DateRange getContractDate() {
    return this.contractDate;
  }
  
  public void setContractDate(final DateRange contractDate) {
    this.contractDate = contractDate;
  }
  
  public final static String P_ContractDate = "contractDate";
  
  public static IObjectFieldAccessor<GWTCustomer,DateRange> ContractDateAccessor = new IObjectFieldAccessor<GWTCustomer,DateRange>(){
    				public DateRange getValue(GWTCustomer object){
    					return object.getContractDate();
    				}
    				public void setValue(GWTCustomer object,DateRange value){
    					object.setContractDate(value);
    				}
    			};
  
  private DateRange outsourceDate;
  
  public DateRange getOutsourceDate() {
    return this.outsourceDate;
  }
  
  public void setOutsourceDate(final DateRange outsourceDate) {
    this.outsourceDate = outsourceDate;
  }
  
  public final static String P_OutsourceDate = "outsourceDate";
  
  public static IObjectFieldAccessor<GWTCustomer,DateRange> OutsourceDateAccessor = new IObjectFieldAccessor<GWTCustomer,DateRange>(){
    				public DateRange getValue(GWTCustomer object){
    					return object.getOutsourceDate();
    				}
    				public void setValue(GWTCustomer object,DateRange value){
    					object.setOutsourceDate(value);
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
  
  public static IObjectFieldAccessor<GWTCustomer,GWTNamedEntity> DomainCodeAccessor = new IObjectFieldAccessor<GWTCustomer,GWTNamedEntity>(){
    				public GWTNamedEntity getValue(GWTCustomer object){
    					return object.getDomainCode();
    				}
    				public void setValue(GWTCustomer object,GWTNamedEntity value){
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
  
  public static IObjectFieldAccessor<GWTCustomer,GWTNamedEntity> ScaleCodeAccessor = new IObjectFieldAccessor<GWTCustomer,GWTNamedEntity>(){
    				public GWTNamedEntity getValue(GWTCustomer object){
    					return object.getScaleCode();
    				}
    				public void setValue(GWTCustomer object,GWTNamedEntity value){
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
  
  public static IObjectFieldAccessor<GWTCustomer,GWTNamedEntity> PropertyCodeAccessor = new IObjectFieldAccessor<GWTCustomer,GWTNamedEntity>(){
    				public GWTNamedEntity getValue(GWTCustomer object){
    					return object.getPropertyCode();
    				}
    				public void setValue(GWTCustomer object,GWTNamedEntity value){
    					object.setPropertyCode(value);
    				}
    			};
  
  private GWTNamedEntity regionCode;
  
  public GWTNamedEntity getRegionCode() {
    return this.regionCode;
  }
  
  public void setRegionCode(final GWTNamedEntity regionCode) {
    this.regionCode = regionCode;
  }
  
  public final static String P_RegionCode = "regionCode";
  
  public static IObjectFieldAccessor<GWTCustomer,GWTNamedEntity> RegionCodeAccessor = new IObjectFieldAccessor<GWTCustomer,GWTNamedEntity>(){
    				public GWTNamedEntity getValue(GWTCustomer object){
    					return object.getRegionCode();
    				}
    				public void setValue(GWTCustomer object,GWTNamedEntity value){
    					object.setRegionCode(value);
    				}
    			};
  
  private String customerComment;
  
  public String getCustomerComment() {
    return this.customerComment;
  }
  
  public void setCustomerComment(final String customerComment) {
    this.customerComment = customerComment;
  }
  
  public final static String P_CustomerComment = "customerComment";
  
  public static IObjectFieldAccessor<GWTCustomer,String> CustomerCommentAccessor = new IObjectFieldAccessor<GWTCustomer,String>(){
    				public String getValue(GWTCustomer object){
    					return object.getCustomerComment();
    				}
    				public void setValue(GWTCustomer object,String value){
    					object.setCustomerComment(value);
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
  
  public static IObjectFieldAccessor<GWTCustomer,String> AnnotationAccessor = new IObjectFieldAccessor<GWTCustomer,String>(){
    				public String getValue(GWTCustomer object){
    					return object.getAnnotation();
    				}
    				public void setValue(GWTCustomer object,String value){
    					object.setAnnotation(value);
    				}
    			};
  
  private Date lastUpdate;
  
  public Date getLastUpdate() {
    return this.lastUpdate;
  }
  
  public void setLastUpdate(final Date lastUpdate) {
    this.lastUpdate = lastUpdate;
  }
  
  public final static String P_LastUpdate = "lastUpdate";
  
  public static IObjectFieldAccessor<GWTCustomer,Date> LastUpdateAccessor = new IObjectFieldAccessor<GWTCustomer,Date>(){
    				public Date getValue(GWTCustomer object){
    					return object.getLastUpdate();
    				}
    				public void setValue(GWTCustomer object,Date value){
    					object.setLastUpdate(value);
    				}
    			};
}
