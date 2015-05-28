package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIRepairTaskStatByOrganizationTypeCriteriaData implements IsSerializable {
  private Long cnt;
  
  public Long getCnt() {
    return this.cnt;
  }
  
  public void setCnt(final Long cnt) {
    this.cnt = cnt;
  }
  
  public final static String P_Cnt = "cnt";
  
  public static IObjectFieldAccessor<UIRepairTaskStatByOrganizationTypeCriteriaData,Long> CntAccessor = new IObjectFieldAccessor<UIRepairTaskStatByOrganizationTypeCriteriaData,Long>(){
    				public Long getValue(UIRepairTaskStatByOrganizationTypeCriteriaData object){
    					return object.getCnt();
    				}
    				public void setValue(UIRepairTaskStatByOrganizationTypeCriteriaData object,Long value){
    					object.setCnt(value);
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
  
  public static IObjectFieldAccessor<UIRepairTaskStatByOrganizationTypeCriteriaData,RCOrganizationProxy> ReportOrgAccessor = new IObjectFieldAccessor<UIRepairTaskStatByOrganizationTypeCriteriaData,RCOrganizationProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy getValue(UIRepairTaskStatByOrganizationTypeCriteriaData object){
    					return object.getReportOrg();
    				}
    				public void setValue(UIRepairTaskStatByOrganizationTypeCriteriaData object,com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy value){
    					object.setReportOrg(value);
    				}
    			};
  
  private String fullPathReportOrg;
  
  public String getFullPathReportOrg() {
    return this.fullPathReportOrg;
  }
  
  public void setFullPathReportOrg(final String fullPathReportOrg) {
    this.fullPathReportOrg = fullPathReportOrg;
  }
  
  public final static String P_FullPathReportOrg = "fullPathReportOrg";
  
  public static IObjectFieldAccessor<UIRepairTaskStatByOrganizationTypeCriteriaData,String> FullPathReportOrgAccessor = new IObjectFieldAccessor<UIRepairTaskStatByOrganizationTypeCriteriaData,String>(){
    				public String getValue(UIRepairTaskStatByOrganizationTypeCriteriaData object){
    					return object.getFullPathReportOrg();
    				}
    				public void setValue(UIRepairTaskStatByOrganizationTypeCriteriaData object,String value){
    					object.setFullPathReportOrg(value);
    				}
    			};
}
