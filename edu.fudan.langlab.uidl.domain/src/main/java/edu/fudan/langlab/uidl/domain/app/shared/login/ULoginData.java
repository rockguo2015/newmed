package edu.fudan.langlab.uidl.domain.app.shared.login;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class ULoginData implements IsSerializable {
  private String userid;
  
  public String getUserid() {
    return this.userid;
  }
  
  public void setUserid(final String userid) {
    this.userid = userid;
  }
  
  public final static String P_Userid = "userid";
  
  public static IObjectFieldAccessor<ULoginData,String> UseridAccessor = new IObjectFieldAccessor<ULoginData,String>(){
    				public String getValue(ULoginData object){
    					return object.getUserid();
    				}
    				public void setValue(ULoginData object,String value){
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
  
  public static IObjectFieldAccessor<ULoginData,String> PasswdAccessor = new IObjectFieldAccessor<ULoginData,String>(){
    				public String getValue(ULoginData object){
    					return object.getPasswd();
    				}
    				public void setValue(ULoginData object,String value){
    					object.setPasswd(value);
    				}
    			};
}
