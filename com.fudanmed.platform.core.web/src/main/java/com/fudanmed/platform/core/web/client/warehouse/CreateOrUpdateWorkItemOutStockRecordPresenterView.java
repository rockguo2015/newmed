package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateWorkItemOutStockRecordView;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemOutStockRecord;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler2;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@ImplementedBy(value = CreateOrUpdateWorkItemOutStockRecordView.class)
public interface CreateOrUpdateWorkItemOutStockRecordPresenterView extends ViewerWithValidation {
  public abstract UIWorkItemOutStockRecord getValue();
  
  public abstract void setValue(final UIWorkItemOutStockRecord value);
  
  public abstract void setWorkItemTask(final RCWorkItemTaskProxy workItem, final RCRepairTaskProxy repairTask);
  
  public abstract void setSourceWarehouseContext(final RCEmployeeProxy employee, final Procedure1<? super Void> notifier);
  
  public abstract void productSidEntered(final RequestHandler2<String,RCWarehouseProxy> requestHandler);
  
  public abstract void setProductSummary(final UIProductWarehouseStorageSummary productSummary);
}
