package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIWorkItemTask4WorkersStatCriteriaData implements IsSerializable {
  private Long cnt;
  
  public Long getCnt() {
    return this.cnt;
  }
  
  public void setCnt(final Long cnt) {
    this.cnt = cnt;
  }
  
  public final static String P_Cnt = "cnt";
  
  public static IObjectFieldAccessor<UIWorkItemTask4WorkersStatCriteriaData,Long> CntAccessor = new IObjectFieldAccessor<UIWorkItemTask4WorkersStatCriteriaData,Long>(){
    				public Long getValue(UIWorkItemTask4WorkersStatCriteriaData object){
    					return object.getCnt();
    				}
    				public void setValue(UIWorkItemTask4WorkersStatCriteriaData object,Long value){
    					object.setCnt(value);
    				}
    			};
  
  private RCEmployeeProxy worker;
  
  public RCEmployeeProxy getWorker() {
    return this.worker;
  }
  
  public void setWorker(final RCEmployeeProxy worker) {
    this.worker = worker;
  }
  
  public final static String P_Worker = "worker";
  
  public static IObjectFieldAccessor<UIWorkItemTask4WorkersStatCriteriaData,RCEmployeeProxy> WorkerAccessor = new IObjectFieldAccessor<UIWorkItemTask4WorkersStatCriteriaData,RCEmployeeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy getValue(UIWorkItemTask4WorkersStatCriteriaData object){
    					return object.getWorker();
    				}
    				public void setValue(UIWorkItemTask4WorkersStatCriteriaData object,com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy value){
    					object.setWorker(value);
    				}
    			};
}
