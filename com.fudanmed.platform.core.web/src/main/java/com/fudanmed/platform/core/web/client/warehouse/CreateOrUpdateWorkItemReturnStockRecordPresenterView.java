package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateWorkItemReturnStockRecordView;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemReturnStockRecord;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@ImplementedBy(value = CreateOrUpdateWorkItemReturnStockRecordView.class)
public interface CreateOrUpdateWorkItemReturnStockRecordPresenterView extends ViewerWithValidation {
  public abstract UIWorkItemReturnStockRecord getValue();
  
  public abstract void setValue(final UIWorkItemReturnStockRecord value);
  
  public abstract void setWorkItemTask(final RCWorkItemTaskProxy workItem, final RCRepairTaskProxy repairTask);
  
  public abstract void setSourceWarehouseContext(final RCEmployeeProxy employee, final Procedure1<? super Void> notifier);
}
