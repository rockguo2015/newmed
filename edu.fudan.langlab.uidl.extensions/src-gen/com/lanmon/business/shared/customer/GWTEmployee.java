package com.lanmon.business.shared.customer;

import com.lanmon.business.shared.customer.GWTRole;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Collection;

public class GWTEmployee extends GWTEntity {
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  public final static String P_Name = "name";
  
  public static IObjectFieldAccessor<GWTEmployee,String> NameAccessor = new IObjectFieldAccessor<GWTEmployee,String>(){
    				public String getValue(GWTEmployee object){
    					return object.getName();
    				}
    				public void setValue(GWTEmployee object,String value){
    					object.setName(value);
    				}
    			};
  
  private GWTNamedEntity directManager;
  
  public GWTNamedEntity getDirectManager() {
    return this.directManager;
  }
  
  public void setDirectManager(final GWTNamedEntity directManager) {
    this.directManager = directManager;
  }
  
  public final static String P_DirectManager = "directManager";
  
  public static IObjectFieldAccessor<GWTEmployee,GWTNamedEntity> DirectManagerAccessor = new IObjectFieldAccessor<GWTEmployee,GWTNamedEntity>(){
    				public GWTNamedEntity getValue(GWTEmployee object){
    					return object.getDirectManager();
    				}
    				public void setValue(GWTEmployee object,GWTNamedEntity value){
    					object.setDirectManager(value);
    				}
    			};
  
  private Integer phoneCountExpected;
  
  public Integer getPhoneCountExpected() {
    return this.phoneCountExpected;
  }
  
  public void setPhoneCountExpected(final Integer phoneCountExpected) {
    this.phoneCountExpected = phoneCountExpected;
  }
  
  public final static String P_PhoneCountExpected = "phoneCountExpected";
  
  public static IObjectFieldAccessor<GWTEmployee,Integer> PhoneCountExpectedAccessor = new IObjectFieldAccessor<GWTEmployee,Integer>(){
    				public Integer getValue(GWTEmployee object){
    					return object.getPhoneCountExpected();
    				}
    				public void setValue(GWTEmployee object,Integer value){
    					object.setPhoneCountExpected(value);
    				}
    			};
  
  private String userid;
  
  public String getUserid() {
    return this.userid;
  }
  
  public void setUserid(final String userid) {
    this.userid = userid;
  }
  
  public final static String P_Userid = "userid";
  
  public static IObjectFieldAccessor<GWTEmployee,String> UseridAccessor = new IObjectFieldAccessor<GWTEmployee,String>(){
    				public String getValue(GWTEmployee object){
    					return object.getUserid();
    				}
    				public void setValue(GWTEmployee object,String value){
    					object.setUserid(value);
    				}
    			};
  
  private String passwd;
  
  public String getPasswd() {
    return this.passwd;
  }
  
  public void setPasswd(final String passwd) {
    this.passwd = passwd;
  }
  
  public final static String P_Passwd = "passwd";
  
  public static IObjectFieldAccessor<GWTEmployee,String> PasswdAccessor = new IObjectFieldAccessor<GWTEmployee,String>(){
    				public String getValue(GWTEmployee object){
    					return object.getPasswd();
    				}
    				public void setValue(GWTEmployee object,String value){
    					object.setPasswd(value);
    				}
    			};
  
  private String passwdConfirm;
  
  public String getPasswdConfirm() {
    return this.passwdConfirm;
  }
  
  public void setPasswdConfirm(final String passwdConfirm) {
    this.passwdConfirm = passwdConfirm;
  }
  
  public final static String P_PasswdConfirm = "passwdConfirm";
  
  public static IObjectFieldAccessor<GWTEmployee,String> PasswdConfirmAccessor = new IObjectFieldAccessor<GWTEmployee,String>(){
    				public String getValue(GWTEmployee object){
    					return object.getPasswdConfirm();
    				}
    				public void setValue(GWTEmployee object,String value){
    					object.setPasswdConfirm(value);
    				}
    			};
  
  private Collection<GWTRole> roles = com.google.common.collect.Lists.newArrayList();
  
  public Collection<GWTRole> getRoles() {
    return this.roles;
  }
  
  public void setRoles(final Collection<GWTRole> roles) {
    this.roles = roles;
  }
  
  public final static String P_Roles = "roles";
  
  public static IObjectFieldAccessor<GWTEmployee,Collection<?>> RolesAccessor = new IObjectFieldAccessor<GWTEmployee,Collection<?>>(){
    				public Collection getValue(GWTEmployee object){
    					return object.getRoles();
    				}
    				public void setValue(GWTEmployee object,Collection value){
    					object.setRoles(value);
    				}
    			};
}
