package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIMaintenanceTeam extends GWTEntity {
  private RCOrganizationProxy organization;
  
  public RCOrganizationProxy getOrganization() {
    return this.organization;
  }
  
  public void setOrganization(final RCOrganizationProxy organization) {
    this.organization = organization;
  }
  
  public final static String P_Organization = "organization";
  
  public static IObjectFieldAccessor<UIMaintenanceTeam,RCOrganizationProxy> OrganizationAccessor = new IObjectFieldAccessor<UIMaintenanceTeam,RCOrganizationProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy getValue(UIMaintenanceTeam object){
    					return object.getOrganization();
    				}
    				public void setValue(UIMaintenanceTeam object,com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy value){
    					object.setOrganization(value);
    				}
    			};
  
  public RCMaintenanceTeamProxy toProxy() {
    return (RCMaintenanceTeamProxy)super.toProxy();
    
  }
}
