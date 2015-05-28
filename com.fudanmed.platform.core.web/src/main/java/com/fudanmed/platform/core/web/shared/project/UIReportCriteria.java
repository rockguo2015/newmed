package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;

public class UIReportCriteria implements IsSerializable, IPagedCriteria {
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public void setComment(final String comment) {
    this.comment = comment;
  }
  
  public final static String P_Comment = "comment";
  
  public static IObjectFieldAccessor<UIReportCriteria,String> CommentAccessor = new IObjectFieldAccessor<UIReportCriteria,String>(){
    				public String getValue(UIReportCriteria object){
    					return object.getComment();
    				}
    				public void setValue(UIReportCriteria object,String value){
    					object.setComment(value);
    				}
    			};
  
  private Boolean includeFinishedTask4Reporter;
  
  public Boolean getIncludeFinishedTask4Reporter() {
    return this.includeFinishedTask4Reporter;
  }
  
  public void setIncludeFinishedTask4Reporter(final Boolean includeFinishedTask4Reporter) {
    this.includeFinishedTask4Reporter = includeFinishedTask4Reporter;
  }
  
  public final static String P_IncludeFinishedTask4Reporter = "includeFinishedTask4Reporter";
  
  public static IObjectFieldAccessor<UIReportCriteria,Boolean> IncludeFinishedTask4ReporterAccessor = new IObjectFieldAccessor<UIReportCriteria,Boolean>(){
    				public Boolean getValue(UIReportCriteria object){
    					return object.getIncludeFinishedTask4Reporter();
    				}
    				public void setValue(UIReportCriteria object,Boolean value){
    					object.setIncludeFinishedTask4Reporter(value);
    				}
    			};
  
  private RCOrganizationProxy reportOrg;
  
  public RCOrganizationProxy getReportOrg() {
    return this.reportOrg;
  }
  
  public void setReportOrg(final RCOrganizationProxy reportOrg) {
    this.reportOrg = reportOrg;
  }
  
  public final static String P_ReportOrg = "reportOrg";
  
  public static IObjectFieldAccessor<UIReportCriteria,RCOrganizationProxy> ReportOrgAccessor = new IObjectFieldAccessor<UIReportCriteria,RCOrganizationProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy getValue(UIReportCriteria object){
    					return object.getReportOrg();
    				}
    				public void setValue(UIReportCriteria object,com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy value){
    					object.setReportOrg(value);
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
