package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckCategory;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface DeliverPatientCheckCategoryListPresenterServiceAsync {
  public abstract void loadDeliverPatientCheckCategoryList(final AsyncCallback<Collection<UIDeliverPatientCheckCategory>> callback);
}
