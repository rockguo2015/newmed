package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCSupplier;
import com.fudanmed.platform.core.warehouse.RCInStockRecordItem;
import com.fudanmed.platform.core.warehouse.RCInStoreType;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.impl.RCInStockRecordImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCInStockRecordProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Collection;
import java.util.Date;

@EntityImplementation(implementBy = RCInStockRecordImpl.class)
public interface RCInStockRecord extends IModelObject {
  public abstract String getSid();
  
  public abstract RCInStockRecord setSid(final String sid);
  
  public abstract RCEmployee getOperator();
  
  public abstract RCInStockRecord setOperator(final RCEmployee operator);
  
  public abstract Date getDate();
  
  public abstract RCInStockRecord setDate(final Date date);
  
  public abstract String getComment();
  
  public abstract RCInStockRecord setComment(final String comment);
  
  public abstract RCWarehouse getStore();
  
  public abstract RCInStockRecord setStore(final RCWarehouse store);
  
  public abstract RCSupplier getSupplier();
  
  public abstract RCInStockRecord setSupplier(final RCSupplier supplier);
  
  public abstract Collection<RCInStockRecordItem> getItems();
  
  public abstract RCInStockRecordItem createAndAddtoItems();
  
  public abstract RCInStockRecord removeFromItems(final RCInStockRecordItem rCInStockRecordItem);
  
  public abstract RCInStockRecord removeAllItems();
  
  public abstract Boolean getCommitted();
  
  public abstract RCInStockRecord setCommitted(final Boolean committed);
  
  public abstract RCInStoreType getInStoreType();
  
  public abstract RCInStockRecord setInStoreType(final RCInStoreType inStoreType);
  
  public abstract String getInvoiceNumber();
  
  public abstract RCInStockRecord setInvoiceNumber(final String invoiceNumber);
  
  public abstract String getDeliverNumber();
  
  public abstract RCInStockRecord setDeliverNumber(final String deliverNumber);
  
  public abstract void commit(final RCEmployee operator);
  
  public abstract RCInStockRecordProxy toProxy();
}
