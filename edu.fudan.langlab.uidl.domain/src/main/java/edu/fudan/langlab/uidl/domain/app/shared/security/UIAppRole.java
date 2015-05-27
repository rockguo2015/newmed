package edu.fudan.langlab.uidl.domain.app.shared.security;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Collection;

public class UIAppRole implements IsSerializable {
  private String roleId;
  
  public String getRoleId() {
    return this.roleId;
  }
  
  public void setRoleId(final String roleId) {
    this.roleId = roleId;
  }
  
  public final static String P_RoleId = "roleId";
  
  public static IObjectFieldAccessor<UIAppRole,String> RoleIdAccessor = new IObjectFieldAccessor<UIAppRole,String>(){
    				public String getValue(UIAppRole object){
    					return object.getRoleId();
    				}
    				public void setValue(UIAppRole object,String value){
    					object.setRoleId(value);
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
  
  public static IObjectFieldAccessor<UIAppRole,String> NameAccessor = new IObjectFieldAccessor<UIAppRole,String>(){
    				public String getValue(UIAppRole object){
    					return object.getName();
    				}
    				public void setValue(UIAppRole object,String value){
    					object.setName(value);
    				}
    			};
  
  private Collection<?> functions;
  
  public Collection<?> getFunctions() {
    return this.functions;
  }
  
  public void setFunctions(final Collection<?> functions) {
    this.functions = functions;
  }
  
  public final static String P_Functions = "functions";
  
  public static IObjectFieldAccessor<UIAppRole,Collection<?>> FunctionsAccessor = new IObjectFieldAccessor<UIAppRole,Collection<?>>(){
    				public java.util.Collection<?> getValue(UIAppRole object){
    					return object.getFunctions();
    				}
    				public void setValue(UIAppRole object,java.util.Collection<?> value){
    					object.setFunctions(value);
    				}
    			};
}
