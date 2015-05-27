package com.lanmon.business.shared.message;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.lanmon.business.shared.message.TriggerType;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class TriggerTypeSelecter implements IsSerializable {
  private TriggerType type;
  
  public TriggerType getType() {
    return this.type;
  }
  
  public void setType(final TriggerType type) {
    this.type = type;
  }
  
  public final static String P_Type = "type";
  
  public static IObjectFieldAccessor<TriggerTypeSelecter,TriggerType> TypeAccessor = new IObjectFieldAccessor<TriggerTypeSelecter,TriggerType>(){
    				public TriggerType getValue(TriggerTypeSelecter object){
    					return object.getType();
    				}
    				public void setValue(TriggerTypeSelecter object,TriggerType value){
    					object.setType(value);
    				}
    			};
}
