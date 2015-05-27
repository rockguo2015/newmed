package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverMaterialType;
import com.fudanmed.platform.core.deliver.DLMaterialDeliver;
import com.fudanmed.platform.core.deliver.impl.DLMaterialDeliverDetailImpl;
import com.fudanmed.platform.core.deliver.proxy.DLMaterialDeliverDetailProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;

@EntityImplementation(implementBy = DLMaterialDeliverDetailImpl.class)
public interface DLMaterialDeliverDetail extends IModelObject {
  public abstract DLDeliverMaterialType getMaterialType();
  
  public abstract DLMaterialDeliverDetail setMaterialType(final DLDeliverMaterialType materialType);
  
  public abstract Double getQuantity();
  
  public abstract DLMaterialDeliverDetail setQuantity(final Double quantity);
  
  public abstract DLMaterialDeliver getMaterialDeliver();
  
  public abstract DLMaterialDeliverDetail setMaterialDeliver(final DLMaterialDeliver materialDeliver);
  
  public abstract DLMaterialDeliverDetailProxy toProxy();
}
