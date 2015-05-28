package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.web.client.organization.SupplierManagementView;
import com.fudanmed.platform.core.web.shared.organization.UISupplier;
import com.fudanmed.platform.core.web.shared.organization.UISupplierCriteria;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

@ImplementedBy(value = SupplierManagementView.class)
public interface SupplierManagementPresenterView extends Viewer {
  public abstract void showResults(final IPagedResult<UISupplier> results);
  
  public abstract void refresh();
  
  public abstract void refreshNew(final RCSupplierProxy value);
  
  public abstract void createRequest(final RequestHandler requestHandler);
  
  public abstract void deleteRequest(final RequestHandler1<RCSupplierProxy> requestHandler);
  
  public abstract void modifyRequest(final RequestHandler1<RCSupplierProxy> requestHandler);
  
  public abstract void filterRequest(final RequestHandler1<UISupplierCriteria> requestHandler);
}
