package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.client.organization.OnsiteLocationOutlinePresenter;
import com.fudanmed.platform.core.web.client.organization.OnsitePositionManagementView;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;

@ImplementedBy(value = OnsitePositionManagementView.class)
public interface OnsitePositionManagementPresenterView extends Viewer {
  public abstract void setOnsiteLocationOutlinePresenter(final OnsiteLocationOutlinePresenter onsiteLocationOutlinePresenter);
  
  public abstract void createRequest(final RequestHandler1<RCOnsitePositionProxy> requestHandler);
  
  public abstract void importRequest(final RequestHandler requestHandler);
  
  public abstract void deleteRequest(final RequestHandler1<RCOnsitePositionProxy> requestHandler);
  
  public abstract void modifyRequest(final RequestHandler1<RCOnsitePositionProxy> requestHandler);
}
