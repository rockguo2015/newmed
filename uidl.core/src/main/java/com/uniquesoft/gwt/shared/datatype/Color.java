package com.uniquesoft.gwt.shared.datatype;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class Color implements IsSerializable {
  private String colorCode;
  
  public String getColorCode() {
    return this.colorCode;
  }
  
  public void setColorCode(final String colorCode) {
    this.colorCode = colorCode;
  }
  
  public final static String P_ColorCode = "colorCode";
  
  public static IObjectFieldAccessor<Color,String> ColorCodeAccessor = new IObjectFieldAccessor<Color,String>(){
    				public String getValue(Color object){
    					return object.getColorCode();
    				}
    				public void setValue(Color object,String value){
    					object.setColorCode(value);
    				}
    			};
}
