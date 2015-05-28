package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationManagementView;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecificationCriteria;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

@ImplementedBy(value = ProductSpecificationManagementView.class)
public interface ProductSpecificationManagementPresenterView extends Viewer {
  public abstract void showResults(final IPagedResult<UIProductSpecification> results);
  
  public abstract void refresh();
  
  public abstract void createRequest(final RequestHandler requestHandler);
  
  public abstract void importRequest(final RequestHandler requestHandler);
  
  public abstract void deleteRequest(final RequestHandler1<RCProductSpecificationProxy> requestHandler);
  
  public abstract void modifyRequest(final RequestHandler1<RCProductSpecificationProxy> requestHandler);
  
  public abstract void filterRequest(final RequestHandler1<UIProductSpecificationCriteria> requestHandler);
}
