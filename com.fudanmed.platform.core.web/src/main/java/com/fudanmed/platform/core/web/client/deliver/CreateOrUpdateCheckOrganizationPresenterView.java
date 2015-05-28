package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateCheckOrganizationView;
import com.fudanmed.platform.core.web.shared.deliver.UICheckOrganization;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.FormViewer;

@ImplementedBy(value = CreateOrUpdateCheckOrganizationView.class)
public interface CreateOrUpdateCheckOrganizationPresenterView extends FormViewer<UICheckOrganization> {
}
