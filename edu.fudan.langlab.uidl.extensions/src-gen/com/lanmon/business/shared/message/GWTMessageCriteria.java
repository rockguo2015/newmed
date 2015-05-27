package com.lanmon.business.shared.message;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;
import com.uniquesoft.gwt.shared.datatype.DateRange;

public class GWTMessageCriteria implements IsSerializable, IPagedCriteria {
  private String title;
  
  public String getTitle() {
    return this.title;
  }
  
  public void setTitle(final String title) {
    this.title = title;
  }
  
  public final static String P_Title = "title";
  
  public static IObjectFieldAccessor<GWTMessageCriteria,String> TitleAccessor = new IObjectFieldAccessor<GWTMessageCriteria,String>(){
    				public String getValue(GWTMessageCriteria object){
    					return object.getTitle();
    				}
    				public void setValue(GWTMessageCriteria object,String value){
    					object.setTitle(value);
    				}
    			};
  
  private DateRange triggerDate;
  
  public DateRange getTriggerDate() {
    return this.triggerDate;
  }
  
  public void setTriggerDate(final DateRange triggerDate) {
    this.triggerDate = triggerDate;
  }
  
  public final static String P_TriggerDate = "triggerDate";
  
  public static IObjectFieldAccessor<GWTMessageCriteria,DateRange> TriggerDateAccessor = new IObjectFieldAccessor<GWTMessageCriteria,DateRange>(){
    				public DateRange getValue(GWTMessageCriteria object){
    					return object.getTriggerDate();
    				}
    				public void setValue(GWTMessageCriteria object,DateRange value){
    					object.setTriggerDate(value);
    				}
    			};
  
  private GWTNamedEntity customer;
  
  public GWTNamedEntity getCustomer() {
    return this.customer;
  }
  
  public void setCustomer(final GWTNamedEntity customer) {
    this.customer = customer;
  }
  
  public final static String P_Customer = "customer";
  
  public static IObjectFieldAccessor<GWTMessageCriteria,GWTNamedEntity> CustomerAccessor = new IObjectFieldAccessor<GWTMessageCriteria,GWTNamedEntity>(){
    				public GWTNamedEntity getValue(GWTMessageCriteria object){
    					return object.getCustomer();
    				}
    				public void setValue(GWTMessageCriteria object,GWTNamedEntity value){
    					object.setCustomer(value);
    				}
    			};
  
  private Integer page;
  
  public Integer getPage() {
    return this.page;
  }
  
  public void setPage(final Integer page) {
    this.page = page;
  }
  
  public final static String P_Page = "page";
  
  public static IObjectFieldAccessor<GWTMessageCriteria,Integer> PageAccessor = new IObjectFieldAccessor<GWTMessageCriteria,Integer>(){
    				public Integer getValue(GWTMessageCriteria object){
    					return object.getPage();
    				}
    				public void setValue(GWTMessageCriteria object,Integer value){
    					object.setPage(value);
    				}
    			};
  
  private Integer pageSize;
  
  public Integer getPageSize() {
    return this.pageSize;
  }
  
  public void setPageSize(final Integer pageSize) {
    this.pageSize = pageSize;
  }
  
  public final static String P_PageSize = "pageSize";
  
  public static IObjectFieldAccessor<GWTMessageCriteria,Integer> PageSizeAccessor = new IObjectFieldAccessor<GWTMessageCriteria,Integer>(){
    				public Integer getValue(GWTMessageCriteria object){
    					return object.getPageSize();
    				}
    				public void setValue(GWTMessageCriteria object,Integer value){
    					object.setPageSize(value);
    				}
    			};
}
