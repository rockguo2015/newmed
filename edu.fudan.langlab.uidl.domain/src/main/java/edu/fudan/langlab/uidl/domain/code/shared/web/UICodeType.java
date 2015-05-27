package edu.fudan.langlab.uidl.domain.code.shared.web;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UICodeType implements IsSerializable {
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  public final static String P_Name = "name";
  
  public static IObjectFieldAccessor<UICodeType,String> NameAccessor = new IObjectFieldAccessor<UICodeType,String>(){
    				public String getValue(UICodeType object){
    					return object.getName();
    				}
    				public void setValue(UICodeType object,String value){
    					object.setName(value);
    				}
    			};
  
  private String className;
  
  public String getClassName() {
    return this.className;
  }
  
  public void setClassName(final String className) {
    this.className = className;
  }
  
  public final static String P_ClassName = "className";
  
  public static IObjectFieldAccessor<UICodeType,String> ClassNameAccessor = new IObjectFieldAccessor<UICodeType,String>(){
    				public String getValue(UICodeType object){
    					return object.getClassName();
    				}
    				public void setValue(UICodeType object,String value){
    					object.setClassName(value);
    				}
    			};
}
