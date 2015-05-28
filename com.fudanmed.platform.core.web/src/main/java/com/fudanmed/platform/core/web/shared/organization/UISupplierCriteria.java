package com.fudanmed.platform.core.web.shared.organization;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;

public class UISupplierCriteria implements IsSerializable, IPagedCriteria {
  private String info;
  
  public String getInfo() {
    return this.info;
  }
  
  public void setInfo(final String info) {
    this.info = info;
  }
  
  public final static String P_Info = "info";
  
  public static IObjectFieldAccessor<UISupplierCriteria,String> InfoAccessor = new IObjectFieldAccessor<UISupplierCriteria,String>(){
    				public String getValue(UISupplierCriteria object){
    					return object.getInfo();
    				}
    				public void setValue(UISupplierCriteria object,String value){
    					object.setInfo(value);
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
