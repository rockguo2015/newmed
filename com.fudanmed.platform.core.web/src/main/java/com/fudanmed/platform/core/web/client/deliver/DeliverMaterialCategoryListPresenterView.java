package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.DeliverMaterialCategoryListView;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialCategory;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import java.util.Collection;

@ImplementedBy(value = DeliverMaterialCategoryListView.class)
public interface DeliverMaterialCategoryListPresenterView extends Viewer {
  public abstract void setResults(final Collection<UIDeliverMaterialCategory> results);
  
  public abstract ActionContext<UIDeliverMaterialCategory> getActionContext();
  
  public abstract void clear();
}
