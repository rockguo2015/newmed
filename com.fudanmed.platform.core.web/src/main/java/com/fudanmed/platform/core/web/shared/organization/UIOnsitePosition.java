package com.fudanmed.platform.core.web.shared.organization;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIOnsitePosition extends GWTEntity {
  private String code;
  
  public String getCode() {
    return this.code;
  }
  
  public void setCode(final String code) {
    this.code = code;
  }
  
  public final static String P_Code = "code";
  
  public static IObjectFieldAccessor<UIOnsitePosition,String> CodeAccessor = new IObjectFieldAccessor<UIOnsitePosition,String>(){
    				public String getValue(UIOnsitePosition object){
    					return object.getCode();
    				}
    				public void setValue(UIOnsitePosition object,String value){
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
  
  public static IObjectFieldAccessor<UIOnsitePosition,String> NameAccessor = new IObjectFieldAccessor<UIOnsitePosition,String>(){
    				public String getValue(UIOnsitePosition object){
    					return object.getName();
    				}
    				public void setValue(UIOnsitePosition object,String value){
    					object.setName(value);
    				}
    			};
  
  private String phone;
  
  public String getPhone() {
    return this.phone;
  }
  
  public void setPhone(final String phone) {
    this.phone = phone;
  }
  
  public final static String P_Phone = "phone";
  
  public static IObjectFieldAccessor<UIOnsitePosition,String> PhoneAccessor = new IObjectFieldAccessor<UIOnsitePosition,String>(){
    				public String getValue(UIOnsitePosition object){
    					return object.getPhone();
    				}
    				public void setValue(UIOnsitePosition object,String value){
    					object.setPhone(value);
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
  
  public static IObjectFieldAccessor<UIOnsitePosition,String> SimplePyAccessor = new IObjectFieldAccessor<UIOnsitePosition,String>(){
    				public String getValue(UIOnsitePosition object){
    					return object.getSimplePy();
    				}
    				public void setValue(UIOnsitePosition object,String value){
    					object.setSimplePy(value);
    				}
    			};
  
  private RCOnsitePositionProxy parent;
  
  public RCOnsitePositionProxy getParent() {
    return this.parent;
  }
  
  public void setParent(final RCOnsitePositionProxy parent) {
    this.parent = parent;
  }
  
  public final static String P_Parent = "parent";
  
  public static IObjectFieldAccessor<UIOnsitePosition,RCOnsitePositionProxy> ParentAccessor = new IObjectFieldAccessor<UIOnsitePosition,RCOnsitePositionProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy getValue(UIOnsitePosition object){
    					return object.getParent();
    				}
    				public void setValue(UIOnsitePosition object,com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy value){
    					object.setParent(value);
    				}
    			};
  
  private String parentCode;
  
  public String getParentCode() {
    return this.parentCode;
  }
  
  public void setParentCode(final String parentCode) {
    this.parentCode = parentCode;
  }
  
  public final static String P_ParentCode = "parentCode";
  
  public static IObjectFieldAccessor<UIOnsitePosition,String> ParentCodeAccessor = new IObjectFieldAccessor<UIOnsitePosition,String>(){
    				public String getValue(UIOnsitePosition object){
    					return object.getParentCode();
    				}
    				public void setValue(UIOnsitePosition object,String value){
    					object.setParentCode(value);
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
  
  public static IObjectFieldAccessor<UIOnsitePosition,Boolean> InputNextAccessor = new IObjectFieldAccessor<UIOnsitePosition,Boolean>(){
    				public Boolean getValue(UIOnsitePosition object){
    					return object.getInputNext();
    				}
    				public void setValue(UIOnsitePosition object,Boolean value){
    					object.setInputNext(value);
    				}
    			};
  
  private String fullPath;
  
  public String getFullPath() {
    return this.fullPath;
  }
  
  public void setFullPath(final String fullPath) {
    this.fullPath = fullPath;
  }
  
  public final static String P_FullPath = "fullPath";
  
  public static IObjectFieldAccessor<UIOnsitePosition,String> FullPathAccessor = new IObjectFieldAccessor<UIOnsitePosition,String>(){
    				public String getValue(UIOnsitePosition object){
    					return object.getFullPath();
    				}
    				public void setValue(UIOnsitePosition object,String value){
    					object.setFullPath(value);
    				}
    			};
  
  public RCOnsitePositionProxy toProxy() {
    return (RCOnsitePositionProxy)super.toProxy();
    
  }
}
