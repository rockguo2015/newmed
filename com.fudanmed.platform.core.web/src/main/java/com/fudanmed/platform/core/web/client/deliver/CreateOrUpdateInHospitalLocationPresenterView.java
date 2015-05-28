package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateInHospitalLocationView;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalLocation;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.FormViewer;

@ImplementedBy(value = CreateOrUpdateInHospitalLocationView.class)
public interface CreateOrUpdateInHospitalLocationPresenterView extends FormViewer<UIInHospitalLocation> {
}
