package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.impl.RCSettlementImpl;
import com.fudanmed.platform.core.domain.proxy.RCSettlementProxy;
import com.fudanmed.platform.core.warehouse.RCWorkItemStorage;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Collection;
import java.util.Date;

@EntityImplementation(implementBy = RCSettlementImpl.class)
public interface RCSettlement extends IModelObject {
  public abstract String getSid();
  
  public abstract RCSettlement setSid(final String sid);
  
  public abstract Date getDate();
  
  public abstract RCSettlement setDate(final Date date);
  
  public abstract Date getFromDate();
  
  public abstract RCSettlement setFromDate(final Date fromDate);
  
  public abstract Date getToDate();
  
  public abstract RCSettlement setToDate(final Date toDate);
  
  public abstract String getDescription();
  
  public abstract RCSettlement setDescription(final String description);
  
  public abstract Double getTotalAmount();
  
  public abstract RCSettlement setTotalAmount(final Double totalAmount);
  
  public abstract Collection<RCRepairTask> getAllItems();
  
  public abstract Collection<RCWorkItemStorage> getAllMaterialItems();
  
  public abstract void calculate();
  
  public abstract RCSettlementProxy toProxy();
}
