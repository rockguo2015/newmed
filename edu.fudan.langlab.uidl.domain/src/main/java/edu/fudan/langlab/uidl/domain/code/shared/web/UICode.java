package edu.fudan.langlab.uidl.domain.code.shared.web;

import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import edu.fudan.langlab.domain.code.proxy.CodeProxy;

public class UICode extends GWTEntity {
  private String codeid;
  
  public String getCodeid() {
    return this.codeid;
  }
  
  public void setCodeid(final String codeid) {
    this.codeid = codeid;
  }
  
  public final static String P_Codeid = "codeid";
  
  public static IObjectFieldAccessor<UICode,String> CodeidAccessor = new IObjectFieldAccessor<UICode,String>(){
    				public String getValue(UICode object){
    					return object.getCodeid();
    				}
    				public void setValue(UICode object,String value){
    					object.setCodeid(value);
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
  
  public static IObjectFieldAccessor<UICode,String> NameAccessor = new IObjectFieldAccessor<UICode,String>(){
    				public String getValue(UICode object){
    					return object.getName();
    				}
    				public void setValue(UICode object,String value){
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
  
  public static IObjectFieldAccessor<UICode,Boolean> InputNextAccessor = new IObjectFieldAccessor<UICode,Boolean>(){
    				public Boolean getValue(UICode object){
    					return object.getInputNext();
    				}
    				public void setValue(UICode object,Boolean value){
    					object.setInputNext(value);
    				}
    			};
  
  public CodeProxy toProxy() {
    return (CodeProxy)super.toProxy();
    
  }
}
