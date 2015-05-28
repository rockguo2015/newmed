package com.fudanmed.platform.core.web.shared.device;

import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIPartTypeSelectData implements IsSerializable {
  private UIProductSpecification productSpec;
  
  public UIProductSpecification getProductSpec() {
    return this.productSpec;
  }
  
  public void setProductSpec(final UIProductSpecification productSpec) {
    this.productSpec = productSpec;
  }
  
  public final static String P_ProductSpec = "productSpec";
  
  public static IObjectFieldAccessor<UIPartTypeSelectData,UIProductSpecification> ProductSpecAccessor = new IObjectFieldAccessor<UIPartTypeSelectData,UIProductSpecification>(){
    				public com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification getValue(UIPartTypeSelectData object){
    					return object.getProductSpec();
    				}
    				public void setValue(UIPartTypeSelectData object,com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification value){
    					object.setProductSpec(value);
    				}
    			};
}
