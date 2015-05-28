package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.AllFaultTypeSContentProviderCriteria;
import com.fudanmed.platform.core.web.shared.project.UIFaultType;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface AllFaultTypeSContentProviderServiceAsync {
  public abstract void load(final AllFaultTypeSContentProviderCriteria criteria, final AsyncCallback<Collection<UIFaultType>> callback);
}
