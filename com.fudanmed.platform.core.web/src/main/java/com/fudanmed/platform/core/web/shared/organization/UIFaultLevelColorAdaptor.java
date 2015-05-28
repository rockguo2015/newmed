package com.fudanmed.platform.core.web.shared.organization;

import com.fudanmed.platform.core.common.proxy.RCFaultLevelColorAdaptorProxy;
import com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy;
import com.fudanmed.platform.core.web.shared.organization.UIStandardColor;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIFaultLevelColorAdaptor extends GWTEntity {
  private UIStandardColor color;
  
  public UIStandardColor getColor() {
    return this.color;
  }
  
  public void setColor(final UIStandardColor color) {
    this.color = color;
  }
  
  public final static String P_Color = "color";
  
  public static IObjectFieldAccessor<UIFaultLevelColorAdaptor,UIStandardColor> ColorAccessor = new IObjectFieldAccessor<UIFaultLevelColorAdaptor,UIStandardColor>(){
    				public com.fudanmed.platform.core.web.shared.organization.UIStandardColor getValue(UIFaultLevelColorAdaptor object){
    					return object.getColor();
    				}
    				public void setValue(UIFaultLevelColorAdaptor object,com.fudanmed.platform.core.web.shared.organization.UIStandardColor value){
    					object.setColor(value);
    				}
    			};
  
  private RCFaultLevelProxy faultLevel;
  
  public RCFaultLevelProxy getFaultLevel() {
    return this.faultLevel;
  }
  
  public void setFaultLevel(final RCFaultLevelProxy faultLevel) {
    this.faultLevel = faultLevel;
  }
  
  public final static String P_FaultLevel = "faultLevel";
  
  public static IObjectFieldAccessor<UIFaultLevelColorAdaptor,RCFaultLevelProxy> FaultLevelAccessor = new IObjectFieldAccessor<UIFaultLevelColorAdaptor,RCFaultLevelProxy>(){
    				public com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy getValue(UIFaultLevelColorAdaptor object){
    					return object.getFaultLevel();
    				}
    				public void setValue(UIFaultLevelColorAdaptor object,com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy value){
    					object.setFaultLevel(value);
    				}
    			};
  
  public RCFaultLevelColorAdaptorProxy toProxy() {
    return (RCFaultLevelColorAdaptorProxy)super.toProxy();
    
  }
}
