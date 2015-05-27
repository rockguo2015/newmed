package edu.fudan.langlab.uidl.domain.app.shared.security;

import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import edu.fudan.langlab.domain.security.proxy.AppFunctionProxy;

public class UIAppFunction extends GWTEntity {
  private String parentFunctionId;
  
  public String getParentFunctionId() {
    return this.parentFunctionId;
  }
  
  public void setParentFunctionId(final String parentFunctionId) {
    this.parentFunctionId = parentFunctionId;
  }
  
  public final static String P_ParentFunctionId = "parentFunctionId";
  
  public static IObjectFieldAccessor<UIAppFunction,String> ParentFunctionIdAccessor = new IObjectFieldAccessor<UIAppFunction,String>(){
    				public String getValue(UIAppFunction object){
    					return object.getParentFunctionId();
    				}
    				public void setValue(UIAppFunction object,String value){
    					object.setParentFunctionId(value);
    				}
    			};
  
  private String functionId;
  
  public String getFunctionId() {
    return this.functionId;
  }
  
  public void setFunctionId(final String functionId) {
    this.functionId = functionId;
  }
  
  public final static String P_FunctionId = "functionId";
  
  public static IObjectFieldAccessor<UIAppFunction,String> FunctionIdAccessor = new IObjectFieldAccessor<UIAppFunction,String>(){
    				public String getValue(UIAppFunction object){
    					return object.getFunctionId();
    				}
    				public void setValue(UIAppFunction object,String value){
    					object.setFunctionId(value);
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
  
  public static IObjectFieldAccessor<UIAppFunction,String> NameAccessor = new IObjectFieldAccessor<UIAppFunction,String>(){
    				public String getValue(UIAppFunction object){
    					return object.getName();
    				}
    				public void setValue(UIAppFunction object,String value){
    					object.setName(value);
    				}
    			};
  
  public AppFunctionProxy toProxy() {
    return (AppFunctionProxy)super.toProxy();
    
  }
}
