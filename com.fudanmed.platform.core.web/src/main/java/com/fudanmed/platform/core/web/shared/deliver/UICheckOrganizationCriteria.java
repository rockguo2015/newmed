package com.fudanmed.platform.core.web.shared.deliver;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;

public class UICheckOrganizationCriteria implements IsSerializable, IPagedCriteria {
  private String info;
  
  public String getInfo() {
    return this.info;
  }
  
  public void setInfo(final String info) {
    this.info = info;
  }
  
  public final static String P_Info = "info";
  
  public static IObjectFieldAccessor<UICheckOrganizationCriteria,String> InfoAccessor = new IObjectFieldAccessor<UICheckOrganizationCriteria,String>(){
    				public String getValue(UICheckOrganizationCriteria object){
    					return object.getInfo();
    				}
    				public void setValue(UICheckOrganizationCriteria object,String value){
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
