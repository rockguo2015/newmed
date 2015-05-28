package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateInStockRecordView;
import com.fudanmed.platform.core.web.shared.warehouse.CreateOrUpdateInStockRecordInitData;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@ImplementedBy(value = CreateOrUpdateInStockRecordView.class)
public interface CreateOrUpdateInStockRecordPresenterView extends ViewerWithValidation {
  public abstract UIInStockRecord getValue();
  
  public abstract void setValue(final UIInStockRecord value);
  
  public abstract void setDefaultValues(final CreateOrUpdateInStockRecordInitData initData);
  
  public abstract void setSourceWarehouseContext(final RCEmployeeProxy employee, final Procedure1<? super Void> notifier);
  
  public abstract void productSidEntered(final RequestHandler1<String> requestHandler);
  
  public abstract void setProductSpecification(final UIProductSpecification productSpec);
}
