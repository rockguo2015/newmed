package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductTypeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;
import java.util.Collection;

public class UIProductWarehouseStorageSummaryCriteria implements IsSerializable, IPagedCriteria {
  private RCWarehouseProxy store;
  
  public RCWarehouseProxy getStore() {
    return this.store;
  }
  
  public void setStore(final RCWarehouseProxy store) {
    this.store = store;
  }
  
  public final static String P_Store = "store";
  
  public static IObjectFieldAccessor<UIProductWarehouseStorageSummaryCriteria,RCWarehouseProxy> StoreAccessor = new IObjectFieldAccessor<UIProductWarehouseStorageSummaryCriteria,RCWarehouseProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy getValue(UIProductWarehouseStorageSummaryCriteria object){
    					return object.getStore();
    				}
    				public void setValue(UIProductWarehouseStorageSummaryCriteria object,com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy value){
    					object.setStore(value);
    				}
    			};
  
  private RCProductTypeProxy productType;
  
  public RCProductTypeProxy getProductType() {
    return this.productType;
  }
  
  public void setProductType(final RCProductTypeProxy productType) {
    this.productType = productType;
  }
  
  public final static String P_ProductType = "productType";
  
  public static IObjectFieldAccessor<UIProductWarehouseStorageSummaryCriteria,RCProductTypeProxy> ProductTypeAccessor = new IObjectFieldAccessor<UIProductWarehouseStorageSummaryCriteria,RCProductTypeProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProductTypeProxy getValue(UIProductWarehouseStorageSummaryCriteria object){
    					return object.getProductType();
    				}
    				public void setValue(UIProductWarehouseStorageSummaryCriteria object,com.fudanmed.platform.core.warehouse.proxy.RCProductTypeProxy value){
    					object.setProductType(value);
    				}
    			};
  
  private Collection<?> stores;
  
  public Collection<?> getStores() {
    return this.stores;
  }
  
  public void setStores(final Collection<?> stores) {
    this.stores = stores;
  }
  
  public final static String P_Stores = "stores";
  
  public static IObjectFieldAccessor<UIProductWarehouseStorageSummaryCriteria,Collection<?>> StoresAccessor = new IObjectFieldAccessor<UIProductWarehouseStorageSummaryCriteria,Collection<?>>(){
    				public java.util.Collection<?> getValue(UIProductWarehouseStorageSummaryCriteria object){
    					return object.getStores();
    				}
    				public void setValue(UIProductWarehouseStorageSummaryCriteria object,java.util.Collection<?> value){
    					object.setStores(value);
    				}
    			};
  
  private UIProductSpecification productSpec;
  
  public UIProductSpecification getProductSpec() {
    return this.productSpec;
  }
  
  public void setProductSpec(final UIProductSpecification productSpec) {
    this.productSpec = productSpec;
  }
  
  public final static String P_ProductSpec = "productSpec";
  
  public static IObjectFieldAccessor<UIProductWarehouseStorageSummaryCriteria,UIProductSpecification> ProductSpecAccessor = new IObjectFieldAccessor<UIProductWarehouseStorageSummaryCriteria,UIProductSpecification>(){
    				public com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification getValue(UIProductWarehouseStorageSummaryCriteria object){
    					return object.getProductSpec();
    				}
    				public void setValue(UIProductWarehouseStorageSummaryCriteria object,com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification value){
    					object.setProductSpec(value);
    				}
    			};
  
  private Integer page;
  
  public Integer getPage() {
    return this.page;
  }
  
  public void setPage(final Integer page) {
    this.page = page;
  }
  
  private Integer pageSize;
  
  public Integer getPageSize() {
    return this.pageSize;
  }
  
  public void setPageSize(final Integer pageSize) {
    this.pageSize = pageSize;
  }
}
