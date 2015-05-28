package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Collection;

public class UIWarehouse extends GWTEntity {
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  public final static String P_Name = "name";
  
  public static IObjectFieldAccessor<UIWarehouse,String> NameAccessor = new IObjectFieldAccessor<UIWarehouse,String>(){
    				public String getValue(UIWarehouse object){
    					return object.getName();
    				}
    				public void setValue(UIWarehouse object,String value){
    					object.setName(value);
    				}
    			};
  
  private String location;
  
  public String getLocation() {
    return this.location;
  }
  
  public void setLocation(final String location) {
    this.location = location;
  }
  
  public final static String P_Location = "location";
  
  public static IObjectFieldAccessor<UIWarehouse,String> LocationAccessor = new IObjectFieldAccessor<UIWarehouse,String>(){
    				public String getValue(UIWarehouse object){
    					return object.getLocation();
    				}
    				public void setValue(UIWarehouse object,String value){
    					object.setLocation(value);
    				}
    			};
  
  private Boolean isMajor;
  
  public Boolean getIsMajor() {
    return this.isMajor;
  }
  
  public void setIsMajor(final Boolean isMajor) {
    this.isMajor = isMajor;
  }
  
  public final static String P_IsMajor = "isMajor";
  
  public static IObjectFieldAccessor<UIWarehouse,Boolean> IsMajorAccessor = new IObjectFieldAccessor<UIWarehouse,Boolean>(){
    				public Boolean getValue(UIWarehouse object){
    					return object.getIsMajor();
    				}
    				public void setValue(UIWarehouse object,Boolean value){
    					object.setIsMajor(value);
    				}
    			};
  
  private Collection<RCEmployeeProxy> storeManager = com.google.common.collect.Lists.newArrayList();
  
  public Collection<RCEmployeeProxy> getStoreManager() {
    return this.storeManager;
  }
  
  public void setStoreManager(final Collection<RCEmployeeProxy> storeManager) {
    this.storeManager = storeManager;
  }
  
  public final static String P_StoreManager = "storeManager";
  
  public static IObjectFieldAccessor<UIWarehouse,Collection<RCEmployeeProxy>> StoreManagerAccessor = new IObjectFieldAccessor<UIWarehouse,Collection<RCEmployeeProxy>>(){
    				public java.util.Collection<com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy> getValue(UIWarehouse object){
    					return object.getStoreManager();
    				}
    				public void setValue(UIWarehouse object,java.util.Collection<com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy> value){
    					object.setStoreManager(value);
    				}
    			};
  
  private Collection<RCMaintenanceTeamProxy> relatedTeams = com.google.common.collect.Lists.newArrayList();
  
  public Collection<RCMaintenanceTeamProxy> getRelatedTeams() {
    return this.relatedTeams;
  }
  
  public void setRelatedTeams(final Collection<RCMaintenanceTeamProxy> relatedTeams) {
    this.relatedTeams = relatedTeams;
  }
  
  public final static String P_RelatedTeams = "relatedTeams";
  
  public static IObjectFieldAccessor<UIWarehouse,Collection<RCMaintenanceTeamProxy>> RelatedTeamsAccessor = new IObjectFieldAccessor<UIWarehouse,Collection<RCMaintenanceTeamProxy>>(){
    				public java.util.Collection<com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy> getValue(UIWarehouse object){
    					return object.getRelatedTeams();
    				}
    				public void setValue(UIWarehouse object,java.util.Collection<com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy> value){
    					object.setRelatedTeams(value);
    				}
    			};
  
  public RCWarehouseProxy toProxy() {
    return (RCWarehouseProxy)super.toProxy();
    
  }
}
