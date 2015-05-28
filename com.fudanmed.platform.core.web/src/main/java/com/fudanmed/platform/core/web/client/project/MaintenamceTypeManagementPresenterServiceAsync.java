package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy;
import com.fudanmed.platform.core.web.shared.project.UIFaultType;
import com.fudanmed.platform.core.web.shared.project.UIMaintenamceType;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface MaintenamceTypeManagementPresenterServiceAsync {
  public abstract void loadAllMaintenamceType(final AsyncCallback<Collection<UIMaintenamceType>> callback);
  
  public abstract void delete(final RCMaintenamceTypeProxy value, final AsyncCallback<Void> callback);
  
  public abstract void getValue(final RCMaintenamceTypeProxy org, final AsyncCallback<UIMaintenamceType> callback);
  
  public abstract void loadItems(final RCMaintenamceTypeProxy value, final AsyncCallback<Collection<UIFaultType>> callback);
  
  public abstract void deleteChild(final RCFaultTypeProxy child, final AsyncCallback<Void> callback);
}
