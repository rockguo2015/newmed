package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.shared.project.UIComplaint;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface ComplaintListPresenterServiceAsync {
  public abstract void loadComplaintList(final RCRepairTaskProxy context, final AsyncCallback<Collection<UIComplaint>> callback);
}
