package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIWorker extends GWTEntity {
  private String cardNumber;
  
  public String getCardNumber() {
    return this.cardNumber;
  }
  
  public void setCardNumber(final String cardNumber) {
    this.cardNumber = cardNumber;
  }
  
  public final static String P_CardNumber = "cardNumber";
  
  public static IObjectFieldAccessor<UIWorker,String> CardNumberAccessor = new IObjectFieldAccessor<UIWorker,String>(){
    				public String getValue(UIWorker object){
    					return object.getCardNumber();
    				}
    				public void setValue(UIWorker object,String value){
    					object.setCardNumber(value);
    				}
    			};
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  public final static String P_Name = "name";
  
  public static IObjectFieldAccessor<UIWorker,String> NameAccessor = new IObjectFieldAccessor<UIWorker,String>(){
    				public String getValue(UIWorker object){
    					return object.getName();
    				}
    				public void setValue(UIWorker object,String value){
    					object.setName(value);
    				}
    			};
  
  private Boolean isBusy;
  
  public Boolean getIsBusy() {
    return this.isBusy;
  }
  
  public void setIsBusy(final Boolean isBusy) {
    this.isBusy = isBusy;
  }
  
  public final static String P_IsBusy = "isBusy";
  
  public static IObjectFieldAccessor<UIWorker,Boolean> IsBusyAccessor = new IObjectFieldAccessor<UIWorker,Boolean>(){
    				public Boolean getValue(UIWorker object){
    					return object.getIsBusy();
    				}
    				public void setValue(UIWorker object,Boolean value){
    					object.setIsBusy(value);
    				}
    			};
  
  public RCEmployeeProxy toProxy() {
    return (RCEmployeeProxy)super.toProxy();
    
  }
}
