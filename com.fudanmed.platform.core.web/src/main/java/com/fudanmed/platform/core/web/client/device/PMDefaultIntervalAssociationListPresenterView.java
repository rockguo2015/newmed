package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.device.PMDefaultIntervalAssociationListView;
import com.fudanmed.platform.core.web.shared.device.UIPMDefaultIntervalAssociation;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import java.util.Collection;

@ImplementedBy(value = PMDefaultIntervalAssociationListView.class)
public interface PMDefaultIntervalAssociationListPresenterView extends Viewer {
  public abstract void setResults(final Collection<UIPMDefaultIntervalAssociation> results);
  
  public abstract void setPMSpecRequest(final RequestHandler requestHandler);
  
  public abstract void setActionContext(final ActionContext<RCDeviceTypeProxy> dac);
  
  public abstract void clear();
}
