package com.lanmon.business.shared.code;

import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class GWTCode extends GWTEntity {
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  public final static String P_Name = "name";
  
  public static IObjectFieldAccessor<GWTCode,String> NameAccessor = new IObjectFieldAccessor<GWTCode,String>(){
    				public String getValue(GWTCode object){
    					return object.getName();
    				}
    				public void setValue(GWTCode object,String value){
    					object.setName(value);
    				}
    			};
}
