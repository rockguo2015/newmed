package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductWarehouseStorageSummaryProxy;
import com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationDetailPresenter;
import com.fudanmed.platform.core.web.client.warehouse.ProductStoreTransactionListPresenter;
import com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStorageListPresenter;
import com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStorageSummaryManagementView;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummaryCriteria;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@ImplementedBy(value = ProductWarehouseStorageSummaryManagementView.class)
public interface ProductWarehouseStorageSummaryManagementPresenterView extends Viewer {
  public abstract void showResults(final IPagedResult<UIProductWarehouseStorageSummary> results);
  
  public abstract void refresh();
  
  public abstract void filterRequest(final RequestHandler1<UIProductWarehouseStorageSummaryCriteria> requestHandler);
  
  public abstract void inStockRequest(final RequestHandler requestHandler);
  
  public abstract void transferRequest(final RequestHandler requestHandler);
  
  public abstract void showStorageDetailRequest(final RequestHandler1<RCProductWarehouseStorageSummaryProxy> requestHandler);
  
  public abstract void setSourceWarehouseContext(final RCEmployeeProxy employee, final Procedure1<? super Void> notifier);
  
  public abstract void setProductStoreTransactionListPresenter(final ProductStoreTransactionListPresenter productStoreTransactionListPresenter);
  
  public abstract void setProductWarehouseStorageListPresenter(final ProductWarehouseStorageListPresenter productWarehouseStorageListPresenter);
  
  public abstract void setProductSpecificationDetailPresenter(final ProductSpecificationDetailPresenter productSpecificationDetailPresenter);
}
