package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateTransferRecordView;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UITransferRecord;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler2;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@ImplementedBy(value = CreateOrUpdateTransferRecordView.class)
public interface CreateOrUpdateTransferRecordPresenterView extends ViewerWithValidation {
  public abstract UITransferRecord getValue();
  
  public abstract void setValue(final UITransferRecord value);
  
  public abstract void setSourceWarehouseContext(final RCEmployeeProxy employee, final Procedure1<? super Void> notifier);
  
  public abstract void productSidEntered(final RequestHandler2<String,RCWarehouseProxy> requestHandler);
  
  public abstract void setProductSummary(final UIProductWarehouseStorageSummary productSummary);
}
