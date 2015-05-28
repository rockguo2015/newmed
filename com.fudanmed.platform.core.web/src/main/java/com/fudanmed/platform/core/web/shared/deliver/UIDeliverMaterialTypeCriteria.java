package com.fudanmed.platform.core.web.shared.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;

public class UIDeliverMaterialTypeCriteria implements IsSerializable, IPagedCriteria {
  private String info;
  
  public String getInfo() {
    return this.info;
  }
  
  public void setInfo(final String info) {
    this.info = info;
  }
  
  public final static String P_Info = "info";
  
  public static IObjectFieldAccessor<UIDeliverMaterialTypeCriteria,String> InfoAccessor = new IObjectFieldAccessor<UIDeliverMaterialTypeCriteria,String>(){
    				public String getValue(UIDeliverMaterialTypeCriteria object){
    					return object.getInfo();
    				}
    				public void setValue(UIDeliverMaterialTypeCriteria object,String value){
    					object.setInfo(value);
    				}
    			};
  
  private DLDeliverMaterialCategoryProxy category;
  
  public DLDeliverMaterialCategoryProxy getCategory() {
    return this.category;
  }
  
  public void setCategory(final DLDeliverMaterialCategoryProxy category) {
    this.category = category;
  }
  
  public final static String P_Category = "category";
  
  public static IObjectFieldAccessor<UIDeliverMaterialTypeCriteria,DLDeliverMaterialCategoryProxy> CategoryAccessor = new IObjectFieldAccessor<UIDeliverMaterialTypeCriteria,DLDeliverMaterialCategoryProxy>(){
    				public com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy getValue(UIDeliverMaterialTypeCriteria object){
    					return object.getCategory();
    				}
    				public void setValue(UIDeliverMaterialTypeCriteria object,com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy value){
    					object.setCategory(value);
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
