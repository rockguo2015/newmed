package com.fudanmed.platform.core.web.shared.device;

import com.fudanmed.platform.core.entityextension.proxy.RCNumberWithUnitTypeProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UINumberWithUnitType extends GWTEntity {
  private String alias;
  
  public String getAlias() {
    return this.alias;
  }
  
  public void setAlias(final String alias) {
    this.alias = alias;
  }
  
  public final static String P_Alias = "alias";
  
  public static IObjectFieldAccessor<UINumberWithUnitType,String> AliasAccessor = new IObjectFieldAccessor<UINumberWithUnitType,String>(){
    				public String getValue(UINumberWithUnitType object){
    					return object.getAlias();
    				}
    				public void setValue(UINumberWithUnitType object,String value){
    					object.setAlias(value);
    				}
    			};
  
  private String unit;
  
  public String getUnit() {
    return this.unit;
  }
  
  public void setUnit(final String unit) {
    this.unit = unit;
  }
  
  public final static String P_Unit = "unit";
  
  public static IObjectFieldAccessor<UINumberWithUnitType,String> UnitAccessor = new IObjectFieldAccessor<UINumberWithUnitType,String>(){
    				public String getValue(UINumberWithUnitType object){
    					return object.getUnit();
    				}
    				public void setValue(UINumberWithUnitType object,String value){
    					object.setUnit(value);
    				}
    			};
  
  public RCNumberWithUnitTypeProxy toProxy() {
    return (RCNumberWithUnitTypeProxy)super.toProxy();
    
  }
}
