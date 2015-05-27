package com.lanmon.business.shared.login;

import com.lanmon.business.shared.customer.GWTRole;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Collection;

public class GWTLoginUser extends GWTEntity {
  private String userid;
  
  public String getUserid() {
    return this.userid;
  }
  
  public void setUserid(final String userid) {
    this.userid = userid;
  }
  
  public final static String P_Userid = "userid";
  
  public static IObjectFieldAccessor<GWTLoginUser,String> UseridAccessor = new IObjectFieldAccessor<GWTLoginUser,String>(){
    				public String getValue(GWTLoginUser object){
    					return object.getUserid();
    				}
    				public void setValue(GWTLoginUser object,String value){
    					object.setUserid(value);
    				}
    			};
  
  private String userName;
  
  public String getUserName() {
    return this.userName;
  }
  
  public void setUserName(final String userName) {
    this.userName = userName;
  }
  
  public final static String P_UserName = "userName";
  
  public static IObjectFieldAccessor<GWTLoginUser,String> UserNameAccessor = new IObjectFieldAccessor<GWTLoginUser,String>(){
    				public String getValue(GWTLoginUser object){
    					return object.getUserName();
    				}
    				public void setValue(GWTLoginUser object,String value){
    					object.setUserName(value);
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
  
  public static IObjectFieldAccessor<GWTLoginUser,Integer> PhoneCountExpectedAccessor = new IObjectFieldAccessor<GWTLoginUser,Integer>(){
    				public Integer getValue(GWTLoginUser object){
    					return object.getPhoneCountExpected();
    				}
    				public void setValue(GWTLoginUser object,Integer value){
    					object.setPhoneCountExpected(value);
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
  
  public static IObjectFieldAccessor<GWTLoginUser,Collection<?>> RolesAccessor = new IObjectFieldAccessor<GWTLoginUser,Collection<?>>(){
    				public Collection getValue(GWTLoginUser object){
    					return object.getRoles();
    				}
    				public void setValue(GWTLoginUser object,Collection value){
    					object.setRoles(value);
    				}
    			};
}
