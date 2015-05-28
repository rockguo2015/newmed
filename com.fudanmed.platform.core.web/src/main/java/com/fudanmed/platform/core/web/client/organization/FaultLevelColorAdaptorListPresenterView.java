package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.common.proxy.RCFaultLevelColorAdaptorProxy;
import com.fudanmed.platform.core.web.client.organization.FaultLevelColorAdaptorListView;
import com.fudanmed.platform.core.web.shared.organization.UIFaultLevelColorAdaptor;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import java.util.Collection;

@ImplementedBy(value = FaultLevelColorAdaptorListView.class)
public interface FaultLevelColorAdaptorListPresenterView extends Viewer {
  public abstract void setResults(final Collection<UIFaultLevelColorAdaptor> results);
  
  public abstract void updateRequest(final RequestHandler1<RCFaultLevelColorAdaptorProxy> requestHandler);
}
