package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMDefaultIntervalAssociationView;
import com.fudanmed.platform.core.web.shared.device.UIPMDefaultIntervalAssociation;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.FormViewer;

@ImplementedBy(value = CreateOrUpdatePMDefaultIntervalAssociationView.class)
public interface CreateOrUpdatePMDefaultIntervalAssociationPresenterView extends FormViewer<UIPMDefaultIntervalAssociation> {
}
