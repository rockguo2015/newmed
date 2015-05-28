package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.client.organization.CreateOrUpdateSupplierView;
import com.fudanmed.platform.core.web.shared.organization.UISupplier;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.FormViewer;

@ImplementedBy(value = CreateOrUpdateSupplierView.class)
public interface CreateOrUpdateSupplierPresenterView extends FormViewer<UISupplier> {
}
