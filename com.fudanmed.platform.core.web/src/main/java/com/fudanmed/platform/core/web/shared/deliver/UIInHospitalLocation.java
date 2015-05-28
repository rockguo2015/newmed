package com.fudanmed.platform.core.web.shared.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLInHospitalLocationProxy;
import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIInHospitalLocation extends GWTEntity {
  private String code;
  
  public String getCode() {
    return this.code;
  }
  
  public void setCode(final String code) {
    this.code = code;
  }
  
  public final static String P_Code = "code";
  
  public static IObjectFieldAccessor<UIInHospitalLocation,String> CodeAccessor = new IObjectFieldAccessor<UIInHospitalLocation,String>(){
    				public String getValue(UIInHospitalLocation object){
    					return object.getCode();
    				}
    				public void setValue(UIInHospitalLocation object,String value){
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
  
  public static IObjectFieldAccessor<UIInHospitalLocation,String> NameAccessor = new IObjectFieldAccessor<UIInHospitalLocation,String>(){
    				public String getValue(UIInHospitalLocation object){
    					return object.getName();
    				}
    				public void setValue(UIInHospitalLocation object,String value){
    					object.setName(value);
    				}
    			};
  
  private RCOnsitePositionProxy location;
  
  public RCOnsitePositionProxy getLocation() {
    return this.location;
  }
  
  public void setLocation(final RCOnsitePositionProxy location) {
    this.location = location;
  }
  
  public final static String P_Location = "location";
  
  public static IObjectFieldAccessor<UIInHospitalLocation,RCOnsitePositionProxy> LocationAccessor = new IObjectFieldAccessor<UIInHospitalLocation,RCOnsitePositionProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy getValue(UIInHospitalLocation object){
    					return object.getLocation();
    				}
    				public void setValue(UIInHospitalLocation object,com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy value){
    					object.setLocation(value);
    				}
    			};
  
  public DLInHospitalLocationProxy toProxy() {
    return (DLInHospitalLocationProxy)super.toProxy();
    
  }
}
