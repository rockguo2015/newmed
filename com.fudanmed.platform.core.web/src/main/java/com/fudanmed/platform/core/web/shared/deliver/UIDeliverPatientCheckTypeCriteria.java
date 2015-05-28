package com.fudanmed.platform.core.web.shared.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;

public class UIDeliverPatientCheckTypeCriteria implements IsSerializable, IPagedCriteria {
  private String info;
  
  public String getInfo() {
    return this.info;
  }
  
  public void setInfo(final String info) {
    this.info = info;
  }
  
  public final static String P_Info = "info";
  
  public static IObjectFieldAccessor<UIDeliverPatientCheckTypeCriteria,String> InfoAccessor = new IObjectFieldAccessor<UIDeliverPatientCheckTypeCriteria,String>(){
    				public String getValue(UIDeliverPatientCheckTypeCriteria object){
    					return object.getInfo();
    				}
    				public void setValue(UIDeliverPatientCheckTypeCriteria object,String value){
    					object.setInfo(value);
    				}
    			};
  
  private DLDeliverPatientCheckCategoryProxy category;
  
  public DLDeliverPatientCheckCategoryProxy getCategory() {
    return this.category;
  }
  
  public void setCategory(final DLDeliverPatientCheckCategoryProxy category) {
    this.category = category;
  }
  
  public final static String P_Category = "category";
  
  public static IObjectFieldAccessor<UIDeliverPatientCheckTypeCriteria,DLDeliverPatientCheckCategoryProxy> CategoryAccessor = new IObjectFieldAccessor<UIDeliverPatientCheckTypeCriteria,DLDeliverPatientCheckCategoryProxy>(){
    				public com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy getValue(UIDeliverPatientCheckTypeCriteria object){
    					return object.getCategory();
    				}
    				public void setValue(UIDeliverPatientCheckTypeCriteria object,com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy value){
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
