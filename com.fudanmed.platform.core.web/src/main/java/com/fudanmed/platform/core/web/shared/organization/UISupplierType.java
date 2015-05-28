package com.fudanmed.platform.core.web.shared.organization;

import com.uniquesoft.gwt.shared.datatype.IUIDLEnum;

public enum UISupplierType implements IUIDLEnum<UISupplierType> {
  maintenanceProvider,

  materialSupplier;
  
  public String toString() {
    switch(this){
    case maintenanceProvider:
    	return "设备及服务提供商";
    case materialSupplier:
    	return "材料供应商";
    	default:
    		return name();
    }
  }
  
  public UISupplierType fromString(final String value) {
    if( "设备及服务提供商".equals(value))
    	return maintenanceProvider;
    if( "材料供应商".equals(value))
    	return materialSupplier;
    	return null;			
    
  }
}
