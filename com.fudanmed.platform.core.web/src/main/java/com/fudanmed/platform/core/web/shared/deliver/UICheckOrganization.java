package com.fudanmed.platform.core.web.shared.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UICheckOrganization extends GWTEntity {
  private String code;
  
  public String getCode() {
    return this.code;
  }
  
  public void setCode(final String code) {
    this.code = code;
  }
  
  public final static String P_Code = "code";
  
  public static IObjectFieldAccessor<UICheckOrganization,String> CodeAccessor = new IObjectFieldAccessor<UICheckOrganization,String>(){
    				public String getValue(UICheckOrganization object){
    					return object.getCode();
    				}
    				public void setValue(UICheckOrganization object,String value){
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
  
  public static IObjectFieldAccessor<UICheckOrganization,String> NameAccessor = new IObjectFieldAccessor<UICheckOrganization,String>(){
    				public String getValue(UICheckOrganization object){
    					return object.getName();
    				}
    				public void setValue(UICheckOrganization object,String value){
    					object.setName(value);
    				}
    			};
  
  private RCOrganizationProxy organization;
  
  public RCOrganizationProxy getOrganization() {
    return this.organization;
  }
  
  public void setOrganization(final RCOrganizationProxy organization) {
    this.organization = organization;
  }
  
  public final static String P_Organization = "organization";
  
  public static IObjectFieldAccessor<UICheckOrganization,RCOrganizationProxy> OrganizationAccessor = new IObjectFieldAccessor<UICheckOrganization,RCOrganizationProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy getValue(UICheckOrganization object){
    					return object.getOrganization();
    				}
    				public void setValue(UICheckOrganization object,com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy value){
    					object.setOrganization(value);
    				}
    			};
  
  public DLCheckOrganizationProxy toProxy() {
    return (DLCheckOrganizationProxy)super.toProxy();
    
  }
}
