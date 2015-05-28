package com.fudanmed.platform.core.web.shared.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;

public class UIEmployeeCriteria implements IsSerializable, IPagedCriteria {
  private String info;
  
  public String getInfo() {
    return this.info;
  }
  
  public void setInfo(final String info) {
    this.info = info;
  }
  
  public final static String P_Info = "info";
  
  public static IObjectFieldAccessor<UIEmployeeCriteria,String> InfoAccessor = new IObjectFieldAccessor<UIEmployeeCriteria,String>(){
    				public String getValue(UIEmployeeCriteria object){
    					return object.getInfo();
    				}
    				public void setValue(UIEmployeeCriteria object,String value){
    					object.setInfo(value);
    				}
    			};
  
  private String orgPath;
  
  public String getOrgPath() {
    return this.orgPath;
  }
  
  public void setOrgPath(final String orgPath) {
    this.orgPath = orgPath;
  }
  
  public final static String P_OrgPath = "orgPath";
  
  public static IObjectFieldAccessor<UIEmployeeCriteria,String> OrgPathAccessor = new IObjectFieldAccessor<UIEmployeeCriteria,String>(){
    				public String getValue(UIEmployeeCriteria object){
    					return object.getOrgPath();
    				}
    				public void setValue(UIEmployeeCriteria object,String value){
    					object.setOrgPath(value);
    				}
    			};
  
  private RCOrganizationProxy organization;
  
  public RCOrganizationProxy getOrganization() {
    return this.organization;
  }
  
  public void setOrganization(final RCOrganizationProxy organization) {
    this.organization = organization;
  }
  
  public final static String P_Organization = "organization";
  
  public static IObjectFieldAccessor<UIEmployeeCriteria,RCOrganizationProxy> OrganizationAccessor = new IObjectFieldAccessor<UIEmployeeCriteria,RCOrganizationProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy getValue(UIEmployeeCriteria object){
    					return object.getOrganization();
    				}
    				public void setValue(UIEmployeeCriteria object,com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy value){
    					object.setOrganization(value);
    				}
    			};
  
  private Boolean includeLeaveEmployees;
  
  public Boolean getIncludeLeaveEmployees() {
    return this.includeLeaveEmployees;
  }
  
  public void setIncludeLeaveEmployees(final Boolean includeLeaveEmployees) {
    this.includeLeaveEmployees = includeLeaveEmployees;
  }
  
  public final static String P_IncludeLeaveEmployees = "includeLeaveEmployees";
  
  public static IObjectFieldAccessor<UIEmployeeCriteria,Boolean> IncludeLeaveEmployeesAccessor = new IObjectFieldAccessor<UIEmployeeCriteria,Boolean>(){
    				public Boolean getValue(UIEmployeeCriteria object){
    					return object.getIncludeLeaveEmployees();
    				}
    				public void setValue(UIEmployeeCriteria object,Boolean value){
    					object.setIncludeLeaveEmployees(value);
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
