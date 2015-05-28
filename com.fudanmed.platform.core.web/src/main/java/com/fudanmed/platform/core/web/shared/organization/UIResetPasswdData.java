package com.fudanmed.platform.core.web.shared.organization;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import edu.fudan.langlab.domain.security.proxy.UserProxy;

public class UIResetPasswdData implements IsSerializable {
  private UserProxy user;
  
  public UserProxy getUser() {
    return this.user;
  }
  
  public void setUser(final UserProxy user) {
    this.user = user;
  }
  
  public final static String P_User = "user";
  
  public static IObjectFieldAccessor<UIResetPasswdData,UserProxy> UserAccessor = new IObjectFieldAccessor<UIResetPasswdData,UserProxy>(){
    				public edu.fudan.langlab.domain.security.proxy.UserProxy getValue(UIResetPasswdData object){
    					return object.getUser();
    				}
    				public void setValue(UIResetPasswdData object,edu.fudan.langlab.domain.security.proxy.UserProxy value){
    					object.setUser(value);
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
  
  public static IObjectFieldAccessor<UIResetPasswdData,String> NewPasswdAccessor = new IObjectFieldAccessor<UIResetPasswdData,String>(){
    				public String getValue(UIResetPasswdData object){
    					return object.getNewPasswd();
    				}
    				public void setValue(UIResetPasswdData object,String value){
    					object.setNewPasswd(value);
    				}
    			};
}
