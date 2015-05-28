package com.fudanmed.platform.core.web.shared.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverOrganizationProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIDeliverOrganization extends GWTEntity {
  private String code;
  
  public String getCode() {
    return this.code;
  }
  
  public void setCode(final String code) {
    this.code = code;
  }
  
  public final static String P_Code = "code";
  
  public static IObjectFieldAccessor<UIDeliverOrganization,String> CodeAccessor = new IObjectFieldAccessor<UIDeliverOrganization,String>(){
    				public String getValue(UIDeliverOrganization object){
    					return object.getCode();
    				}
    				public void setValue(UIDeliverOrganization object,String value){
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
  
  public static IObjectFieldAccessor<UIDeliverOrganization,String> NameAccessor = new IObjectFieldAccessor<UIDeliverOrganization,String>(){
    				public String getValue(UIDeliverOrganization object){
    					return object.getName();
    				}
    				public void setValue(UIDeliverOrganization object,String value){
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
  
  public static IObjectFieldAccessor<UIDeliverOrganization,RCOrganizationProxy> OrganizationAccessor = new IObjectFieldAccessor<UIDeliverOrganization,RCOrganizationProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy getValue(UIDeliverOrganization object){
    					return object.getOrganization();
    				}
    				public void setValue(UIDeliverOrganization object,com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy value){
    					object.setOrganization(value);
    				}
    			};
  
  public DLDeliverOrganizationProxy toProxy() {
    return (DLDeliverOrganizationProxy)super.toProxy();
    
  }
}
