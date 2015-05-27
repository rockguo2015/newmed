package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCStockTakingList;
import com.fudanmed.platform.core.warehouse.impl.RCStockTakingItemImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingItemProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;

@EntityImplementation(implementBy = RCStockTakingItemImpl.class)
public interface RCStockTakingItem extends IModelObject {
  public abstract RCStockTakingList getTakingList();
  
  public abstract RCStockTakingItem setTakingList(final RCStockTakingList takingList);
  
  public abstract RCProductSpecification getProductSpec();
  
  public abstract RCStockTakingItem setProductSpec(final RCProductSpecification productSpec);
  
  public abstract Integer getQuantity();
  
  public abstract RCStockTakingItem setQuantity(final Integer quantity);
  
  public abstract Integer getRealQuantity();
  
  public abstract RCStockTakingItem setRealQuantity(final Integer realQuantity);
  
  public abstract String getComment();
  
  public abstract RCStockTakingItem setComment(final String comment);
  
  public abstract RCStockTakingItemProxy toProxy();
}
