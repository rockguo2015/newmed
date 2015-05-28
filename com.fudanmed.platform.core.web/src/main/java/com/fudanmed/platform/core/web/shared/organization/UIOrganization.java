package com.fudanmed.platform.core.web.shared.organization;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Collection;

public class UIOrganization extends GWTEntity {
  private String code;
  
  public String getCode() {
    return this.code;
  }
  
  public void setCode(final String code) {
    this.code = code;
  }
  
  public final static String P_Code = "code";
  
  public static IObjectFieldAccessor<UIOrganization,String> CodeAccessor = new IObjectFieldAccessor<UIOrganization,String>(){
    				public String getValue(UIOrganization object){
    					return object.getCode();
    				}
    				public void setValue(UIOrganization object,String value){
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
  
  public static IObjectFieldAccessor<UIOrganization,String> NameAccessor = new IObjectFieldAccessor<UIOrganization,String>(){
    				public String getValue(UIOrganization object){
    					return object.getName();
    				}
    				public void setValue(UIOrganization object,String value){
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
  
  public static IObjectFieldAccessor<UIOrganization,String> SimplePyAccessor = new IObjectFieldAccessor<UIOrganization,String>(){
    				public String getValue(UIOrganization object){
    					return object.getSimplePy();
    				}
    				public void setValue(UIOrganization object,String value){
    					object.setSimplePy(value);
    				}
    			};
  
  private RCOrganizationProxy parent;
  
  public RCOrganizationProxy getParent() {
    return this.parent;
  }
  
  public void setParent(final RCOrganizationProxy parent) {
    this.parent = parent;
  }
  
  public final static String P_Parent = "parent";
  
  public static IObjectFieldAccessor<UIOrganization,RCOrganizationProxy> ParentAccessor = new IObjectFieldAccessor<UIOrganization,RCOrganizationProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy getValue(UIOrganization object){
    					return object.getParent();
    				}
    				public void setValue(UIOrganization object,com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy value){
    					object.setParent(value);
    				}
    			};
  
  private Collection<UIOnsitePosition> positions = com.google.common.collect.Lists.newArrayList();
  
  public Collection<UIOnsitePosition> getPositions() {
    return this.positions;
  }
  
  public void setPositions(final Collection<UIOnsitePosition> positions) {
    this.positions = positions;
  }
  
  public final static String P_Positions = "positions";
  
  public static IObjectFieldAccessor<UIOrganization,Collection<UIOnsitePosition>> PositionsAccessor = new IObjectFieldAccessor<UIOrganization,Collection<UIOnsitePosition>>(){
    				public java.util.Collection<com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition> getValue(UIOrganization object){
    					return object.getPositions();
    				}
    				public void setValue(UIOrganization object,java.util.Collection<com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition> value){
    					object.setPositions(value);
    				}
    			};
  
  private Collection<RCOnsitePositionProxy> positionsProxy = com.google.common.collect.Lists.newArrayList();
  
  public Collection<RCOnsitePositionProxy> getPositionsProxy() {
    return this.positionsProxy;
  }
  
  public void setPositionsProxy(final Collection<RCOnsitePositionProxy> positionsProxy) {
    this.positionsProxy = positionsProxy;
  }
  
  public final static String P_PositionsProxy = "positionsProxy";
  
  public static IObjectFieldAccessor<UIOrganization,Collection<RCOnsitePositionProxy>> PositionsProxyAccessor = new IObjectFieldAccessor<UIOrganization,Collection<RCOnsitePositionProxy>>(){
    				public java.util.Collection<com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy> getValue(UIOrganization object){
    					return object.getPositionsProxy();
    				}
    				public void setValue(UIOrganization object,java.util.Collection<com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy> value){
    					object.setPositionsProxy(value);
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
  
  public static IObjectFieldAccessor<UIOrganization,Boolean> InputNextAccessor = new IObjectFieldAccessor<UIOrganization,Boolean>(){
    				public Boolean getValue(UIOrganization object){
    					return object.getInputNext();
    				}
    				public void setValue(UIOrganization object,Boolean value){
    					object.setInputNext(value);
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
  
  public static IObjectFieldAccessor<UIOrganization,String> ParentCodeAccessor = new IObjectFieldAccessor<UIOrganization,String>(){
    				public String getValue(UIOrganization object){
    					return object.getParentCode();
    				}
    				public void setValue(UIOrganization object,String value){
    					object.setParentCode(value);
    				}
    			};
  
  private String positionCodes;
  
  public String getPositionCodes() {
    return this.positionCodes;
  }
  
  public void setPositionCodes(final String positionCodes) {
    this.positionCodes = positionCodes;
  }
  
  public final static String P_PositionCodes = "positionCodes";
  
  public static IObjectFieldAccessor<UIOrganization,String> PositionCodesAccessor = new IObjectFieldAccessor<UIOrganization,String>(){
    				public String getValue(UIOrganization object){
    					return object.getPositionCodes();
    				}
    				public void setValue(UIOrganization object,String value){
    					object.setPositionCodes(value);
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
  
  public static IObjectFieldAccessor<UIOrganization,String> FullPathAccessor = new IObjectFieldAccessor<UIOrganization,String>(){
    				public String getValue(UIOrganization object){
    					return object.getFullPath();
    				}
    				public void setValue(UIOrganization object,String value){
    					object.setFullPath(value);
    				}
    			};
  
  public RCOrganizationProxy toProxy() {
    return (RCOrganizationProxy)super.toProxy();
    
  }
}
