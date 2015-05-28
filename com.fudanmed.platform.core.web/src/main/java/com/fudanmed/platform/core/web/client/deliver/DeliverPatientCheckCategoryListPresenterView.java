package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckCategoryListView;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckCategory;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import java.util.Collection;

@ImplementedBy(value = DeliverPatientCheckCategoryListView.class)
public interface DeliverPatientCheckCategoryListPresenterView extends Viewer {
  public abstract void setResults(final Collection<UIDeliverPatientCheckCategory> results);
  
  public abstract ActionContext<UIDeliverPatientCheckCategory> getActionContext();
  
  public abstract void clear();
}
