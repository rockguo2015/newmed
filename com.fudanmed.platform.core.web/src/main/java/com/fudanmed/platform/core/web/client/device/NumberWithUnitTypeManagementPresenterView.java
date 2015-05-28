package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCCustomizableTypeProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCNumberWithUnitTypeProxy;
import com.fudanmed.platform.core.web.client.device.NumberWithUnitTypeManagementView;
import com.fudanmed.platform.core.web.shared.device.UICustomizableType;
import com.fudanmed.platform.core.web.shared.device.UICustomizableTypeCriteria;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

@ImplementedBy(value = NumberWithUnitTypeManagementView.class)
public interface NumberWithUnitTypeManagementPresenterView extends Viewer {
  public abstract void showResults(final IPagedResult<UICustomizableType> results);
  
  public abstract void refresh();
  
  public abstract void createRequest(final RequestHandler requestHandler);
  
  public abstract void deleteRequest(final RequestHandler1<RCCustomizableTypeProxy> requestHandler);
  
  public abstract void modifyRequest(final RequestHandler1<RCNumberWithUnitTypeProxy> requestHandler);
  
  public abstract void createRangeTypeRequest(final RequestHandler1<RCNumberWithUnitTypeProxy> requestHandler);
  
  public abstract void filterRequest(final RequestHandler1<UICustomizableTypeCriteria> requestHandler);
}
