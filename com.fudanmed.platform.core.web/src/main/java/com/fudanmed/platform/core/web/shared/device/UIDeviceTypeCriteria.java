package com.fudanmed.platform.core.web.shared.device;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;

public class UIDeviceTypeCriteria implements IsSerializable, IPagedCriteria {
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  public final static String P_Name = "name";
  
  public static IObjectFieldAccessor<UIDeviceTypeCriteria,String> NameAccessor = new IObjectFieldAccessor<UIDeviceTypeCriteria,String>(){
    				public String getValue(UIDeviceTypeCriteria object){
    					return object.getName();
    				}
    				public void setValue(UIDeviceTypeCriteria object,String value){
    					object.setName(value);
    				}
    			};
  
  private String category;
  
  public String getCategory() {
    return this.category;
  }
  
  public void setCategory(final String category) {
    this.category = category;
  }
  
  public final static String P_Category = "category";
  
  public static IObjectFieldAccessor<UIDeviceTypeCriteria,String> CategoryAccessor = new IObjectFieldAccessor<UIDeviceTypeCriteria,String>(){
    				public String getValue(UIDeviceTypeCriteria object){
    					return object.getCategory();
    				}
    				public void setValue(UIDeviceTypeCriteria object,String value){
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
