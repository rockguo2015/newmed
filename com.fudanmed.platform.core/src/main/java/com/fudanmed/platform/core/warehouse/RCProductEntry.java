package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCInStockRecord;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.impl.RCProductEntryImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCProductEntryProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.INamedModelObject;

@EntityImplementation(implementBy = RCProductEntryImpl.class)
public interface RCProductEntry extends IModelObject, INamedModelObject {
  public abstract String getSid();
  
  public abstract RCProductEntry setSid(final String sid);
  
  public abstract RCProductSpecification getProductSpec();
  
  public abstract RCProductEntry setProductSpec(final RCProductSpecification productSpec);
  
  public abstract RCInStockRecord getInStockRecord();
  
  public abstract RCProductEntry setInStockRecord(final RCInStockRecord inStockRecord);
  
  public abstract Double getPrice();
  
  public abstract RCProductEntry setPrice(final Double price);
  
  public abstract Integer getQuantity();
  
  public abstract RCProductEntry setQuantity(final Integer quantity);
  
  public abstract String getEntityName();
  
  public abstract RCProductEntryProxy toProxy();
}
