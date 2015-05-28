package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.fudanmed.platform.core.web.client.device.AttributeSlotEditView;
import com.fudanmed.platform.core.web.client.device.AttributeSlotTreeListPresenter;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;

@ImplementedBy(value = AttributeSlotEditView.class)
public interface AttributeSlotEditPresenterView extends Viewer {
  public abstract void newParameterRequest(final RequestHandler1<RCAttributeSlotProxy> requestHandler);
  
  public abstract void newCategoryRequest(final RequestHandler1<RCAttributeSlotProxy> requestHandler);
  
  public abstract void deleteAttributeRequest(final RequestHandler1<RCAttributeSlotProxy> requestHandler);
  
  public abstract void setAttributeSlotTreeListPresenter(final AttributeSlotTreeListPresenter attributeSlotTreeListPresenter);
}
