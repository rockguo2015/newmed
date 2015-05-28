package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateStockTakingListView;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingList;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@ImplementedBy(value = CreateOrUpdateStockTakingListView.class)
public interface CreateOrUpdateStockTakingListPresenterView extends ViewerWithValidation {
  public abstract UIStockTakingList getValue();
  
  public abstract void setValue(final UIStockTakingList value);
  
  public abstract void setSourceWarehouseContext(final RCEmployeeProxy employee, final Procedure1<? super Void> notifier);
}
