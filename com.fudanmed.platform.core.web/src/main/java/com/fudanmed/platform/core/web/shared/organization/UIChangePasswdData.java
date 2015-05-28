package com.fudanmed.platform.core.web.shared.organization;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import edu.fudan.langlab.domain.security.proxy.UserProxy;

public class UIChangePasswdData implements IsSerializable {
  private UserProxy user;
  
  public UserProxy getUser() {
    return this.user;
  }
  
  public void setUser(final UserProxy user) {
    this.user = user;
  }
  
  public final static String P_User = "user";
  
  public static IObjectFieldAccessor<UIChangePasswdData,UserProxy> UserAccessor = new IObjectFieldAccessor<UIChangePasswdData,UserProxy>(){
    				public edu.fudan.langlab.domain.security.proxy.UserProxy getValue(UIChangePasswdData object){
    					return object.getUser();
    				}
    				public void setValue(UIChangePasswdData object,edu.fudan.langlab.domain.security.proxy.UserProxy value){
    					object.setUser(value);
    				}
    			};
  
  private String orgPasswd;
  
  public String getOrgPasswd() {
    return this.orgPasswd;
  }
  
  public void setOrgPasswd(final String orgPasswd) {
    this.orgPasswd = orgPasswd;
  }
  
  public final static String P_OrgPasswd = "orgPasswd";
  
  public static IObjectFieldAccessor<UIChangePasswdData,String> OrgPasswdAccessor = new IObjectFieldAccessor<UIChangePasswdData,String>(){
    				public String getValue(UIChangePasswdData object){
    					return object.getOrgPasswd();
    				}
    				public void setValue(UIChangePasswdData object,String value){
    					object.setOrgPasswd(value);
    				}
    			};
  
  private String newPasswd;
  
  public String getNewPasswd() {
    return this.newPasswd;
  }
  
  public void setNewPasswd(final String newPasswd) {
    this.newPasswd = newPasswd;
  }
  
  public final static String P_NewPasswd = "newPasswd";
  
  public static IObjectFieldAccessor<UIChangePasswdData,String> NewPasswdAccessor = new IObjectFieldAccessor<UIChangePasswdData,String>(){
    				public String getValue(UIChangePasswdData object){
    					return object.getNewPasswd();
    				}
    				public void setValue(UIChangePasswdData object,String value){
    					object.setNewPasswd(value);
    				}
    			};
  
  private String newPasswdAgain;
  
  public String getNewPasswdAgain() {
    return this.newPasswdAgain;
  }
  
  public void setNewPasswdAgain(final String newPasswdAgain) {
    this.newPasswdAgain = newPasswdAgain;
  }
  
  public final static String P_NewPasswdAgain = "newPasswdAgain";
  
  public static IObjectFieldAccessor<UIChangePasswdData,String> NewPasswdAgainAccessor = new IObjectFieldAccessor<UIChangePasswdData,String>(){
    				public String getValue(UIChangePasswdData object){
    					return object.getNewPasswdAgain();
    				}
    				public void setValue(UIChangePasswdData object,String value){
    					object.setNewPasswdAgain(value);
    				}
    			};
}
