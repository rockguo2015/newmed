package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIMaintenamceType extends GWTEntity {
  private String code;
  
  public String getCode() {
    return this.code;
  }
  
  public void setCode(final String code) {
    this.code = code;
  }
  
  public final static String P_Code = "code";
  
  public static IObjectFieldAccessor<UIMaintenamceType,String> CodeAccessor = new IObjectFieldAccessor<UIMaintenamceType,String>(){
    				public String getValue(UIMaintenamceType object){
    					return object.getCode();
    				}
    				public void setValue(UIMaintenamceType object,String value){
    					object.setCode(value);
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
  
  public static IObjectFieldAccessor<UIMaintenamceType,String> NameAccessor = new IObjectFieldAccessor<UIMaintenamceType,String>(){
    				public String getValue(UIMaintenamceType object){
    					return object.getName();
    				}
    				public void setValue(UIMaintenamceType object,String value){
    					object.setName(value);
    				}
    			};
  
  private String simplePy;
  
  public String getSimplePy() {
    return this.simplePy;
  }
  
  public void setSimplePy(final String simplePy) {
    this.simplePy = simplePy;
  }
  
  public final static String P_SimplePy = "simplePy";
  
  public static IObjectFieldAccessor<UIMaintenamceType,String> SimplePyAccessor = new IObjectFieldAccessor<UIMaintenamceType,String>(){
    				public String getValue(UIMaintenamceType object){
    					return object.getSimplePy();
    				}
    				public void setValue(UIMaintenamceType object,String value){
    					object.setSimplePy(value);
    				}
    			};
  
  private RCMaintenamceTypeProxy parent;
  
  public RCMaintenamceTypeProxy getParent() {
    return this.parent;
  }
  
  public void setParent(final RCMaintenamceTypeProxy parent) {
    this.parent = parent;
  }
  
  public final static String P_Parent = "parent";
  
  public static IObjectFieldAccessor<UIMaintenamceType,RCMaintenamceTypeProxy> ParentAccessor = new IObjectFieldAccessor<UIMaintenamceType,RCMaintenamceTypeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy getValue(UIMaintenamceType object){
    					return object.getParent();
    				}
    				public void setValue(UIMaintenamceType object,com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy value){
    					object.setParent(value);
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
  
  public static IObjectFieldAccessor<UIMaintenamceType,Boolean> InputNextAccessor = new IObjectFieldAccessor<UIMaintenamceType,Boolean>(){
    				public Boolean getValue(UIMaintenamceType object){
    					return object.getInputNext();
    				}
    				public void setValue(UIMaintenamceType object,Boolean value){
    					object.setInputNext(value);
    				}
    			};
  
  public RCMaintenamceTypeProxy toProxy() {
    return (RCMaintenamceTypeProxy)super.toProxy();
    
  }
}
