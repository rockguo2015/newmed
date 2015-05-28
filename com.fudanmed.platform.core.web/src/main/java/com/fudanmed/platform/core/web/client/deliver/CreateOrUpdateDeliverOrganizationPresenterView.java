package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverOrganizationView;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverOrganization;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.FormViewer;

@ImplementedBy(value = CreateOrUpdateDeliverOrganizationView.class)
public interface CreateOrUpdateDeliverOrganizationPresenterView extends FormViewer<UIDeliverOrganization> {
}
