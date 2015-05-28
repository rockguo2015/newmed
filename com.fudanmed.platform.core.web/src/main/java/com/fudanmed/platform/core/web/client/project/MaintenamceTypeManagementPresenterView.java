package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy;
import com.fudanmed.platform.core.web.client.project.MaintenamceTypeManagementView;
import com.fudanmed.platform.core.web.shared.project.UIFaultType;
import com.fudanmed.platform.core.web.shared.project.UIMaintenamceType;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import java.util.Collection;

@ImplementedBy(value = MaintenamceTypeManagementView.class)
public interface MaintenamceTypeManagementPresenterView extends Viewer {
  public abstract void showResults(final Collection<UIMaintenamceType> results);
  
  public abstract void updateMaintenamceType(final UIMaintenamceType org);
  
  public abstract void deleteMaintenamceType(final RCMaintenamceTypeProxy org);
  
  public abstract void addMaintenamceType(final UIMaintenamceType org);
  
  public abstract void showItems(final Collection<UIFaultType> items);
  
  public abstract void setAsReadonly(final Boolean isReadonly);
  
  public abstract void setAsSelector();
  
  public abstract void typeSelected(final RequestHandler1<RCMaintenamceTypeProxy> requestHandler);
  
  public abstract void createRequest(final RequestHandler1<RCMaintenamceTypeProxy> requestHandler);
  
  public abstract void deleteRequest(final RequestHandler1<RCMaintenamceTypeProxy> requestHandler);
  
  public abstract void modifyRequest(final RequestHandler1<RCMaintenamceTypeProxy> requestHandler);
  
  public abstract void createChildRequest(final RequestHandler1<RCMaintenamceTypeProxy> requestHandler);
  
  public abstract void modifyChildRequest(final RequestHandler1<RCFaultTypeProxy> requestHandler);
  
  public abstract void deleteChildRequest(final RequestHandler1<RCFaultTypeProxy> requestHandler);
  
  public abstract ActionContext<UIFaultType> getActionContext();
}
