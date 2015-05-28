package com.fudanmed.platform.core.web.shared.organization;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeAction;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeManager;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.organization.UIEmployeeStatus;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import edu.fudan.langlab.domain.security.proxy.RoleProxy;
import java.util.Collection;

public class UIEmployee extends GWTEntity {
  private String eid;
  
  public String getEid() {
    return this.eid;
  }
  
  public void setEid(final String eid) {
    this.eid = eid;
  }
  
  public final static String P_Eid = "eid";
  
  public static IObjectFieldAccessor<UIEmployee,String> EidAccessor = new IObjectFieldAccessor<UIEmployee,String>(){
    				public String getValue(UIEmployee object){
    					return object.getEid();
    				}
    				public void setValue(UIEmployee object,String value){
    					object.setEid(value);
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
  
  public static IObjectFieldAccessor<UIEmployee,String> NameAccessor = new IObjectFieldAccessor<UIEmployee,String>(){
    				public String getValue(UIEmployee object){
    					return object.getName();
    				}
    				public void setValue(UIEmployee object,String value){
    					object.setName(value);
    				}
    			};
  
  private String mobil;
  
  public String getMobil() {
    return this.mobil;
  }
  
  public void setMobil(final String mobil) {
    this.mobil = mobil;
  }
  
  public final static String P_Mobil = "mobil";
  
  public static IObjectFieldAccessor<UIEmployee,String> MobilAccessor = new IObjectFieldAccessor<UIEmployee,String>(){
    				public String getValue(UIEmployee object){
    					return object.getMobil();
    				}
    				public void setValue(UIEmployee object,String value){
    					object.setMobil(value);
    				}
    			};
  
  private String tel;
  
  public String getTel() {
    return this.tel;
  }
  
  public void setTel(final String tel) {
    this.tel = tel;
  }
  
  public final static String P_Tel = "tel";
  
  public static IObjectFieldAccessor<UIEmployee,String> TelAccessor = new IObjectFieldAccessor<UIEmployee,String>(){
    				public String getValue(UIEmployee object){
    					return object.getTel();
    				}
    				public void setValue(UIEmployee object,String value){
    					object.setTel(value);
    				}
    			};
  
  private String workTel;
  
  public String getWorkTel() {
    return this.workTel;
  }
  
  public void setWorkTel(final String workTel) {
    this.workTel = workTel;
  }
  
  public final static String P_WorkTel = "workTel";
  
  public static IObjectFieldAccessor<UIEmployee,String> WorkTelAccessor = new IObjectFieldAccessor<UIEmployee,String>(){
    				public String getValue(UIEmployee object){
    					return object.getWorkTel();
    				}
    				public void setValue(UIEmployee object,String value){
    					object.setWorkTel(value);
    				}
    			};
  
  private String cardNumber;
  
  public String getCardNumber() {
    return this.cardNumber;
  }
  
  public void setCardNumber(final String cardNumber) {
    this.cardNumber = cardNumber;
  }
  
  public final static String P_CardNumber = "cardNumber";
  
  public static IObjectFieldAccessor<UIEmployee,String> CardNumberAccessor = new IObjectFieldAccessor<UIEmployee,String>(){
    				public String getValue(UIEmployee object){
    					return object.getCardNumber();
    				}
    				public void setValue(UIEmployee object,String value){
    					object.setCardNumber(value);
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
  
  public static IObjectFieldAccessor<UIEmployee,String> EmailAccessor = new IObjectFieldAccessor<UIEmployee,String>(){
    				public String getValue(UIEmployee object){
    					return object.getEmail();
    				}
    				public void setValue(UIEmployee object,String value){
    					object.setEmail(value);
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
  
  public static IObjectFieldAccessor<UIEmployee,String> AddressAccessor = new IObjectFieldAccessor<UIEmployee,String>(){
    				public String getValue(UIEmployee object){
    					return object.getAddress();
    				}
    				public void setValue(UIEmployee object,String value){
    					object.setAddress(value);
    				}
    			};
  
  private RCOrganizationProxy organization;
  
  public RCOrganizationProxy getOrganization() {
    return this.organization;
  }
  
  public void setOrganization(final RCOrganizationProxy organization) {
    this.organization = organization;
  }
  
  public final static String P_Organization = "organization";
  
  public static IObjectFieldAccessor<UIEmployee,RCOrganizationProxy> OrganizationAccessor = new IObjectFieldAccessor<UIEmployee,RCOrganizationProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy getValue(UIEmployee object){
    					return object.getOrganization();
    				}
    				public void setValue(UIEmployee object,com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy value){
    					object.setOrganization(value);
    				}
    			};
  
  private Collection<RoleProxy> roles = com.google.common.collect.Lists.newArrayList();
  
  public Collection<RoleProxy> getRoles() {
    return this.roles;
  }
  
  public void setRoles(final Collection<RoleProxy> roles) {
    this.roles = roles;
  }
  
  public final static String P_Roles = "roles";
  
  public static IObjectFieldAccessor<UIEmployee,Collection<RoleProxy>> RolesAccessor = new IObjectFieldAccessor<UIEmployee,Collection<RoleProxy>>(){
    				public java.util.Collection<edu.fudan.langlab.domain.security.proxy.RoleProxy> getValue(UIEmployee object){
    					return object.getRoles();
    				}
    				public void setValue(UIEmployee object,java.util.Collection<edu.fudan.langlab.domain.security.proxy.RoleProxy> value){
    					object.setRoles(value);
    				}
    			};
  
  private Boolean isLeaveJob;
  
  public Boolean getIsLeaveJob() {
    return this.isLeaveJob;
  }
  
  public void setIsLeaveJob(final Boolean isLeaveJob) {
    this.isLeaveJob = isLeaveJob;
  }
  
  public final static String P_IsLeaveJob = "isLeaveJob";
  
  public static IObjectFieldAccessor<UIEmployee,Boolean> IsLeaveJobAccessor = new IObjectFieldAccessor<UIEmployee,Boolean>(){
    				public Boolean getValue(UIEmployee object){
    					return object.getIsLeaveJob();
    				}
    				public void setValue(UIEmployee object,Boolean value){
    					object.setIsLeaveJob(value);
    				}
    			};
  
  private Boolean inputNext;
  
  public Boolean getInputNext() {
    return this.inputNext;
  }
  
  public void setInputNext(final Boolean inputNext) {
    this.inputNext = inputNext;
  }
  
  public final static String P_InputNext = "inputNext";
  
  public static IObjectFieldAccessor<UIEmployee,Boolean> InputNextAccessor = new IObjectFieldAccessor<UIEmployee,Boolean>(){
    				public Boolean getValue(UIEmployee object){
    					return object.getInputNext();
    				}
    				public void setValue(UIEmployee object,Boolean value){
    					object.setInputNext(value);
    				}
    			};
  
  private UIEmployeeStatus status;
  
  public UIEmployeeStatus getStatus() {
    return this.status;
  }
  
  public void setStatus(final UIEmployeeStatus status) {
    this.status = status;
  }
  
  public final static String P_Status = "status";
  
  public static IObjectFieldAccessor<UIEmployee,UIEmployeeStatus> StatusAccessor = new IObjectFieldAccessor<UIEmployee,UIEmployeeStatus>(){
    				public com.fudanmed.platform.core.web.shared.organization.UIEmployeeStatus getValue(UIEmployee object){
    					return object.getStatus();
    				}
    				public void setValue(UIEmployee object,com.fudanmed.platform.core.web.shared.organization.UIEmployeeStatus value){
    					object.setStatus(value);
    				}
    			};
  
  public Boolean validFor(final RCEmployeeAction action) {
    Boolean _isActionValid = RCEmployeeManager.isActionValid(action, this.status);
    return _isActionValid;
  }
  
  public RCEmployeeProxy toProxy() {
    return (RCEmployeeProxy)super.toProxy();
    
  }
}
