package com.lanmon.business.shared.customer;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.lanmon.business.shared.customer.GWTCustomerStatus;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;

public class GWTNormalCustomerCriteria4Admin implements IsSerializable, IPagedCriteria {
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  public final static String P_Name = "name";
  
  public static IObjectFieldAccessor<GWTNormalCustomerCriteria4Admin,String> NameAccessor = new IObjectFieldAccessor<GWTNormalCustomerCriteria4Admin,String>(){
    				public String getValue(GWTNormalCustomerCriteria4Admin object){
    					return object.getName();
    				}
    				public void setValue(GWTNormalCustomerCriteria4Admin object,String value){
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
  
  public static IObjectFieldAccessor<GWTNormalCustomerCriteria4Admin,String> PhoneAccessor = new IObjectFieldAccessor<GWTNormalCustomerCriteria4Admin,String>(){
    				public String getValue(GWTNormalCustomerCriteria4Admin object){
    					return object.getPhone();
    				}
    				public void setValue(GWTNormalCustomerCriteria4Admin object,String value){
    					object.setPhone(value);
    				}
    			};
  
  private String info;
  
  public String getInfo() {
    return this.info;
  }
  
  public void setInfo(final String info) {
    this.info = info;
  }
  
  public final static String P_Info = "info";
  
  public static IObjectFieldAccessor<GWTNormalCustomerCriteria4Admin,String> InfoAccessor = new IObjectFieldAccessor<GWTNormalCustomerCriteria4Admin,String>(){
    				public String getValue(GWTNormalCustomerCriteria4Admin object){
    					return object.getInfo();
    				}
    				public void setValue(GWTNormalCustomerCriteria4Admin object,String value){
    					object.setInfo(value);
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
  
  public static IObjectFieldAccessor<GWTNormalCustomerCriteria4Admin,GWTCustomerStatus> StatusAccessor = new IObjectFieldAccessor<GWTNormalCustomerCriteria4Admin,GWTCustomerStatus>(){
    				public GWTCustomerStatus getValue(GWTNormalCustomerCriteria4Admin object){
    					return object.getStatus();
    				}
    				public void setValue(GWTNormalCustomerCriteria4Admin object,GWTCustomerStatus value){
    					object.setStatus(value);
    				}
    			};
  
  private Boolean noPhoneSales;
  
  public Boolean getNoPhoneSales() {
    return this.noPhoneSales;
  }
  
  public void setNoPhoneSales(final Boolean noPhoneSales) {
    this.noPhoneSales = noPhoneSales;
  }
  
  public final static String P_NoPhoneSales = "noPhoneSales";
  
  public static IObjectFieldAccessor<GWTNormalCustomerCriteria4Admin,Boolean> NoPhoneSalesAccessor = new IObjectFieldAccessor<GWTNormalCustomerCriteria4Admin,Boolean>(){
    				public Boolean getValue(GWTNormalCustomerCriteria4Admin object){
    					return object.getNoPhoneSales();
    				}
    				public void setValue(GWTNormalCustomerCriteria4Admin object,Boolean value){
    					object.setNoPhoneSales(value);
    				}
    			};
  
  private GWTNamedEntity phoneSales;
  
  public GWTNamedEntity getPhoneSales() {
    return this.phoneSales;
  }
  
  public void setPhoneSales(final GWTNamedEntity phoneSales) {
    this.phoneSales = phoneSales;
  }
  
  public final static String P_PhoneSales = "phoneSales";
  
  public static IObjectFieldAccessor<GWTNormalCustomerCriteria4Admin,GWTNamedEntity> PhoneSalesAccessor = new IObjectFieldAccessor<GWTNormalCustomerCriteria4Admin,GWTNamedEntity>(){
    				public GWTNamedEntity getValue(GWTNormalCustomerCriteria4Admin object){
    					return object.getPhoneSales();
    				}
    				public void setValue(GWTNormalCustomerCriteria4Admin object,GWTNamedEntity value){
    					object.setPhoneSales(value);
    				}
    			};
  
  private GWTNamedEntity onsiteSales;
  
  public GWTNamedEntity getOnsiteSales() {
    return this.onsiteSales;
  }
  
  public void setOnsiteSales(final GWTNamedEntity onsiteSales) {
    this.onsiteSales = onsiteSales;
  }
  
  public final static String P_OnsiteSales = "onsiteSales";
  
  public static IObjectFieldAccessor<GWTNormalCustomerCriteria4Admin,GWTNamedEntity> OnsiteSalesAccessor = new IObjectFieldAccessor<GWTNormalCustomerCriteria4Admin,GWTNamedEntity>(){
    				public GWTNamedEntity getValue(GWTNormalCustomerCriteria4Admin object){
    					return object.getOnsiteSales();
    				}
    				public void setValue(GWTNormalCustomerCriteria4Admin object,GWTNamedEntity value){
    					object.setOnsiteSales(value);
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
  
  public static IObjectFieldAccessor<GWTNormalCustomerCriteria4Admin,Integer> PageAccessor = new IObjectFieldAccessor<GWTNormalCustomerCriteria4Admin,Integer>(){
    				public Integer getValue(GWTNormalCustomerCriteria4Admin object){
    					return object.getPage();
    				}
    				public void setValue(GWTNormalCustomerCriteria4Admin object,Integer value){
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
  
  public static IObjectFieldAccessor<GWTNormalCustomerCriteria4Admin,Integer> PageSizeAccessor = new IObjectFieldAccessor<GWTNormalCustomerCriteria4Admin,Integer>(){
    				public Integer getValue(GWTNormalCustomerCriteria4Admin object){
    					return object.getPageSize();
    				}
    				public void setValue(GWTNormalCustomerCriteria4Admin object,Integer value){
    					object.setPageSize(value);
    				}
    			};
}
