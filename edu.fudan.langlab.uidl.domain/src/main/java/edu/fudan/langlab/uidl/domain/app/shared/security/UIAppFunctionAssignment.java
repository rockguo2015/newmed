package edu.fudan.langlab.uidl.domain.app.shared.security;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppFunction;
import java.util.Collection;

public class UIAppFunctionAssignment implements IsSerializable {
  private String roleId;
  
  public String getRoleId() {
    return this.roleId;
  }
  
  public void setRoleId(final String roleId) {
    this.roleId = roleId;
  }
  
  public final static String P_RoleId = "roleId";
  
  public static IObjectFieldAccessor<UIAppFunctionAssignment,String> RoleIdAccessor = new IObjectFieldAccessor<UIAppFunctionAssignment,String>(){
    				public String getValue(UIAppFunctionAssignment object){
    					return object.getRoleId();
    				}
    				public void setValue(UIAppFunctionAssignment object,String value){
    					object.setRoleId(value);
    				}
    			};
  
  private Collection<UIAppFunction> functions = com.google.common.collect.Lists.newArrayList();
  
  public Collection<UIAppFunction> getFunctions() {
    return this.functions;
  }
  
  public void setFunctions(final Collection<UIAppFunction> functions) {
    this.functions = functions;
  }
  
  public final static String P_Functions = "functions";
  
  public static IObjectFieldAccessor<UIAppFunctionAssignment,Collection<UIAppFunction>> FunctionsAccessor = new IObjectFieldAccessor<UIAppFunctionAssignment,Collection<UIAppFunction>>(){
    				public java.util.Collection<edu.fudan.langlab.uidl.domain.app.shared.security.UIAppFunction> getValue(UIAppFunctionAssignment object){
    					return object.getFunctions();
    				}
    				public void setValue(UIAppFunctionAssignment object,java.util.Collection<edu.fudan.langlab.uidl.domain.app.shared.security.UIAppFunction> value){
    					object.setFunctions(value);
    				}
    			};
}
