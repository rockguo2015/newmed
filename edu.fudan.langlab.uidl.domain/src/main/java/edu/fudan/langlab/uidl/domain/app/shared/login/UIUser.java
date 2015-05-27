package edu.fudan.langlab.uidl.domain.app.shared.login;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIUser implements IsSerializable {
  private String userid;
  
  public String getUserid() {
    return this.userid;
  }
  
  public void setUserid(final String userid) {
    this.userid = userid;
  }
  
  public final static String P_Userid = "userid";
  
  public static IObjectFieldAccessor<UIUser,String> UseridAccessor = new IObjectFieldAccessor<UIUser,String>(){
    				public String getValue(UIUser object){
    					return object.getUserid();
    				}
    				public void setValue(UIUser object,String value){
    					object.setUserid(value);
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
  
  public static IObjectFieldAccessor<UIUser,String> NameAccessor = new IObjectFieldAccessor<UIUser,String>(){
    				public String getValue(UIUser object){
    					return object.getName();
    				}
    				public void setValue(UIUser object,String value){
    					object.setName(value);
    				}
    			};
}
