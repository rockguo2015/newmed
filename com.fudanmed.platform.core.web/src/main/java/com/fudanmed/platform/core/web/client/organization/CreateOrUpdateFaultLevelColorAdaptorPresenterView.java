package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.client.organization.CreateOrUpdateFaultLevelColorAdaptorView;
import com.fudanmed.platform.core.web.shared.organization.UIFaultLevelColorAdaptor;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.FormViewer;

@ImplementedBy(value = CreateOrUpdateFaultLevelColorAdaptorView.class)
public interface CreateOrUpdateFaultLevelColorAdaptorPresenterView extends FormViewer<UIFaultLevelColorAdaptor> {
}
