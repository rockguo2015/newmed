package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCComplaintProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.shared.project.UIComplaint;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateComplaintPresenterServiceAsync {
  public abstract void loadValue(final RCComplaintProxy pvalue, final AsyncCallback<UIComplaint> callback);
  
  public abstract void updateValue(final UIComplaint uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final RCRepairTaskProxy parent, final UIComplaint uivalue, final AsyncCallback<Void> callback);
}
