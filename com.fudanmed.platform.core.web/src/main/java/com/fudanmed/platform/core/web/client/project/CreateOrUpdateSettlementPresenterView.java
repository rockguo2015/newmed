package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.CreateOrUpdateSettlementView;
import com.fudanmed.platform.core.web.shared.project.UISettlement;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = CreateOrUpdateSettlementView.class)
public interface CreateOrUpdateSettlementPresenterView extends ViewerWithValidation {
  public abstract UISettlement getValue();
  
  public abstract void setValue(final UISettlement value);
}
