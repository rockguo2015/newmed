package edu.fudan.langlab.uidl.domain.app.shared.security;

import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import edu.fudan.langlab.domain.security.proxy.RoleProxy;

public class UIRole extends GWTEntity {
  private String roleId;
  
  public String getRoleId() {
    return this.roleId;
  }
  
  public void setRoleId(final String roleId) {
    this.roleId = roleId;
  }
  
  public final static String P_RoleId = "roleId";
  
  public static IObjectFieldAccessor<UIRole,String> RoleIdAccessor = new IObjectFieldAccessor<UIRole,String>(){
    				public String getValue(UIRole object){
    					return object.getRoleId();
    				}
    				public void setValue(UIRole object,String value){
    					object.setRoleId(value);
    				}
    			};
  
  private Boolean isBuildin;
  
  public Boolean getIsBuildin() {
    return this.isBuildin;
  }
  
  public void setIsBuildin(final Boolean isBuildin) {
    this.isBuildin = isBuildin;
  }
  
  public final static String P_IsBuildin = "isBuildin";
  
  public static IObjectFieldAccessor<UIRole,Boolean> IsBuildinAccessor = new IObjectFieldAccessor<UIRole,Boolean>(){
    				public Boolean getValue(UIRole object){
    					return object.getIsBuildin();
    				}
    				public void setValue(UIRole object,Boolean value){
    					object.setIsBuildin(value);
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
  
  public static IObjectFieldAccessor<UIRole,String> NameAccessor = new IObjectFieldAccessor<UIRole,String>(){
    				public String getValue(UIRole object){
    					return object.getName();
    				}
    				public void setValue(UIRole object,String value){
    					object.setName(value);
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
  
  public static IObjectFieldAccessor<UIRole,Boolean> InputNextAccessor = new IObjectFieldAccessor<UIRole,Boolean>(){
    				public Boolean getValue(UIRole object){
    					return object.getInputNext();
    				}
    				public void setValue(UIRole object,Boolean value){
    					object.setInputNext(value);
    				}
    			};
  
  public RoleProxy toProxy() {
    return (RoleProxy)super.toProxy();
    
  }
}
