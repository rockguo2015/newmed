package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.warehouse.RCProductSpecificationSummary;
import com.fudanmed.platform.core.warehouse.RCTransferRecordItem;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.impl.RCTransferRecordImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCTransferRecordProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Collection;
import java.util.Date;

@EntityImplementation(implementBy = RCTransferRecordImpl.class)
public interface RCTransferRecord extends IModelObject {
  public abstract String getSid();
  
  public abstract RCTransferRecord setSid(final String sid);
  
  public abstract RCEmployee getOperator();
  
  public abstract RCTransferRecord setOperator(final RCEmployee operator);
  
  public abstract Date getDate();
  
  public abstract RCTransferRecord setDate(final Date date);
  
  public abstract String getComment();
  
  public abstract RCTransferRecord setComment(final String comment);
  
  public abstract RCWarehouse getSourceStore();
  
  public abstract RCTransferRecord setSourceStore(final RCWarehouse sourceStore);
  
  public abstract RCWarehouse getTargetStore();
  
  public abstract RCTransferRecord setTargetStore(final RCWarehouse targetStore);
  
  public abstract Collection<RCTransferRecordItem> getItems();
  
  public abstract RCTransferRecordItem createAndAddtoItems();
  
  public abstract RCTransferRecord removeFromItems(final RCTransferRecordItem rCTransferRecordItem);
  
  public abstract RCTransferRecord removeAllItems();
  
  public abstract Boolean getCommitted();
  
  public abstract RCTransferRecord setCommitted(final Boolean committed);
  
  public abstract void initItemsFromSummary(final Collection<RCProductSpecificationSummary> summaryItems);
  
  public abstract void commit(final RCEmployee operator);
  
  public abstract RCTransferRecordProxy toProxy();
}
