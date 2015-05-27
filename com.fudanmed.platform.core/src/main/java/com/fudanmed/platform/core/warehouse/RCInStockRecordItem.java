package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCInStockRecord;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.impl.RCInStockRecordItemImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCInStockRecordItemProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;

@EntityImplementation(implementBy = RCInStockRecordItemImpl.class)
public interface RCInStockRecordItem extends IModelObject {
  public abstract RCInStockRecord getInStockRecord();
  
  public abstract RCInStockRecordItem setInStockRecord(final RCInStockRecord inStockRecord);
  
  public abstract String getSid();
  
  public abstract RCInStockRecordItem setSid(final String sid);
  
  public abstract RCProductSpecification getProductSpec();
  
  public abstract RCInStockRecordItem setProductSpec(final RCProductSpecification productSpec);
  
  public abstract Double getPrice();
  
  public abstract RCInStockRecordItem setPrice(final Double price);
  
  public abstract Integer getQuantity();
  
  public abstract RCInStockRecordItem setQuantity(final Integer quantity);
  
  public abstract RCInStockRecordItemProxy toProxy();
}
