package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.web.client.device.PartTypeListView;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import java.util.Collection;

@ImplementedBy(value = PartTypeListView.class)
public interface PartTypeListPresenterView extends Viewer {
  public abstract void setResults(final Collection<UIProductSpecification> results);
  
  public abstract void createRequest(final RequestHandler requestHandler);
  
  public abstract void deleteRequest(final RequestHandler1<RCProductSpecificationProxy> requestHandler);
}
