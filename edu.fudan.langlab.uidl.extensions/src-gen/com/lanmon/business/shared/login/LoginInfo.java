package com.lanmon.business.shared.login;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class LoginInfo implements IsSerializable {
  private String userid;
  
  public String getUserid() {
    return this.userid;
  }
  
  public void setUserid(final String userid) {
    this.userid = userid;
  }
  
  public final static String P_Userid = "userid";
  
  public static IObjectFieldAccessor<LoginInfo,String> UseridAccessor = new IObjectFieldAccessor<LoginInfo,String>(){
    				public String getValue(LoginInfo object){
    					return object.getUserid();
    				}
    				public void setValue(LoginInfo object,String value){
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
  
  public static IObjectFieldAccessor<LoginInfo,String> PasswdAccessor = new IObjectFieldAccessor<LoginInfo,String>(){
    				public String getValue(LoginInfo object){
    					return object.getPasswd();
    				}
    				public void setValue(LoginInfo object,String value){
    					object.setPasswd(value);
    				}
    			};
}
