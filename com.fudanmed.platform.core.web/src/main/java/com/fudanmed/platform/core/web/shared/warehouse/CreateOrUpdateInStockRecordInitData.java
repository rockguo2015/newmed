package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class CreateOrUpdateInStockRecordInitData implements IsSerializable {
  private RCWarehouseProxy store;
  
  public RCWarehouseProxy getStore() {
    return this.store;
  }
  
  public void setStore(final RCWarehouseProxy store) {
    this.store = store;
  }
  
  public final static String P_Store = "store";
  
  public static IObjectFieldAccessor<CreateOrUpdateInStockRecordInitData,RCWarehouseProxy> StoreAccessor = new IObjectFieldAccessor<CreateOrUpdateInStockRecordInitData,RCWarehouseProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy getValue(CreateOrUpdateInStockRecordInitData object){
    					return object.getStore();
    				}
    				public void setValue(CreateOrUpdateInStockRecordInitData object,com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy value){
    					object.setStore(value);
    				}
    			};
  
  private RCEmployeeProxy storeManager;
  
  public RCEmployeeProxy getStoreManager() {
    return this.storeManager;
  }
  
  public void setStoreManager(final RCEmployeeProxy storeManager) {
    this.storeManager = storeManager;
  }
  
  public final static String P_StoreManager = "storeManager";
  
  public static IObjectFieldAccessor<CreateOrUpdateInStockRecordInitData,RCEmployeeProxy> StoreManagerAccessor = new IObjectFieldAccessor<CreateOrUpdateInStockRecordInitData,RCEmployeeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy getValue(CreateOrUpdateInStockRecordInitData object){
    					return object.getStoreManager();
    				}
    				public void setValue(CreateOrUpdateInStockRecordInitData object,com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy value){
    					object.setStoreManager(value);
    				}
    			};
  
  private RCEmployeeProxy currentUser;
  
  public RCEmployeeProxy getCurrentUser() {
    return this.currentUser;
  }
  
  public void setCurrentUser(final RCEmployeeProxy currentUser) {
    this.currentUser = currentUser;
  }
  
  public final static String P_CurrentUser = "currentUser";
  
  public static IObjectFieldAccessor<CreateOrUpdateInStockRecordInitData,RCEmployeeProxy> CurrentUserAccessor = new IObjectFieldAccessor<CreateOrUpdateInStockRecordInitData,RCEmployeeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy getValue(CreateOrUpdateInStockRecordInitData object){
    					return object.getCurrentUser();
    				}
    				public void setValue(CreateOrUpdateInStockRecordInitData object,com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy value){
    					object.setCurrentUser(value);
    				}
    			};
}
