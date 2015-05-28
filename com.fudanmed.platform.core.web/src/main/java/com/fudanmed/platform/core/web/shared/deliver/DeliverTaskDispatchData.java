package com.fudanmed.platform.core.web.shared.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverOrganizationProxy;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Collection;

public class DeliverTaskDispatchData implements IsSerializable {
  private DLDeliverOrganizationProxy deliverOrg;
  
  public DLDeliverOrganizationProxy getDeliverOrg() {
    return this.deliverOrg;
  }
  
  public void setDeliverOrg(final DLDeliverOrganizationProxy deliverOrg) {
    this.deliverOrg = deliverOrg;
  }
  
  public final static String P_DeliverOrg = "deliverOrg";
  
  public static IObjectFieldAccessor<DeliverTaskDispatchData,DLDeliverOrganizationProxy> DeliverOrgAccessor = new IObjectFieldAccessor<DeliverTaskDispatchData,DLDeliverOrganizationProxy>(){
    				public com.fudanmed.platform.core.deliver.proxy.DLDeliverOrganizationProxy getValue(DeliverTaskDispatchData object){
    					return object.getDeliverOrg();
    				}
    				public void setValue(DeliverTaskDispatchData object,com.fudanmed.platform.core.deliver.proxy.DLDeliverOrganizationProxy value){
    					object.setDeliverOrg(value);
    				}
    			};
  
  private Collection<RCEmployeeProxy> haulier = com.google.common.collect.Lists.newArrayList();
  
  public Collection<RCEmployeeProxy> getHaulier() {
    return this.haulier;
  }
  
  public void setHaulier(final Collection<RCEmployeeProxy> haulier) {
    this.haulier = haulier;
  }
  
  public final static String P_Haulier = "haulier";
  
  public static IObjectFieldAccessor<DeliverTaskDispatchData,Collection<RCEmployeeProxy>> HaulierAccessor = new IObjectFieldAccessor<DeliverTaskDispatchData,Collection<RCEmployeeProxy>>(){
    				public java.util.Collection<com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy> getValue(DeliverTaskDispatchData object){
    					return object.getHaulier();
    				}
    				public void setValue(DeliverTaskDispatchData object,java.util.Collection<com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy> value){
    					object.setHaulier(value);
    				}
    			};
}
