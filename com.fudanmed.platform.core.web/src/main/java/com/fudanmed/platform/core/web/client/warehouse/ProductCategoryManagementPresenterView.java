package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductTypeProxy;
import com.fudanmed.platform.core.web.client.warehouse.ProductCategoryManagementView;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductCategory;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductType;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import java.util.Collection;

@ImplementedBy(value = ProductCategoryManagementView.class)
public interface ProductCategoryManagementPresenterView extends Viewer {
  public abstract void showResults(final Collection<UIProductCategory> results);
  
  public abstract void updateProductCategory(final UIProductCategory org);
  
  public abstract void deleteProductCategory(final RCProductCategoryProxy org);
  
  public abstract void addProductCategory(final UIProductCategory org);
  
  public abstract void showItems(final Collection<UIProductType> items);
  
  public abstract void setAsReadonly(final Boolean isReadonly);
  
  public abstract void typeSelected(final RequestHandler1<RCProductCategoryProxy> requestHandler);
  
  public abstract void createRequest(final RequestHandler1<RCProductCategoryProxy> requestHandler);
  
  public abstract void deleteRequest(final RequestHandler1<RCProductCategoryProxy> requestHandler);
  
  public abstract void modifyRequest(final RequestHandler1<RCProductCategoryProxy> requestHandler);
  
  public abstract void createChildRequest(final RequestHandler1<RCProductCategoryProxy> requestHandler);
  
  public abstract void modifyChildRequest(final RequestHandler1<RCProductTypeProxy> requestHandler);
  
  public abstract void deleteChildRequest(final RequestHandler1<RCProductTypeProxy> requestHandler);
  
  public abstract ActionContext<UIProductType> getActionContext();
}
