package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateMaintenamceTypeView;
import com.fudanmed.platform.core.web.shared.project.UIMaintenamceType;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = CreateOrUpdateMaintenamceTypeView.class)
public interface CreateOrUpdateMaintenamceTypePresenterView extends ViewerWithValidation {
  public abstract UIMaintenamceType getValue();
  
  public abstract void setParent(final RCMaintenamceTypeProxy parent);
  
  public abstract void setValue(final UIMaintenamceType value);
}
