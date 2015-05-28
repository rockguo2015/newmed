package com.fudanmed.platform.core.web.shared.workbench;

import com.fudanmed.platform.core.common.proxy.RCSystemParameterProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UISystemParameter extends GWTEntity {
  private String applicationTitle;
  
  public String getApplicationTitle() {
    return this.applicationTitle;
  }
  
  public void setApplicationTitle(final String applicationTitle) {
    this.applicationTitle = applicationTitle;
  }
  
  public final static String P_ApplicationTitle = "applicationTitle";
  
  public static IObjectFieldAccessor<UISystemParameter,String> ApplicationTitleAccessor = new IObjectFieldAccessor<UISystemParameter,String>(){
    				public String getValue(UISystemParameter object){
    					return object.getApplicationTitle();
    				}
    				public void setValue(UISystemParameter object,String value){
    					object.setApplicationTitle(value);
    				}
    			};
  
  private Integer refreshInterval;
  
  public Integer getRefreshInterval() {
    return this.refreshInterval;
  }
  
  public void setRefreshInterval(final Integer refreshInterval) {
    this.refreshInterval = refreshInterval;
  }
  
  public final static String P_RefreshInterval = "refreshInterval";
  
  public static IObjectFieldAccessor<UISystemParameter,Integer> RefreshIntervalAccessor = new IObjectFieldAccessor<UISystemParameter,Integer>(){
    				public Integer getValue(UISystemParameter object){
    					return object.getRefreshInterval();
    				}
    				public void setValue(UISystemParameter object,Integer value){
    					object.setRefreshInterval(value);
    				}
    			};
  
  private Integer customerEvalCommitInterval;
  
  public Integer getCustomerEvalCommitInterval() {
    return this.customerEvalCommitInterval;
  }
  
  public void setCustomerEvalCommitInterval(final Integer customerEvalCommitInterval) {
    this.customerEvalCommitInterval = customerEvalCommitInterval;
  }
  
  public final static String P_CustomerEvalCommitInterval = "customerEvalCommitInterval";
  
  public static IObjectFieldAccessor<UISystemParameter,Integer> CustomerEvalCommitIntervalAccessor = new IObjectFieldAccessor<UISystemParameter,Integer>(){
    				public Integer getValue(UISystemParameter object){
    					return object.getCustomerEvalCommitInterval();
    				}
    				public void setValue(UISystemParameter object,Integer value){
    					object.setCustomerEvalCommitInterval(value);
    				}
    			};
  
  private Integer eboardRefreshInterval;
  
  public Integer getEboardRefreshInterval() {
    return this.eboardRefreshInterval;
  }
  
  public void setEboardRefreshInterval(final Integer eboardRefreshInterval) {
    this.eboardRefreshInterval = eboardRefreshInterval;
  }
  
  public final static String P_EboardRefreshInterval = "eboardRefreshInterval";
  
  public static IObjectFieldAccessor<UISystemParameter,Integer> EboardRefreshIntervalAccessor = new IObjectFieldAccessor<UISystemParameter,Integer>(){
    				public Integer getValue(UISystemParameter object){
    					return object.getEboardRefreshInterval();
    				}
    				public void setValue(UISystemParameter object,Integer value){
    					object.setEboardRefreshInterval(value);
    				}
    			};
  
  private String orgName;
  
  public String getOrgName() {
    return this.orgName;
  }
  
  public void setOrgName(final String orgName) {
    this.orgName = orgName;
  }
  
  public final static String P_OrgName = "orgName";
  
  public static IObjectFieldAccessor<UISystemParameter,String> OrgNameAccessor = new IObjectFieldAccessor<UISystemParameter,String>(){
    				public String getValue(UISystemParameter object){
    					return object.getOrgName();
    				}
    				public void setValue(UISystemParameter object,String value){
    					object.setOrgName(value);
    				}
    			};
  
  public RCSystemParameterProxy toProxy() {
    return (RCSystemParameterProxy)super.toProxy();
    
  }
}
