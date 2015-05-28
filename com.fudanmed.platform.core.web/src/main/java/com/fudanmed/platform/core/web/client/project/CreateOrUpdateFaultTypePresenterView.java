package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateFaultTypeView;
import com.fudanmed.platform.core.web.shared.project.UIFaultType;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = CreateOrUpdateFaultTypeView.class)
public interface CreateOrUpdateFaultTypePresenterView extends ViewerWithValidation {
  public abstract UIFaultType getValue();
  
  public abstract void setParent(final RCMaintenamceTypeProxy parent);
  
  public abstract void setValue(final UIFaultType value);
  
  public abstract void setDefaultValues();
}
